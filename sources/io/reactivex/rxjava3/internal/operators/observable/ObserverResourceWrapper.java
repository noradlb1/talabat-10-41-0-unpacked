package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super T> f22576b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Disposable> f22577c = new AtomicReference<>();

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.f22576b = observer;
    }

    public void dispose() {
        DisposableHelper.dispose(this.f22577c);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.f22577c.get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        dispose();
        this.f22576b.onComplete();
    }

    public void onError(Throwable th2) {
        dispose();
        this.f22576b.onError(th2);
    }

    public void onNext(T t11) {
        this.f22576b.onNext(t11);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.f22577c, disposable)) {
            this.f22576b.onSubscribe(this);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
