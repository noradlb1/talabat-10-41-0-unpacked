package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SafeCompletableObserver implements CompletableObserver {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableObserver f19064b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19065c;

    public SafeCompletableObserver(CompletableObserver completableObserver) {
        this.f19064b = completableObserver;
    }

    public void onComplete() {
        if (!this.f19065c) {
            try {
                this.f19064b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(@NonNull Throwable th2) {
        if (this.f19065c) {
            RxJavaPlugins.onError(th2);
            return;
        }
        try {
            this.f19064b.onError(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        try {
            this.f19064b.onSubscribe(disposable);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            this.f19065c = true;
            disposable.dispose();
            RxJavaPlugins.onError(th2);
        }
    }
}
