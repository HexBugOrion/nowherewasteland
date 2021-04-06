package net.vdragondev.nowhere;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.world.GeneratorType;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.VanillaLayeredBiomeSource;
import net.minecraft.world.gen.chunk.*;
import net.vdragondev.nowhere.extras.fluids.SaltWater;
import net.vdragondev.nowhere.mixin.world.GeneratorTypeMixin;
import net.vdragondev.nowhere.registries.BiomeRegistry;
import net.vdragondev.nowhere.registries.BlockRegistry;
import net.vdragondev.nowhere.registries.ItemRegistry;
import net.vdragondev.nowhere.registries.NowhereFeaturesRegistry;
import net.vdragondev.nowhere.worldgen.NowhereLayeredBiomeSource;
import net.vdragondev.nowhere.worldgen.biome.jsongen.BiomeDataListHolder;
import net.vdragondev.nowhere.worldgen.biome.jsongen.JsonGenBiomes;
import net.vdragondev.nowhere.worldgen.biome.jsongen.SubBiomeDataListHolder;

import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;


public class Nowhere implements ModInitializer {

	private static final GeneratorType NOWHERE = new GeneratorType("nowhere") {
		protected ChunkGenerator getChunkGenerator(Registry<Biome> biomeRegistry, Registry<ChunkGeneratorSettings> chunkGeneratorSettingsRegistry, long seed) {
			return new NoiseChunkGenerator(new NowhereLayeredBiomeSource(seed, false, false, biomeRegistry), seed, () -> {
				return (ChunkGeneratorSettings)chunkGeneratorSettingsRegistry.getOrThrow(ChunkGeneratorSettings.OVERWORLD);
			});
		}
	};

	public static Registry<Biome> REGISTRY;

	public static FlowableFluid STILL_SALTWATER;
	public static FlowableFluid FLOWING_SALTWATER;

	public static Item SALTWATER_BUCKET;

	public static Block SALTWATER;

	public static final String MOD_ID = "nowhere";
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
		System.out.println("Registering Fluids...");

		STILL_SALTWATER = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "saltwater"), new SaltWater.Still());
		FLOWING_SALTWATER = Registry.register(Registry.FLUID, new Identifier(MOD_ID,"flowing_saltwater"),  new SaltWater.Flowing());
		SALTWATER_BUCKET = Registry.register(Registry.ITEM, new Identifier(MOD_ID,"saltwater_bucket"), new BucketItem(STILL_SALTWATER, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(ItemGroup.MISC)));
		SALTWATER = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "saltwater"), new FluidBlock(STILL_SALTWATER, FabricBlockSettings.copy(Blocks.WATER)){});

		System.out.println("Registered Fluids!");
		NowhereWorldRegistries.registerWorldStuff();
		commonSetup();
		clearRAM();
		GeneratorTypeMixin.getValues().add(NOWHERE);
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

	public static void clearRAM(){
		System.out.println("Clearing MC Ram");
		FILE_PATH = null;
		System.out.println("Cleared ram!");
	}

	public static class NowhereRegistries {

		public static void registerStuff(){

			System.out.println("Registering Blocks...");
			BlockRegistry.init();
			BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.DESERT_ROOTS, RenderLayer.getTranslucent());
			System.out.println("Blocks Registered!");
			System.out.println("Registering Items...");
			ItemRegistry.init();
			System.out.println("Items Registered!");

		}
	}
	public static class NowhereWorldRegistries{

		public static void registerWorldStuff(){
			System.out.println("Registering Features...");
			NowhereFeaturesRegistry.registerConfiguredFeatures();
			System.out.println("Features Registered!");
			System.out.println("Registering Biomes...");
			BiomeRegistry.init();
			System.out.println("Biomes Registered!");
		}
	}
}
