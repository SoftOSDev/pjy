package net.rit.pojiy.procedures;

import net.rit.pojiy.init.PojiyModItems;
import net.rit.pojiy.PojiyMod;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.util.Map;

public class PjyDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhiProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PojiyMod.LOGGER.warn("Failed to load dependency world for procedure PjyDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhi!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PojiyMod.LOGGER.warn("Failed to load dependency x for procedure PjyDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhi!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PojiyMod.LOGGER.warn("Failed to load dependency y for procedure PjyDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhi!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PojiyMod.LOGGER.warn("Failed to load dependency z for procedure PjyDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhi!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PojiyMod.LOGGER.warn("Failed to load dependency entity for procedure PjyDangYouJianDianJiFangKuaiShiFangKuaiDeWeiZhi!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (y == -64) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(PojiyModItems.PJY);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = Blocks.OBSIDIAN.defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
	}
}
