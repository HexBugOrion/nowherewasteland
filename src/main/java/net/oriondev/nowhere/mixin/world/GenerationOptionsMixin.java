package net.oriondev.nowhere.mixin.world;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GeneratorOptions;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.oriondev.nowhere.worldgen.generators.NowhereGeneratorOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GeneratorOptions.class)
public class GenerationOptionsMixin {

    /**
     * @author OrionHexDev
     */
    @Overwrite
    public static NoiseChunkGenerator createOverworldGenerator(Registry<Biome> biomeRegistry, Registry<NowhereGeneratorOptions> chunkGeneratorSettingsRegistry, long seed) {
        return new NowhereGeneratorOptions();
    }
}
