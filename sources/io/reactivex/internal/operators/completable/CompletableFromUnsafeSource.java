package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;

public final class CompletableFromUnsafeSource extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14669b;

    public CompletableFromUnsafeSource(CompletableSource completableSource) {
        this.f14669b = completableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14669b.subscribe(completableObserver);
    }
}
