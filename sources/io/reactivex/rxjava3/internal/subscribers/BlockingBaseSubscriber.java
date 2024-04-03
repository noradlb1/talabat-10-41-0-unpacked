package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public T f23113b;

    /* renamed from: c  reason: collision with root package name */
    public Throwable f23114c;

    /* renamed from: d  reason: collision with root package name */
    public Subscription f23115d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f23116e;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e11) {
                Subscription subscription = this.f23115d;
                this.f23115d = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.wrapOrThrow(e11);
            }
        }
        Throwable th2 = this.f23114c;
        if (th2 == null) {
            return this.f23113b;
        }
        throw ExceptionHelper.wrapOrThrow(th2);
    }

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23115d, subscription)) {
            this.f23115d = subscription;
            if (!this.f23116e) {
                subscription.request(Long.MAX_VALUE);
                if (this.f23116e) {
                    this.f23115d = SubscriptionHelper.CANCELLED;
                    subscription.cancel();
                }
            }
        }
    }
}
