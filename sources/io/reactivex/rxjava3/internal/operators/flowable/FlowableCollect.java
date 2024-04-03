package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCollect<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final Supplier<? extends U> f19424d;

    /* renamed from: e  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f19425e;

    public static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3589550218733891694L;

        /* renamed from: d  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f19426d;

        /* renamed from: e  reason: collision with root package name */
        public final U f19427e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f19428f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f19429g;

        public CollectSubscriber(Subscriber<? super U> subscriber, U u11, BiConsumer<? super U, ? super T> biConsumer) {
            super(subscriber);
            this.f19426d = biConsumer;
            this.f19427e = u11;
        }

        public void cancel() {
            super.cancel();
            this.f19428f.cancel();
        }

        public void onComplete() {
            if (!this.f19429g) {
                this.f19429g = true;
                complete(this.f19427e);
            }
        }

        public void onError(Throwable th2) {
            if (this.f19429g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19429g = true;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19429g) {
                try {
                    this.f19426d.accept(this.f19427e, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19428f.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19428f, subscription)) {
                this.f19428f = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCollect(Flowable<T> flowable, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        super(flowable);
        this.f19424d = supplier;
        this.f19425e = biConsumer;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        try {
            Object obj = this.f19424d.get();
            Objects.requireNonNull(obj, "The initial value supplied is null");
            this.f19260c.subscribe(new CollectSubscriber(subscriber, obj, this.f19425e));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
