package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f16069d;

    public static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1015244841293359600L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f16070b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f16071c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f16072d;

        public final class Cancellation implements Runnable {
            public Cancellation() {
            }

            public void run() {
                UnsubscribeSubscriber.this.f16072d.cancel();
            }
        }

        public UnsubscribeSubscriber(Subscriber<? super T> subscriber, Scheduler scheduler) {
            this.f16070b = subscriber;
            this.f16071c = scheduler;
        }

        public void cancel() {
            if (compareAndSet(false, true)) {
                this.f16071c.scheduleDirect(new Cancellation());
            }
        }

        public void onComplete() {
            if (!get()) {
                this.f16070b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f16070b.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!get()) {
                this.f16070b.onNext(t11);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16072d, subscription)) {
                this.f16072d = subscription;
                this.f16070b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f16072d.request(j11);
        }
    }

    public FlowableUnsubscribeOn(Flowable<T> flowable, Scheduler scheduler) {
        super(flowable);
        this.f16069d = scheduler;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new UnsubscribeSubscriber(subscriber, this.f16069d));
    }
}
