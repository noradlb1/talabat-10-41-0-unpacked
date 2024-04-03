package com.instabug.library.migration;

import com.instabug.library.internal.storage.cache.CacheManager;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

class g implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f51491a;

    public g(h hVar) {
        this.f51491a = hVar;
    }

    public void subscribe(ObservableEmitter observableEmitter) {
        CacheManager.getInstance().invalidateAllCaches();
        observableEmitter.onNext(this.f51491a);
        observableEmitter.onComplete();
    }
}
