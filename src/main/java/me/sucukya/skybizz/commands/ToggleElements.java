package me.sucukya.skybizz.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.sucukya.skybizz.Skybizz;
import me.sucukya.skybizz.utils.Values;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;


public class ToggleElements {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("toggleelement")
                .then(literal("hpnumber")
                        .executes(ctx -> toggleElement(ctx.getSource(),"hpNumber")))
                .then(literal("defencenumber")
                        .executes(ctx -> toggleElement(ctx.getSource(),"defnumber")))
                .then(literal("mananumber")
                        .executes(ctx -> toggleElement(ctx.getSource(),"mananumber"))));
    }

    private static int toggleElement(FabricClientCommandSource source, String element) throws CommandSyntaxException {
        ClientPlayerEntity player = source.getPlayer();

        if(element.equalsIgnoreCase("hpnumber")) {
            if(Values.healthNumberToggled) {
                Values.healthNumberToggled = false;
                Values.save();
                player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bToggled §c§lHealth §bNumber §c§lOFF§b!"));
            } else {
                Values.healthNumberToggled = true;
                Values.save();
                player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bToggled §c§lHealth §bNumber §a§lON§b!"));
            }
        }
        if(element.equalsIgnoreCase("defnumber")) {
            if(Values.defenceNumberToggled) {
                Values.defenceNumberToggled = false;
                Values.save();
                player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bToggled §a§lDefence §bNumber §c§lOFF§b!"));
            } else {
                Values.defenceNumberToggled = true;
                Values.save();
                player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bToggled §a§lDefence §bNumber §a§lON§b!"));
            }
        }
        if(element.equalsIgnoreCase("mananumber")) {
            if(Values.manaNumberToggled) {
                Values.manaNumberToggled = false;
                Values.save();
                player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bToggled §b§lMana §bNumber §c§lOFF§b!"));
            } else {
                Values.manaNumberToggled = true;
                Values.save();
                player.sendMessage(Text.literal(Skybizz.chatPrefix + "§bToggled §b§lMana §bNumber §a§lON§b!"));
            }
        }

        return Command.SINGLE_SUCCESS;
    }

}
