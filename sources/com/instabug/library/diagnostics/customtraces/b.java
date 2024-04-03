package com.instabug.library.diagnostics.customtraces;

import androidx.annotation.WorkerThread;
import com.instabug.library.diagnostics.customtraces.cache.CustomTracesCacheManager;
import com.instabug.library.diagnostics.customtraces.di.a;
import com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.threading.m;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wc.c;
import wc.d;
import wc.e;
import wc.f;
import wc.g;
import wc.h;
import wc.i;
import wc.j;

public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final CustomTracesCacheManager f34221a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f34222b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Object f34223c;

    public b(@NotNull CustomTracesCacheManager customTracesCacheManager, @NotNull ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(customTracesCacheManager, "cacheManager");
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "executor");
        this.f34221a = customTracesCacheManager;
        this.f34222b = threadPoolExecutor;
        this.f34223c = new Object();
    }

    /* access modifiers changed from: private */
    public static final void a(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        synchronized (bVar.f34223c) {
            bVar.f34221a.deleteAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void b(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        synchronized (bVar.f34223c) {
            bVar.f34221a.removeUnEndedTraces();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void clearCache() {
        this.f34222b.execute(new f(this));
    }

    public void clearSyncedTraces(@Nullable List list) {
        this.f34222b.execute(new c(this, list));
    }

    @Nullable
    public Boolean endTrace(long j11, long j12, boolean z11) {
        return (Boolean) m.a(this.f34222b, new h(this, j11, j12, z11));
    }

    @NotNull
    @WorkerThread
    public List getAllTraces() {
        List<IBGCustomTrace> allTraces;
        synchronized (this.f34223c) {
            allTraces = this.f34221a.getAllTraces();
        }
        return allTraces;
    }

    public void removeUnEndedTraces() {
        this.f34222b.execute(new wc.b(this));
    }

    @Nullable
    public Boolean setAttribute(long j11, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        return (Boolean) m.a(this.f34222b, new e(this, j11, str, str2));
    }

    @Nullable
    public Boolean updateAttribute(long j11, @NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        return (Boolean) m.a(this.f34222b, new i(this, j11, str, str2));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(CustomTracesCacheManager customTracesCacheManager, ThreadPoolExecutor threadPoolExecutor, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? a.f34228a.b() : customTracesCacheManager, (i11 & 2) != 0 ? a.f34228a.c() : threadPoolExecutor);
    }

    /* access modifiers changed from: private */
    public static final Boolean b(b bVar, long j11, String str, String str2) {
        Boolean valueOf;
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$key");
        synchronized (bVar.f34223c) {
            valueOf = Boolean.valueOf(bVar.f34221a.updateAttribute(j11, str, str2));
        }
        return valueOf;
    }

    @Nullable
    public IBGCustomTrace a(@Nullable String str, long j11) {
        return (IBGCustomTrace) m.a(this.f34222b, new g(this, Thread.currentThread().getStackTrace(), str, j11));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace a(com.instabug.library.diagnostics.customtraces.b r23, java.lang.StackTraceElement[] r24, java.lang.String r25, long r26) {
        /*
            r0 = r23
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.Object r1 = r0.f34223c
            monitor-enter(r1)
            com.instabug.library.diagnostics.customtraces.utils.b r2 = com.instabug.library.diagnostics.customtraces.utils.b.f34240a     // Catch:{ all -> 0x006f }
            r3 = r24
            boolean r3 = r2.a((java.lang.StackTraceElement[]) r3)     // Catch:{ all -> 0x006f }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x006f }
            boolean r4 = r3.booleanValue()     // Catch:{ all -> 0x006f }
            r5 = 0
            if (r4 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r3 = r5
        L_0x001f:
            if (r3 != 0) goto L_0x0022
            goto L_0x006d
        L_0x0022:
            r3.booleanValue()     // Catch:{ all -> 0x006f }
            r3 = r25
            java.lang.String r9 = r2.d(r3)     // Catch:{ all -> 0x006f }
            if (r9 != 0) goto L_0x002e
            goto L_0x006d
        L_0x002e:
            com.instabug.library.tracking.InstabugInternalTrackingDelegate r2 = com.instabug.library.tracking.InstabugInternalTrackingDelegate.getInstance()     // Catch:{ all -> 0x006f }
            int r2 = r2.getStartedActivitiesNumber()     // Catch:{ all -> 0x006f }
            if (r2 > 0) goto L_0x003a
            r2 = 1
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            r16 = r2
            long r2 = java.lang.System.nanoTime()     // Catch:{ all -> 0x006f }
            r4 = 1000(0x3e8, float:1.401E-42)
            long r6 = (long) r4     // Catch:{ all -> 0x006f }
            long r10 = r2 / r6
            com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace r2 = new com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace     // Catch:{ all -> 0x006f }
            r7 = 0
            r12 = 0
            r14 = 0
            r17 = 0
            r18 = 0
            r21 = 217(0xd9, float:3.04E-43)
            r22 = 0
            r6 = r2
            r19 = r26
            r6.<init>(r7, r9, r10, r12, r14, r16, r17, r18, r19, r21, r22)     // Catch:{ all -> 0x006f }
            com.instabug.library.diagnostics.customtraces.cache.CustomTracesCacheManager r0 = r0.f34221a     // Catch:{ all -> 0x006f }
            long r3 = r0.startTrace(r2)     // Catch:{ all -> 0x006f }
            r6 = -1
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x006d
            r2.setId(r3)     // Catch:{ all -> 0x006f }
            monitor-exit(r1)
            return r2
        L_0x006d:
            monitor-exit(r1)
            return r5
        L_0x006f:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.customtraces.b.a(com.instabug.library.diagnostics.customtraces.b, java.lang.StackTraceElement[], java.lang.String, long):com.instabug.library.diagnostics.customtraces.model.IBGCustomTrace");
    }

    public void a(@Nullable String str, long j11, long j12) {
        this.f34222b.execute(new d(this, Thread.currentThread().getStackTrace(), j11, j12, str));
    }

    /* access modifiers changed from: private */
    public static final void a(b bVar, StackTraceElement[] stackTraceElementArr, long j11, long j12, String str) {
        b bVar2 = bVar;
        long j13 = j11;
        long j14 = j12;
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        synchronized (bVar2.f34223c) {
            com.instabug.library.diagnostics.customtraces.utils.b bVar3 = com.instabug.library.diagnostics.customtraces.utils.b.f34240a;
            StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
            if ((bVar3.a(stackTraceElementArr) && bVar3.a(j11, j12) ? bVar2 : null) != null) {
                String d11 = bVar3.d(str);
                if (d11 != null) {
                    bVar2.f34221a.logTrace(d11, j11, j14 - j13, InstabugInternalTrackingDelegate.getInstance().getStartedActivitiesNumber() <= 0);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final Boolean a(b bVar, long j11, String str, String str2) {
        Boolean valueOf;
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$key");
        synchronized (bVar.f34223c) {
            valueOf = Boolean.valueOf(bVar.f34221a.setAttribute(j11, str, str2));
        }
        return valueOf;
    }

    /* access modifiers changed from: private */
    public static final Boolean a(b bVar, long j11, long j12, boolean z11) {
        Boolean valueOf;
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        synchronized (bVar.f34223c) {
            valueOf = Boolean.valueOf(bVar.f34221a.endTrace(j11, j12, z11));
        }
        return valueOf;
    }

    /* access modifiers changed from: private */
    public static final void a(b bVar, List list) {
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        synchronized (bVar.f34223c) {
            if (list != null) {
                bVar.f34221a.clearSyncedTraces(list);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "flagName");
        this.f34222b.execute(new j(this, str));
    }

    /* access modifiers changed from: private */
    public static final void a(b bVar, String str) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$flagName");
        synchronized (bVar.f34223c) {
            boolean z11 = false;
            if (Intrinsics.areEqual((Object) str, (Object) "record_sdk_launch_trace")) {
                strArr = com.instabug.library.diagnostics.a.f34216a.b();
            } else {
                strArr = Intrinsics.areEqual((Object) str, (Object) "record_sdk_feature_trace") ? com.instabug.library.diagnostics.a.f34216a.a() : new String[0];
            }
            if (strArr.length == 0) {
                z11 = true;
            }
            if (!(!z11)) {
                strArr = null;
            }
            if (strArr != null) {
                bVar.f34221a.clearTracesByName(strArr);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
