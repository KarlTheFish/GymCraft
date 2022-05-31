package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GymCraft implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("gymcraft");

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("gymcraft", "gymcraft"),
			() -> new ItemStack(Blocks.BEDROCK));

	public static final StatusEffect STRONG = new StrongStatusEffect();

	public static final Dumbbell dumbbell = new Dumbbell(new Item.Settings().group(GymCraft.ITEM_GROUP).maxCount(1));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.STATUS_EFFECT, new Identifier("gymcraft", "strong"), STRONG);

		Registry.register(Registry.ITEM, new Identifier("gymcraft", "dumbbell"), dumbbell);

	}
}
