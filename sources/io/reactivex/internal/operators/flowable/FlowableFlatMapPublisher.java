package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f15269c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends U>> f15270d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15271e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15272f;

    /* renamed from: g  reason: collision with root package name */
    public final int f15273g;

    public FlowableFlatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends U>> function, boolean z11, int i11, int i12) {
        this.f15269c = publisher;
        this.f15270d = function;
        this.f15271e = z11;
        this.f15272f = i11;
        this.f15273g = i12;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f15269c, subscriber, this.f15270d)) {
            this.f15269c.subscribe(FlowableFlatMap.subscribe(subscriber, this.f15270d, this.f15271e, this.f15272f, this.f15273g));
        }
    }
}
