package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureError<T> extends AbstractFlowableWithUpstream<T, T> {

    public static final class BackpressureErrorSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3176480756392482682L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20091b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f20092c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f20093d;

        public BackpressureErrorSubscriber(Subscriber<? super T> subscriber) {
            this.f20091b = subscriber;
        }

        public void cancel() {
            this.f20092c.cancel();
        }

        public void onComplete() {
            if (!this.f20093d) {
                this.f20093d = true;
                this.f20091b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20093d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20093d = true;
            this.f20091b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20093d) {
                if (get() != 0) {
                    this.f20091b.onNext(t11);
                    BackpressureHelper.produced(this, 1);
                    return;
                }
                this.f20092c.cancel();
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20092c, subscription)) {
                this.f20092c = subscription;
                this.f20091b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }
    }

    public FlowableOnBackpressureError(Flowable<T> flowable) {
        super(flowable);
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new BackpressureErrorSubscriber(subscriber));
    }
}
