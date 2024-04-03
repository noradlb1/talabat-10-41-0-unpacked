package io.reactivex.internal.subscribers;

import com.google.android.exoplayer2.C;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 7917814472626990048L;

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super R> f18595b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f18596c;

    /* renamed from: d  reason: collision with root package name */
    public R f18597d;

    /* renamed from: e  reason: collision with root package name */
    public long f18598e;

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.f18595b = subscriber;
    }

    public final void a(R r11) {
        long j11 = this.f18598e;
        if (j11 != 0) {
            BackpressureHelper.produced(this, j11);
        }
        while (true) {
            long j12 = get();
            if ((j12 & Long.MIN_VALUE) != 0) {
                b(r11);
                return;
            } else if ((j12 & Long.MAX_VALUE) != 0) {
                lazySet(C.TIME_UNSET);
                this.f18595b.onNext(r11);
                this.f18595b.onComplete();
                return;
            } else {
                this.f18597d = r11;
                if (!compareAndSet(0, Long.MIN_VALUE)) {
                    this.f18597d = null;
                } else {
                    return;
                }
            }
        }
    }

    public void b(R r11) {
    }

    public void cancel() {
        this.f18596c.cancel();
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f18596c, subscription)) {
            this.f18596c = subscription;
            this.f18595b.onSubscribe(this);
        }
    }

    public final void request(long j11) {
        long j12;
        if (SubscriptionHelper.validate(j11)) {
            do {
                j12 = get();
                if ((j12 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, C.TIME_UNSET)) {
                        this.f18595b.onNext(this.f18597d);
                        this.f18595b.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j12, BackpressureHelper.addCap(j12, j11)));
            this.f18596c.request(j11);
        }
    }
}
