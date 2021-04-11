package net.vdragondev.nowhere.extras.item;

import net.minecraft.util.Formatting;

public enum CustomRarity {
    NECROTIC(Formatting.DARK_RED),
    LORE(Formatting.DARK_PURPLE),
    SACRED(Formatting.AQUA);

    public final Formatting formatting;

    private CustomRarity(Formatting formatting) {
        this.formatting = formatting;
    }
}
