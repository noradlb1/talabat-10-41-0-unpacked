package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super R> f19006b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f19007c;

    /* renamed from: d  reason: collision with root package name */
    public QueueDisposable<T> f19008d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19009e;

    /* renamed from: f  reason: collision with root package name */
    public int f19010f;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.f19006b = observer;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        Exceptions.throwIfFatal(th2);
        this.f19007c.dispose();
        onError(th2);
    }

    public void clear() {
        this.f19008d.clear();
    }

    public final int d(int i11) {
        QueueDisposable<T> queueDisposable = this.f19008d;
        if (queueDisposable == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueDisposable.requestFusion(i11);
        if (requestFusion != 0) {
            this.f19010f = requestFusion;
        }
        return requestFusion;
    }

    public void dispose() {
        this.f19007c.dispose();
    }

    public boolean isDisposed() {
        return this.f19007c.isDisposed();
    }

    public boolean isEmpty() {
        return this.f19008d.isEmpty();
    }

    public final boolean offer(R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f19009e) {
            this.f19009e = true;
            this.f19006b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f19009e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f19009e = true;
        this.f19006b.onError(th2);
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f19007c, disposable)) {
            this.f19007c = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f19008d = (QueueDisposable) disposable;
            }
            if (b()) {
                this.f19006b.onSubscribe(this);
                a();
            }
        }
    }

    public final boolean offer(R r11, R r12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
