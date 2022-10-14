package net.nonswag.tnl.mappings.v1_16_R3.api.packets;

import net.minecraft.server.v1_16_R3.PacketPlayOutResourcePackSend;
import net.nonswag.tnl.listener.api.packets.ResourcePackPacket;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class NMSResourcePackPacket extends ResourcePackPacket {

    public NMSResourcePackPacket(@Nonnull String url, @Nullable String hash, @Nullable String prompt, boolean required) {
        super(url, hash, prompt, required);
    }

    @Nonnull
    @Override
    public PacketPlayOutResourcePackSend build() {
        return new PacketPlayOutResourcePackSend(getUrl(), String.valueOf(getHash()));
    }
}
