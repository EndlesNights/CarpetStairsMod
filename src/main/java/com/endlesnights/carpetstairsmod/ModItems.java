package com.endlesnights.carpetstairsmod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = CarpetStairsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(CarpetStairsMod.MODID)
public class ModItems
{
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
    	
        event.getRegistry().registerAll
        (
    		createItemBlockForBlock(ModBlocks.acacia_wood_floor, new Item.Properties().group(CarpetStairsMod.instance.creativeTab)),
    		createItemBlockForBlock(ModBlocks.birch_wood_floor, new Item.Properties().group(CarpetStairsMod.instance.creativeTab)),
    		createItemBlockForBlock(ModBlocks.jungle_wood_floor, new Item.Properties().group(CarpetStairsMod.instance.creativeTab)),
    		createItemBlockForBlock(ModBlocks.spruce_wood_floor, new Item.Properties().group(CarpetStairsMod.instance.creativeTab)),
    		createItemBlockForBlock(ModBlocks.oak_wood_floor, new Item.Properties().group(CarpetStairsMod.instance.creativeTab)),
    		createItemBlockForBlock(ModBlocks.dark_oak_wood_floor, new Item.Properties().group(CarpetStairsMod.instance.creativeTab))

        );
        
		if(ModList.get().isLoaded("extendedmushrooms"))
		{
			try
			{
		        event.getRegistry().registerAll
		        (
	        		createItemBlockForBlock(ExtendedMushroomsCompat.glowshroom_wood_floor, new Item.Properties().group(CarpetStairsMod.instance.creativeTab)),
	        		createItemBlockForBlock(ExtendedMushroomsCompat.mushroom_wood_floor, new Item.Properties().group(CarpetStairsMod.instance.creativeTab)),
	        		createItemBlockForBlock(ExtendedMushroomsCompat.poisonous_mushroom_wood_floor, new Item.Properties().group(CarpetStairsMod.instance.creativeTab))
				);
			}
			catch(Error e)
			{
				System.out.println("Error while attpeing to load compatibility with CarpetStairs & ExtendedMushroomsBlocks. Skipping Block:");
			}
			catch(Exception e)
			{
				System.out.println("Error while attpeing to load compatibility with CarpetStairs & ExtendedMushroomsBlocks. Skipping Block:" + e.getMessage());
			}

		}
    }
    
    private static BlockItem createItemBlockForBlock (Block block, Item.Properties properties)
    {
        return (BlockItem) new BlockItem(block, properties).setRegistryName(block.getRegistryName());
    }
}
