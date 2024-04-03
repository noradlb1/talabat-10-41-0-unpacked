package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableIntervalRange extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final Scheduler f21899b;

    /* renamed from: c  reason: collision with root package name */
    public final long f21900c;

    /* renamed from: d  reason: collision with root package name */
    public final long f21901d;

    /* renamed from: e  reason: collision with root package name */
    public final long f21902e;

    /* renamed from: f  reason: collision with root package name */
    public final long f21903f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeUnit f21904g;

    public static final class IntervalRangeObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f21905b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21906c;

        /* renamed from: d  reason: collision with root package name */
        public long f21907d;

        public IntervalRangeObserver(Observer<? super Long> observer, long j11, long j12) {
            this.f21905b = observer;
            this.f21907d = j11;
            this.f21906c = j12;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                long j11 = this.f21907d;
                this.f21905b.onNext(Long.valueOf(j11));
                if (j11 == this.f21906c) {
                    if (!isDisposed()) {
                        this.f21905b.onComplete();
                    }
                    DisposableHelper.dispose(this);
                    return;
                }
                this.f21907d = j11 + 1;
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableIntervalRange(long j11, long j12, long j13, long j14, TimeUnit timeUnit, Scheduler scheduler) {
        this.f21902e = j13;
        this.f21903f = j14;
        this.f21904g = timeUnit;
        this.f21899b = scheduler;
        this.f21900c = j11;
        this.f21901d = j12;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(observer, this.f21900c, this.f21901d);
        observer.onSubscribe(intervalRangeObserver);
        Scheduler scheduler = this.f21899b;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalRangeObserver.setResource(createWorker);
            createWorker.schedulePeriodically(intervalRangeObserver, this.f21902e, this.f21903f, this.f21904g);
            return;
        }
        intervalRangeObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalRangeObserver, this.f21902e, this.f21903f, this.f21904g));
    }
}
