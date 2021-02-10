package net.vdragondev.nowhere.worldgen.features.trees;

import com.mojang.serialization.Codec;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.vdragondev.nowhere.Nowhere;
import net.vdragondev.nowhere.registries.BlockRegistry;

import java.util.Random;

public class SmallTreeThing extends Feature<DefaultFeatureConfig> {

    public SmallTreeThing(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        if (pos.getX() == -9 && pos.getZ() == -6) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.Mutable block = new BlockPos.Mutable(checkX, checkY, checkZ);
                        world.setBlockState(block, BlockRegistry.DRIED_LOG.getDefaultState(), 2);
                    }
                }
            }

            StructureManager templatemanager = world.toServerWorld().getStructureManager();
            Structure template = templatemanager.getStructure(new Identifier(Nowhere.MOD_ID + ":features/trees/dried_tree"));

            if (template == null) {
                return false;
            }

            StructurePlacementData
                placementsettings = (new StructurePlacementData()).setMirror(BlockMirror.NONE).setRotation(
                BlockRotation.NONE).setIgnoreEntities(false).setChunkPosition(null);
            template.place(world, pos, placementsettings, rand);
            return true;
        }
        return false;
    }
}
