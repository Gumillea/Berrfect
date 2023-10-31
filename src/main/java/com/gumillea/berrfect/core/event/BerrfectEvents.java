package com.gumillea.berrfect.core.event;

import com.gumillea.berrfect.Berrfect;
import com.gumillea.berrfect.BerrfectConfig.Common;
import com.gumillea.berrfect.core.reg.BerrfectItems;
import com.gumillea.berrfect.core.util.ModCompat;
import com.hollingsworth.arsnouveau.setup.BlockRegistry;
import com.teamabnormals.blueprint.core.util.TradeUtil;
import com.teamabnormals.blueprint.core.util.TradeUtil.BlueprintTrade;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Berrfect.MODID)
public class BerrfectEvents {

    @SubscribeEvent
    public static void rightClickBlock(RightClickBlock event) {
        ItemStack stack = event.getItemStack();

        if (ModList.get().isLoaded(ModCompat.AN) && (Common.AN_MODIFICATION.get())) {
            if (stack.is(BlockRegistry.SOURCEBERRY_BUSH.asItem())){
                event.setUseItem(Event.Result.DENY);
            }
        }

        if (ModList.get().isLoaded("byg") && (Common.BYG_MODIFICATION.get())) {
            if (stack.is(ModCompat.BLUEBERRIES) || stack.is(ModCompat.CRIMSON_BERRIES) || stack.is(ModCompat.NIGHTSHADE_BERRIES)){
                event.setUseItem(Event.Result.DENY);
            }
        }

        if (ModList.get().isLoaded(ModCompat.UG) && (Common.UG_MODIFICATION.get())) {
            if (stack.is(ModCompat.BLISTERBERRY) || stack.is(ModCompat.DROOPFRUIT)){
                event.setUseItem(Event.Result.DENY);
            }
        }

    }


    @SubscribeEvent
    public static void onWandererTradesEvent(WandererTradesEvent event) {
        if (ModList.get().isLoaded(ModCompat.AN)) {
            TradeUtil.addWandererTrades(event,
                    new BlueprintTrade(1, BerrfectItems.SOURCEBERRY_PIPS.get(), 1, 12, 1)
            );
        }

        if (ModList.get().isLoaded("byg")) {
            TradeUtil.addWandererTrades(event,
                    new BlueprintTrade(1, BerrfectItems.BLUEBERRY_PIPS.get(), 1, 12, 1)
            );
            TradeUtil.addRareWandererTrades(event,
                    new BlueprintTrade(1, BerrfectItems.CRIMSON_BERRY_PIPS.get(), 1, 12, 1),
                    new BlueprintTrade(1, BerrfectItems.NIGHTSHADE_BERRY_PIPS.get(), 1, 12, 1)
            );
        }

    }


}
