package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTimer extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final long f14743b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f14744c;

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f14745d;

    public static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14746b;

        public TimerDisposable(CompletableObserver completableObserver) {
            this.f14746b = completableObserver;
        }

        public void a(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void run() {
            this.f14746b.onComplete();
        }
    }

    public CompletableTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f14743b = j11;
        this.f14744c = timeUnit;
        this.f14745d = scheduler;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        timerDisposable.a(this.f14745d.scheduleDirect(timerDisposable, this.f14743b, this.f14744c));
    }
}
