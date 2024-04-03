package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCallbackObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -6076952298809384986L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f20775b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f20776c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f20777d;

    public MaybeCallbackObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        this.f20775b = consumer;
        this.f20776c = consumer2;
        this.f20777d = action;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.f20776c != Functions.ON_ERROR_MISSING;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f20777d.run();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }

    public void onError(Throwable th2) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f20776c.accept(th2);
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
            this.f20775b.accept(t11);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }
}
