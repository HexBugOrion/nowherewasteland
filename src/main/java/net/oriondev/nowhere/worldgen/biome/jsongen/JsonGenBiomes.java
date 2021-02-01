package net.oriondev.nowhere.worldgen.biome.jsongen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.oriondev.nowhere.worldgen.biome.NowhereBiome;
import net.oriondev.nowhere.worldgen.biome.NowhereSubBiome;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonGenBiomes {


    public static void handleNowhereBiomeJSONConfig(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BiomeDataListHolder.class, new BiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        final File CONFIG_FILE = new File(String.valueOf(path));

        if (!CONFIG_FILE.exists()) {
            BiomeDataListHolder.createDefaults();
            createNowhereBiomesJson(path);
        }
        try (Reader reader = new FileReader(path.toString())) {
            BiomeDataListHolder biomeDataListHolder = gson.fromJson(reader, BiomeDataListHolder.class);
            if (biomeDataListHolder != null)
                NowhereBiome.biomeData = biomeDataListHolder.getBiomeData();
        } catch (IOException e) {
        }
    }

    public static void createNowhereBiomesJson(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BiomeDataListHolder.class, new BiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(new BiomeDataListHolder(NowhereBiome.biomeData));

        try {
            Files.write(path, jsonString.getBytes());
        } catch (IOException e) {
        }
    }


    public static void handleNowhereSubBiomesJSONConfig(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SubBiomeDataListHolder.class, new SubBiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        final File CONFIG_FILE = new File(String.valueOf(path));

        if (!CONFIG_FILE.exists()) {
            SubBiomeDataListHolder.createDefaults();
            createNowhereSubBiomesJson(path);
        }
        try (Reader reader = new FileReader(path.toString())) {
            SubBiomeDataListHolder biomeDataListHolder = gson.fromJson(reader, SubBiomeDataListHolder.class);
            if (biomeDataListHolder != null)
                NowhereSubBiome.subBiomeData = biomeDataListHolder.getSubBiomeData();
        } catch (IOException e) {
        }
    }

    public static void createNowhereSubBiomesJson(Path path) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SubBiomeDataListHolder.class, new SubBiomeDataListHolderSerializer());
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.disableHtmlEscaping();
        Gson gson = gsonBuilder.create();

        String jsonString = gson.toJson(new SubBiomeDataListHolder(NowhereSubBiome.subBiomeData));

        try {
            Files.write(path, jsonString.getBytes());
        } catch (IOException e) {
        }
    }
}
