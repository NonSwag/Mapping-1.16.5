package net.nonswag.tnl.mappings.v1_16_R3.api.packets;

import net.minecraft.server.v1_16_R3.PacketPlayOutAttachEntity;
import net.nonswag.core.api.reflection.Reflection;
import net.nonswag.tnl.listener.api.packets.EntityAttachPacket;

import javax.annotation.Nonnull;

public final class NMSEntityAttachPacket extends EntityAttachPacket {

    NMSEntityAttachPacket(int holderId, int leashedId) {
        super(holderId, leashedId);
    }

    @Nonnull
    @Override
    public PacketPlayOutAttachEntity build() {
        PacketPlayOutAttachEntity packet = new PacketPlayOutAttachEntity();
        Reflection.Field.set(packet, "a", getHolderId());
        Reflection.Field.set(packet, "b", getLeashedId());
        return packet;
    }
}
