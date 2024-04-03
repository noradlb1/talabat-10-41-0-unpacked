package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;

abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21304b;

    public AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.f21304b = observableSource;
    }

    public final ObservableSource<T> source() {
        return this.f21304b;
    }
}
