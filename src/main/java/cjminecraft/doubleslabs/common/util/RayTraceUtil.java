package cjminecraft.doubleslabs.common.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.ForgeMod;

public class RayTraceUtil {

    public static BlockRayTraceResult rayTrace(PlayerEntity player) {
        double length = player.getAttribute(ForgeMod.REACH_DISTANCE.get()).getValue();
        Vector3d startPos = new Vector3d(player.getPosX(), player.getPosY() + player.getEyeHeight(), player.getPosZ());
        Vector3d endPos = startPos.add(player.getLookVec().x * length, player.getLookVec().y * length, player.getLookVec().z * length);
        RayTraceContext rayTraceContext = new RayTraceContext(startPos, endPos, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, player);
        return player.world.rayTraceBlocks(rayTraceContext);
    }

}
