package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import java.util.Objects;
import org.reactivestreams.Publisher;

abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f19260c;

    public AbstractFlowableWithUpstream(Flowable<T> flowable) {
        Objects.requireNonNull(flowable, "source is null");
        this.f19260c = flowable;
    }

    public final Publisher<T> source() {
        return this.f19260c;
    }
}
