package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCollect<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Callable<? extends U> f14936d;

    /* renamed from: e  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f14937e;

    public static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3589550218733891694L;

        /* renamed from: d  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f14938d;

        /* renamed from: e  reason: collision with root package name */
        public final U f14939e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f14940f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f14941g;

        public CollectSubscriber(Subscriber<? super U> subscriber, U u11, BiConsumer<? super U, ? super T> biConsumer) {
            super(subscriber);
            this.f14938d = biConsumer;
            this.f14939e = u11;
        }

        public void cancel() {
            super.cancel();
            this.f14940f.cancel();
        }

        public void onComplete() {
            if (!this.f14941g) {
                this.f14941g = true;
                complete(this.f14939e);
            }
        }

        public void onError(Throwable th2) {
            if (this.f14941g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14941g = true;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14941g) {
                try {
                    this.f14938d.accept(this.f14939e, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14940f.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14940f, subscription)) {
                this.f14940f = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCollect(Flowable<T> flowable, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        super(flowable);
        this.f14936d = callable;
        this.f14937e = biConsumer;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            this.f14763c.subscribe(new CollectSubscriber(subscriber, ObjectHelper.requireNonNull(this.f14936d.call(), "The initial value supplied is null"), this.f14937e));
        } catch (Throwable th2) {
            EmptySubscription.error(th2, subscriber);
        }
    }
}
