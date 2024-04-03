package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SingleFlatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<T> f18353c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f18354d;

    public SingleFlatMapPublisher(SingleSource<T> singleSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.f18353c = singleSource;
        this.f18354d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f18353c.subscribe(new SingleFlatMapPublisherObserver(subscriber, this.f18354d));
    }

    public static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements SingleObserver<S>, FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7759721921468635667L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f18355b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super S, ? extends Publisher<? extends T>> f18356c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Subscription> f18357d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public Disposable f18358e;

        public SingleFlatMapPublisherObserver(Subscriber<? super T> subscriber, Function<? super S, ? extends Publisher<? extends T>> function) {
            this.f18355b = subscriber;
            this.f18356c = function;
        }

        public void cancel() {
            this.f18358e.dispose();
            SubscriptionHelper.cancel(this.f18357d);
        }

        public void onComplete() {
            this.f18355b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f18355b.onError(th2);
        }

        public void onNext(T t11) {
            this.f18355b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f18358e = disposable;
            this.f18355b.onSubscribe(this);
        }

        public void onSuccess(S s11) {
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.f18356c.apply(s11), "the mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f18355b.onError(th2);
            }
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f18357d, this, j11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f18357d, this, subscription);
        }
    }
}
