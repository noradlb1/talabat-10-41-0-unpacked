package com.instabug.featuresrequest.ui.featuredetails;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.instabug.featuresrequest.cache.a;
import com.instabug.featuresrequest.models.j;
import com.instabug.featuresrequest.network.service.l;
import com.instabug.featuresrequest.network.timelinerepository.c;
import com.instabug.featuresrequest.network.timelinerepository.d;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.util.threading.PoolProvider;
import org.json.JSONException;

public class f extends BasePresenter implements d {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d f46763a = ((d) this.f34200f.get());
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private c f46764b;

    public f(d dVar) {
        super(dVar);
        if (dVar.getViewContext() != null && ((Fragment) dVar.getViewContext()).getContext() != null) {
            this.f46764b = c.a();
        }
    }

    private void b() {
        d dVar = this.f46763a;
        if (dVar != null && ((Fragment) dVar.getViewContext()).getContext() != null) {
            l.b().start();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(long j11) {
        c cVar = this.f46764b;
        if (cVar != null) {
            cVar.a(j11, (d) this);
        }
    }

    private void b(com.instabug.featuresrequest.models.d dVar) {
        dVar.a(com.instabug.featuresrequest.models.c.USER_UN_VOTED);
        try {
            a.a(dVar);
        } catch (JSONException unused) {
        }
        b();
        com.instabug.featuresrequest.eventbus.a.a().post(dVar);
    }

    private void c(com.instabug.featuresrequest.models.d dVar) {
        dVar.a(com.instabug.featuresrequest.models.c.USER_VOTED_UP);
        try {
            a.a(dVar);
        } catch (JSONException unused) {
        }
        b();
        com.instabug.featuresrequest.eventbus.a.a().post(dVar);
    }

    public void a() {
        d dVar = this.f46763a;
        if (dVar != null) {
            dVar.F();
        }
    }

    public void a(long j11) {
        PoolProvider.postIOTask(new oc.c(this, j11));
    }

    public void a(com.instabug.featuresrequest.models.d dVar) {
        if (dVar.p()) {
            dVar.a(false);
            dVar.b(dVar.i() - 1);
            b(dVar);
        } else {
            dVar.a(true);
            dVar.b(dVar.i() + 1);
            c(dVar);
        }
        d dVar2 = this.f46763a;
        if (dVar2 != null) {
            dVar2.b(dVar);
        }
    }

    public void a(j jVar) {
        PoolProvider.postMainThreadTask(new e(this, jVar));
    }

    public void a(Throwable th2) {
        th2.printStackTrace();
    }
}
