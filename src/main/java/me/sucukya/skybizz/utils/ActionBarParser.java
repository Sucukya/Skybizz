package me.sucukya.skybizz.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import me.sucukya.skybizz.Skybizz;
import me.sucukya.skybizz.ui.DrawText;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ActionBarParser implements HudRenderCallback{
    static String health = "";
    static String defence = "";
    static String mana = "";
    static int healthColor = 0;
    static int defenceColor = 0;
    static int manaColor = 0;

    public static void parseActionBar(Text actionmessage) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        String message = actionmessage.getString();
        String[] segments = message.split("§");

        for(String segment : segments){
            String color = "f";
            if(segment.length() > 0) {
                color = String.valueOf(segment.charAt(0));
            }

            String stripped = TextUtils.stripColor("§" + segment);
            if(stripped.contains("❤")) {
                String[] healthSegments = stripped.split("/");
                healthColor = Static.colorMatcher.get(color);
                String iconstripped = TextUtils.stripActionBarIcons(stripped);
                health = iconstripped;
            } else if(stripped.contains("❈")){

            }else if(stripped.contains("-")) {
                //MinecraftClient.getInstance().player.sendMessage(Text.literal("Mana Used " + stripped));
            }else if(TextUtils.onlyCharacters(stripped)){
                //MinecraftClient.getInstance().player.sendMessage(Text.literal("Used Ability: " + stripped));
            }else if(stripped.contains("✎")){
                manaColor = Static.colorMatcher.get(color);
                String iconstripped = TextUtils.stripActionBarIcons(stripped);
                mana = iconstripped;
            } else if(stripped.contains("🞠")) {
                String iconstripped = TextUtils.stripActionBarIcons(stripped);
                //MinecraftClient.getInstance().player.sendMessage(Text.of("Location " +iconstripped));
            } else {
                if(TextUtils.isInt(stripped)) {
                    defenceColor = Static.colorMatcher.get(color);
                    String iconstripped = TextUtils.stripActionBarIcons(stripped);
                    defence = iconstripped;
                }
            }
        }
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        DrawText gui = new DrawText();
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        matrixStack.push();
        if(Values.healthNumberToggled) {
            gui.drawStat(matrixStack, Text.literal(health), Values.healthX, Values.healthY, healthColor, Values.healthScaleX, Values.healthScaleY);
        }
        if(Values.defenceNumberToggled) {
            gui.drawStat(matrixStack, Text.literal(defence), Values.defenceX, Values.defenceY, defenceColor, Values.defenceScaleX, Values.defenceScaleY);
        }
        if(Values.manaNumberToggled) {
            gui.drawStat(matrixStack, Text.literal(mana), Values.manaX, Values.manaY, manaColor, Values.manaScaleX, Values.manaScaleY);
        }
    }
}
