package com.instabug.library.networkv2;

import com.instabug.library.networkv2.ReactiveNetworkManager;
import com.instabug.library.networkv2.request.Request;
import io.reactivex.ObservableEmitter;

class g implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f51655a;

    public g(ReactiveNetworkManager.a aVar, ObservableEmitter observableEmitter) {
        this.f51655a = observableEmitter;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        this.f51655a.onNext(requestResponse);
        this.f51655a.onComplete();
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        this.f51655a.tryOnError(th2);
    }
}
