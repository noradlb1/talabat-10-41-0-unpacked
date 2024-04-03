package com.instabug.library.invocation.invoker;

import com.instabug.library.model.session.SessionState;
import io.reactivex.functions.Consumer;

class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r f51388b;

    public q(r rVar) {
        this.f51388b = rVar;
    }

    /* renamed from: a */
    public void accept(SessionState sessionState) {
        if (sessionState.equals(SessionState.START)) {
            boolean unused = this.f51388b.f51393e = true;
        }
    }
}
