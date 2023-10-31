package com.gumillea.berrfect.core.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import potionstudios.byg.common.item.BYGCreativeTab;
import quek.undergarden.registry.UGBlocks;
import quek.undergarden.registry.UGCreativeModeTabs;

public class ModCompat {
    public static final String AN = "ars_nouveau";
    public static final String B = "byg";
    public static final String UG = "undergarden";

    //Resource Locations
    public static Item BLUEBERRIES = ForgeRegistries.ITEMS.getValue(new ResourceLocation(B, "blueberries"));
    public static Item BLISTERBERRY = ForgeRegistries.ITEMS.getValue(new ResourceLocation(UG, "blisterberry"));
    public static Item CRIMSON_BERRIES = ForgeRegistries.ITEMS.getValue(new ResourceLocation(B, "crimson_berries"));
    public static Item DROOPFRUIT = ForgeRegistries.ITEMS.getValue(new ResourceLocation(UG, "droopvine_item"));
    public static Item NIGHTSHADE_BERRIES = ForgeRegistries.ITEMS.getValue(new ResourceLocation(B, "nightshade_berries"));

    public static Block BLUEBERRIES_BUSH = ModList.get().isLoaded(ModCompat.B) ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(B, "blueberry_bush")) : Blocks.SWEET_BERRY_BUSH;
    public static Block BLISTERBERRY_BUSH = ModList.get().isLoaded(ModCompat.UG) ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(UG, "blisterberry_bush")) : Blocks.SWEET_BERRY_BUSH;
    public static Block CRIMSON_BERRY_BUSH = ModList.get().isLoaded(ModCompat.B) ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(B, "crimson_berry_bush")) : Blocks.SWEET_BERRY_BUSH;
    public static Block DROOP_VINE = ModList.get().isLoaded(ModCompat.UG) ? UGBlocks.DROOPVINE.get() : Blocks.CAVE_VINES;
    public static Block NIGHTSHADE_BERRY_BUSH = ModList.get().isLoaded(ModCompat.B) ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(B, "nightshade_berry_bush")) : Blocks.SWEET_BERRY_BUSH;
    public static Block SOURCEBERRY_BUSH = ModList.get().isLoaded(ModCompat.AN) ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(AN, "sourceberry_bush")) : Blocks.SWEET_BERRY_BUSH;

    //Tabs
    public static final CreativeModeTab AN_PIPS = ((ModList.get().isLoaded(AN)) ? (CreativeModeTab.TAB_MISC) : null);

    public static final CreativeModeTab BYG_ITEM = ((ModList.get().isLoaded(B)) ? (CreativeModeTab.TAB_MISC) : null);
    public static final CreativeModeTab BYG_MISC = ((ModList.get().isLoaded(AN)) ? (BYGCreativeTab.CREATIVE_TAB) : null);

    public static final CreativeModeTab UG_PIPS = ((ModList.get().isLoaded(UG)) ? (CreativeModeTab.TAB_MISC) : null);
    public static final CreativeModeTab UG_MISC = ((ModList.get().isLoaded(UG)) ? (UGCreativeModeTabs.GROUP) : null);
}

