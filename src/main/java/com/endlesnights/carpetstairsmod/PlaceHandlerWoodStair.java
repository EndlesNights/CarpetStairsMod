package com.endlesnights.carpetstairsmod;

import java.util.Collection;
import java.util.HashMap;

import com.endlesnights.carpetstairsmod.blocks.WoodFloorStair;
import com.endlesnights.carpetstairsmod.blocks.WoodFloorBlock.WoodType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
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
					.with(StairsBlock.SHAPE, world.getBlockState(pos).get(StairsBlock.SHAPE)));
			
			world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), block.getSoundType(world.getBlockState(pos)).getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			event.getPlayer().swingArm(event.getHand());
			
			if(!event.getPlayer().isCreative())
				held.shrink(1);
			event.setCanceled(true);
		}
		else if((world.getBlockState(pos).getBlock() instanceof WoodFloorStair && world.getBlockState(pos).get(WoodFloorStair.CONDITIONAL) == false)
				&& getWoodTypeItem(held) == getWoodTypeBlock(world.getBlockState(pos) ) && getWoodTypeItem(held) != null)
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
				&& getWoodTypeItem(held) == getWoodTypeBlock(world.getBlockState(pos.up()) ) && getWoodTypeItem(held) != null)
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

	public static WoodType getWoodTypeItem(ItemStack item)
	{
		switch(item.getDisplayName().getString())
		{
			case"Acacia Flooring":
				return WoodType.ACACIA;
			case"Birch Flooring":
				return WoodType.BIRCH;
			case"Dark Oak Flooring":
				return WoodType.DARK_OAK;
			case"Jungle Flooring":
				return WoodType.JUNGLE;
			case"Oak Flooring":
				return WoodType.OAK;
			case"Spruce Flooring":
				return WoodType.SPRUCE;	
		}
		
		return null;
	}
	
	public static WoodType getWoodTypeBlock(BlockState state)
	{
		switch(state.getBlock().getNameTextComponent().getString())
		{				
		case"Acacia Flooring Stair":
			return WoodType.ACACIA;
		case"Birch Flooring Stair":
			return WoodType.BIRCH;
		case"Dark Oak Flooring Stair":
			return WoodType.DARK_OAK;
		case"Jungle Flooring Stair":
			return WoodType.JUNGLE;
		case"Oak Flooring Stair":
			return WoodType.OAK;
		case"Spruce Flooring Stair":
			return WoodType.SPRUCE;	
		}
		
		return null;
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