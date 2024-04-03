package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReduce<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<T, T, T> f20166d;

    public static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4663883003264602070L;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<T, T, T> f20167d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f20168e;

        public ReduceSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.f20167d = biFunction;
        }

        public void cancel() {
            super.cancel();
            this.f20168e.cancel();
            this.f20168e = SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            Subscription subscription = this.f20168e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f20168e = subscriptionHelper;
                T t11 = this.f23171c;
                if (t11 != null) {
                    complete(t11);
                } else {
                    this.f23170b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            Subscription subscription = this.f20168e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20168e = subscriptionHelper;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f20168e != SubscriptionHelper.CANCELLED) {
                T t12 = this.f23171c;
                if (t12 == null) {
                    this.f23171c = t11;
                    return;
                }
                try {
                    T apply = this.f20167d.apply(t12, t11);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.f23171c = apply;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20168e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20168e, subscription)) {
                this.f20168e = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableReduce(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f20166d = biFunction;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new ReduceSubscriber(subscriber, this.f20166d));
    }
}
