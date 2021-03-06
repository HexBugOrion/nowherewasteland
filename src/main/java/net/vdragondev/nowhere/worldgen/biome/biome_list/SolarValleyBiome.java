package net.vdragondev.nowhere.worldgen.biome.biome_list;

import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.collection.WeightedList;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.vdragondev.nowhere.registries.NowhereFeaturesRegistry;
import net.vdragondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.vdragondev.nowhere.worldgen.biome.NowhereBiome;
import net.vdragondev.nowhere.worldgen.biome.NowhereSurfaceBuilders;

public class SolarValleyBiome extends NowhereBiome {
    static final ConfiguredSurfaceBuilder<?>
        SURFACE_BUILDER = WorldGenRegistryHelper.createConfiguredSurfaceBuilder("scorched_peaks", new ConfiguredSurfaceBuilder<>(
        NowhereSurfaceBuilders.SOLAR_VALLEY, SurfaceBuilder.GRASS_CONFIG));
    static final Biome.Precipitation PRECIPATATION = Biome.Precipitation.NONE;
    static final Biome.Category CATEGORY = Biome.Category.DESERT;
    static final float DEPTH = 0.3F;
    static final float SCALE = 0.0F;
    static final float TEMPERATURE = 1.2F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final int SKY_COLOR = 16745538;

    static final Biome.Weather WEATHER = new Biome.Weather(PRECIPATATION, TEMPERATURE, Biome.TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER);

    public SolarValleyBiome() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(16769730).skyColor(SKY_COLOR).moodSound(
            BiomeMoodSound.CAVE).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
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

        GENERATION_SETTINGS.feature(GenerationStep.Feature.VEGETAL_DECORATION, NowhereFeaturesRegistry.SCRAP);

    }
}
