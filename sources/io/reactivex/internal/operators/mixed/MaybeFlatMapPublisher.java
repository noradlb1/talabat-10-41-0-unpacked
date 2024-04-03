package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeFlatMapPublisher<T, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<T> f16701c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<? extends R>> f16702d;

    public MaybeFlatMapPublisher(MaybeSource<T> maybeSource, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.f16701c = maybeSource;
        this.f16702d = function;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f16701c.subscribe(new FlatMapPublisherSubscriber(subscriber, this.f16702d));
    }

    public static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f16703b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<? extends R>> f16704c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16705d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f16706e = new AtomicLong();

        public FlatMapPublisherSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.f16703b = subscriber;
            this.f16704c = function;
        }

        public void cancel() {
            this.f16705d.dispose();
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            this.f16703b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16703b.onError(th2);
        }

        public void onNext(R r11) {
            this.f16703b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16705d, disposable)) {
                this.f16705d = disposable;
                this.f16703b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.f16704c.apply(t11), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16703b.onError(th2);
            }
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this, this.f16706e, j11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.f16706e, subscription);
        }
    }
}
