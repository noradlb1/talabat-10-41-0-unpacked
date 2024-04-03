package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

public enum Variance {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);
    
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    @NotNull
    private final String label;
    private final int superpositionFactor;

    private Variance(String str, boolean z11, boolean z12, int i11) {
        this.label = str;
        this.allowsInPosition = z11;
        this.allowsOutPosition = z12;
        this.superpositionFactor = i11;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public String toString() {
        return this.label;
    }
}
