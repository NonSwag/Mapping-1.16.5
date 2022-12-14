package net.nonswag.tnl.mappings.v1_16_R3.api.packets;

import net.minecraft.server.v1_16_R3.PacketPlayOutMount;
import net.nonswag.core.api.reflection.Reflection;
import net.nonswag.tnl.listener.api.packets.MountPacket;

import javax.annotation.Nonnull;

public final class NMSMountPacket extends MountPacket {

    NMSMountPacket(int holderId, int[] mounts) {
        super(holderId, mounts);
    }

    @Nonnull
    @Override
    public PacketPlayOutMount build() {
        PacketPlayOutMount packet = new PacketPlayOutMount();
        Reflection.Field.set(packet, "a", getHolderId());
        Reflection.Field.set(packet, "b", getMounts());
        return packet;
    }
}
