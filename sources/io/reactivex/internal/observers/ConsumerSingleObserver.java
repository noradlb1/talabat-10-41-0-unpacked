package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7012088219455310787L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f14547b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f14548c;

    public ConsumerSingleObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        this.f14547b = consumer;
        this.f14548c = consumer2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.f14548c != Functions.ON_ERROR_MISSING;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f14548c.accept(th2);
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
            this.f14547b.accept(t11);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }
}
