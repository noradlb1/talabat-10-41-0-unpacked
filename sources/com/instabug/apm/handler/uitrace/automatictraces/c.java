package com.instabug.apm.handler.uitrace.automatictraces;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import com.instabug.apm.cache.handler.session.f;
import com.instabug.apm.cache.model.j;
import com.instabug.apm.handler.uitrace.uiloading.d;
import com.instabug.apm.model.e;
import com.instabug.apm.util.device.a;
import com.instabug.apm.util.powermanagement.b;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@RequiresApi(api = 16)
public class c implements a, b {

    /* renamed from: a  reason: collision with root package name */
    private final a f45412a = com.instabug.apm.di.a.x();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final com.instabug.apm.configuration.c f45413b = com.instabug.apm.di.a.c();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final com.instabug.apm.logger.internal.a f45414c = com.instabug.apm.di.a.f();

    /* renamed from: d  reason: collision with root package name */
    private final com.instabug.apm.handler.uitrace.uihang.a f45415d = com.instabug.apm.di.a.d0();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private d f45416e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private j f45417f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private WeakReference f45418g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private WeakReference f45419h;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public com.instabug.apm.handler.session.c f45420i = com.instabug.apm.di.a.W();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public f f45421j = com.instabug.apm.di.a.Y();
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private Executor f45422k = com.instabug.apm.di.a.b("ui_trace_thread_executor");
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final Executor f45423l = com.instabug.apm.di.a.q();

    public c() {
        this.f45416e = f() ? com.instabug.apm.di.a.f0() : null;
    }

    private long a(@NonNull j jVar) {
        if (jVar == null) {
            return 0;
        }
        return TimeUnit.MICROSECONDS.toSeconds(jVar.c());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        f(activity);
        e(activity);
    }

    @WorkerThread
    private void a(Activity activity, long j11, j jVar) {
        if (jVar != null) {
            jVar.b(this.f45412a.b(activity));
            jVar.a(TimeUnit.NANOSECONDS.toMicros(j11 - jVar.o()));
            if (activity != null) {
                if (jVar.g() != null && !jVar.g().equals(activity.getClass().getSimpleName())) {
                    jVar.a(activity.getClass().getSimpleName());
                }
                jVar.b(com.instabug.apm.util.b.a(activity.getClass()));
            }
            jVar.a(false);
            return;
        }
        this.f45414c.g("uiTraceModel is null, can't update");
    }

    private long b(@NonNull j jVar) {
        if (jVar == null) {
            return 0;
        }
        return TimeUnit.MICROSECONDS.toMillis(jVar.m() + jVar.e());
    }

    private j b(Activity activity, String str, String str2, long j11, long j12) {
        a aVar;
        j jVar = new j();
        if (!(activity == null || (aVar = this.f45412a) == null)) {
            jVar.a(aVar.a((Context) activity));
            jVar.a(this.f45412a.c(activity));
            jVar.d(this.f45412a.a(activity));
        }
        jVar.c(str);
        jVar.e(str2);
        jVar.e(TimeUnit.MILLISECONDS.toMicros(j11));
        jVar.f(j12);
        return jVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Activity activity) {
        c(activity);
        d(activity);
    }

    private void c(Activity activity) {
        if (activity != null) {
            WeakReference weakReference = this.f45418g;
            if (!(weakReference == null || weakReference.get() == null)) {
                try {
                    activity.unregisterReceiver((BroadcastReceiver) this.f45418g.get());
                } catch (Exception e11) {
                    InstabugCore.reportError(e11, "couldn't unregister Receiver");
                }
            }
            com.instabug.apm.util.powermanagement.a aVar = new com.instabug.apm.util.powermanagement.a(this);
            aVar.a(activity);
            this.f45418g = new WeakReference(aVar);
        }
    }

    private void c(j jVar) {
        this.f45422k.execute(new b(this, jVar));
    }

    private void d(Activity activity) {
        if (activity != null) {
            com.instabug.apm.util.powermanagement.c cVar = new com.instabug.apm.util.powermanagement.c(this);
            cVar.a(activity);
            this.f45419h = new WeakReference(cVar);
        }
    }

    private void e(Activity activity) {
        WeakReference weakReference;
        com.instabug.apm.util.powermanagement.a aVar;
        if (activity != null && (weakReference = this.f45418g) != null && (aVar = (com.instabug.apm.util.powermanagement.a) weakReference.get()) != null) {
            aVar.b(activity);
            this.f45418g = null;
        }
    }

    private boolean e() {
        com.instabug.apm.configuration.c cVar = this.f45413b;
        if (cVar == null) {
            return false;
        }
        return cVar.d0();
    }

    private void f(Activity activity) {
        WeakReference weakReference;
        com.instabug.apm.util.powermanagement.c cVar;
        if (activity != null && (weakReference = this.f45419h) != null && (cVar = (com.instabug.apm.util.powermanagement.c) weakReference.get()) != null) {
            cVar.b(activity);
            this.f45419h = null;
        }
    }

    private boolean f() {
        com.instabug.apm.configuration.c cVar = this.f45413b;
        if (cVar == null) {
            return false;
        }
        return cVar.A();
    }

    public void a() {
        d dVar = this.f45416e;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void a(int i11) {
        j jVar;
        j jVar2 = this.f45417f;
        if (jVar2 != null) {
            if (jVar2.a() == -1) {
                jVar = this.f45417f;
            } else {
                jVar = this.f45417f;
                i11 = Math.min(i11, jVar.a());
            }
            jVar.a(i11);
        }
    }

    public void a(int i11, e eVar) {
        d dVar = this.f45416e;
        if (dVar != null) {
            dVar.a(i11, eVar);
        }
    }

    public void a(@NonNull Activity activity, long j11) {
        if (activity != null) {
            this.f45423l.execute(new pb.a(this, activity));
            j jVar = this.f45417f;
            if (jVar != null) {
                a(activity, j11, jVar);
                com.instabug.apm.handler.uitrace.uihang.a aVar = this.f45415d;
                if (aVar != null) {
                    jVar.a(aVar.c());
                }
                d dVar = this.f45416e;
                if (dVar != null) {
                    jVar.a(dVar.b());
                }
                if (jVar.s()) {
                    c(jVar);
                    com.instabug.apm.logger.internal.a aVar2 = this.f45414c;
                    aVar2.d("Ended Auto UI Trace for screen with name \"" + activity.getClass().getSimpleName() + "\".\nTotal duration: " + a(jVar) + " seconds\nTotal hang duration: " + b(jVar) + " ms");
                    this.f45417f = jVar;
                }
            } else {
                this.f45414c.g("uiTraceModel is null, can't insert to DB");
            }
            d();
            b();
        }
    }

    public void a(@NonNull Activity activity, @NonNull String str, @NonNull String str2, long j11, long j12) {
        com.instabug.apm.handler.uitrace.uihang.a aVar;
        if (activity != null) {
            this.f45423l.execute(new pb.b(this, activity));
            this.f45417f = b(activity, str, str2, j11, j12);
            if (e() && (aVar = this.f45415d) != null) {
                aVar.a();
            }
            com.instabug.apm.logger.internal.a aVar2 = this.f45414c;
            aVar2.d("Started Auto UI Trace for screen with name \"" + activity.getClass().getSimpleName() + "\".");
        }
    }

    public void a(e eVar) {
        d dVar = this.f45416e;
        if (dVar != null) {
            dVar.a(eVar);
        }
    }

    public void a(boolean z11) {
        j jVar;
        if (z11 && (jVar = this.f45417f) != null) {
            jVar.a(Boolean.valueOf(z11));
        }
    }

    public void b() {
        this.f45416e = null;
    }

    public void c() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            a(currentActivity, System.nanoTime());
        }
    }

    public void d() {
        com.instabug.apm.handler.uitrace.uihang.a aVar = this.f45415d;
        if (aVar != null) {
            aVar.b();
            this.f45415d.d();
        }
    }
}
