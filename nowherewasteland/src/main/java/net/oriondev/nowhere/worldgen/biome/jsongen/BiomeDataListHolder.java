package net.oriondev.nowhere.worldgen.biome.jsongen;

import net.minecraft.util.registry.BuiltinRegistries;
import net.oriondev.nowhere.worldgen.BiomeData;
import net.oriondev.nowhere.worldgen.NowhereBiome;

import java.util.Comparator;
import java.util.List;

public class BiomeDataListHolder {

    List<BiomeData> biomeData;


    public BiomeDataListHolder(List<BiomeData> biomeData) {
        this.biomeData = biomeData;
    }

    public List<BiomeData> getBiomeData() {
        return biomeData;
    }

    public static void createDefaults() {
        for (NowhereBiome nowhereBiome : NowhereBiome.NOWHERE_BIOMES) {
            NowhereBiome.biomeData.add(new BiomeData(nowhereBiome.getBiome(), nowhereBiome.getWeight(), nowhereBiome.getBiomeType(), nowhereBiome.getHills(), nowhereBiome.getEdge(), nowhereBiome.getBeach(), nowhereBiome.getRiver()));
        }

        //Sort entries alphabetically
        NowhereBiome.biomeData.sort(
            Comparator.comparing(data -> BuiltinRegistries.BIOME.getId(data.getBiome()).toString()));
    }

    public static void fillBiomeLists() {
        for (BiomeData biomeData : NowhereBiome.biomeData) {
            if (biomeData.getBiomeWeightedList() != null) {
                NowhereBiome.BIOME_TO_HILLS_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getBiomeWeightedList());
            }
            if (biomeData.getBeachBiome() != null)
                NowhereBiome.BIOME_TO_BEACH_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getBeachBiome());
            if (biomeData.getEdgeBiome() != null)
                NowhereBiome.BIOME_TO_EDGE_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getEdgeBiome());
            if (biomeData.getRiverBiome() != null)
                NowhereBiome.BIOME_TO_RIVER_LIST.put(BuiltinRegistries.BIOME.getRawId(biomeData.getBiome()), biomeData.getRiverBiome());
        }

        NowhereBiome.BIOME_TO_EDGE_LIST.remove(-1);
        NowhereBiome.BIOME_TO_BEACH_LIST.remove(-1);
        NowhereBiome.BIOME_TO_RIVER_LIST.remove(-1);
    }

}
