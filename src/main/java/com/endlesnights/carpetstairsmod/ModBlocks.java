package com.endlesnights.carpetstairsmod;

import com.endlesnights.carpetstairsmod.blocks.BlockCarpetStair;
import com.endlesnights.carpetstairsmod.blocks.CarpetSlab;
import com.endlesnights.carpetstairsmod.blocks.WoodFloorBlock;
import com.endlesnights.carpetstairsmod.blocks.WoodFloorStair;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(CarpetStairsMod.MODID)
public class ModBlocks implements ICarpetStairsCompat
{	
	public static Block black_carpet_stair = null;
	public static Block blue_carpet_stair = null;
	public static Block brown_carpet_stair = null;
	public static Block cyan_carpet_stair = null;
	public static Block gray_carpet_stair = null;
	public static Block green_carpet_stair = null;
	public static Block light_blue_carpet_stair = null;
	public static Block light_gray_carpet_stair = null;
	public static Block lime_carpet_stair = null;
	public static Block magenta_carpet_stair = null;
	public static Block orange_carpet_stair = null;
	public static Block pink_carpet_stair = null;
	public static Block purple_carpet_stair = null;
	public static Block red_carpet_stair = null;
	public static Block white_carpet_stair = null;
	public static Block yellow_carpet_stair = null;
	
	public static Block black_carpet_slab = null;
	public static Block blue_carpet_slab = null;
	public static Block brown_carpet_slab = null;
	public static Block cyan_carpet_slab = null;
	public static Block gray_carpet_slab = null;
	public static Block green_carpet_slab = null;
	public static Block light_blue_carpet_slab = null;
	public static Block light_gray_carpet_slab = null;
	public static Block lime_carpet_slab = null;
	public static Block magenta_carpet_slab = null;
	public static Block orange_carpet_slab = null;
	public static Block pink_carpet_slab = null;
	public static Block purple_carpet_slab = null;
	public static Block red_carpet_slab = null;
	public static Block white_carpet_slab = null;
	public static Block yellow_carpet_slab = null;
	
	public static Block acacia_wood_floor = null;
	public static Block birch_wood_floor = null;
	public static Block jungle_wood_floor = null;
	public static Block spruce_wood_floor = null;
	public static Block oak_wood_floor = null;
	public static Block dark_oak_wood_floor = null;
	
	public static Block acacia_wood_floor_stair = null;
	public static Block birch_wood_floor_stair = null;
	public static Block jungle_wood_floor_stair = null;
	public static Block spruce_wood_floor_stair = null;
	public static Block oak_wood_floor_stair = null;
	public static Block dark_oak_wood_floor_stair = null;
	
	@Override
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
	
		black_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.BLACK , Block.Properties.from(Blocks.BLACK_CARPET)), "black_carpet_stair");
		blue_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.BLUE , Block.Properties.from(Blocks.BLUE_CARPET)), "blue_carpet_stair");
		brown_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.BROWN , Block.Properties.from(Blocks.BROWN_CARPET)), "brown_carpet_stair");
		cyan_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.CYAN , Block.Properties.from(Blocks.CYAN_CARPET)), "cyan_carpet_stair");
		gray_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.GRAY , Block.Properties.from(Blocks.GRAY_CARPET)), "gray_carpet_stair");
		green_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.GREEN , Block.Properties.from(Blocks.GREEN_CARPET)), "green_carpet_stair");
		light_blue_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.LIGHT_BLUE , Block.Properties.from(Blocks.LIGHT_BLUE_CARPET)), "light_blue_carpet_stair");
		light_gray_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.LIGHT_GRAY , Block.Properties.from(Blocks.LIGHT_GRAY_CARPET)), "light_gray_carpet_stair");
		lime_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.LIME , Block.Properties.from(Blocks.LIME_CARPET)), "lime_carpet_stair");
		magenta_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.MAGENTA , Block.Properties.from(Blocks.MAGENTA_CARPET)), "magenta_carpet_stair");
		orange_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.ORANGE , Block.Properties.from(Blocks.ORANGE_CARPET)), "orange_carpet_stair");
		pink_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.PINK , Block.Properties.from(Blocks.PINK_CARPET)), "pink_carpet_stair");
		purple_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.PURPLE , Block.Properties.from(Blocks.PURPLE_CARPET)), "purple_carpet_stair");
		red_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.RED , Block.Properties.from(Blocks.RED_CARPET)), "red_carpet_stair");
		white_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.WHITE , Block.Properties.from(Blocks.WHITE_CARPET)), "white_carpet_stair");
		yellow_carpet_stair = registerBlock(new BlockCarpetStair(DyeColor.YELLOW , Block.Properties.from(Blocks.YELLOW_CARPET)), "yellow_carpet_stair");

		black_carpet_slab = registerBlock(new CarpetSlab(DyeColor.BLACK, Block.Properties.from(Blocks.BLACK_CARPET).lootFrom(Blocks.BLACK_CARPET)), "black_carpet_slab");
		blue_carpet_slab = registerBlock(new CarpetSlab(DyeColor.BLACK, Block.Properties.from(Blocks.BLACK_CARPET).lootFrom(Blocks.BLACK_CARPET)), "blue_carpet_slab");
		brown_carpet_slab = registerBlock(new CarpetSlab(DyeColor.BROWN , Block.Properties.from(Blocks.BROWN_CARPET).lootFrom(Blocks.BROWN_CARPET)), "brown_carpet_slab");
		cyan_carpet_slab = registerBlock(new CarpetSlab(DyeColor.CYAN , Block.Properties.from(Blocks.CYAN_CARPET).lootFrom(Blocks.CYAN_CARPET)), "cyan_carpet_slab");
		gray_carpet_slab = registerBlock(new CarpetSlab(DyeColor.GRAY , Block.Properties.from(Blocks.GRAY_CARPET).lootFrom(Blocks.GRAY_CARPET)), "gray_carpet_slab");
		green_carpet_slab = registerBlock(new CarpetSlab(DyeColor.GREEN , Block.Properties.from(Blocks.GREEN_CARPET).lootFrom(Blocks.GREEN_CARPET)), "green_carpet_slab");
		light_blue_carpet_slab = registerBlock(new CarpetSlab(DyeColor.LIGHT_BLUE , Block.Properties.from(Blocks.LIGHT_BLUE_CARPET).lootFrom(Blocks.LIGHT_BLUE_CARPET)), "light_blue_carpet_slab");
		light_gray_carpet_slab = registerBlock(new CarpetSlab(DyeColor.LIGHT_GRAY , Block.Properties.from(Blocks.LIGHT_GRAY_CARPET).lootFrom(Blocks.LIGHT_GRAY_CARPET)), "light_gray_carpet_slab");
		lime_carpet_slab = registerBlock(new CarpetSlab(DyeColor.LIME , Block.Properties.from(Blocks.LIME_CARPET).lootFrom(Blocks.LIME_CARPET)), "lime_carpet_slab");
		magenta_carpet_slab = registerBlock(new CarpetSlab(DyeColor.MAGENTA , Block.Properties.from(Blocks.MAGENTA_CARPET).lootFrom(Blocks.MAGENTA_CARPET)), "magenta_carpet_slab");
		orange_carpet_slab = registerBlock(new CarpetSlab(DyeColor.ORANGE , Block.Properties.from(Blocks.ORANGE_CARPET).lootFrom(Blocks.ORANGE_CARPET)), "orange_carpet_slab");
		pink_carpet_slab = registerBlock(new CarpetSlab(DyeColor.PINK , Block.Properties.from(Blocks.PINK_CARPET).lootFrom(Blocks.PINK_CARPET)), "pink_carpet_slab");
		purple_carpet_slab = registerBlock(new CarpetSlab(DyeColor.PURPLE , Block.Properties.from(Blocks.PURPLE_CARPET).lootFrom(Blocks.PURPLE_CARPET)), "purple_carpet_slab");
		red_carpet_slab = registerBlock(new CarpetSlab(DyeColor.RED , Block.Properties.from(Blocks.RED_CARPET).lootFrom(Blocks.RED_CARPET)), "red_carpet_slab");
		white_carpet_slab = registerBlock(new CarpetSlab(DyeColor.WHITE , Block.Properties.from(Blocks.WHITE_CARPET).lootFrom(Blocks.WHITE_CARPET)), "white_carpet_slab");
		yellow_carpet_slab = registerBlock(new CarpetSlab(DyeColor.YELLOW, Block.Properties.from(Blocks.YELLOW_CARPET).lootFrom(Blocks.YELLOW_CARPET)), "yellow_carpet_slab");

		acacia_wood_floor = registerBlock(new WoodFloorBlock(WoodFloorBlock.WoodType.ACACIA, Block.Properties.from(Blocks.ACACIA_SLAB)), "acacia_wood_floor");
		birch_wood_floor = registerBlock(new WoodFloorBlock(WoodFloorBlock.WoodType.BIRCH, Block.Properties.from(Blocks.BIRCH_SLAB)), "birch_wood_floor");
		jungle_wood_floor = registerBlock(new WoodFloorBlock(WoodFloorBlock.WoodType.JUNGLE, Block.Properties.from(Blocks.JUNGLE_SLAB)), "jungle_wood_floor");
		spruce_wood_floor = registerBlock(new WoodFloorBlock(WoodFloorBlock.WoodType.SPRUCE, Block.Properties.from(Blocks.SPRUCE_SLAB)), "spruce_wood_floor");
		oak_wood_floor = registerBlock(new WoodFloorBlock(WoodFloorBlock.WoodType.OAK, Block.Properties.from(Blocks.OAK_SLAB)), "oak_wood_floor");
		dark_oak_wood_floor = registerBlock(new WoodFloorBlock(WoodFloorBlock.WoodType.DARK_OAK, Block.Properties.from(Blocks.DARK_OAK_SLAB)), "dark_oak_wood_floor");
		
		acacia_wood_floor_stair = registerBlock(new WoodFloorStair(WoodFloorBlock.WoodType.ACACIA, Block.Properties.from(Blocks.ACACIA_SLAB)), "acacia_wood_floor_stair");
		birch_wood_floor_stair = registerBlock(new WoodFloorStair(WoodFloorBlock.WoodType.BIRCH, Block.Properties.from(Blocks.BIRCH_SLAB)), "birch_wood_floor_stair");
		jungle_wood_floor_stair = registerBlock(new WoodFloorStair(WoodFloorBlock.WoodType.JUNGLE, Block.Properties.from(Blocks.JUNGLE_SLAB)), "jungle_wood_floor_stair");
		spruce_wood_floor_stair = registerBlock(new WoodFloorStair(WoodFloorBlock.WoodType.SPRUCE, Block.Properties.from(Blocks.SPRUCE_SLAB)), "spruce_wood_floor_stair");
		oak_wood_floor_stair = registerBlock(new WoodFloorStair(WoodFloorBlock.WoodType.OAK, Block.Properties.from(Blocks.OAK_SLAB)), "oak_wood_floor_stair");
		dark_oak_wood_floor_stair = registerBlock(new WoodFloorStair(WoodFloorBlock.WoodType.DARK_OAK, Block.Properties.from(Blocks.DARK_OAK_SLAB)), "dark_oak_wood_floor_stair");
	}

	@Override
	public void registerPlaceEntries()
	{
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.BLACK_CARPET.getRegistryName(), black_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.BLUE_CARPET.getRegistryName(), blue_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.BROWN_CARPET.getRegistryName(), brown_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.CYAN_CARPET.getRegistryName(), cyan_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.GRAY_CARPET.getRegistryName(), gray_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.GREEN_CARPET.getRegistryName(), green_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.LIGHT_BLUE_CARPET.getRegistryName(), light_blue_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.LIGHT_GRAY_CARPET.getRegistryName(), light_gray_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.LIME_CARPET.getRegistryName(), lime_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.MAGENTA_CARPET.getRegistryName(), magenta_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.ORANGE_CARPET.getRegistryName(), orange_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.PINK_CARPET.getRegistryName(), pink_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.PURPLE_CARPET.getRegistryName(), purple_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.RED_CARPET.getRegistryName(), red_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.WHITE_CARPET.getRegistryName(), white_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(Items.YELLOW_CARPET.getRegistryName(), yellow_carpet_stair);
		
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.BLACK_CARPET.getRegistryName(), black_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.BLUE_CARPET.getRegistryName(), blue_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.BROWN_CARPET.getRegistryName(), brown_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.CYAN_CARPET.getRegistryName(), cyan_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.GRAY_CARPET.getRegistryName(), gray_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.GREEN_CARPET.getRegistryName(), green_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.LIGHT_BLUE_CARPET.getRegistryName(), light_blue_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.LIGHT_GRAY_CARPET.getRegistryName(), light_gray_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.LIME_CARPET.getRegistryName(), lime_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.MAGENTA_CARPET.getRegistryName(), magenta_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.ORANGE_CARPET.getRegistryName(), orange_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.PINK_CARPET.getRegistryName(), pink_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.PURPLE_CARPET.getRegistryName(), purple_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.RED_CARPET.getRegistryName(), red_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.WHITE_CARPET.getRegistryName(), white_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(Items.YELLOW_CARPET.getRegistryName(), yellow_carpet_slab);
		
		PlaceHandlerWoodStair.registerPlaceEntry(acacia_wood_floor.asItem().getRegistryName(), acacia_wood_floor_stair);
		PlaceHandlerWoodStair.registerPlaceEntry(birch_wood_floor.asItem().getRegistryName(), birch_wood_floor_stair);
		PlaceHandlerWoodStair.registerPlaceEntry(jungle_wood_floor.asItem().getRegistryName(), jungle_wood_floor_stair);
		PlaceHandlerWoodStair.registerPlaceEntry(spruce_wood_floor.asItem().getRegistryName(), spruce_wood_floor_stair);
		PlaceHandlerWoodStair.registerPlaceEntry(oak_wood_floor.asItem().getRegistryName(), oak_wood_floor_stair);
		PlaceHandlerWoodStair.registerPlaceEntry(dark_oak_wood_floor.asItem().getRegistryName(), dark_oak_wood_floor_stair);
	}

    public static Block registerBlock(Block block, String name)
    {
        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        return block;
    }
}
