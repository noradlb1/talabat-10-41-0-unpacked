package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super T> f19033b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f19034c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f19035d;

    /* renamed from: e  reason: collision with root package name */
    public Disposable f19036e;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.f19033b = observer;
        this.f19034c = consumer;
        this.f19035d = action;
    }

    public void dispose() {
        Disposable disposable = this.f19036e;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f19036e = disposableHelper;
            try {
                this.f19035d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            disposable.dispose();
        }
    }

    public boolean isDisposed() {
        return this.f19036e.isDisposed();
    }

    public void onComplete() {
        Disposable disposable = this.f19036e;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f19036e = disposableHelper;
            this.f19033b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        Disposable disposable = this.f19036e;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f19036e = disposableHelper;
            this.f19033b.onError(th2);
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onNext(T t11) {
        this.f19033b.onNext(t11);
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.f19034c.accept(disposable);
            if (DisposableHelper.validate(this.f19036e, disposable)) {
                this.f19036e = disposable;
                this.f19033b.onSubscribe(this);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            disposable.dispose();
            this.f19036e = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th2, (Observer<?>) this.f19033b);
        }
    }
}
