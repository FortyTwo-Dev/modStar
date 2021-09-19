package fr.titi.infinity.utils;

import fr.titi.infinity.INFINITY;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SurfacesBuilderInit {

    public static final SurfaceBuilderConfig STAR_CONFIG = new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.BLACKSTONE.defaultBlockState());

    public static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> STAR_CONFIG_BIOME = register("star_config_biome", SurfaceBuilder.DEFAULT.configured(STAR_CONFIG));

    private static <SC extends ISurfaceBuilderConfig> ConfiguredSurfaceBuilder<SC> register(String name, ConfiguredSurfaceBuilder<SC> configuredSurfaceBuilder) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(INFINITY.MODID, name), configuredSurfaceBuilder);
    }
}
