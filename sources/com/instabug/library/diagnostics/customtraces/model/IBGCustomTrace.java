package com.instabug.library.diagnostics.customtraces.model;

import androidx.annotation.WorkerThread;
import com.instabug.library.diagnostics.customtraces.a;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.HashMap;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IBGCustomTrace {
    @NotNull
    private HashMap<String, String> attributes;
    @NotNull
    private final a customTracesManager;
    private long duration;
    private long endTimeMicros;
    private boolean endedInBG;

    /* renamed from: id  reason: collision with root package name */
    private long f34230id;
    @NotNull
    private final Object lock;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f34231name;
    private long startTime;
    private final long startTimeMicros;
    private final boolean startedInBG;

    public IBGCustomTrace() {
        this(0, (String) null, 0, 0, 0, false, false, (HashMap) null, 0, 511, (DefaultConstructorMarker) null);
    }

    public IBGCustomTrace(long j11, @NotNull String str, long j12, long j13, long j14, boolean z11, boolean z12, @NotNull HashMap<String, String> hashMap, long j15) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(hashMap, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.f34230id = j11;
        this.f34231name = str;
        this.startTimeMicros = j12;
        this.endTimeMicros = j13;
        this.duration = j14;
        this.startedInBG = z11;
        this.endedInBG = z12;
        this.attributes = hashMap;
        this.startTime = j15;
        this.customTracesManager = com.instabug.library.diagnostics.customtraces.di.a.d();
        this.lock = new Object();
    }

    public static /* synthetic */ IBGCustomTrace copy$default(IBGCustomTrace iBGCustomTrace, long j11, String str, long j12, long j13, long j14, boolean z11, boolean z12, HashMap hashMap, long j15, int i11, Object obj) {
        IBGCustomTrace iBGCustomTrace2 = iBGCustomTrace;
        int i12 = i11;
        return iBGCustomTrace.copy((i12 & 1) != 0 ? iBGCustomTrace2.f34230id : j11, (i12 & 2) != 0 ? iBGCustomTrace2.f34231name : str, (i12 & 4) != 0 ? iBGCustomTrace2.startTimeMicros : j12, (i12 & 8) != 0 ? iBGCustomTrace2.endTimeMicros : j13, (i12 & 16) != 0 ? iBGCustomTrace2.duration : j14, (i12 & 32) != 0 ? iBGCustomTrace2.startedInBG : z11, (i12 & 64) != 0 ? iBGCustomTrace2.endedInBG : z12, (i12 & 128) != 0 ? iBGCustomTrace2.attributes : hashMap, (i12 & 256) != 0 ? iBGCustomTrace2.startTime : j15);
    }

    public static /* synthetic */ void end$default(IBGCustomTrace iBGCustomTrace, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = System.nanoTime() / ((long) 1000);
        }
        iBGCustomTrace.end(j11);
    }

    public final long component1() {
        return this.f34230id;
    }

    @NotNull
    public final String component2() {
        return this.f34231name;
    }

    public final long component3() {
        return this.startTimeMicros;
    }

    public final long component4() {
        return this.endTimeMicros;
    }

    public final long component5() {
        return this.duration;
    }

    public final boolean component6() {
        return this.startedInBG;
    }

    public final boolean component7() {
        return this.endedInBG;
    }

    @NotNull
    public final HashMap<String, String> component8() {
        return this.attributes;
    }

    public final long component9() {
        return this.startTime;
    }

    @NotNull
    public final IBGCustomTrace copy(long j11, @NotNull String str, long j12, long j13, long j14, boolean z11, boolean z12, @NotNull HashMap<String, String> hashMap, long j15) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "name");
        HashMap<String, String> hashMap2 = hashMap;
        Intrinsics.checkNotNullParameter(hashMap2, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        return new IBGCustomTrace(j11, str2, j12, j13, j14, z11, z12, hashMap2, j15);
    }

    @WorkerThread
    @JvmOverloads
    public final void end() {
        end$default(this, 0, 1, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        return;
     */
    @androidx.annotation.WorkerThread
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void end(long r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.lock
            monitor-enter(r0)
            r1 = 0
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0058
            long r1 = r11.getStartTimeMicros()     // Catch:{ all -> 0x0055 }
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0012
            goto L_0x0058
        L_0x0012:
            com.instabug.library.tracking.InstabugInternalTrackingDelegate r1 = com.instabug.library.tracking.InstabugInternalTrackingDelegate.getInstance()     // Catch:{ all -> 0x0055 }
            int r1 = r1.getStartedActivitiesNumber()     // Catch:{ all -> 0x0055 }
            if (r1 > 0) goto L_0x001e
            r1 = 1
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            long r2 = r11.getStartTimeMicros()     // Catch:{ all -> 0x0055 }
            long r8 = r12 - r2
            java.lang.Long r10 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0055 }
            r10.longValue()     // Catch:{ all -> 0x0055 }
            com.instabug.library.diagnostics.customtraces.a r2 = r11.customTracesManager     // Catch:{ all -> 0x0055 }
            long r3 = r11.getId()     // Catch:{ all -> 0x0055 }
            r5 = r8
            r7 = r1
            java.lang.Boolean r2 = r2.endTrace(r3, r5, r7)     // Catch:{ all -> 0x0055 }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0055 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r10 = 0
        L_0x0042:
            if (r10 != 0) goto L_0x0045
            goto L_0x0053
        L_0x0045:
            r10.longValue()     // Catch:{ all -> 0x0055 }
            r11.setEndTimeMicros(r12)     // Catch:{ all -> 0x0055 }
            r11.setDuration(r8)     // Catch:{ all -> 0x0055 }
            r11.setEndedInBG(r1)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r0)
            return
        L_0x0055:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        L_0x0058:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace.end(long):void");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IBGCustomTrace)) {
            return false;
        }
        IBGCustomTrace iBGCustomTrace = (IBGCustomTrace) obj;
        return this.f34230id == iBGCustomTrace.f34230id && Intrinsics.areEqual((Object) this.f34231name, (Object) iBGCustomTrace.f34231name) && this.startTimeMicros == iBGCustomTrace.startTimeMicros && this.endTimeMicros == iBGCustomTrace.endTimeMicros && this.duration == iBGCustomTrace.duration && this.startedInBG == iBGCustomTrace.startedInBG && this.endedInBG == iBGCustomTrace.endedInBG && Intrinsics.areEqual((Object) this.attributes, (Object) iBGCustomTrace.attributes) && this.startTime == iBGCustomTrace.startTime;
    }

    @NotNull
    public final HashMap<String, String> getAttributes() {
        return this.attributes;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getEndTimeMicros() {
        return this.endTimeMicros;
    }

    public final boolean getEndedInBG() {
        return this.endedInBG;
    }

    public final long getId() {
        return this.f34230id;
    }

    @NotNull
    public final String getName() {
        return this.f34231name;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getStartTimeMicros() {
        return this.startTimeMicros;
    }

    public final boolean getStartedInBG() {
        return this.startedInBG;
    }

    public int hashCode() {
        int a11 = ((((((((l.a.a(this.f34230id) * 31) + this.f34231name.hashCode()) * 31) + l.a.a(this.startTimeMicros)) * 31) + l.a.a(this.endTimeMicros)) * 31) + l.a.a(this.duration)) * 31;
        boolean z11 = this.startedInBG;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (a11 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.endedInBG;
        if (!z13) {
            z12 = z13;
        }
        return ((((i11 + (z12 ? 1 : 0)) * 31) + this.attributes.hashCode()) * 31) + l.a.a(this.startTime);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007f, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0055  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAttribute(@org.jetbrains.annotations.Nullable java.lang.String r6, @org.jetbrains.annotations.Nullable java.lang.String r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            long r1 = r5.getEndTimeMicros()     // Catch:{ all -> 0x0080 }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)
            return
        L_0x000f:
            r1 = 0
            if (r6 != 0) goto L_0x0014
            r6 = r1
            goto L_0x001a
        L_0x0014:
            com.instabug.library.diagnostics.customtraces.utils.b r2 = com.instabug.library.diagnostics.customtraces.utils.b.f34240a     // Catch:{ all -> 0x0080 }
            java.lang.String r6 = r2.b(r6)     // Catch:{ all -> 0x0080 }
        L_0x001a:
            if (r7 != 0) goto L_0x001d
            goto L_0x0023
        L_0x001d:
            com.instabug.library.diagnostics.customtraces.utils.b r1 = com.instabug.library.diagnostics.customtraces.utils.b.f34240a     // Catch:{ all -> 0x0080 }
            java.lang.String r1 = r1.c(r7)     // Catch:{ all -> 0x0080 }
        L_0x0023:
            if (r6 != 0) goto L_0x0026
            goto L_0x007e
        L_0x0026:
            java.util.HashMap r7 = r5.getAttributes()     // Catch:{ all -> 0x0080 }
            boolean r7 = r7.containsKey(r6)     // Catch:{ all -> 0x0080 }
            if (r7 == 0) goto L_0x003b
            com.instabug.library.diagnostics.customtraces.a r7 = r5.customTracesManager     // Catch:{ all -> 0x0080 }
            long r2 = r5.getId()     // Catch:{ all -> 0x0080 }
            java.lang.Boolean r7 = r7.updateAttribute(r2, r6, r1)     // Catch:{ all -> 0x0080 }
            goto L_0x0062
        L_0x003b:
            java.util.HashMap r7 = r5.getAttributes()     // Catch:{ all -> 0x0080 }
            int r7 = r7.size()     // Catch:{ all -> 0x0080 }
            r2 = 5
            if (r7 == r2) goto L_0x0060
            if (r1 == 0) goto L_0x0051
            int r7 = r1.length()     // Catch:{ all -> 0x0080 }
            if (r7 != 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r7 = 0
            goto L_0x0052
        L_0x0051:
            r7 = 1
        L_0x0052:
            if (r7 == 0) goto L_0x0055
            goto L_0x0060
        L_0x0055:
            com.instabug.library.diagnostics.customtraces.a r7 = r5.customTracesManager     // Catch:{ all -> 0x0080 }
            long r2 = r5.getId()     // Catch:{ all -> 0x0080 }
            java.lang.Boolean r7 = r7.setAttribute(r2, r6, r1)     // Catch:{ all -> 0x0080 }
            goto L_0x0062
        L_0x0060:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0080 }
        L_0x0062:
            if (r7 != 0) goto L_0x0065
            goto L_0x007e
        L_0x0065:
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x0080 }
            if (r7 == 0) goto L_0x007c
            if (r1 != 0) goto L_0x0075
            java.util.HashMap r7 = r5.getAttributes()     // Catch:{ all -> 0x0080 }
            r7.remove(r6)     // Catch:{ all -> 0x0080 }
            goto L_0x007c
        L_0x0075:
            java.util.HashMap r7 = r5.getAttributes()     // Catch:{ all -> 0x0080 }
            r7.put(r6, r1)     // Catch:{ all -> 0x0080 }
        L_0x007c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0080 }
        L_0x007e:
            monitor-exit(r0)
            return
        L_0x0080:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace.setAttribute(java.lang.String, java.lang.String):void");
    }

    public final void setAttributes(@NotNull HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.attributes = hashMap;
    }

    public final void setDuration(long j11) {
        this.duration = j11;
    }

    public final void setEndTimeMicros(long j11) {
        this.endTimeMicros = j11;
    }

    public final void setEndedInBG(boolean z11) {
        this.endedInBG = z11;
    }

    public final void setId(long j11) {
        this.f34230id = j11;
    }

    public final void setStartTime(long j11) {
        this.startTime = j11;
    }

    @NotNull
    public String toString() {
        return "IBGCustomTrace(id=" + this.f34230id + ", name=" + this.f34231name + ", startTimeMicros=" + this.startTimeMicros + ", endTimeMicros=" + this.endTimeMicros + ", duration=" + this.duration + ", startedInBG=" + this.startedInBG + ", endedInBG=" + this.endedInBG + ", attributes=" + this.attributes + ", startTime=" + this.startTime + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ IBGCustomTrace(long r16, java.lang.String r18, long r19, long r21, long r23, boolean r25, boolean r26, java.util.HashMap r27, long r28, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            r2 = -1
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000c
        L_0x000a:
            r4 = r16
        L_0x000c:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0013
            java.lang.String r1 = ""
            goto L_0x0015
        L_0x0013:
            r1 = r18
        L_0x0015:
            r6 = r0 & 4
            r7 = 0
            if (r6 == 0) goto L_0x001d
            r9 = r7
            goto L_0x001f
        L_0x001d:
            r9 = r19
        L_0x001f:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0025
            r11 = r7
            goto L_0x0027
        L_0x0025:
            r11 = r21
        L_0x0027:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r2 = r23
        L_0x002e:
            r6 = r0 & 32
            r13 = 0
            if (r6 == 0) goto L_0x0035
            r6 = r13
            goto L_0x0037
        L_0x0035:
            r6 = r25
        L_0x0037:
            r14 = r0 & 64
            if (r14 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r13 = r26
        L_0x003e:
            r14 = r0 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x0048
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            goto L_0x004a
        L_0x0048:
            r14 = r27
        L_0x004a:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r7 = r28
        L_0x0051:
            r16 = r15
            r17 = r4
            r19 = r1
            r20 = r9
            r22 = r11
            r24 = r2
            r26 = r6
            r27 = r13
            r28 = r14
            r29 = r7
            r16.<init>(r17, r19, r20, r22, r24, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace.<init>(long, java.lang.String, long, long, long, boolean, boolean, java.util.HashMap, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
