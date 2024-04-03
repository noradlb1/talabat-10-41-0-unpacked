package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -4361286194466301354L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super Throwable> f19024b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f19025c;

    public CallbackCompletableObserver(Consumer<? super Throwable> consumer, Action action) {
        this.f19024b = consumer;
        this.f19025c = action;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.f19024b != Functions.ON_ERROR_MISSING;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        try {
            this.f19025c.run();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th2) {
        try {
            this.f19024b.accept(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(th3);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
