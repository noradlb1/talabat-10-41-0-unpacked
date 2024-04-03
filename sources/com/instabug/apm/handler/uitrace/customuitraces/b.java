package com.instabug.apm.handler.uitrace.customuitraces;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.apm.cache.handler.session.f;
import com.instabug.apm.cache.model.j;
import com.instabug.apm.handler.uitrace.c;
import com.instabug.apm.handler.uitrace.d;
import com.instabug.apm.util.device.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.model.common.Session;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@RequiresApi(api = 16)
public class b implements a, c, com.instabug.apm.util.powermanagement.b, d {

    /* renamed from: a  reason: collision with root package name */
    private final a f45424a;

    /* renamed from: b  reason: collision with root package name */
    private final com.instabug.apm.configuration.c f45425b;

    /* renamed from: c  reason: collision with root package name */
    private final com.instabug.apm.logger.internal.a f45426c;

    /* renamed from: d  reason: collision with root package name */
    private final com.instabug.apm.uitrace.a f45427d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f45428e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private j f45429f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private WeakReference f45430g = new WeakReference(new com.instabug.apm.util.powermanagement.a(this));
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private WeakReference f45431h = new WeakReference(new com.instabug.apm.util.powermanagement.c(this));

    /* renamed from: i  reason: collision with root package name */
    public com.instabug.apm.cache.handler.uitrace.c f45432i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public f f45433j;

    public b(a aVar, com.instabug.apm.configuration.c cVar, com.instabug.apm.logger.internal.a aVar2) {
        this.f45424a = aVar;
        this.f45425b = cVar;
        this.f45426c = aVar2;
        this.f45427d = com.instabug.apm.di.a.a(this, cVar.d());
        this.f45432i = com.instabug.apm.di.a.i0();
        this.f45433j = com.instabug.apm.di.a.Y();
        this.f45428e = com.instabug.apm.di.a.a("CustomUiTraceHandler");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        f fVar;
        com.instabug.apm.logger.internal.a aVar = this.f45426c;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ui trace");
        j jVar = this.f45429f;
        sb2.append(jVar != null ? jVar.g() : "");
        sb2.append(" is ending in ");
        sb2.append(activity.toString());
        aVar.g(sb2.toString());
        com.instabug.apm.uitrace.a aVar2 = this.f45427d;
        if (aVar2 != null) {
            aVar2.b();
        }
        try {
            f(activity);
            e(activity);
            g(activity);
            j jVar2 = this.f45429f;
            if (jVar2 == null || jVar2.l() == null) {
                this.f45426c.g("uiTraceModel or currentSession is null, can't insert to DB");
            } else {
                if (!(this.f45432i.a(this.f45429f) == -1 || (fVar = this.f45433j) == null)) {
                    fVar.a(this.f45429f.l(), 1);
                }
                com.instabug.apm.logger.internal.a aVar3 = this.f45426c;
                aVar3.d("Custom UI Trace \"" + this.f45429f.g() + "\" has ended.\nTotal duration: " + a(this.f45429f) + " seconds\nTotal hang duration: " + b(this.f45429f) + " ms");
            }
            this.f45429f = null;
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "Unable to end ui trace");
        }
    }

    private void a(@NonNull String str, Activity activity, @NonNull Session session) {
        j jVar = new j();
        this.f45429f = jVar;
        jVar.f(session.getId());
        this.f45429f.c(str);
        this.f45429f.e(TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis()));
        this.f45429f.f(System.nanoTime());
        this.f45429f.a(this.f45424a.a((Context) activity));
        this.f45429f.a(this.f45424a.c(activity));
        this.f45429f.d(this.f45424a.a(activity));
        this.f45429f.a(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Activity activity) {
        d(activity);
        c(activity);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(String str, Activity activity, Looper looper) {
        if (this.f45429f != null) {
            com.instabug.apm.logger.internal.a aVar = this.f45426c;
            aVar.g("Existing Ui trace " + a() + " need to be ended first");
            if (a() != null) {
                this.f45426c.i("Custom UI Trace \"$s1\" has started and \"$s2\" has been ended. Please make sure to end traces before starting a new one by following the instructions at this link: https://docs.instabug.com/reference#end-ui-trace".replace("$s1", str).replace("$s2", a()));
            }
            a(activity, looper);
        }
        Session b11 = com.instabug.apm.di.a.W().b();
        if (b11 != null) {
            a(str, activity, b11);
            c(activity);
            d(activity);
            com.instabug.apm.uitrace.a aVar2 = this.f45427d;
            if (aVar2 != null) {
                aVar2.a();
            }
            com.instabug.apm.logger.internal.a aVar3 = this.f45426c;
            aVar3.d("Custom UI Trace  \"" + str + "\" has started.");
        }
    }

    private void c(Activity activity) {
        WeakReference weakReference = new WeakReference(new com.instabug.apm.util.powermanagement.a(this));
        this.f45430g = weakReference;
        com.instabug.apm.util.powermanagement.a aVar = (com.instabug.apm.util.powermanagement.a) weakReference.get();
        if (aVar != null) {
            aVar.a(activity);
        }
    }

    private void d(Activity activity) {
        WeakReference weakReference = new WeakReference(new com.instabug.apm.util.powermanagement.c(this));
        this.f45431h = weakReference;
        com.instabug.apm.util.powermanagement.c cVar = (com.instabug.apm.util.powermanagement.c) weakReference.get();
        if (cVar != null) {
            cVar.a(activity);
        }
    }

    private void e(Activity activity) {
        com.instabug.apm.util.powermanagement.a aVar;
        WeakReference weakReference = this.f45430g;
        if (weakReference != null && (aVar = (com.instabug.apm.util.powermanagement.a) weakReference.get()) != null) {
            aVar.b(activity);
            this.f45430g = null;
        }
    }

    private void f(Activity activity) {
        com.instabug.apm.util.powermanagement.c cVar;
        WeakReference weakReference = this.f45431h;
        if (weakReference != null && (cVar = (com.instabug.apm.util.powermanagement.c) weakReference.get()) != null) {
            cVar.b(activity);
            this.f45431h = null;
        }
    }

    private void g(Activity activity) {
        j jVar = this.f45429f;
        if (jVar != null) {
            jVar.a(TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.f45429f.o()));
            if (activity != null) {
                this.f45429f.a(activity.getClass().getSimpleName());
                if (activity.getTitle() != null) {
                    this.f45429f.e(activity.getTitle().toString());
                }
                this.f45429f.b(com.instabug.apm.util.b.a(activity.getClass()));
            }
            this.f45429f.b(this.f45424a.b(activity));
        }
    }

    public long a(@NonNull j jVar) {
        return TimeUnit.MICROSECONDS.toSeconds(jVar.c());
    }

    @Nullable
    public String a() {
        j jVar = this.f45429f;
        if (jVar != null) {
            return jVar.g();
        }
        return null;
    }

    public void a(int i11) {
        j jVar;
        j jVar2 = this.f45429f;
        if (jVar2 != null) {
            if (jVar2.a() == -1) {
                jVar = this.f45429f;
            } else {
                jVar = this.f45429f;
                i11 = Math.min(i11, jVar.a());
            }
            jVar.a(i11);
        }
    }

    public void a(long j11) {
        j jVar = this.f45429f;
        if (jVar != null) {
            jVar.d(jVar.m() + j11);
            if (((float) j11) > this.f45425b.T()) {
                j jVar2 = this.f45429f;
                jVar2.c(jVar2.e() + j11);
            }
        }
    }

    public void a(Activity activity, @Nullable Looper looper) {
        this.f45428e.execute(new qb.b(this, activity));
    }

    public void a(Activity activity, boolean z11) {
        if (this.f45429f != null && z11) {
            this.f45426c.g(String.format("App went background while ui Trace %s is running, ending the trace…", new Object[]{a()}));
            a(activity, Looper.myLooper());
        }
    }

    public void a(@NonNull String str, Activity activity, @Nullable Looper looper) {
        this.f45428e.execute(new qb.c(this, str, activity, looper));
    }

    public void a(boolean z11) {
        j jVar;
        if (z11 && (jVar = this.f45429f) != null) {
            jVar.a(Boolean.valueOf(z11));
        }
    }

    public long b(@NonNull j jVar) {
        return TimeUnit.MICROSECONDS.toMillis(jVar.m() + jVar.e());
    }

    public void c() {
        if (InstabugInternalTrackingDelegate.getInstance().getCurrentActivity() != null) {
            a(InstabugInternalTrackingDelegate.getInstance().getCurrentActivity(), Looper.myLooper());
        }
    }

    public void onActivityStarted(Activity activity) {
        if (this.f45429f != null) {
            this.f45426c.g(String.format("New activity resumed while ui Trace %s is running, registering broadcast receivers…", new Object[]{a()}));
            this.f45428e.execute(new qb.a(this, activity));
        }
    }
}
