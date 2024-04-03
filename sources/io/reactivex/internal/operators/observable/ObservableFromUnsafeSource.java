package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17272b;

    public ObservableFromUnsafeSource(ObservableSource<T> observableSource) {
        this.f17272b = observableSource;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f17272b.subscribe(observer);
    }
}
