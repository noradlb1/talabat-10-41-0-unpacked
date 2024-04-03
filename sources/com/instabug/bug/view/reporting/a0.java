package com.instabug.bug.view.reporting;

import io.reactivex.functions.Consumer;

class a0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0 f45874b;

    public a0(g0 g0Var) {
        this.f45874b = g0Var;
    }

    /* renamed from: a */
    public void accept(Throwable th2) {
        g0.e(this.f45874b);
        if (this.f45874b.f34200f != null) {
            this.f45874b.a((i0) this.f45874b.f34200f.get());
        }
    }
}
