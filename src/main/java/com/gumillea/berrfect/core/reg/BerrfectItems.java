package com.gumillea.berrfect.core.reg;

import com.gumillea.berrfect.Berrfect;
import com.gumillea.berrfect.common.item.BerrfectDrinkItem;
import com.gumillea.berrfect.common.item.RottenPieItem;
import com.gumillea.berrfect.common.item.SourceBerryPipsItem;
import com.gumillea.berrfect.common.item.BlueberryJamRollItem;
import com.gumillea.berrfect.core.util.ModCompat;
import com.teamabnormals.berry_good.common.item.BerryPipsBlockItem;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Berrfect.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BerrfectItems {
    public static final ItemSubRegistryHelper HELPER = Berrfect.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> BLUEBERRY_PIPS = HELPER.createItem("blueberry_pips", () -> new BerryPipsBlockItem(ModCompat.BLUEBERRIES_BUSH, new Item.Properties().tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> BLUEBERRY_JAM_BOTTLE = HELPER.createItem("blueberry_jam_bottle", () -> new BerrfectDrinkItem(new Item.Properties().food(BerrfectFoods.BLUEBERRY_JAM_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(ModCompat.BYG_MISC)));
    public static final RegistryObject<Item> BLUEBERRY_JAM_ROLL = HELPER.createItem("blueberry_jam_roll", () -> new BlueberryJamRollItem(new Item.Properties().food(BerrfectFoods.BLUEBERRY_JAM_ROLL).tab(ModCompat.BYG_MISC)));

    public static final RegistryObject<Item> BLISTERBERRY_PIPS = HELPER.createItem("blisterberry_pips", () -> new BerryPipsBlockItem(ModCompat.BLISTERBERRY_BUSH, new Item.Properties().tab(ModCompat.UG_PIPS)));
    public static final RegistryObject<Item> BLISTERBERRY_PIE = HELPER.createItem("blisterberry_pie", () -> new Item(new Item.Properties().food(BerrfectFoods.BLISTERBERRY_PIE).tab(ModCompat.UG_MISC)));
    public static final RegistryObject<Item> ROTTEN_BLISTERBERRY_PIE = HELPER.createItem("rotten_blisterberry_pie", () -> new RottenPieItem(new Item.Properties().food(BerrfectFoods.BLISTERBERRY_PIE).tab(ModCompat.UG_MISC)));

    public static final RegistryObject<Item> CRIMSON_BERRY_PIPS = HELPER.createItem("crimson_berry_pips", () -> new BerryPipsBlockItem(ModCompat.CRIMSON_BERRY_BUSH, new Item.Properties().tab(ModCompat.BYG_ITEM)));
    public static final RegistryObject<Item> EMBUR_PUDDING = HELPER.createItem("embur_pudding", () -> new BowlFoodItem(new Item.Properties().food(BerrfectFoods.EMBUR_PUDDING).stacksTo(1).tab(ModCompat.BYG_MISC)));

    public static final RegistryObject<Item> DROOPFRUIT_PIPS = HELPER.createItem("droopfruit_pips", () -> new BerryPipsBlockItem(ModCompat.DROOP_VINE, new Item.Properties().tab(ModCompat.UG_PIPS)));
    public static final RegistryObject<Item> RAINDROOP_CAKE = HELPER.createItem("raindroop_cake", () -> new Item(new Item.Properties().food(BerrfectFoods.RAINDROOP_CAKE).tab(ModCompat.UG_MISC)));

    public static final RegistryObject<Item> NIGHTSHADE_BERRY_PIPS = HELPER.createItem("nightshade_berry_pips", () -> new BerryPipsBlockItem(ModCompat.NIGHTSHADE_BERRY_BUSH, new Item.Properties().tab(ModCompat.BYG_ITEM)));

    public static final RegistryObject<Item> SOURCEBERRY_PIPS = HELPER.createItem("sourceberry_pips", () -> new SourceBerryPipsItem(ModCompat.SOURCEBERRY_BUSH, new Item.Properties().tab(ModCompat.AN_PIPS)));

    static class BerrfectFoods {
        public static final FoodProperties BLUEBERRY_JAM_BOTTLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.1F).alwaysEat().build();
        public static final FoodProperties BLUEBERRY_JAM_ROLL = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
        public static final FoodProperties BLISTERBERRY_PIE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
        public static final FoodProperties RAINDROOP_CAKE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 1200), 1.0F).build();
        public static final FoodProperties EMBUR_PUDDING = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400), 1.0F).build();
    }
}
