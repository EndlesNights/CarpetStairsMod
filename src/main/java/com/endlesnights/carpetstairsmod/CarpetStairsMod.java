package com.endlesnights.carpetstairsmod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;

@Mod(CarpetStairsMod.MODID)
@EventBusSubscriber(bus=Bus.MOD)
public class CarpetStairsMod
{
	public static final String MODID = "carpetstairsmod";
	public static final String NAME = "Carpet Stairs Mod";
	private static List<Supplier<ICarpetStairsCompat>> compatList = new ArrayList<>();
	
	public static CarpetStairsMod instance;
	public final ItemGroup creativeTab;
	
	public CarpetStairsMod()
	{
		instance = this;
		creativeTab = new CreativeTab();
		compatList.add(ModBlocks::new);
		
		if(ModList.get().isLoaded("extendedmushrooms"))
		{
			System.out.println("EXTENDED MUSHROOMS Blocks DETECTED AND LOADED carpetstairsmod COMPAT");
			compatList.add(ExtendedMushroomsCompat::new);
		}

	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		for(Supplier<ICarpetStairsCompat> compat : compatList)
		{
			compat.get().registerBlocks(event);
		}
	}

	@SubscribeEvent
	public static void onInterModEnqueue(InterModEnqueueEvent event)
	{
		for(Supplier<ICarpetStairsCompat> compat : compatList)
		{
			compat.get().registerPlaceEntries();
		}
	}
	
    public ItemGroup getTab() {
        return creativeTab;
    }
    
    private class CreativeTab extends ItemGroup
    {
    	public CreativeTab()
    	{
    		super(CarpetStairsMod.MODID);
		}

		public ItemStack createIcon()
    	{
    		return new ItemStack(ModBlocks.jungle_wood_floor);
    	}
    };
	
}
