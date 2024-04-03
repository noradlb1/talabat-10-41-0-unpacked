package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class Visibility {
    private final boolean isPublicAPI;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f24491name;

    public Visibility(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f24491name = str;
        this.isPublicAPI = z11;
    }

    @Nullable
    public Integer compareTo(@NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, visibility);
    }

    @NotNull
    public String getInternalDisplayName() {
        return this.f24491name;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    @NotNull
    public Visibility normalize() {
        return this;
    }

    @NotNull
    public final String toString() {
        return getInternalDisplayName();
    }
}
