package net.oriondev.nowhere.worldgen;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.oriondev.nowhere.Nowhere;
import net.oriondev.nowhere.registries.BiomeRegistry;

import java.util.HashSet;
import java.util.Set;

public class WorldGenRegistryHelper {

    public static <SBC extends SurfaceConfig, SB extends SurfaceBuilder<SBC>> SB createSurfaceBuilder(String id, SB surfaceBuilder) {
        Identifier nowhereID = new Identifier(Nowhere.MOD_ID, id);
        if (Registry.SURFACE_BUILDER.getIds().contains(nowhereID))

        Registry.register(Registry.SURFACE_BUILDER, nowhereID, surfaceBuilder);
        return surfaceBuilder;
    }

    public static <SC extends SurfaceConfig, CSB extends ConfiguredSurfaceBuilder<SC>> CSB createConfiguredSurfaceBuilder(String id, CSB configuredSurfaceBuilder) {
        Identifier nowhereID = new Identifier(Nowhere.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_SURFACE_BUILDER.getIds().contains(nowhereID))

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, nowhereID, configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <C extends FeatureConfig, F extends Feature<C>> F createFeature(String id, F feature) {
        Identifier nowhereID = new Identifier(Nowhere.MOD_ID, id);
        if (Registry.FEATURE.getIds().contains(nowhereID))

        Registry.register(Registry.FEATURE, nowhereID, feature);
        return feature;
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        Identifier nowhereID = new Identifier(Nowhere.MOD_ID, id);
        if (BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(nowhereID))

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, nowhereID, configuredFeature);
        return configuredFeature;
    }

    public static <DC extends DecoratorConfig, D extends Decorator<DC>> D createDecorator(String id, D decorator) {
        Identifier nowhereID = new Identifier(Nowhere.MOD_ID, id);
        if (Registry.DECORATOR.getIds().contains(nowhereID))

        Registry.register(Registry.DECORATOR, nowhereID, decorator);
        return decorator;
    }

    static Set<Integer> integerList = new HashSet<>();

    public static Biome createBiome(String id, Biome biome, int numericalID) {
        Identifier nowhereID = new Identifier(Nowhere.MOD_ID, id);
        if (BuiltinRegistries.BIOME.getIds().contains(nowhereID))

        if (integerList.contains(numericalID))

        BiomeRegistry.biomeList.add(new BiomeRegistry.PreserveBiomeOrder(biome, numericalID, id));
        integerList.add(numericalID);
        return biome;
    }
}
