package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super R> f18551b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f18552c;

    /* renamed from: d  reason: collision with root package name */
    public QueueSubscription<T> f18553d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18554e;

    /* renamed from: f  reason: collision with root package name */
    public int f18555f;

    public BasicFuseableSubscriber(Subscriber<? super R> subscriber) {
        this.f18551b = subscriber;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        Exceptions.throwIfFatal(th2);
        this.f18552c.cancel();
        onError(th2);
    }

    public void cancel() {
        this.f18552c.cancel();
    }

    public void clear() {
        this.f18553d.clear();
    }

    public final int d(int i11) {
        QueueSubscription<T> queueSubscription = this.f18553d;
        if (queueSubscription == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i11);
        if (requestFusion != 0) {
            this.f18555f = requestFusion;
        }
        return requestFusion;
    }

    public boolean isEmpty() {
        return this.f18553d.isEmpty();
    }

    public final boolean offer(R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f18554e) {
            this.f18554e = true;
            this.f18551b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f18554e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f18554e = true;
        this.f18551b.onError(th2);
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f18552c, subscription)) {
            this.f18552c = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f18553d = (QueueSubscription) subscription;
            }
            if (b()) {
                this.f18551b.onSubscribe(this);
                a();
            }
        }
    }

    public void request(long j11) {
        this.f18552c.request(j11);
    }

    public final boolean offer(R r11, R r12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
