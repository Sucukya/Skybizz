package me.sucukya.skybizz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.mojang.brigadier.CommandDispatcher;
import lombok.Getter;
import me.sucukya.skybizz.commands.TestCommand;
import me.sucukya.skybizz.events.UseItemHandler;
import me.sucukya.skybizz.utils.ActionBarParser;
import me.sucukya.skybizz.utils.Static;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.command.CommandRegistryAccess;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.regex.Pattern;

public class Skybizz implements ModInitializer {
	@Getter
    private static Skybizz instance;
	public static final String MODID = "Skybizz";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);


	public Skybizz() {
		instance = this;
	}
	@Override
	public void onInitialize() {
		UseItemCallback.EVENT.register(new UseItemHandler());
		HudRenderCallback.EVENT.register(new ActionBarParser());
		ClientCommandRegistrationCallback.EVENT.register(Skybizz::registerCommands);
		Static.initialize();

		LOGGER.info("Hello Fabric world!");
	}

	public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess) {
		TestCommand.register(dispatcher);
	}

}
