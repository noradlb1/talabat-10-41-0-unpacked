package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;

    /* renamed from: b  reason: collision with root package name */
    public final Predicate<? super T> f19037b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f19038c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f19039d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19040e;

    public ForEachWhileObserver(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.f19037b = predicate;
        this.f19038c = consumer;
        this.f19039d = action;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        if (!this.f19040e) {
            this.f19040e = true;
            try {
                this.f19039d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.f19040e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f19040e = true;
        try {
            this.f19038c.accept(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t11) {
        if (!this.f19040e) {
            try {
                if (!this.f19037b.test(t11)) {
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
