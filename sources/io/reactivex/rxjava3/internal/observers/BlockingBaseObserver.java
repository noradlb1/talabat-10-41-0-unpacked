package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public T f19012b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f19013c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f19014d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f19015e;

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
        Throwable th2 = this.f19013c;
        if (th2 == null) {
            return this.f19012b;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public final void dispose() {
        this.f19015e = true;
        Disposable disposable = this.f19014d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f19015e;
    }

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(Disposable disposable) {
        this.f19014d = disposable;
        if (this.f19015e) {
            disposable.dispose();
        }
    }
}
