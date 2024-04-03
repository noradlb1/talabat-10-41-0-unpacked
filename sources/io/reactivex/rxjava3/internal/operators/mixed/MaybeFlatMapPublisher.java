package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeFlatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<T> f21225c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f21226d;

    public MaybeFlatMapPublisher(MaybeSource<T> maybeSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.f21225c = maybeSource;
        this.f21226d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21225c.subscribe(new FlatMapPublisherSubscriber(subscriber, this.f21226d));
    }

    public static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f21227b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f21228c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21229d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f21230e = new AtomicLong();

        public FlatMapPublisherSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.f21227b = subscriber;
            this.f21228c = function;
        }

        public void cancel() {
            this.f21229d.dispose();
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f21227b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21227b.onError(th2);
        }

        public void onNext(R r11) {
            this.f21227b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21229d, disposable)) {
                this.f21229d = disposable;
                this.f21227b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f21228c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                if (get() != SubscriptionHelper.CANCELLED) {
                    publisher.subscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21227b.onError(th2);
            }
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this, this.f21230e, j11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.f21230e, subscription);
        }
    }
}
