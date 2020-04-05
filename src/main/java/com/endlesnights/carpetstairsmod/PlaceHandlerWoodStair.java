package com.endlesnights.carpetstairsmod;

import java.util.Collection;
import java.util.HashMap;

import com.endlesnights.carpetstairsmod.blocks.WoodFloorStair;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid=CarpetStairsMod.MODID)
public class PlaceHandlerWoodStair
{
private static final HashMap<ResourceLocation,Block> PLACE_ENTRIES = new HashMap<>();
	
	@SubscribeEvent
	public static void onBlockEntityPlace(RightClickBlock event)
	{	
		ItemStack held = event.getItemStack();
		ResourceLocation rl = held.getItem().getRegistryName();

		if(PLACE_ENTRIES.containsKey(rl))
			placeCarpet(event, held, PLACE_ENTRIES.get(rl));
	}
	
	private static void placeCarpet(RightClickBlock event, ItemStack held, Block block)
	{
		BlockPos pos = event.getPos();
		Direction face = event.getFace();
		BlockPos placeAt = pos.offset(face);
		World world = event.getWorld();
		
		if(face == Direction.UP
				&& world.getBlockState(pos).getBlock() instanceof StairsBlock && world.getBlockState(pos).get(StairsBlock.HALF) == Half.BOTTOM
				&& (world.isAirBlock(placeAt) || world.getFluidState(placeAt).getFluid() == Fluids.WATER || world.getFluidState(placeAt).getFluid() == Fluids.FLOWING_WATER))
		{
			world.setBlockState(placeAt, block.getDefaultState()  
					.with(StairsBlock.FACING, world.getBlockState(pos).get(StairsBlock.FACING))
					.with(StairsBlock.SHAPE, world.getBlockState(pos).get(StairsBlock.SHAPE))
					.with(BlockStateProperties.WATERLOGGED, world.getFluidState(placeAt).getFluid() == Fluids.WATER));
			
			world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), block.getSoundType(world.getBlockState(pos)).getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			event.getPlayer().swingArm(event.getHand());
			
			if(!event.getPlayer().isCreative())
				held.shrink(1);
			event.setCanceled(true);
		}
		else if((world.getBlockState(pos).getBlock() instanceof WoodFloorStair && world.getBlockState(pos).get(WoodFloorStair.CONDITIONAL) == false)
				&& match(held,world.getBlockState(pos)))
		{
			world.setBlockState(pos, world.getBlockState(pos)
					.with(WoodFloorStair.CONDITIONAL, true));
			
			world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), block.getSoundType(world.getBlockState(pos)).getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			event.getPlayer().swingArm(event.getHand());
			
			if(!event.getPlayer().isCreative())
				held.shrink(1);
			event.setCanceled(true);
		}
		else if( face != Direction.DOWN
				&& (world.getBlockState(pos).getBlock() instanceof StairsBlock && world.getBlockState(pos).get(StairsBlock.HALF) == Half.BOTTOM)
				&& (world.getBlockState(pos.up()).getBlock() instanceof WoodFloorStair && world.getBlockState(pos.up()).get(WoodFloorStair.CONDITIONAL) == false)
				&& match(held,world.getBlockState(pos.up())))
		{
			
			world.setBlockState(pos.up(), world.getBlockState(pos.up())
					.with(WoodFloorStair.CONDITIONAL, true));
			
			world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), block.getSoundType(world.getBlockState(pos.up())).getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			event.getPlayer().swingArm(event.getHand());
			
			if(!event.getPlayer().isCreative())
				held.shrink(1);
			event.setCanceled(true);
		}

	}
	
	public static boolean match(ItemStack item, BlockState state)
	{
		if(	(item.getItem() == ModBlocks.acacia_wood_floor.asItem() && state.getBlock() == ModBlocks.acacia_wood_floor_stair) ||
			(item.getItem() == ModBlocks.birch_wood_floor.asItem() && state.getBlock() == ModBlocks.birch_wood_floor_stair) ||
			(item.getItem() == ModBlocks.dark_oak_wood_floor.asItem() && state.getBlock() == ModBlocks.dark_oak_wood_floor_stair) ||
			(item.getItem() == ModBlocks.jungle_wood_floor.asItem() && state.getBlock() == ModBlocks.jungle_wood_floor_stair) ||
			(item.getItem() == ModBlocks.oak_wood_floor.asItem() && state.getBlock() == ModBlocks.oak_wood_floor_stair) ||
			(item.getItem() == ModBlocks.spruce_wood_floor.asItem() && state.getBlock() == ModBlocks.spruce_wood_floor_stair) 
				)
				return true;
		
		return false;
	}
	
	public static void registerPlaceEntry(ResourceLocation itemName, Block torchSlab)
	{
		if(!PLACE_ENTRIES.containsKey(itemName))
			PLACE_ENTRIES.put(itemName, torchSlab);
	}

	public static Collection<Block> getPlaceEntryBlocks()
	{
		return PLACE_ENTRIES.values();
	}
}