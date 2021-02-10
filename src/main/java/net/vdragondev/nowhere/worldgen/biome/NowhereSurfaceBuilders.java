package net.vdragondev.nowhere.worldgen.biome;

import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.vdragondev.nowhere.registries.BlockRegistry;
import net.vdragondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.vdragondev.nowhere.worldgen.biome.surfaces.SolarValleySB;

import java.util.ArrayList;
import java.util.List;

public class NowhereSurfaceBuilders {
    public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static final SurfaceBuilder<TernarySurfaceConfig> SOLAR_VALLEY = WorldGenRegistryHelper.createSurfaceBuilder("solar_valley", new SolarValleySB(TernarySurfaceConfig.CODEC));

        public static class Configs{
            public static final TernarySurfaceConfig SOLAR_VALLEY_CF = new TernarySurfaceConfig(
                BlockRegistry.CRACKED_SOIL.getDefaultState(), BlockRegistry.CRACKED_SOIL.getDefaultState(), BlockRegistry.CRACKED_SOIL.getDefaultState());
            public static final TernarySurfaceConfig SOLAR_VALLEY_CF2 = new TernarySurfaceConfig(BlockRegistry.SALT_BLOCK.getDefaultState(), BlockRegistry.CRACKED_SOIL.getDefaultState(), BlockRegistry.CRACKED_SOIL.getDefaultState());

        }

}
