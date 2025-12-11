package com.sluym1k.simplemegaphone;

import com.sluym1k.simplemegaphone.item.ModItems;
import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.events.ClientSoundEvent;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.MicrophonePacketEvent;
import de.maxhenkel.voicechat.api.events.VoiceDistanceEvent;
import de.maxhenkel.voicechat.api.opus.OpusDecoder;
import de.maxhenkel.voicechat.api.opus.OpusEncoder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.maxhenkel.voicechat.api.ForgeVoicechatPlugin;
import de.maxhenkel.voicechat.api.VoicechatPlugin;

@ForgeVoicechatPlugin
public class SimpleMegaphoneVoicechatPlugin implements VoicechatPlugin {

    public static final String PLUGIN_ID = "simplemegaphone";
    public static final Logger LOGGER = LogManager.getLogger(PLUGIN_ID);

    private static OpusEncoder ENCODER;
    private static OpusDecoder DECODER;

    @Override
    public String getPluginId() {
        return SimpleMegaphone.MODID;
    }

    @Override
    public void initialize(VoicechatApi api) {
        ENCODER = api.createEncoder();
        DECODER = api.createDecoder();
    }

    @Override
    public void registerEvents(EventRegistration registration) {
        registration.registerEvent(VoiceDistanceEvent.class, this::voiceDistance);
//        registration.registerEvent(ClientSoundEvent.class, this::clientSound);
    }

    public void voiceDistance(VoiceDistanceEvent e) {
        if (e.getSenderConnection() == null || !(e.getSenderConnection().getPlayer().getPlayer() instanceof ServerPlayer player)) {
            return;
        }
        if (player.isUsingItem()) {
            if (player.getUseItem().is(ModItems.MEGAPHONE.get())) {
                e.setDistance(e.getDistance()*Config.distanceMultiplier);
            }
        }
    }
    public void clientSound(ClientSoundEvent e) {
        LocalPlayer player = Minecraft.getInstance().player;

        if (player.isUsingItem()) {
            if (player.getUseItem().is(ModItems.MEGAPHONE.get())) {
                short[] audio = e.getRawAudio();
                audio = distort(audio);
                e.setRawAudio(audio);
            }
        }
    }

    float lastValue = 0;
    public short[] distort(short[] audio) {
        float gain = 2.5f;
        short[] newAudio = new short[audio.length];

        for (int i = 0; i < audio.length; i++) {
            float value = audio[i]-lastValue;
            lastValue = audio[i];
            value *= gain;
            if (value >  32767.0f) {
                value = 32767.0f;
            } else if (value < -32767.0f) {
                value = -32767.0f;
            }
            newAudio[i] = (short) value;
        }
        return newAudio;
    }
}