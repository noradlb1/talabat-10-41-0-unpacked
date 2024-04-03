package io.reactivex.rxjava3.internal.observers;

import i.b;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
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
    public T f19044b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f19045c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Disposable> f19046d = new AtomicReference<>();

    public FutureObserver() {
        super(1);
    }

    public boolean cancel(boolean z11) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.f19046d.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!b.a(this.f19046d, disposable, disposableHelper));
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
            Throwable th2 = this.f19045c;
            if (th2 == null) {
                return this.f19044b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f19046d.get());
    }

    public boolean isDisposed() {
        return isDone();
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        if (this.f19044b == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        Disposable disposable = this.f19046d.get();
        if (disposable != this && disposable != DisposableHelper.DISPOSED && b.a(this.f19046d, disposable, this)) {
            countDown();
        }
    }

    public void onError(Throwable th2) {
        Disposable disposable;
        if (this.f19045c != null || (disposable = this.f19046d.get()) == this || disposable == DisposableHelper.DISPOSED || !b.a(this.f19046d, disposable, this)) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f19045c = th2;
        countDown();
    }

    public void onNext(T t11) {
        if (this.f19044b != null) {
            this.f19046d.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f19044b = t11;
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f19046d, disposable);
    }

    public T get(long j11, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j11, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j11, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f19045c;
            if (th2 == null) {
                return this.f19044b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
