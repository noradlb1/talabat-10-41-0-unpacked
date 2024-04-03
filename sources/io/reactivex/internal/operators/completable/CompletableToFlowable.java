package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import org.reactivestreams.Subscriber;

public final class CompletableToFlowable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f14747c;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.f14747c = completableSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14747c.subscribe(new SubscriberCompletableObserver(subscriber));
    }
}
