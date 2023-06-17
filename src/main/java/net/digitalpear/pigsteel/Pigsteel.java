package net.digitalpear.pigsteel;


import net.digitalpear.pigsteel.common.worldgen.PigsteelFeature;
import net.digitalpear.pigsteel.register.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.item.trim.ArmorTrimMaterials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SuppressWarnings({"unused"})
public class Pigsteel implements ModInitializer {
	public static final String MOD_ID = "pigsteel";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		PigsteelBlocks.init();
		PigsteelItems.init();
		PigsteelFeature.init();
		PigsteelConfiguredFeatures.init();
		PigsteelPlacedFeatures.init();
		PigsteelData.init();
		PigsteelArmorTrimMaterials.init();

		LOGGER.info("Let there be pigsteel!");
	}
}
