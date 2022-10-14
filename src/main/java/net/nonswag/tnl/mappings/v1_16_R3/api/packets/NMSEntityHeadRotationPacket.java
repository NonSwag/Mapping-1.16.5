package net.nonswag.tnl.mappings.v1_16_R3.api.packets;

import net.minecraft.server.v1_16_R3.PacketPlayOutEntityHeadRotation;
import net.nonswag.core.api.reflection.Reflection;
import net.nonswag.tnl.listener.api.packets.EntityHeadRotationPacket;

import javax.annotation.Nonnull;

public final class NMSEntityHeadRotationPacket extends EntityHeadRotationPacket {

    NMSEntityHeadRotationPacket(int entityId, float yaw) {
        super(entityId, yaw);
    }

    @Nonnull
    @Override
    public PacketPlayOutEntityHeadRotation build() {
        PacketPlayOutEntityHeadRotation packet = new PacketPlayOutEntityHeadRotation();
        Reflection.Field.set(packet, "a", getEntityId());
        Reflection.Field.set(packet, "b", (byte) (getYaw() * 256 / 360));
        return packet;
    }
}
