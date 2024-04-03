package com.instabug.featuresrequest.ui.addcomment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.instabug.featuresrequest.network.timelinerepository.c;
import com.instabug.featuresrequest.network.timelinerepository.d;
import com.instabug.featuresrequest.settings.a;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.util.threading.PoolProvider;
import lc.e;
import lc.f;
import org.json.JSONObject;

public class i extends BasePresenter implements d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private c f46617a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final a f46618b = ((a) this.f34200f.get());
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private volatile String f46619c;

    public i(a aVar) {
        super(aVar);
        PoolProvider.postIOTask(new f(this));
        if (aVar.getViewContext() != null && ((Fragment) aVar.getViewContext()).getContext() != null) {
            this.f46617a = c.a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        a aVar = this.f46618b;
        if (aVar != null) {
            aVar.b(str);
            this.f46618b.a(str2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        PoolProvider.postMainThreadTask(new lc.d(this, c(), b()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f46619c = InstabugCore.getEnteredEmail();
    }

    public void a() {
        PoolProvider.postIOTask(new e(this));
    }

    public void a(com.instabug.featuresrequest.models.f fVar) {
        a aVar = this.f46618b;
        if (aVar != null) {
            InstabugCore.setEnteredUsername(aVar.e());
            InstabugCore.setEnteredEmail(this.f46618b.s());
            this.f46618b.B();
        }
        c cVar = this.f46617a;
        if (cVar != null) {
            cVar.a(fVar, (d) this);
        }
    }

    public void a(Throwable th2) {
        PoolProvider.postMainThreadTask(new h(this));
    }

    public void a(JSONObject jSONObject) {
        PoolProvider.postMainThreadTask(new g(this));
    }

    public String b() {
        return this.f46619c != null ? this.f46619c : InstabugCore.getEnteredEmail();
    }

    public String c() {
        return InstabugCore.getEnteredUsername();
    }

    public void d() {
        a aVar = this.f46618b;
        if (aVar != null) {
            aVar.a(a.a().d());
        }
    }

    public boolean e() {
        return a.a().d();
    }

    public void h() {
        a aVar = this.f46618b;
        if (aVar != null) {
            aVar.z();
        }
    }

    public void i() {
        a aVar = this.f46618b;
        if (aVar != null) {
            aVar.H();
        }
    }
}
