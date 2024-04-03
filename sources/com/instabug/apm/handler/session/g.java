package com.instabug.apm.handler.session;

import com.instabug.apm.APMPlugin;
import com.instabug.apm.cache.model.f;

class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f45397b;

    public g(h hVar) {
        this.f45397b = hVar;
    }

    public void run() {
        synchronized (APMPlugin.lock) {
            if (this.f45397b.f45398a.f45400c.b() == null) {
                j jVar = this.f45397b.f45398a.f45400c;
                jVar.b(jVar.f45403c.a(this.f45397b.f45398a.f45399b));
                f c11 = this.f45397b.f45398a.f45400c.b();
                if (c11 != null) {
                    this.f45397b.f45398a.f45400c.a(c11);
                    this.f45397b.f45398a.f45400c.d();
                    k.b(c11, this.f45397b.f45398a.f45400c.f45403c.b(c11.getId()));
                }
            } else {
                this.f45397b.f45398a.f45400c.f45405e.g("Attempted to start session while another session is already running. Skipping..");
            }
        }
    }
}
