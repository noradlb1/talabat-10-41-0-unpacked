package com.instabug.apm.handler.uitrace;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.instabug.apm.cache.handler.session.f;
import com.instabug.apm.configuration.c;
import com.instabug.apm.logger.internal.a;
import com.instabug.apm.model.e;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.threading.PoolProvider;
import java.util.HashMap;
import java.util.Map;
import ob.b;
import ob.d;
import ob.g;
import ob.h;
import ob.i;
import ob.j;
import ob.l;
import ob.m;

@RequiresApi(api = 16)
@WorkerThread
public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c f45440a;

    /* renamed from: b  reason: collision with root package name */
    private final SettingsManager f45441b;

    /* renamed from: c  reason: collision with root package name */
    private final a f45442c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f45443d = new HashMap();

    public k(c cVar, SettingsManager settingsManager, a aVar) {
        this.f45440a = cVar;
        this.f45441b = settingsManager;
        this.f45442c = aVar;
    }

    @NonNull
    private com.instabug.apm.handler.uitrace.automatictraces.a a(String str) {
        com.instabug.apm.handler.uitrace.automatictraces.a p11 = com.instabug.apm.di.a.p();
        this.f45443d.put(str, p11);
        return p11;
    }

    @NonNull
    private String a(@NonNull Class cls) {
        return cls == null ? "" : cls.getSimpleName();
    }

    private void a(@NonNull Activity activity, int i11, e eVar) {
        com.instabug.apm.handler.uitrace.automatictraces.a c11 = c(b(activity));
        if (c11 != null) {
            c11.a(i11, eVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, Runnable runnable) {
        if (a(activity) && h() && g()) {
            PoolProvider.postMainThreadTask(runnable);
        }
    }

    private boolean a(Activity activity) {
        return !com.instabug.apm.util.view.a.a(activity);
    }

    @Nullable
    private com.instabug.apm.handler.uitrace.automatictraces.a b(String str) {
        com.instabug.apm.handler.uitrace.automatictraces.a aVar = (com.instabug.apm.handler.uitrace.automatictraces.a) this.f45443d.get(str);
        this.f45443d.remove(str);
        return aVar;
    }

    @NonNull
    private String b(@NonNull Activity activity) {
        return activity == null ? "" : a((Class) activity.getClass());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Activity activity, long j11) {
        com.instabug.apm.handler.uitrace.automatictraces.a b11 = b(b(activity));
        if (b11 != null) {
            b11.a(activity, j11);
        }
    }

    private void b(Activity activity, Runnable runnable) {
        PoolProvider.getSingleThreadExecutor("UiTracesExecutor").execute(new j(this, activity, runnable));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void c(@NonNull Class cls, e eVar) {
        if (cls != null) {
            com.instabug.apm.handler.uitrace.automatictraces.a c11 = c(a(cls));
            if (c11 != null) {
                c11.a(eVar);
                return;
            }
            a aVar = this.f45442c;
            if (aVar != null) {
                aVar.i("endScreenLoading wasn’t called as the call was made after the screen had already disappeared.");
            }
        }
    }

    @Nullable
    private com.instabug.apm.handler.uitrace.automatictraces.a c(String str) {
        return (com.instabug.apm.handler.uitrace.automatictraces.a) this.f45443d.get(str);
    }

    @NonNull
    private com.instabug.apm.handler.uitrace.automatictraces.a d(String str) {
        com.instabug.apm.handler.uitrace.automatictraces.a aVar = (com.instabug.apm.handler.uitrace.automatictraces.a) this.f45443d.get(str);
        return aVar == null ? a(str) : aVar;
    }

    private void e(@NonNull String str) {
        a aVar = this.f45442c;
        if (aVar != null && str != null) {
            aVar.e(str);
        }
    }

    private boolean g() {
        SettingsManager settingsManager = this.f45441b;
        return settingsManager != null && settingsManager.getCurrentPlatform() == 2;
    }

    private boolean h() {
        c cVar = this.f45440a;
        if (cVar == null) {
            return false;
        }
        return cVar.O();
    }

    /* access modifiers changed from: private */
    public void i() {
        com.instabug.apm.cache.handler.uitrace.c i02 = com.instabug.apm.di.a.i0();
        f Y = com.instabug.apm.di.a.Y();
        i02.a();
        if (Y != null) {
            Y.a();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        com.instabug.apm.cache.handler.uitrace.c i02 = com.instabug.apm.di.a.i0();
        if (i02 != null) {
            i02.c();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        com.instabug.apm.cache.handler.uitrace.c i02 = com.instabug.apm.di.a.i0();
        if (i02 != null) {
            i02.e();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(Activity activity, e eVar) {
        d(b(activity));
        a(activity, 1, eVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(Activity activity, e eVar) {
        a(activity, 2, eVar);
    }

    private boolean l() {
        String str;
        c cVar = this.f45440a;
        if (cVar == null) {
            return false;
        }
        if (!cVar.k0()) {
            e("endScreenLoading wasn’t called as the feature seems to be disabled for your Instabug company account. Please contact support for more information.");
            return false;
        }
        if (!this.f45440a.H()) {
            str = "endScreenLoading wasn't called. Please make sure to enable APM first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-apm";
        } else if (!this.f45440a.n()) {
            e("endScreenLoading wasn’t called as the feature seems to be disabled for your Instabug company account. Please contact support for more information.");
            return false;
        } else if (!this.f45440a.f()) {
            str = "endScreenLoading wasn't called as Screen Loading seems to be disabled. Please make sure to enable Screen Loading first by following the instructions at this link: https://docs.instabug.com/docs/android-apm-screen-loading#disablingenabling-screen-loading-tracking";
        } else if (!this.f45440a.y()) {
            str = "endScreenLoading wasn't called as Auto UI Traces seems to be disabled. Please make sure to enable Auto UI Traces first by following the instructions at this link: https://docs.instabug.com/reference#enable-or-disable-auto-ui-traces";
        } else if (this.f45440a.D()) {
            return true;
        } else {
            e("endScreenLoading wasn’t called as the feature seems to be disabled for your Instabug company account. Please contact support for more information.");
            return false;
        }
        e(str);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Activity activity, e eVar) {
        a(activity, 8, eVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(Activity activity, e eVar) {
        a(activity, 5, eVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(Activity activity, e eVar) {
        a(b(activity));
        a(activity, 0, eVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(Activity activity, e eVar) {
        a(activity, 6, eVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(Activity activity, e eVar) {
        a(activity, 3, eVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(Activity activity, e eVar) {
        com.instabug.apm.handler.uitrace.automatictraces.a c11 = c(b(activity));
        if (c11 != null) {
            c11.a();
        }
        a(activity, 7, eVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(Activity activity, e eVar) {
        a(activity, 4, eVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(Activity activity, e eVar) {
        String b11 = b(activity);
        d(b11).a(activity, b11, activity.getTitle() != null ? activity.getTitle().toString() : "", eVar.d(), eVar.b());
    }

    public void a() {
        com.instabug.apm.di.a.b("ui_trace_thread_executor").execute(new h(this));
    }

    public void a(@NonNull Activity activity, long j11) {
        if (activity != null) {
            b(activity, (Runnable) new g(this, activity, j11));
        }
    }

    public void a(@NonNull Activity activity, long j11, @NonNull String str) {
        com.instabug.apm.handler.uitrace.automatictraces.a b11;
        if (activity != null && a(activity) && h() && (b11 = b(str)) != null) {
            b11.a(activity, j11);
        }
    }

    public void a(@NonNull Activity activity, e eVar) {
        if (activity != null) {
            b(activity, (Runnable) new h(this, activity, eVar));
        }
    }

    public void a(@NonNull Activity activity, @NonNull String str, long j11, long j12) {
        if (activity != null && str != null && h()) {
            a(str).a(activity, str, str, j11, j12);
        }
    }

    public void a(@NonNull Activity activity, boolean z11) {
        d h02;
        if (activity != null && g() && a(activity) && (h02 = com.instabug.apm.di.a.h0()) != null) {
            h02.a(activity, z11);
        }
    }

    public void a(@NonNull Class cls, e eVar) {
        if (l()) {
            PoolProvider.postMainThreadTask(new l(this, cls, eVar));
        }
    }

    public void b() {
        for (com.instabug.apm.handler.uitrace.automatictraces.a b11 : (com.instabug.apm.handler.uitrace.automatictraces.a[]) this.f45443d.values().toArray(new com.instabug.apm.handler.uitrace.automatictraces.a[0])) {
            b11.b();
        }
    }

    public void b(@NonNull Activity activity, e eVar) {
        if (activity != null) {
            b(activity, (Runnable) new b(this, activity, eVar));
        }
    }

    public void c() {
        com.instabug.apm.di.a.b("ui_trace_thread_executor").execute(new i(this));
    }

    public void c(@NonNull Activity activity, e eVar) {
        d h02;
        if (activity != null) {
            if (g() && a(activity) && (h02 = com.instabug.apm.di.a.h0()) != null) {
                h02.onActivityStarted(activity);
            }
            b(activity, (Runnable) new ob.a(this, activity, eVar));
        }
    }

    public void d() {
        for (com.instabug.apm.handler.uitrace.automatictraces.a d11 : (com.instabug.apm.handler.uitrace.automatictraces.a[]) this.f45443d.values().toArray(new com.instabug.apm.handler.uitrace.automatictraces.a[0])) {
            d11.d();
        }
    }

    public void d(@NonNull Activity activity, e eVar) {
        if (activity != null) {
            b(activity, (Runnable) new d(this, activity, eVar));
        }
    }

    public void e() {
        com.instabug.apm.di.a.b("ui_trace_thread_executor").execute(new j(this));
    }

    public void e(@NonNull Activity activity, e eVar) {
        if (activity != null) {
            b(activity, (Runnable) new ob.f(this, activity, eVar));
        }
    }

    public void f() {
        for (com.instabug.apm.handler.uitrace.automatictraces.a c11 : (com.instabug.apm.handler.uitrace.automatictraces.a[]) this.f45443d.values().toArray(new com.instabug.apm.handler.uitrace.automatictraces.a[0])) {
            c11.c();
        }
        this.f45443d.clear();
    }

    public void f(@NonNull Activity activity, e eVar) {
        if (activity != null) {
            b(activity, (Runnable) new ob.e(this, activity, eVar));
        }
    }

    public void g(@NonNull Activity activity, e eVar) {
        if (activity != null) {
            b(activity, (Runnable) new ob.c(this, activity, eVar));
        }
    }

    public void h(@NonNull Activity activity, e eVar) {
        if (activity != null) {
            b(activity, (Runnable) new m(this, activity, eVar));
        }
    }

    public void i(@NonNull Activity activity, e eVar) {
        if (activity != null) {
            b(activity, (Runnable) new i(this, activity, eVar));
        }
    }

    public void j(@NonNull Activity activity, e eVar) {
        if (activity != null) {
            b(activity, (Runnable) new ob.k(this, activity, eVar));
        }
    }
}
