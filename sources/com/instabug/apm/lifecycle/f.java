package com.instabug.apm.lifecycle;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.instabug.apm.cache.model.b;
import com.instabug.apm.configuration.c;
import com.instabug.apm.di.a;
import com.instabug.apm.model.e;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.model.common.Session;
import com.instabug.library.util.threading.PoolProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sb.d;

public final class f implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f45470a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f45471b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f45472c;

    /* renamed from: d  reason: collision with root package name */
    private final b f45473d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Lazy f45474e = LazyKt__LazyJVMKt.lazy(d.f45468a);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Lazy f45475f = LazyKt__LazyJVMKt.lazy(e.f45469a);
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private String f45476g = "";

    public f(@NotNull Context context, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f45470a = context;
        this.f45471b = z11;
        this.f45472c = z12;
        b k11 = a.k();
        this.f45473d = k11;
        if (f()) {
            k11.a(false);
        }
    }

    private final long a(long j11) {
        return TimeUnit.MICROSECONDS.toMillis(j11);
    }

    private final void a(long j11, long j12) {
        com.instabug.apm.handler.applaunch.a n11;
        List b11;
        b bVar = this.f45473d;
        if (bVar.c() != null) {
            b c11 = bVar.c();
            Map map = null;
            if ((c11 == null ? null : c11.f()) != null) {
                b c12 = bVar.c();
                if (c12 != null) {
                    map = c12.d();
                }
                if (!a(map)) {
                    if (j12 < 0) {
                        e().e("endAppLaunch() was called too early in the App Launch cycle. Please make sure to call the API after the app is done launching.");
                        b c13 = bVar.c();
                        Intrinsics.checkNotNull(c13);
                        Intrinsics.checkNotNullExpressionValue(c13, "appLaunchCacheModel!!");
                        a(c13, 0, 0);
                        bVar.c(true);
                        return;
                    }
                    b c14 = bVar.c();
                    Intrinsics.checkNotNull(c14);
                    Intrinsics.checkNotNullExpressionValue(c14, "appLaunchCacheModel!!");
                    a(c14, j11, j12);
                    return;
                }
                e().i("endAppLaunch() has already been called. Multiple calls to this API are not allowed in the same session, only the first call will be considered.");
            }
        }
        if (Intrinsics.areEqual((Object) this.f45476g, (Object) "") || (b11 = n11.b(this.f45476g)) == null || b11.size() != 1) {
            e().e("endAppLaunch() was called too early in the App Launch cycle. Please make sure to call the API after the app is done launching.");
            bVar.c(true);
            return;
        }
        b bVar2 = (b) b11.get(0);
        if (bVar2 != null && bVar2.f() != null) {
            if (!a(bVar2.d())) {
                if (j12 < 0) {
                    e().e("endAppLaunch() was called too early in the App Launch cycle. Please make sure to call the API after the app is done launching.");
                    a(bVar2, 0, 0);
                    n11.a(bVar2);
                    bVar.c(true);
                    return;
                }
                a(bVar2, j11, j12);
                (n11 = a.n()).a(bVar2);
                return;
            }
            e().i("endAppLaunch() has already been called. Multiple calls to this API are not allowed in the same session, only the first call will be considered.");
        }
    }

    private final synchronized void a(long j11, long j12, String str) {
        synchronized (this) {
            b bVar = this.f45473d;
            b bVar2 = new b();
            bVar2.b("cold");
            bVar2.a(str);
            Map e11 = bVar.e();
            com.instabug.apm.model.a aVar = com.instabug.apm.model.a.APP_CREATION;
            com.instabug.apm.model.b bVar3 = (com.instabug.apm.model.b) e11.get(aVar);
            long j13 = 0;
            bVar2.c(bVar3 == null ? 0 : bVar3.d());
            com.instabug.apm.model.b bVar4 = (com.instabug.apm.model.b) bVar.e().get(aVar);
            bVar2.a(j12 - (bVar4 == null ? 0 : bVar4.c()));
            HashMap hashMap = new HashMap(6);
            com.instabug.apm.model.b bVar5 = (com.instabug.apm.model.b) bVar.e().get(aVar);
            if (bVar5 != null) {
                hashMap.put("ap_on_c_mus_st", String.valueOf(bVar5.d()));
                hashMap.put("ap_on_c_mus", String.valueOf(bVar5.a() - bVar5.c()));
            }
            Map e12 = bVar.e();
            com.instabug.apm.model.a aVar2 = com.instabug.apm.model.a.ACTIVITY_CREATION;
            com.instabug.apm.model.b bVar6 = (com.instabug.apm.model.b) e12.get(aVar2);
            if (bVar6 != null) {
                hashMap.put("ac_on_c_mus_st", String.valueOf(bVar6.d()));
                hashMap.put("ac_on_c_mus", String.valueOf(bVar6.a() - bVar6.c()));
            }
            Map e13 = bVar.e();
            com.instabug.apm.model.a aVar3 = com.instabug.apm.model.a.ACTIVITY_START;
            com.instabug.apm.model.b bVar7 = (com.instabug.apm.model.b) e13.get(aVar3);
            if (bVar7 != null) {
                hashMap.put("ac_on_st_mus_st", String.valueOf(j11));
                hashMap.put("ac_on_st_mus", String.valueOf(j12 - bVar7.c()));
            }
            if (bVar.i()) {
                hashMap.put("eal_mus", "0");
            }
            bVar2.a((Map) hashMap);
            bVar.a(bVar2);
            com.instabug.apm.logger.internal.a e14 = e();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("App took ");
            com.instabug.apm.model.b bVar8 = (com.instabug.apm.model.b) bVar.e().get(aVar);
            sb2.append(a(j12 - (bVar8 == null ? 0 : bVar8.c())));
            sb2.append(" ms to launch.\nApp onCreate(): ");
            com.instabug.apm.model.b bVar9 = (com.instabug.apm.model.b) bVar.e().get(aVar);
            long a11 = bVar9 == null ? 0 : bVar9.a();
            com.instabug.apm.model.b bVar10 = (com.instabug.apm.model.b) bVar.e().get(aVar);
            sb2.append(a(a11 - (bVar10 == null ? 0 : bVar10.c())));
            sb2.append("  ms\nActivity onCreate(): ");
            com.instabug.apm.model.b bVar11 = (com.instabug.apm.model.b) bVar.e().get(aVar2);
            long a12 = bVar11 == null ? 0 : bVar11.a();
            com.instabug.apm.model.b bVar12 = (com.instabug.apm.model.b) bVar.e().get(aVar2);
            sb2.append(a(a12 - (bVar12 == null ? 0 : bVar12.c())));
            sb2.append(" ms\nActivity onStart(): ");
            com.instabug.apm.model.b bVar13 = (com.instabug.apm.model.b) bVar.e().get(aVar3);
            if (bVar13 != null) {
                j13 = bVar13.c();
            }
            sb2.append(a(j12 - j13));
            sb2.append(" ms");
            e14.d(sb2.toString());
            Session b11 = a.W().b();
            if (b11 != null) {
                a(b11, bVar2);
            }
        }
    }

    private final void a(b bVar, long j11, long j12) {
        b bVar2 = this.f45473d;
        bVar.a(bVar2.a(bVar2.f()));
        bVar.a(bVar.a() + j12);
        Map d11 = bVar.d();
        if (d11 != null) {
            d11.put("eal_mus", String.valueOf(j12));
            if (j11 != 0) {
                d11.put("eal_mus_st", String.valueOf(j11));
            }
            bVar.a(d11);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar) {
        String str;
        com.instabug.apm.logger.internal.a aVar;
        String str2;
        String str3;
        String f11;
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        synchronized (fVar) {
            if (fVar.i()) {
                aVar = fVar.e();
                str2 = "endAppLaunch() wasn't called. Please make sure to enable %s App Launches first by following the instructions at this link:https://docs.instabug.com/reference#end-app-launch";
                str3 = LogWriteConstants.LOCATION_MSG_FORMAT;
                f11 = fVar.f45473d.f();
                Intrinsics.checkNotNullExpressionValue(f11, "appLaunchDataRepository.currentAppLaunchType");
            } else if (fVar.h()) {
                aVar = fVar.e();
                str2 = "endAppLaunch() wasn't called as %s App Launches seems to be disabled for your Instabug company account. Please contact support for more information.";
                str3 = LogWriteConstants.LOCATION_MSG_FORMAT;
                f11 = fVar.f45473d.f();
                Intrinsics.checkNotNullExpressionValue(f11, "appLaunchDataRepository.currentAppLaunchType");
            } else if (fVar.g()) {
                aVar = fVar.e();
                str = "endAppLaunch() wasn't called as the feature seems to be disabled for your Instabug company account. Please contact support for more information.";
                aVar.e(str);
                Unit unit = Unit.INSTANCE;
            } else {
                long b11 = fVar.f45473d.b();
                long d11 = fVar.f45473d.d();
                com.instabug.apm.model.b bVar = (com.instabug.apm.model.b) fVar.f45473d.e().get(com.instabug.apm.model.a.ACTIVITY_START);
                fVar.a(b11, d11 - (bVar == null ? 0 : bVar.a()));
                Unit unit2 = Unit.INSTANCE;
            }
            str = StringsKt__StringsJVMKt.replace$default(str2, str3, f11, false, 4, (Object) null);
            aVar.e(str);
            Unit unit22 = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, Activity activity, e eVar) {
        String str;
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(eVar, "$timeMetricCapture");
        synchronized (fVar) {
            b bVar = fVar.f45473d;
            String name2 = activity.getClass().getName();
            if (!bVar.h() || !fVar.f45471b) {
                if (bVar.j() && !bVar.k() && fVar.d().P()) {
                    bVar.b("hot");
                    com.instabug.apm.model.b bVar2 = (com.instabug.apm.model.b) fVar.f45473d.e().get(com.instabug.apm.model.a.ACTIVITY_START);
                    if (bVar2 != null) {
                        bVar2.a(eVar.a());
                    }
                    fVar.f45473d.a(eVar.c());
                    str = "screenName";
                }
                bVar.a(false);
                bVar.d(true);
                bVar.e(true);
                Unit unit = Unit.INSTANCE;
            } else {
                com.instabug.apm.model.b bVar3 = (com.instabug.apm.model.b) bVar.e().get(com.instabug.apm.model.a.ACTIVITY_START);
                if (bVar3 != null) {
                    bVar3.a(eVar.a());
                }
                bVar.a(eVar.c());
                if (bVar.g()) {
                    if (fVar.f45472c) {
                        bVar.b("cold");
                        if ((fVar.d().Q() ? bVar : null) != null) {
                            Intrinsics.checkNotNullExpressionValue(name2, "screenName");
                            fVar.a(name2);
                        }
                    }
                } else if (bVar.j() && !bVar.k() && fVar.d().P()) {
                    bVar.b("hot");
                    str = "screenName";
                }
                bVar.a(false);
                bVar.d(true);
                bVar.e(true);
                Unit unit2 = Unit.INSTANCE;
            }
            Intrinsics.checkNotNullExpressionValue(name2, str);
            fVar.b(name2);
            bVar.a(false);
            bVar.d(true);
            bVar.e(true);
            Unit unit22 = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, e eVar, Activity activity) {
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(eVar, "$timeMetricCapture");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        synchronized (fVar) {
            com.instabug.apm.model.b bVar = (com.instabug.apm.model.b) fVar.f45473d.e().get(com.instabug.apm.model.a.APP_CREATION);
            if (bVar != null) {
                bVar.a(eVar.a());
            }
            Map e11 = fVar.f45473d.e();
            Intrinsics.checkNotNullExpressionValue(e11, "appLaunchDataRepository.appLaunchStages");
            e11.put(com.instabug.apm.model.a.ACTIVITY_CREATION, new com.instabug.apm.model.b(eVar.c(), eVar.a(), 0, activity.getClass().getName(), 4, (DefaultConstructorMarker) null));
            fVar.f45473d.d(false);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void a(f fVar, Session session) {
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        Intrinsics.checkNotNullParameter(session, "$session");
        synchronized (fVar) {
            String id2 = session.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "session.id");
            fVar.f45476g = id2;
            b c11 = fVar.f45473d.c();
            if (c11 != null) {
                fVar.a(session, c11);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void a(Session session, b bVar) {
        a.n().a(session.getId(), bVar);
        c();
    }

    private final void a(String str) {
        com.instabug.apm.model.b bVar = (com.instabug.apm.model.b) this.f45473d.e().get(com.instabug.apm.model.a.ACTIVITY_START);
        if (bVar != null) {
            a(bVar.d(), bVar.a(), str);
        }
    }

    private final boolean a(Map map) {
        return map != null && map.containsKey("eal_mus");
    }

    private final void b(long j11, long j12, String str) {
        com.instabug.apm.model.b bVar = (com.instabug.apm.model.b) this.f45473d.e().get(com.instabug.apm.model.a.ACTIVITY_START);
        long c11 = j12 - (bVar == null ? 0 : bVar.c());
        b bVar2 = new b();
        bVar2.b("hot");
        bVar2.a(str);
        bVar2.c(j11);
        bVar2.a(c11);
        HashMap hashMap = new HashMap(1);
        hashMap.put("ac_on_st_mus", String.valueOf(c11));
        hashMap.put("ac_on_st_mus_st", String.valueOf(j11));
        if (this.f45473d.i()) {
            hashMap.put("eal_mus", "0");
        }
        bVar2.a((Map) hashMap);
        this.f45473d.a(bVar2);
        com.instabug.apm.logger.internal.a e11 = e();
        e11.d("App took " + a(c11) + " ms to launch form the background (hot).\n");
    }

    /* access modifiers changed from: private */
    public static final void b(f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "this$0");
        synchronized (fVar) {
            b bVar = fVar.f45473d;
            boolean z11 = false;
            if (bVar.a() != 0) {
                bVar.a(bVar.a() - 1);
            } else {
                bVar.c(false);
                bVar.b("hot");
                fVar.f45476g = "";
            }
            if (bVar.a() != 0) {
                z11 = true;
            }
            bVar.a(z11);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void b(f fVar, e eVar, Activity activity) {
        f fVar2 = fVar;
        Intrinsics.checkNotNullParameter(fVar2, "this$0");
        Intrinsics.checkNotNullParameter(eVar, "$timeMetricCapture");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        synchronized (fVar) {
            b bVar = fVar2.f45473d;
            boolean z11 = false;
            bVar.e(bVar.a() != 0);
            com.instabug.apm.model.b bVar2 = (com.instabug.apm.model.b) fVar2.f45473d.e().get(com.instabug.apm.model.a.ACTIVITY_CREATION);
            if (bVar2 != null) {
                bVar2.a(eVar.a());
            }
            Map e11 = fVar2.f45473d.e();
            Intrinsics.checkNotNullExpressionValue(e11, "appLaunchDataRepository.appLaunchStages");
            com.instabug.apm.model.a aVar = com.instabug.apm.model.a.ACTIVITY_START;
            com.instabug.apm.model.b bVar3 = r7;
            com.instabug.apm.model.b bVar4 = new com.instabug.apm.model.b(eVar.c(), eVar.a(), 0, activity.getClass().getName(), 4, (DefaultConstructorMarker) null);
            e11.put(aVar, bVar3);
            b bVar5 = fVar2.f45473d;
            if (bVar5.a() == 0) {
                z11 = true;
            }
            bVar5.b(z11);
            b bVar6 = fVar2.f45473d;
            bVar6.a(bVar6.a() + 1);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void b(String str) {
        com.instabug.apm.model.b bVar = (com.instabug.apm.model.b) this.f45473d.e().get(com.instabug.apm.model.a.ACTIVITY_START);
        if (bVar != null) {
            b(bVar.d(), bVar.a(), str);
        }
    }

    private final void c() {
        this.f45473d.a((b) null);
    }

    private final c d() {
        return (c) this.f45474e.getValue();
    }

    private final com.instabug.apm.logger.internal.a e() {
        return (com.instabug.apm.logger.internal.a) this.f45475f.getValue();
    }

    private final boolean f() {
        Object systemService = this.f45470a.getSystemService("activity");
        if (systemService != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                String packageName = this.f45470a.getPackageName();
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next.importance == 100 && Intrinsics.areEqual((Object) next.processName, (Object) packageName)) {
                        return false;
                    }
                }
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    private final boolean g() {
        String f11 = this.f45473d.f();
        return !Intrinsics.areEqual((Object) f11, (Object) "hot") ? !Intrinsics.areEqual((Object) f11, (Object) "cold") || !d().l0() : !d().z();
    }

    private final boolean h() {
        String f11 = this.f45473d.f();
        return !Intrinsics.areEqual((Object) f11, (Object) "hot") ? !Intrinsics.areEqual((Object) f11, (Object) "cold") || !d().s() : !d().a();
    }

    private final boolean i() {
        String f11 = this.f45473d.f();
        return !Intrinsics.areEqual((Object) f11, (Object) "hot") ? !Intrinsics.areEqual((Object) f11, (Object) "cold") || !d().X() : !d().R();
    }

    public void a() {
        PoolProvider.postIOTask(new sb.f(this));
    }

    public void a(@NotNull Activity activity, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(eVar, "timeMetricCapture");
        PoolProvider.postIOTask(new sb.e(this, activity, eVar));
    }

    public void a(@NotNull Session session) {
        Intrinsics.checkNotNullParameter(session, SDKCoreEvent.Session.TYPE_SESSION);
        PoolProvider.postIOTask(new sb.b(this, session));
    }

    public void b() {
        PoolProvider.postIOTask(new sb.c(this));
    }

    public void b(@NotNull Activity activity, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(eVar, "timeMetricCapture");
        PoolProvider.postIOTask(new sb.a(this, eVar, activity));
    }

    public void c(@NotNull Activity activity, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(eVar, "timeMetricCapture");
        PoolProvider.postIOTask(new d(this, eVar, activity));
    }
}
