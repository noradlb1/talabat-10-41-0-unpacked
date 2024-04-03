package com.instabug.library.diagnostics.sdkEvents.models;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f34338a;

    /* renamed from: b  reason: collision with root package name */
    private final int f34339b;

    public a(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.f34338a = str;
        this.f34339b = i11;
    }

    public final int a() {
        return this.f34339b;
    }

    @NotNull
    public final String b() {
        return this.f34338a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual((Object) this.f34338a, (Object) aVar.f34338a) && this.f34339b == aVar.f34339b;
    }

    public int hashCode() {
        return (this.f34338a.hashCode() * 31) + this.f34339b;
    }

    @NotNull
    public String toString() {
        return "SDKEvent(key=" + this.f34338a + ", count=" + this.f34339b + ')';
    }
}
