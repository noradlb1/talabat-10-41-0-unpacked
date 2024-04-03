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

public final class FlowableInterval extends Flowable<Long> {

    /* renamed from: c  reason: collision with root package name */
    public final Scheduler f19937c;

    /* renamed from: d  reason: collision with root package name */
    public final long f19938d;

    /* renamed from: e  reason: collision with root package name */
    public final long f19939e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f19940f;

    public static final class IntervalSubscriber extends AtomicLong implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Long> f19941b;

        /* renamed from: c  reason: collision with root package name */
        public long f19942c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f19943d = new AtomicReference<>();

        public IntervalSubscriber(Subscriber<? super Long> subscriber) {
            this.f19941b = subscriber;
        }

        public void cancel() {
            DisposableHelper.dispose(this.f19943d);
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this, j11);
            }
        }

        public void run() {
            if (this.f19943d.get() == DisposableHelper.DISPOSED) {
                return;
            }
            if (get() != 0) {
                Subscriber<? super Long> subscriber = this.f19941b;
                long j11 = this.f19942c;
                this.f19942c = j11 + 1;
                subscriber.onNext(Long.valueOf(j11));
                BackpressureHelper.produced(this, 1);
                return;
            }
            Subscriber<? super Long> subscriber2 = this.f19941b;
            subscriber2.onError(new MissingBackpressureException("Can't deliver value " + this.f19942c + " due to lack of requests"));
            DisposableHelper.dispose(this.f19943d);
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this.f19943d, disposable);
        }
    }

    public FlowableInterval(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19938d = j11;
        this.f19939e = j12;
        this.f19940f = timeUnit;
        this.f19937c = scheduler;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(subscriber);
        subscriber.onSubscribe(intervalSubscriber);
        Scheduler scheduler = this.f19937c;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalSubscriber.setResource(createWorker);
            createWorker.schedulePeriodically(intervalSubscriber, this.f19938d, this.f19939e, this.f19940f);
            return;
        }
        intervalSubscriber.setResource(scheduler.schedulePeriodicallyDirect(intervalSubscriber, this.f19938d, this.f19939e, this.f19940f));
    }
}
