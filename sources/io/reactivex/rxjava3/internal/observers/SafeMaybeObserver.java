package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SafeMaybeObserver<T> implements MaybeObserver<T> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeObserver<? super T> f19066b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19067c;

    public SafeMaybeObserver(MaybeObserver<? super T> maybeObserver) {
        this.f19066b = maybeObserver;
    }

    public void onComplete() {
        if (!this.f19067c) {
            try {
                this.f19066b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(@NonNull Throwable th2) {
        if (this.f19067c) {
            RxJavaPlugins.onError(th2);
            return;
        }
        try {
            this.f19066b.onError(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        try {
            this.f19066b.onSubscribe(disposable);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f19067c = true;
            disposable.dispose();
            RxJavaPlugins.onError(th2);
        }
    }

    public void onSuccess(@NonNull T t11) {
        if (!this.f19067c) {
            try {
                this.f19066b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }
}
