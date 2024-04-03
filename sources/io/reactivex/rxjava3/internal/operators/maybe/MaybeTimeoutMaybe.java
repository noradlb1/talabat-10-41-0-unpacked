package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimeoutMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<U> f21044c;

    /* renamed from: d  reason: collision with root package name */
    public final MaybeSource<? extends T> f21045d;

    public static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21046b;

        public TimeoutFallbackMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f21046b = maybeObserver;
        }

        public void onComplete() {
            this.f21046b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21046b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f21046b.onSuccess(t11);
        }
    }

    public static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -5955289211445418871L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21047b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeoutOtherMaybeObserver<T, U> f21048c = new TimeoutOtherMaybeObserver<>(this);

        /* renamed from: d  reason: collision with root package name */
        public final MaybeSource<? extends T> f21049d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeoutFallbackMaybeObserver<T> f21050e;

        public TimeoutMainMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver;
            this.f21047b = maybeObserver;
            this.f21049d = maybeSource;
            if (maybeSource != null) {
                timeoutFallbackMaybeObserver = new TimeoutFallbackMaybeObserver<>(maybeObserver);
            } else {
                timeoutFallbackMaybeObserver = null;
            }
            this.f21050e = timeoutFallbackMaybeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.f21048c);
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver = this.f21050e;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.dispose(timeoutFallbackMaybeObserver);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f21048c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f21047b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f21048c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f21047b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            DisposableHelper.dispose(this.f21048c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f21047b.onSuccess(t11);
            }
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this)) {
                MaybeSource<? extends T> maybeSource = this.f21049d;
                if (maybeSource == null) {
                    this.f21047b.onError(new TimeoutException());
                } else {
                    maybeSource.subscribe(this.f21050e);
                }
            }
        }

        public void otherError(Throwable th2) {
            if (DisposableHelper.dispose(this)) {
                this.f21047b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<Object> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutMainMaybeObserver<T, U> f21051b;

        public TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.f21051b = timeoutMainMaybeObserver;
        }

        public void onComplete() {
            this.f21051b.otherComplete();
        }

        public void onError(Throwable th2) {
            this.f21051b.otherError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(Object obj) {
            this.f21051b.otherComplete();
        }
    }

    public MaybeTimeoutMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        super(maybeSource);
        this.f21044c = maybeSource2;
        this.f21045d = maybeSource3;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.f21045d);
        maybeObserver.onSubscribe(timeoutMainMaybeObserver);
        this.f21044c.subscribe(timeoutMainMaybeObserver.f21048c);
        this.f20763b.subscribe(timeoutMainMaybeObserver);
    }
}
