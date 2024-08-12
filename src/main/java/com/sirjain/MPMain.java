package com.sirjain;

import com.sirjain.content.MPItems;
import com.sirjain.content.MPUtil;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MPMain implements ModInitializer {
	public static final String MOD_ID = "more_potions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing More Potions mod!");

		MPItems.registerItems();
		MPUtil.registerPotions();
		MPUtil.registerRecipes();
	}
}