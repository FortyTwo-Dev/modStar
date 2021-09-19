package fr.titi.infinity.init;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.entity.MeteoriteEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITIES, INFINITY.MODID);

    public static final RegistryObject<EntityType<MeteoriteEntity>> METEORITE_ENTITY = ENTITY_TYPE.register("meteorite_entity", ()->
            EntityType.Builder.of(MeteoriteEntity::new, EntityClassification.MONSTER).sized(1.0f, 1.0f).build(new ResourceLocation(INFINITY.MODID, "meteorite_entity").toString()));

}
