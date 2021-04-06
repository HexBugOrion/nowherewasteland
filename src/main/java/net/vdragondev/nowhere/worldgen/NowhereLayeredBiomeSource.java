package net.vdragondev.nowhere.worldgen;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.BuiltinBiomes;
import net.minecraft.world.biome.layer.BiomeLayers;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.VanillaLayeredBiomeSource;
import net.vdragondev.nowhere.Nowhere;
import net.vdragondev.nowhere.registries.BiomeRegistry;

import java.util.List;

public class NowhereLayeredBiomeSource extends BiomeSource {
    public static final Codec<NowhereLayeredBiomeSource> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(Codec.LONG.fieldOf("seed").stable().forGetter((nowhereLayeredBiomeSource) -> {
            return nowhereLayeredBiomeSource.seed;
        }), Codec.BOOL.optionalFieldOf("legacy_biome_init_layer", false, Lifecycle.stable()).forGetter((nowhereLayeredBiomeSource) -> {
            return nowhereLayeredBiomeSource.legacyBiomeInitLayer;
        }), Codec.BOOL.fieldOf("large_biomes").orElse(false).stable().forGetter((nowhereLayeredBiomeSource) -> {
            return nowhereLayeredBiomeSource.largeBiomes;
        }), RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((nowhereLayeredBiomeSource) -> {
            return nowhereLayeredBiomeSource.biomeRegistry;
        })).apply(instance, instance.stable(NowhereLayeredBiomeSource::new));
    });
    private final BiomeLayerSampler biomeSampler;
    private static final List<RegistryKey<Biome>> BIOMES;
    private final long seed;
    private final boolean legacyBiomeInitLayer;
    private final boolean largeBiomes;
    private final Registry<Biome> biomeRegistry;

    public NowhereLayeredBiomeSource(long seed, boolean legacyBiomeInitLayer, boolean largeBiomes, Registry<Biome> biomeRegistry) {
        super(BIOMES.stream().map((registryKey) -> {
            return () -> {
                return (Biome)biomeRegistry.getOrThrow(registryKey);
            };
        }));
        this.seed = seed;
        this.legacyBiomeInitLayer = legacyBiomeInitLayer;
        this.largeBiomes = largeBiomes;
        this.biomeRegistry = biomeRegistry;
        this.biomeSampler = BiomeLayers.build(seed, legacyBiomeInitLayer, largeBiomes ? 6 : 4, 4);
    }

    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Environment(EnvType.CLIENT)
    public BiomeSource withSeed(long seed) {
        return new NowhereLayeredBiomeSource(seed, this.legacyBiomeInitLayer, this.largeBiomes, this.biomeRegistry);
    }

    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        return this.biomeSampler.sample(this.biomeRegistry, biomeX, biomeZ);
    }

    static {
        BIOMES = ImmutableList
            .of(BiomeKeys.OCEAN, BiomeKeys.PLAINS, BiomeKeys.DESERT, BiomeKeys.MOUNTAINS, BiomeKeys.FOREST, BiomeKeys.TAIGA, BiomeKeys.SWAMP, BiomeKeys.RIVER, BiomeKeys.FROZEN_OCEAN, BiomeKeys.FROZEN_RIVER, BiomeKeys.SNOWY_TUNDRA, BiomeKeys.SNOWY_MOUNTAINS, new RegistryKey[]{
                BiomeRegistry.DUNES_KEY});
    }
}
