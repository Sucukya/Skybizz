package me.sucukya.skybizz;

import com.mojang.brigadier.CommandDispatcher;
import lombok.Getter;
import me.sucukya.skybizz.commands.Move;
import me.sucukya.skybizz.commands.TestCommand;
import me.sucukya.skybizz.events.UseItemHandler;
import me.sucukya.skybizz.utils.ActionBarParser;
import me.sucukya.skybizz.utils.SkybizzConfig;
import me.sucukya.skybizz.utils.Static;
import me.sucukya.skybizz.utils.Values;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.command.CommandRegistryAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Skybizz implements ModInitializer {

	public static final SkybizzConfig CONFIG = SkybizzConfig.createAndLoad();
	@Getter
    private static Skybizz instance;
	public static final String MODID = "Skybizz";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public Skybizz() {
		instance = this;
	}
	@Override
	public void onInitialize() {
		CONFIG.load();
		Static.initialize();
		UseItemCallback.EVENT.register(new UseItemHandler());
		HudRenderCallback.EVENT.register(new ActionBarParser());
		ClientCommandRegistrationCallback.EVENT.register(Skybizz::registerCommands);

		LOGGER.info("Hello Fabric world!");
	}

	public static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher,CommandRegistryAccess registryAccess) {
		Move.register(dispatcher);
		TestCommand.register(dispatcher);
	}



}
