package me.sucukya.skybizz.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.sucukya.skybizz.utils.Values;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.FloatArgumentType.getFloat;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;


public class Move {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("move")
                        .then(literal("def")
                                .then(argument("x",FloatArgumentType.floatArg())
                                        .then(argument("y",FloatArgumentType.floatArg()).executes(ctx->moveDef(ctx.getSource(),
                                                getFloat(ctx,"x"),getFloat(ctx,"y"))))))
                        .then(literal("mana")
                                .then(argument("x",FloatArgumentType.floatArg())
                                        .then(argument("y",FloatArgumentType.floatArg()).executes(ctx->moveMana(ctx.getSource(),
                                                getFloat(ctx,"x"),getFloat(ctx,"y"))))))
                        .then(literal("hp")
                                .then(argument("x",FloatArgumentType.floatArg())
                                                .then(argument("y",FloatArgumentType.floatArg()).executes(ctx -> moveHp(ctx.getSource(),
                                                        getFloat(ctx,"x"),getFloat(ctx,"y")))))));
    }
    private static int moveHp(FabricClientCommandSource source, float x, float y) throws CommandSyntaxException {
        ClientPlayerEntity player = source.getPlayer();
            Values.healthX = x;
            Values.healthY = y;
            Values.save();

        return Command.SINGLE_SUCCESS;
    }
    private static int moveMana(FabricClientCommandSource source, float x, float y) throws CommandSyntaxException {
        ClientPlayerEntity player = source.getPlayer();
        Values.healthX = x;
        Values.healthY = y;
        Values.save();

        return Command.SINGLE_SUCCESS;
    }
    private static int moveDef(FabricClientCommandSource source, float x, float y) throws CommandSyntaxException {
        ClientPlayerEntity player = source.getPlayer();
        Values.healthX = x;
        Values.healthY = y;
        Values.save();

        return Command.SINGLE_SUCCESS;
    }

}
