package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromCompletable;
import org.reactivestreams.Subscriber;

public final class CompletableToFlowable<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f19239c;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.f19239c = completableSource;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19239c.subscribe(new FlowableFromCompletable.FromCompletableObserver(subscriber));
    }
}
