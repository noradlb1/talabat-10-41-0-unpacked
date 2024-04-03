package com.instabug.library.networkv2;

import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.networkv2.request.Request;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class ReactiveNetworkManager {
    /* access modifiers changed from: private */
    public final NetworkManager networkManager = new NetworkManager();

    public class a implements ObservableOnSubscribe {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f51641a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f51642b;

        public a(int i11, Request request) {
            this.f51641a = i11;
            this.f51642b = request;
        }

        public void subscribe(@NonNull ObservableEmitter observableEmitter) throws Exception {
            ReactiveNetworkManager.this.networkManager.doRequest(IBGNetworkWorker.CORE, this.f51641a, this.f51642b, (Request.Callbacks<RequestResponse, Throwable>) new g(this, observableEmitter));
        }
    }

    public Observable<RequestResponse> doRequest(int i11, @androidx.annotation.NonNull Request request) {
        if (this.networkManager.getOnDoRequestListener() != null) {
            this.networkManager.getOnDoRequestListener().onRequestStarted(request);
        }
        return Observable.create(new a(i11, request));
    }
}
