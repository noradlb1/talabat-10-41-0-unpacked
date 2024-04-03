package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import java.util.concurrent.CountDownLatch;

public final class BlockingDisposableMultiObserver<T> extends CountDownLatch implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public T f19016b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f19017c;

    /* renamed from: d  reason: collision with root package name */
    public final SequentialDisposable f19018d = new SequentialDisposable();

    public BlockingDisposableMultiObserver() {
        super(1);
    }

    public void blockingConsume(CompletableObserver completableObserver) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e11) {
                dispose();
                completableObserver.onError(e11);
                return;
            }
        }
        if (!isDisposed()) {
            Throwable th2 = this.f19017c;
            if (th2 != null) {
                completableObserver.onError(th2);
            } else {
                completableObserver.onComplete();
            }
        }
    }

    public void dispose() {
        this.f19018d.dispose();
        countDown();
    }

    public boolean isDisposed() {
        return this.f19018d.isDisposed();
    }

    public void onComplete() {
        this.f19018d.lazySet(a.a());
        countDown();
    }

    public void onError(@NonNull Throwable th2) {
        this.f19017c = th2;
        this.f19018d.lazySet(a.a());
        countDown();
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        DisposableHelper.setOnce(this.f19018d, disposable);
    }

    public void onSuccess(@NonNull T t11) {
        this.f19016b = t11;
        this.f19018d.lazySet(a.a());
        countDown();
    }

    public void blockingConsume(SingleObserver<? super T> singleObserver) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e11) {
                dispose();
                singleObserver.onError(e11);
                return;
            }
        }
        if (!isDisposed()) {
            Throwable th2 = this.f19017c;
            if (th2 != null) {
                singleObserver.onError(th2);
            } else {
                singleObserver.onSuccess(this.f19016b);
            }
        }
    }

    public void blockingConsume(MaybeObserver<? super T> maybeObserver) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e11) {
                dispose();
                maybeObserver.onError(e11);
                return;
            }
        }
        if (!isDisposed()) {
            Throwable th2 = this.f19017c;
            if (th2 != null) {
                maybeObserver.onError(th2);
                return;
            }
            T t11 = this.f19016b;
            if (t11 == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(t11);
            }
        }
    }
}
