package net.primzal.emeraldgear.items.utils;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.primzal.emeraldgear.EmeraldGear;
import net.primzal.emeraldgear.items.Materials;

public class ItemRegisterer {
    public ItemRegisterer() {}

    public Item registerHelmet(String name, ArmorMaterial material, Item repairMaterial, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item helmet = new Item(
                new Item.Properties()
                        .setId(key)
                        .humanoidArmor(material, ArmorType.HELMET)
                        .repairable(repairMaterial)
                        .durability(durability)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, helmet);
    }

    public Item registerChestplate(String name, ArmorMaterial material, Item repairMaterial, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item chestplate = new Item(
                new Item.Properties()
                        .setId(key)
                        .humanoidArmor(material, ArmorType.CHESTPLATE)
                        .repairable(repairMaterial)
                        .durability(durability)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, chestplate);
    }

    public Item registerLeggings(String name, ArmorMaterial material, Item repairMaterial, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item leggings = new Item(
                new Item.Properties()
                        .setId(key)
                        .humanoidArmor(material, ArmorType.LEGGINGS)
                        .repairable(repairMaterial)
                        .durability(durability)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, leggings);
    }

    public Item registerBoots(String name, ArmorMaterial material, Item repairMaterial, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item boots = new Item(
                new Item.Properties()
                        .setId(key)
                        .humanoidArmor(material, ArmorType.BOOTS)
                        .repairable(repairMaterial)
                        .durability(durability)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, boots);
    }

    public Item registerNautilusArmor(String name, ArmorMaterial material) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item nautilusArmor = new Item(new Item.Properties()
                .setId(key)
                .nautilusArmor(material)
                .stacksTo(1)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, nautilusArmor);
    }

    public Item registerHorseArmor(String name, ArmorMaterial material) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item horseArmor = new Item(new Item.Properties()
                .setId(key)
                .horseArmor(material)
                .stacksTo(1)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, horseArmor);
    }

    public Item registerSword(String name, ToolMaterial material, Item repairMaterial, float attackDamageBaseline, float attackSpeedBaseline, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item sword = new Item(new Item.Properties()
                .setId(key)
                .sword(material,attackDamageBaseline, attackSpeedBaseline)
                .durability(durability)
                .stacksTo(1)
                .repairable(repairMaterial)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, sword);
    }

    public Item registerSpear(String name, ToolMaterial material, Item repairMaterial, float attackDuration, float attackMultiplier, float delay, float dismountTime, float dismountThreshold, float knockbackTime, float knockbackThreshold, float damageTime, float damageThreshold, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item spear = new Item(new Item.Properties()
                .setId(key)
                .spear(
                        Materials.TOOL_MATERIAL,
                        attackDuration,
                        attackMultiplier,
                        delay,
                        dismountTime,
                        dismountThreshold,
                        knockbackTime,
                        knockbackThreshold,
                        damageTime,
                        damageThreshold
                )
                .durability(durability)
                .stacksTo(1)
                .repairable(repairMaterial)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, spear);
    }

    public Item registerPickaxe(String name, ToolMaterial material, Item repairMaterial, float attackDamageBaseline, float attackSpeedBaseline, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item pickaxe = new Item(new Item.Properties()
                .setId(key)
                .pickaxe(material, attackDamageBaseline, attackSpeedBaseline)
                .repairable(repairMaterial)
                .stacksTo(1)
                .durability(durability)

        );
        return Registry.register(BuiltInRegistries.ITEM, id, pickaxe);
    }
    
    public Item registerAxe(String name, ToolMaterial material, Item repairMaterial, float attackDamageBaseline, float attackSpeedBaseline, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        AxeItem axe = new AxeItem(material, attackDamageBaseline, attackSpeedBaseline, new Item.Properties()
                .setId(key)
                .repairable(repairMaterial)
                .durability(1)
                .durability(durability)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, axe);
    }
    
    public Item registerShovel(String name, ToolMaterial material, Item repairMaterial, float attackDamageBaseline, float attackSpeedBaseline, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        ShovelItem shovel = new ShovelItem(material, attackDamageBaseline, attackSpeedBaseline, new Item.Properties()
                .setId(key)
                .repairable(repairMaterial)
                .stacksTo(1)
                .durability(durability)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, shovel);
    }
    
    public Item registerHoe(String name, ToolMaterial material, Item repairMaterial, float attackDamageBaseline, float attackSpeedBaseline, int durability) {
        Identifier id = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        HoeItem hoe = new HoeItem(material, attackDamageBaseline, attackSpeedBaseline, new Item.Properties()
                .setId(key)
                .repairable(repairMaterial)
                .stacksTo(1)
                .durability(durability)
        );
        return Registry.register(BuiltInRegistries.ITEM, id, hoe);
    }

}
