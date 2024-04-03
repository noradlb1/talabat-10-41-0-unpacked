package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f23160b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicThrowable f23161c = new AtomicThrowable();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicLong f23162d = new AtomicLong();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<Subscription> f23163e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f23164f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f23165g;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.f23160b = subscriber;
    }

    public void cancel() {
        if (!this.f23165g) {
            SubscriptionHelper.cancel(this.f23163e);
        }
    }

    public void onComplete() {
        this.f23165g = true;
        HalfSerializer.onComplete((Subscriber<?>) this.f23160b, (AtomicInteger) this, this.f23161c);
    }

    public void onError(Throwable th2) {
        this.f23165g = true;
        HalfSerializer.onError((Subscriber<?>) this.f23160b, th2, (AtomicInteger) this, this.f23161c);
    }

    public void onNext(T t11) {
        HalfSerializer.onNext(this.f23160b, t11, (AtomicInteger) this, this.f23161c);
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f23164f.compareAndSet(false, true)) {
            this.f23160b.onSubscribe(this);
            SubscriptionHelper.deferredSetOnce(this.f23163e, this.f23162d, subscription);
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
        SubscriptionHelper.deferredRequest(this.f23163e, this.f23162d, j11);
    }
}
