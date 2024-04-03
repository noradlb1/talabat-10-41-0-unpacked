package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {

    /* renamed from: b  reason: collision with root package name */
    public T f14540b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f14541c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f14542d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f14543e;

    public BlockingMultiObserver() {
        super(1);
    }

    public void a() {
        this.f14543e = true;
        Disposable disposable = this.f14542d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public boolean blockingAwait(long j11, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j11, timeUnit)) {
                    a();
                    return false;
                }
            } catch (InterruptedException e11) {
                a();
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        }
        Throwable th2 = this.f14541c;
        if (th2 == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e11) {
                a();
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        }
        Throwable th2 = this.f14541c;
        if (th2 == null) {
            return this.f14540b;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public Throwable blockingGetError() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e11) {
                a();
                return e11;
            }
        }
        return this.f14541c;
    }

    public void onComplete() {
        countDown();
    }

    public void onError(Throwable th2) {
        this.f14541c = th2;
        countDown();
    }

    public void onSubscribe(Disposable disposable) {
        this.f14542d = disposable;
        if (this.f14543e) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t11) {
        this.f14540b = t11;
        countDown();
    }

    public Throwable blockingGetError(long j11, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j11, timeUnit)) {
                    a();
                    throw ExceptionHelper.wrapOrThrow(new TimeoutException(ExceptionHelper.timeoutMessage(j11, timeUnit)));
                }
            } catch (InterruptedException e11) {
                a();
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        }
        return this.f14541c;
    }

    public T blockingGet(T t11) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e11) {
                a();
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        }
        Throwable th2 = this.f14541c;
        if (th2 == null) {
            T t12 = this.f14540b;
            return t12 != null ? t12 : t11;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }
}
