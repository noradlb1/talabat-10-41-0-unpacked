package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapMaybe;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFlatMapMaybePublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f19777c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f19778d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f19779e;

    /* renamed from: f  reason: collision with root package name */
    public final int f19780f;

    public FlowableFlatMapMaybePublisher(Publisher<T> publisher, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11, int i11) {
        this.f19777c = publisher;
        this.f19778d = function;
        this.f19779e = z11;
        this.f19780f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f19777c.subscribe(new FlowableFlatMapMaybe.FlatMapMaybeSubscriber(subscriber, this.f19778d, this.f19779e, this.f19780f));
    }
}
