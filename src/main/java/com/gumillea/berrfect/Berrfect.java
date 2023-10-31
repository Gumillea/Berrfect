package com.gumillea.berrfect;

import com.gumillea.berrfect.core.loot.BerrfectLootModifiers;
import com.gumillea.berrfect.core.data.tags.BerrfectBlockTagsProvider;
import com.gumillea.berrfect.core.data.tags.BerrfectItemTagsProvider;
import com.gumillea.berrfect.core.reg.BerrfectCompat;
import com.gumillea.berrfect.core.reg.BerrfectEntityTypes;
import com.gumillea.berrfect.core.reg.BerrfectItems;
import com.gumillea.berrfect.core.reg.BerrfectLootConditions;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Berrfect.MODID)
@Mod.EventBusSubscriber(modid = Berrfect.MODID)
public class Berrfect {
        public static final String MODID = "berrfect";
        public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

        public Berrfect()
        {
                IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
                ModLoadingContext context = ModLoadingContext.get();
                MinecraftForge.EVENT_BUS.register(this);

                REGISTRY_HELPER.register(modEventBus);
                BerrfectLootConditions.LOOT_CONDITION_TYPES.register(modEventBus);
                BerrfectLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);

                modEventBus.addListener(this::commonSetup);
                modEventBus.addListener(this::gatherData);

                context.registerConfig(ModConfig.Type.COMMON, BerrfectConfig.COMMON_SPEC);

                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                        modEventBus.addListener(this::registerRenderers);
                });
        }

        private void commonSetup(final FMLCommonSetupEvent event) {
                BerrfectCompat.registerCompat();
        }

        private void gatherData(GatherDataEvent event) {
                DataGenerator generator = event.getGenerator();
                ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

                boolean includeServer = event.includeServer();
                BerrfectBlockTagsProvider blockTagsProvider = new BerrfectBlockTagsProvider(generator, existingFileHelper);
                generator.addProvider(includeServer, blockTagsProvider);
                generator.addProvider(includeServer, new BerrfectItemTagsProvider(generator, blockTagsProvider, existingFileHelper));
        }

        @OnlyIn(Dist.CLIENT)
        private void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
                event.registerEntityRenderer(BerrfectEntityTypes.ROTTEN_PIE.get(), ThrownItemRenderer::new);
        }

}
