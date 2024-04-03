package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SafeSingleObserver<T> implements SingleObserver<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleObserver<? super T> f19068b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19069c;

    public SafeSingleObserver(SingleObserver<? super T> singleObserver) {
        this.f19068b = singleObserver;
    }

    public void onError(@NonNull Throwable th2) {
        if (this.f19069c) {
            RxJavaPlugins.onError(th2);
            return;
        }
        try {
            this.f19068b.onError(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        try {
            this.f19068b.onSubscribe(disposable);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f19069c = true;
            disposable.dispose();
            RxJavaPlugins.onError(th2);
        }
    }

    public void onSuccess(@NonNull T t11) {
        if (!this.f19069c) {
            try {
                this.f19068b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }
}
