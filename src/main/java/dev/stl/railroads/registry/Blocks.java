package dev.stl.railroads.registry;

import dev.stl.railroads.Railroads;
import dev.stl.railroads.blocks.CrossRailBlock;
import dev.stl.railroads.blocks.ParallelRailBlock;
import dev.stl.railroads.blocks.SwitchRailBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Railroads.MOD_ID);

    @SuppressWarnings("unused")
    public static final RegistryObject<Block> SWITCH_RAIL_BLOCK = BLOCKS.register("switch_rail", () ->
            new SwitchRailBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.7F).sound(SoundType.METAL)));

    @SuppressWarnings("unused")
    public static final RegistryObject<Block> PARALLEL_RAIL_BLOCK = BLOCKS.register("parallel_rail", () ->
            new ParallelRailBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.7F).sound(SoundType.METAL)));

    @SuppressWarnings("unused")
    public static final RegistryObject<Block> CROSS_RAIL_BLOCK = BLOCKS.register("cross_rail", () ->
            new CrossRailBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).noCollission().strength(0.7F).sound(SoundType.METAL)));

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

}