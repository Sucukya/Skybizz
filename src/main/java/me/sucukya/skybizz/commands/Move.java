package me.sucukya.skybizz.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.sucukya.skybizz.Skybizz;
import me.sucukya.skybizz.utils.Values;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.FloatArgumentType.getFloat;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;


public class Move {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("move")
                        .then(literal("def")
                                .then(argument("x",FloatArgumentType.floatArg())
                                        .then(argument("y",FloatArgumentType.floatArg()).executes(ctx->movePosition(ctx.getSource(),
                                                getFloat(ctx,"x"),getFloat(ctx,"y"),"def")))))
                        .then(literal("mana")
                                .then(argument("x",FloatArgumentType.floatArg())
                                        .then(argument("y",FloatArgumentType.floatArg()).executes(ctx->movePosition(ctx.getSource(),
                                                getFloat(ctx,"x"),getFloat(ctx,"y"),"mana")))))
                        .then(literal("hp")
                                .then(argument("x",FloatArgumentType.floatArg())
                                                .then(argument("y",FloatArgumentType.floatArg()).executes(ctx -> movePosition(ctx.getSource(),
                                                        getFloat(ctx,"x"),getFloat(ctx,"y"),"hp"))))));
    }
    private static int movePosition(FabricClientCommandSource source, float x, float y, String stat) throws CommandSyntaxException {
        ClientPlayerEntity player = source.getPlayer();
        if(stat.equalsIgnoreCase("hp")) {
            Values.healthX = x;
            Values.healthY = y;
            player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bMoved §c§lHealth §bNumber to: §e§lx §b- §a§l" + x + "§b, §e§ly §b- §a§l" + y));
        }
        if(stat.equalsIgnoreCase("def")) {
            Values.defenceX = x;
            Values.defenceY = y;
            player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bMoved §a§lDefence §bNumber to: §e§lx §b- §a§l" + x + "§b, §e§ly §b- §a§l" + y));
        }
        if(stat.equalsIgnoreCase("mana")) {
            Values.manaX = x;
            Values.manaY = y;
            player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bMoved §b§lMana §bNumber to: §e§lx §b- §a§l" + x + "§b, §e§ly §b- §a§l" + y));
        }
            Values.save();

        return Command.SINGLE_SUCCESS;
    }
}
