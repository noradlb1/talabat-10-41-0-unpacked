package org.mockito.internal.util.reflection;

public class FieldInitializationReport {
    private final Object fieldInstance;
    private final boolean wasInitialized;
    private final boolean wasInitializedUsingConstructorArgs;

    public FieldInitializationReport(Object obj, boolean z11, boolean z12) {
        this.fieldInstance = obj;
        this.wasInitialized = z11;
        this.wasInitializedUsingConstructorArgs = z12;
    }

    public Class<?> fieldClass() {
        Object obj = this.fieldInstance;
        if (obj != null) {
            return obj.getClass();
        }
        return null;
    }

    public Object fieldInstance() {
        return this.fieldInstance;
    }

    public boolean fieldWasInitialized() {
        return this.wasInitialized;
    }

    public boolean fieldWasInitializedUsingContructorArgs() {
        return this.wasInitializedUsingConstructorArgs;
    }
}
