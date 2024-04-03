package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableIntervalRange extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final Scheduler f17352b;

    /* renamed from: c  reason: collision with root package name */
    public final long f17353c;

    /* renamed from: d  reason: collision with root package name */
    public final long f17354d;

    /* renamed from: e  reason: collision with root package name */
    public final long f17355e;

    /* renamed from: f  reason: collision with root package name */
    public final long f17356f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f17357g;

    public static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f17358b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17359c;

        /* renamed from: d  reason: collision with root package name */
        public long f17360d;

        public IntervalRangeObserver(Observer<? super Long> observer, long j11, long j12) {
            this.f17358b = observer;
            this.f17360d = j11;
            this.f17359c = j12;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                long j11 = this.f17360d;
                this.f17358b.onNext(Long.valueOf(j11));
                if (j11 == this.f17359c) {
                    DisposableHelper.dispose(this);
                    this.f17358b.onComplete();
                    return;
                }
                this.f17360d = j11 + 1;
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableIntervalRange(long j11, long j12, long j13, long j14, TimeUnit timeUnit, Scheduler scheduler) {
        this.f17355e = j13;
        this.f17356f = j14;
        this.f17357g = timeUnit;
        this.f17352b = scheduler;
        this.f17353c = j11;
        this.f17354d = j12;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.f17353c, this.f17354d);
        observer.onSubscribe(intervalRangeObserver);
        Scheduler scheduler = this.f17352b;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalRangeObserver.setResource(createWorker);
            createWorker.schedulePeriodically(intervalRangeObserver, this.f17355e, this.f17356f, this.f17357g);
            return;
        }
        intervalRangeObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeObserver, this.f17355e, this.f17356f, this.f17357g));
    }
}
