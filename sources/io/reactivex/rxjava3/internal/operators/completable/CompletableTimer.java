package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTimer extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final long f19235b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f19236c;

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f19237d;

    public static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19238b;

        public TimerDisposable(CompletableObserver completableObserver) {
            this.f19238b = completableObserver;
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
            this.f19238b.onComplete();
        }
    }

    public CompletableTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f19235b = j11;
        this.f19236c = timeUnit;
        this.f19237d = scheduler;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.onSubscribe(timerDisposable);
        timerDisposable.a(this.f19237d.scheduleDirect(timerDisposable, this.f19235b, this.f19236c));
    }
}
