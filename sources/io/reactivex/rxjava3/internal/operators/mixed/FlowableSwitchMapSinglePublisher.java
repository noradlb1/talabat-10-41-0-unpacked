package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapSingle;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableSwitchMapSinglePublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f21216c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f21217d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f21218e;

    public FlowableSwitchMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        this.f21216c = publisher;
        this.f21217d = function;
        this.f21218e = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21216c.subscribe(new FlowableSwitchMapSingle.SwitchMapSingleSubscriber(subscriber, this.f21217d, this.f21218e));
    }
}
