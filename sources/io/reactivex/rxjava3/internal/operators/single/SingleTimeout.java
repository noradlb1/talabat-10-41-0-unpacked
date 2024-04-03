package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleTimeout<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22971b;

    /* renamed from: c  reason: collision with root package name */
    public final long f22972c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f22973d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f22974e;

    /* renamed from: f  reason: collision with root package name */
    public final SingleSource<? extends T> f22975f;

    public static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
        private static final long serialVersionUID = 37497744973048446L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22976b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicReference<Disposable> f22977c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        public final TimeoutFallbackObserver<T> f22978d;

        /* renamed from: e  reason: collision with root package name */
        public SingleSource<? extends T> f22979e;

        /* renamed from: f  reason: collision with root package name */
        public final long f22980f;

        /* renamed from: g  reason: collision with root package name */
        public final TimeUnit f22981g;

        public static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = 2071387740092105509L;

            /* renamed from: b  reason: collision with root package name */
            public final SingleObserver<? super T> f22982b;

            public TimeoutFallbackObserver(SingleObserver<? super T> singleObserver) {
                this.f22982b = singleObserver;
            }

            public void onError(Throwable th2) {
                this.f22982b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(T t11) {
                this.f22982b.onSuccess(t11);
            }
        }

        public TimeoutMainObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource, long j11, TimeUnit timeUnit) {
            this.f22976b = singleObserver;
            this.f22979e = singleSource;
            this.f22980f = j11;
            this.f22981g = timeUnit;
            if (singleSource != null) {
                this.f22978d = new TimeoutFallbackObserver<>(singleObserver);
            } else {
                this.f22978d = null;
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.f22977c);
            TimeoutFallbackObserver<T> timeoutFallbackObserver = this.f22978d;
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
            DisposableHelper.dispose(this.f22977c);
            this.f22976b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                DisposableHelper.dispose(this.f22977c);
                this.f22976b.onSuccess(t11);
            }
        }

        public void run() {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper && compareAndSet(disposable, disposableHelper)) {
                if (disposable != null) {
                    disposable.dispose();
                }
                SingleSource<? extends T> singleSource = this.f22979e;
                if (singleSource == null) {
                    this.f22976b.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f22980f, this.f22981g)));
                    return;
                }
                this.f22979e = null;
                singleSource.subscribe(this.f22978d);
            }
        }
    }

    public SingleTimeout(SingleSource<T> singleSource, long j11, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource2) {
        this.f22971b = singleSource;
        this.f22972c = j11;
        this.f22973d = timeUnit;
        this.f22974e = scheduler;
        this.f22975f = singleSource2;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.f22975f, this.f22972c, this.f22973d);
        singleObserver.onSubscribe(timeoutMainObserver);
        DisposableHelper.replace(timeoutMainObserver.f22977c, this.f22974e.scheduleDirect(timeoutMainObserver, this.f22972c, this.f22973d));
        this.f22971b.subscribe(timeoutMainObserver);
    }
}
