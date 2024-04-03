package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5417183359794346637L;

    /* renamed from: b  reason: collision with root package name */
    public final InnerQueuedObserverSupport<T> f19047b;

    /* renamed from: c  reason: collision with root package name */
    public final int f19048c;

    /* renamed from: d  reason: collision with root package name */
    public SimpleQueue<T> f19049d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f19050e;

    /* renamed from: f  reason: collision with root package name */
    public int f19051f;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i11) {
        this.f19047b = innerQueuedObserverSupport;
        this.f19048c = i11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public boolean isDone() {
        return this.f19050e;
    }

    public void onComplete() {
        this.f19047b.innerComplete(this);
    }

    public void onError(Throwable th2) {
        this.f19047b.innerError(this, th2);
    }

    public void onNext(T t11) {
        if (this.f19051f == 0) {
            this.f19047b.innerNext(this, t11);
        } else {
            this.f19047b.drain();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.f19051f = requestFusion;
                    this.f19049d = queueDisposable;
                    this.f19050e = true;
                    this.f19047b.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.f19051f = requestFusion;
                    this.f19049d = queueDisposable;
                    return;
                }
            }
            this.f19049d = QueueDrainHelper.createQueue(-this.f19048c);
        }
    }

    public SimpleQueue<T> queue() {
        return this.f19049d;
    }

    public void setDone() {
        this.f19050e = true;
    }
}
