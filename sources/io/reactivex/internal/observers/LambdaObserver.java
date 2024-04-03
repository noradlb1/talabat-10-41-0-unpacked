package io.reactivex.internal.observers;

import io.reactivex.Observer;
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

public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f14571b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f14572c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f14573d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Disposable> f14574e;

    public LambdaObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        this.f14571b = consumer;
        this.f14572c = consumer2;
        this.f14573d = action;
        this.f14574e = consumer3;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.f14572c != Functions.ON_ERROR_MISSING;
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.f14573d.run();
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
                this.f14572c.accept(th2);
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
                this.f14571b.accept(t11);
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
                this.f14574e.accept(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                disposable.dispose();
                onError(th2);
            }
        }
    }
}
