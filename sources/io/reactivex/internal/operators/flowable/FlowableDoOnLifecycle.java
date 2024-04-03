package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {
    private final Action onCancel;
    private final LongConsumer onRequest;
    private final Consumer<? super Subscription> onSubscribe;

    public static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15164b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super Subscription> f15165c;

        /* renamed from: d  reason: collision with root package name */
        public final LongConsumer f15166d;

        /* renamed from: e  reason: collision with root package name */
        public final Action f15167e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f15168f;

        public SubscriptionLambdaSubscriber(Subscriber<? super T> subscriber, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
            this.f15164b = subscriber;
            this.f15165c = consumer;
            this.f15167e = action;
            this.f15166d = longConsumer;
        }

        public void cancel() {
            Subscription subscription = this.f15168f;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f15168f = subscriptionHelper;
                try {
                    this.f15167e.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
                subscription.cancel();
            }
        }

        public void onComplete() {
            if (this.f15168f != SubscriptionHelper.CANCELLED) {
                this.f15164b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15168f != SubscriptionHelper.CANCELLED) {
                this.f15164b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            this.f15164b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            try {
                this.f15165c.accept(subscription);
                if (SubscriptionHelper.validate(this.f15168f, subscription)) {
                    this.f15168f = subscription;
                    this.f15164b.onSubscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                subscription.cancel();
                this.f15168f = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th2, this.f15164b);
            }
        }

        public void request(long j11) {
            try {
                this.f15166d.accept(j11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f15168f.request(j11);
        }
    }

    public FlowableDoOnLifecycle(Flowable<T> flowable, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        super(flowable);
        this.onSubscribe = consumer;
        this.onRequest = longConsumer;
        this.onCancel = action;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new SubscriptionLambdaSubscriber(subscriber, this.onSubscribe, this.onRequest, this.onCancel));
    }
}
