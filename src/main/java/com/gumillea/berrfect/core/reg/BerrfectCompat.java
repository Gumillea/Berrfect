package com.gumillea.berrfect.core.reg;

import com.teamabnormals.blueprint.core.util.DataUtil;

public class BerrfectCompat {

    public static void registerCompat() {
        registerAnimalFoods();
        registerCompostableItems();
    }

    private static void registerAnimalFoods() {
        DataUtil.addParrotFood(
                BerrfectItems.BLUEBERRY_PIPS.get(),
                BerrfectItems.BLISTERBERRY_PIE.get(),
                BerrfectItems.CRIMSON_BERRY_PIPS.get(),
                BerrfectItems.DROOPFRUIT_PIPS.get(),
                BerrfectItems.NIGHTSHADE_BERRY_PIPS.get(),
                BerrfectItems.SOURCEBERRY_PIPS.get()
        );
    }

    private static void registerCompostableItems() {
        DataUtil.registerCompostable(BerrfectBlocks.BLUEBERRY_JAM_BLOCK.get(), 1.0F);

        DataUtil.registerCompostable(BerrfectItems.BLUEBERRY_JAM_ROLL.get(), 0.85F);
        DataUtil.registerCompostable(BerrfectItems.BLISTERBERRY_PIE.get(), 0.85F);

        DataUtil.registerCompostable(BerrfectItems.RAINDROOP_CAKE.get(), 0.5F);

        DataUtil.registerCompostable(BerrfectItems.BLUEBERRY_PIPS.get(), 0.3F);
        DataUtil.registerCompostable(BerrfectItems.CRIMSON_BERRY_PIPS.get(), 0.3F);
        DataUtil.registerCompostable(BerrfectItems.NIGHTSHADE_BERRY_PIPS.get(), 0.3F);
        DataUtil.registerCompostable(BerrfectItems.SOURCEBERRY_PIPS.get(), 0.3F);

        DataUtil.registerCompostable(BerrfectItems.BLISTERBERRY_PIPS.get(), 0.1F);
        DataUtil.registerCompostable(BerrfectItems.DROOPFRUIT_PIPS.get(), 0.1F);
    }
}
