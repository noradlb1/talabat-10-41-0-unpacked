package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.stream.Collector;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCollectWithCollector<T, A, R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final Flowable<T> f18824c;

    /* renamed from: d  reason: collision with root package name */
    public final Collector<? super T, A, R> f18825d;

    public static final class CollectorSubscriber<T, A, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -229544830565448758L;

        /* renamed from: d  reason: collision with root package name */
        public final BiConsumer<A, T> f18826d;

        /* renamed from: e  reason: collision with root package name */
        public final Function<A, R> f18827e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f18828f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18829g;

        /* renamed from: h  reason: collision with root package name */
        public A f18830h;

        public CollectorSubscriber(Subscriber<? super R> subscriber, A a11, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            super(subscriber);
            this.f18830h = a11;
            this.f18826d = biConsumer;
            this.f18827e = function;
        }

        public void cancel() {
            super.cancel();
            this.f18828f.cancel();
        }

        public void onComplete() {
            if (!this.f18829g) {
                this.f18829g = true;
                this.f18828f = SubscriptionHelper.CANCELLED;
                A a11 = this.f18830h;
                this.f18830h = null;
                try {
                    R apply = this.f18827e.apply(a11);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    complete(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f23170b.onError(th2);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f18829g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18829g = true;
            this.f18828f = SubscriptionHelper.CANCELLED;
            this.f18830h = null;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18829g) {
                try {
                    this.f18826d.accept(this.f18830h, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f18828f.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(@NonNull Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18828f, subscription)) {
                this.f18828f = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCollectWithCollector(Flowable<T> flowable, Collector<? super T, A, R> collector) {
        this.f18824c = flowable;
        this.f18825d = collector;
    }

    public void subscribeActual(@NonNull Subscriber<? super R> subscriber) {
        try {
            this.f18824c.subscribe(new CollectorSubscriber(subscriber, this.f18825d.supplier().get(), this.f18825d.accumulator(), this.f18825d.finisher()));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
