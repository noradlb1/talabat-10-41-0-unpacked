package com.instabug.library.migration;

import com.instabug.library.internal.storage.cache.CacheManager;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

class i implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f51492a;

    public i(j jVar) {
        this.f51492a = jVar;
    }

    public void subscribe(ObservableEmitter observableEmitter) {
        CacheManager.getInstance().invalidateAllCaches();
        observableEmitter.onNext(this.f51492a);
        observableEmitter.onComplete();
    }
}
