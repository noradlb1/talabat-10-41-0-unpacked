package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final T f15837d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f15838e;

    public static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5526049321428043809L;

        /* renamed from: d  reason: collision with root package name */
        public final T f15839d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f15840e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f15841f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15842g;

        public SingleElementSubscriber(Subscriber<? super T> subscriber, T t11, boolean z11) {
            super(subscriber);
            this.f15839d = t11;
            this.f15840e = z11;
        }

        public void cancel() {
            super.cancel();
            this.f15841f.cancel();
        }

        public void onComplete() {
            if (!this.f15842g) {
                this.f15842g = true;
                T t11 = this.f18610c;
                this.f18610c = null;
                if (t11 == null) {
                    t11 = this.f15839d;
                }
                if (t11 != null) {
                    complete(t11);
                } else if (this.f15840e) {
                    this.f18609b.onError(new NoSuchElementException());
                } else {
                    this.f18609b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f15842g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15842g = true;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15842g) {
                if (this.f18610c != null) {
                    this.f15842g = true;
                    this.f15841f.cancel();
                    this.f18609b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f18610c = t11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15841f, subscription)) {
                this.f15841f = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSingle(Flowable<T> flowable, T t11, boolean z11) {
        super(flowable);
        this.f15837d = t11;
        this.f15838e = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new SingleElementSubscriber(subscriber, this.f15837d, this.f15838e));
    }
}
