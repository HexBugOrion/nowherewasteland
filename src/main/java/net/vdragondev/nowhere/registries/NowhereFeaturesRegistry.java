package net.vdragondev.nowhere.registries;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.source.VanillaLayeredBiomeSource;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;

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
    public static ConfiguredFeature<?,?> NECROTIC_TREE;
    public static ConfiguredFeature<?,?> NECROTIC_TREE_DEC;
    public static ConfiguredFeature<?,?> MONOLITH;
    public static ConfiguredFeature<?,?> MONOLITH_DEC;
    public static ConfiguredFeature<?,?> SCRAP;
    public static ConfiguredFeature<?,?> SCRAP2;
    public static ConfiguredFeature<?,?> DESERT_ROOTS;
    public static ConfiguredFeature<?,?> CARNA_ROOTS;

    public static void registerConfiguredFeatures() {

        DRIED_TREE = register("nowhere:dried_tree", Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.DRIED_LOG), new SimpleBlockStateProvider(States.AIR), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(1), 1), new ForkingTrunkPlacer(5, 1, 3), new TwoLayersFeatureSize(0, 0, 0))).heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));
        DRIED_TREE_DEC = register("nowhere:dried_tree_decor", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(DRIED_TREE.withChance(0.04F), DRIED_TREE.withChance(0.04F)), DRIED_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        CHARRED_TREE = register("nowhere:charred_tree", Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.CHARCOAL_LOG), new SimpleBlockStateProvider(States.AIR), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(1), 1), new ForkingTrunkPlacer(5, 1, 3), new TwoLayersFeatureSize(0, 0, 0))).heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));
        CHARRED_TREE_DEC = register("nowhere:charred_tree_decor", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(CHARRED_TREE.withChance(0.04F), CHARRED_TREE.withChance(0.04F)), CHARRED_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        NECROTIC_TREE = register("nowhere:necrotic_tree", Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.NECROTIC_LOG), new SimpleBlockStateProvider(States.AIR), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(1), 1), new ForkingTrunkPlacer(5, 1, 3), new TwoLayersFeatureSize(0, 0, 0))).heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));
        NECROTIC_TREE_DEC = register("nowhere:necrotic_tree_decor", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(NECROTIC_TREE.withChance(0.04F), NECROTIC_TREE.withChance(0.04F)), NECROTIC_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        MONOLITH = register("nowhere:monolith", Feature.TREE.configure((new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.MONOSTONE), new SimpleBlockStateProvider(States.AIR), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(1), 1), new GiantTrunkPlacer(20, 1, 3), new TwoLayersFeatureSize(0, 0, 0))).heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build()));
        MONOLITH_DEC = register("nowhere:monolith_decor", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(MONOLITH.withChance(0.04F), MONOLITH.withChance(0.04F)), MONOLITH)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.1F, 1))));
        SCRAP = register("nowhere:scrap", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(States.SCRAP_HEAP), SimpleBlockPlacer.INSTANCE)).tries(128).whitelist(ImmutableSet.of(States.CRACKED_SOIL.getBlock())).cannotProject().build()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).applyChance(0));
        SCRAP2 = register("nowhere:scrap_rare", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(States.SCRAP_HEAP), SimpleBlockPlacer.INSTANCE)).tries(64).whitelist(ImmutableSet.of(States.DUST.getBlock())).cannotProject().build()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).applyChance(8));
        DESERT_ROOTS = register("nowhere:roots", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(States.DESERT_ROOTS), SimpleBlockPlacer.INSTANCE)).tries(256).whitelist(ImmutableSet.of(States.DUST.getBlock())).cannotProject().build()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).applyChance(0));
        CARNA_ROOTS = register("nowhere:necroots", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(States.CARNA_ROOTS), SimpleBlockPlacer.INSTANCE)).tries(256).whitelist(ImmutableSet.of(States.NECROTIC_DUST.getBlock())).cannotProject().build()).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).applyChance(0));

    }

    public static final class States {

        protected static final BlockState DRIED_LOG = BlockRegistry.DRIED_LOG.getDefaultState();
        protected static final BlockState CHARCOAL_LOG = BlockRegistry.CHARCOAL_LOG.getDefaultState();
        protected static final BlockState NECROTIC_LOG = BlockRegistry.NECROTIC_LOG.getDefaultState();
        protected static final BlockState SCRAP_HEAP = BlockRegistry.SCRAP_HEAP.getDefaultState();
        protected static final BlockState CRACKED_SOIL = BlockRegistry.CRACKED_SOIL.getDefaultState();
        protected static final BlockState DUST = BlockRegistry.DUST.getDefaultState();
        protected static final BlockState NECROTIC_DUST = BlockRegistry.NECROTIC_DUST.getDefaultState();
        protected static final BlockState DESERT_ROOTS = BlockRegistry.DESERT_ROOTS.getDefaultState();
        protected static final BlockState CARNA_ROOTS = BlockRegistry.CARNA_ROOTS.getDefaultState();
        protected static final BlockState MONOSTONE = BlockRegistry.MONOSTONE.getDefaultState();
        protected static final BlockState AIR = Blocks.AIR.getDefaultState();

    }
}
