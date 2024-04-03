package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableOnErrorReturn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f15586d;

    public static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;

        /* renamed from: f  reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f15587f;

        public OnErrorReturnSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends T> function) {
            super(subscriber);
            this.f15587f = function;
        }

        public void onComplete() {
            this.f18595b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                a(ObjectHelper.requireNonNull(this.f15587f.apply(th2), "The valueSupplier returned a null value"));
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f18595b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f18598e++;
            this.f18595b.onNext(t11);
        }
    }

    public FlowableOnErrorReturn(Flowable<T> flowable, Function<? super Throwable, ? extends T> function) {
        super(flowable);
        this.f15586d = function;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new OnErrorReturnSubscriber(subscriber, this.f15586d));
    }
}
