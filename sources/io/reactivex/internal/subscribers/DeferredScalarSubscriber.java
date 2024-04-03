package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 2984505488220891551L;

    /* renamed from: d  reason: collision with root package name */
    public Subscription f18568d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18569e;

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        super(subscriber);
    }

    public void cancel() {
        super.cancel();
        this.f18568d.cancel();
    }

    public void onComplete() {
        if (this.f18569e) {
            complete(this.f18610c);
        } else {
            this.f18609b.onComplete();
        }
    }

    public void onError(Throwable th2) {
        this.f18610c = null;
        this.f18609b.onError(th2);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f18568d, subscription)) {
            this.f18568d = subscription;
            this.f18609b.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
