package net.primzal.emeraldgear.modmenu;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class Config {
    private static CommentedFileConfig toml;

    public Config() {
        Path path = FabricLoader.getInstance().getConfigDir().resolve("emeraldgear.toml");

        toml = CommentedFileConfig.builder(path)
                .autosave()
                .autoreload()
                .sync()
                .build();
        toml.load();

        if(toml.get("settings.villagerDiscounts") == null) {
            toml.set("settings.villagerDiscounts", true);
            toml.setComment("settings.villagerDiscounts"," Experimental");
        }
    }

    public boolean getBoolean(ConfigPath path) {
        switch(path) {
            case villagerDiscounts -> {
                return toml.get("settings.villagerDiscounts");
            }
            case null, default -> {
                return false;
            }
        }
    }

    public void setBoolean(ConfigPath path, boolean value) {
        switch(path) {
            case villagerDiscounts -> {
                if(getBoolean(path) != value) toml.set("settings.villagerDiscounts", value);
            }
            case null, default -> {}
        }
    }

    public enum ConfigPath {
        villagerDiscounts
    }
}