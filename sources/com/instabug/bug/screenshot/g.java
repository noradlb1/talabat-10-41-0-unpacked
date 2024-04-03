package com.instabug.bug.screenshot;

import com.instabug.library.InstabugState;
import io.reactivex.functions.Consumer;

class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f45736b;

    public g(h hVar) {
        this.f45736b = hVar;
    }

    /* renamed from: a */
    public void accept(InstabugState instabugState) {
        if (instabugState == InstabugState.DISABLED) {
            this.f45736b.a();
        }
    }
}
