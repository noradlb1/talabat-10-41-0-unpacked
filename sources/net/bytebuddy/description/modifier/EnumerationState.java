package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

public enum EnumerationState implements ModifierContributor.ForType, ModifierContributor.ForField {
    PLAIN(0),
    ENUMERATION(16384);
    
    private final int mask;

    private EnumerationState(int i11) {
        this.mask = i11;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 16384;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isEnumeration() {
        return this == ENUMERATION;
    }
}
