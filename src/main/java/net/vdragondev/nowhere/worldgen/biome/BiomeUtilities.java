package net.vdragondev.nowhere.worldgen.biome;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class BiomeUtilities {

    public static boolean isOcean(Biome biome) {
        return biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.WARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.LUKEWARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.COLD_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.FROZEN_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_WARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_LUKEWARM_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_COLD_OCEAN) || biome == BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.DEEP_FROZEN_OCEAN);
    }
}
