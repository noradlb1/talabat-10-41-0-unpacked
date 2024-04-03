package com.instabug.bug.view.reporting;

class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i0 f45880b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g0 f45881c;

    public d0(g0 g0Var, i0 i0Var) {
        this.f45881c = g0Var;
        this.f45880b = i0Var;
    }

    public void run() {
        if (this.f45881c.f45892b != f0.SEND_BUG || this.f45881c.f45893c == 0) {
            this.f45880b.a();
            int i11 = e0.f45883a[this.f45881c.f45892b.ordinal()];
            if (i11 == 1) {
                this.f45881c.f();
            } else if (i11 == 2) {
                this.f45881c.b();
            } else if (i11 == 3) {
                this.f45881c.g();
            }
        }
    }
}
