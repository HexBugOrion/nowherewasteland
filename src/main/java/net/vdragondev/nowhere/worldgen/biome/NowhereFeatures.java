package net.vdragondev.nowhere.worldgen.biome;

import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.vdragondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.vdragondev.nowhere.worldgen.features.trees.SmallTreeThing;

public class NowhereFeatures {

    public static final Feature<DefaultFeatureConfig> DRIED_TREE = WorldGenRegistryHelper.createFeature("dried_tree", new SmallTreeThing(DefaultFeatureConfig.CODEC.stable()));


    public static class Configurations{

    }

}
