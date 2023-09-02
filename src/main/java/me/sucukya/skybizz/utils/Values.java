package me.sucukya.skybizz.utils;

import me.sucukya.skybizz.Skybizz;
import me.sucukya.skybizz.utils.SkybizzConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Values {
    public static float healthX = Skybizz.CONFIG.healthX();
    public static float healthY = Skybizz.CONFIG.healthY();
    //public static float defenceX = Skybizz.CONFIG.def

    public static void save() {
        Skybizz.CONFIG.healthX(healthX);
        Skybizz.CONFIG.healthY(healthY);

        Skybizz.CONFIG.save();
    }

}
