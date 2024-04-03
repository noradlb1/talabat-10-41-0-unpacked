package com.instabug.apm.cache.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final long f45204a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f45205b;

    /* renamed from: c  reason: collision with root package name */
    private final long f45206c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final List f45207d;

    public d(long j11, @NotNull String str, long j12, @NotNull List list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "events");
        this.f45204a = j11;
        this.f45205b = str;
        this.f45206c = j12;
        this.f45207d = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(long j11, String str, long j12, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, str, j12, (i11 & 8) != 0 ? new ArrayList() : list);
    }

    @NotNull
    public final List a() {
        return this.f45207d;
    }

    public final long b() {
        return this.f45204a;
    }

    @NotNull
    public final String c() {
        return this.f45205b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f45204a == dVar.f45204a && Intrinsics.areEqual((Object) this.f45205b, (Object) dVar.f45205b) && this.f45206c == dVar.f45206c && Intrinsics.areEqual((Object) this.f45207d, (Object) dVar.f45207d);
    }

    public int hashCode() {
        return (((((a.a(this.f45204a) * 31) + this.f45205b.hashCode()) * 31) + a.a(this.f45206c)) * 31) + this.f45207d.hashCode();
    }

    @NotNull
    public String toString() {
        return "FragmentSpansCacheModel(id=" + this.f45204a + ", name=" + this.f45205b + ", sessionId=" + this.f45206c + ", events=" + this.f45207d + ')';
    }
}
