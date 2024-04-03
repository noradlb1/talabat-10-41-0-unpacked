package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18402b;

    /* renamed from: c  reason: collision with root package name */
    public final long f18403c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f18404d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f18405e;

    /* renamed from: f  reason: collision with root package name */
    public final SingleSource<? extends T> f18406f;

    public static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
        private static final long serialVersionUID = 37497744973048446L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18407b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f18408c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final TimeoutFallbackObserver<T> f18409d;

        /* renamed from: e  reason: collision with root package name */
        public SingleSource<? extends T> f18410e;

        /* renamed from: f  reason: collision with root package name */
        public final long f18411f;

        /* renamed from: g  reason: collision with root package name */
        public final TimeUnit f18412g;

        public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = 2071387740092105509L;

            /* renamed from: b  reason: collision with root package name */
            public final SingleObserver<? super T> f18413b;

            public TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
                this.f18413b = singleObserver;
            }

            public void onError(Throwable th2) {
                this.f18413b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f18413b.onSuccess(t11);
            }
        }

        public TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource, long j11, TimeUnit timeUnit) {
            this.f18407b = singleObserver;
            this.f18410e = singleSource;
            this.f18411f = j11;
            this.f18412g = timeUnit;
            if (singleSource != null) {
                this.f18409d = new TimeoutFallbackObserver<>(singleObserver);
            } else {
                this.f18409d = null;
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.f18408c);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.f18409d;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.dispose(timeoutFallbackObserver);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || !compareAndSet(disposable, disposableHelper)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            DisposableHelper.dispose(this.f18408c);
            this.f18407b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                DisposableHelper.dispose(this.f18408c);
                this.f18407b.onSuccess(t11);
            }
        }

        public void run() {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                if (disposable != null) {
                    disposable.dispose();
                }
                SingleSource<? extends T> singleSource = this.f18410e;
                if (singleSource == null) {
                    this.f18407b.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f18411f, this.f18412g)));
                    return;
                }
                this.f18410e = null;
                singleSource.subscribe(this.f18409d);
            }
        }
    }

    public SingleTimeout(SingleSource<T> singleSource, long j11, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource2) {
        this.f18402b = singleSource;
        this.f18403c = j11;
        this.f18404d = timeUnit;
        this.f18405e = scheduler;
        this.f18406f = singleSource2;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.f18406f, this.f18403c, this.f18404d);
        singleObserver.onSubscribe(timeoutMainObserver);
        DisposableHelper.replace(timeoutMainObserver.f18408c, this.f18405e.scheduleDirect(timeoutMainObserver, this.f18403c, this.f18404d));
        this.f18402b.subscribe(timeoutMainObserver);
    }
}
