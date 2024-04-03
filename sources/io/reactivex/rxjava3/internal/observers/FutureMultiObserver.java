package io.reactivex.rxjava3.internal.observers;

import i.b;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class FutureMultiObserver<T> extends CountDownLatch implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver, Future<T>, Disposable {

    /* renamed from: b  reason: collision with root package name */
    public T f19041b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f19042c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Disposable> f19043d = new AtomicReference<>();

    public FutureMultiObserver() {
        super(1);
    }

    public boolean cancel(boolean z11) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.f19043d.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!b.a(this.f19043d, disposable, disposableHelper));
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
            Throwable th2 = this.f19042c;
            if (th2 == null) {
                return this.f19041b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f19043d.get());
    }

    public boolean isDisposed() {
        return isDone();
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        Disposable disposable = this.f19043d.get();
        if (disposable != DisposableHelper.DISPOSED) {
            b.a(this.f19043d, disposable, this);
            countDown();
        }
    }

    public void onError(Throwable th2) {
        Disposable disposable;
        do {
            disposable = this.f19043d.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19042c = th2;
        } while (!b.a(this.f19043d, disposable, this));
        countDown();
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f19043d, disposable);
    }

    public void onSuccess(T t11) {
        Disposable disposable = this.f19043d.get();
        if (disposable != DisposableHelper.DISPOSED) {
            this.f19041b = t11;
            b.a(this.f19043d, disposable, this);
            countDown();
        }
    }

    public T get(long j11, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j11, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j11, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f19042c;
            if (th2 == null) {
                return this.f19041b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
