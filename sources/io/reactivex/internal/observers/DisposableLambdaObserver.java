package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super T> f14552b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f14553c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f14554d;

    /* renamed from: e  reason: collision with root package name */
    public Disposable f14555e;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.f14552b = observer;
        this.f14553c = consumer;
        this.f14554d = action;
    }

    public void dispose() {
        Disposable disposable = this.f14555e;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f14555e = disposableHelper;
            try {
                this.f14554d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            disposable.dispose();
        }
    }

    public boolean isDisposed() {
        return this.f14555e.isDisposed();
    }

    public void onComplete() {
        Disposable disposable = this.f14555e;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f14555e = disposableHelper;
            this.f14552b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        Disposable disposable = this.f14555e;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f14555e = disposableHelper;
            this.f14552b.onError(th2);
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onNext(T t11) {
        this.f14552b.onNext(t11);
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.f14553c.accept(disposable);
            if (DisposableHelper.validate(this.f14555e, disposable)) {
                this.f14555e = disposable;
                this.f14552b.onSubscribe(this);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            disposable.dispose();
            this.f14555e = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th2, (Observer<?>) this.f14552b);
        }
    }
}
