package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimer extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final Scheduler f22402b;

    /* renamed from: c  reason: collision with root package name */
    public final long f22403c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f22404d;

    public static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f22405b;

        public TimerObserver(Observer<? super Long> observer) {
            this.f22405b = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                this.f22405b.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f22405b.onComplete();
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.trySet(this, disposable);
        }
    }

    public ObservableTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f22403c = j11;
        this.f22404d = timeUnit;
        this.f22402b = scheduler;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        timerObserver.setResource(this.f22402b.scheduleDirect(timerObserver, this.f22403c, this.f22404d));
    }
}
