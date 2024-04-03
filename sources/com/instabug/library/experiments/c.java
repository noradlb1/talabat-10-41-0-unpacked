package com.instabug.library.experiments;

import com.instabug.library.experiments.di.a;
import java.util.List;

class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f34360b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f34361c;

    public c(e eVar, List list) {
        this.f34361c = eVar;
        this.f34360b = list;
    }

    public void run() {
        synchronized (e.f34363a) {
            a.b().b(this.f34361c.c(this.f34360b));
        }
    }
}
