package net.vdragondev.nowhere.registries.configured;


import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.vdragondev.nowhere.registries.BlockRegistry;
import net.vdragondev.nowhere.worldgen.NowhereTreeConfig;
import net.vdragondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.vdragondev.nowhere.worldgen.biome.NowhereFeatures;

public class NowhereConfiguredFeatures {



    public static final ConfiguredFeature<DefaultFeatureConfig, ?> DRIED_TREE_FEATURE = WorldGenRegistryHelper
        .createConfiguredFeature("dried_tree_feature", NowhereFeatures.DRIED_TREE.configure(
            (DefaultFeatureConfig) new NowhereTreeConfig.Builder().setLeavesBlock(
                Blocks.AIR).setTrunkBlock(BlockRegistry.DRIED_LOG).setMaxHeight(15).setMinHeight(11).build()));


    public static class FeatureConfigs {



    }
}
