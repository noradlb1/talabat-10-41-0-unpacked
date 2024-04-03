package com.instabug.featuresrequest.ui.base.featureslist;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.network.service.g;
import com.instabug.featuresrequest.network.service.l;
import com.instabug.featuresrequest.settings.a;
import com.instabug.featuresrequest.ui.base.b;
import com.instabug.featuresrequest.utils.d;
import com.instabug.library.Instabug;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.disposables.CompositeDisposable;
import mc.c;
import org.json.JSONException;

public abstract class n extends BasePresenter {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final f f46657a = ((f) this.f34200f.get());

    /* renamed from: c  reason: collision with root package name */
    private CompositeDisposable f46658c;

    /* renamed from: g  reason: collision with root package name */
    public b f46659g;

    public n(f fVar, b bVar, boolean z11) {
        super(fVar);
        this.f46659g = bVar;
        a(bVar, bVar.d(), false, a.g(), z11, true);
        m();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i11, boolean z11, boolean z12, boolean z13, boolean z14, b bVar) {
        if (!d.b() || Instabug.getApplicationContext() == null) {
            PoolProvider.postMainThreadTask(new c(this, bVar));
            return;
        }
        if (i11 == 1) {
            PoolProvider.postMainThreadTask(new mc.b(this));
        }
        g.a().a(i11, z11, z12, z13, new k(this, z14, bVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(b bVar) {
        if (this.f46657a != null) {
            if (bVar.c() == 0) {
                this.f46657a.x();
            } else {
                this.f46657a.v();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        f fVar = this.f46657a;
        if (fVar != null) {
            fVar.b(true);
        }
    }

    private void l() {
        f fVar = this.f46657a;
        if (fVar != null && ((Fragment) fVar.getViewContext()).getContext() != null) {
            l.b().start();
        }
    }

    private void m() {
        CompositeDisposable compositeDisposable = this.f46658c;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.f46658c = new CompositeDisposable();
        }
        this.f46658c.add(com.instabug.featuresrequest.eventbus.a.a().subscribe(new m(this)));
    }

    public int a() {
        return this.f46659g.c();
    }

    public void a(int i11) {
        f fVar = this.f46657a;
        if (fVar != null) {
            fVar.d(this.f46659g.a(i11));
        }
    }

    public void a(int i11, e eVar) {
        com.instabug.featuresrequest.models.d a11 = this.f46659g.a(i11);
        eVar.a(a11.m());
        eVar.a(a11);
        eVar.a(a11.b());
        eVar.b(a11.i());
        eVar.a(a11.d());
        eVar.a(Boolean.valueOf(a11.p()));
        eVar.b(a11);
    }

    public void a(com.instabug.featuresrequest.models.d dVar) {
        dVar.a(com.instabug.featuresrequest.models.c.USER_UN_VOTED);
        try {
            com.instabug.featuresrequest.cache.a.a(dVar);
        } catch (JSONException unused) {
        }
        l();
        com.instabug.featuresrequest.eventbus.a.a().post(dVar);
        f fVar = this.f46657a;
        if (fVar != null) {
            fVar.f();
        }
    }

    public void a(b bVar, int i11, boolean z11, boolean z12, boolean z13, boolean z14) {
        PoolProvider.postIOTask(new mc.a(this, i11, z11, z12, z13, z14, bVar));
    }

    public void b() {
        f fVar = this.f46657a;
        if (fVar != null) {
            fVar.h();
        }
    }

    public void b(com.instabug.featuresrequest.models.d dVar) {
        dVar.a(com.instabug.featuresrequest.models.c.USER_VOTED_UP);
        try {
            com.instabug.featuresrequest.cache.a.a(dVar);
        } catch (JSONException unused) {
        }
        l();
        com.instabug.featuresrequest.eventbus.a.a().post(dVar);
        f fVar = this.f46657a;
        if (fVar != null) {
            fVar.f();
        }
    }

    public boolean c() {
        return this.f46659g.e();
    }

    public void e() {
        f fVar = this.f46657a;
        if (fVar != null) {
            fVar.a();
        }
    }

    public void f() {
        f fVar = this.f46657a;
        if (fVar != null) {
            fVar.l();
            h();
        }
    }

    public void g() {
        if (this.f46657a != null && this.f46659g.d() != 1) {
            if (this.f46659g.e()) {
                this.f46657a.i();
                b bVar = this.f46659g;
                a(bVar, bVar.d(), false, a.g(), this.f46657a.I(), false);
                return;
            }
            this.f46657a.D();
        }
    }

    public void h() {
        this.f46659g.a(true);
        if (this.f46657a != null && Instabug.getApplicationContext() != null) {
            if (NetworkManager.isOnline()) {
                this.f46657a.b();
                this.f46657a.l();
                a(this.f46659g, 1, false, a.g(), this.f46657a.I(), true);
            } else if (this.f46659g.c() != 0) {
                this.f46657a.j();
                this.f46657a.D();
            } else if (NetworkManager.isOnline()) {
                this.f46657a.o();
            } else {
                this.f46657a.x();
            }
        }
    }

    public void i() {
        f fVar = this.f46657a;
        if (fVar != null && ((Fragment) fVar.getViewContext()).isAdded() && ((Fragment) this.f46657a.getViewContext()).getContext() != null) {
            this.f46657a.b(false);
            if (a() != 0) {
                this.f46657a.A();
            } else if (NetworkManager.isOnline()) {
                this.f46657a.o();
            } else {
                this.f46657a.x();
            }
        }
    }

    public void j() {
        f fVar = this.f46657a;
        if (fVar != null) {
            fVar.b(false);
            if (a() == 0) {
                this.f46657a.x();
                return;
            }
            this.f46657a.a(R.string.feature_requests_error_state_title);
            this.f46657a.v();
        }
    }

    public void k() {
        h();
    }

    public void onDestroy() {
        CompositeDisposable compositeDisposable = this.f46658c;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        this.f46659g.a();
    }
}
