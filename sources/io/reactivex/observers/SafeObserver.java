package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SafeObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super T> f18655b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f18656c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f18657d;

    public SafeObserver(@NonNull Observer<? super T> observer) {
        this.f18655b = observer;
    }

    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f18655b.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f18655b.onError(nullPointerException);
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
        this.f18657d = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f18655b.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f18655b.onError(nullPointerException);
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
        this.f18656c.dispose();
    }

    public boolean isDisposed() {
        return this.f18656c.isDisposed();
    }

    public void onComplete() {
        if (!this.f18657d) {
            this.f18657d = true;
            if (this.f18656c == null) {
                a();
                return;
            }
            try {
                this.f18655b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(@NonNull Throwable th2) {
        if (this.f18657d) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f18657d = true;
        if (this.f18656c == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f18655b.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f18655b.onError(new CompositeException(th2, nullPointerException));
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
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f18655b.onError(th2);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                RxJavaPlugins.onError(new CompositeException(th2, th5));
            }
        }
    }

    public void onNext(@NonNull T t11) {
        if (!this.f18657d) {
            if (this.f18656c == null) {
                b();
            } else if (t11 == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f18656c.dispose();
                    onError(nullPointerException);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(new CompositeException(nullPointerException, th2));
                }
            } else {
                try {
                    this.f18655b.onNext(t11);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    onError(new CompositeException(th, th3));
                }
            }
        }
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        if (DisposableHelper.validate(this.f18656c, disposable)) {
            this.f18656c = disposable;
            try {
                this.f18655b.onSubscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        }
    }
}
