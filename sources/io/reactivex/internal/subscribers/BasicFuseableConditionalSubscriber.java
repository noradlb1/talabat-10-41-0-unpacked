package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, QueueSubscription<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ConditionalSubscriber<? super R> f18546b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f18547c;

    /* renamed from: d  reason: collision with root package name */
    public QueueSubscription<T> f18548d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18549e;

    /* renamed from: f  reason: collision with root package name */
    public int f18550f;

    public BasicFuseableConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber) {
        this.f18546b = conditionalSubscriber;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        Exceptions.throwIfFatal(th2);
        this.f18547c.cancel();
        onError(th2);
    }

    public void cancel() {
        this.f18547c.cancel();
    }

    public void clear() {
        this.f18548d.clear();
    }

    public final int d(int i11) {
        QueueSubscription<T> queueSubscription = this.f18548d;
        if (queueSubscription == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i11);
        if (requestFusion != 0) {
            this.f18550f = requestFusion;
        }
        return requestFusion;
    }

    public boolean isEmpty() {
        return this.f18548d.isEmpty();
    }

    public final boolean offer(R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f18549e) {
            this.f18549e = true;
            this.f18546b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f18549e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f18549e = true;
        this.f18546b.onError(th2);
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f18547c, subscription)) {
            this.f18547c = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f18548d = (QueueSubscription) subscription;
            }
            if (b()) {
                this.f18546b.onSubscribe(this);
                a();
            }
        }
    }

    public void request(long j11) {
        this.f18547c.request(j11);
    }

    public final boolean offer(R r11, R r12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
