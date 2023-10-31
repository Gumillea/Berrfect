package com.gumillea.berrfect.core.data.tags;

import com.gumillea.berrfect.Berrfect;
import com.gumillea.berrfect.core.reg.BerrfectItems;
import com.gumillea.berrfect.core.util.BerrfectItemTags;
import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BerrfectItemTagsProvider extends ItemTagsProvider {
    public BerrfectItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(generator, blockTags, Berrfect.MODID, existingFileHelper);
    }
    @Override
    public void addTags() {
        this.tag(BlueprintItemTags.CHICKEN_FOOD).add(
                BerrfectItems.BLUEBERRY_PIPS.get(),
                BerrfectItems.BLISTERBERRY_PIPS.get(),
                BerrfectItems.CRIMSON_BERRY_PIPS.get(),
                BerrfectItems.DROOPFRUIT_PIPS.get(),
                BerrfectItems.NIGHTSHADE_BERRY_PIPS.get(),
                BerrfectItems.SOURCEBERRY_PIPS.get()
        );
        this.tag(BerrfectItemTags.FRUITS_BLUEBERRY)
                .addOptional(new ResourceLocation("byg", "blueberries"))
                .addOptional(new ResourceLocation("aether", "blue_berry")
        );
        this.tag(BerrfectItemTags.JAM).add(
                BerrfectItems.BLUEBERRY_JAM_BOTTLE.get()
        );
        this.tag(Tags.Items.SEEDS).add(
                BerrfectItems.BLUEBERRY_PIPS.get(),
                BerrfectItems.BLISTERBERRY_PIPS.get(),
                BerrfectItems.CRIMSON_BERRY_PIPS.get(),
                BerrfectItems.DROOPFRUIT_PIPS.get(),
                BerrfectItems.NIGHTSHADE_BERRY_PIPS.get(),
                BerrfectItems.SOURCEBERRY_PIPS.get()
        );
    }
}

