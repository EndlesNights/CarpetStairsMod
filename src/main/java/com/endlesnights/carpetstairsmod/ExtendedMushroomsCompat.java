package com.endlesnights.carpetstairsmod;

import com.endlesnights.carpetstairsmod.blocks.BlockCarpetStair;
import com.endlesnights.carpetstairsmod.blocks.CarpetSlab;
import com.endlesnights.carpetstairsmod.blocks.WoodFloorBlock;
import com.endlesnights.carpetstairsmod.blocks.WoodFloorStair;

import cech12.extendedmushrooms.api.block.ExtendedMushroomsBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.DyeColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ExtendedMushroomsCompat implements ICarpetStairsCompat
{
	
	public static Block brown_mushroom_carpet_stair = null;
	public static Block red_mushroom_carpet_stair = null;
	public static Block glowshroom_carpet_stair = null;
	public static Block poisonous_mushroom_carpet_stair = null;
	
	public static Block brown_mushroom_carpet_slab = null;
	public static Block red_mushroom_carpet_slab = null;
	public static Block glowshroom_carpet_slab = null;
	public static Block poisonous_mushroom_carpet_slab = null;
	
	public static Block mushroom_wood_floor = null;
	public static Block glowshroom_wood_floor = null;
	public static Block poisonous_mushroom_wood_floor = null;
	
	public static Block mushroom_wood_floor_stair = null;
	public static Block glowshroom_wood_floor_stair = null;
	public static Block poisonous_mushroom_wood_floor_stair = null;
	
	@Override
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
		brown_mushroom_carpet_stair = registerBlock(new BlockCarpetStair(ExtendedMushroomsBlocks.BROWN_MUSHROOM_CARPET,DyeColor.BLUE , Block.Properties.from(ExtendedMushroomsBlocks.BROWN_MUSHROOM_CARPET).notSolid()), "brown_mushroom_carpet_stair");
		red_mushroom_carpet_stair = registerBlock(new BlockCarpetStair(ExtendedMushroomsBlocks.RED_MUSHROOM_CARPET,DyeColor.BLUE , Block.Properties.from(ExtendedMushroomsBlocks.RED_MUSHROOM_CARPET).notSolid()), "red_mushroom_carpet_stair");
		glowshroom_carpet_stair = registerBlock(new BlockCarpetStair(ExtendedMushroomsBlocks.GLOWSHROOM_CAP_CARPET, DyeColor.BLUE , Block.Properties.from(ExtendedMushroomsBlocks.GLOWSHROOM_CAP_CARPET).notSolid()), "glowshroom_carpet_stair");
		poisonous_mushroom_carpet_stair = registerBlock(new BlockCarpetStair(ExtendedMushroomsBlocks.POISONOUS_MUSHROOM_CAP_CARPET, DyeColor.BLUE , Block.Properties.from(ExtendedMushroomsBlocks.POISONOUS_MUSHROOM_CAP_CARPET).notSolid()), "poisonous_mushroom_carpet_stair");

		brown_mushroom_carpet_slab = registerBlock(new CarpetSlab(ExtendedMushroomsBlocks.BROWN_MUSHROOM_CARPET,DyeColor.BLUE , Block.Properties.from(ExtendedMushroomsBlocks.BROWN_MUSHROOM_CARPET).notSolid()), "brown_mushroom_carpet_slab");
		red_mushroom_carpet_slab = registerBlock(new CarpetSlab(ExtendedMushroomsBlocks.RED_MUSHROOM_CARPET,DyeColor.BLUE , Block.Properties.from(ExtendedMushroomsBlocks.RED_MUSHROOM_CARPET).notSolid()), "red_mushroom_carpet_slab");
		glowshroom_carpet_slab = registerBlock(new CarpetSlab(ExtendedMushroomsBlocks.GLOWSHROOM_CAP_CARPET, DyeColor.BLUE , Block.Properties.from(ExtendedMushroomsBlocks.GLOWSHROOM_CAP_CARPET).notSolid()), "glowshroom_carpet_slab");
		poisonous_mushroom_carpet_slab = registerBlock(new CarpetSlab(ExtendedMushroomsBlocks.POISONOUS_MUSHROOM_CAP_CARPET, DyeColor.BLUE , Block.Properties.from(ExtendedMushroomsBlocks.POISONOUS_MUSHROOM_CAP_CARPET).notSolid()), "poisonous_mushroom_carpet_slab");
		
		mushroom_wood_floor = registerBlock(new WoodFloorBlock(Block.Properties.from(ExtendedMushroomsBlocks.MUSHROOM_SLAB).notSolid()), "mushroom_wood_floor");
		glowshroom_wood_floor = registerBlock(new WoodFloorBlock(Block.Properties.from(ExtendedMushroomsBlocks.GLOWSHROOM_SLAB).notSolid()), "glowshroom_wood_floor");
		poisonous_mushroom_wood_floor = registerBlock(new WoodFloorBlock(Block.Properties.from(ExtendedMushroomsBlocks.POISONOUS_MUSHROOM_SLAB).notSolid()), "poisonous_mushroom_wood_floor");
		
		mushroom_wood_floor_stair = registerBlock(new WoodFloorStair(mushroom_wood_floor, Block.Properties.from(ExtendedMushroomsBlocks.MUSHROOM_SLAB).notSolid()), "mushroom_wood_floor_stair");
		glowshroom_wood_floor_stair = registerBlock(new WoodFloorStair(glowshroom_wood_floor, Block.Properties.from(ExtendedMushroomsBlocks.GLOWSHROOM_SLAB).notSolid()), "glowshroom_wood_floor_stair");
		poisonous_mushroom_wood_floor_stair = registerBlock(new WoodFloorStair(poisonous_mushroom_wood_floor, Block.Properties.from(ExtendedMushroomsBlocks.POISONOUS_MUSHROOM_SLAB).notSolid()), "poisonous_mushroom_wood_floor_stair");
	}
	
	@Override
	public void registerPlaceEntries()
	{
		PlaceHandlerCarpetStairs.registerPlaceEntry(ExtendedMushroomsBlocks.BROWN_MUSHROOM_CARPET.asItem().getRegistryName(), brown_mushroom_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(ExtendedMushroomsBlocks.RED_MUSHROOM_CARPET.asItem().getRegistryName(), red_mushroom_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(ExtendedMushroomsBlocks.GLOWSHROOM_CAP_CARPET.asItem().getRegistryName(), glowshroom_carpet_stair);
		PlaceHandlerCarpetStairs.registerPlaceEntry(ExtendedMushroomsBlocks.POISONOUS_MUSHROOM_CAP_CARPET.asItem().getRegistryName(), poisonous_mushroom_carpet_stair);

		PlaceHandlerCarpetSlab.registerPlaceEntry(ExtendedMushroomsBlocks.BROWN_MUSHROOM_CARPET.asItem().getRegistryName(), brown_mushroom_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(ExtendedMushroomsBlocks.RED_MUSHROOM_CARPET.asItem().getRegistryName(), red_mushroom_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(ExtendedMushroomsBlocks.GLOWSHROOM_CAP_CARPET.asItem().getRegistryName(), glowshroom_carpet_slab);
		PlaceHandlerCarpetSlab.registerPlaceEntry(ExtendedMushroomsBlocks.POISONOUS_MUSHROOM_CAP_CARPET.asItem().getRegistryName(), poisonous_mushroom_carpet_slab);

		PlaceHandlerWoodStair.registerPlaceEntry(mushroom_wood_floor.asItem().getRegistryName(), mushroom_wood_floor_stair);
		PlaceHandlerWoodStair.registerPlaceEntry(glowshroom_wood_floor.asItem().getRegistryName(), glowshroom_wood_floor_stair);
		PlaceHandlerWoodStair.registerPlaceEntry(poisonous_mushroom_wood_floor.asItem().getRegistryName(), poisonous_mushroom_wood_floor_stair);

	}
	
    public static Block registerBlock(Block block, String name)
    {
        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        return block;
    }
}
