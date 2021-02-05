package net.oriondev.nowhere.registries;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltinBiomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.oriondev.nowhere.Nowhere;
import net.oriondev.nowhere.worldgen.biome.BiomeData;
import net.oriondev.nowhere.worldgen.biome.NowhereBiome;
import net.oriondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.oriondev.nowhere.worldgen.biome.biome_list.DummySubBiome;
import net.oriondev.nowhere.worldgen.biome.biome_list.DunesBiome;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BiomeRegistry {

    //get biomed, dummy
    public static Biome DUMMY_BIOME = Registry.register(BuiltinRegistries.BIOME, new Identifier(Nowhere.MOD_ID, "dummy"), new DummySubBiome().getBiome());
    //actual biomes
    public static Biome NOWHERE_DUNES = Registry.register(BuiltinRegistries.BIOME, new Identifier(Nowhere.MOD_ID, "nowheredunes"), new DunesBiome().getBiome());


    public static void init() {
    }

   public static void addBiomeEntries() {
        for (BiomeData biomeData : NowhereBiome.biomeData) {
            if (biomeData.getBiomeWeight() > 1) {
                OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, BuiltinRegistries.BIOME.getId(biomeData.getBiome())), biomeData.getBiomeType(), biomeData.getBiomeWeight() / 100.0);
            }
        }
    }

    public static void addFeatureToBiome(Biome biome, GenerationStep.Feature feature, ConfiguredFeature<?, ?> configuredFeature) {
        convertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = biome.getGenerationSettings().features;
        while (biomeFeatures.size() <= feature.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);
    }

    private static void convertImmutableFeatures(Biome biome) {
        biome.getGenerationSettings().features = biome.getGenerationSettings().features.stream().map(
            Lists::newArrayList).collect(Collectors.toList());
    }
}
