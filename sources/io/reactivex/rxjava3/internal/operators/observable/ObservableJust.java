package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.rxjava3.operators.ScalarSupplier;

public final class ObservableJust<T> extends Observable<T> implements ScalarSupplier<T> {
    private final T value;

    public ObservableJust(T t11) {
        this.value = t11;
    }

    public T get() {
        return this.value;
    }

    public void subscribeActual(Observer<? super T> observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.value);
        observer.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
