package io.reactivex.rxjava3.internal.subscribers;

import com.google.android.exoplayer2.C;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 7917814472626990048L;

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super R> f23156b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f23157c;

    /* renamed from: d  reason: collision with root package name */
    public R f23158d;

    /* renamed from: e  reason: collision with root package name */
    public long f23159e;

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.f23156b = subscriber;
    }

    public final void a(R r11) {
        long j11 = this.f23159e;
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
                this.f23156b.onNext(r11);
                this.f23156b.onComplete();
                return;
            } else {
                this.f23158d = r11;
                if (!compareAndSet(0, Long.MIN_VALUE)) {
                    this.f23158d = null;
                } else {
                    return;
                }
            }
        }
    }

    public void b(R r11) {
    }

    public void cancel() {
        this.f23157c.cancel();
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23157c, subscription)) {
            this.f23157c = subscription;
            this.f23156b.onSubscribe(this);
        }
    }

    public final void request(long j11) {
        long j12;
        if (SubscriptionHelper.validate(j11)) {
            do {
                j12 = get();
                if ((j12 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, C.TIME_UNSET)) {
                        this.f23156b.onNext(this.f23158d);
                        this.f23156b.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j12, BackpressureHelper.addCap(j12, j11)));
            this.f23157c.request(j11);
        }
    }
}
