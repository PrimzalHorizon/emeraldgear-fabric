package net.primzal.emeraldgear.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.primzal.emeraldgear.EmeraldGear;

import static net.primzal.emeraldgear.Utils.buildComponent;
import static net.primzal.emeraldgear.modmenu.Config.ConfigPath;

public class ModMenu implements ModMenuApi {
    private Config config = EmeraldGear.config;
    private boolean villagerDiscounts = config.getBoolean(ConfigPath.villagerDiscounts);

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parentScreen -> {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parentScreen)
                    .setDoesConfirmSave(true)
                    .setTitle(buildComponent("Emerald Gear"));
            ConfigCategory general = builder.getOrCreateCategory(buildComponent("General"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            general.addEntry(entryBuilder.startBooleanToggle(buildComponent("Random Villager discounts (Experimental)"), villagerDiscounts)
                    .setDefaultValue(true)
                    .setSaveConsumer(value -> villagerDiscounts = value)
                    .setTooltip(buildComponent("Random Villager discounts is villager trade discounts when wearing or holding a emerald related equipment"))
                    .build());

            builder.setSavingRunnable(this::onSave);
            return builder.build();
        };
    }

    private void onSave() {
        if(config.getBoolean(ConfigPath.villagerDiscounts) != villagerDiscounts) config.setBoolean(ConfigPath.villagerDiscounts, villagerDiscounts);
    }
}
