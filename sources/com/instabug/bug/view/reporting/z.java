package com.instabug.bug.view.reporting;

import com.instabug.bug.screenshot.viewhierarchy.d;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class z implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0 f45944b;

    public z(g0 g0Var) {
        this.f45944b = g0Var;
    }

    /* renamed from: a */
    public void accept(d dVar) {
        g0.e(this.f45944b);
        InstabugSDKLogger.d("IBG-BR", "Received a view hierarchy inspection action, action value: " + dVar);
        if ((dVar == d.COMPLETED || dVar == d.FAILED) && this.f45944b.f34200f != null) {
            this.f45944b.a((i0) this.f45944b.f34200f.get());
        }
    }
}
