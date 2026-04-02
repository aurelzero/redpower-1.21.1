package wellick.redpower;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wellick.redpower.block.ModBlocks;
import wellick.redpower.item.ModItemGroups;
import wellick.redpower.item.ModItems;

public class Redpower implements ModInitializer {
	public static final String MOD_ID = "redpower";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();

		FuelRegistry.INSTANCE.add(ModItems.COKE, 6400);
	}
}