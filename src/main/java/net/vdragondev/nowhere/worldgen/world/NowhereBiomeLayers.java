package net.vdragondev.nowhere.worldgen.world;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import net.minecraft.util.Util;
import net.minecraft.world.biome.layer.*;
import net.minecraft.world.biome.layer.type.ParentedLayer;
import net.minecraft.world.biome.layer.util.*;
import net.minecraft.world.biome.source.BiomeLayerSampler;

import java.util.function.LongFunction;

public class NowhereBiomeLayers {
    private static final Int2IntMap
        field_26709 = (Int2IntMap) Util.make(new Int2IntOpenHashMap(), (int2IntOpenHashMap) -> {
        layer(int2IntOpenHashMap, Category.NOWHERE, 16);
    });

    private static <T extends LayerSampler, C extends LayerSampleContext<T>> LayerFactory<T> stack(long seed, ParentedLayer layer, LayerFactory<T> parent, int count, LongFunction<C> contextProvider) {
        LayerFactory<T> layerFactory = parent;

        for(int i = 0; i < count; ++i) {
            layerFactory = layer.create((LayerSampleContext)contextProvider.apply(seed + (long)i), layerFactory);
        }

        return layerFactory;
    }

    private static <T extends LayerSampler, C extends LayerSampleContext<T>> LayerFactory<T> build(boolean old, int biomeSize, int riverSize, LongFunction<C> contextProvider) {
        LayerFactory<T> layerFactory = ContinentLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1L));
        layerFactory = ScaleLayer.FUZZY.create((LayerSampleContext)contextProvider.apply(2000L), layerFactory);
        layerFactory = IncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1L), layerFactory);
        layerFactory = ScaleLayer.NORMAL.create((LayerSampleContext)contextProvider.apply(2001L), layerFactory);
        layerFactory = IncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(2L), layerFactory);
        layerFactory = IncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(50L), layerFactory);
        layerFactory = IncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(70L), layerFactory);
        layerFactory = AddIslandLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(2L), layerFactory);
        LayerFactory<T> layerFactory2 = OceanTemperatureLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(2L));
        layerFactory2 = stack(2001L, ScaleLayer.NORMAL, layerFactory2, 6, contextProvider);
        layerFactory = AddColdClimatesLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(2L), layerFactory);
        layerFactory = IncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(3L), layerFactory);
        layerFactory = AddClimateLayers.AddTemperateBiomesLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(2L), layerFactory);
        layerFactory = AddClimateLayers.AddCoolBiomesLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(2L), layerFactory);
        layerFactory = AddClimateLayers.AddSpecialBiomesLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(3L), layerFactory);
        layerFactory = ScaleLayer.NORMAL.create((LayerSampleContext)contextProvider.apply(2002L), layerFactory);
        layerFactory = ScaleLayer.NORMAL.create((LayerSampleContext)contextProvider.apply(2003L), layerFactory);
        layerFactory = IncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(4L), layerFactory);
        layerFactory = AddMushroomIslandLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(5L), layerFactory);
        layerFactory = AddDeepOceanLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(4L), layerFactory);
        layerFactory = stack(1000L, ScaleLayer.NORMAL, layerFactory, 0, contextProvider);
        LayerFactory<T> layerFactory3 = stack(1000L, ScaleLayer.NORMAL, layerFactory, 0, contextProvider);
        layerFactory3 = SimpleLandNoiseLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(100L), layerFactory3);
        LayerFactory<T> layerFactory4 = (new SetBaseBiomesLayer(old)).create((LayerSampleContext)contextProvider.apply(200L), layerFactory);
        layerFactory4 = AddBambooJungleLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1001L), layerFactory4);
        layerFactory4 = stack(1000L, ScaleLayer.NORMAL, layerFactory4, 2, contextProvider);
        layerFactory4 = EaseBiomeEdgeLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1000L), layerFactory4);
        LayerFactory<T> layerFactory5 = stack(1000L, ScaleLayer.NORMAL, layerFactory3, 2, contextProvider);
        layerFactory4 = AddHillsLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1000L), layerFactory4, layerFactory5);
        layerFactory3 = stack(1000L, ScaleLayer.NORMAL, layerFactory3, 2, contextProvider);
        layerFactory3 = stack(1000L, ScaleLayer.NORMAL, layerFactory3, riverSize, contextProvider);
        layerFactory3 = NoiseToRiverLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1L), layerFactory3);
        layerFactory3 = SmoothLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1000L), layerFactory3);
        layerFactory4 = AddSunflowerPlainsLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1001L), layerFactory4);

        for(int i = 0; i < biomeSize; ++i) {
            layerFactory4 = ScaleLayer.NORMAL.create((LayerSampleContext)contextProvider.apply((long)(1000 + i)), layerFactory4);
            if (i == 0) {
                layerFactory4 = IncreaseEdgeCurvatureLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(3L), layerFactory4);
            }

            if (i == 1 || biomeSize == 1) {
                layerFactory4 = AddEdgeBiomesLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1000L), layerFactory4);
            }
        }

        layerFactory4 = SmoothLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(1000L), layerFactory4);
        layerFactory4 = AddRiversLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(100L), layerFactory4, layerFactory3);
        layerFactory4 = ApplyOceanTemperatureLayer.INSTANCE.create((LayerSampleContext)contextProvider.apply(100L), layerFactory4, layerFactory2);
        return layerFactory4;
    }

    public static BiomeLayerSampler build(long seed, boolean old, int biomeSize, int riverSize) {
        boolean i = true;
        LayerFactory<CachingLayerSampler> layerFactory = build(old, biomeSize, riverSize, (salt) -> {
            return new CachingLayerContext(25, seed, salt);
        });
        return new BiomeLayerSampler(layerFactory);
    }

    public static boolean areSimilar(int id1, int id2) {
        if (id1 == id2) {
            return true;
        } else {
            return field_26709.get(id1) == field_26709.get(id2);
        }
    }

    private static void layer(Int2IntOpenHashMap int2IntOpenHashMap, NowhereBiomeLayers.Category category, int i) {
        int2IntOpenHashMap.put(i, category.ordinal());
    }

    protected static boolean isOcean(int id) {
        return id == 44 || id == 45 || id == 0 || id == 46 || id == 10 || id == 47 || id == 48 || id == 24 || id == 49 || id == 50;
    }

    protected static boolean isShallowOcean(int id) {
        return id == 44 || id == 45 || id == 0 || id == 46 || id == 10;
    }

    static enum Category {
        NONE,
        NOWHERE;
        private Category() {
        }
    }
}
