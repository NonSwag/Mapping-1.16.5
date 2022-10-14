package net.nonswag.tnl.mappings.v1_16_R3.api.packets;

import net.minecraft.server.v1_16_R3.PacketPlayOutEntityTeleport;
import net.nonswag.core.api.reflection.Reflection;
import net.nonswag.tnl.listener.api.location.Position;
import net.nonswag.tnl.listener.api.packets.EntityTeleportPacket;

import javax.annotation.Nonnull;

public final class NMSEntityTeleportPacket extends EntityTeleportPacket {

    NMSEntityTeleportPacket(int entityId, @Nonnull Position position) {
        super(entityId, position);
    }

    @Nonnull
    @Override
    public PacketPlayOutEntityTeleport build() {
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport();
        Reflection.Field.set(packet, "a", getEntityId());
        Reflection.Field.set(packet, "b", getPosition().getX());
        Reflection.Field.set(packet, "c", getPosition().getY());
        Reflection.Field.set(packet, "d", getPosition().getZ());
        Reflection.Field.set(packet, "e", (byte) ((int) (getPosition().getYaw() * 256.0F / 360.0F)));
        Reflection.Field.set(packet, "f", (byte) ((int) (getPosition().getPitch() * 256.0F / 360.0F)));
        Reflection.Field.set(packet, "g", false);
        return packet;
    }
}
