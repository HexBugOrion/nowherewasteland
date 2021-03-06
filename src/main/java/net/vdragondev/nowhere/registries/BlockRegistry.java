package net.vdragondev.nowhere.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.vdragondev.nowhere.Nowhere;

import java.util.ArrayList;
import java.util.List;

public class BlockRegistry {
    public static List<Block> blocksList = new ArrayList<>();

    //blocks
    public static final Block PACKED_DUST = createSoils("packed_dust");
    public static final Block DUST = createSands("dust");
    public static final Block DESERT_ROOTS = createFlower("desert_roots");
    public static final Block DRIED_LOG = createLogs("dried_log");
    public static final Block DRAINED_PACKED_DUST = createLifelessSoils("drained_packed_dust");
    public static final Block DRAINED_DUST = createLifelessSands("drained_dust");
    public static final Block NECROTIC_PACKED_DUST = createLifelessSoils("necrotic_packed_dust");
    public static final Block NECROTIC_DUST = createLifelessSands("necrotic_dust");
    public static final Block NECROTIC_LOG = createLogs("necrotic_log");
    public static final Block SCRAP_HEAP = createMetalScraps("scrap_heap");
    public static final Block SCRAP_PILE = createMetalScraps("scrap_pile");
    public static final Block DUST_STONE = createStones("dust_stone");
    public static final Block SALT_BLOCK = createLifelessSands("salt_block");
    public static final Block SALT_HEAP = createSalts("salt_heap");
    public static final Block CRACKED_SOIL = createCrackedSoils("cracked_soil");
    public static final Block SCORCHED_SOIL = createCrackedSoils("scorched_soil");
    public static final Block CHARCOAL_LOG = createLogs("charcoal_log");
    public static final Block VORTEX_PACKED_DUST = createLifelessSoils("vortex_packed_dust");
    public static final Block VORTEX_DUST = createLifelessSands("vortex_dust");
    public static final Block VORTEXITE = createStones("vortexite");
    public static final Block MONOSTONE = createGlowingMonoStones("monostone");
    public static final Block CARNA_ROOTS = createFlower("carna_roots");
    public static final Block SCRAP_PILLAR = createMetalPillars("scrap_pillar");

    static Block createLogs(String id) {
        Block createBlock = new PillarBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.5f,2.5f));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createMetalPillars(String id) {
        Block createBlock = new PillarBlock(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(5,5).breakByTool(FabricToolTags.PICKAXES));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createSoils(String id){
        Block createBlock = new Block(
            FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SOUL_SOIL).strength(0.5f,0.5f).breakByTool(
                FabricToolTags.SHOVELS));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createSalts(String id){
        Block createBlock = new FallingBlock(
            FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SAND).strength(0.5f,0.5f).breakByTool(
                FabricToolTags.SHOVELS));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createCrackedSoils(String id){
        Block createBlock = new Block(
            FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.BASALT).strength(0.9f,0.9f).breakByTool(
                FabricToolTags.PICKAXES));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createLifelessSoils(String id) {
        Block createBlock = new Block(
            FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SOUL_SOIL)
                .strength(0.5f, 0.5f).ticksRandomly().breakByTool(FabricToolTags.SHOVELS));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
        static Block createSands(String id){
        Block createBlock = new Block(
            FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SOUL_SAND).strength(0.2f).strength(0.5f, 0.1f).breakByTool(
                FabricToolTags.SHOVELS));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createLifelessSands(String id){
        Block createBlock = new Block(
            FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.SOUL_SAND).strength(0.2f).strength(0.5f, 0.1f).breakByTool(
                FabricToolTags.SHOVELS));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createMetalScraps(String id){
        Block createBlock = new Block(
            FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(5,5).breakByTool(
                FabricToolTags.PICKAXES));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createFlower(String id) {
        Block createBlock = new FlowerBlock(
            StatusEffects.SATURATION, 7, FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.GRASS).strength(0.0f).noCollision().nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createStones(String id){
        Block createBlock = new Block(
            FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(1,1).breakByTool(
                FabricToolTags.PICKAXES));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createMonoStones(String id){
        Block createBlock = new Block(
            FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(50,12000).breakByTool(
                FabricToolTags.PICKAXES,3));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }    static Block createGlowingMonoStones(String id){
        Block createBlock = new Block(
            FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(50,12000).breakByTool(
                FabricToolTags.PICKAXES,3).lightLevel(4));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    static Block createScorched(String id){
        Block createBlock = new MagmaBlock(
            FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(1,1).breakByTool(
                FabricToolTags.PICKAXES));
        Registry.register(Registry.BLOCK, new Identifier(Nowhere.MOD_ID, id), createBlock);
        blocksList.add(createBlock);
        return createBlock;
    }
    public static void init() {
    }
}
