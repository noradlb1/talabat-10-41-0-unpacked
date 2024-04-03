package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableInterval extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final Scheduler f21893b;

    /* renamed from: c  reason: collision with root package name */
    public final long f21894c;

    /* renamed from: d  reason: collision with root package name */
    public final long f21895d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f21896e;

    public static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 346773832286157679L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f21897b;

        /* renamed from: c  reason: collision with root package name */
        public long f21898c;

        public IntervalObserver(Observer<? super Long> observer) {
            this.f21897b = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                Observer<? super Long> observer = this.f21897b;
                long j11 = this.f21898c;
                this.f21898c = 1 + j11;
                observer.onNext(Long.valueOf(j11));
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableInterval(long j11, long j12, TimeUnit timeUnit, Scheduler scheduler) {
        this.f21894c = j11;
        this.f21895d = j12;
        this.f21896e = timeUnit;
        this.f21893b = scheduler;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        Scheduler scheduler = this.f21893b;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            intervalObserver.setResource(createWorker);
            createWorker.schedulePeriodically(intervalObserver, this.f21894c, this.f21895d, this.f21896e);
            return;
        }
        intervalObserver.setResource(scheduler.schedulePeriodicallyDirect(intervalObserver, this.f21894c, this.f21895d, this.f21896e));
    }
}
