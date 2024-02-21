
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.rit.pojiy.init;

import net.rit.pojiy.item.PjyItem;
import net.rit.pojiy.PojiyMod;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class PojiyModItems {
	public static Item PJY;

	public static void load() {
		PJY = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(PojiyMod.MODID, "pjy"), new PjyItem());
	}
}
