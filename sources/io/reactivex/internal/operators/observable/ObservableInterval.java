package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableInterval extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final Scheduler f17346b;

    /* renamed from: c  reason: collision with root package name */
    public final long f17347c;

    /* renamed from: d  reason: collision with root package name */
    public final long f17348d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f17349e;

    public static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 346773832286157679L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f17350b;

        /* renamed from: c  reason: collision with root package name */
        public long f17351c;

        public IntervalObserver(Observer<? super Long> observer) {
            this.f17350b = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                Observer<? super Long> observer = this.f17350b;
                long j11 = this.f17351c;
                this.f17351c = 1 + j11;
                observer.onNext(Long.valueOf(j11));
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableInterval(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        this.f17347c = j11;
        this.f17348d = j12;
        this.f17349e = timeUnit;
        this.f17346b = scheduler;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        Scheduler scheduler = this.f17346b;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalObserver.setResource(createWorker);
            createWorker.schedulePeriodically(intervalObserver, this.f17347c, this.f17348d, this.f17349e);
            return;
        }
        intervalObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalObserver, this.f17347c, this.f17348d, this.f17349e));
    }
}
