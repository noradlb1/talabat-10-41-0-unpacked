package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

public enum FieldManifestation implements ModifierContributor.ForField {
    PLAIN(0),
    FINAL(16),
    VOLATILE(64);
    
    private final int mask;

    private FieldManifestation(int i11) {
        this.mask = i11;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 80;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isFinal() {
        return (this.mask & 16) != 0;
    }

    public boolean isPlain() {
        return !isFinal() && !isVolatile();
    }

    public boolean isVolatile() {
        return (this.mask & 64) != 0;
    }
}
