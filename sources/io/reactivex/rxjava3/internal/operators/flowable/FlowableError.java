package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import org.reactivestreams.Subscriber;

public final class FlowableError<T> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<? extends Throwable> f19702c;

    public FlowableError(Supplier<? extends Throwable> supplier) {
        this.f19702c = supplier;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            th = (Throwable) ExceptionHelper.nullCheck(this.f19702c.get(), "Callable returned a null Throwable.");
        } catch (Throwable th2) {
            th = th2;
            Exceptions.throwIfFatal(th);
        }
        EmptySubscription.error(th, subscriber);
    }
}
