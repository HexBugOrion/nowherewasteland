package net.oriondev.nowhere.registries;

import net.oriondev.nowhere.worldgen.NowhereAbstractTreeFeature;
import net.oriondev.nowhere.worldgen.NowhereTreeConfig;
import net.oriondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.oriondev.nowhere.worldgen.features.trees.DriedTree;

public class FeatureRegistry {

    public static final NowhereAbstractTreeFeature<NowhereTreeConfig> DRIED_TREE = WorldGenRegistryHelper.createFeature("dried_tree", new DriedTree(
        NowhereTreeConfig.CODEC));

    public static void init() {
    }
}
