package com.gumillea.berrfect.core.reg;

import com.gumillea.berrfect.Berrfect;
import com.gumillea.berrfect.common.item.BerrfectDrinkItem;
import com.gumillea.berrfect.common.item.BerrfectPipsItem;
import com.gumillea.berrfect.common.item.BlueberryJamRollItem;
import com.gumillea.berrfect.core.util.ModCompat;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Berrfect.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BerrfectItems {
    public static final ItemSubRegistryHelper HELPER = Berrfect.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> BLUEBERRY_PIPS = HELPER.createItem("blueberry_pips", () -> new BerrfectPipsItem(ModCompat.BLUEBERRIES_BUSH, new Item.Properties().tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> CRIMSON_BERRY_PIPS = HELPER.createItem("crimson_berry_pips", () -> new BerrfectPipsItem(ModCompat.CRIMSON_BERRY_BUSH, new Item.Properties().tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> NIGHTSHADE_BERRY_PIPS = HELPER.createItem("nightshade_berry_pips", () -> new BerrfectPipsItem(ModCompat.NIGHTSHADE_BERRY_BUSH, new Item.Properties().tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> SOURCEBERRY_PIPS = HELPER.createItem("sourceberry_pips", () -> new BerrfectPipsItem(ModCompat.SOURCEBERRY_BUSH, new Item.Properties().tab(ModCompat.AN_ITEM)));

    public static final RegistryObject<Item> BLUEBERRY_JAM_BOTTLE = HELPER.createItem("blueberry_jam_bottle", () -> new BerrfectDrinkItem(new Item.Properties().food(BerrfectFoods.BLUEBERRY_JAM_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> BLUEBERRY_JAM_ROLL = HELPER.createItem("blueberry_jam_roll", () -> new BlueberryJamRollItem(new Item.Properties().food(BerrfectFoods.BLUEBERRY_JAM_ROLL).tab(CreativeModeTab.TAB_FOOD)));
    public static final RegistryObject<Item> EMBUR_PUDDING = HELPER.createItem("embur_pudding", () -> new BowlFoodItem(new Item.Properties().food(BerrfectFoods.EMBUR_PUDDING).stacksTo(1).tab(CreativeModeTab.TAB_FOOD)));

    static class BerrfectFoods {
        public static final FoodProperties BLUEBERRY_JAM_BOTTLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).alwaysEat().build();
        public static final FoodProperties BLUEBERRY_JAM_ROLL = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
        public static final FoodProperties EMBUR_PUDDING = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400), 1.0F).build();
    }
}
