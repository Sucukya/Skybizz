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
    static int healthColor = 0;

    public static void parseActionBar(Text actionmessage) {
        PlayerEntity player = MinecraftClient.getInstance().player;
        String message = actionmessage.getString();
        String[] segments = message.split("§");

        for(String segment : segments){
            String color = "f";
            if(segment.length() > 0) {
                color = String.valueOf(segment.charAt(0));
            }
            player.sendMessage(Text.of(segment));

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
                String iconstripped = TextUtils.stripActionBarIcons(stripped);
                //MinecraftClient.getInstance().player.sendMessage(Text.of("Mana " +iconstripped));
            } else if(stripped.contains("🞠")) {
                String iconstripped = TextUtils.stripActionBarIcons(stripped);
                //MinecraftClient.getInstance().player.sendMessage(Text.of("Location " +iconstripped));
            } else {
                if(TextUtils.isInt(stripped)) {
                    //MinecraftClient.getInstance().player.sendMessage(Text.of("Def " + stripped));
                }
            }
        }
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        DrawText gui = new DrawText();
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);

        matrixStack.push();
        gui.drawStat(matrixStack,Text.literal(health),200,250,healthColor);
    }
}
