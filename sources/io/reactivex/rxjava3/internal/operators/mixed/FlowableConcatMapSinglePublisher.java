package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapSinglePublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f21162c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f21163d;

    /* renamed from: e  reason: collision with root package name */
    public final ErrorMode f21164e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21165f;

    public FlowableConcatMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f21162c = publisher;
        this.f21163d = function;
        this.f21164e = errorMode;
        this.f21165f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21162c.subscribe(new FlowableConcatMapSingle.ConcatMapSingleSubscriber(subscriber, this.f21163d, this.f21165f, this.f21164e));
    }
}
