package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f20517d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f20518e;

    public static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Timed<T>> f20519b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeUnit f20520c;

        /* renamed from: d  reason: collision with root package name */
        public final Scheduler f20521d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f20522e;

        /* renamed from: f  reason: collision with root package name */
        public long f20523f;

        public TimeIntervalSubscriber(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.f20519b = subscriber;
            this.f20521d = scheduler;
            this.f20520c = timeUnit;
        }

        public void cancel() {
            this.f20522e.cancel();
        }

        public void onComplete() {
            this.f20519b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20519b.onError(th2);
        }

        public void onNext(T t11) {
            long now = this.f20521d.now(this.f20520c);
            long j11 = this.f20523f;
            this.f20523f = now;
            this.f20519b.onNext(new Timed(t11, now - j11, this.f20520c));
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20522e, subscription)) {
                this.f20523f = this.f20521d.now(this.f20520c);
                this.f20522e = subscription;
                this.f20519b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20522e.request(j11);
        }
    }

    public FlowableTimeInterval(Flowable<T> flowable, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.f20517d = scheduler;
        this.f20518e = timeUnit;
    }

    public void subscribeActual(Subscriber<? super Timed<T>> subscriber) {
        this.f19260c.subscribe(new TimeIntervalSubscriber(subscriber, this.f20518e, this.f20517d));
    }
}
