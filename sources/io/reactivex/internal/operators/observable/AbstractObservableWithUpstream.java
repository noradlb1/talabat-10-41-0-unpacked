package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;

abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f16799b;

    public AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.f16799b = observableSource;
    }

    public final ObservableSource<T> source() {
        return this.f16799b;
    }
}
