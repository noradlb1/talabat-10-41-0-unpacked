package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f15023c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f15024d;

    /* renamed from: e  reason: collision with root package name */
    public final int f15025e;

    /* renamed from: f  reason: collision with root package name */
    public final int f15026f;

    /* renamed from: g  reason: collision with root package name */
    public final ErrorMode f15027g;

    public FlowableConcatMapEagerPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i11, int i12, ErrorMode errorMode) {
        this.f15023c = publisher;
        this.f15024d = function;
        this.f15025e = i11;
        this.f15026f = i12;
        this.f15027g = errorMode;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f15023c.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.f15024d, this.f15025e, this.f15026f, this.f15027g));
    }
}
