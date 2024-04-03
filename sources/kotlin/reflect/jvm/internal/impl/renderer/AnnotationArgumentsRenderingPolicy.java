package kotlin.reflect.jvm.internal.impl.renderer;

public enum AnnotationArgumentsRenderingPolicy {
    NO_ARGUMENTS(false, false, 3, (boolean) null),
    UNLESS_EMPTY(true, false, 2, (boolean) null),
    ALWAYS_PARENTHESIZED(true, true);
    
    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    private AnnotationArgumentsRenderingPolicy(boolean z11, boolean z12) {
        this.includeAnnotationArguments = z11;
        this.includeEmptyAnnotationArguments = z12;
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }
}
