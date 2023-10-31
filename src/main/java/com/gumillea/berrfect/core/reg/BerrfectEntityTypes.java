package com.gumillea.berrfect.core.reg;

import com.gumillea.berrfect.Berrfect;
import com.gumillea.berrfect.common.entity.RottenPie;
import com.teamabnormals.blueprint.core.util.registry.EntitySubRegistryHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Berrfect.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BerrfectEntityTypes {
    public static final EntitySubRegistryHelper HELPER = Berrfect.REGISTRY_HELPER.getEntitySubHelper();
    public static final RegistryObject<EntityType<RottenPie>> ROTTEN_PIE = HELPER.createEntity("rotten_pie", RottenPie::new, RottenPie::new, MobCategory.MISC, 0.25F, 0.25F);


}
