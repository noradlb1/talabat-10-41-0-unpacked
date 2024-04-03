package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f16009d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f16010e;

    public static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Timed<T>> f16011b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeUnit f16012c;

        /* renamed from: d  reason: collision with root package name */
        public final Scheduler f16013d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f16014e;

        /* renamed from: f  reason: collision with root package name */
        public long f16015f;

        public TimeIntervalSubscriber(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.f16011b = subscriber;
            this.f16013d = scheduler;
            this.f16012c = timeUnit;
        }

        public void cancel() {
            this.f16014e.cancel();
        }

        public void onComplete() {
            this.f16011b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16011b.onError(th2);
        }

        public void onNext(T t11) {
            long now = this.f16013d.now(this.f16012c);
            long j11 = this.f16015f;
            this.f16015f = now;
            this.f16011b.onNext(new Timed(t11, now - j11, this.f16012c));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16014e, subscription)) {
                this.f16015f = this.f16013d.now(this.f16012c);
                this.f16014e = subscription;
                this.f16011b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f16014e.request(j11);
        }
    }

    public FlowableTimeInterval(Flowable<T> flowable, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f16009d = scheduler;
        this.f16010e = timeUnit;
    }

    public void subscribeActual(Subscriber<? super Timed<T>> subscriber) {
        this.f14763c.subscribe(new TimeIntervalSubscriber(subscriber, this.f16010e, this.f16009d));
    }
}
