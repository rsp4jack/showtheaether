package io.github.rsp4jack.showtheaether;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = Main.MODID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue ENABLE_MOD = BUILDER.comment("Enable the mod").define("enableMod", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean enableMod;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        Main.LOGGER.warn("Changed {}", ENABLE_MOD.get());
        enableMod = ENABLE_MOD.get();
    }
}
