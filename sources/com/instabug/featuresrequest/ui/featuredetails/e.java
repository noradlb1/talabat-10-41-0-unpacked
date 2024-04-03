package com.instabug.featuresrequest.ui.featuredetails;

import com.instabug.featuresrequest.models.j;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f46761b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ f f46762c;

    public e(f fVar, j jVar) {
        this.f46762c = fVar;
        this.f46761b = jVar;
    }

    public void run() {
        if (this.f46762c.f46763a != null) {
            if (this.f46761b.b() == null || this.f46761b.b().size() <= 0) {
                this.f46762c.f46763a.d();
                return;
            }
            this.f46762c.f46763a.a(this.f46761b);
            this.f46762c.f46763a.t();
        }
    }
}
