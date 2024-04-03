package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f19511c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f19512d;

    /* renamed from: e  reason: collision with root package name */
    public final int f19513e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19514f;

    /* renamed from: g  reason: collision with root package name */
    public final ErrorMode f19515g;

    public FlowableConcatMapEagerPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i11, int i12, ErrorMode errorMode) {
        this.f19511c = publisher;
        this.f19512d = function;
        this.f19513e = i11;
        this.f19514f = i12;
        this.f19515g = errorMode;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19511c.subscribe(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.f19512d, this.f19513e, this.f19514f, this.f19515g));
    }
}
