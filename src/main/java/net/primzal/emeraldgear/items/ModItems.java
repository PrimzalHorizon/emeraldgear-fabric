package net.primzal.emeraldgear.items;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.primzal.emeraldgear.items.utils.ItemRegisterer;

public class ModItems {
    private static final ItemRegisterer registerer = new ItemRegisterer();

    public static Item EMERALD_HELMET;
    public static Item EMERALD_CHESTPLATE;
    public static Item EMERALD_LEGGINGS;
    public static Item EMERALD_BOOTS;
    public static Item EMERALD_NAUTILUS_ARMOR;
    public static Item EMERALD_HORSE_ARMOR;

    public static Item EMERALD_SWORD;
    public static Item EMERALD_SPEAR;

    public static Item EMERALD_PICKAXE;
    public static Item EMERALD_AXE;
    public static Item EMERALD_SHOVEL;
    public static Item EMERALD_HOE;

    public static void register() {
        Item repairMaterial = net.minecraft.world.item.Items.EMERALD;
        Item armorsNeighbour = net.minecraft.world.item.Items.DIAMOND_HELMET;
        Item toolsNeighbour = net.minecraft.world.item.Items.NETHERITE_PICKAXE;

        EMERALD_HELMET = registerer.registerHelmet("emerald_helmet", Materials.ARMOR_MATERIAL, repairMaterial, 205);
        EMERALD_CHESTPLATE = registerer.registerChestplate("emerald_chestplate", Materials.ARMOR_CHESTPLATE_MATERIAL, repairMaterial, 314);
        EMERALD_LEGGINGS = registerer.registerLeggings("emerald_leggings", Materials.ARMOR_MATERIAL, repairMaterial, 304);
        EMERALD_BOOTS = registerer.registerBoots("emerald_boots", Materials.ARMOR_MATERIAL, repairMaterial, 219);

        EMERALD_NAUTILUS_ARMOR = registerer.registerNautilusArmor("emerald_nautilus_armor", Materials.MOB_ARMOR_MATERIAL);
        EMERALD_HORSE_ARMOR = registerer.registerHorseArmor("emerald_horse_armor", Materials.MOB_ARMOR_MATERIAL);

        EMERALD_SWORD = registerer.registerSword("emerald_sword", Materials.TOOL_MATERIAL, repairMaterial,3F,-2.4F, 431);
        EMERALD_SPEAR = registerer.registerSpear("emerald_spear", Materials.TOOL_MATERIAL, repairMaterial,
                0.95F,
                0.95F,
                0.5F,
                2.5F,
                7.8F,
                6.73F,
                5.0F,
                11.27F,
                4.5F,
                423);

        EMERALD_SHOVEL = registerer.registerShovel("emerald_shovel", Materials.TOOL_MATERIAL, repairMaterial, 3.8F, -3.0F, 356);
        EMERALD_PICKAXE = registerer.registerPickaxe("emerald_pickaxe", Materials.TOOL_MATERIAL, repairMaterial,3.5F, -2.8F, 435);
        EMERALD_AXE = registerer.registerAxe("emerald_axe", Materials.TOOL_MATERIAL, repairMaterial,8.0F, -3.1F, 393);
        EMERALD_HOE = registerer.registerHoe("emerald_hoe", Materials.TOOL_MATERIAL, repairMaterial, 0.0F, -0.5F, 341);

        addToInventory(EMERALD_HELMET, CreativeModeTabs.COMBAT, armorsNeighbour, true);
        addToInventory(EMERALD_CHESTPLATE, CreativeModeTabs.COMBAT, armorsNeighbour, true);
        addToInventory(EMERALD_LEGGINGS, CreativeModeTabs.COMBAT, armorsNeighbour, true);
        addToInventory(EMERALD_BOOTS, CreativeModeTabs.COMBAT, armorsNeighbour, true);

        addToInventory(EMERALD_NAUTILUS_ARMOR, CreativeModeTabs.COMBAT, net.minecraft.world.item.Items.GOLDEN_NAUTILUS_ARMOR, false);
        addToInventory(EMERALD_HORSE_ARMOR, CreativeModeTabs.COMBAT, net.minecraft.world.item.Items.GOLDEN_HORSE_ARMOR, false);

        addToInventory(EMERALD_SWORD, CreativeModeTabs.COMBAT, net.minecraft.world.item.Items.GOLDEN_SWORD, false);
        addToInventory(EMERALD_SPEAR, CreativeModeTabs.COMBAT, net.minecraft.world.item.Items.GOLDEN_SPEAR, false);

        addToInventory(EMERALD_PICKAXE, CreativeModeTabs.TOOLS_AND_UTILITIES, toolsNeighbour, true);
        addToInventory(EMERALD_AXE, CreativeModeTabs.TOOLS_AND_UTILITIES, toolsNeighbour, true);
        addToInventory(EMERALD_SHOVEL, CreativeModeTabs.TOOLS_AND_UTILITIES, toolsNeighbour, true);
        addToInventory(EMERALD_HOE, CreativeModeTabs.TOOLS_AND_UTILITIES, toolsNeighbour, true);

        addToLootTables();
    }

    private static void addToInventory(Item item, ResourceKey<CreativeModeTab> tab, Item neighbour, boolean insertBefore){
        CreativeModeTabEvents.modifyOutputEvent(tab).register(tabOutput -> {
            if(insertBefore)
                tabOutput.insertBefore(neighbour, item);
            else 
                tabOutput.insertAfter(neighbour, item);
        });
    }

    private static void addToLootTables() {
        LootTableEvents.MODIFY.register((key, builder, source, lookup) -> {
            if(!source.isBuiltin()) return;

            if(key.equals(BuiltInLootTables.VILLAGE_ARMORER)) {
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .add(LootItem.lootTableItem(EMERALD_HELMET)
                                .when(LootItemRandomChanceCondition.randomChance(0.09f)))
                );
            }

            if(key.equals(BuiltInLootTables.VILLAGE_WEAPONSMITH)){
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .add(LootItem.lootTableItem(EMERALD_HELMET)
                                .when(LootItemRandomChanceCondition.randomChance(0.18f)))
                        .add(LootItem.lootTableItem(EMERALD_CHESTPLATE)
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(EMERALD_LEGGINGS)
                                .when(LootItemRandomChanceCondition.randomChance(0.16f)))
                        .add(LootItem.lootTableItem(EMERALD_BOOTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.17f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(EMERALD_SWORD)
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(EMERALD_PICKAXE)
                                .when(LootItemRandomChanceCondition.randomChance(0.16f)))
                        .add(LootItem.lootTableItem(EMERALD_SPEAR)
                                .when(LootItemRandomChanceCondition.randomChance(0.17f)))
                );
            }

            if(key.equals(BuiltInLootTables.VILLAGE_TOOLSMITH)){
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .add(LootItem.lootTableItem(EMERALD_SHOVEL)
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                        .add(LootItem.lootTableItem(EMERALD_PICKAXE)
                                .when(LootItemRandomChanceCondition.randomChance(0.15f)))
                );
            }

            if(key.equals(BuiltInLootTables.VILLAGE_SNOWY_HOUSE)) {
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_HELMET)
                                .when(LootItemRandomChanceCondition.randomChance(0.08f)))
                        .add(LootItem.lootTableItem(EMERALD_CHESTPLATE)
                                .when(LootItemRandomChanceCondition.randomChance(0.05f)))
                        .add(LootItem.lootTableItem(EMERALD_LEGGINGS)
                                .when(LootItemRandomChanceCondition.randomChance(0.06f)))
                        .add(LootItem.lootTableItem(EMERALD_BOOTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.07f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.04f)))
                );
            }


            if(key.equals(BuiltInLootTables.VILLAGE_TAIGA_HOUSE)) {
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_HELMET)
                                .when(LootItemRandomChanceCondition.randomChance(0.11f)))
                        .add(LootItem.lootTableItem(EMERALD_CHESTPLATE)
                                .when(LootItemRandomChanceCondition.randomChance(0.08f)))
                        .add(LootItem.lootTableItem(EMERALD_LEGGINGS)
                                .when(LootItemRandomChanceCondition.randomChance(0.09f)))
                        .add(LootItem.lootTableItem(EMERALD_BOOTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.10f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.03f)))
                );
            }

            if(key.equals(BuiltInLootTables.VILLAGE_PLAINS_HOUSE)) {
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_HELMET)
                                .when(LootItemRandomChanceCondition.randomChance(0.12f)))
                        .add(LootItem.lootTableItem(EMERALD_CHESTPLATE)
                                .when(LootItemRandomChanceCondition.randomChance(0.09f)))
                        .add(LootItem.lootTableItem(EMERALD_LEGGINGS)
                                .when(LootItemRandomChanceCondition.randomChance(0.10f)))
                        .add(LootItem.lootTableItem(EMERALD_BOOTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.11f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.09f)))
                );
            }

            if(key.equals(BuiltInLootTables.VILLAGE_SAVANNA_HOUSE)) {
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_HELMET)
                                .when(LootItemRandomChanceCondition.randomChance(0.10f)))
                        .add(LootItem.lootTableItem(EMERALD_CHESTPLATE)
                                .when(LootItemRandomChanceCondition.randomChance(0.07f)))
                        .add(LootItem.lootTableItem(EMERALD_LEGGINGS)
                                .when(LootItemRandomChanceCondition.randomChance(0.08f)))
                        .add(LootItem.lootTableItem(EMERALD_BOOTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.09f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.08f)))
                );
            }

            if(key.equals(BuiltInLootTables.VILLAGE_DESERT_HOUSE)) {
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_HELMET)
                                .when(LootItemRandomChanceCondition.randomChance(0.09f)))
                        .add(LootItem.lootTableItem(EMERALD_CHESTPLATE)
                                .when(LootItemRandomChanceCondition.randomChance(0.06f)))
                        .add(LootItem.lootTableItem(EMERALD_LEGGINGS)
                                .when(LootItemRandomChanceCondition.randomChance(0.07f)))
                        .add(LootItem.lootTableItem(EMERALD_BOOTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.08f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.05f)))
                );
            }

            if(key.equals(BuiltInLootTables.DESERT_PYRAMID)) {
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_HELMET)
                                .when(LootItemRandomChanceCondition.randomChance(0.06f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.08f)))
                        .add(LootItem.lootTableItem(EMERALD_NAUTILUS_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.07f)))
                );
            }

            if(key.equals(BuiltInLootTables.JUNGLE_TEMPLE)){
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.18f)))
                );
            }

            if(key.equals(BuiltInLootTables.BURIED_TREASURE)) {
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_NAUTILUS_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.10f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.08f)))
                );
            }

            if(key.equals(BuiltInLootTables.UNDERWATER_RUIN_SMALL)){
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_NAUTILUS_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.04f)))
                );
            }

            if(key.equals(BuiltInLootTables.UNDERWATER_RUIN_BIG)){
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_NAUTILUS_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.04f)))
                );
            }

            if(key.equals(BuiltInLootTables.SHIPWRECK_TREASURE)){
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_NAUTILUS_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.13f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.07f)))
                );
            }

            if(key.equals(BuiltInLootTables.SHIPWRECK_SUPPLY)){
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_NAUTILUS_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.06f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.02f)))
                );
            }

            if(key.equals(BuiltInLootTables.ANCIENT_CITY)) {
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(2))
                        .add(LootItem.lootTableItem(EMERALD_LEGGINGS)
                                .when(LootItemRandomChanceCondition.randomChance(0.15f))
                                .apply(EnchantWithLevelsFunction.enchantWithLevels(lookup, UniformGenerator.between(29, 30))))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.07f)))
                );
            }

            if(key.equals(BuiltInLootTables.STRONGHOLD_CORRIDOR)){
                builder.withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(EMERALD_HELMET)
                                .when(LootItemRandomChanceCondition.randomChance(0.11f)))
                        .add(LootItem.lootTableItem(EMERALD_CHESTPLATE)
                                .when(LootItemRandomChanceCondition.randomChance(0.08f)))
                        .add(LootItem.lootTableItem(EMERALD_LEGGINGS)
                                .when(LootItemRandomChanceCondition.randomChance(0.09f)))
                        .add(LootItem.lootTableItem(EMERALD_BOOTS)
                                .when(LootItemRandomChanceCondition.randomChance(0.10f)))
                        .add(LootItem.lootTableItem(EMERALD_HORSE_ARMOR)
                                .when(LootItemRandomChanceCondition.randomChance(0.09f)))
                        .add(LootItem.lootTableItem(EMERALD_PICKAXE)
                                .when(LootItemRandomChanceCondition.randomChance(0.10f)))
                        .add(LootItem.lootTableItem(EMERALD_SWORD)
                                .when(LootItemRandomChanceCondition.randomChance(0.11f)))
                );
            }
        });
    }
}
