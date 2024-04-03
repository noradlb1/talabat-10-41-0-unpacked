package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class MaybeTimeInterval<T> extends Maybe<Timed<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f21035b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f21036c;

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f21037d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f21038e;

    public static final class TimeIntervalMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super Timed<T>> f21039b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeUnit f21040c;

        /* renamed from: d  reason: collision with root package name */
        public final Scheduler f21041d;

        /* renamed from: e  reason: collision with root package name */
        public final long f21042e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f21043f;

        public TimeIntervalMaybeObserver(MaybeObserver<? super Timed<T>> maybeObserver, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            long j11;
            this.f21039b = maybeObserver;
            this.f21040c = timeUnit;
            this.f21041d = scheduler;
            if (z11) {
                j11 = scheduler.now(timeUnit);
            } else {
                j11 = 0;
            }
            this.f21042e = j11;
        }

        public void dispose() {
            this.f21043f.dispose();
        }

        public boolean isDisposed() {
            return this.f21043f.isDisposed();
        }

        public void onComplete() {
            this.f21039b.onComplete();
        }

        public void onError(@NonNull Throwable th2) {
            this.f21039b.onError(th2);
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.f21043f, disposable)) {
                this.f21043f = disposable;
                this.f21039b.onSubscribe(this);
            }
        }

        public void onSuccess(@NonNull T t11) {
            this.f21039b.onSuccess(new Timed(t11, this.f21041d.now(this.f21040c) - this.f21042e, this.f21040c));
        }
    }

    public MaybeTimeInterval(MaybeSource<T> maybeSource, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        this.f21035b = maybeSource;
        this.f21036c = timeUnit;
        this.f21037d = scheduler;
        this.f21038e = z11;
    }

    public void subscribeActual(@NonNull MaybeObserver<? super Timed<T>> maybeObserver) {
        this.f21035b.subscribe(new TimeIntervalMaybeObserver(maybeObserver, this.f21036c, this.f21037d, this.f21038e));
    }
}
