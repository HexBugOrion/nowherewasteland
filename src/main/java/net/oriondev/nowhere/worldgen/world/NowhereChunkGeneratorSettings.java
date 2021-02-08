package net.oriondev.nowhere.worldgen.world;

import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.RegistryElementCodec;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.chunk.*;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class NowhereChunkGeneratorSettings {
    /*public static final Codec<NowhereChunkGeneratorSettings> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(StructuresConfig.CODEC.fieldOf("structures").forGetter(
            NowhereChunkGeneratorSettings::getStructuresConfig), GenerationShapeConfig.CODEC.fieldOf("noise").forGetter(
            NowhereChunkGeneratorSettings::getGenerationShapeConfig), BlockState.CODEC.fieldOf("default_block").forGetter(
            NowhereChunkGeneratorSettings::getDefaultBlock), BlockState.CODEC.fieldOf("default_fluid").forGetter(
            NowhereChunkGeneratorSettings::getDefaultFluid), Codec.intRange(-20, 276).fieldOf("bedrock_roof_position").forGetter(
            NowhereChunkGeneratorSettings::getBedrockCeilingY), Codec.intRange(-20, 276).fieldOf("bedrock_floor_position").forGetter(
            NowhereChunkGeneratorSettings::getBedrockFloorY), Codec.intRange(0, 255).fieldOf("sea_level").forGetter(
            NowhereChunkGeneratorSettings::getSeaLevel), Codec.BOOL.fieldOf("disable_mob_generation").forGetter(
            NowhereChunkGeneratorSettings::isMobGenerationDisabled)).apply(instance, NowhereChunkGeneratorSettings::new);
    });
    public static final Codec<Supplier<NowhereChunkGeneratorSettings>> REGISTRY_CODEC;
    private final StructuresConfig structuresConfig;
    private final GenerationShapeConfig generationShapeConfig;
    private final BlockState defaultBlock;
    private final BlockState defaultFluid;
    private final int bedrockCeilingY;
    private final int bedrockFloorY;
    private final int seaLevel;
    private final boolean mobGenerationDisabled;
    public static final RegistryKey<NowhereChunkGeneratorSettings> NOWHERE;
    private static final NowhereChunkGeneratorSettings INSTANCE;

    private NowhereChunkGeneratorSettings(StructuresConfig structuresConfig, GenerationShapeConfig generationShapeConfig, BlockState defaultBlock, BlockState defaultFluid, int bedrockCeilingY, int bedrockFloorY, int seaLevel, boolean mobGenerationDisabled) {
        this.structuresConfig = structuresConfig;
        this.generationShapeConfig = generationShapeConfig;
        this.defaultBlock = defaultBlock;
        this.defaultFluid = defaultFluid;
        this.bedrockCeilingY = bedrockCeilingY;
        this.bedrockFloorY = bedrockFloorY;
        this.seaLevel = seaLevel;
        this.mobGenerationDisabled = mobGenerationDisabled;
    }

    public StructuresConfig getStructuresConfig() {
        return this.structuresConfig;
    }

    public GenerationShapeConfig getGenerationShapeConfig() {
        return this.generationShapeConfig;
    }

    public BlockState getDefaultBlock() {
        return this.defaultBlock;
    }

    public BlockState getDefaultFluid() {
        return this.defaultFluid;
    }

    public int getBedrockCeilingY() {
        return this.bedrockCeilingY;
    }

    public int getBedrockFloorY() {
        return this.bedrockFloorY;
    }

    public int getSeaLevel() {
        return this.seaLevel;
    }

    @Deprecated
    protected boolean isMobGenerationDisabled() {
        return this.mobGenerationDisabled;
    }

    public boolean equals(RegistryKey<NowhereChunkGeneratorSettings> registryKey) {
        return Objects.equals(this, BuiltinRegistries.CHUNK_GENERATOR_SETTINGS.get(registryKey));
    }

    private static NowhereChunkGeneratorSettings register(RegistryKey<NowhereChunkGeneratorSettings> registryKey, NowhereChunkGeneratorSettings settings) {
        BuiltinRegistries.add(BuiltinRegistries.CHUNK_GENERATOR_SETTINGS, registryKey.getValue(), settings);
        return settings;
    }

    public static NowhereChunkGeneratorSettings getInstance() {
        return INSTANCE;
    }

    private static NowhereChunkGeneratorSettings createIslandSettings(StructuresConfig structuresConfig, BlockState defaultBlock, BlockState defaultFluid, Identifier id, boolean mobGenerationDisabled, boolean islandNoiseOverride) {
        return new NowhereChunkGeneratorSettings(structuresConfig, new GenerationShapeConfig(128, new NoiseSamplingConfig(2.0D, 1.0D, 80.0D, 160.0D), new SlideConfig(-3000, 64, -46), new SlideConfig(-30, 7, 1), 2, 1, 0.0D, 0.0D, true, false, islandNoiseOverride, false), defaultBlock, defaultFluid, -10, -10, 0, mobGenerationDisabled);
    }

    private static NowhereChunkGeneratorSettings createUndergroundSettings(StructuresConfig structuresConfig, BlockState defaultBlock, BlockState defaultFluid, Identifier id) {
        Map<StructureFeature<?>, StructureConfig> map = Maps.newHashMap(StructuresConfig.DEFAULT_STRUCTURES);
        map.put(StructureFeature.RUINED_PORTAL, new StructureConfig(25, 10, 34222645));
        return new NowhereChunkGeneratorSettings(new StructuresConfig(Optional.ofNullable(structuresConfig.getStronghold()), map), new GenerationShapeConfig(128, new NoiseSamplingConfig(1.0D, 3.0D, 80.0D, 60.0D), new SlideConfig(120, 3, 0), new SlideConfig(320, 4, -1), 1, 2, 0.0D, 0.019921875D, false, false, false, false), defaultBlock, defaultFluid, 0, 0, 32, false);
    }

    private static NowhereChunkGeneratorSettings createSurfaceSettings(StructuresConfig structuresConfig, boolean amplified, Identifier id) {
        double d = 0.9999999814507745D;
        return new NowhereChunkGeneratorSettings(structuresConfig, new GenerationShapeConfig(256, new NoiseSamplingConfig(0.9999999814507745D, 0.9999999814507745D, 80.0D, 160.0D), new SlideConfig(-10, 3, 0), new SlideConfig(-30, 0, 0), 1, 2, 1.0D, -0.46875D, true, true, false, amplified), Blocks.STONE.getDefaultState(), Blocks.WATER.getDefaultState(), -10, 0, 63, false);
    }

    static {
        REGISTRY_CODEC = RegistryElementCodec.of(Registry.NOISE_SETTINGS_WORLDGEN, CODEC);
        NOWHERE = RegistryKey.of(Registry.NOISE_SETTINGS_WORLDGEN, new Identifier("nowhere"));;
        INSTANCE = register(NOWHERE, createSurfaceSettings(new StructuresConfig(true), false, NOWHERE.getValue()));
    } */
}
