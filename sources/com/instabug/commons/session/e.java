package com.instabug.commons.session;

import com.instabug.commons.models.Incident;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f46335a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f46336b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Incident.Type f46337c;

    /* renamed from: d  reason: collision with root package name */
    private final int f46338d;

    /* renamed from: e  reason: collision with root package name */
    private final long f46339e;

    public e(@NotNull String str, @Nullable String str2, @NotNull Incident.Type type, int i11, long j11) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(type, "incidentType");
        this.f46335a = str;
        this.f46336b = str2;
        this.f46337c = type;
        this.f46338d = i11;
        this.f46339e = j11;
    }

    public final long a() {
        return this.f46339e;
    }

    @Nullable
    public final String b() {
        return this.f46336b;
    }

    @NotNull
    public final Incident.Type c() {
        return this.f46337c;
    }

    @NotNull
    public final String d() {
        return this.f46335a;
    }

    public final int e() {
        return this.f46338d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.areEqual((Object) this.f46335a, (Object) eVar.f46335a) && Intrinsics.areEqual((Object) this.f46336b, (Object) eVar.f46336b) && this.f46337c == eVar.f46337c && this.f46338d == eVar.f46338d && this.f46339e == eVar.f46339e;
    }

    public final boolean f() {
        return this.f46338d > 0;
    }

    public int hashCode() {
        int hashCode = this.f46335a.hashCode() * 31;
        String str = this.f46336b;
        return ((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f46337c.hashCode()) * 31) + this.f46338d) * 31) + a.a(this.f46339e);
    }

    @NotNull
    public String toString() {
        return "SessionIncident(sessionId=" + this.f46335a + ", incidentId=" + this.f46336b + ", incidentType=" + this.f46337c + ", validationStatus=" + this.f46338d + ", id=" + this.f46339e + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(String str, String str2, Incident.Type type, int i11, long j11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, type, (i12 & 8) != 0 ? 0 : i11, (i12 & 16) != 0 ? System.currentTimeMillis() : j11);
    }
}
