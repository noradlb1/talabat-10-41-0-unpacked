package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long serialVersionUID = -2189523197179400958L;

    /* renamed from: b  reason: collision with root package name */
    public Subscription f23174b;

    /* renamed from: c  reason: collision with root package name */
    public long f23175c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<Subscription> f23176d = new AtomicReference<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicLong f23177e = new AtomicLong();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicLong f23178f = new AtomicLong();

    /* renamed from: g  reason: collision with root package name */
    public final boolean f23179g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f23180h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23181i;

    public SubscriptionArbiter(boolean z11) {
        this.f23179g = z11;
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
            Subscription subscription2 = this.f23176d.get();
            if (subscription2 != null) {
                subscription2 = this.f23176d.getAndSet((Object) null);
            }
            long j12 = this.f23177e.get();
            if (j12 != 0) {
                j12 = this.f23177e.getAndSet(0);
            }
            long j13 = this.f23178f.get();
            if (j13 != 0) {
                j13 = this.f23178f.getAndSet(0);
            }
            Subscription subscription3 = this.f23174b;
            if (this.f23180h) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.f23174b = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j14 = this.f23175c;
                if (j14 != Long.MAX_VALUE) {
                    j14 = BackpressureHelper.addCap(j14, j12);
                    if (j14 != Long.MAX_VALUE) {
                        j14 -= j13;
                        if (j14 < 0) {
                            SubscriptionHelper.reportMoreProduced(j14);
                            j14 = 0;
                        }
                    }
                    this.f23175c = j14;
                }
                if (subscription2 != null) {
                    if (subscription3 != null && this.f23179g) {
                        subscription3.cancel();
                    }
                    this.f23174b = subscription2;
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
        if (!this.f23180h) {
            this.f23180h = true;
            a();
        }
    }

    public final boolean isCancelled() {
        return this.f23180h;
    }

    public final boolean isUnbounded() {
        return this.f23181i;
    }

    public final void produced(long j11) {
        if (!this.f23181i) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.add(this.f23178f, j11);
                a();
                return;
            }
            long j12 = this.f23175c;
            if (j12 != Long.MAX_VALUE) {
                long j13 = j12 - j11;
                if (j13 < 0) {
                    SubscriptionHelper.reportMoreProduced(j13);
                    j13 = 0;
                }
                this.f23175c = j13;
            }
            if (decrementAndGet() != 0) {
                b();
            }
        }
    }

    public final void request(long j11) {
        if (SubscriptionHelper.validate(j11) && !this.f23181i) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.add(this.f23177e, j11);
                a();
                return;
            }
            long j12 = this.f23175c;
            if (j12 != Long.MAX_VALUE) {
                long addCap = BackpressureHelper.addCap(j12, j11);
                this.f23175c = addCap;
                if (addCap == Long.MAX_VALUE) {
                    this.f23181i = true;
                }
            }
            Subscription subscription = this.f23174b;
            if (decrementAndGet() != 0) {
                b();
            }
            if (subscription != null) {
                subscription.request(j11);
            }
        }
    }

    public final void setSubscription(Subscription subscription) {
        if (this.f23180h) {
            subscription.cancel();
            return;
        }
        Objects.requireNonNull(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription andSet = this.f23176d.getAndSet(subscription);
            if (andSet != null && this.f23179g) {
                andSet.cancel();
            }
            a();
            return;
        }
        Subscription subscription2 = this.f23174b;
        if (subscription2 != null && this.f23179g) {
            subscription2.cancel();
        }
        this.f23174b = subscription;
        long j11 = this.f23175c;
        if (decrementAndGet() != 0) {
            b();
        }
        if (j11 != 0) {
            subscription.request(j11);
        }
    }
}
