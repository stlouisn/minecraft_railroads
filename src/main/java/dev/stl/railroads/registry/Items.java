package dev.stl.railroads.registry;

import dev.stl.railroads.Railroads;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Railroads.MOD_ID);

    public static Item.Properties modItem() {
        return new Item.Properties();
    }

    @SuppressWarnings("unused")
    public static final RegistryObject<Item> SWITCH_RAIL_ITEM = ITEMS.register("switch_rail", () ->
            new BlockItem(Blocks.SWITCH_RAIL_BLOCK.get(), modItem()));

    @SuppressWarnings("unused")
    public static final RegistryObject<Item> PARALLEL_RAIL_ITEM = ITEMS.register("parallel_rail", () ->
            new BlockItem(Blocks.PARALLEL_RAIL_BLOCK.get(), modItem()));

    @SuppressWarnings("unused")
    public static final RegistryObject<Item> CROSS_RAIL_ITEM = ITEMS.register("cross_rail", () ->
            new BlockItem(Blocks.CROSS_RAIL_BLOCK.get(), modItem()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

}