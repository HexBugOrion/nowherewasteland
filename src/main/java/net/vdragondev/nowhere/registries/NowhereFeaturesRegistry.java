package net.vdragondev.nowhere.registries;


import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class NowhereFeaturesRegistry {

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<?, ?> configuredFeature)
    {
        return (ConfiguredFeature) Registry
            .register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }

    public static ConfiguredFeature<?,?> DRIED_TREE;
    public static ConfiguredFeature<?,?> DRIED_TREE_DEC;
    public static ConfiguredFeature<?,?> CHARRED_TREE;
    public static ConfiguredFeature<?,?> CHARRED_TREE_DEC;

    public static void registerConfiguredFeatures() {

        DRIED_TREE = register("nowhere:dried_tree", Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.DRIED_LOG), new SimpleBlockStateProvider(States.AIR), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(1), 1), new ForkingTrunkPlacer(5, 1, 3), new TwoLayersFeatureSize(0, 0, 0))).heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));
        DRIED_TREE_DEC = register("nowhere:dried_tree_decor", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(DRIED_TREE.withChance(0.04F), DRIED_TREE.withChance(0.04F)), DRIED_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        CHARRED_TREE = register("nowhere:charred_tree", Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CHARCOAL_LOG), new SimpleBlockStateProvider(States.AIR), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(1), 1), new ForkingTrunkPlacer(5, 1, 3), new TwoLayersFeatureSize(0, 0, 0))).heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));
        CHARRED_TREE_DEC = register("nowhere:charred_tree_decor", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(DRIED_TREE.withChance(0.04F), DRIED_TREE.withChance(0.04F)), DRIED_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));

    }

    public static final class States {

        protected static final BlockState DRIED_LOG = BlockRegistry.DRIED_LOG.getDefaultState();
        protected static final BlockState CHARCOAL_LOG = BlockRegistry.CHARCOAL_LOG.getDefaultState();
        protected static final BlockState AIR = Blocks.AIR.getDefaultState();

    }
}
