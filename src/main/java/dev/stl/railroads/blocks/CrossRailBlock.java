package dev.stl.railroads.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.phys.Vec3;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CrossRailBlock extends BaseRailBlock {

    public static final Property<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE_STRAIGHT;

    public CrossRailBlock(Properties builder) {
        super(false, builder);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, WATERLOGGED);
    }

    @Override
    public boolean canMakeSlopes(BlockState state, BlockGetter world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isFlexibleRail(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos) {
        return false;
    }

    @Override
    public @NotNull Property<RailShape> getShapeProperty() {
        return SHAPE;
    }

    @Override
    public @NotNull RailShape getRailDirection(@NotNull BlockState state, @NotNull BlockGetter world, @NotNull BlockPos pos, @Nullable AbstractMinecart cart) {
        if (cart == null) return RailShape.NORTH_SOUTH;

        Vec3 movement = cart.getDeltaMovement();
        if (Math.abs(movement.x) > Math.abs(movement.z)) return RailShape.EAST_WEST;
        else return RailShape.NORTH_SOUTH;
    }

}