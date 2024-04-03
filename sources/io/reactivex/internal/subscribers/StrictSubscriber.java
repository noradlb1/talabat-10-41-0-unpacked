package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f18599b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicThrowable f18600c = new AtomicThrowable();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f18601d = new AtomicLong();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<Subscription> f18602e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f18603f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f18604g;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.f18599b = subscriber;
    }

    public void cancel() {
        if (!this.f18604g) {
            SubscriptionHelper.cancel(this.f18602e);
        }
    }

    public void onComplete() {
        this.f18604g = true;
        HalfSerializer.onComplete((Subscriber<?>) this.f18599b, (AtomicInteger) this, this.f18600c);
    }

    public void onError(Throwable th2) {
        this.f18604g = true;
        HalfSerializer.onError((Subscriber<?>) this.f18599b, th2, (AtomicInteger) this, this.f18600c);
    }

    public void onNext(T t11) {
        HalfSerializer.onNext(this.f18599b, t11, (AtomicInteger) this, this.f18600c);
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f18603f.compareAndSet(false, true)) {
            this.f18599b.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.f18602e, this.f18601d, subscription);
            return;
        }
        subscription.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void request(long j11) {
        if (j11 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j11));
            return;
        }
        SubscriptionHelper.deferredRequest(this.f18602e, this.f18601d, j11);
    }
}
