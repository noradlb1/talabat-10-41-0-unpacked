package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;

    /* renamed from: b  reason: collision with root package name */
    public Subscription f18613b;

    /* renamed from: c  reason: collision with root package name */
    public long f18614c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Subscription> f18615d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicLong f18616e = new AtomicLong();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicLong f18617f = new AtomicLong();

    /* renamed from: g  reason: collision with root package name */
    public final boolean f18618g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f18619h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18620i;

    public SubscriptionArbiter(boolean z11) {
        this.f18618g = z11;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (getAndIncrement() == 0) {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        int i11 = 1;
        long j11 = 0;
        Subscription subscription = null;
        do {
            Subscription subscription2 = this.f18615d.get();
            if (subscription2 != null) {
                subscription2 = this.f18615d.getAndSet((Object) null);
            }
            long j12 = this.f18616e.get();
            if (j12 != 0) {
                j12 = this.f18616e.getAndSet(0);
            }
            long j13 = this.f18617f.get();
            if (j13 != 0) {
                j13 = this.f18617f.getAndSet(0);
            }
            Subscription subscription3 = this.f18613b;
            if (this.f18619h) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.f18613b = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j14 = this.f18614c;
                if (j14 != Long.MAX_VALUE) {
                    j14 = BackpressureHelper.addCap(j14, j12);
                    if (j14 != Long.MAX_VALUE) {
                        j14 -= j13;
                        if (j14 < 0) {
                            SubscriptionHelper.reportMoreProduced(j14);
                            j14 = 0;
                        }
                    }
                    this.f18614c = j14;
                }
                if (subscription2 != null) {
                    if (subscription3 != null && this.f18618g) {
                        subscription3.cancel();
                    }
                    this.f18613b = subscription2;
                    if (j14 != 0) {
                        j11 = BackpressureHelper.addCap(j11, j14);
                        subscription = subscription2;
                    }
                } else if (!(subscription3 == null || j12 == 0)) {
                    j11 = BackpressureHelper.addCap(j11, j12);
                    subscription = subscription3;
                }
            }
            i11 = addAndGet(-i11);
        } while (i11 != 0);
        if (j11 != 0) {
            subscription.request(j11);
        }
    }

    public void cancel() {
        if (!this.f18619h) {
            this.f18619h = true;
            a();
        }
    }

    public final boolean isCancelled() {
        return this.f18619h;
    }

    public final boolean isUnbounded() {
        return this.f18620i;
    }

    public final void produced(long j11) {
        if (!this.f18620i) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.add(this.f18617f, j11);
                a();
                return;
            }
            long j12 = this.f18614c;
            if (j12 != Long.MAX_VALUE) {
                long j13 = j12 - j11;
                if (j13 < 0) {
                    SubscriptionHelper.reportMoreProduced(j13);
                    j13 = 0;
                }
                this.f18614c = j13;
            }
            if (decrementAndGet() != 0) {
                b();
            }
        }
    }

    public final void request(long j11) {
        if (SubscriptionHelper.validate(j11) && !this.f18620i) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.add(this.f18616e, j11);
                a();
                return;
            }
            long j12 = this.f18614c;
            if (j12 != Long.MAX_VALUE) {
                long addCap = BackpressureHelper.addCap(j12, j11);
                this.f18614c = addCap;
                if (addCap == Long.MAX_VALUE) {
                    this.f18620i = true;
                }
            }
            Subscription subscription = this.f18613b;
            if (decrementAndGet() != 0) {
                b();
            }
            if (subscription != null) {
                subscription.request(j11);
            }
        }
    }

    public final void setSubscription(Subscription subscription) {
        if (this.f18619h) {
            subscription.cancel();
            return;
        }
        ObjectHelper.requireNonNull(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription andSet = this.f18615d.getAndSet(subscription);
            if (andSet != null && this.f18618g) {
                andSet.cancel();
            }
            a();
            return;
        }
        Subscription subscription2 = this.f18613b;
        if (subscription2 != null && this.f18618g) {
            subscription2.cancel();
        }
        this.f18613b = subscription;
        long j11 = this.f18614c;
        if (decrementAndGet() != 0) {
            b();
        }
        if (j11 != 0) {
            subscription.request(j11);
        }
    }
}
