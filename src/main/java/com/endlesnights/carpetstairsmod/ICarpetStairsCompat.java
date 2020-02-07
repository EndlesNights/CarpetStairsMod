package com.endlesnights.carpetstairsmod;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

public interface ICarpetStairsCompat
{
	public void registerBlocks(RegistryEvent.Register<Block> event);
	public void registerPlaceEntries();
}
