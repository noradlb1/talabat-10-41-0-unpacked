package io.reactivex.internal.observers;

import i.b;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Future<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public T f14563b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f14564c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Disposable> f14565d = new AtomicReference<>();

    public FutureSingleObserver() {
        super(1);
    }

    public boolean cancel(boolean z11) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.f14565d.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!b.a(this.f14565d, disposable, disposableHelper));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    public void dispose() {
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (!isCancelled()) {
            Throwable th2 = this.f14564c;
            if (th2 == null) {
                return this.f14563b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f14565d.get());
    }

    public boolean isDisposed() {
        return isDone();
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onError(Throwable th2) {
        Disposable disposable;
        do {
            disposable = this.f14565d.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14564c = th2;
        } while (!b.a(this.f14565d, disposable, this));
        countDown();
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f14565d, disposable);
    }

    public void onSuccess(T t11) {
        Disposable disposable = this.f14565d.get();
        if (disposable != DisposableHelper.DISPOSED) {
            this.f14563b = t11;
            b.a(this.f14565d, disposable, this);
            countDown();
        }
    }

    public T get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j11, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j11, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f14564c;
            if (th2 == null) {
                return this.f14563b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
