package me.sucukya.skybizz.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;


public class TestCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("test").executes(ctx -> run(ctx.getSource())));
    }

    private static int run(FabricClientCommandSource source) throws CommandSyntaxException {
        ClientPlayerEntity player = source.getPlayer();
        player.sendMessage(Text.literal("Funktioniert wie ne tolle Sau"));
        return -1;
    }

}
