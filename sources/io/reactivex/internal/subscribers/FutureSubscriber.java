package io.reactivex.internal.subscribers;

import i.b;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
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
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {

    /* renamed from: b  reason: collision with root package name */
    public T f18574b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f18575c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Subscription> f18576d = new AtomicReference<>();

    public FutureSubscriber() {
        super(1);
    }

    public void cancel() {
    }

    public boolean cancel(boolean z11) {
        Subscription subscription;
        SubscriptionHelper subscriptionHelper;
        do {
            subscription = this.f18576d.get();
            if (subscription == this || subscription == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!b.a(this.f18576d, subscription, subscriptionHelper));
        if (subscription != null) {
            subscription.cancel();
        }
        countDown();
        return true;
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            await();
        }
        if (!isCancelled()) {
            Throwable th2 = this.f18575c;
            if (th2 == null) {
                return this.f18574b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return this.f18576d.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        Subscription subscription;
        if (this.f18574b == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            subscription = this.f18576d.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!b.a(this.f18576d, subscription, this));
        countDown();
    }

    public void onError(Throwable th2) {
        Subscription subscription;
        do {
            subscription = this.f18576d.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18575c = th2;
        } while (!b.a(this.f18576d, subscription, this));
        countDown();
    }

    public void onNext(T t11) {
        if (this.f18574b != null) {
            this.f18576d.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f18574b = t11;
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.f18576d, subscription, Long.MAX_VALUE);
    }

    public void request(long j11) {
    }

    public T get(long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j11, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j11, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f18575c;
            if (th2 == null) {
                return this.f18574b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
