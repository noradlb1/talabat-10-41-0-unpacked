package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {

    /* renamed from: b  reason: collision with root package name */
    public T f19019b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f19020c;

    /* renamed from: d  reason: collision with root package name */
    public Disposable f19021d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f19022e;

    public BlockingMultiObserver() {
        super(1);
    }

    public void a() {
        this.f19022e = true;
        Disposable disposable = this.f19021d;
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
        Throwable th2 = this.f19020c;
        if (th2 == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public void blockingConsume(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        try {
            if (getCount() != 0) {
                BlockingHelper.verifyNonBlocking();
                await();
            }
            Throwable th2 = this.f19020c;
            if (th2 != null) {
                consumer2.accept(th2);
                return;
            }
            T t11 = this.f19019b;
            if (t11 != null) {
                consumer.accept(t11);
            } else {
                action.run();
            }
        } catch (InterruptedException e11) {
            a();
            consumer2.accept(e11);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(th3);
        }
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
        Throwable th2 = this.f19020c;
        if (th2 == null) {
            return this.f19019b;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public void onComplete() {
        countDown();
    }

    public void onError(Throwable th2) {
        this.f19020c = th2;
        countDown();
    }

    public void onSubscribe(Disposable disposable) {
        this.f19021d = disposable;
        if (this.f19022e) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t11) {
        this.f19019b = t11;
        countDown();
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
        Throwable th2 = this.f19020c;
        if (th2 == null) {
            T t12 = this.f19019b;
            return t12 != null ? t12 : t11;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }
}
