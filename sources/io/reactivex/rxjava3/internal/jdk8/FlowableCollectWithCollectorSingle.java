package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.stream.Collector;
import java.util.Objects;
import org.reactivestreams.Subscription;

public final class FlowableCollectWithCollectorSingle<T, A, R> extends Single<R> implements FuseToFlowable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f18831b;

    /* renamed from: c  reason: collision with root package name */
    public final Collector<? super T, A, R> f18832c;

    public static final class CollectorSingleObserver<T, A, R> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f18833b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<A, T> f18834c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<A, R> f18835d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f18836e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18837f;

        /* renamed from: g  reason: collision with root package name */
        public A f18838g;

        public CollectorSingleObserver(SingleObserver<? super R> singleObserver, A a11, BiConsumer<A, T> biConsumer, Function<A, R> function) {
            this.f18833b = singleObserver;
            this.f18838g = a11;
            this.f18834c = biConsumer;
            this.f18835d = function;
        }

        public void dispose() {
            this.f18836e.cancel();
            this.f18836e = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f18836e == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            if (!this.f18837f) {
                this.f18837f = true;
                this.f18836e = SubscriptionHelper.CANCELLED;
                A a11 = this.f18838g;
                this.f18838g = null;
                try {
                    R apply = this.f18835d.apply(a11);
                    Objects.requireNonNull(apply, "The finisher returned a null value");
                    this.f18833b.onSuccess(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f18833b.onError(th2);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f18837f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18837f = true;
            this.f18836e = SubscriptionHelper.CANCELLED;
            this.f18838g = null;
            this.f18833b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18837f) {
                try {
                    this.f18834c.accept(this.f18838g, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f18836e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(@NonNull Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18836e, subscription)) {
                this.f18836e = subscription;
                this.f18833b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableCollectWithCollectorSingle(Flowable<T> flowable, Collector<? super T, A, R> collector) {
        this.f18831b = flowable;
        this.f18832c = collector;
    }

    public Flowable<R> fuseToFlowable() {
        return new FlowableCollectWithCollector(this.f18831b, this.f18832c);
    }

    public void subscribeActual(@NonNull SingleObserver<? super R> singleObserver) {
        try {
            this.f18831b.subscribe(new CollectorSingleObserver(singleObserver, this.f18832c.supplier().get(), this.f18832c.accumulator(), this.f18832c.finisher()));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
