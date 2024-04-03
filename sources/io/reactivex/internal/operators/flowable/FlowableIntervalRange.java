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

public final class FlowableIntervalRange extends Flowable<Long> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f15417c;

    /* renamed from: d  reason: collision with root package name */
    public final long f15418d;

    /* renamed from: e  reason: collision with root package name */
    public final long f15419e;

    /* renamed from: f  reason: collision with root package name */
    public final long f15420f;

    /* renamed from: g  reason: collision with root package name */
    public final long f15421g;

    /* renamed from: h  reason: collision with root package name */
    public final TimeUnit f15422h;

    public static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Long> f15423b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15424c;

        /* renamed from: d  reason: collision with root package name */
        public long f15425d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f15426e = new AtomicReference<>();

        public IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j11, long j12) {
            this.f15423b = subscriber;
            this.f15425d = j11;
            this.f15424c = j12;
        }

        public void cancel() {
            DisposableHelper.dispose(this.f15426e);
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }

        public void run() {
            Disposable disposable = this.f15426e.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                long j11 = get();
                if (j11 != 0) {
                    long j12 = this.f15425d;
                    this.f15423b.onNext(Long.valueOf(j12));
                    if (j12 == this.f15424c) {
                        if (this.f15426e.get() != disposableHelper) {
                            this.f15423b.onComplete();
                        }
                        DisposableHelper.dispose(this.f15426e);
                        return;
                    }
                    this.f15425d = j12 + 1;
                    if (j11 != Long.MAX_VALUE) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
                Subscriber<? super Long> subscriber = this.f15423b;
                subscriber.onError(new MissingBackpressureException("Can't deliver value " + this.f15425d + " due to lack of requests"));
                DisposableHelper.dispose(this.f15426e);
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this.f15426e, disposable);
        }
    }

    public FlowableIntervalRange(long j11, long j12, long j13, long j14, TimeUnit timeUnit, Scheduler scheduler) {
        this.f15420f = j13;
        this.f15421g = j14;
        this.f15422h = timeUnit;
        this.f15417c = scheduler;
        this.f15418d = j11;
        this.f15419e = j12;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.f15418d, this.f15419e);
        subscriber.onSubscribe(intervalRangeSubscriber);
        Scheduler scheduler = this.f15417c;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalRangeSubscriber.setResource(createWorker);
            createWorker.schedulePeriodically(intervalRangeSubscriber, this.f15420f, this.f15421g, this.f15422h);
            return;
        }
        intervalRangeSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeSubscriber, this.f15420f, this.f15421g, this.f15422h));
    }
}
