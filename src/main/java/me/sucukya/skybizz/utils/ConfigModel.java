package me.sucukya.skybizz.utils;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.SectionHeader;


@Modmenu(modId = "skybizz")
@Config(name = "Skybizz", wrapperName = "SkybizzConfig")

public class ConfigModel {
   @SectionHeader("Health Number")

   public float healthX = 100;
   public float healthY = 100;
   public float healthScaleX = 1.5f;
   public float healthScaleY = 1.5f;
   public boolean healthNumberToggled = false;
   @SectionHeader("Defence Number")

   public float defenceX = 100;
   public float defenceY = 100;
   public float defenceScaleX = 1.5f;
   public float defenceScaleY = 1.5f;
   public boolean defenceNumberToggled = false;
   @SectionHeader("Mana Number")

   public float manaX = 100;
   public float manaY = 100;
   public float manaScaleX = 1.5f;
   public float manaScaleY = 1.5f;
   public boolean manaNumberToggled = false;
}
