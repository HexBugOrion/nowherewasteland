package net.vdragondev.nowhere.registries;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.vdragondev.nowhere.worldgen.biome.BiomeData;
import net.vdragondev.nowhere.worldgen.biome.NowhereBiome;
import net.vdragondev.nowhere.worldgen.biome.biome_list.*;

public class BiomeRegistry {

    //actual biomes
    public static RegistryKey<Biome> DUNES_KEY = register("dunes_key", BiomeRegistry.NOWHERE_DUNES);
    public static Biome NOWHERE_DUNES = Registry.register(BuiltinRegistries.BIOME, DUNES_KEY.getValue(), new DunesBiome().getBiome());
    public static RegistryKey<Biome> SALT_FLATS_KEY = register("salt_flats_key", BiomeRegistry.NOWHERE_SALT_FLATS);
    public static Biome NOWHERE_SALT_FLATS = Registry.register(BuiltinRegistries.BIOME, SALT_FLATS_KEY.getValue(), new SaltFlatsBiome().getBiome());
    public static RegistryKey<Biome> DRAINED_DUNES_KEY = register("drained_dunes_key", BiomeRegistry.NOWHERE_DRAINED_DUNES);
    public static Biome NOWHERE_DRAINED_DUNES = Registry.register(BuiltinRegistries.BIOME, DRAINED_DUNES_KEY.getValue(), new DrainedDunes().getBiome());
    public static RegistryKey<Biome> NECROTIC_DUNES_KEY = register("necrotic_dunes_key", BiomeRegistry.NOWHERE_NECROTIC_DUNES);
    public static Biome NOWHERE_NECROTIC_DUNES = Registry.register(BuiltinRegistries.BIOME, NECROTIC_DUNES_KEY.getValue(), new NecroticDunes().getBiome());
    public static RegistryKey<Biome> SOLAR_VALLEY_KEY = register("solar_valley_key", BiomeRegistry.NOWHERE_SOLAR_VALLEY);
    public static Biome NOWHERE_SOLAR_VALLEY = Registry.register(BuiltinRegistries.BIOME, SOLAR_VALLEY_KEY.getValue(), new SolarValleyBiome().getBiome());
    public static RegistryKey<Biome> NATRON_SEA_KEY = register("natron_sea_key", BiomeRegistry.NOWHERE_NATRON_SEA);
    public static Biome NOWHERE_NATRON_SEA = Registry.register(BuiltinRegistries.BIOME, NATRON_SEA_KEY.getValue(), new NatronSeaBiome().getBiome());
    public static RegistryKey<Biome> SCORCHED_PEAKS_KEY = register("scorched_peaks_key", BiomeRegistry.NOWHERE_SCORCHED_PEAKS);
    public static Biome NOWHERE_SCORCHED_PEAKS = Registry.register(BuiltinRegistries.BIOME, SCORCHED_PEAKS_KEY.getValue(), new ScorchedPeaksBiome().getBiome());
    public static RegistryKey<Biome> MONOLITH_KEY = register("mono_key", BiomeRegistry.NOWHERE_MONO);
    public static Biome NOWHERE_MONO = Registry.register(BuiltinRegistries.BIOME, MONOLITH_KEY.getValue(), new MonolithBiome().getBiome());

    public static void init() {
    }



    public static void addBiomeEntries() {
        for (BiomeData biomeData : NowhereBiome.biomeData) {
            if (biomeData.getBiomeWeight() > 100) {
                OverworldBiomes.addContinentalBiome(RegistryKey.of(Registry.BIOME_KEY, BuiltinRegistries.BIOME.getId(biomeData.getBiome())), biomeData.getBiomeType(), biomeData.getBiomeWeight());
            }
        }
    }
    public static RegistryKey<Biome> register(String name, Biome biome){
        Identifier id = new Identifier("nowherebiomes", name);
        return RegistryKey.of(Registry.BIOME_KEY, id);
    }
}
