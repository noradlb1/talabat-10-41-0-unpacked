package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimer extends Maybe<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final long f21060b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f21061c;

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f21062d;

    public static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super Long> f21063b;

        public TimerDisposable(MaybeObserver<? super Long> maybeObserver) {
            this.f21063b = maybeObserver;
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
            this.f21063b.onSuccess(0L);
        }
    }

    public MaybeTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f21060b = j11;
        this.f21061c = timeUnit;
        this.f21062d = scheduler;
    }

    public void subscribeActual(MaybeObserver<? super Long> maybeObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(maybeObserver);
        maybeObserver.onSubscribe(timerDisposable);
        timerDisposable.a(this.f21062d.scheduleDirect(timerDisposable, this.f21060b, this.f21061c));
    }
}
