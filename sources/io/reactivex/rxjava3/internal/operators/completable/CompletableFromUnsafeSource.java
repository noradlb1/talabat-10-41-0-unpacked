package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;

public final class CompletableFromUnsafeSource extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19155b;

    public CompletableFromUnsafeSource(CompletableSource completableSource) {
        this.f19155b = completableSource;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19155b.subscribe(completableObserver);
    }
}
