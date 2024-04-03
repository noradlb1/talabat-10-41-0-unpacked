package com.instabug.library.migration;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

class k implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f51493a;

    public k(l lVar) {
        this.f51493a = lVar;
    }

    public void subscribe(ObservableEmitter observableEmitter) {
        if (this.f51493a.f51494a != null && this.f51493a.f51494a.get() != null) {
            this.f51493a.a();
            observableEmitter.onNext(this.f51493a);
            observableEmitter.onComplete();
        }
    }
}
