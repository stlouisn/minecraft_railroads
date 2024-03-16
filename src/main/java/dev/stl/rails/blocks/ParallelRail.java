package dev.stl.rails.blocks;

import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RailShape;
import org.jetbrains.annotations.NotNull;

public class ParallelRail extends BaseRailBlock {

    public static final EnumProperty<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE_STRAIGHT;

    public ParallelRail(Properties builder) {
        super(true, builder);
        this.registerDefaultState(defaultBlockState().setValue(SHAPE, RailShape.NORTH_SOUTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, WATERLOGGED);
    }

    public @NotNull BlockState rotate(@NotNull BlockState state, Rotation rot) {
        switch(rot) {
            case CLOCKWISE_180:
                switch(state.getValue(SHAPE)) {
                    case ASCENDING_EAST:
                        return state.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case ASCENDING_WEST:
                        return state.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case ASCENDING_NORTH:
                        return state.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    case ASCENDING_SOUTH:
                        return state.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    case SOUTH_EAST:
                        return state.setValue(SHAPE, RailShape.NORTH_WEST);
                    case SOUTH_WEST:
                        return state.setValue(SHAPE, RailShape.NORTH_EAST);
                    case NORTH_WEST:
                        return state.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_EAST:
                        return state.setValue(SHAPE, RailShape.SOUTH_WEST);
                }
            case COUNTERCLOCKWISE_90:
                return switch (state.getValue(SHAPE)) {
                    case ASCENDING_EAST -> state.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    case ASCENDING_WEST -> state.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    case ASCENDING_NORTH -> state.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case ASCENDING_SOUTH -> state.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case SOUTH_EAST -> state.setValue(SHAPE, RailShape.NORTH_EAST);
                    case SOUTH_WEST -> state.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_WEST -> state.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case NORTH_EAST -> state.setValue(SHAPE, RailShape.NORTH_WEST);
                    case NORTH_SOUTH -> state.setValue(SHAPE, RailShape.EAST_WEST);
                    case EAST_WEST -> state.setValue(SHAPE, RailShape.NORTH_SOUTH);
                };
            case CLOCKWISE_90:
                return switch (state.getValue(SHAPE)) {
                    case ASCENDING_EAST -> state.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    case ASCENDING_WEST -> state.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    case ASCENDING_NORTH -> state.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case ASCENDING_SOUTH -> state.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case SOUTH_EAST -> state.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case SOUTH_WEST -> state.setValue(SHAPE, RailShape.NORTH_WEST);
                    case NORTH_WEST -> state.setValue(SHAPE, RailShape.NORTH_EAST);
                    case NORTH_EAST -> state.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_SOUTH -> state.setValue(SHAPE, RailShape.EAST_WEST);
                    case EAST_WEST -> state.setValue(SHAPE, RailShape.NORTH_SOUTH);
                };
            default:
                return state;
        }
    }

    public @NotNull BlockState mirror(BlockState state, Mirror mirrorIn) {
        RailShape railshape = state.getValue(SHAPE);
        switch(mirrorIn) {
            case LEFT_RIGHT:
                return switch (railshape) {
                    case ASCENDING_NORTH -> state.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    case ASCENDING_SOUTH -> state.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    case SOUTH_EAST -> state.setValue(SHAPE, RailShape.NORTH_EAST);
                    case SOUTH_WEST -> state.setValue(SHAPE, RailShape.NORTH_WEST);
                    case NORTH_WEST -> state.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case NORTH_EAST -> state.setValue(SHAPE, RailShape.SOUTH_EAST);
                    default -> super.mirror(state, mirrorIn);
                };
            case FRONT_BACK:
                switch(railshape) {
                    case ASCENDING_EAST:
                        return state.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case ASCENDING_WEST:
                        return state.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case ASCENDING_NORTH:
                    case ASCENDING_SOUTH:
                    case SOUTH_EAST:
                        return state.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case SOUTH_WEST:
                        return state.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_WEST:
                        return state.setValue(SHAPE, RailShape.NORTH_EAST);
                    case NORTH_EAST:
                        return state.setValue(SHAPE, RailShape.NORTH_WEST);
                    default:
                        break;
                }
        }
        return super.mirror(state, mirrorIn);
    }

    @Override
    public @NotNull Property<RailShape> getShapeProperty() { return SHAPE; }
}