package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableOnErrorReturn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f20110d;

    public static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;

        /* renamed from: f  reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f20111f;

        public OnErrorReturnSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends T> function) {
            super(subscriber);
            this.f20111f = function;
        }

        public void onComplete() {
            this.f23156b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f20111f.apply(th2);
                Objects.requireNonNull(apply, "The valueSupplier returned a null value");
                a(apply);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f23156b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f23159e++;
            this.f23156b.onNext(t11);
        }
    }

    public FlowableOnErrorReturn(Flowable<T> flowable, Function<? super Throwable, ? extends T> function) {
        super(flowable);
        this.f20110d = function;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new OnErrorReturnSubscriber(subscriber, this.f20110d));
    }
}
