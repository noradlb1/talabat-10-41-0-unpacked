package com.instabug.library.model.v3Session;

import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.sessionV3.providers.c;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g {
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public static final f f51597k = new f((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f51598a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f51599b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final y f51600c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final q f51601d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final b0 f51602e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f51603f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final a0 f51604g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final w f51605h;

    /* renamed from: i  reason: collision with root package name */
    private final long f51606i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final c0 f51607j;

    public g(long j11, @NotNull String str, @NotNull y yVar, @NotNull q qVar, @NotNull b0 b0Var, boolean z11, @NotNull a0 a0Var, @Nullable w wVar, long j12, @NotNull c0 c0Var) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(yVar, "userData");
        Intrinsics.checkNotNullParameter(qVar, "appData");
        Intrinsics.checkNotNullParameter(b0Var, "stitchingState");
        Intrinsics.checkNotNullParameter(a0Var, "startTime");
        Intrinsics.checkNotNullParameter(c0Var, "syncStatus");
        this.f51598a = j11;
        this.f51599b = str;
        this.f51600c = yVar;
        this.f51601d = qVar;
        this.f51602e = b0Var;
        this.f51603f = z11;
        this.f51604g = a0Var;
        this.f51605h = wVar;
        this.f51606i = j12;
        this.f51607j = c0Var;
    }

    public static /* synthetic */ g a(g gVar, long j11, String str, y yVar, q qVar, b0 b0Var, boolean z11, a0 a0Var, w wVar, long j12, c0 c0Var, int i11, Object obj) {
        g gVar2 = gVar;
        int i12 = i11;
        return gVar.a((i12 & 1) != 0 ? gVar2.f51598a : j11, (i12 & 2) != 0 ? gVar2.f51599b : str, (i12 & 4) != 0 ? gVar2.f51600c : yVar, (i12 & 8) != 0 ? gVar2.f51601d : qVar, (i12 & 16) != 0 ? gVar2.f51602e : b0Var, (i12 & 32) != 0 ? gVar2.f51603f : z11, (i12 & 64) != 0 ? gVar2.f51604g : a0Var, (i12 & 128) != 0 ? gVar2.f51605h : wVar, (i12 & 256) != 0 ? gVar2.f51606i : j12, (i12 & 512) != 0 ? gVar2.f51607j : c0Var);
    }

    @NotNull
    public final g a(long j11, @NotNull String str, @NotNull y yVar, @NotNull q qVar, @NotNull b0 b0Var, boolean z11, @NotNull a0 a0Var, @Nullable w wVar, long j12, @NotNull c0 c0Var) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "id");
        y yVar2 = yVar;
        Intrinsics.checkNotNullParameter(yVar2, "userData");
        q qVar2 = qVar;
        Intrinsics.checkNotNullParameter(qVar2, "appData");
        b0 b0Var2 = b0Var;
        Intrinsics.checkNotNullParameter(b0Var2, "stitchingState");
        a0 a0Var2 = a0Var;
        Intrinsics.checkNotNullParameter(a0Var2, "startTime");
        c0 c0Var2 = c0Var;
        Intrinsics.checkNotNullParameter(c0Var2, "syncStatus");
        return new g(j11, str2, yVar2, qVar2, b0Var2, z11, a0Var2, wVar, j12, c0Var2);
    }

    @NotNull
    public final q a() {
        return this.f51601d;
    }

    public final long b() {
        return this.f51606i;
    }

    @NotNull
    public final String c() {
        return this.f51599b;
    }

    @Nullable
    public final w d() {
        return this.f51605h;
    }

    public final long e() {
        return this.f51598a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f51598a == gVar.f51598a && Intrinsics.areEqual((Object) this.f51599b, (Object) gVar.f51599b) && Intrinsics.areEqual((Object) this.f51600c, (Object) gVar.f51600c) && Intrinsics.areEqual((Object) this.f51601d, (Object) gVar.f51601d) && this.f51602e == gVar.f51602e && this.f51603f == gVar.f51603f && Intrinsics.areEqual((Object) this.f51604g, (Object) gVar.f51604g) && Intrinsics.areEqual((Object) this.f51605h, (Object) gVar.f51605h) && this.f51606i == gVar.f51606i && this.f51607j == gVar.f51607j;
    }

    @NotNull
    public final a0 f() {
        return this.f51604g;
    }

    @NotNull
    public final b0 g() {
        return this.f51602e;
    }

    @NotNull
    public final c0 h() {
        return this.f51607j;
    }

    public int hashCode() {
        int a11 = ((((((((a.a(this.f51598a) * 31) + this.f51599b.hashCode()) * 31) + this.f51600c.hashCode()) * 31) + this.f51601d.hashCode()) * 31) + this.f51602e.hashCode()) * 31;
        boolean z11 = this.f51603f;
        if (z11) {
            z11 = true;
        }
        int hashCode = (((a11 + (z11 ? 1 : 0)) * 31) + this.f51604g.hashCode()) * 31;
        w wVar = this.f51605h;
        return ((((hashCode + (wVar == null ? 0 : wVar.hashCode())) * 31) + a.a(this.f51606i)) * 31) + this.f51607j.hashCode();
    }

    @NotNull
    public final y i() {
        return this.f51600c;
    }

    public final boolean j() {
        return this.f51603f;
    }

    @NotNull
    public String toString() {
        return "IBGSession(serial=" + this.f51598a + ", id=" + this.f51599b + ", userData=" + this.f51600c + ", appData=" + this.f51601d + ", stitchingState=" + this.f51602e + ", isV2SessionSent=" + this.f51603f + ", startTime=" + this.f51604g + ", productionUsage=" + this.f51605h + ", durationInMicro=" + this.f51606i + ", syncStatus=" + this.f51607j + ')';
    }

    public static /* synthetic */ g a(g gVar, u uVar, c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            cVar = com.instabug.library.sessionV3.di.c.f51790a.o();
        }
        return gVar.a(uVar, cVar);
    }

    @NotNull
    public final g a(@NotNull u uVar, @NotNull c cVar) {
        c cVar2 = cVar;
        Intrinsics.checkNotNullParameter(uVar, "sessionEvent");
        Intrinsics.checkNotNullParameter(cVar2, "dataProvider");
        return a(this, 0, (String) null, y.f51634g.a(cVar2), q.f51619f.a(cVar2), (b0) null, false, (a0) null, w.f51627g.a(cVar2), a(uVar), c0.OFFLINE, 115, (Object) null);
    }

    public static /* synthetic */ g a(g gVar, a0 a0Var, c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            cVar = com.instabug.library.sessionV3.di.c.f51790a.o();
        }
        return gVar.a(a0Var, cVar);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ g(long r17, java.lang.String r19, com.instabug.library.model.v3Session.y r20, com.instabug.library.model.v3Session.q r21, com.instabug.library.model.v3Session.b0 r22, boolean r23, com.instabug.library.model.v3Session.a0 r24, com.instabug.library.model.v3Session.w r25, long r26, com.instabug.library.model.v3Session.c0 r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000a
            r1 = -1
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r17
        L_0x000c:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0014
            r1 = 0
            r13 = r1
            goto L_0x0016
        L_0x0014:
            r13 = r26
        L_0x0016:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x001e
            com.instabug.library.model.v3Session.c0 r0 = com.instabug.library.model.v3Session.c0.RUNNING
            r15 = r0
            goto L_0x0020
        L_0x001e:
            r15 = r28
        L_0x0020:
            r3 = r16
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.v3Session.g.<init>(long, java.lang.String, com.instabug.library.model.v3Session.y, com.instabug.library.model.v3Session.q, com.instabug.library.model.v3Session.b0, boolean, com.instabug.library.model.v3Session.a0, com.instabug.library.model.v3Session.w, long, com.instabug.library.model.v3Session.c0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    public final g a(@NotNull a0 a0Var, @NotNull c cVar) {
        a0 a0Var2 = a0Var;
        c cVar2 = cVar;
        Intrinsics.checkNotNullParameter(a0Var2, "startTime");
        Intrinsics.checkNotNullParameter(cVar2, "dataProvider");
        return a(this, 0, (String) null, (y) null, (q) null, cVar2.a(a0Var2), false, a0Var2, (w) null, 0, (c0) null, 943, (Object) null);
    }

    private final long a(u uVar) {
        return uVar.b() - this.f51604g.d();
    }

    @NotNull
    public Map a(@NotNull Map map) {
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        Map a11 = this.f51604g.a(this.f51601d.a(this.f51600c.a(map)));
        w d11 = d();
        if (d11 != null) {
            d11.a(a11);
        }
        a11.put("id", c());
        a11.put("s2s", Boolean.valueOf(j()));
        b0 g11 = g();
        boolean z11 = true;
        if (g() == b0.BACKGROUND_SESSION) {
            g11 = null;
        }
        if (g11 != null) {
            if (g() != b0.SESSION_LEAD) {
                z11 = false;
            }
            a11.put("ss", Boolean.valueOf(z11));
        }
        a11.put("d", Long.valueOf(b()));
        return a11;
    }
}
