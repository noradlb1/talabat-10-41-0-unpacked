package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<T, T, T> f15788d;

    public static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15789b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f15790c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15791d;

        /* renamed from: e  reason: collision with root package name */
        public T f15792e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f15793f;

        public ScanSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.f15789b = subscriber;
            this.f15790c = biFunction;
        }

        public void cancel() {
            this.f15791d.cancel();
        }

        public void onComplete() {
            if (!this.f15793f) {
                this.f15793f = true;
                this.f15789b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15793f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15793f = true;
            this.f15789b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15793f) {
                Subscriber<? super T> subscriber = this.f15789b;
                T t12 = this.f15792e;
                if (t12 == null) {
                    this.f15792e = t11;
                    subscriber.onNext(t11);
                    return;
                }
                try {
                    T requireNonNull = ObjectHelper.requireNonNull(this.f15790c.apply(t12, t11), "The value returned by the accumulator is null");
                    this.f15792e = requireNonNull;
                    subscriber.onNext(requireNonNull);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f15791d.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15791d, subscription)) {
                this.f15791d = subscription;
                this.f15789b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15791d.request(j11);
        }
    }

    public FlowableScan(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f15788d = biFunction;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new ScanSubscriber(subscriber, this.f15788d));
    }
}
