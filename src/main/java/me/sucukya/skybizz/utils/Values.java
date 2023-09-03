package me.sucukya.skybizz.utils;

import me.sucukya.skybizz.Skybizz;
import me.sucukya.skybizz.utils.SkybizzConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Values {

    //Health Number Values
    public static float healthX = Skybizz.CONFIG.healthX();
    public static float healthY = Skybizz.CONFIG.healthY();
    public static float healthScaleX = Skybizz.CONFIG.healthScaleX();
    public static float healthScaleY = Skybizz.CONFIG.healthScaleY();
    public static boolean healthNumberToggled = Skybizz.CONFIG.healthNumberToggled();

    //Defence Number Values
    public static float defenceX = Skybizz.CONFIG.defenceX();
    public static float defenceY = Skybizz.CONFIG.defenceY();
    public static float defenceScaleX = Skybizz.CONFIG.defenceScaleX();
    public static float defenceScaleY = Skybizz.CONFIG.defenceScaleY();
    public static boolean defenceNumberToggled = Skybizz.CONFIG.defenceNumberToggled();

    //Mana Number Values
    public static float manaX = Skybizz.CONFIG.manaX();
    public static float manaY = Skybizz.CONFIG.manaY();
    public static float manaScaleX = Skybizz.CONFIG.manaScaleX();
    public static float manaScaleY = Skybizz.CONFIG.manaScaleY();
    public static boolean manaNumberToggled = Skybizz.CONFIG.manaNumberToggled();

    public static void save() {
        //Health Number saving
        Skybizz.CONFIG.healthX(healthX);
        Skybizz.CONFIG.healthY(healthY);
        Skybizz.CONFIG.healthScaleX(healthScaleX);
        Skybizz.CONFIG.healthScaleY(healthScaleY);
        Skybizz.CONFIG.healthNumberToggled(healthNumberToggled);

        //Defence Number saving
        Skybizz.CONFIG.defenceX(defenceX);
        Skybizz.CONFIG.defenceY(defenceY);
        Skybizz.CONFIG.defenceScaleX(defenceScaleX);
        Skybizz.CONFIG.defenceScaleY(defenceScaleY);
        Skybizz.CONFIG.defenceNumberToggled(defenceNumberToggled);

        //Mana Number saving
        Skybizz.CONFIG.manaX(manaX);
        Skybizz.CONFIG.manaY(manaY);
        Skybizz.CONFIG.manaScaleX(manaScaleX);
        Skybizz.CONFIG.manaScaleY(manaScaleY);
        Skybizz.CONFIG.manaNumberToggled(manaNumberToggled);

        Skybizz.CONFIG.save();
    }

}
