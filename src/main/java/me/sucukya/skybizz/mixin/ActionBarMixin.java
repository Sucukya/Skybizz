package me.sucukya.skybizz.mixin;

import me.sucukya.skybizz.utils.ActionBarParser;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)

public class ActionBarMixin {

    @Inject(method = "setOverlayMessage", at = @At("TAIL"), cancellable = true)

    public void onGameMessage(Text message, boolean tinted, CallbackInfo ci) {
        ActionBarParser.parseActionBar(message);
    }

}