package com.instabug.library.sessionV3.manager;

import android.content.SharedPreferences;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.v3Session.a0;
import com.instabug.library.model.v3Session.e;
import com.instabug.library.model.v3Session.f;
import com.instabug.library.model.v3Session.g;
import com.instabug.library.model.v3Session.j;
import com.instabug.library.model.v3Session.l;
import com.instabug.library.model.v3Session.m;
import com.instabug.library.model.v3Session.n;
import com.instabug.library.model.v3Session.r;
import com.instabug.library.model.v3Session.s;
import com.instabug.library.model.v3Session.t;
import com.instabug.library.model.v3Session.u;
import com.instabug.library.sessionV3.cache.SessionCacheManager;
import com.instabug.library.sessionV3.configurations.c;
import com.instabug.library.sessionV3.providers.a;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TimeUtils;
import com.instabug.library.util.threading.PoolProvider;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import kd.b;
import kd.d;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class i {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final i f51800a = new i();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static volatile e f51801b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f51802c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Lazy f51803d = LazyKt__LazyJVMKt.lazy(b.f51793a);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Lazy f51804e = LazyKt__LazyJVMKt.lazy(d.f51795a);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final Lazy f51805f = LazyKt__LazyJVMKt.lazy(a.f51792a);
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final Lazy f51806g = LazyKt__LazyJVMKt.lazy(f.f51797a);
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final Lazy f51807h = LazyKt__LazyJVMKt.lazy(e.f51796a);
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final Lazy f51808i = LazyKt__LazyJVMKt.lazy(h.f51799a);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final Lazy f51809j = LazyKt__LazyJVMKt.lazy(c.f51794a);
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private static final Lazy f51810k = LazyKt__LazyJVMKt.lazy(g.f51798a);
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static volatile ScheduledFuture f51811l;

    private i() {
    }

    private final a b() {
        return (a) f51805f.getValue();
    }

    private final SessionCacheManager c() {
        return (SessionCacheManager) f51803d.getValue();
    }

    private final c d() {
        return (c) f51809j.getValue();
    }

    private final SharedPreferences.Editor f() {
        SharedPreferences l11 = l();
        if (l11 == null) {
            return null;
        }
        return l11.edit();
    }

    private final com.instabug.library.sessionV3.cache.e g() {
        return (com.instabug.library.sessionV3.cache.e) f51804e.getValue();
    }

    private final Executor h() {
        return (Executor) f51807h.getValue();
    }

    private final Executor j() {
        return (Executor) f51806g.getValue();
    }

    private final j k() {
        return (j) f51810k.getValue();
    }

    private final SharedPreferences l() {
        return com.instabug.library.sessionV3.di.c.f51790a.e();
    }

    private final m m() {
        return (m) f51808i.getValue();
    }

    private final void n() {
        if (f51811l == null && d().i() && d().f()) {
            f51811l = PoolProvider.postDelayedTaskAtFixedDelay(d().b(), d().b(), new kd.c());
        }
    }

    /* access modifiers changed from: private */
    public static final void o() {
        f51800a.j().execute(new kd.a());
    }

    /* access modifiers changed from: private */
    public static final void p() {
        f51800a.r();
    }

    private final void q() {
        Object obj;
        String str;
        try {
            Result.Companion companion = Result.Companion;
            ScheduledFuture scheduledFuture = f51811l;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            Unit unit = null;
            f51811l = null;
            SharedPreferences.Editor f11 = f();
            if (f11 != null) {
                e e11 = e();
                if (e11 == null) {
                    str = null;
                } else {
                    str = e11.a();
                }
                SharedPreferences.Editor remove = f11.remove(str);
                if (remove != null) {
                    remove.apply();
                    unit = Unit.INSTANCE;
                }
            }
            obj = Result.m6329constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        String str2 = "";
        if (r12 != null) {
            String message = r12.getMessage();
            if (message == null) {
                message = str2;
            }
            InstabugCore.reportError(r12, Intrinsics.stringPlus("Something went wrong while stopping session duration update", message));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            String message2 = r02.getMessage();
            if (message2 != null) {
                str2 = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while stopping session duration update", str2), r02);
        }
    }

    private final Object r() {
        Object obj;
        boolean z11;
        try {
            Result.Companion companion = Result.Companion;
            e e11 = e();
            Unit unit = null;
            if (e11 != null) {
                Long valueOf = Long.valueOf(TimeUtils.currentTimeStampMicroSeconds() - e11.b().d());
                if (valueOf.longValue() < 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    long longValue = valueOf.longValue();
                    SharedPreferences.Editor f11 = f();
                    if (f11 != null) {
                        SharedPreferences.Editor putLong = f11.putLong(e11.a(), longValue);
                        if (putLong != null) {
                            putLong.apply();
                            unit = Unit.INSTANCE;
                        }
                    }
                }
            }
            obj = Result.m6329constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        String str = "";
        if (r12 != null) {
            String message = r12.getMessage();
            if (message == null) {
                message = str;
            }
            InstabugCore.reportError(r12, Intrinsics.stringPlus("Something went wrong while updating session duration", message));
        }
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj);
        if (r13 != null) {
            String message2 = r13.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while updating session duration", str), r13);
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object s() {
        /*
            r6 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00d7 }
            com.instabug.library.model.v3Session.e r0 = r6.e()     // Catch:{ all -> 0x00d7 }
            if (r0 != 0) goto L_0x00be
            android.content.SharedPreferences r0 = r6.l()     // Catch:{ all -> 0x00d7 }
            if (r0 != 0) goto L_0x0010
            goto L_0x00be
        L_0x0010:
            java.util.Map r0 = r0.getAll()     // Catch:{ all -> 0x00d7 }
            if (r0 != 0) goto L_0x0018
            goto L_0x00be
        L_0x0018:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00d7 }
            r1.<init>()     // Catch:{ all -> 0x00d7 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x00d7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00d7 }
        L_0x0025:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x0050
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00d7 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00d7 }
            java.lang.Object r3 = r2.getValue()     // Catch:{ all -> 0x00d7 }
            if (r3 == 0) goto L_0x0041
            java.lang.Object r3 = r2.getValue()     // Catch:{ all -> 0x00d7 }
            boolean r3 = r3 instanceof java.lang.Long     // Catch:{ all -> 0x00d7 }
            if (r3 == 0) goto L_0x0041
            r3 = 1
            goto L_0x0042
        L_0x0041:
            r3 = 0
        L_0x0042:
            if (r3 == 0) goto L_0x0025
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00d7 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00d7 }
            r1.put(r3, r2)     // Catch:{ all -> 0x00d7 }
            goto L_0x0025
        L_0x0050:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00d7 }
            int r2 = r1.size()     // Catch:{ all -> 0x00d7 }
            r0.<init>(r2)     // Catch:{ all -> 0x00d7 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x00d7 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00d7 }
        L_0x0061:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00d7 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00d7 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00d7 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x0089
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x00d7 }
            long r4 = r2.longValue()     // Catch:{ all -> 0x00d7 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00d7 }
            kotlin.Pair r2 = kotlin.TuplesKt.to(r3, r2)     // Catch:{ all -> 0x00d7 }
            r0.add(r2)     // Catch:{ all -> 0x00d7 }
            goto L_0x0061
        L_0x0089:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Long"
            r0.<init>(r1)     // Catch:{ all -> 0x00d7 }
            throw r0     // Catch:{ all -> 0x00d7 }
        L_0x0091:
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00d7 }
        L_0x0095:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00d7 }
            if (r1 == 0) goto L_0x00be
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00d7 }
            kotlin.Pair r1 = (kotlin.Pair) r1     // Catch:{ all -> 0x00d7 }
            com.instabug.library.sessionV3.cache.SessionCacheManager r2 = r6.c()     // Catch:{ all -> 0x00d7 }
            java.lang.Object r3 = r1.getFirst()     // Catch:{ all -> 0x00d7 }
            java.lang.String r4 = "it.first"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x00d7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00d7 }
            java.lang.Object r1 = r1.getSecond()     // Catch:{ all -> 0x00d7 }
            java.lang.Number r1 = (java.lang.Number) r1     // Catch:{ all -> 0x00d7 }
            long r4 = r1.longValue()     // Catch:{ all -> 0x00d7 }
            r2.updateSessionDuration(r3, r4)     // Catch:{ all -> 0x00d7 }
            goto L_0x0095
        L_0x00be:
            android.content.SharedPreferences$Editor r0 = r6.f()     // Catch:{ all -> 0x00d7 }
            if (r0 != 0) goto L_0x00c5
            goto L_0x00cb
        L_0x00c5:
            android.content.SharedPreferences$Editor r0 = r0.clear()     // Catch:{ all -> 0x00d7 }
            if (r0 != 0) goto L_0x00cd
        L_0x00cb:
            r0 = 0
            goto L_0x00d2
        L_0x00cd:
            r0.apply()     // Catch:{ all -> 0x00d7 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d7 }
        L_0x00d2:
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x00d7 }
            goto L_0x00e2
        L_0x00d7:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00e2:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            java.lang.String r3 = r1.getMessage()
            if (r3 != 0) goto L_0x00f2
            r3 = r2
        L_0x00f2:
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            com.instabug.library.core.InstabugCore.reportError(r1, r3)
        L_0x00f9:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r1 != 0) goto L_0x0100
            goto L_0x0110
        L_0x0100:
            java.lang.String r3 = r1.getMessage()
            if (r3 != 0) goto L_0x0107
            r3 = r2
        L_0x0107:
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            java.lang.String r3 = "Something went wrong while updating not ended session duration"
            com.instabug.library.util.InstabugSDKLogger.e(r3, r2, r1)
        L_0x0110:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.sessionV3.manager.i.s():java.lang.Object");
    }

    public final void a(@NotNull u uVar) {
        Intrinsics.checkNotNullParameter(uVar, "sessionEvent");
        a(uVar, false);
    }

    @Nullable
    public final e e() {
        return f51801b;
    }

    @Nullable
    public final String i() {
        if (f51801b != null || d().i()) {
            return f51802c;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void b(u uVar) {
        Object obj;
        Intrinsics.checkNotNullParameter(uVar, "$sessionEvent");
        i iVar = f51800a;
        String stringPlus = Intrinsics.stringPlus("Something went wrong while handling ", uVar);
        try {
            Result.Companion companion = Result.Companion;
            iVar.e(uVar);
            iVar.d(uVar);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        String str = "";
        if (r02 != null) {
            String message = r02.getMessage();
            if (message == null) {
                message = str;
            }
            InstabugCore.reportError(r02, Intrinsics.stringPlus(stringPlus, message));
        }
        Throwable r42 = Result.m6332exceptionOrNullimpl(obj);
        if (r42 != null) {
            String message2 = r42.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus(stringPlus, str), r42);
        }
    }

    private final void c(u uVar) {
        g a11;
        if (f51801b != null) {
            q();
            Unit unit = null;
            f51801b = null;
            a();
            m().b(uVar.b());
            g queryLastSession = c().queryLastSession();
            if (!(queryLastSession == null || (a11 = g.a(queryLastSession, uVar, (com.instabug.library.sessionV3.providers.c) null, 2, (Object) null)) == null)) {
                a(c().insertOrUpdate(a11));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                a("trying to end session while last session is null");
            }
        }
    }

    private final void d(u uVar) {
        synchronized (this) {
            if (uVar instanceof s) {
                f51800a.b((s) uVar);
            } else if (uVar instanceof t) {
                f51800a.a((t) uVar);
            } else if (uVar instanceof r) {
                f51800a.c(uVar);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void e(u uVar) {
        a("session " + uVar + " event happen at " + uVar.b());
    }

    private final void f(u uVar) {
        e a11;
        long b11 = uVar.b();
        boolean z11 = true;
        boolean z12 = !b().a();
        e eVar = f51801b;
        if (eVar != null) {
            if (!eVar.b().e() || !z12) {
                z11 = false;
            }
            g gVar = null;
            e eVar2 = z11 ? eVar : null;
            if (eVar2 != null && (a11 = e.a(eVar2, a0.a(eVar2.b(), 0, 0, b11, 3, (Object) null), (String) null, 2, (Object) null)) != null) {
                i iVar = f51800a;
                f51801b = a11;
                g queryLastSession = iVar.c().queryLastSession();
                if (queryLastSession != null) {
                    gVar = g.a(queryLastSession, a11.b(), (com.instabug.library.sessionV3.providers.c) null, 2, (Object) null);
                }
                if (gVar != null) {
                    c().insertOrUpdate(gVar);
                }
            }
        }
    }

    public final void a(@NotNull u uVar, boolean z11) {
        Intrinsics.checkNotNullParameter(uVar, "sessionEvent");
        d dVar = new d(uVar);
        if (z11) {
            dVar.run();
        } else {
            j().execute(dVar);
        }
    }

    private final void a(t tVar) {
        a("Instabug is disabled during app session, ending current session");
        c(tVar);
    }

    private final void a() {
        k().a(m.f51617a);
    }

    private final void a(long j11) {
        h().execute(new b(j11));
    }

    private final g a(s sVar) {
        e a11 = e.f51594c.a(sVar);
        i iVar = f51800a;
        f51801b = a11;
        f51802c = a11.a();
        g a12 = f.a(g.f51597k, a11, (com.instabug.library.sessionV3.providers.c) null, 2, (Object) null);
        a(a12);
        iVar.a(iVar.c().insertOrUpdate(a12));
        return a12;
    }

    private final void b(s sVar) {
        Unit unit;
        if (d().i()) {
            s();
            if (f51801b == null) {
                unit = null;
            } else {
                f51800a.f(sVar);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                a(sVar);
            }
            n();
        }
    }

    private final void a(g gVar) {
        k().a(new n(l.f51616a.b(gVar)));
    }

    private final void a(String str) {
        InstabugSDKLogger.d("IBG-Core", str);
    }

    /* access modifiers changed from: private */
    public static final void b(long j11) {
        Unit unit;
        j a11 = com.instabug.library.model.v3Session.i.a(j.f51611d, j11, (c) null, 2, (Object) null);
        if (a11 == null) {
            unit = null;
        } else {
            f51800a.g().insert(a11);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            f51800a.a("experiments weren't saved as Experiments seems to be disabled for your Instabug company account. Please contact support for more information.");
        }
    }
}
