package net.bytebuddy.dynamic.scaffold;

public enum TypeValidation {
    ENABLED(true),
    DISABLED(false);
    
    private final boolean enabled;

    private TypeValidation(boolean z11) {
        this.enabled = z11;
    }

    public static TypeValidation of(boolean z11) {
        return z11 ? ENABLED : DISABLED;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
