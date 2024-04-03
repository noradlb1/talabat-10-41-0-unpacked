package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7012088219455310787L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f19026b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f19027c;

    public ConsumerSingleObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        this.f19026b = consumer;
        this.f19027c = consumer2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.f19027c != Functions.ON_ERROR_MISSING;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f19027c.accept(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void onSuccess(T t11) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f19026b.accept(t11);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }
}
