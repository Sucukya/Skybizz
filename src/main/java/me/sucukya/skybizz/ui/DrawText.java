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

    public void drawStat(MatrixStack stack, Text text, float x, float y, int color, float scaleX, float scaleY) {
        MatrixStack stackToUse = new MatrixStack();
        stackToUse.multiplyPositionMatrix(stack.peek().getPositionMatrix());
        stackToUse.scale(scaleX,scaleY,0.5f);
        fontRenderer.draw(stackToUse,text,x,y,color);
    }
}
