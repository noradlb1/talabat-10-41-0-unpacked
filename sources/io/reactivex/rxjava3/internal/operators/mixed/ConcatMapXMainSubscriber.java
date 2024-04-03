package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

public abstract class ConcatMapXMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -3214213361171757852L;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicThrowable f21114b = new AtomicThrowable();

    /* renamed from: c  reason: collision with root package name */
    public final int f21115c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f21116d;

    /* renamed from: e  reason: collision with root package name */
    public SimpleQueue<T> f21117e;

    /* renamed from: f  reason: collision with root package name */
    public Subscription f21118f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f21119g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f21120h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21121i;

    public ConcatMapXMainSubscriber(int i11, ErrorMode errorMode) {
        this.f21116d = errorMode;
        this.f21115c = i11;
    }

    public void a() {
    }

    /* access modifiers changed from: package-private */
    public abstract void b();

    /* access modifiers changed from: package-private */
    public abstract void c();

    public abstract void d();

    /* access modifiers changed from: package-private */
    public final void e() {
        this.f21120h = true;
        this.f21118f.cancel();
        b();
        this.f21114b.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.f21117e.clear();
            a();
        }
    }

    public final void onComplete() {
        this.f21119g = true;
        c();
    }

    public final void onError(Throwable th2) {
        if (this.f21114b.tryAddThrowableOrReport(th2)) {
            if (this.f21116d == ErrorMode.IMMEDIATE) {
                b();
            }
            this.f21119g = true;
            c();
        }
    }

    public final void onNext(T t11) {
        if (t11 == null || this.f21117e.offer(t11)) {
            c();
            return;
        }
        this.f21118f.cancel();
        onError(new MissingBackpressureException("queue full?!"));
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f21118f, subscription)) {
            this.f21118f = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.f21117e = queueSubscription;
                    this.f21121i = true;
                    this.f21119g = true;
                    d();
                    c();
                    return;
                } else if (requestFusion == 2) {
                    this.f21117e = queueSubscription;
                    d();
                    this.f21118f.request((long) this.f21115c);
                    return;
                }
            }
            this.f21117e = new SpscArrayQueue(this.f21115c);
            d();
            this.f21118f.request((long) this.f21115c);
        }
    }
}
