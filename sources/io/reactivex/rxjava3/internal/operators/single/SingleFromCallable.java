package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class SingleFromCallable<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends T> f22916b;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.f22916b = callable;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable b11 = a.b();
        singleObserver.onSubscribe(b11);
        if (!b11.isDisposed()) {
            try {
                Object call = this.f22916b.call();
                Objects.requireNonNull(call, "The callable returned a null value");
                if (!b11.isDisposed()) {
                    singleObserver.onSuccess(call);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                if (!b11.isDisposed()) {
                    singleObserver.onError(th2);
                } else {
                    RxJavaPlugins.onError(th2);
                }
            }
        }
    }
}
