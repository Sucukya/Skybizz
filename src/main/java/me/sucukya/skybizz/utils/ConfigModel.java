package me.sucukya.skybizz.utils;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.SectionHeader;


@Modmenu(modId = "Skybizz")
@Config(name = "Skybizz", wrapperName = "SkybizzConfig")

public class ConfigModel {
   @SectionHeader("Health Number")
   public float healthX = 100;
   public float healthY = 100;
   @SectionHeader("Defence Number")
   public float defenceX = 100;
   public float defenceY = 100;
   @SectionHeader("Mana Number")
   public float manaX = 100;
   public float manaY = 100;
}
