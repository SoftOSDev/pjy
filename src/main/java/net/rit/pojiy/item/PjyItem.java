
package net.rit.pojiy.item;

import net.rit.pojiy.procedures.PjyDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhiProcedure;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.InteractionResult;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class PjyItem extends Item {
	public PjyItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> content.accept(this));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		PjyDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhiProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", context.getLevel()).put("x", context.getClickedPos().getX())
				.put("y", context.getClickedPos().getY()).put("z", context.getClickedPos().getZ()).put("entity", context.getPlayer()).build());
		return retval;
	}
}
