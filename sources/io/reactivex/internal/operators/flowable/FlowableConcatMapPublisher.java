package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f15028c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f15029d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15030e;

    /* renamed from: f  reason: collision with root package name */
    public final ErrorMode f15031f;

    public FlowableConcatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i11, ErrorMode errorMode) {
        this.f15028c = publisher;
        this.f15029d = function;
        this.f15030e = i11;
        this.f15031f = errorMode;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f15028c, subscriber, this.f15029d)) {
            this.f15028c.subscribe(FlowableConcatMap.subscribe(subscriber, this.f15029d, this.f15030e, this.f15031f));
        }
    }
}
