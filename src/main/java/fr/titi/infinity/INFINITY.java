package fr.titi.infinity;

import fr.titi.infinity.entity.MeteoriteEntity;
import fr.titi.infinity.entity.MeteoriteEntityRenderer;
import fr.titi.infinity.event.StarArmorEvent;
import fr.titi.infinity.init.*;
import fr.titi.infinity.network.FlyArmorN;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;

@Mod(INFINITY.MODID)
public class INFINITY {

    public static final String MODID ="infinity";

    public static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel NETWORK = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, "channel"),
            ()-> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);


    public INFINITY() {


        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntityTypes.ENTITY_TYPE.register(bus);
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModBiomes.BIOMES.register(bus);
        MinecraftForge.EVENT_BUS.register(new StarArmorEvent());


        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(INFINITY.MODID, "star_biome")), 5));

    }

    private void setup(final FMLCommonSetupEvent e) {
        MinecraftForge.EVENT_BUS.register(this);
        DeferredWorkQueue.runLater(()->{
            GlobalEntityTypeAttributes.put(ModEntityTypes.METEORITE_ENTITY.get(), MeteoriteEntity.setAttributes().build());
        });
        int intex = 0;
        NETWORK.registerMessage(intex, FlyArmorN.class, FlyArmorN::encode, FlyArmorN::decode, FlyArmorN::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));

    }

    private void clientSetup(FMLClientSetupEvent e) {
        IEventBus bus = MinecraftForge.EVENT_BUS;
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.METEORITE_ENTITY.get(), MeteoriteEntityRenderer::new);

        ModKeybindings.register();
        bus.addListener(ModKeybindings::onKeyPress);


    }


}