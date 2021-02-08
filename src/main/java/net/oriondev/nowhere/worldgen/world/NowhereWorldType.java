package net.oriondev.nowhere.worldgen.world;

import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

public class NowhereWorldType extends GeneratorType {
    protected NowhereWorldType() {
        super("nowhere");
        GeneratorType.VALUES.add(this);
    }

    @Override protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry,
        Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
        return new NoiseChunkGenerator(new NowhereLayeredBiomeSource(biomeRegistry, seed), seed);;
    }
}
