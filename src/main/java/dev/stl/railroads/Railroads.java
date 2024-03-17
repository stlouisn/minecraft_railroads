package dev.stl.railroads;

import dev.stl.railroads.misc.CreativeTab;
import dev.stl.railroads.registry.Blocks;
import dev.stl.railroads.registry.Items;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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

        MinecraftForge.EVENT_BUS.register(this);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        Blocks.register(bus);
        Items.register(bus);

        RegHelper.addItemsToTabsRegistration(CreativeTab::addCreativeTabItems);

    }

}