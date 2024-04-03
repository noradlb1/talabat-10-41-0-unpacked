package com.instabug.library.invocation.invoker;

import com.instabug.library.core.eventbus.a;
import io.reactivex.functions.Consumer;

class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f51340b;

    public e(p pVar) {
        this.f51340b = pVar;
    }

    /* renamed from: a */
    public void accept(a aVar) throws Exception {
        if (aVar.b() != null) {
            this.f51340b.a(aVar.b());
        }
    }
}
