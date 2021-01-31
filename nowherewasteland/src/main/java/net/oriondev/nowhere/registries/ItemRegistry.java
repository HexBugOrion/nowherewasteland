package net.oriondev.nowhere.registries;

import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.oriondev.nowhere.Nowhere;

import java.util.ArrayList;
import java.util.List;

public class ItemRegistry {

    public static List<Item> itemsList = new ArrayList<>();

    //blockItems
    public static final Item DUST = createItem(new BlockItem(BlockRegistry.DUST, new Item.Settings().group(Nowhere.NOWHERE_BLOCKS)), "dust");
    public static final Item PACKED_DUST = createItem(new BlockItem(BlockRegistry.PACKED_DUST, new Item.Settings().group(Nowhere.NOWHERE_BLOCKS)), "packed_dust");
    public static final Item DRIED_LOG = createItem(new BlockItem(BlockRegistry.DRIED_LOG, new Item.Settings().group(Nowhere.NOWHERE_BLOCKS)), "dried_log");
    public static final Item DRAINED_PACKED_DUST = createItem(new BlockItem(BlockRegistry.DRAINED_PACKED_DUST, new Item.Settings().group(Nowhere.NOWHERE_BLOCKS)), "drained_packed_dust");
    public static final Item DRAINED_DUST = createItem(new BlockItem(BlockRegistry.DRAINED_DUST, new Item.Settings().group(Nowhere.NOWHERE_BLOCKS)), "drained_dust");
    public static final Item NECROTIC_PACKED_DUST = createItem(new BlockItem(BlockRegistry.NECROTIC_PACKED_DUST, new Item.Settings().group(Nowhere.NOWHERE_BLOCKS)), "necrotic_packed_dust");
    public static final Item NECROTIC_DUST = createItem(new BlockItem(BlockRegistry.NECROTIC_DUST, new Item.Settings().group(Nowhere.NOWHERE_BLOCKS)), "necrotic_dust");
    public static final Item NECROTIC_LOG = createItem(new BlockItem(BlockRegistry.NECROTIC_LOG, new Item.Settings().group(Nowhere.NOWHERE_BLOCKS)), "necrotic_log");
    public static final Item SCRAP_HEAP = createItem(new BlockItem(BlockRegistry.SCRAP_HEAP, new Item.Settings().group(Nowhere.NOWHERE_BLOCKS)), "scrap_heap");
    public static final Item DESERT_ROOTS = createItem(new BlockItem(BlockRegistry.DESERT_ROOTS, new Item.Settings().group(Nowhere.NOWHERE_DECOR)), "desert_roots");
    //items
    public static final Item SCRAPMETAL = createItem(new Item(new Item.Settings().group(Nowhere.NOWHERE_MISC)), "scrapmetal");
    public static final Item DESERT_ROOT = createItem(new Item(new Item.Settings().group(Nowhere.NOWHERE_FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.f).build())), "desert_root");


    public static Item createItem(Item item, Identifier id) {
        if (id != null && !id.equals(new Identifier("minecraft:air"))) {
            Registry.register(Registry.ITEM, id, item);
            itemsList.add(item);
            return item;
        } else {
            return null;
        }
    }

    public static Item createItem(Item item, String id) {
        Registry.register(Registry.ITEM, new Identifier(Nowhere.MOD_ID, id), item);
        return item;
    }

    public static void init() {
    }
}
