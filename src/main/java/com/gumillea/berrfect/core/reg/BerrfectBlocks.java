package com.gumillea.berrfect.core.reg;

import com.gumillea.berrfect.Berrfect;
import com.gumillea.berrfect.common.block.BlueberryJamBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Berrfect.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BerrfectBlocks {
    public static final BlockSubRegistryHelper HELPER = Berrfect.REGISTRY_HELPER.getBlockSubHelper();
    public static final RegistryObject<Block> BLUEBERRY_JAM_BLOCK = HELPER.createBlock("blueberry_jam_block", () -> new BlueberryJamBlock(Properties.BLUEBERRY_JAM_BLOCK), (CreativeModeTab.TAB_DECORATIONS));

    static class Properties {
        public static final BlockBehaviour.Properties BLUEBERRY_JAM_BLOCK = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).instabreak().noCollission().noOcclusion().sound(SoundType.HONEY_BLOCK);
    }

}
