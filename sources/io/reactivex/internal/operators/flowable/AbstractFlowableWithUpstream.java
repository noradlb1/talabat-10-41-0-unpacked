package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import org.reactivestreams.Publisher;

abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f14763c;

    public AbstractFlowableWithUpstream(Flowable<T> flowable) {
        this.f14763c = (Flowable) ObjectHelper.requireNonNull(flowable, "source is null");
    }

    public final Publisher<T> source() {
        return this.f14763c;
    }
}
