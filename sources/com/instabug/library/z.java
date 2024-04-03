package com.instabug.library;

import com.instabug.library.sessionV3.di.c;
import com.instabug.library.sessionV3.sync.SessionBatchingFilterKt;

class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a0 f50602b;

    public z(a0 a0Var) {
        this.f50602b = a0Var;
    }

    public void run() {
        this.f50602b.f50529b.f50535c.d().a().g();
        c.u().a(SessionBatchingFilterKt.getNoneFilter());
    }
}
