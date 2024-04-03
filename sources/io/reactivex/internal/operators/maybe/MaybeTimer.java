package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimer extends Maybe<Long> {

    /* renamed from: b  reason: collision with root package name */
    public final long f16547b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f16548c;

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f16549d;

    public static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super Long> f16550b;

        public TimerDisposable(MaybeObserver<? super Long> maybeObserver) {
            this.f16550b = maybeObserver;
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
            this.f16550b.onSuccess(0L);
        }
    }

    public MaybeTimer(long j11, TimeUnit timeUnit, Scheduler scheduler) {
        this.f16547b = j11;
        this.f16548c = timeUnit;
        this.f16549d = scheduler;
    }

    public void subscribeActual(MaybeObserver<? super Long> maybeObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(maybeObserver);
        maybeObserver.onSubscribe(timerDisposable);
        timerDisposable.a(this.f16549d.scheduleDirect(timerDisposable, this.f16547b, this.f16548c));
    }
}
