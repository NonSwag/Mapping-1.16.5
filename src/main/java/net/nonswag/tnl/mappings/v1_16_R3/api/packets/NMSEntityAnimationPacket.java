package net.nonswag.tnl.mappings.v1_16_R3.api.packets;

import net.minecraft.server.v1_16_R3.PacketPlayOutAnimation;
import net.nonswag.core.api.reflection.Reflection;
import net.nonswag.tnl.listener.api.packets.EntityAnimationPacket;

import javax.annotation.Nonnull;

public final class NMSEntityAnimationPacket extends EntityAnimationPacket {

    NMSEntityAnimationPacket(int entityId, @Nonnull Animation animation) {
        super(entityId, animation);
    }

    @Nonnull
    @Override
    public PacketPlayOutAnimation build() {
        PacketPlayOutAnimation packet = new PacketPlayOutAnimation();
        Reflection.Field.set(packet, "a", getEntityId());
        Reflection.Field.set(packet, "b", getAnimation().getId());
        return packet;
    }
}
