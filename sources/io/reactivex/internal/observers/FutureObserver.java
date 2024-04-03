package io.reactivex.internal.observers;

import i.b;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public T f14560b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f14561c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Disposable> f14562d = new AtomicReference<>();

    public FutureObserver() {
        super(1);
    }

    public boolean cancel(boolean z11) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.f14562d.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!b.a(this.f14562d, disposable, disposableHelper));
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
            Throwable th2 = this.f14561c;
            if (th2 == null) {
                return this.f14560b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f14562d.get());
    }

    public boolean isDisposed() {
        return isDone();
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        Disposable disposable;
        if (this.f14560b == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            disposable = this.f14562d.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!b.a(this.f14562d, disposable, this));
        countDown();
    }

    public void onError(Throwable th2) {
        Disposable disposable;
        if (this.f14561c == null) {
            this.f14561c = th2;
            do {
                disposable = this.f14562d.get();
                if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                    RxJavaPlugins.onError(th2);
                    return;
                }
            } while (!b.a(this.f14562d, disposable, this));
            countDown();
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onNext(T t11) {
        if (this.f14560b != null) {
            this.f14562d.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f14560b = t11;
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f14562d, disposable);
    }

    public T get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j11, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j11, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f14561c;
            if (th2 == null) {
                return this.f14560b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
