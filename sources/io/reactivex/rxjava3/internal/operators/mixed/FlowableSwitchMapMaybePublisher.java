package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapMaybe;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableSwitchMapMaybePublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f21197c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f21198d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f21199e;

    public FlowableSwitchMapMaybePublisher(Publisher<T> publisher, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        this.f21197c = publisher;
        this.f21198d = function;
        this.f21199e = z11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21197c.subscribe(new FlowableSwitchMapMaybe.SwitchMapMaybeSubscriber(subscriber, this.f21198d, this.f21199e));
    }
}
