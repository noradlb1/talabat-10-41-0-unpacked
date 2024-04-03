package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class SingleFromSupplier<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<? extends T> f22923b;

    public SingleFromSupplier(Supplier<? extends T> supplier) {
        this.f22923b = supplier;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable b11 = a.b();
        singleObserver.onSubscribe(b11);
        if (!b11.isDisposed()) {
            try {
                Object obj = this.f22923b.get();
                Objects.requireNonNull(obj, "The supplier returned a null value");
                if (!b11.isDisposed()) {
                    singleObserver.onSuccess(obj);
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
