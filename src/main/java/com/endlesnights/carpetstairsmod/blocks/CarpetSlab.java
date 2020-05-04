package com.endlesnights.carpetstairsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class CarpetSlab extends CarpetBlock 
{
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	Block parrentBlock;
	
	public CarpetSlab(Block parentBlock, DyeColor color, Block.Properties properties)
	{
		super(color, properties);
		this.parrentBlock = parentBlock;
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
	{
		return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return SHAPE;
	}
	
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 16.0D, -7.0D, 16.0D);
	}
	   
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).getBlock() instanceof SlabBlock
				&& worldIn.getBlockState(pos.down()).get(SlabBlock.TYPE) == SlabType.BOTTOM
				&& !(worldIn.getBlockState(pos.down()).get(BlockStateProperties.WATERLOGGED));
	}
		   
			@Override
			public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player)
			{
				return new ItemStack(parrentBlock.asItem());
			}
}
