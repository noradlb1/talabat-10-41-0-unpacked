package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super R> f23108b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f23109c;

    /* renamed from: d  reason: collision with root package name */
    public QueueSubscription<T> f23110d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23111e;

    /* renamed from: f  reason: collision with root package name */
    public int f23112f;

    public BasicFuseableSubscriber(Subscriber<? super R> subscriber) {
        this.f23108b = subscriber;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        Exceptions.throwIfFatal(th2);
        this.f23109c.cancel();
        onError(th2);
    }

    public void cancel() {
        this.f23109c.cancel();
    }

    public void clear() {
        this.f23110d.clear();
    }

    public final int d(int i11) {
        QueueSubscription<T> queueSubscription = this.f23110d;
        if (queueSubscription == null || (i11 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i11);
        if (requestFusion != 0) {
            this.f23112f = requestFusion;
        }
        return requestFusion;
    }

    public boolean isEmpty() {
        return this.f23110d.isEmpty();
    }

    public final boolean offer(R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.f23111e) {
            this.f23111e = true;
            this.f23108b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.f23111e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23111e = true;
        this.f23108b.onError(th2);
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23109c, subscription)) {
            this.f23109c = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f23110d = (QueueSubscription) subscription;
            }
            if (b()) {
                this.f23108b.onSubscribe(this);
                a();
            }
        }
    }

    public void request(long j11) {
        this.f23109c.request(j11);
    }

    public final boolean offer(R r11, R r12) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
