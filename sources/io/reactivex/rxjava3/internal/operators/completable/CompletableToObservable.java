package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromCompletable;

public final class CompletableToObservable<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19240b;

    public CompletableToObservable(CompletableSource completableSource) {
        this.f19240b = completableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f19240b.subscribe(new ObservableFromCompletable.FromCompletableObserver(observer));
    }
}
