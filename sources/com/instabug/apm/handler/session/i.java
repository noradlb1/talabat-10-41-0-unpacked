package com.instabug.apm.handler.session;

import com.instabug.library.model.common.Session;

class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Session f45399b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ j f45400c;

    public i(j jVar, Session session) {
        this.f45400c = jVar;
        this.f45399b = session;
    }

    public void run() {
        this.f45400c.f45404d.execute(new h(this));
    }
}
