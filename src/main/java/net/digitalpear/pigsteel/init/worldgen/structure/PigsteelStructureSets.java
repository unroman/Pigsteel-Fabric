package net.digitalpear.pigsteel.init.worldgen.structure;

import net.digitalpear.pigsteel.Pigsteel;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.StructureSet;

import java.util.ArrayList;
import java.util.List;

public class PigsteelStructureSets {
    public static List<RegistryKey<StructureSet>> structures = new ArrayList<>();
    public static RegistryKey<StructureSet> of(String id) {
        RegistryKey<StructureSet> poolRegistryKey = RegistryKey.of(RegistryKeys.STRUCTURE_SET, Pigsteel.getModId(id));
        structures.add(poolRegistryKey);
        return poolRegistryKey;
    }

//    public static final RegistryKey<StructureSet> PIGSTEEL_MINE = of("pigsteel_mine");



    public static void bootstrap(Registerable<StructureSet> structureSetRegisterable) {
//        RegistryEntryLookup<Structure> registryEntryLookup = structureSetRegisterable.getRegistryLookup(RegistryKeys.STRUCTURE);
//        structureSetRegisterable.register(PIGSTEEL_MINE,
//                new StructureSet(
//                        registryEntryLookup.getOrThrow(PigsteelStructures.PIGSTEEL_MINE),
//                        new RandomSpreadStructurePlacement(
//                                32,
//                                8,
//                                SpreadType.LINEAR,
//                                14357617
//                        )
//                )
//        );


    }


}
