package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
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

public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f19052b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f19053c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f19054d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Disposable> f19055e;

    public LambdaObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        this.f19052b = consumer;
        this.f19053c = consumer2;
        this.f19054d = action;
        this.f19055e = consumer3;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.f19053c != Functions.ON_ERROR_MISSING;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.f19054d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.f19053c.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th2, th3));
            }
        } else {
            RxJavaPlugins.onError(th2);
        }
    }

    public void onNext(T t11) {
        if (!isDisposed()) {
            try {
                this.f19052b.accept(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                ((Disposable) get()).dispose();
                onError(th2);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            try {
                this.f19055e.accept(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                disposable.dispose();
                onError(th2);
            }
        }
    }
}
