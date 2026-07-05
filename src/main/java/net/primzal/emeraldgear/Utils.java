package net.primzal.emeraldgear;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class Utils {
    public static MutableComponent buildComponent(String s, ChatFormatting... formatting) {
        if(formatting == null || formatting.length < 1)
            return Component.literal(s);
        else
            return Component.literal(s).withStyle(formatting);

    }
}
