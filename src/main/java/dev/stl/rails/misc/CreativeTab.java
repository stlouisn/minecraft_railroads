package dev.stl.rails.misc;

import dev.stl.rails.RailsMod;
import dev.stl.rails.registry.Items;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTab {

    public static final ResourceLocation BASE_TAB_ID = new ResourceLocation(RailsMod.modid, "base");

    private static class DisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

        @Override
        public void accept(CreativeModeTab.@NotNull ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
            output.acceptAll(
                    Items.ITEMS.getEntries().stream().map(
                            (obj) -> new ItemStack( obj.get() )
                    ).collect(Collectors.toList()));
            output.accept(new ItemStack( Items.CROSS_RAIL_ITEM.get()));
        }
    }

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RailsMod.modid);

    public static final RegistryObject<CreativeModeTab> tab = TABS.register("rails_tab", () ->
           CreativeModeTab.builder()
                   .icon(() -> new ItemStack(Items.CROSS_RAIL_ITEM.get()))
                   .title(Component.translatable("itemGroup.rails"))
                   .displayItems(new DisplayItemsGenerator())
                   .build());

    public static void register(IEventBus bus) {
        TABS.register(bus);
    }
}