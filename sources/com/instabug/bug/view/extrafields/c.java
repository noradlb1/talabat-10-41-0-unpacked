package com.instabug.bug.view.extrafields;

import com.instabug.bug.di.a;
import com.instabug.bug.settings.b;
import com.instabug.bug.view.q;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f45828b;

    public c(d dVar) {
        this.f45828b = dVar;
    }

    public void run() {
        if (!b.f().t() || a.e().b()) {
            this.f45828b.finishActivity();
            return;
        }
        q b11 = q.b();
        if (this.f45828b.getFragmentManager() != null) {
            b11.show(this.f45828b.getFragmentManager(), "Instabug-Thanks-Fragment");
        }
    }
}
