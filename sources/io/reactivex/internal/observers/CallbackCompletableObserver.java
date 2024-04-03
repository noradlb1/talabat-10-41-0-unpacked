package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Consumer<Throwable>, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -4361286194466301354L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super Throwable> f14545b;

    /* renamed from: c  reason: collision with root package name */
    public final Action f14546c;

    public CallbackCompletableObserver(Action action) {
        this.f14545b = this;
        this.f14546c = action;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.f14545b != this;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        try {
            this.f14546c.run();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th2) {
        try {
            this.f14545b.accept(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(th3);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void accept(Throwable th2) {
        RxJavaPlugins.onError(new OnErrorNotImplementedException(th2));
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> consumer, Action action) {
        this.f14545b = consumer;
        this.f14546c = action;
    }
}
