package com.instabug.survey;

import com.instabug.survey.cache.l;
import java.util.List;

class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f52382b;

    public g(h hVar) {
        this.f52382b = hVar;
    }

    public void run() {
        List b11 = l.b();
        if (b11 != null && !b11.isEmpty()) {
            this.f52382b.n(b11);
        }
    }
}
