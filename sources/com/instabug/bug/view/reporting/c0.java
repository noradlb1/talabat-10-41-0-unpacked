package com.instabug.bug.view.reporting;

import com.instabug.bug.v;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class c0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0 f45878b;

    public c0(g0 g0Var) {
        this.f45878b = g0Var;
    }

    /* renamed from: a */
    public void accept(Throwable th2) {
        g0.e(this.f45878b);
        if (this.f45878b.f34200f != null) {
            this.f45878b.a((i0) this.f45878b.f34200f.get());
        }
        InstabugSDKLogger.e("IBG-BR", "State Building got error: " + th2.getMessage());
        v.b();
    }
}
