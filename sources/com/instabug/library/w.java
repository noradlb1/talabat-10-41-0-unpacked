package com.instabug.library;

import com.instabug.library.sessionV3.di.c;
import com.instabug.library.sessionV3.sync.SessionBatchingFilter;
import com.instabug.library.sessionV3.sync.SessionBatchingFilterKt;
import com.instabug.library.sessionV3.sync.o;

class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f50598b;

    public w(x xVar) {
        this.f50598b = xVar;
    }

    public void run() {
        SessionBatchingFilter sessionBatchingFilter;
        this.f50598b.f50600c.f50535c.a().g();
        o u11 = c.u();
        if (this.f50598b.f50599b) {
            sessionBatchingFilter = SessionBatchingFilterKt.getDataReadinessFilter();
        } else {
            sessionBatchingFilter = SessionBatchingFilterKt.getAllFilter();
        }
        u11.a(sessionBatchingFilter);
    }
}
