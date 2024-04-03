package com.instabug.featuresrequest.ui.newfeature;

import androidx.annotation.Nullable;
import com.instabug.featuresrequest.models.d;
import com.instabug.featuresrequest.network.service.b;
import com.instabug.featuresrequest.settings.a;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BasePresenter;
import com.instabug.library.user.UserManagerWrapper;
import com.instabug.library.util.threading.PoolProvider;
import pc.e;
import pc.f;

public class k extends BasePresenter {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final a f46827a = ((a) this.f34200f.get());
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private volatile String f46828b = null;

    public k(a aVar) {
        super(aVar);
        PoolProvider.postIOTask(new f(this));
    }

    private void a() {
        a aVar = this.f46827a;
        if (aVar != null) {
            InstabugCore.setEnteredEmail(aVar.y());
            InstabugCore.setEnteredUsername(this.f46827a.g());
            this.f46827a.p();
            d dVar = new d(UserManagerWrapper.getUserName(), UserManagerWrapper.getUserEmail(), InstabugCore.getPushNotificationToken());
            dVar.d(this.f46827a.c() != null ? this.f46827a.c() : "");
            dVar.c(this.f46827a.q());
            if (Instabug.getApplicationContext() != null) {
                b.a().b(dVar, new j(this, dVar));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        a aVar = this.f46827a;
        if (aVar != null) {
            aVar.a(str);
            this.f46827a.b(str2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        String enteredEmail = InstabugCore.getEnteredEmail();
        this.f46828b = enteredEmail;
        PoolProvider.postMainThreadTask(new e(this, enteredEmail, c()));
    }

    public String b() {
        return this.f46828b != null ? this.f46828b : InstabugCore.getEnteredEmail();
    }

    public String c() {
        return InstabugCore.getEnteredUsername();
    }

    public void d() {
        a aVar = this.f46827a;
        if (aVar != null) {
            aVar.a(a.a().f());
        }
    }

    public void f() {
        a aVar = this.f46827a;
        if (aVar != null && aVar.c() != null) {
            if ((!a.a().f() && this.f46827a.y().length() <= 0) || this.f46827a.J() != null) {
                a();
            }
        }
    }
}
