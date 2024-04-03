package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;

public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21805b;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f21805b = observableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21805b.subscribe(observer);
    }
}
