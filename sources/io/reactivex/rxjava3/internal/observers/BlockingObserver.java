package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* renamed from: b  reason: collision with root package name */
    public final Queue<Object> f19023b;

    public BlockingObserver(Queue<Object> queue) {
        this.f19023b = queue;
    }

    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.f19023b.offer(TERMINATED);
        }
    }

    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void onComplete() {
        this.f19023b.offer(NotificationLite.complete());
    }

    public void onError(Throwable th2) {
        this.f19023b.offer(NotificationLite.error(th2));
    }

    public void onNext(T t11) {
        this.f19023b.offer(NotificationLite.next(t11));
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }
}
