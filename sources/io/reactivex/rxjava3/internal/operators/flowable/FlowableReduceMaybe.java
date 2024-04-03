package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceMaybe<T> extends Maybe<T> implements HasUpstreamPublisher<T>, FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f20169b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<T, T, T> f20170c;

    public static final class ReduceSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20171b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f20172c;

        /* renamed from: d  reason: collision with root package name */
        public T f20173d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f20174e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20175f;

        public ReduceSubscriber(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.f20171b = maybeObserver;
            this.f20172c = biFunction;
        }

        public void dispose() {
            this.f20174e.cancel();
            this.f20175f = true;
        }

        public boolean isDisposed() {
            return this.f20175f;
        }

        public void onComplete() {
            if (!this.f20175f) {
                this.f20175f = true;
                T t11 = this.f20173d;
                if (t11 != null) {
                    this.f20171b.onSuccess(t11);
                } else {
                    this.f20171b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f20175f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20175f = true;
            this.f20171b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20175f) {
                T t12 = this.f20173d;
                if (t12 == null) {
                    this.f20173d = t11;
                    return;
                }
                try {
                    T apply = this.f20172c.apply(t12, t11);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.f20173d = apply;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20174e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20174e, subscription)) {
                this.f20174e = subscription;
                this.f20171b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableReduceMaybe(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        this.f20169b = flowable;
        this.f20170c = biFunction;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableReduce(this.f20169b, this.f20170c));
    }

    public Publisher<T> source() {
        return this.f20169b;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20169b.subscribe(new ReduceSubscriber(maybeObserver, this.f20170c));
    }
}
