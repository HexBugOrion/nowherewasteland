package net.vdragondev.nowhere.mixin.plant;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.vdragondev.nowhere.registries.BlockRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlantBlock.class)
public class PlantMixin {
    @Inject(at = @At("HEAD"), method = "canPlantOnTop", cancellable = true)
    private void init(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
        if (floor.isOf(BlockRegistry.DUST) || floor.isOf(BlockRegistry.PACKED_DUST) || floor.isOf(BlockRegistry.NECROTIC_DUST )|| floor.isOf(BlockRegistry.NECROTIC_PACKED_DUST)) {
            info.setReturnValue(true);
        }
    }
}
