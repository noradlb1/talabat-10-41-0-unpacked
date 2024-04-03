package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f19030d;

    public DeferredScalarObserver(Observer<? super R> observer) {
        super(observer);
    }

    public void dispose() {
        super.dispose();
        this.f19030d.dispose();
    }

    public void onComplete() {
        T t11 = this.f19029c;
        if (t11 != null) {
            this.f19029c = null;
            complete(t11);
            return;
        }
        complete();
    }

    public void onError(Throwable th2) {
        this.f19029c = null;
        error(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f19030d, disposable)) {
            this.f19030d = disposable;
            this.f19028b.onSubscribe(this);
        }
    }
}
