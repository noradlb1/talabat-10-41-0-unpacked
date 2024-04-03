package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f16214d;

    /* renamed from: e  reason: collision with root package name */
    public final Publisher<? extends U> f16215e;

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
        public final Subscriber<? super R> f16217b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends R> f16218c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Subscription> f16219d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f16220e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Subscription> f16221f = new AtomicReference<>();

        public WithLatestFromSubscriber(Subscriber<? super R> subscriber, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f16217b = subscriber;
            this.f16218c = biFunction;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f16219d);
            SubscriptionHelper.cancel(this.f16221f);
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f16221f);
            this.f16217b.onComplete();
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f16221f);
            this.f16217b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f16219d.get().request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f16219d, this.f16220e, subscription);
        }

        public void otherError(Throwable th2) {
            SubscriptionHelper.cancel(this.f16219d);
            this.f16217b.onError(th2);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f16219d, this.f16220e, j11);
        }

        public boolean setOther(Subscription subscription) {
            return SubscriptionHelper.setOnce(this.f16221f, subscription);
        }

        public boolean tryOnNext(T t11) {
            Object obj = get();
            if (obj != null) {
                try {
                    this.f16217b.onNext(ObjectHelper.requireNonNull(this.f16218c.apply(t11, obj), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    this.f16217b.onError(th2);
                }
            }
            return false;
        }
    }

    public FlowableWithLatestFrom(Flowable<T> flowable, BiFunction<? super T, ? super U, ? extends R> biFunction, Publisher<? extends U> publisher) {
        super(flowable);
        this.f16214d = biFunction;
        this.f16215e = publisher;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(serializedSubscriber, this.f16214d);
        serializedSubscriber.onSubscribe(withLatestFromSubscriber);
        this.f16215e.subscribe(new FlowableWithLatestSubscriber(withLatestFromSubscriber));
        this.f14763c.subscribe(withLatestFromSubscriber);
    }
}
