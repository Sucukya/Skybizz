package me.sucukya.skybizz.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import me.sucukya.skybizz.Skybizz;
import me.sucukya.skybizz.utils.Values;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.FloatArgumentType.floatArg;
import static com.mojang.brigadier.arguments.FloatArgumentType.getFloat;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class Scale {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("scale")
                .then(literal("hp")
                        .then(argument("x", floatArg())
                                .then(argument("y",floatArg())
                                        .executes(ctx -> changeScale(ctx.getSource(),getFloat(ctx,"x"),getFloat(ctx,"y"),"hp")))))
                .then(literal("def")
                        .then(argument("x", floatArg())
                                .then(argument("y",floatArg())
                                        .executes(ctx -> changeScale(ctx.getSource(),getFloat(ctx,"x"),getFloat(ctx,"y"),"def")))))
                .then(literal("mana")
                        .then(argument("x", floatArg())
                                .then(argument("y",floatArg())
                                        .executes(ctx -> changeScale(ctx.getSource(),getFloat(ctx,"x"),getFloat(ctx,"y"),"mana"))))));


    }

    private static int changeScale(FabricClientCommandSource source, float x, float y, String stat) {
        ClientPlayerEntity player = source.getPlayer();
        if(stat.equalsIgnoreCase("hp")) {
            Values.healthScaleX = x;
            Values.healthScaleY = y;
            Values.save();
            player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bScaled §c§lHealth §bNumber to §e§lx§b: §a§l" + x + "§b, §e§ly§b: §a§l" + y));
        }
        if(stat.equalsIgnoreCase("def")) {
            Values.defenceScaleX = x;
            Values.defenceScaleY = y;
            Values.save();
            player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bScaled §a§lDefence §bNumber to §e§lx§b: §a§l" + x + "§b, §e§ly§b: §a§l" + y));
        }
        if(stat.equalsIgnoreCase("mana")) {
            Values.manaScaleX = x;
            Values.manaScaleY = y;
            Values.save();
            player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bScaled §b§lMana §bNumber to §e§lx§b: §a§l" + x + "§b, §e§ly§b: §a§l" + y));
        }


        return Command.SINGLE_SUCCESS;
    }

}
