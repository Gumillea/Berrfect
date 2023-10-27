package com.gumillea.berrfect.core.data.tags;

import com.gumillea.berrfect.Berrfect;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BerrfectBlockTagsProvider  extends BlockTagsProvider {
    public BerrfectBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Berrfect.MODID, existingFileHelper);
    }

    @Override
    public void addTags() {

    }
}
