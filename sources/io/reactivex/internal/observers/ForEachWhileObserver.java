package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;

    /* renamed from: b  reason: collision with root package name */
    public final Predicate<? super T> f14556b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f14557c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f14558d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14559e;

    public ForEachWhileObserver(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.f14556b = predicate;
        this.f14557c = consumer;
        this.f14558d = action;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        if (!this.f14559e) {
            this.f14559e = true;
            try {
                this.f14558d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.f14559e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f14559e = true;
        try {
            this.f14557c.accept(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t11) {
        if (!this.f14559e) {
            try {
                if (!this.f14556b.test(t11)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                dispose();
                onError(th2);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
