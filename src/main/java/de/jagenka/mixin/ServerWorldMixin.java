package de.jagenka.mixin;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerWorld.class)
public class ServerWorldMixin
{
    @Shadow
    @Final
    List<ServerPlayerEntity> players;

    /**
     * this method resets the time since rest for all online players after skipping the night with sleeping
     * this effectively resets their insomnia
     */
    @Inject(at = @At("HEAD"), method = "wakeSleepingPlayers")
    private void resetInsomniaAfterSkippingNight(CallbackInfo info)
    {
        players.stream().toList().forEach(player -> player.resetStat(Stats.CUSTOM.getOrCreateStat(Stats.TIME_SINCE_REST)));
    }
}