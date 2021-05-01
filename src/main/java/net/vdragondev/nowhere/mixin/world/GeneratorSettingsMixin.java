package net.vdragondev.nowhere.mixin.world;


import net.minecraft.client.world.GeneratorType;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(ChunkGeneratorSettings.class)
public interface GeneratorSettingsMixin {
}
