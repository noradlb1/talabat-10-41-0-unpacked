package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super R> f14530b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f14531c;

    /* renamed from: d  reason: collision with root package name */
    public QueueDisposable<T> f14532d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14533e;

    /* renamed from: f  reason: collision with root package name */
    public int f14534f;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.f14530b = observer;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        Exceptions.throwIfFatal(th2);
        this.f14531c.dispose();
        onError(th2);
    }

    public void clear() {
        this.f14532d.clear();
    }

    public final int d(int i11) {
        QueueDisposable<T> queueDisposable = this.f14532d;
        if (queueDisposable == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueDisposable.requestFusion(i11);
        if (requestFusion != 0) {
            this.f14534f = requestFusion;
        }
        return requestFusion;
    }

    public void dispose() {
        this.f14531c.dispose();
    }

    public boolean isDisposed() {
        return this.f14531c.isDisposed();
    }

    public boolean isEmpty() {
        return this.f14532d.isEmpty();
    }

    public final boolean offer(R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f14533e) {
            this.f14533e = true;
            this.f14530b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f14533e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f14533e = true;
        this.f14530b.onError(th2);
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f14531c, disposable)) {
            this.f14531c = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f14532d = (QueueDisposable) disposable;
            }
            if (b()) {
                this.f14530b.onSubscribe(this);
                a();
            }
        }
    }

    public final boolean offer(R r11, R r12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
