package com.instabug.library.migration;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

class c implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f51489a;

    public c(d dVar) {
        this.f51489a = dVar;
    }

    public void subscribe(ObservableEmitter observableEmitter) {
        observableEmitter.onNext(this.f51489a);
        observableEmitter.onComplete();
    }
}
