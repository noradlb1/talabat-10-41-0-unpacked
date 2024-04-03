package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import org.jetbrains.annotations.NotNull;

public interface NameResolver {
    @NotNull
    String getQualifiedClassName(int i11);

    @NotNull
    String getString(int i11);

    boolean isLocalClassName(int i11);
}
