package net.primzal.emeraldgear;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.primzal.emeraldgear.items.Materials;
import net.primzal.emeraldgear.items.ModItems;
import net.primzal.emeraldgear.modmenu.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EmeraldGear implements ModInitializer {
    public static String mod_id = "emeraldgear";
    public static String prefix = "[Emerald Gear]";

    public static Logger logger = LoggerFactory.getLogger(mod_id);
    public static Config config = new Config();

    @Override
    public void onInitialize() {
        logger.info("{}: Mod initializing", prefix);
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) Materials.registerSound();
        ModItems.register();
    }
}
