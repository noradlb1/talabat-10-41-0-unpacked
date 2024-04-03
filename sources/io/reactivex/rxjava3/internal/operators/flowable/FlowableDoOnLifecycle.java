package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {
    private final Action onCancel;
    private final LongConsumer onRequest;
    private final Consumer<? super Subscription> onSubscribe;

    public static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19670b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super Subscription> f19671c;

        /* renamed from: d  reason: collision with root package name */
        public final LongConsumer f19672d;

        /* renamed from: e  reason: collision with root package name */
        public final Action f19673e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f19674f;

        public SubscriptionLambdaSubscriber(Subscriber<? super T> subscriber, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
            this.f19670b = subscriber;
            this.f19671c = consumer;
            this.f19673e = action;
            this.f19672d = longConsumer;
        }

        public void cancel() {
            Subscription subscription = this.f19674f;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f19674f = subscriptionHelper;
                try {
                    this.f19673e.run();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
                subscription.cancel();
            }
        }

        public void onComplete() {
            if (this.f19674f != SubscriptionHelper.CANCELLED) {
                this.f19670b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19674f != SubscriptionHelper.CANCELLED) {
                this.f19670b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            this.f19670b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            try {
                this.f19671c.accept(subscription);
                if (SubscriptionHelper.validate(this.f19674f, subscription)) {
                    this.f19674f = subscription;
                    this.f19670b.onSubscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                subscription.cancel();
                this.f19674f = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th2, this.f19670b);
            }
        }

        public void request(long j11) {
            try {
                this.f19672d.accept(j11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f19674f.request(j11);
        }
    }

    public FlowableDoOnLifecycle(Flowable<T> flowable, Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        super(flowable);
        this.onSubscribe = consumer;
        this.onRequest = longConsumer;
        this.onCancel = action;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new SubscriptionLambdaSubscriber(subscriber, this.onSubscribe, this.onRequest, this.onCancel));
    }
}
