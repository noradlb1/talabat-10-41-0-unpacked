package com.instabug.library.sessionprofiler;

import com.instabug.library.model.session.SessionState;
import io.reactivex.functions.Consumer;

class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f51861b;

    public a(e eVar) {
        this.f51861b = eVar;
    }

    /* renamed from: a */
    public void accept(SessionState sessionState) {
        if (sessionState == SessionState.START) {
            this.f51861b.c();
        } else if (sessionState == SessionState.FINISH) {
            this.f51861b.d();
        }
    }
}
