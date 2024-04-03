package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;

public abstract class GroupedObservable<K, T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final K f18641b;

    public GroupedObservable(@Nullable K k11) {
        this.f18641b = k11;
    }

    @Nullable
    public K getKey() {
        return this.f18641b;
    }
}
