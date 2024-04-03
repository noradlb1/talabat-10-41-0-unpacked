package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapMaybePublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<T> f21145c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f21146d;

    /* renamed from: e  reason: collision with root package name */
    public final ErrorMode f21147e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21148f;

    public FlowableConcatMapMaybePublisher(Publisher<T> publisher, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f21145c = publisher;
        this.f21146d = function;
        this.f21147e = errorMode;
        this.f21148f = i11;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21145c.subscribe(new FlowableConcatMapMaybe.ConcatMapMaybeSubscriber(subscriber, this.f21146d, this.f21148f, this.f21147e));
    }
}
