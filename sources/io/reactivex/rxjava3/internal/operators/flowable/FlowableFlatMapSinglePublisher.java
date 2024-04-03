package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapSingle;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFlatMapSinglePublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f19796c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f19797d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f19798e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19799f;

    public FlowableFlatMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11, int i11) {
        this.f19796c = publisher;
        this.f19797d = function;
        this.f19798e = z11;
        this.f19799f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19796c.subscribe(new FlowableFlatMapSingle.FlatMapSingleSubscriber(subscriber, this.f19797d, this.f19798e, this.f19799f));
    }
}
