package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;

public final class SingleTimeInterval<T> extends Single<Timed<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22962b;

    /* renamed from: c  reason: collision with root package name */
    public final TimeUnit f22963c;

    /* renamed from: d  reason: collision with root package name */
    public final Scheduler f22964d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f22965e;

    public static final class TimeIntervalSingleObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Timed<T>> f22966b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeUnit f22967c;

        /* renamed from: d  reason: collision with root package name */
        public final Scheduler f22968d;

        /* renamed from: e  reason: collision with root package name */
        public final long f22969e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f22970f;

        public TimeIntervalSingleObserver(SingleObserver<? super Timed<T>> singleObserver, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
            long j11;
            this.f22966b = singleObserver;
            this.f22967c = timeUnit;
            this.f22968d = scheduler;
            if (z11) {
                j11 = scheduler.now(timeUnit);
            } else {
                j11 = 0;
            }
            this.f22969e = j11;
        }

        public void dispose() {
            this.f22970f.dispose();
        }

        public boolean isDisposed() {
            return this.f22970f.isDisposed();
        }

        public void onError(@NonNull Throwable th2) {
            this.f22966b.onError(th2);
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            if (DisposableHelper.validate(this.f22970f, disposable)) {
                this.f22970f = disposable;
                this.f22966b.onSubscribe(this);
            }
        }

        public void onSuccess(@NonNull T t11) {
            this.f22966b.onSuccess(new Timed(t11, this.f22968d.now(this.f22967c) - this.f22969e, this.f22967c));
        }
    }

    public SingleTimeInterval(SingleSource<T> singleSource, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        this.f22962b = singleSource;
        this.f22963c = timeUnit;
        this.f22964d = scheduler;
        this.f22965e = z11;
    }

    public void subscribeActual(@NonNull SingleObserver<? super Timed<T>> singleObserver) {
        this.f22962b.subscribe(new TimeIntervalSingleObserver(singleObserver, this.f22963c, this.f22964d, this.f22965e));
    }
}
