package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

abstract class AbstractMaybeWithUpstream<T, R> extends Maybe<R> implements HasUpstreamMaybeSource<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16264b;

    public AbstractMaybeWithUpstream(MaybeSource<T> maybeSource) {
        this.f16264b = maybeSource;
    }

    public final MaybeSource<T> source() {
        return this.f16264b;
    }
}
