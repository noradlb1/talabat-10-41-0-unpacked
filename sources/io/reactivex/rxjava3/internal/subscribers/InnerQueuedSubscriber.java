package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.operators.QueueSubscription;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;

    /* renamed from: b  reason: collision with root package name */
    public final InnerQueuedSubscriberSupport<T> f23138b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23139c;

    /* renamed from: d  reason: collision with root package name */
    public final int f23140d;

    /* renamed from: e  reason: collision with root package name */
    public volatile SimpleQueue<T> f23141e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f23142f;

    /* renamed from: g  reason: collision with root package name */
    public long f23143g;

    /* renamed from: h  reason: collision with root package name */
    public int f23144h;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i11) {
        this.f23138b = innerQueuedSubscriberSupport;
        this.f23139c = i11;
        this.f23140d = i11 - (i11 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.f23142f;
    }

    public void onComplete() {
        this.f23138b.innerComplete(this);
    }

    public void onError(Throwable th2) {
        this.f23138b.innerError(this, th2);
    }

    public void onNext(T t11) {
        if (this.f23144h == 0) {
            this.f23138b.innerNext(this, t11);
        } else {
            this.f23138b.drain();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.f23144h = requestFusion;
                    this.f23141e = queueSubscription;
                    this.f23142f = true;
                    this.f23138b.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.f23144h = requestFusion;
                    this.f23141e = queueSubscription;
                    QueueDrainHelper.request(subscription, this.f23139c);
                    return;
                }
            }
            this.f23141e = QueueDrainHelper.createQueue(this.f23139c);
            QueueDrainHelper.request(subscription, this.f23139c);
        }
    }

    public SimpleQueue<T> queue() {
        return this.f23141e;
    }

    public void request(long j11) {
        if (this.f23144h != 1) {
            long j12 = this.f23143g + j11;
            if (j12 >= ((long) this.f23140d)) {
                this.f23143g = 0;
                ((Subscription) get()).request(j12);
                return;
            }
            this.f23143g = j12;
        }
    }

    public void setDone() {
        this.f23142f = true;
    }
}
