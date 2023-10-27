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
                BerrfectItems.CRIMSON_BERRY_PIPS.get(),
                BerrfectItems.NIGHTSHADE_BERRY_PIPS.get(),
                BerrfectItems.SOURCEBERRY_PIPS.get()
        );
    }

    private static void registerCompostableItems() {
        DataUtil.registerCompostable(BerrfectBlocks.BLUEBERRY_JAM_BLOCK.get(), 1.0F);

        DataUtil.registerCompostable(BerrfectItems.BLUEBERRY_JAM_ROLL.get(), 0.85F);

        DataUtil.registerCompostable(BerrfectItems.BLUEBERRY_PIPS.get(), 0.30F);
        DataUtil.registerCompostable(BerrfectItems.CRIMSON_BERRY_PIPS.get(), 0.30F);
        DataUtil.registerCompostable(BerrfectItems.NIGHTSHADE_BERRY_PIPS.get(), 0.30F);
        DataUtil.registerCompostable(BerrfectItems.SOURCEBERRY_PIPS.get(), 0.30F);
    }
}
