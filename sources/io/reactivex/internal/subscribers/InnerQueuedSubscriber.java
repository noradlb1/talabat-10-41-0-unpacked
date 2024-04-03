package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;

    /* renamed from: b  reason: collision with root package name */
    public final InnerQueuedSubscriberSupport<T> f18577b;

    /* renamed from: c  reason: collision with root package name */
    public final int f18578c;

    /* renamed from: d  reason: collision with root package name */
    public final int f18579d;

    /* renamed from: e  reason: collision with root package name */
    public volatile SimpleQueue<T> f18580e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f18581f;

    /* renamed from: g  reason: collision with root package name */
    public long f18582g;

    /* renamed from: h  reason: collision with root package name */
    public int f18583h;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i11) {
        this.f18577b = innerQueuedSubscriberSupport;
        this.f18578c = i11;
        this.f18579d = i11 - (i11 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.f18581f;
    }

    public void onComplete() {
        this.f18577b.innerComplete(this);
    }

    public void onError(Throwable th2) {
        this.f18577b.innerError(this, th2);
    }

    public void onNext(T t11) {
        if (this.f18583h == 0) {
            this.f18577b.innerNext(this, t11);
        } else {
            this.f18577b.drain();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f18583h = requestFusion;
                    this.f18580e = queueSubscription;
                    this.f18581f = true;
                    this.f18577b.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.f18583h = requestFusion;
                    this.f18580e = queueSubscription;
                    QueueDrainHelper.request(subscription, this.f18578c);
                    return;
                }
            }
            this.f18580e = QueueDrainHelper.createQueue(this.f18578c);
            QueueDrainHelper.request(subscription, this.f18578c);
        }
    }

    public SimpleQueue<T> queue() {
        return this.f18580e;
    }

    public void request(long j11) {
        if (this.f18583h != 1) {
            long j12 = this.f18582g + j11;
            if (j12 >= ((long) this.f18579d)) {
                this.f18582g = 0;
                ((Subscription) get()).request(j12);
                return;
            }
            this.f18582g = j12;
        }
    }

    public void requestOne() {
        if (this.f18583h != 1) {
            long j11 = this.f18582g + 1;
            if (j11 == ((long) this.f18579d)) {
                this.f18582g = 0;
                ((Subscription) get()).request(j11);
                return;
            }
            this.f18582g = j11;
        }
    }

    public void setDone() {
        this.f18581f = true;
    }
}
