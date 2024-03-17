package dev.stl.railroads.misc;

import dev.stl.railroads.registry.Items;
import net.mehvahdjukaar.moonlight.api.platform.RegHelper;
import net.minecraft.world.item.*;

public class CreativeTab {

    public static void addCreativeTabItems(RegHelper.ItemToTabEvent event) {

        // TOOLS AND UTILITIES TAB

        event.addAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, i -> i.is(net.minecraft.world.item.Items.RAIL),
                Items.CROSS_RAIL_ITEM.get());

        event.addAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, i -> i.is(net.minecraft.world.item.Items.RAIL),
                Items.SWITCH_RAIL_ITEM.get());

        // REDSTONE BLOCKS TAB

        event.addAfter(CreativeModeTabs.REDSTONE_BLOCKS, i -> i.is(net.minecraft.world.item.Items.RAIL),
                Items.CROSS_RAIL_ITEM.get());

        event.addAfter(CreativeModeTabs.REDSTONE_BLOCKS, i -> i.is(net.minecraft.world.item.Items.RAIL),
                Items.SWITCH_RAIL_ITEM.get());

    }

}