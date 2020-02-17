package com.endlesnights.carpetstairsmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

	private DyeColor dyeColor;

	public CarpetSlab(DyeColor color, Block.Properties properties)
	{
		super(color, properties);
		this.dyeColor = color;
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

		if(worldIn.getBlockState(pos.down()).get(BlockStateProperties.WATERLOGGED))
		{
			return false;
		}
		return worldIn.getBlockState(pos.down()).getBlock() instanceof SlabBlock
				&& worldIn.getBlockState(pos.down()).get(SlabBlock.TYPE) == SlabType.BOTTOM;
	}
		   
			@Override
			public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player)
			{
				if(this.dyeColor == DyeColor.BLACK)
					return new ItemStack( Items.BLACK_CARPET);
				if(this.dyeColor == DyeColor.BLUE)
					return new ItemStack( Items.BLUE_CARPET);
				if(this.dyeColor == DyeColor.BROWN)
					return new ItemStack( Items.BROWN_CARPET);
				if(this.dyeColor == DyeColor.CYAN)
					return new ItemStack( Items.CYAN_CARPET);
				if(this.dyeColor == DyeColor.GRAY)
					return new ItemStack( Items.GRAY_CARPET);
				if(this.dyeColor == DyeColor.GREEN)
					return new ItemStack( Items.GREEN_CARPET);
				if(this.dyeColor == DyeColor.LIGHT_GRAY)
					return new ItemStack( Items.LIGHT_GRAY_CARPET);
				if(this.dyeColor == DyeColor.LIGHT_BLUE)
					return new ItemStack( Items.LIGHT_BLUE_CARPET);
				if(this.dyeColor == DyeColor.LIME)
					return new ItemStack( Items.LIME_CARPET);
				if(this.dyeColor == DyeColor.MAGENTA)
					return new ItemStack( Items.MAGENTA_CARPET);
				if(this.dyeColor == DyeColor.ORANGE)
					return new ItemStack( Items.ORANGE_CARPET);
				if(this.dyeColor == DyeColor.PINK)
					return new ItemStack( Items.PINK_CARPET);
				if(this.dyeColor == DyeColor.PURPLE)
					return new ItemStack( Items.PURPLE_CARPET);
				if(this.dyeColor == DyeColor.RED)
					return new ItemStack( Items.RED_CARPET);
				if(this.dyeColor == DyeColor.WHITE)
					return new ItemStack( Items.WHITE_CARPET);
				if(this.dyeColor == DyeColor.YELLOW)
					return new ItemStack( Items.YELLOW_CARPET);
				return new ItemStack(null);
			}
}
