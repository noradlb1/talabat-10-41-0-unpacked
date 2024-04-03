package io.reactivex.rxjava3.internal.subscribers;

import i.b;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
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
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {

    /* renamed from: b  reason: collision with root package name */
    public T f23135b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f23136c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Subscription> f23137d = new AtomicReference<>();

    public FutureSubscriber() {
        super(1);
    }

    public void cancel() {
    }

    public boolean cancel(boolean z11) {
        Subscription subscription;
        SubscriptionHelper subscriptionHelper;
        do {
            subscription = this.f23137d.get();
            if (subscription == this || subscription == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!b.a(this.f23137d, subscription, subscriptionHelper));
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
            Throwable th2 = this.f23136c;
            if (th2 == null) {
                return this.f23135b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return this.f23137d.get() == SubscriptionHelper.CANCELLED;
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        if (this.f23135b == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        Subscription subscription = this.f23137d.get();
        if (subscription != this && subscription != SubscriptionHelper.CANCELLED && b.a(this.f23137d, subscription, this)) {
            countDown();
        }
    }

    public void onError(Throwable th2) {
        Subscription subscription;
        if (this.f23136c != null || (subscription = this.f23137d.get()) == this || subscription == SubscriptionHelper.CANCELLED || !b.a(this.f23137d, subscription, this)) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23136c = th2;
        countDown();
    }

    public void onNext(T t11) {
        if (this.f23135b != null) {
            this.f23137d.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f23135b = t11;
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.f23137d, subscription, Long.MAX_VALUE);
    }

    public void request(long j11) {
    }

    public T get(long j11, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.verifyNonBlocking();
            if (!await(j11, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.timeoutMessage(j11, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f23136c;
            if (th2 == null) {
                return this.f23135b;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
