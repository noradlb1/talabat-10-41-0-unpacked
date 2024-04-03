package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableIntervalRange extends Flowable<Long> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f19944c;

    /* renamed from: d  reason: collision with root package name */
    public final long f19945d;

    /* renamed from: e  reason: collision with root package name */
    public final long f19946e;

    /* renamed from: f  reason: collision with root package name */
    public final long f19947f;

    /* renamed from: g  reason: collision with root package name */
    public final long f19948g;

    /* renamed from: h  reason: collision with root package name */
    public final TimeUnit f19949h;

    public static final class IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Long> f19950b;

        /* renamed from: c  reason: collision with root package name */
        public final long f19951c;

        /* renamed from: d  reason: collision with root package name */
        public long f19952d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f19953e = new AtomicReference<>();

        public IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j11, long j12) {
            this.f19950b = subscriber;
            this.f19952d = j11;
            this.f19951c = j12;
        }

        public void cancel() {
            DisposableHelper.dispose(this.f19953e);
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }

        public void run() {
            Disposable disposable = this.f19953e.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                long j11 = get();
                if (j11 != 0) {
                    long j12 = this.f19952d;
                    this.f19950b.onNext(Long.valueOf(j12));
                    if (j12 == this.f19951c) {
                        if (this.f19953e.get() != disposableHelper) {
                            this.f19950b.onComplete();
                        }
                        DisposableHelper.dispose(this.f19953e);
                        return;
                    }
                    this.f19952d = j12 + 1;
                    if (j11 != Long.MAX_VALUE) {
                        decrementAndGet();
                        return;
                    }
                    return;
                }
                Subscriber<? super Long> subscriber = this.f19950b;
                subscriber.onError(new MissingBackpressureException("Can't deliver value " + this.f19952d + " due to lack of requests"));
                DisposableHelper.dispose(this.f19953e);
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this.f19953e, disposable);
        }
    }

    public FlowableIntervalRange(long j11, long j12, long j13, long j14, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19947f = j13;
        this.f19948g = j14;
        this.f19949h = timeUnit;
        this.f19944c = scheduler;
        this.f19945d = j11;
        this.f19946e = j12;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(subscriber, this.f19945d, this.f19946e);
        subscriber.onSubscribe(intervalRangeSubscriber);
        Scheduler scheduler = this.f19944c;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalRangeSubscriber.setResource(createWorker);
            createWorker.schedulePeriodically(intervalRangeSubscriber, this.f19947f, this.f19948g, this.f19949h);
            return;
        }
        intervalRangeSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeSubscriber, this.f19947f, this.f19948g, this.f19949h));
    }
}
