package com.instabug.library.model.v3Session;

import com.instabug.library.model.State;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class j {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final i f51611d = new i((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f51612a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List f51613b;

    /* renamed from: c  reason: collision with root package name */
    private final int f51614c;

    public j(long j11, @NotNull List list, int i11) {
        Intrinsics.checkNotNullParameter(list, State.KEY_EXPERIMENTS);
        this.f51612a = j11;
        this.f51613b = list;
        this.f51614c = i11;
    }

    public final int a() {
        return this.f51614c;
    }

    @NotNull
    public final List b() {
        return this.f51613b;
    }

    public final long c() {
        return this.f51612a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f51612a == jVar.f51612a && Intrinsics.areEqual((Object) this.f51613b, (Object) jVar.f51613b) && this.f51614c == jVar.f51614c;
    }

    public int hashCode() {
        return (((a.a(this.f51612a) * 31) + this.f51613b.hashCode()) * 31) + this.f51614c;
    }

    @NotNull
    public String toString() {
        return "IBGSessionExperiments(sessionSerial=" + this.f51612a + ", experiments=" + this.f51613b + ", droppedCount=" + this.f51614c + ')';
    }
}
