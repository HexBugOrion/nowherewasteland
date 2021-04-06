package net.vdragondev.nowhere.mixin.feature;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.Feature;
import net.vdragondev.nowhere.registries.BlockRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Feature.class)
public class SoilMixin {
    @Inject(at = @At("HEAD"), method = "isSoil(Lnet/minecraft/block/Block;)Z", cancellable = true)
    private static void isSoil(Block block, CallbackInfoReturnable<Boolean> cir) {
        if(block == BlockRegistry.DUST || block == BlockRegistry.SCORCHED_SOIL || block == BlockRegistry.NECROTIC_DUST || block == BlockRegistry.DRAINED_DUST){
            cir .setReturnValue(true);
        }
    }
}
