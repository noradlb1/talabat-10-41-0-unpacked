package com.instabug.terminations;

import androidx.annotation.RequiresApi;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(30)
public final class r implements b0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List f52650a;

    public r(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "foregroundTimeline");
        this.f52650a = list;
    }

    @NotNull
    public List a() {
        return this.f52650a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && Intrinsics.areEqual((Object) a(), (Object) ((r) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    @NotNull
    public String toString() {
        return "PostAndroidRTerminationSnapshot(foregroundTimeline=" + a() + ')';
    }
}
