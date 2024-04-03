package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, QueueSubscription<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ConditionalSubscriber<? super R> f23103b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f23104c;

    /* renamed from: d  reason: collision with root package name */
    public QueueSubscription<T> f23105d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23106e;

    /* renamed from: f  reason: collision with root package name */
    public int f23107f;

    public BasicFuseableConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber) {
        this.f23103b = conditionalSubscriber;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        Exceptions.throwIfFatal(th2);
        this.f23104c.cancel();
        onError(th2);
    }

    public void cancel() {
        this.f23104c.cancel();
    }

    public void clear() {
        this.f23105d.clear();
    }

    public final int d(int i11) {
        QueueSubscription<T> queueSubscription = this.f23105d;
        if (queueSubscription == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i11);
        if (requestFusion != 0) {
            this.f23107f = requestFusion;
        }
        return requestFusion;
    }

    public boolean isEmpty() {
        return this.f23105d.isEmpty();
    }

    public final boolean offer(R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f23106e) {
            this.f23106e = true;
            this.f23103b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f23106e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23106e = true;
        this.f23103b.onError(th2);
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23104c, subscription)) {
            this.f23104c = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f23105d = (QueueSubscription) subscription;
            }
            if (b()) {
                this.f23103b.onSubscribe(this);
                a();
            }
        }
    }

    public void request(long j11) {
        this.f23104c.request(j11);
    }

    public final boolean offer(R r11, R r12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
