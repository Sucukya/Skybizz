package me.sucukya.skybizz.utils;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class SkybizzConfig extends ConfigWrapper<me.sucukya.skybizz.utils.ConfigModel> {

    public final Keys keys = new Keys();

    private final Option<java.lang.Float> healthX = this.optionForKey(this.keys.healthX);
    private final Option<java.lang.Float> healthY = this.optionForKey(this.keys.healthY);
    private final Option<java.lang.Float> healthScaleX = this.optionForKey(this.keys.healthScaleX);
    private final Option<java.lang.Float> healthScaleY = this.optionForKey(this.keys.healthScaleY);
    private final Option<java.lang.Boolean> healthNumberToggled = this.optionForKey(this.keys.healthNumberToggled);
    private final Option<java.lang.Float> defenceX = this.optionForKey(this.keys.defenceX);
    private final Option<java.lang.Float> defenceY = this.optionForKey(this.keys.defenceY);
    private final Option<java.lang.Float> defenceScaleX = this.optionForKey(this.keys.defenceScaleX);
    private final Option<java.lang.Float> defenceScaleY = this.optionForKey(this.keys.defenceScaleY);
    private final Option<java.lang.Boolean> defenceNumberToggled = this.optionForKey(this.keys.defenceNumberToggled);
    private final Option<java.lang.Float> manaX = this.optionForKey(this.keys.manaX);
    private final Option<java.lang.Float> manaY = this.optionForKey(this.keys.manaY);
    private final Option<java.lang.Float> manaScaleX = this.optionForKey(this.keys.manaScaleX);
    private final Option<java.lang.Float> manaScaleY = this.optionForKey(this.keys.manaScaleY);
    private final Option<java.lang.Boolean> manaNumberToggled = this.optionForKey(this.keys.manaNumberToggled);

    private SkybizzConfig() {
        super(me.sucukya.skybizz.utils.ConfigModel.class);
    }

    private SkybizzConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(me.sucukya.skybizz.utils.ConfigModel.class, janksonBuilder);
    }

    public static SkybizzConfig createAndLoad() {
        var wrapper = new SkybizzConfig();
        wrapper.load();
        return wrapper;
    }

    public static SkybizzConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new SkybizzConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public float healthX() {
        return healthX.value();
    }

    public void healthX(float value) {
        healthX.set(value);
    }

    public float healthY() {
        return healthY.value();
    }

    public void healthY(float value) {
        healthY.set(value);
    }

    public float healthScaleX() {
        return healthScaleX.value();
    }

    public void healthScaleX(float value) {
        healthScaleX.set(value);
    }

    public float healthScaleY() {
        return healthScaleY.value();
    }

    public void healthScaleY(float value) {
        healthScaleY.set(value);
    }

    public boolean healthNumberToggled() {
        return healthNumberToggled.value();
    }

    public void healthNumberToggled(boolean value) {
        healthNumberToggled.set(value);
    }

    public float defenceX() {
        return defenceX.value();
    }

    public void defenceX(float value) {
        defenceX.set(value);
    }

    public float defenceY() {
        return defenceY.value();
    }

    public void defenceY(float value) {
        defenceY.set(value);
    }

    public float defenceScaleX() {
        return defenceScaleX.value();
    }

    public void defenceScaleX(float value) {
        defenceScaleX.set(value);
    }

    public float defenceScaleY() {
        return defenceScaleY.value();
    }

    public void defenceScaleY(float value) {
        defenceScaleY.set(value);
    }

    public boolean defenceNumberToggled() {
        return defenceNumberToggled.value();
    }

    public void defenceNumberToggled(boolean value) {
        defenceNumberToggled.set(value);
    }

    public float manaX() {
        return manaX.value();
    }

    public void manaX(float value) {
        manaX.set(value);
    }

    public float manaY() {
        return manaY.value();
    }

    public void manaY(float value) {
        manaY.set(value);
    }

    public float manaScaleX() {
        return manaScaleX.value();
    }

    public void manaScaleX(float value) {
        manaScaleX.set(value);
    }

    public float manaScaleY() {
        return manaScaleY.value();
    }

    public void manaScaleY(float value) {
        manaScaleY.set(value);
    }

    public boolean manaNumberToggled() {
        return manaNumberToggled.value();
    }

    public void manaNumberToggled(boolean value) {
        manaNumberToggled.set(value);
    }


    public static class Keys {
        public final Option.Key healthX = new Option.Key("healthX");
        public final Option.Key healthY = new Option.Key("healthY");
        public final Option.Key healthScaleX = new Option.Key("healthScaleX");
        public final Option.Key healthScaleY = new Option.Key("healthScaleY");
        public final Option.Key healthNumberToggled = new Option.Key("healthNumberToggled");
        public final Option.Key defenceX = new Option.Key("defenceX");
        public final Option.Key defenceY = new Option.Key("defenceY");
        public final Option.Key defenceScaleX = new Option.Key("defenceScaleX");
        public final Option.Key defenceScaleY = new Option.Key("defenceScaleY");
        public final Option.Key defenceNumberToggled = new Option.Key("defenceNumberToggled");
        public final Option.Key manaX = new Option.Key("manaX");
        public final Option.Key manaY = new Option.Key("manaY");
        public final Option.Key manaScaleX = new Option.Key("manaScaleX");
        public final Option.Key manaScaleY = new Option.Key("manaScaleY");
        public final Option.Key manaNumberToggled = new Option.Key("manaNumberToggled");
    }
}

