package net.oriondev.nowhere.worldgen.biome.biome_list;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.oriondev.nowhere.registries.BiomeRegistry;
import net.oriondev.nowhere.worldgen.biome.surfacebuilders.SurfaceBuilder2;

public class DunesBiome {

    public static Biome create(){
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder().surfaceBuilder(new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder2.DUST_CONFIG));



        return new Biome.Builder()
            .precipitation(Biome.Precipitation.RAIN)
            .category(Biome.Category.RIVER)
            .depth(-0.5F)
            .scale(0.0F)
            .temperature(0.5F)
            .downfall(0.5F)
            .effects(new BiomeEffects.Builder()
                .waterColor(4159204)
                .waterFogColor(329011)
                .fogColor(12638463)
                .skyColor(BiomeRegistry.getSkyColor(0.5F))
                .moodSound(BiomeMoodSound.CAVE).build())
            .spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }

}
