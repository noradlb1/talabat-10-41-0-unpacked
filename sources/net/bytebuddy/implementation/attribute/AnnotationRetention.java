package net.bytebuddy.implementation.attribute;

public enum AnnotationRetention {
    ENABLED(true),
    DISABLED(false);
    
    private final boolean enabled;

    private AnnotationRetention(boolean z11) {
        this.enabled = z11;
    }

    public static AnnotationRetention of(boolean z11) {
        return z11 ? ENABLED : DISABLED;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
