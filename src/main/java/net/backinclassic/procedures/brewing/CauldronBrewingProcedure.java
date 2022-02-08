package net.backinclassic.procedures.brewing;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.backinclassic.block.AwkwardCauldronBlock;
import net.backinclassic.block.SpeedCauldronBlock;
import net.backinclassic.block.JumpingCauldronBlock;
import net.backinclassic.block.SlownessCauldronBlock;
import net.backinclassic.block.HealingCauldronBlock;
import net.backinclassic.block.HarmingCauldronBlock;
import net.backinclassic.block.FireCauldronBlock;
import net.backinclassic.block.InvisibleCauldronBlock;
import net.backinclassic.block.NightCauldronBlock;
import net.backinclassic.block.PoisonCauldronBlock;
import net.backinclassic.block.RegenCauldronBlock;
import net.backinclassic.block.SlowfallCauldronBlock;
import net.backinclassic.block.StrengthCauldronBlock;
import net.backinclassic.block.WaterCauldronBlock;
import net.backinclassic.block.WeaknessCauldronBlock;
import net.backinclassic.BackInClassicMod;

import java.util.Map;
import java.util.HashMap;

public class CauldronBrewingProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure Caultrontoawkward!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure Caultrontoawkward!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure Caultrontoawkward!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure Caultrontoawkward!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure Caultrontoawkward!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == new ItemStack(Items.NETHER_WART, (int) (1)).getItem())
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAULDRON))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), AwkwardCauldronBlock.block.getDefaultState(), 3);
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.SUGAR, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SpeedCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SpeedCauldronBlock.block.getDefaultState().getBlock()) || 
                ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == JumpingCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.FERMENTED_SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SlownessCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.RABBIT_FOOT, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), JumpingCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.BLAZE_POWDER, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StrengthCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.NETHER_WART, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WeaknessCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.GLISTERING_MELON_SLICE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), HealingCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PoisonCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PoisonCauldronBlock.block.getDefaultState().getBlock()) || 
                ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == HealingCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.FERMENTED_SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), HarmingCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.GHAST_TEAR, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RegenCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.MAGMA_CREAM, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), FireCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.PUFFERFISH, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WaterCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.GOLDEN_CARROT, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), NightCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NightCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.FERMENTED_SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), InvisibleCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.PHANTOM_MEMBRANE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PoisonCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.FERMENTED_SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WeaknessCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
	}
}