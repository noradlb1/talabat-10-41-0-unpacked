package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class DisposableAutoReleaseObserver<T> extends AbstractDisposableAutoRelease implements Observer<T> {
    private static final long serialVersionUID = 8924480688481408726L;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super T> f19032e;

    public DisposableAutoReleaseObserver(DisposableContainer disposableContainer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        super(disposableContainer, consumer2, action);
        this.f19032e = consumer;
    }

    public void onNext(T t11) {
        if (get() != DisposableHelper.DISPOSED) {
            try {
                this.f19032e.accept(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                ((Disposable) get()).dispose();
                onError(th2);
            }
        }
    }
}
