package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableError<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends Throwable> f15194c;

    public FlowableError(Callable<? extends Throwable> callable) {
        this.f15194c = callable;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            th = (Throwable) ObjectHelper.requireNonNull(this.f15194c.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        EmptySubscription.error(th, subscriber);
    }
}
