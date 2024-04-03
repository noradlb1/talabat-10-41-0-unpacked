package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;

public abstract class GroupedFlowable<K, T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final K f14497c;

    public GroupedFlowable(@Nullable K k11) {
        this.f14497c = k11;
    }

    @Nullable
    public K getKey() {
        return this.f14497c;
    }
}
