package dev.stl.rails.registry;

import dev.stl.rails.RailsMod;
import dev.stl.rails.blocks.CrossRail;
import dev.stl.rails.blocks.ParallelRail;
import dev.stl.rails.blocks.SwitchRail;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RailsMod.modid);

    public static final RegistryObject<Block> SWITCH_RAIL_BLOCK = BLOCKS.register("switch_rail", () -> new SwitchRail(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.7F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> PARALLEL_RAIL_BLOCK = BLOCKS.register("parallel_rail", () -> new ParallelRail(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.7F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> CROSS_RAIL_BLOCK = BLOCKS.register("cross_rail", () -> new CrossRail(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.7F).sound(SoundType.METAL)));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

}