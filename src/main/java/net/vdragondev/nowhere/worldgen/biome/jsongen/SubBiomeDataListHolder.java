package net.vdragondev.nowhere.worldgen.biome.jsongen;

import net.minecraft.util.registry.BuiltinRegistries;
import net.vdragondev.nowhere.worldgen.biome.NowhereBiome;
import net.vdragondev.nowhere.worldgen.biome.NowhereSubBiome;
import net.vdragondev.nowhere.worldgen.biome.SubBiomeData;

import java.util.Comparator;
import java.util.List;

public class SubBiomeDataListHolder {

    List<SubBiomeData> subBiomeData;


    public SubBiomeDataListHolder(List<SubBiomeData> subBiomeData) {
        this.subBiomeData = subBiomeData;
    }

    public List<SubBiomeData> getSubBiomeData() {
        return subBiomeData;
    }

    public static void createDefaults() {
        for (NowhereSubBiome nowhereSubBiome : NowhereSubBiome.NOWHERE_SUB_BIOMES) {
            NowhereSubBiome.subBiomeData.add(new SubBiomeData(nowhereSubBiome.getBiome(), nowhereSubBiome.getEdge(), nowhereSubBiome.getBeach(), nowhereSubBiome.getRiver()));
        }
        NowhereSubBiome.subBiomeData.sort(
            Comparator.comparing(data -> BuiltinRegistries.BIOME.getId(data.getBiome()).toString()));
    }

    public static void fillBiomeLists() {
        for (SubBiomeData biomeData : NowhereSubBiome.subBiomeData) {
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
