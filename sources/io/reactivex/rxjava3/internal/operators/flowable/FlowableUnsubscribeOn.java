package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f20577d;

    public static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1015244841293359600L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20578b;

        /* renamed from: c  reason: collision with root package name */
        public final Scheduler f20579c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20580d;

        public final class Cancellation implements Runnable {
            public Cancellation() {
            }

            public void run() {
                UnsubscribeSubscriber.this.f20580d.cancel();
            }
        }

        public UnsubscribeSubscriber(Subscriber<? super T> subscriber, Scheduler scheduler) {
            this.f20578b = subscriber;
            this.f20579c = scheduler;
        }

        public void cancel() {
            if (compareAndSet(false, true)) {
                this.f20579c.scheduleDirect(new Cancellation());
            }
        }

        public void onComplete() {
            if (!get()) {
                this.f20578b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f20578b.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!get()) {
                this.f20578b.onNext(t11);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20580d, subscription)) {
                this.f20580d = subscription;
                this.f20578b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20580d.request(j11);
        }
    }

    public FlowableUnsubscribeOn(Flowable<T> flowable, Scheduler scheduler) {
        super(flowable);
        this.f20577d = scheduler;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new UnsubscribeSubscriber(subscriber, this.f20577d));
    }
}
