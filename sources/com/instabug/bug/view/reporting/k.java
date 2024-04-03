package com.instabug.bug.view.reporting;

import com.instabug.bug.di.a;
import com.instabug.bug.settings.b;
import com.instabug.bug.view.q;

class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f45902b;

    public k(x xVar) {
        this.f45902b = xVar;
    }

    public void run() {
        if (!b.f().t() || a.e().b()) {
            if (this.f45902b.f45931o != null) {
                this.f45902b.f45930n.l();
            }
        } else if (this.f45902b.getFragmentManager() != null) {
            q b11 = q.b();
            if (!this.f45902b.getFragmentManager().isStateSaved()) {
                b11.show(this.f45902b.getFragmentManager(), "Instabug-Thanks-Fragment");
            }
        }
    }
}
