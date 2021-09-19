package fr.titi.infinity.init;

import fr.titi.infinity.INFINITY;
import fr.titi.infinity.utils.ModConfiguredFeature;
import fr.titi.infinity.utils.SurfacesBuilderInit;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, INFINITY.MODID);

    public static final RegistryObject<Biome> STAR_BIOME = BIOMES.register("star_biome", ()-> makeStarBiome(0.2F, 0.2F, 0.3F));

    public static Biome makeStarBiome(float depth, float scale, float temperature) {
        MobSpawnInfo.Builder mobspawninfo$builder = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.farmAnimals(mobspawninfo$builder);
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITHER_SKELETON, 8, 4, 4));
        mobspawninfo$builder.addSpawn(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 8, 4, 4));

        BiomeGenerationSettings.Builder biomegenerationsettings$builder = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfacesBuilderInit.STAR_CONFIG_BIOME);
        DefaultBiomeFeatures.addDefaultCarvers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addOceanCarvers(biomegenerationsettings$builder);
        DefaultBiomeFeatures.addDefaultGrass(biomegenerationsettings$builder);
        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeature.ORE_STAR);
        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ModConfiguredFeature.ORE_DIAMOND);
        biomegenerationsettings$builder.addFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);
        biomegenerationsettings$builder.addCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CANYON);
        biomegenerationsettings$builder.addStructureStart(StructureFeatures.MINESHAFT);


        return (new Biome.Builder()).precipitation(Biome.RainType.RAIN).biomeCategory(Biome.Category.DESERT).depth(depth).scale(scale).temperature(temperature).downfall(0.8F).specialEffects((new BiomeAmbience.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(12638463).skyColor(getSkyColorWithTemperatureModifier(temperature)).ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(mobspawninfo$builder.build()).generationSettings(biomegenerationsettings$builder.build()).build();
    }
    private static int getSkyColorWithTemperatureModifier(float temperature) {
        float lvt_1_1_ = temperature / 3.0F;
        lvt_1_1_ = MathHelper.clamp(lvt_1_1_, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - lvt_1_1_ * 0.05F, 0.5F + lvt_1_1_ * 0.1F, 1.0F);
    }



}
