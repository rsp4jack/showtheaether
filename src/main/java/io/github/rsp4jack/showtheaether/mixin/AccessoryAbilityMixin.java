package io.github.rsp4jack.showtheaether.mixin;

import com.aetherteam.aether.client.event.listeners.abilities.AccessoryAbilityClientListener;
import io.github.rsp4jack.showtheaether.Config;
import net.neoforged.neoforge.client.event.RenderPlayerEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AccessoryAbilityClientListener.class)
public class AccessoryAbilityMixin {
    @Inject(method = "onRenderPlayer", at = @At("HEAD") , cancellable = true)
    private static void onRenderPlayer(RenderPlayerEvent.Pre event, CallbackInfo ci) {
        if (Config.enableMod) {
            ci.cancel();
        }
    }
}
