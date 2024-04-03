package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ConcatMapXMainObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
    private static final long serialVersionUID = -3214213361171757852L;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicThrowable f21107b = new AtomicThrowable();

    /* renamed from: c  reason: collision with root package name */
    public final int f21108c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f21109d;

    /* renamed from: e  reason: collision with root package name */
    public SimpleQueue<T> f21110e;

    /* renamed from: f  reason: collision with root package name */
    public Disposable f21111f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f21112g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f21113h;

    public ConcatMapXMainObserver(int i11, ErrorMode errorMode) {
        this.f21109d = errorMode;
        this.f21108c = i11;
    }

    public void a() {
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public final void dispose() {
        this.f21113h = true;
        this.f21111f.dispose();
        b();
        this.f21107b.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.f21110e.clear();
            a();
        }
    }

    public final boolean isDisposed() {
        return this.f21113h;
    }

    public final void onComplete() {
        this.f21112g = true;
        c();
    }

    public final void onError(Throwable th2) {
        if (this.f21107b.tryAddThrowableOrReport(th2)) {
            if (this.f21109d == ErrorMode.IMMEDIATE) {
                b();
            }
            this.f21112g = true;
            c();
        }
    }

    public final void onNext(T t11) {
        if (t11 != null) {
            this.f21110e.offer(t11);
        }
        c();
    }

    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f21111f, disposable)) {
            this.f21111f = disposable;
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.f21110e = queueDisposable;
                    this.f21112g = true;
                    d();
                    c();
                    return;
                } else if (requestFusion == 2) {
                    this.f21110e = queueDisposable;
                    d();
                    return;
                }
            }
            this.f21110e = new SpscLinkedArrayQueue(this.f21108c);
            d();
        }
    }
}
