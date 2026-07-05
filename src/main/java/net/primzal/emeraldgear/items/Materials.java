package net.primzal.emeraldgear.items;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.primzal.emeraldgear.EmeraldGear;

import java.util.Map;

public class Materials {
    public static final Identifier ARMOR_EQUIP_SOUND_ID = Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, "armor.equip_emerald");
    public static final SoundEvent ARMOR_EQUIP_EMERALD = SoundEvent.createFixedRangeEvent(ARMOR_EQUIP_SOUND_ID,1);
    private static final Holder<SoundEvent> ARMOR_EQUIP_SOUND = BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvent.createVariableRangeEvent(ARMOR_EQUIP_SOUND_ID));
    private static final ResourceKey<EquipmentAsset> ASSET_KEY =
            ResourceKey.create(
                    EquipmentAssets.ROOT_ID,
                    Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, "emerald")
            );


    public static void registerSound() {
        Registry.register(
                BuiltInRegistries.SOUND_EVENT,
                ARMOR_EQUIP_SOUND_ID,
                ARMOR_EQUIP_EMERALD
        );
    }

    public static final ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(
            500,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 6,
                    ArmorType.LEGGINGS, 5,
                    ArmorType.BOOTS, 2
            ),
            15,
            ARMOR_EQUIP_SOUND,
            0.0F,
            0.0F,
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, "repairs_emerald_armor")
            ),
            ASSET_KEY
    );

    public static final ArmorMaterial ARMOR_CHESTPLATE_MATERIAL = new ArmorMaterial(
            500,
            Map.of(
                    ArmorType.HELMET, 0,
                    ArmorType.CHESTPLATE, 5,
                    ArmorType.LEGGINGS, 0,
                    ArmorType.BOOTS, 0
            ),
            15,
            ARMOR_EQUIP_SOUND,
            1.0F,
            0.0F,
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, "repairs_emerald_armor")
            ),
            ASSET_KEY
    );

    public static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            300,
            7F,
            2.0F,
            15,
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    Identifier.fromNamespaceAndPath(EmeraldGear.mod_id, "repairs_emerald_tool")
            )

    );

    public static final ArmorMaterial MOB_ARMOR_MATERIAL = new ArmorMaterial(
            0,
            Map.of(
                    ArmorType.HELMET, 0,
                    ArmorType.CHESTPLATE, 0,
                    ArmorType.LEGGINGS, 0,
                    ArmorType.BOOTS, 0,
                    ArmorType.BODY, 9
            ),
            0,
            ARMOR_EQUIP_SOUND,
            1,
            0,
            TagKey.create(
                    BuiltInRegistries.ITEM.key(),
                    Identifier.fromNamespaceAndPath(EmeraldGear.mod_id,"repairs_emerald_armor"
                    )
            ),
            ASSET_KEY
    );
}