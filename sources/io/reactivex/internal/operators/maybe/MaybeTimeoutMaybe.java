package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimeoutMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final MaybeSource<U> f16531c;

    /* renamed from: d  reason: collision with root package name */
    public final MaybeSource<? extends T> f16532d;

    public static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16533b;

        public TimeoutFallbackMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16533b = maybeObserver;
        }

        public void onComplete() {
            this.f16533b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16533b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f16533b.onSuccess(t11);
        }
    }

    public static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -5955289211445418871L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16534b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeoutOtherMaybeObserver<T, U> f16535c = new TimeoutOtherMaybeObserver<>(this);

        /* renamed from: d  reason: collision with root package name */
        public final MaybeSource<? extends T> f16536d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeoutFallbackMaybeObserver<T> f16537e;

        public TimeoutMainMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver;
            this.f16534b = maybeObserver;
            this.f16536d = maybeSource;
            if (maybeSource != null) {
                timeoutFallbackMaybeObserver = new TimeoutFallbackMaybeObserver<>(maybeObserver);
            } else {
                timeoutFallbackMaybeObserver = null;
            }
            this.f16537e = timeoutFallbackMaybeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.f16535c);
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver = this.f16537e;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.dispose(timeoutFallbackMaybeObserver);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f16535c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16534b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f16535c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16534b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            DisposableHelper.dispose(this.f16535c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16534b.onSuccess(t11);
            }
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this)) {
                MaybeSource<? extends T> maybeSource = this.f16536d;
                if (maybeSource == null) {
                    this.f16534b.onError(new TimeoutException());
                } else {
                    maybeSource.subscribe(this.f16537e);
                }
            }
        }

        public void otherError(Throwable th2) {
            if (DisposableHelper.dispose(this)) {
                this.f16534b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<Object> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutMainMaybeObserver<T, U> f16538b;

        public TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.f16538b = timeoutMainMaybeObserver;
        }

        public void onComplete() {
            this.f16538b.otherComplete();
        }

        public void onError(Throwable th2) {
            this.f16538b.otherError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(Object obj) {
            this.f16538b.otherComplete();
        }
    }

    public MaybeTimeoutMaybe(MaybeSource<T> maybeSource, MaybeSource<U> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        super(maybeSource);
        this.f16531c = maybeSource2;
        this.f16532d = maybeSource3;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.f16532d);
        maybeObserver.onSubscribe(timeoutMainMaybeObserver);
        this.f16531c.subscribe(timeoutMainMaybeObserver.f16535c);
        this.f16264b.subscribe(timeoutMainMaybeObserver);
    }
}
