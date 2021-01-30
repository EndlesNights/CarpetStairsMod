package com.endlesnights.carpetstairsmod;

import java.util.Collection;
import java.util.HashMap;

import com.endlesnights.carpetstairsmod.blocks.BlockCarpetStair;

//import cech12.extendedmushrooms.api.block.ExtendedMushroomsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
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
				&& match(held,world.getBlockState(pos) ))
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
				&& match(held,world.getBlockState(pos.up()) ))
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

	public static boolean match(ItemStack item, BlockState state)
	{
		if(	(item.getItem() == Items.BLACK_CARPET && state.getBlock() == ModBlocks.black_carpet_stair)||
			(item.getItem() == Items.BLUE_CARPET && state.getBlock() == ModBlocks.blue_carpet_stair)||
			(item.getItem() == Items.BROWN_CARPET && state.getBlock() == ModBlocks.brown_carpet_stair)||
			(item.getItem() == Items.CYAN_CARPET && state.getBlock() == ModBlocks.cyan_carpet_stair)||
			(item.getItem() == Items.GRAY_CARPET && state.getBlock() == ModBlocks.gray_carpet_stair)||
			(item.getItem() == Items.GREEN_CARPET && state.getBlock() == ModBlocks.green_carpet_stair)||
			(item.getItem() == Items.LIGHT_BLUE_CARPET && state.getBlock() == ModBlocks.light_blue_carpet_stair)||
			(item.getItem() == Items.LIGHT_GRAY_CARPET && state.getBlock() == ModBlocks.light_gray_carpet_stair)||
			(item.getItem() == Items.LIME_CARPET && state.getBlock() == ModBlocks.lime_carpet_stair)||
			(item.getItem() == Items.ORANGE_CARPET && state.getBlock() == ModBlocks.orange_carpet_stair)||
			(item.getItem() == Items.PINK_CARPET && state.getBlock() == ModBlocks.pink_carpet_stair)||
			(item.getItem() == Items.PURPLE_CARPET && state.getBlock() == ModBlocks.purple_carpet_stair)||
			(item.getItem() == Items.RED_CARPET && state.getBlock() == ModBlocks.red_carpet_stair)||
			(item.getItem() == Items.WHITE_CARPET && state.getBlock() == ModBlocks.white_carpet_stair)||
			(item.getItem() == Items.YELLOW_CARPET && state.getBlock() == ModBlocks.yellow_carpet_stair)
				)
			return true;
		
//		if(ModList.get().isLoaded("extendedmushrooms"))
//		{
//			if(	(item.getItem() == ExtendedMushroomsBlocks.BROWN_MUSHROOM_CARPET.asItem() && state.getBlock() == ExtendedMushroomsCompat.brown_mushroom_carpet_stair)||
//					(item.getItem() == ExtendedMushroomsBlocks.GLOWSHROOM_CAP_CARPET.asItem() && state.getBlock() == ExtendedMushroomsCompat.glowshroom_carpet_stair)||
//					(item.getItem() == ExtendedMushroomsBlocks.POISONOUS_MUSHROOM_CAP_CARPET.asItem() && state.getBlock() == ExtendedMushroomsCompat.poisonous_mushroom_carpet_stair)||
//					(item.getItem() == ExtendedMushroomsBlocks.RED_MUSHROOM_CARPET.asItem() && state.getBlock() == ExtendedMushroomsCompat.red_mushroom_carpet_stair))
//				return true;
//		}
		
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
