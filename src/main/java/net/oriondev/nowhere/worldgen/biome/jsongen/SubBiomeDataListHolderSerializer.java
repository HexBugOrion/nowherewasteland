package net.oriondev.nowhere.worldgen.biome.jsongen;

import com.google.gson.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.oriondev.nowhere.Nowhere;
import net.oriondev.nowhere.worldgen.biome.SubBiomeData;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubBiomeDataListHolderSerializer implements JsonSerializer<SubBiomeDataListHolder>, JsonDeserializer<SubBiomeDataListHolder> {

    @Override
    public JsonElement serialize(SubBiomeDataListHolder Src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject biomes = new JsonObject();
        JsonObject biomeObject = new JsonObject();

        for (SubBiomeData biomeData : Src.getSubBiomeData()) {
            JsonObject object = new JsonObject();

            Identifier riverKey = BuiltinRegistries.BIOME.getId(biomeData.getRiverBiome());
            if (riverKey != null)
                object.addProperty("river", riverKey.toString());
            else
                object.addProperty("river", "");

            Identifier beachKey = BuiltinRegistries.BIOME.getId(biomeData.getBeachBiome());
            if (beachKey != null)
                object.addProperty("beach", beachKey.toString());
            else
                object.addProperty("beach", "");

            Identifier edgeKey = BuiltinRegistries.BIOME.getId(biomeData.getEdgeBiome());
            if (edgeKey != null)
                object.addProperty("edge", edgeKey.toString());
            else
                object.addProperty("edge", "");

            //This should never be null.
            Identifier location = BuiltinRegistries.BIOME.getId(biomeData.getBiome());
            if (location != null)
                biomeObject.add(location.toString(), object);

        }
        biomes.add("sub-biomes", biomeObject);

        return biomes;
    }

    @Override
    public SubBiomeDataListHolder deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        List<SubBiomeData> biomeData = new ArrayList<>();

        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.get("sub-biomes").getAsJsonObject().entrySet();

        for (Map.Entry<String, JsonElement> elementEntry : entrySet) {

            String biomeName = elementEntry.getKey();
            JsonElement element = elementEntry.getValue();

            JsonObject elementObject = element.getAsJsonObject();

            String edge = elementObject.get("edge").getAsString();
            String river = elementObject.get("river").getAsString();
            String beach = elementObject.get("beach").getAsString();


            Identifier biomeKey = new Identifier(biomeName);
            if (BuiltinRegistries.BIOME.getIds().contains(biomeKey)) {
                if (biomeKey.getNamespace().equals(Nowhere.MOD_ID))
                    biomeData.add(new SubBiomeData(BuiltinRegistries.BIOME.get(biomeKey), BuiltinRegistries.BIOME.get(new Identifier(edge)), BuiltinRegistries.BIOME.get(new Identifier(beach)), BuiltinRegistries.BIOME.get(new Identifier(river))));
            }
        }
        return new SubBiomeDataListHolder(biomeData);
    }
}
