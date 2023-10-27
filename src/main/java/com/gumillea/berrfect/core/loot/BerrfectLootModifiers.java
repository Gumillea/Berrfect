package com.gumillea.berrfect.core.loot;

import com.gumillea.berrfect.Berrfect;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BerrfectLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Berrfect.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_PIPS_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_pips_item", PipsItemModifier.CODEC);
}
