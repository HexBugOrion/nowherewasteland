package net.oriondev.nowhere;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeKeys;
import net.oriondev.nowhere.registries.BiomeRegistry;
import net.oriondev.nowhere.registries.BlockRegistry;
import net.oriondev.nowhere.registries.ItemRegistry;
import net.oriondev.nowhere.worldgen.biome.jsongen.BiomeDataListHolder;
import net.oriondev.nowhere.worldgen.biome.jsongen.JsonGenBiomes;
import net.oriondev.nowhere.worldgen.biome.jsongen.SubBiomeDataListHolder;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;

public class Nowhere implements ModInitializer {

	public static String MOD_ID = "nowhere";
	public static String FILE_PATH = "your-home";
	public static final ItemGroup NOWHERE_BLOCKS = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "nowhere_blocks"), () -> new ItemStack(ItemRegistry.DUST));
	public static final ItemGroup NOWHERE_DECOR = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "nowhere_decor"), () -> new ItemStack(ItemRegistry.DESERT_ROOTS));
	public static final ItemGroup NOWHERE_MISC = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "nowhere_misc"), () -> new ItemStack(ItemRegistry.SCRAPMETAL));
	public static final ItemGroup NOWHERE_FOOD = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "nowhere_food"), () -> new ItemStack(ItemRegistry.DESERT_ROOT));

	public static final Path CONFIG_PATH = new File(String.valueOf(FabricLoader.getInstance().getConfigDirectory().toPath().resolve(MOD_ID))).toPath();



	@Override
	public void onInitialize() {
		File dir = new File(CONFIG_PATH.toString());
		if (!dir.exists())
			dir.mkdir();

		System.out.println("Registering Nowhere...");
		NowhereRegistries.registerStuff();
		NowhereWorldRegistries.registerWorldStuff();
		biomeSetup();
		commonSetup();
		clearRAM();
		System.out.println("Registered Nowhere, welcome... to your last stop...");

	}

	private void commonSetup(){
		System.out.println("Setting up Biomes...");
		JsonGenBiomes.handleNowhereBiomeJSONConfig(CONFIG_PATH.resolve(MOD_ID + "-biomes.json"));
		JsonGenBiomes.handleNowhereSubBiomesJSONConfig(CONFIG_PATH.resolve(MOD_ID + "-sub-biomes.json"));
		BiomeRegistry.addBiomeEntries();
		BiomeDataListHolder.fillBiomeLists();
		SubBiomeDataListHolder.fillBiomeLists();
		System.out.println("Biome Setup Complete");
	}

	//SUCH POO
	private void biomeSetup() {
		System.out.println("Registering Biomes...");
		BiomeRegistry.init();
		BiomeRegistry.biomeList.sort(Comparator.comparingInt(BiomeRegistry.PreserveBiomeOrder::getOrderPosition));
		BiomeRegistry.biomeList.forEach(preserveBiomeOrder -> Registry.register(BuiltinRegistries.BIOME, new Identifier(MOD_ID, preserveBiomeOrder.getId()), preserveBiomeOrder.getBiome()));
		System.out.println("Biomes Registered!");
	}


	public static void clearRAM(){
		System.out.println("Clearing MC Ram");
		FILE_PATH = null;
		System.out.println("Cleared ram!");
	}

	public static class NowhereRegistries {

		public static void registerStuff(){

			System.out.println("Registering Blocks...");
			BlockRegistry.init();
			BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.DESERT_ROOTS, RenderLayer.getCutout());
			System.out.println("Blocks Registered!");
			System.out.println("Registering Items...");
			ItemRegistry.init();
			System.out.println("Items Registered!");

		}
	}
	public static class NowhereWorldRegistries{

		public static void registerWorldStuff(){

			System.out.println("Registering Biomes...");
			BiomeRegistry.init();
			BiomeRegistry.biomeList.sort(Comparator.comparingInt(BiomeRegistry.PreserveBiomeOrder::getOrderPosition));
			BiomeRegistry.biomeList.forEach(preserveBiomeOrder -> Registry.register(BuiltinRegistries.BIOME, new Identifier(MOD_ID, preserveBiomeOrder.getId()), preserveBiomeOrder.getBiome()));
			BiomeRegistry.addBiomeNumericalIDs();
			System.out.println("Biomes Registered!");
		}
	}
}
