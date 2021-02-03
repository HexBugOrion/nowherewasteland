package net.oriondev.nowhere.worldgen.biome.surfacebuilders;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.oriondev.nowhere.registries.BlockRegistry;

public abstract class SurfaceBuilder2 extends SurfaceBuilder {

    private static final BlockState DUST;
    private static final BlockState PACKED_DUST;
    public static final TernarySurfaceConfig DUST_CONFIG;
    public static final SurfaceBuilder<TernarySurfaceConfig> DUSTY_DUNES;

    private static <C extends SurfaceConfig, F extends SurfaceBuilder<C>> F register(String id, F surfaceBuilder) {
        return (F) Registry.register(Registry.SURFACE_BUILDER, id, surfaceBuilder);
    }

    static {
        DUST = BlockRegistry.DUST.getDefaultState();
        PACKED_DUST = BlockRegistry.PACKED_DUST.getDefaultState();
        DUST_CONFIG = new TernarySurfaceConfig(DUST,PACKED_DUST,DUST);
        DUSTY_DUNES = register("dusty_dunes", new DustyDunesSurface(TernarySurfaceConfig.CODEC));
    }

    public SurfaceBuilder2(Codec codec) {
        super(codec);
    }
}
