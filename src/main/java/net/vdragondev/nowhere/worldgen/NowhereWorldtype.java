package net.vdragondev.nowhere.worldgen;


import net.minecraft.client.world.GeneratorType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;

public class NowhereWorldtype extends GeneratorType {
    public NowhereWorldtype(String translationKey) {
        super("nowhere");
        GeneratorType.VALUES.add(this);
    }

    @Override protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry,
        Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
        return null;
    }
}
