package com.gumillea.berrfect.core.loot;

import com.gumillea.berrfect.Berrfect;
import com.gumillea.berrfect.core.util.ModCompat;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BerrfectLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Berrfect.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_BYG_PIPS_ITEM =
            ModList.get().isLoaded(ModCompat.B) ? LOOT_MODIFIER_SERIALIZERS.register("add_byg_pips_item", BYGPipsItemModifier.CODEC) : null;

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_AN_PIPS_ITEM =
            ModList.get().isLoaded(ModCompat.AN) ? LOOT_MODIFIER_SERIALIZERS.register("add_an_pips_item", ANPipsItemModifier.CODEC) : null;
}
