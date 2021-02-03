package net.oriondev.nowhere.registries;

import com.google.common.base.Optional;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.oriondev.nowhere.Nowhere;
import net.oriondev.nowhere.worldgen.biome.biome_list.DunesBiome;

import java.util.Objects;

public class BiomeRegistry {
    public static int getSkyColor(float temperature) {
        float f = temperature / 3.0F;
        f = MathHelper.clamp(f, -1.0F, 1.0F);
        return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    public static RegistryKey<Biome> DUNES;

    public static void init(){
        Biome dunes = Registry.register(BuiltinRegistries.BIOME, new Identifier(Nowhere.MOD_ID, "dunes"), DunesBiome.create());
        DUNES = BuiltinRegistries.BIOME.getKey(dunes).get();
        OverworldBiomes.addHillsBiome(BiomeKeys.DESERT, DUNES, 100);
        OverworldBiomes.addHillsBiome(BiomeKeys.DESERT_HILLS, DUNES, 100);
        OverworldBiomes.addHillsBiome(BiomeKeys.DESERT_LAKES, DUNES, 100);
        OverworldBiomes.addHillsBiome(BiomeKeys.SAVANNA, DUNES, 100);
        OverworldBiomes.addHillsBiome(BiomeKeys.SAVANNA_PLATEAU, DUNES, 100);
        OverworldBiomes.addHillsBiome(BiomeKeys.SHATTERED_SAVANNA_PLATEAU, DUNES, 100);
        OverworldBiomes.addHillsBiome(BiomeKeys.SHATTERED_SAVANNA, DUNES, 100);

    }
    public static boolean isBiome(Optional<RegistryKey<Biome>> optional) {
        return Objects.equals(optional, Optional.of(DUNES));
    }
}
