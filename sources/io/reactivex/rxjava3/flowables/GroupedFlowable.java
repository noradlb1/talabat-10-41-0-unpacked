package io.reactivex.rxjava3.flowables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;

public abstract class GroupedFlowable<K, T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final K f18785c;

    public GroupedFlowable(@Nullable K k11) {
        this.f18785c = k11;
    }

    @Nullable
    public K getKey() {
        return this.f18785c;
    }
}
