package com.instabug.apm.handler.uitrace.automatictraces;

import com.instabug.apm.cache.handler.uitrace.c;
import com.instabug.apm.cache.model.j;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.model.common.Session;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ j f45410b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f45411c;

    public b(c cVar, j jVar) {
        this.f45411c = cVar;
        this.f45410b = jVar;
    }

    public void run() {
        String str;
        a aVar;
        c i02 = com.instabug.apm.di.a.i0();
        Session b11 = this.f45411c.f45420i.b();
        String id2 = b11 != null ? b11.getId() : null;
        if (id2 != null) {
            this.f45410b.f(id2);
            if (i02.a(this.f45410b) != -1) {
                if (this.f45411c.f45421j != null) {
                    this.f45411c.f45421j.a(id2, 1);
                    int a11 = i02.a(id2, this.f45411c.f45413b.o());
                    if (a11 > 0) {
                        this.f45411c.f45421j.g(id2, a11);
                    }
                }
                i02.b(this.f45411c.f45413b.j0());
                return;
            }
            aVar = this.f45411c.f45414c;
            str = "Session meta data was not updated. Failed to save UITrace";
        } else {
            aVar = this.f45411c.f45414c;
            str = "UITrace was not inserted. APM session is null";
        }
        aVar.g(str);
    }
}
