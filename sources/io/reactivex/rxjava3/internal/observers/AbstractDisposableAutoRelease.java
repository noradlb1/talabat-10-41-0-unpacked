package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

abstract class AbstractDisposableAutoRelease extends AtomicReference<Disposable> implements Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = 8924480688481408726L;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<DisposableContainer> f19003b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f19004c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f19005d;

    public AbstractDisposableAutoRelease(DisposableContainer disposableContainer, Consumer<? super Throwable> consumer, Action action) {
        this.f19004c = consumer;
        this.f19005d = action;
        this.f19003b = new AtomicReference<>(disposableContainer);
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        DisposableContainer andSet = this.f19003b.getAndSet((Object) null);
        if (andSet != null) {
            andSet.delete(this);
        }
    }

    public final void dispose() {
        DisposableHelper.dispose(this);
        a();
    }

    public final boolean hasCustomOnError() {
        return this.f19004c != Functions.ON_ERROR_MISSING;
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public final void onComplete() {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            try {
                this.f19005d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
        a();
    }

    public final void onError(Throwable th2) {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            try {
                this.f19004c.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th2, th3));
            }
        } else {
            RxJavaPlugins.onError(th2);
        }
        a();
    }

    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
