package dev.stl.rails;

import dev.stl.rails.misc.CreativeTab;
import dev.stl.rails.registry.Blocks;
import dev.stl.rails.registry.Items;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("rails")
@Mod.EventBusSubscriber(modid = RailsMod.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RailsMod {

    public static final String modid = "rails";

    public static Logger LOGGER = LogManager.getLogger();

    public RailsMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        Blocks.register(bus);
        Items.register(bus);
        CreativeTab.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(
                () -> {
                    RenderType cutout = RenderType.cutout();
                    ItemBlockRenderTypes.setRenderLayer(Blocks.SWITCH_RAIL_BLOCK.get(), cutout);
                    ItemBlockRenderTypes.setRenderLayer(Blocks.PARALLEL_RAIL_BLOCK.get(), cutout);
                    ItemBlockRenderTypes.setRenderLayer(Blocks.CROSS_RAIL_BLOCK.get(), cutout);
                }
        );
    }
}