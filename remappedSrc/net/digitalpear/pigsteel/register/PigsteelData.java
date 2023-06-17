package net.digitalpear.pigsteel.register;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.vanilla.VanillaChestLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.EmptyEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetDamageLootFunction;
import net.minecraft.loot.function.SetPotionLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.Arrays;
import java.util.Map;

public class PigsteelData {


    /*
        Replace iron in nether loot tables with pigsteel
     */
    public static void registerLootTableModifications(){
        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if (LootTables.BASTION_OTHER_CHEST.equals(id) && source.isBuiltin()) {
                return createBastionOtherChestTableBuilder().build();
            }
            else if (LootTables.BASTION_TREASURE_CHEST.equals(id) && source.isBuiltin()) {
                return createBastionTreasureChestTableBuilder().build();
            }
            else if (LootTables.NETHER_BRIDGE_CHEST.equals(id) && source.isBuiltin()) {
                return createNetherBridgeChestTableBuilder().build();
            }
            else if (LootTables.BASTION_BRIDGE_CHEST.equals(id) && source.isBuiltin()) {
                return createBastionBridgeChestTableBuilder().build();
            }
            else if (LootTables.PIGLIN_BARTERING_GAMEPLAY.equals(id) && source.isBuiltin()) {
                return createPiglinBarteringLootTableBuilder().build();
            }
            else {
                return original;
            }
        });
    }

    public static void init(){
        registerLootTableModifications();
    }


    public static LootTable.Builder createBastionTreasureChestTableBuilder() {
        return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(3.0F)).with(ItemEntry.builder(Items.NETHERITE_INGOT).weight(15).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Blocks.ANCIENT_DEBRIS).weight(10).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.NETHERITE_SCRAP).weight(8).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Blocks.ANCIENT_DEBRIS).weight(4).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0F)))).with(ItemEntry.builder(Items.DIAMOND_SWORD).weight(6).apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F, 1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).weight(6).apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F, 1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.DIAMOND_HELMET).weight(6).apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F, 1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.DIAMOND_LEGGINGS).weight(6).apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F, 1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.DIAMOND_BOOTS).weight(6).apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.8F, 1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.DIAMOND_SWORD).weight(6)).with(ItemEntry.builder(Items.DIAMOND_CHESTPLATE).weight(5)).with(ItemEntry.builder(Items.DIAMOND_HELMET).weight(5)).with(ItemEntry.builder(Items.DIAMOND_BOOTS).weight(5)).with(ItemEntry.builder(Items.DIAMOND_LEGGINGS).weight(5)).with(ItemEntry.builder(Items.DIAMOND).weight(5).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F)))).with(ItemEntry.builder(Items.ENCHANTED_GOLDEN_APPLE).weight(2).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))).pool(LootPool.builder().rolls(UniformLootNumberProvider.create(3.0F, 4.0F)).with(ItemEntry.builder(Items.SPECTRAL_ARROW).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(12.0F, 25.0F)))).with(ItemEntry.builder(Blocks.GOLD_BLOCK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))).with(ItemEntry.builder(PigsteelBlocks.PIGSTEEL_BLOCK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))).with(ItemEntry.builder(Items.GOLD_INGOT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 9.0F)))).with(ItemEntry.builder(PigsteelItems.PIGSTEEL_INGOT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 9.0F)))).with(ItemEntry.builder(Blocks.CRYING_OBSIDIAN).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 5.0F)))).with(ItemEntry.builder(Items.QUARTZ).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0F, 23.0F)))).with(ItemEntry.builder(Blocks.GILDED_BLACKSTONE).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5.0F, 15.0F)))).with(ItemEntry.builder(Items.MAGMA_CREAM).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 8.0F))))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(EmptyEntry.builder().weight(11)).with(ItemEntry.builder(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE).weight(1))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).weight(1)));
    }
    public static LootTable.Builder createBastionOtherChestTableBuilder() {
        return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(Items.DIAMOND_PICKAXE).weight(6).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.DIAMOND_SHOVEL).weight(6).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.CROSSBOW).weight(6).apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1F, 0.9F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.ANCIENT_DEBRIS).weight(12).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.NETHERITE_SCRAP).weight(4).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.SPECTRAL_ARROW).weight(10).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(10.0F, 22.0F)))).with(ItemEntry.builder(Items.PIGLIN_BANNER_PATTERN).weight(9).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.MUSIC_DISC_PIGSTEP).weight(5).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.GOLDEN_CARROT).weight(12).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0F, 17.0F)))).with(ItemEntry.builder(Items.GOLDEN_APPLE).weight(9).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.BOOK).weight(10).apply((new net.minecraft.loot.function.EnchantRandomlyLootFunction.Builder()).add(Enchantments.SOUL_SPEED)))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(2.0F)).with(ItemEntry.builder(Items.IRON_SWORD).weight(2).apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1F, 0.9F))).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(PigsteelBlocks.PIGSTEEL_BLOCK).weight(2).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.GOLDEN_BOOTS).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).apply((new net.minecraft.loot.function.EnchantRandomlyLootFunction.Builder()).add(Enchantments.SOUL_SPEED))).with(ItemEntry.builder(Items.GOLDEN_AXE).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Blocks.GOLD_BLOCK).weight(2).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.CROSSBOW).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.GOLD_INGOT).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 6.0F)))).with(ItemEntry.builder(PigsteelItems.PIGSTEEL_INGOT).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 6.0F)))).with(ItemEntry.builder(Items.GOLDEN_SWORD).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.GOLDEN_CHESTPLATE).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.GOLDEN_HELMET).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.GOLDEN_LEGGINGS).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.GOLDEN_BOOTS).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Blocks.CRYING_OBSIDIAN).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))))).pool(LootPool.builder().rolls(UniformLootNumberProvider.create(3.0F, 4.0F)).with(ItemEntry.builder(Blocks.GILDED_BLACKSTONE).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F)))).with(ItemEntry.builder(Blocks.CHAIN).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 10.0F)))).with(ItemEntry.builder(Items.MAGMA_CREAM).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F)))).with(ItemEntry.builder(Blocks.BONE_BLOCK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 6.0F)))).with(ItemEntry.builder(PigsteelItems.PIGSTEEL_NUGGET).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 8.0F)))).with(ItemEntry.builder(Blocks.OBSIDIAN).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 6.0F)))).with(ItemEntry.builder(Items.GOLD_NUGGET).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 8.0F)))).with(ItemEntry.builder(Items.STRING).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 6.0F)))).with(ItemEntry.builder(Items.ARROW).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5.0F, 17.0F)))).with(ItemEntry.builder(Items.COOKED_PORKCHOP).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(EmptyEntry.builder().weight(11)).with(ItemEntry.builder(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE).weight(1))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(EmptyEntry.builder().weight(9)).with(ItemEntry.builder(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).weight(1)));
    }
    public static LootTable.Builder createBastionBridgeChestTableBuilder() {
        return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(Blocks.LODESTONE).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))).pool(LootPool.builder().rolls(UniformLootNumberProvider.create(1.0F, 2.0F)).with(ItemEntry.builder(Items.CROSSBOW).apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.1F, 0.5F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.SPECTRAL_ARROW).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(10.0F, 28.0F)))).with(ItemEntry.builder(Blocks.GILDED_BLACKSTONE).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0F, 12.0F)))).with(ItemEntry.builder(Blocks.CRYING_OBSIDIAN).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 8.0F)))).with(ItemEntry.builder(Blocks.GOLD_BLOCK).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.GOLD_INGOT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 9.0F)))).with(ItemEntry.builder(PigsteelItems.PIGSTEEL_INGOT).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(4.0F, 9.0F)))).with(ItemEntry.builder(Items.GOLDEN_SWORD).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))).with(ItemEntry.builder(Items.GOLDEN_CHESTPLATE).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.GOLDEN_HELMET).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.GOLDEN_LEGGINGS).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.GOLDEN_BOOTS).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).apply(EnchantRandomlyLootFunction.builder())).with(ItemEntry.builder(Items.GOLDEN_AXE).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))).apply(EnchantRandomlyLootFunction.builder()))).pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2.0F, 4.0F)).with(ItemEntry.builder(Items.STRING).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 6.0F)))).with(ItemEntry.builder(Items.LEATHER).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))).with(ItemEntry.builder(Items.ARROW).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5.0F, 17.0F)))).with(ItemEntry.builder(PigsteelItems.PIGSTEEL_NUGGET).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F)))).with(ItemEntry.builder(Items.GOLD_NUGGET).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 6.0F))))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(EmptyEntry.builder().weight(11)).with(ItemEntry.builder(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE).weight(1))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(EmptyEntry.builder().weight(9)).with(ItemEntry.builder(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).weight(1)));
    }
    public static LootTable.Builder createNetherBridgeChestTableBuilder() {
        return LootTable.builder().pool(LootPool.builder().rolls(UniformLootNumberProvider.create(2.0F, 4.0F)).with(ItemEntry.builder(Items.DIAMOND).weight(5).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))).with(ItemEntry.builder(PigsteelItems.PIGSTEEL_INGOT).weight(5).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F)))).with(ItemEntry.builder(Items.GOLD_INGOT).weight(15).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))).with(ItemEntry.builder(Items.GOLDEN_SWORD).weight(5)).with(ItemEntry.builder(Items.GOLDEN_CHESTPLATE).weight(5)).with(ItemEntry.builder(Items.FLINT_AND_STEEL).weight(5)).with(ItemEntry.builder(Items.NETHER_WART).weight(5).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 7.0F)))).with(ItemEntry.builder(Items.SADDLE).weight(10)).with(ItemEntry.builder(Items.GOLDEN_HORSE_ARMOR).weight(8)).with(ItemEntry.builder(Items.IRON_HORSE_ARMOR).weight(5)).with(ItemEntry.builder(Items.DIAMOND_HORSE_ARMOR).weight(3)).with(ItemEntry.builder(Blocks.OBSIDIAN).weight(2).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F))))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(EmptyEntry.builder().weight(14)).with(ItemEntry.builder(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE).weight(1)));
    }
    public static LootTable.Builder createPiglinBarteringLootTableBuilder(){
        return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(Items.BOOK).weight(5).apply((new net.minecraft.loot.function.EnchantRandomlyLootFunction.Builder()).add(Enchantments.SOUL_SPEED))).with(ItemEntry.builder(Items.IRON_BOOTS).weight(8).apply((new net.minecraft.loot.function.EnchantRandomlyLootFunction.Builder()).add(Enchantments.SOUL_SPEED))).with(ItemEntry.builder(Items.POTION).weight(8).apply(SetPotionLootFunction.builder(Potions.FIRE_RESISTANCE))).with(ItemEntry.builder(Items.SPLASH_POTION).weight(8).apply(SetPotionLootFunction.builder(Potions.FIRE_RESISTANCE))).with(ItemEntry.builder(Items.POTION).weight(10).apply(SetPotionLootFunction.builder(Potions.WATER))).with(ItemEntry.builder(PigsteelItems.PIGSTEEL_NUGGET).weight(10).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(10.0F, 36.0F)))).with(ItemEntry.builder(Items.ENDER_PEARL).weight(10).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F)))).with(ItemEntry.builder(Items.STRING).weight(20).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0F, 9.0F)))).with(ItemEntry.builder(Items.QUARTZ).weight(20).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(5.0F, 12.0F)))).with(ItemEntry.builder(Items.OBSIDIAN).weight(40)).with(ItemEntry.builder(Items.CRYING_OBSIDIAN).weight(40).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))).with(ItemEntry.builder(Items.FIRE_CHARGE).weight(40)).with(ItemEntry.builder(Items.LEATHER).weight(40).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F)))).with(ItemEntry.builder(Items.SOUL_SAND).weight(40).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 8.0F)))).with(ItemEntry.builder(Items.NETHER_BRICK).weight(40).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 8.0F)))).with(ItemEntry.builder(Items.SPECTRAL_ARROW).weight(40).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(6.0F, 12.0F)))).with(ItemEntry.builder(Items.GRAVEL).weight(40).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0F, 16.0F)))).with(ItemEntry.builder(Items.BLACKSTONE).weight(40).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(8.0F, 16.0F)))));
    }

}
