package gregtech.api.unification.ore;

import gregtech.api.unification.stack.UnificationEntry;
import gregtech.api.unification.stack.SimpleItemStack;

@FunctionalInterface
public interface IOreRegistrationHandler {

    void registerOre(UnificationEntry entry, String modName, SimpleItemStack itemStack);

}