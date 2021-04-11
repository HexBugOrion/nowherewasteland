package net.vdragondev.nowhere.extras.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MonoLoreItem1 extends Item {
    public MonoLoreItem1(Settings settings) {
        super(settings);
    }

    @Override public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip,
        TooltipContext context) {
        tooltip.add(new TranslatableText("nowhere.loreitemmonolith1.lore1"));
        tooltip.add(new TranslatableText("nowhere.loreitemmonolith1.lore2"));
        tooltip.add(new TranslatableText("nowhere.loreitemmonolith1.lore3"));
        tooltip.add(new TranslatableText("nowhere.loreitemmonolith1.lore4"));
        tooltip.add(new TranslatableText("nowhere.loreitemmonolith1.lore5"));
    }
}
