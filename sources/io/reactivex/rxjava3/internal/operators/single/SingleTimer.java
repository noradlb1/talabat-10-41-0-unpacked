package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimer extends Single<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final long f22983b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f22984c;

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f22985d;

    public static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Long> f22986b;

        public TimerDisposable(SingleObserver<? super Long> singleObserver) {
            this.f22986b = singleObserver;
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
            this.f22986b.onSuccess(0L);
        }
    }

    public SingleTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f22983b = j11;
        this.f22984c = timeUnit;
        this.f22985d = scheduler;
    }

    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.onSubscribe(timerDisposable);
        timerDisposable.a(this.f22985d.scheduleDirect(timerDisposable, this.f22983b, this.f22984c));
    }
}
