package net.digitalpear.pigsteel.init.tags;

import net.digitalpear.pigsteel.Pigsteel;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class PigsteelItemTags {

    public static final TagKey<Item> PIGSTEEL_ORES = of("pigsteel_ores");

    public static final TagKey<Item> C_ORES = of("c","ores");

    private static TagKey<Item> of(String id) {
        return of(Pigsteel.MOD_ID, id);
    }
    private static TagKey<Item> of(String modid,String id) {
        return TagKey.of(Registries.ITEM.getKey(), Identifier.of(modid, id));
    }
}
