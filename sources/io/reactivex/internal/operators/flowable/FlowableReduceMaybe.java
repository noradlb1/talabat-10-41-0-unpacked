package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceMaybe<T> extends Maybe<T> implements HasUpstreamPublisher<T>, FuseToFlowable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Flowable<T> f15662b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<T, T, T> f15663c;

    public static final class ReduceSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f15664b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f15665c;

        /* renamed from: d  reason: collision with root package name */
        public T f15666d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f15667e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f15668f;

        public ReduceSubscriber(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.f15664b = maybeObserver;
            this.f15665c = biFunction;
        }

        public void dispose() {
            this.f15667e.cancel();
            this.f15668f = true;
        }

        public boolean isDisposed() {
            return this.f15668f;
        }

        public void onComplete() {
            if (!this.f15668f) {
                this.f15668f = true;
                T t11 = this.f15666d;
                if (t11 != null) {
                    this.f15664b.onSuccess(t11);
                } else {
                    this.f15664b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f15668f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15668f = true;
            this.f15664b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15668f) {
                T t12 = this.f15666d;
                if (t12 == null) {
                    this.f15666d = t11;
                    return;
                }
                try {
                    this.f15666d = ObjectHelper.requireNonNull(this.f15665c.apply(t12, t11), "The reducer returned a null value");
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f15667e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15667e, subscription)) {
                this.f15667e = subscription;
                this.f15664b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableReduceMaybe(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        this.f15662b = flowable;
        this.f15663c = biFunction;
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableReduce(this.f15662b, this.f15663c));
    }

    public Publisher<T> source() {
        return this.f15662b;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f15662b.subscribe(new ReduceSubscriber(maybeObserver, this.f15663c));
    }
}
