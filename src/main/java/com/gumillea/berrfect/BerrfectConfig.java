package com.gumillea.berrfect;

import com.teamabnormals.blueprint.core.annotations.ConfigKey;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class BerrfectConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class Common {

        @ConfigKey("enable_ars_nouveau_modification")
        public static ForgeConfigSpec.BooleanValue AN_MODIFICATION;
        @ConfigKey("enable_byg_modification")
        public static ForgeConfigSpec.BooleanValue BYG_MODIFICATION;

        Common(ForgeConfigSpec.Builder builder) {
            builder.push("Modifications");
            AN_MODIFICATION = builder.comment("Whether to enable the berry modifications for Ars Nouveau.").define("Ars Nouveau modification", true);
            BYG_MODIFICATION = builder.comment("Whether to enable the berry modifications for Oh The Biomes You'll Go.").define("BYG modification", true);
        }
    }

}
