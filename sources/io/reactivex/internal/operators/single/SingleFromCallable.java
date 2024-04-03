package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class SingleFromCallable<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends T> f18359b;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.f18359b = callable;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable empty = Disposables.empty();
        singleObserver.onSubscribe(empty);
        if (!empty.isDisposed()) {
            try {
                Object requireNonNull = ObjectHelper.requireNonNull(this.f18359b.call(), "The callable returned a null value");
                if (!empty.isDisposed()) {
                    singleObserver.onSuccess(requireNonNull);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                if (!empty.isDisposed()) {
                    singleObserver.onError(th2);
                } else {
                    RxJavaPlugins.onError(th2);
                }
            }
        }
    }
}
