package net.primzal.emeraldgear.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.primzal.emeraldgear.EmeraldGear;
import net.primzal.emeraldgear.items.ModItems;
import net.primzal.emeraldgear.modmenu.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(Villager.class)
public abstract class VillagerTradeDiscountsMixin {

    @Inject(method = "updateSpecialPrices", at = @At("TAIL"))
    private void applyEmeraldGearDiscount(Player player, CallbackInfo ci) {
        if (!(EmeraldGear.config.getBoolean(Config.ConfigPath.villagerDiscounts))) return;

        int discountAmount = 0;
        int chanceRange = 0;

        if (player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.EMERALD_HELMET)) {
            chanceRange++;
            discountAmount += randomDiscountChange(chanceRange, 0) ? 1 : 0;
        }
        if (player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.EMERALD_CHESTPLATE)) {
            chanceRange++;
            discountAmount += randomDiscountChange(chanceRange, 0) ? 1 : 0;
        }
        if (player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.EMERALD_LEGGINGS)) {
            chanceRange++;
            discountAmount += randomDiscountChange(chanceRange, 0) ? 1 : 0;
        }
        if (player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.EMERALD_BOOTS)) {
            chanceRange++;
            discountAmount += randomDiscountChange(chanceRange, 0) ? 1 : 0;
        }

        if (player.getMainHandItem().getItem().getCreatorNamespace(player.getMainHandItem()).equals("emeraldgear")) {
            chanceRange++;
            discountAmount += randomDiscountChange(chanceRange, 0) ? 1 : 0;
        }

        if (discountAmount == 0) return;

        Villager villager = (Villager) (Object) this;
        MerchantOffers offers = villager.getOffers();

        if (offers != null) {
            for (MerchantOffer offer : offers) {
                int currentDiff = offer.getSpecialPriceDiff();
                offer.setSpecialPriceDiff(currentDiff - discountAmount);
            }
        }
    }

    @Unique
    private boolean randomDiscountChange(int range, int toMatch) {
        Random random = new Random();
        return random.nextInt(range) == toMatch;
    }
}