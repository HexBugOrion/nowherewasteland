package net.vdragondev.nowhere.worldgen;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.vdragondev.nowhere.registries.configured.NowhereConfiguredFeatures;

public class NowhereDefaultFeatures {

    public static void addDriedTrees(GenerationSettings.Builder gen){

        gen.feature(GenerationStep.Feature.VEGETAL_DECORATION, NowhereConfiguredFeatures.DRIED_TREE_FEATURE);

    }
}
