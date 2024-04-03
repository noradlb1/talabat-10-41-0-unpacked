package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeDelay<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f20813c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f20814d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f20815e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f20816f;

    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20817b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20818c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f20819d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f20820e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f20821f;

        /* renamed from: g  reason: collision with root package name */
        public T f20822g;

        /* renamed from: h  reason: collision with root package name */
        public Throwable f20823h;

        public DelayMaybeObserver(MaybeObserver<? super T> maybeObserver, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            this.f20817b = maybeObserver;
            this.f20818c = j11;
            this.f20819d = timeUnit;
            this.f20820e = scheduler;
            this.f20821f = z11;
        }

        public void a(long j11) {
            DisposableHelper.replace(this, this.f20820e.scheduleDirect(this, j11, this.f20819d));
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            a(this.f20818c);
        }

        public void onError(Throwable th2) {
            long j11;
            this.f20823h = th2;
            if (this.f20821f) {
                j11 = this.f20818c;
            } else {
                j11 = 0;
            }
            a(j11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f20817b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20822g = t11;
            a(this.f20818c);
        }

        public void run() {
            Throwable th2 = this.f20823h;
            if (th2 != null) {
                this.f20817b.onError(th2);
                return;
            }
            T t11 = this.f20822g;
            if (t11 != null) {
                this.f20817b.onSuccess(t11);
            } else {
                this.f20817b.onComplete();
            }
        }
    }

    public MaybeDelay(MaybeSource<T> maybeSource, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(maybeSource);
        this.f20813c = j11;
        this.f20814d = timeUnit;
        this.f20815e = scheduler;
        this.f20816f = z11;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new DelayMaybeObserver(maybeObserver, this.f20813c, this.f20814d, this.f20815e, this.f20816f));
    }
}
