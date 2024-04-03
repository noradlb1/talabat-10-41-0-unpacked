package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableElementAtMaybe;
import org.reactivestreams.Publisher;

public final class FlowableElementAtMaybePublisher<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f19691b;

    /* renamed from: c  reason: collision with root package name */
    public final long f19692c;

    public FlowableElementAtMaybePublisher(Publisher<T> publisher, long j11) {
        this.f19691b = publisher;
        this.f19692c = j11;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19691b.subscribe(new FlowableElementAtMaybe.ElementAtSubscriber(maybeObserver, this.f19692c));
    }
}
