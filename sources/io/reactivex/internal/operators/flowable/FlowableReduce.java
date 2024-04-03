package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableReduce<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<T, T, T> f15659d;

    public static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4663883003264602070L;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<T, T, T> f15660d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f15661e;

        public ReduceSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.f15660d = biFunction;
        }

        public void cancel() {
            super.cancel();
            this.f15661e.cancel();
            this.f15661e = SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            Subscription subscription = this.f15661e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f15661e = subscriptionHelper;
                T t11 = this.f18610c;
                if (t11 != null) {
                    complete(t11);
                } else {
                    this.f18609b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            Subscription subscription = this.f15661e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15661e = subscriptionHelper;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f15661e != SubscriptionHelper.CANCELLED) {
                T t12 = this.f18610c;
                if (t12 == null) {
                    this.f18610c = t11;
                    return;
                }
                try {
                    this.f18610c = ObjectHelper.requireNonNull(this.f15660d.apply(t12, t11), "The reducer returned a null value");
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f15661e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15661e, subscription)) {
                this.f15661e = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableReduce(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f15659d = biFunction;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new ReduceSubscriber(subscriber, this.f15659d));
    }
}
