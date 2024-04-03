package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SingleFlatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<T> f22910c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f22911d;

    public SingleFlatMapPublisher(SingleSource<T> singleSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.f22910c = singleSource;
        this.f22911d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f22910c.subscribe(new SingleFlatMapPublisherObserver(subscriber, this.f22911d));
    }

    public static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements SingleObserver<S>, FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7759721921468635667L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f22912b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super S, ? extends Publisher<? extends T>> f22913c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Subscription> f22914d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22915e;

        public SingleFlatMapPublisherObserver(Subscriber<? super T> subscriber, Function<? super S, ? extends Publisher<? extends T>> function) {
            this.f22912b = subscriber;
            this.f22913c = function;
        }

        public void cancel() {
            this.f22915e.dispose();
            SubscriptionHelper.cancel(this.f22914d);
        }

        public void onComplete() {
            this.f22912b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22912b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22912b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22915e = disposable;
            this.f22912b.onSubscribe(this);
        }

        public void onSuccess(S s11) {
            try {
                Object apply = this.f22913c.apply(s11);
                Objects.requireNonNull(apply, "the mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                if (this.f22914d.get() != SubscriptionHelper.CANCELLED) {
                    publisher.subscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22912b.onError(th2);
            }
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f22914d, this, j11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f22914d, this, subscription);
        }
    }
}
