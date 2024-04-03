package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super T> f18045b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<Disposable> f18046c = new AtomicReference<>();

    public ObserverResourceWrapper(Observer<? super T> observer) {
        this.f18045b = observer;
    }

    public void dispose() {
        DisposableHelper.dispose(this.f18046c);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.f18046c.get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        dispose();
        this.f18045b.onComplete();
    }

    public void onError(Throwable th2) {
        dispose();
        this.f18045b.onError(th2);
    }

    public void onNext(T t11) {
        this.f18045b.onNext(t11);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this.f18046c, disposable)) {
            this.f18045b.onSubscribe(this);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
