package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SafeObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super T> f23215b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f23216c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23217d;

    public SafeObserver(@NonNull Observer<? super T> observer) {
        this.f23215b = observer;
    }

    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f23215b.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f23215b.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th3));
        }
    }

    public void b() {
        this.f23217d = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f23215b.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f23215b.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th3));
        }
    }

    public void dispose() {
        this.f23216c.dispose();
    }

    public boolean isDisposed() {
        return this.f23216c.isDisposed();
    }

    public void onComplete() {
        if (!this.f23217d) {
            this.f23217d = true;
            if (this.f23216c == null) {
                a();
                return;
            }
            try {
                this.f23215b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(@NonNull Throwable th2) {
        if (this.f23217d) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23217d = true;
        if (this.f23216c == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f23215b.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f23215b.onError(new CompositeException(th2, nullPointerException));
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    RxJavaPlugins.onError(new CompositeException(th2, nullPointerException, th3));
                }
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(new CompositeException(th2, nullPointerException, th4));
            }
        } else {
            if (th2 == null) {
                th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            try {
                this.f23215b.onError(th2);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                RxJavaPlugins.onError(new CompositeException(th2, th5));
            }
        }
    }

    public void onNext(@NonNull T t11) {
        if (!this.f23217d) {
            if (this.f23216c == null) {
                b();
            } else if (t11 == null) {
                NullPointerException createNullPointerException = ExceptionHelper.createNullPointerException("onNext called with a null value.");
                try {
                    this.f23216c.dispose();
                    onError(createNullPointerException);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(new CompositeException(createNullPointerException, th2));
                }
            } else {
                try {
                    this.f23215b.onNext(t11);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    onError(new CompositeException(th, th3));
                }
            }
        }
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.f23216c, disposable)) {
            this.f23216c = disposable;
            try {
                this.f23215b.onSubscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        }
    }
}
