package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5417183359794346637L;

    /* renamed from: b  reason: collision with root package name */
    public final InnerQueuedObserverSupport<T> f14566b;

    /* renamed from: c  reason: collision with root package name */
    public final int f14567c;

    /* renamed from: d  reason: collision with root package name */
    public SimpleQueue<T> f14568d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f14569e;

    /* renamed from: f  reason: collision with root package name */
    public int f14570f;

    public InnerQueuedObserver(InnerQueuedObserverSupport<T> innerQueuedObserverSupport, int i11) {
        this.f14566b = innerQueuedObserverSupport;
        this.f14567c = i11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.f14570f;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public boolean isDone() {
        return this.f14569e;
    }

    public void onComplete() {
        this.f14566b.innerComplete(this);
    }

    public void onError(Throwable th2) {
        this.f14566b.innerError(this, th2);
    }

    public void onNext(T t11) {
        if (this.f14570f == 0) {
            this.f14566b.innerNext(this, t11);
        } else {
            this.f14566b.drain();
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(3);
                if (requestFusion == 1) {
                    this.f14570f = requestFusion;
                    this.f14568d = queueDisposable;
                    this.f14569e = true;
                    this.f14566b.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.f14570f = requestFusion;
                    this.f14568d = queueDisposable;
                    return;
                }
            }
            this.f14568d = QueueDrainHelper.createQueue(-this.f14567c);
        }
    }

    public SimpleQueue<T> queue() {
        return this.f14568d;
    }

    public void setDone() {
        this.f14569e = true;
    }
}
