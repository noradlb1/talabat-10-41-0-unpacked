package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelay<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f16314c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f16315d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f16316e;

    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16317b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16318c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f16319d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f16320e;

        /* renamed from: f  reason: collision with root package name */
        public T f16321f;

        /* renamed from: g  reason: collision with root package name */
        public Throwable f16322g;

        public DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f16317b = maybeObserver;
            this.f16318c = j11;
            this.f16319d = timeUnit;
            this.f16320e = scheduler;
        }

        public void a() {
            DisposableHelper.replace(this, this.f16320e.scheduleDirect(this, this.f16318c, this.f16319d));
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th2) {
            this.f16322g = th2;
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f16317b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16321f = t11;
            a();
        }

        public void run() {
            Throwable th2 = this.f16322g;
            if (th2 != null) {
                this.f16317b.onError(th2);
                return;
            }
            T t11 = this.f16321f;
            if (t11 != null) {
                this.f16317b.onSuccess(t11);
            } else {
                this.f16317b.onComplete();
            }
        }
    }

    public MaybeDelay(MaybeSource<T> maybeSource, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(maybeSource);
        this.f16314c = j11;
        this.f16315d = timeUnit;
        this.f16316e = scheduler;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new DelayMaybeObserver(maybeObserver, this.f16314c, this.f16315d, this.f16316e));
    }
}
