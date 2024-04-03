package com.instabug.chat.notification;

import android.view.View;
import com.instabug.chat.model.n;
import com.instabug.library.Instabug;
import com.instabug.library.util.ScreenUtility;

class i extends r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f46116b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s f46117c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(s sVar, n nVar) {
        super(sVar);
        this.f46117c = sVar;
        this.f46116b = nVar;
    }

    public void a() {
        this.f46117c.b(this.f46116b);
    }

    public void b() {
        View view = this.f46117c.f46131a != null ? (View) this.f46117c.f46131a.get() : null;
        if (view != null) {
            view.setY((float) ScreenUtility.getScreenHeight(Instabug.getApplicationContext()));
        }
        this.f46117c.b(this.f46116b);
    }
}
