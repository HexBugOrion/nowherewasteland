package net.vdragondev.nowhere.registries;

import net.vdragondev.nowhere.worldgen.NowhereAbstractTreeFeature;
import net.vdragondev.nowhere.worldgen.NowhereTreeConfig;
import net.vdragondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.vdragondev.nowhere.worldgen.features.trees.DriedTree;

public class FeatureRegistry {

    public static final NowhereAbstractTreeFeature<NowhereTreeConfig> DRIED_TREE1 = WorldGenRegistryHelper
        .createFeature("dried_tree1", new DriedTree(
            NowhereTreeConfig.CODEC));

    public static void init() {
    }
}
