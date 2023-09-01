package me.sucukya.skybizz.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class DrawText {


    private final MinecraftClient minecraft;
    private final TextRenderer fontRenderer;

    public DrawText() {
        minecraft = MinecraftClient.getInstance();
        fontRenderer = minecraft.textRenderer;
    }

    public void drawStat(MatrixStack stack, Text text, float x, float y, int color) {
        MatrixStack stackToUse = new MatrixStack();
        stackToUse.translate(1,1,1);
        stackToUse.multiplyPositionMatrix(stack.peek().getPositionMatrix());
        stackToUse.scale(1.5f,1.5f,1.5f);
        fontRenderer.draw(stackToUse,text,y,y,color);
    }
}
