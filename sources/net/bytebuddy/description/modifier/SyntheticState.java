package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

public enum SyntheticState implements ModifierContributor.ForType, ModifierContributor.ForMethod, ModifierContributor.ForField, ModifierContributor.ForParameter {
    PLAIN(0),
    SYNTHETIC(4096);
    
    private final int mask;

    private SyntheticState(int i11) {
        this.mask = i11;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 4096;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isSynthetic() {
        return this == SYNTHETIC;
    }
}
