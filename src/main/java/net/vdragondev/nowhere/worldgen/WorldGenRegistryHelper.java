package net.vdragondev.nowhere.worldgen;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.vdragondev.nowhere.Nowhere;

public class WorldGenRegistryHelper {

    public static <SBC extends SurfaceConfig, SB extends SurfaceBuilder<SBC>> SB createSurfaceBuilder(String id, SB surfaceBuilder) {
        Registry.register(Registry.SURFACE_BUILDER, new Identifier(Nowhere.MOD_ID, id), surfaceBuilder);
        return surfaceBuilder;
    }

    public static <SC extends SurfaceConfig, CSB extends ConfiguredSurfaceBuilder<SC>> CSB createConfiguredSurfaceBuilder(String id, CSB configuredSurfaceBuilder) {
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(Nowhere.MOD_ID, id), configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <C extends FeatureConfig, F extends Feature<C>> F createFeature(String id, F feature) {
        Registry.register(Registry.FEATURE, new Identifier(Nowhere.MOD_ID, id), feature);
        return feature;
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Nowhere.MOD_ID, id), configuredFeature);
        return configuredFeature;
    }

    public static <DC extends DecoratorConfig, D extends Decorator<DC>> D createDecorator(String id, D decorator) {
        Registry.register(Registry.DECORATOR, new Identifier(Nowhere.MOD_ID, id), decorator);
        return decorator;
    }
}
