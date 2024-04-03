package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.DisposableContainer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class DisposableAutoReleaseMultiObserver<T> extends AbstractDisposableAutoRelease implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver {
    private static final long serialVersionUID = 8924480688481408726L;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super T> f19031e;

    public DisposableAutoReleaseMultiObserver(DisposableContainer disposableContainer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        super(disposableContainer, consumer2, action);
        this.f19031e = consumer;
    }

    public void onSuccess(T t11) {
        Object obj = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (obj != disposableHelper) {
            lazySet(disposableHelper);
            try {
                this.f19031e.accept(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
        a();
    }
}
