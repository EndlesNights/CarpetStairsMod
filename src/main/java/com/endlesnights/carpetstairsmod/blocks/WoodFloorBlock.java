package com.endlesnights.carpetstairsmod.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class WoodFloorBlock extends Block
{
	public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
	   
	protected static final VoxelShape SHAPE_FLOOR = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	protected static final VoxelShape SHAPE_SLAB = Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	
	public enum WoodType
	{
		ACACIA(),
		BIRCH(),
		JUNGLE(),
		SPRUCE(),
		OAK(),
		DARK_OAK();
	}
	
	private final WoodType wood;
	
	public WoodFloorBlock(WoodType woodtype, Properties properties)
	{
		super(properties);
		this.setDefaultState(this.getDefaultState().with(HALF, Half.BOTTOM));
		this.wood = woodtype;
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(HALF);
	}
	
	public WoodType getWoodType()
	{
		return this.wood;
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		if(state.get(HALF) == Half.TOP)
			return SHAPE_SLAB;
		else
			return SHAPE_FLOOR;
	}
	
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		if(state.get(HALF) == Half.TOP)
			return Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 16.0D, -7.0D, 16.0D);
		else
			return SHAPE_FLOOR;
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
	{
		return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
	{
		if(state.get(HALF) == Half.BOTTOM)
			return !worldIn.isAirBlock(pos.down());
		
		return worldIn.getBlockState(pos.down()).getBlock() instanceof SlabBlock
				&& worldIn.getBlockState(pos.down()).get(SlabBlock.TYPE) == SlabType.BOTTOM;
	}
	
	@Override
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context)
	{
		BlockPos blockpos = context.getPos();
		
		if(context.getWorld().getBlockState(blockpos.down()).getBlock() instanceof SlabBlock
				&& context.getWorld().getBlockState(blockpos.down()).get(SlabBlock.TYPE) == SlabType.BOTTOM)
		{
			return this.getDefaultState().with(HALF, Half.TOP);
		}
		return this.getDefaultState().with(HALF, Half.BOTTOM);
	}
}
