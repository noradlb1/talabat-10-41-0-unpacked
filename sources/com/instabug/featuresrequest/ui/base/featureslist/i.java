package com.instabug.featuresrequest.ui.base.featureslist;

import com.instabug.featuresrequest.models.e;

class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f46649b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f46650c;

    public i(k kVar, e eVar) {
        this.f46650c = kVar;
        this.f46649b = eVar;
    }

    public void run() {
        if (this.f46649b.b() != null && this.f46649b.b().size() > 0) {
            k kVar = this.f46650c;
            if (kVar.f46652a) {
                kVar.f46653b.a();
            }
            this.f46650c.f46653b.a(this.f46649b.b());
            if (this.f46649b.c()) {
                this.f46650c.f46653b.f();
            } else {
                this.f46650c.f46653b.a(false);
            }
        }
        this.f46650c.f46654c.i();
    }
}
