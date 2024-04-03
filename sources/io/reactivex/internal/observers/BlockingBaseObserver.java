package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public T f14536b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f14537c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f14538d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f14539e;

    public BlockingBaseObserver() {
        super(1);
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e11) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        }
        Throwable th2 = this.f14537c;
        if (th2 == null) {
            return this.f14536b;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public final void dispose() {
        this.f14539e = true;
        Disposable disposable = this.f14538d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f14539e;
    }

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(Disposable disposable) {
        this.f14538d = disposable;
        if (this.f14539e) {
            disposable.dispose();
        }
    }
}
