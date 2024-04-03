package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCallbackObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -6076952298809384986L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f16276b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f16277c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f16278d;

    public MaybeCallbackObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        this.f16276b = consumer;
        this.f16277c = consumer2;
        this.f16278d = action;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.f16277c != Functions.ON_ERROR_MISSING;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f16278d.run();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }

    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f16277c.accept(th2);
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
            this.f16276b.accept(t11);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }
}
