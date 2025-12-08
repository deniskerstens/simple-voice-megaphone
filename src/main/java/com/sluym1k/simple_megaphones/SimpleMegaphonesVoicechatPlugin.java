package com.sluym1k.simple_megaphones;

import com.sluym1k.simple_megaphones.item.ModItems;
import com.sluym1k.simple_megaphones.item.custom.Megaphone;
import de.maxhenkel.voicechat.api.Player;
import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.VoiceDistanceEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.maxhenkel.voicechat.api.ForgeVoicechatPlugin;
import de.maxhenkel.voicechat.api.VoicechatPlugin;

@ForgeVoicechatPlugin
public class SimpleMegaphonesVoicechatPlugin implements VoicechatPlugin {

    public static final String PLUGIN_ID = "simple_megaphones";
    public static final Logger LOGGER = LogManager.getLogger(PLUGIN_ID);

    @Override
    public String getPluginId() {
        return SimpleMegaphones.MODID;
    }

    @Override
    public void initialize(VoicechatApi api) {

    }

    @Override
    public void registerEvents(EventRegistration registration) {
        registration.registerEvent(VoiceDistanceEvent.class, this::voiceDistance);
    }

    public void voiceDistance(VoiceDistanceEvent e) {
        if (e.getSenderConnection() == null || !(e.getSenderConnection().getPlayer().getPlayer() instanceof ServerPlayer player)) {
            return;
        }
        if (player.isUsingItem()) {
            ItemStack heldItem = player.getItemInHand(InteractionHand.MAIN_HAND);

            if (player.getUseItem().is(ModItems.MEGAPHONE.get())) {
                e.setDistance(e.getDistance()*2);
            }
        }
    }
}
