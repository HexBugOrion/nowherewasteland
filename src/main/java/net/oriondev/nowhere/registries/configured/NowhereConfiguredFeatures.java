package net.oriondev.nowhere.registries.configured;


import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.oriondev.nowhere.registries.BlockRegistry;
import net.oriondev.nowhere.worldgen.NowhereTreeConfig;
import net.oriondev.nowhere.worldgen.WorldGenRegistryHelper;
import net.oriondev.nowhere.worldgen.biome.NowhereFeatures;

public class NowhereConfiguredFeatures {
    public static final ConfiguredFeature<NowhereTreeConfig, ?> DRIED_TREE = WorldGenRegistryHelper.createConfiguredFeature("dried_tree", NowhereFeatures.DRIED_TREE.configure(
        new NowhereTreeConfig.Builder().setLeavesBlock(Blocks.AIR).setTrunkBlock(BlockRegistry.DRIED_LOG).setMaxHeight(15).setMinHeight(11).build()));


    public static class FeatureConfigs {



    }
}
