package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInterval extends Flowable<Long> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f15410c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15411d;

    /* renamed from: e  reason: collision with root package name */
    public final long f15412e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f15413f;

    public static final class IntervalSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Long> f15414b;

        /* renamed from: c  reason: collision with root package name */
        public long f15415c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f15416d = new AtomicReference<>();

        public IntervalSubscriber(Subscriber<? super Long> subscriber) {
            this.f15414b = subscriber;
        }

        public void cancel() {
            DisposableHelper.dispose(this.f15416d);
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }

        public void run() {
            if (this.f15416d.get() == DisposableHelper.DISPOSED) {
                return;
            }
            if (get() != 0) {
                Subscriber<? super Long> subscriber = this.f15414b;
                long j11 = this.f15415c;
                this.f15415c = j11 + 1;
                subscriber.onNext(Long.valueOf(j11));
                BackpressureHelper.produced(this, 1);
                return;
            }
            Subscriber<? super Long> subscriber2 = this.f15414b;
            subscriber2.onError(new MissingBackpressureException("Can't deliver value " + this.f15415c + " due to lack of requests"));
            DisposableHelper.dispose(this.f15416d);
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this.f15416d, disposable);
        }
    }

    public FlowableInterval(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        this.f15411d = j11;
        this.f15412e = j12;
        this.f15413f = timeUnit;
        this.f15410c = scheduler;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(subscriber);
        subscriber.onSubscribe(intervalSubscriber);
        Scheduler scheduler = this.f15410c;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalSubscriber.setResource(createWorker);
            createWorker.schedulePeriodically(intervalSubscriber, this.f15411d, this.f15412e, this.f15413f);
            return;
        }
        intervalSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalSubscriber, this.f15411d, this.f15412e, this.f15413f));
    }
}
