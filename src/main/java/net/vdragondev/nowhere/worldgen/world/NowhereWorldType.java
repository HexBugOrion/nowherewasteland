package net.vdragondev.nowhere.worldgen.world;

import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.vdragondev.nowhere.worldgen.NowhereLayeredBiomeSource;

import java.util.function.Supplier;

public abstract class NowhereWorldType extends GeneratorType {
    protected NowhereWorldType() {
        super("nowhere");
        GeneratorType.VALUES.add(this);
    }

    protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry,
        Supplier<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
        return new NoiseChunkGenerator(new NowhereLayeredBiomeSource(seed, false, false, biomeRegistry), seed, chunkGeneratorSettingsRegistry);
    }
}
