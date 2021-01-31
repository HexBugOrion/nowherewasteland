package net.oriondev.nowhere.registries;

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltinBiomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.oriondev.nowhere.worldgen.BiomeData;
import net.oriondev.nowhere.worldgen.NowhereBiome;
import net.oriondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.oriondev.nowhere.worldgen.biome.biome_list.DummySubBiome;
import net.oriondev.nowhere.worldgen.biome.biome_list.DunesBiome;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BiomeRegistry {

    public static List<PreserveBiomeOrder> biomeList = new ArrayList<>();

    //get biomed, dummy
    public static Biome DUMMY_BIOME = WorldGenRegistryHelper.createBiome("dummy", new DummySubBiome().getBiome(), 2000);
    //actual biomes
    public static Biome NOWHERE_DUNES = WorldGenRegistryHelper.createBiome("nowheredunes", new DunesBiome().getBiome(), 2);




    public static void init() {
    }

    public static void addBiomeEntries() {
        for (BiomeData biomeData : NowhereBiome.biomeData) {
            if (biomeData.getBiomeWeight() > 0) {
                OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, BuiltinRegistries.BIOME.getId(biomeData.getBiome())), biomeData.getBiomeType(), biomeData.getBiomeWeight() / 10.0);

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

    public static void addBiomeNumericalIDs() {
        for (PreserveBiomeOrder biome : biomeList) {
            Optional<RegistryKey<Biome>> key = BuiltinRegistries.BIOME.getKey(biome.getBiome());
            if (key.isPresent())
                key.ifPresent(biomeRegistryKey -> BuiltinBiomes.BY_RAW_ID.put(BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.getOrThrow(key.get())), biomeRegistryKey));
        }

    }

    public static class PreserveBiomeOrder {
        private final Biome biome;
        private final int orderPosition;
        private final String id;

        public PreserveBiomeOrder(Biome biome, int orderPosition, String id) {
            this.biome = biome;
            this.orderPosition = orderPosition;
            this.id = id;
        }

        public Biome getBiome() {
            return biome;
        }

        public int getOrderPosition() {
            return orderPosition;
        }

        public String getId() {
            return id;
        }
    }
}
