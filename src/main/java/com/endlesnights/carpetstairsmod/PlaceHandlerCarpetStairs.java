package com.endlesnights.carpetstairsmod;

import java.util.Collection;
import java.util.HashMap;

import com.endlesnights.carpetstairsmod.blocks.BlockCarpetStair;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.DyeColor;
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
public class PlaceHandlerCarpetStairs
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
			if(world.getBlockState(pos).get(BlockStateProperties.WATERLOGGED))
				world.setBlockState(pos, world.getBlockState(pos).with(BlockStateProperties.WATERLOGGED, false));
			
			world.setBlockState(placeAt, block.getDefaultState()  
					.with(StairsBlock.FACING, world.getBlockState(pos).get(StairsBlock.FACING))
					.with(StairsBlock.SHAPE, world.getBlockState(pos).get(StairsBlock.SHAPE)));
			
			world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), block.getSoundType(world.getBlockState(pos)).getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			event.getPlayer().swingArm(event.getHand());
			
			if(!event.getPlayer().isCreative())
				held.shrink(1);
			event.setCanceled(true);
		}
		else if((world.getBlockState(pos).getBlock() instanceof BlockCarpetStair && world.getBlockState(pos).get(BlockCarpetStair.CONDITIONAL) == false)
				&& getDyeColorItem(held) == getDyeColorBlock(world.getBlockState(pos) ) && getDyeColorItem(held) != null)
		{
			world.setBlockState(pos, world.getBlockState(pos)
					.with(BlockCarpetStair.CONDITIONAL, true));
			
			world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), block.getSoundType(world.getBlockState(pos)).getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			event.getPlayer().swingArm(event.getHand());
			
			if(!event.getPlayer().isCreative())
				held.shrink(1);
			event.setCanceled(true);
		}
		else if( face != Direction.DOWN
				&& (world.getBlockState(pos).getBlock() instanceof StairsBlock && world.getBlockState(pos).get(StairsBlock.HALF) == Half.BOTTOM)
				&& (world.getBlockState(pos.up()).getBlock() instanceof BlockCarpetStair && world.getBlockState(pos.up()).get(BlockCarpetStair.CONDITIONAL) == false)
				&& getDyeColorItem(held) == getDyeColorBlock(world.getBlockState(pos.up()) ) && getDyeColorItem(held) != null)
		{
			
			world.setBlockState(pos.up(), world.getBlockState(pos.up())
					.with(BlockCarpetStair.CONDITIONAL, true));
			
			world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), block.getSoundType(world.getBlockState(pos.up())).getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			event.getPlayer().swingArm(event.getHand());
			
			if(!event.getPlayer().isCreative())
				held.shrink(1);
			event.setCanceled(true);
		}
	}

	public static DyeColor getDyeColorItem(ItemStack item)
	{
		switch(item.getDisplayName().getString())
		{
			case"Black Carpet":
				return DyeColor.BLACK;
			case"Blue Carpet":
				return DyeColor.BLUE;
			case"Brown Carpet":
				return DyeColor.BROWN;
			case"Cyan Carpet":
				return DyeColor.CYAN;
			case"Gray Carpet":
				return DyeColor.GRAY;
			case"Green Carpet":
				return DyeColor.GREEN;	
			case"Light Blue Carpet":
				return DyeColor.LIGHT_BLUE;
			case"Light Gray Carpet":
				return DyeColor.LIGHT_GRAY;
			case"Lime Carpet":
				return DyeColor.LIME;
			case"Magenta Carpet":
				return DyeColor.MAGENTA;
			case"Orange Carpet":
				return DyeColor.ORANGE;
			case"Pink Carpet":
				return DyeColor.PINK;
			case"Purple Carpet":
				return DyeColor.PURPLE;
			case"Red Carpet":
				return DyeColor.RED;
			case"White Carpet":
				return DyeColor.WHITE;
			case"Yellow Carpet":
				return DyeColor.YELLOW;
		}
		
		return null;
	}
	
	public static DyeColor getDyeColorBlock(BlockState state)
	{
		switch(state.getBlock().getNameTextComponent().getString())
		{				
			case"Black Carpet Stair":
				return DyeColor.BLACK;
			case"Blue Carpet Stair":
				return DyeColor.BLUE;
			case"Brown Carpet Stair":
				return DyeColor.BROWN;
			case"Cyan Carpet Stair":
				return DyeColor.CYAN;
			case"Gray Carpet Stair":
				return DyeColor.GRAY;
			case"Green Carpet Stair":
				return DyeColor.GREEN;	
			case"Light Blue Carpet Stair":
				return DyeColor.LIGHT_BLUE;
			case"Light Gray Carpet Stair":
				return DyeColor.LIGHT_GRAY;
			case"Lime Carpet Stair":
				return DyeColor.LIME;
			case"Magenta Carpet Stair":
				return DyeColor.MAGENTA;
			case"Orange Carpet Stair":
				return DyeColor.ORANGE;
			case"Pink Carpet Stair":
				return DyeColor.PINK;
			case"Purple Carpet Stair":
				return DyeColor.PURPLE;
			case"Red Carpet Stair":
				return DyeColor.RED;
			case"White Carpet Stair":
				return DyeColor.WHITE;
			case"Yellow Carpet Stair":
				return DyeColor.YELLOW;
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
