package net.oriondev.nowhere.worldgen.biome.biome_list;


import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.oriondev.nowhere.registries.BlockRegistry;
import net.oriondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.oriondev.nowhere.worldgen.biome.NowhereBiome;

public class NecroticDunesBiome extends NowhereBiome {
    static final ConfiguredSurfaceBuilder<?> SURFACE_BUILDER = WorldGenRegistryHelper.createConfiguredSurfaceBuilder("necrotic_dunes", new ConfiguredSurfaceBuilder<>(
        SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(BlockRegistry.NECROTIC_DUST.getDefaultState(), BlockRegistry.NECROTIC_PACKED_DUST.getDefaultState(), BlockRegistry.NECROTIC_PACKED_DUST.getDefaultState())));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.NONE;
    static final Biome.Category CATEGORY = Biome.Category.DESERT;
    static final float DEPTH = 1.0F;
    static final float SCALE = 0.2F;
    static final float TEMPERATURE = 1.2F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int SKY_COLOR = 16748154;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public NecroticDunesBiome() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(16769730).skyColor(SKY_COLOR).moodSound(BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }



    @Override
    public WeightedList<Biome> getHills() {
        WeightedList<Biome> biomeWeightedList = new WeightedList<>();
        biomeWeightedList.add(BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.SAVANNA), 3);
        return biomeWeightedList;
    }

    @Override
    public int getWeight() {
        return 6;
    }

    @Override
    public OverworldClimate getBiomeType() {
        return OverworldClimate.DRY;
    }

    static {
    }
}
