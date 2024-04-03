package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

public enum MethodArguments implements ModifierContributor.ForMethod {
    PLAIN(0),
    VARARGS(128);
    
    private final int mask;

    private MethodArguments(int i11) {
        this.mask = i11;
    }

    public int getMask() {
        return this.mask;
    }

    public int getRange() {
        return 128;
    }

    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isVarArgs() {
        return this == VARARGS;
    }
}
