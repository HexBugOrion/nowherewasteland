package net.vdragondev.nowhere.mixin.world;

import net.minecraft.client.world.GeneratorType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(GeneratorType.class)
public interface GeneratorTypeMixin {
    @Accessor("VALUES")
    public static List<GeneratorType> getValues(){
        throw new AssertionError();
    }

}
