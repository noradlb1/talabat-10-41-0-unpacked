package com.instabug.apm.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private long f45487a;

    /* renamed from: b  reason: collision with root package name */
    private long f45488b;

    /* renamed from: c  reason: collision with root package name */
    private long f45489c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f45490d;

    public b() {
        this(0, 0, 0, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public b(long j11, long j12, long j13, @Nullable String str) {
        this.f45487a = j11;
        this.f45488b = j12;
        this.f45489c = j13;
        this.f45490d = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(long r7, long r9, long r11, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0008
            r2 = r0
            goto L_0x0009
        L_0x0008:
            r2 = r7
        L_0x0009:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000f
            r4 = r0
            goto L_0x0010
        L_0x000f:
            r4 = r9
        L_0x0010:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = r11
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001b
            r13 = 0
        L_0x001b:
            r14 = r13
            r7 = r6
            r8 = r2
            r10 = r4
            r12 = r0
            r7.<init>(r8, r10, r12, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.model.b.<init>(long, long, long, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long a() {
        return this.f45489c;
    }

    public final void a(long j11) {
        this.f45489c = j11;
    }

    @Nullable
    public final String b() {
        return this.f45490d;
    }

    public final void b(long j11) {
        this.f45488b = j11;
    }

    public final long c() {
        return this.f45488b;
    }

    public final void c(long j11) {
        this.f45487a = j11;
    }

    public final long d() {
        return this.f45487a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f45487a == bVar.f45487a && this.f45488b == bVar.f45488b && this.f45489c == bVar.f45489c && Intrinsics.areEqual((Object) this.f45490d, (Object) bVar.f45490d);
    }

    public int hashCode() {
        int a11 = ((((a.a(this.f45487a) * 31) + a.a(this.f45488b)) * 31) + a.a(this.f45489c)) * 31;
        String str = this.f45490d;
        return a11 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "AppLaunchStageDetails(stageStartTimeStampMicro=" + this.f45487a + ", stageStartTimeMicro=" + this.f45488b + ", stageEndTimeMicro=" + this.f45489c + ", stageScreenName=" + this.f45490d + ')';
    }
}
