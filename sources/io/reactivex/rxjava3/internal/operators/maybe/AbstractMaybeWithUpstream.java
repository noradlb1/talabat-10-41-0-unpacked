package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamMaybeSource;

abstract class AbstractMaybeWithUpstream<T, R> extends Maybe<R> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20763b;

    public AbstractMaybeWithUpstream(MaybeSource<T> maybeSource) {
        this.f20763b = maybeSource;
    }

    public final MaybeSource<T> source() {
        return this.f20763b;
    }
}
