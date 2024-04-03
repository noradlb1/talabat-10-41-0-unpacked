package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f14551d;

    public DeferredScalarObserver(Observer<? super R> observer) {
        super(observer);
    }

    public void dispose() {
        super.dispose();
        this.f14551d.dispose();
    }

    public void onComplete() {
        T t11 = this.f14550c;
        if (t11 != null) {
            this.f14550c = null;
            complete(t11);
            return;
        }
        complete();
    }

    public void onError(Throwable th2) {
        this.f14550c = null;
        error(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f14551d, disposable)) {
            this.f14551d = disposable;
            this.f14549b.onSubscribe(this);
        }
    }
}
