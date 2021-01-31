package net.oriondev.nowhere.worldgen.biome;

import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.oriondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.oriondev.nowhere.worldgen.features.trees.SmallTreeThing;

public class NowhereFeatures {
    public static final Feature<DefaultFeatureConfig> DUMMY_TREE = WorldGenRegistryHelper.createFeature("dummy_tree", new SmallTreeThing(DefaultFeatureConfig.CODEC.stable()));

    public static final ConfiguredFeature<?, ?> DUMMY_TREE_FEATURE = WorldGenRegistryHelper.createConfiguredFeature("dummy_tree", NowhereFeatures.DUMMY_TREE.configure(DecoratedFeatureConfig.DEFAULT).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(10000, 0.4F, 8))));

    public static class Configurations{

    }

}
