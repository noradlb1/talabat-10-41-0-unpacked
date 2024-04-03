package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<T, T, T> f20298d;

    public static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20299b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f20300c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20301d;

        /* renamed from: e  reason: collision with root package name */
        public T f20302e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20303f;

        public ScanSubscriber(Subscriber<? super T> subscriber, BiFunction<T, T, T> biFunction) {
            this.f20299b = subscriber;
            this.f20300c = biFunction;
        }

        public void cancel() {
            this.f20301d.cancel();
        }

        public void onComplete() {
            if (!this.f20303f) {
                this.f20303f = true;
                this.f20299b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20303f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20303f = true;
            this.f20299b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20303f) {
                Subscriber<? super T> subscriber = this.f20299b;
                T t12 = this.f20302e;
                if (t12 == null) {
                    this.f20302e = t11;
                    subscriber.onNext(t11);
                    return;
                }
                try {
                    T apply = this.f20300c.apply(t12, t11);
                    Objects.requireNonNull(apply, "The value returned by the accumulator is null");
                    this.f20302e = apply;
                    subscriber.onNext(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20301d.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20301d, subscription)) {
                this.f20301d = subscription;
                this.f20299b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20301d.request(j11);
        }
    }

    public FlowableScan(Flowable<T> flowable, BiFunction<T, T, T> biFunction) {
        super(flowable);
        this.f20298d = biFunction;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new ScanSubscriber(subscriber, this.f20298d));
    }
}
