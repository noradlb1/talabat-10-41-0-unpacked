package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final T f20347d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f20348e;

    public static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5526049321428043809L;

        /* renamed from: d  reason: collision with root package name */
        public final T f20349d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f20350e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f20351f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f20352g;

        public SingleElementSubscriber(Subscriber<? super T> subscriber, T t11, boolean z11) {
            super(subscriber);
            this.f20349d = t11;
            this.f20350e = z11;
        }

        public void cancel() {
            super.cancel();
            this.f20351f.cancel();
        }

        public void onComplete() {
            if (!this.f20352g) {
                this.f20352g = true;
                T t11 = this.f23171c;
                this.f23171c = null;
                if (t11 == null) {
                    t11 = this.f20349d;
                }
                if (t11 != null) {
                    complete(t11);
                } else if (this.f20350e) {
                    this.f23170b.onError(new NoSuchElementException());
                } else {
                    this.f23170b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f20352g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20352g = true;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20352g) {
                if (this.f23171c != null) {
                    this.f20352g = true;
                    this.f20351f.cancel();
                    this.f23170b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f23171c = t11;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20351f, subscription)) {
                this.f20351f = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSingle(Flowable<T> flowable, T t11, boolean z11) {
        super(flowable);
        this.f20347d = t11;
        this.f20348e = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new SingleElementSubscriber(subscriber, this.f20347d, this.f20348e));
    }
}
