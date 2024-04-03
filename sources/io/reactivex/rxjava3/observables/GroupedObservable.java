package io.reactivex.rxjava3.observables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;

public abstract class GroupedObservable<K, T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final K f23202b;

    public GroupedObservable(@Nullable K k11) {
        this.f23202b = k11;
    }

    @Nullable
    public K getKey() {
        return this.f23202b;
    }
}
