package net.nonswag.tnl.mappings.v1_16_R3.api.item;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import net.minecraft.server.v1_16_R3.BlockComposter;
import net.minecraft.server.v1_16_R3.IMaterial;
import net.minecraft.server.v1_16_R3.Item;
import net.nonswag.core.api.reflection.Reflection;
import net.nonswag.tnl.listener.api.item.ItemHelper;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftMagicNumbers;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@Getter
public class NMSItemHelper extends ItemHelper {

    @Nullable
    private Map<Material, Float> compostableItems = null;

    @Override
    public void setMaxStackSize(@Nonnull Material material, int maxStackSize) {
        Reflection.Field.set(material, "maxStack", maxStackSize);
        Reflection.Field.set(Item.getById(material.ordinal()), Item.class, "maxStackSize", maxStackSize);
    }

    @Override
    public void setDurability(@Nonnull Material material, int durability) {
        Reflection.Field.set(material, "durability", durability);
        Reflection.Field.set(Item.getById(material.ordinal()), Item.class, "durability", durability);
    }

    @Nonnull
    @Override
    public Map<Material, Float> getCompostableItems() {
        if (compostableItems != null) return compostableItems;
        ImmutableMap.Builder<Material, Float> items = ImmutableMap.builder();
        var map = Reflection.Field.Static.<Map<IMaterial, Float>>get(BlockComposter.class, "b");
        if (map == null) map = new HashMap<>();
        map.forEach((item, weight) -> items.put(CraftMagicNumbers.getMaterial(item.getItem()), weight));
        return compostableItems = items.build();
    }
}
