package dev.stl.railroads;

import dev.stl.railroads.misc.CreativeTab;
import dev.stl.railroads.registry.Blocks;
import dev.stl.railroads.registry.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Railroads.MOD_ID)
@Mod.EventBusSubscriber(modid = Railroads.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Railroads {

    public static final String MOD_ID = "railroads";

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger("Railroads");

    public Railroads() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        Blocks.register(bus);
        Items.register(bus);
        CreativeTab.register(bus);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

}