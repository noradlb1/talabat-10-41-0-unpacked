package com.instabug.bug.view.reporting;

import com.instabug.bug.v;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class b0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0 f45876b;

    public b0(g0 g0Var) {
        this.f45876b = g0Var;
    }

    /* renamed from: a */
    public void accept(State.Action action) {
        g0.e(this.f45876b);
        if (this.f45876b.f34200f != null) {
            this.f45876b.a((i0) this.f45876b.f34200f.get());
        }
        InstabugSDKLogger.v("IBG-BR", "State Building finished action");
        v.b();
    }
}
