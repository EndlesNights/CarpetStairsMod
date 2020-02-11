package com.endlesnights.carpetstairsmod.blocks;

import java.util.stream.IntStream;

import com.endlesnights.carpetstairsmod.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

public class WoodFloorStair extends WoodFloorBlock
{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
	   
	public static final BooleanProperty CONDITIONAL = BlockStateProperties.CONDITIONAL;
	
	protected static final VoxelShape TOP_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	protected static final VoxelShape BOTTOM_SHAPE = Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 16.0D, -7.0D, 16.0D);
	protected static final VoxelShape NWD_CORNER = Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 8.0D, -7.0D, 8.0D);
	protected static final VoxelShape SWD_CORNER = Block.makeCuboidShape(0.0D, -8.0D, 8.0D, 8.0D, -7.0D, 16.0D);
	protected static final VoxelShape NWU_CORNER = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 8.0D, 1.0D, 8.0D);
	protected static final VoxelShape SWU_CORNER = Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 8.0D, 1.0D, 16.0D);
	protected static final VoxelShape NED_CORNER = Block.makeCuboidShape(8.0D, -8.0D, 0.0D, 16.0D, -7.0D, 8.0D);
	protected static final VoxelShape SED_CORNER = Block.makeCuboidShape(8.0D, -8.0D, 8.0D, 16.0D, -7.0D, 16.0D);
	protected static final VoxelShape NEU_CORNER = Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 16.0D, 1.0D, 8.0D);
	protected static final VoxelShape SEU_CORNER = Block.makeCuboidShape(8.0D, 0.0D, 8.0D, 16.0D, 1.0D, 16.0D);
	
	protected static final VoxelShape[] SLAB_TOP_SHAPES = makeShapes(TOP_SHAPE, NWD_CORNER, NED_CORNER, SWD_CORNER, SED_CORNER);
	protected static final VoxelShape[] SLAB_BOTTOM_SHAPES = makeShapes(BOTTOM_SHAPE, NWU_CORNER, NEU_CORNER, SWU_CORNER, SEU_CORNER);
	
	private static final int[] field_196522_K = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};
	private final WoodType wood;
	
	public WoodFloorStair(WoodType woodtype, Properties properties)
	{
		super(woodtype, properties);
		this.setDefaultState(this.stateContainer.getBaseState()
				.with(FACING, Direction.NORTH)
				.with(SHAPE, StairsShape.STRAIGHT)
				.with(CONDITIONAL, false));
		this.wood = woodtype;
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(FACING, SHAPE, CONDITIONAL, HALF);
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).getBlock() instanceof StairsBlock;
	}
	
	@Override
	public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player)
	{
		if(this.wood == WoodType.ACACIA)
			return new ItemStack( ModBlocks.acacia_wood_floor.asItem());
		if(this.wood == WoodType.BIRCH)
			return new ItemStack( ModBlocks.birch_wood_floor.asItem());
		if(this.wood == WoodType.DARK_OAK)
			return new ItemStack( ModBlocks.dark_oak_wood_floor.asItem());
		if(this.wood == WoodType.JUNGLE)
			return new ItemStack( ModBlocks.jungle_wood_floor.asItem());
		if(this.wood == WoodType.OAK)
			return new ItemStack( ModBlocks.oak_wood_floor.asItem());
		if(this.wood == WoodType.SPRUCE)
			return new ItemStack( ModBlocks.spruce_wood_floor.asItem());
		
		return null;
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos)
	{

		if(worldIn.getBlockState(currentPos.down()).getBlock() instanceof StairsBlock && worldIn.getBlockState(currentPos.down()).get(StairsBlock.HALF) == Half.BOTTOM)
			return this.getDefaultState()  
				.with(StairsBlock.FACING, worldIn.getBlockState(currentPos.down()).get(StairsBlock.FACING))
				.with(StairsBlock.SHAPE, worldIn.getBlockState(currentPos.down()).get(StairsBlock.SHAPE))
				.with(BlockCarpetStair.CONDITIONAL, stateIn.get(CONDITIONAL));
		
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
	
	private StairsShape getShapeProperty(BlockState state, IBlockReader worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).get(StairsBlock.SHAPE);
	}
	
	
	private static VoxelShape[] makeShapes(VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner)
	{
		return IntStream.range(0, 16).mapToObj((p_199780_5_) -> {
			return combineShapes(p_199780_5_, slabShape, nwCorner, neCorner, swCorner, seCorner);
		}).toArray((p_199778_0_) -> {
			return new VoxelShape[p_199778_0_];
		});
	}  
	
	private static VoxelShape combineShapes(int bitfield, VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner)
	{
		VoxelShape voxelshape = slabShape;
		if ((bitfield & 1) != 0) {
			voxelshape = VoxelShapes.or(slabShape, nwCorner);
		}

		if ((bitfield & 2) != 0) {
			voxelshape = VoxelShapes.or(voxelshape, neCorner);
		}

		if ((bitfield & 4) != 0) {
			voxelshape = VoxelShapes.or(voxelshape, swCorner);
		}

		if ((bitfield & 8) != 0) {
			voxelshape = VoxelShapes.or(voxelshape, seCorner);
		}

		return voxelshape;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
	{
		return (SLAB_BOTTOM_SHAPES)[field_196522_K[this.func_196511_x(state)]];
	}
	
	
	private int func_196511_x(BlockState state)
	{
		return state.get(SHAPE).ordinal() * 4 + state.get(FACING).getHorizontalIndex();
	}
}
