package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimer extends Single<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final long f18414b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f18415c;

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f18416d;

    public static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Long> f18417b;

        public TimerDisposable(SingleObserver<? super Long> singleObserver) {
            this.f18417b = singleObserver;
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
            this.f18417b.onSuccess(0L);
        }
    }

    public SingleTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f18414b = j11;
        this.f18415c = timeUnit;
        this.f18416d = scheduler;
    }

    public void subscribeActual(SingleObserver<? super Long> singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.onSubscribe(timerDisposable);
        timerDisposable.a(this.f18416d.scheduleDirect(timerDisposable, this.f18414b, this.f18415c));
    }
}
