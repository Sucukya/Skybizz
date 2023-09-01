package me.sucukya.skybizz.events;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.ArrayList;

public class UseItemHandler implements UseItemCallback {
    @Override
    public TypedActionResult<ItemStack> interact(PlayerEntity player, World world, Hand hand) {
        if(!player.getMainHandStack().isEmpty()) {
            ItemStack item = player.getMainHandStack();
            if (item.hasNbt()) {
                NbtCompound nbt = item.getNbt();
                NbtCompound display = nbt.getCompound("display");
                String lore = String.valueOf(display.get("Lore"));
                if(lore.contains("Wither Impact")) {
                    player.sendMessage(Text.literal("Used Wither Impact"));
                }
            }
        }
        return new TypedActionResult<>(ActionResult.PASS,player.getMainHandStack());
    }
}
