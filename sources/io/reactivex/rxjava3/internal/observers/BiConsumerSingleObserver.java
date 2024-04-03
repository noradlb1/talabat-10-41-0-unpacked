package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = 4943102778943297569L;

    /* renamed from: b  reason: collision with root package name */
    public final BiConsumer<? super T, ? super Throwable> f19011b;

    public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.f19011b = biConsumer;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onError(Throwable th2) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.f19011b.accept(null, th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void onSuccess(T t11) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.f19011b.accept(t11, null);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }
}
