package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f20713d;

    /* renamed from: e  reason: collision with root package name */
    public final Publisher<? extends U> f20714e;

    public final class FlowableWithLatestSubscriber implements FlowableSubscriber<U> {
        private final WithLatestFromSubscriber<T, U, R> wlf;

        public FlowableWithLatestSubscriber(WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
            this.wlf = withLatestFromSubscriber;
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            this.wlf.otherError(th2);
        }

        public void onNext(U u11) {
            this.wlf.lazySet(u11);
        }

        public void onSubscribe(Subscription subscription) {
            if (this.wlf.setOther(subscription)) {
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -312246233408980075L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f20716b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends R> f20717c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Subscription> f20718d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f20719e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Subscription> f20720f = new AtomicReference<>();

        public WithLatestFromSubscriber(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f20716b = subscriber;
            this.f20717c = biFunction;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f20718d);
            SubscriptionHelper.cancel(this.f20720f);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f20720f);
            this.f20716b.onComplete();
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f20720f);
            this.f20716b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f20718d.get().request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f20718d, this.f20719e, subscription);
        }

        public void otherError(Throwable th2) {
            SubscriptionHelper.cancel(this.f20718d);
            this.f20716b.onError(th2);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f20718d, this.f20719e, j11);
        }

        public boolean setOther(Subscription subscription) {
            return SubscriptionHelper.setOnce(this.f20720f, subscription);
        }

        public boolean tryOnNext(T t11) {
            Object obj = get();
            if (obj != null) {
                try {
                    Object apply = this.f20717c.apply(t11, obj);
                    Objects.requireNonNull(apply, "The combiner returned a null value");
                    this.f20716b.onNext(apply);
                    return true;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    this.f20716b.onError(th2);
                }
            }
            return false;
        }
    }

    public FlowableWithLatestFrom(Flowable<T> flowable, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher) {
        super(flowable);
        this.f20713d = biFunction;
        this.f20714e = publisher;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(serializedSubscriber, this.f20713d);
        serializedSubscriber.onSubscribe(withLatestFromSubscriber);
        this.f20714e.subscribe(new FlowableWithLatestSubscriber(withLatestFromSubscriber));
        this.f19260c.subscribe(withLatestFromSubscriber);
    }
}
