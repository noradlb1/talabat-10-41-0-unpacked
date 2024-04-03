package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

abstract class AbstractBackpressureThrottlingSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -5050301752721603566L;

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super R> f19253b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f19254c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f19255d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f19256e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f19257f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f19258g = new AtomicLong();

    /* renamed from: h  reason: collision with root package name */
    public final AtomicReference<R> f19259h = new AtomicReference<>();

    public AbstractBackpressureThrottlingSubscriber(Subscriber<? super R> subscriber) {
        this.f19253b = subscriber;
    }

    public boolean a(boolean z11, boolean z12, Subscriber<?> subscriber, AtomicReference<R> atomicReference) {
        if (this.f19257f) {
            atomicReference.lazySet((Object) null);
            return true;
        } else if (!z11) {
            return false;
        } else {
            Throwable th2 = this.f19256e;
            if (th2 != null) {
                atomicReference.lazySet((Object) null);
                subscriber.onError(th2);
                return true;
            } else if (!z12) {
                return false;
            } else {
                subscriber.onComplete();
                return true;
            }
        }
    }

    public void b() {
        boolean z11;
        boolean z12;
        if (getAndIncrement() == 0) {
            Subscriber<? super R> subscriber = this.f19253b;
            AtomicLong atomicLong = this.f19258g;
            AtomicReference<R> atomicReference = this.f19259h;
            int i11 = 1;
            do {
                long j11 = 0;
                while (true) {
                    z11 = false;
                    if (j11 == atomicLong.get()) {
                        break;
                    }
                    boolean z13 = this.f19255d;
                    R andSet = atomicReference.getAndSet((Object) null);
                    if (andSet == null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!a(z13, z12, subscriber, atomicReference)) {
                        if (z12) {
                            break;
                        }
                        subscriber.onNext(andSet);
                        j11++;
                    } else {
                        return;
                    }
                }
                if (j11 == atomicLong.get()) {
                    boolean z14 = this.f19255d;
                    if (atomicReference.get() == null) {
                        z11 = true;
                    }
                    if (a(z14, z11, subscriber, atomicReference)) {
                        return;
                    }
                }
                if (j11 != 0) {
                    BackpressureHelper.produced(atomicLong, j11);
                }
                i11 = addAndGet(-i11);
            } while (i11 != 0);
        }
    }

    public void cancel() {
        if (!this.f19257f) {
            this.f19257f = true;
            this.f19254c.cancel();
            if (getAndIncrement() == 0) {
                this.f19259h.lazySet((Object) null);
            }
        }
    }

    public void onComplete() {
        this.f19255d = true;
        b();
    }

    public void onError(Throwable th2) {
        this.f19256e = th2;
        this.f19255d = true;
        b();
    }

    public abstract void onNext(T t11);

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f19254c, subscription)) {
            this.f19254c = subscription;
            this.f19253b.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            BackpressureHelper.add(this.f19258g, j11);
            b();
        }
    }
}
