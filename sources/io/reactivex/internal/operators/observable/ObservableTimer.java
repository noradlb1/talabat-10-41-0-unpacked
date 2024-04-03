package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimer extends Observable<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final Scheduler f17860b;

    /* renamed from: c  reason: collision with root package name */
    public final long f17861c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17862d;

    public static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Long> f17863b;

        public TimerObserver(Observer<? super Long> observer) {
            this.f17863b = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                this.f17863b.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f17863b.onComplete();
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.trySet(this, disposable);
        }
    }

    public ObservableTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f17861c = j11;
        this.f17862d = timeUnit;
        this.f17860b = scheduler;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        timerObserver.setResource(this.f17860b.scheduleDirect(timerObserver, this.f17861c, this.f17862d));
    }
}
