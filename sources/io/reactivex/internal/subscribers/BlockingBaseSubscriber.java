package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public T f18556b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f18557c;

    /* renamed from: d  reason: collision with root package name */
    public Subscription f18558d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f18559e;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e11) {
                Subscription subscription = this.f18558d;
                this.f18558d = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        }
        Throwable th2 = this.f18557c;
        if (th2 == null) {
            return this.f18556b;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f18558d, subscription)) {
            this.f18558d = subscription;
            if (!this.f18559e) {
                subscription.request(Long.MAX_VALUE);
                if (this.f18559e) {
                    this.f18558d = SubscriptionHelper.CANCELLED;
                    subscription.cancel();
                }
            }
        }
    }
}
