package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ModuleCapability<T> {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f24483name;

    public ModuleCapability(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f24483name = str;
    }

    @NotNull
    public String toString() {
        return this.f24483name;
    }
}
