package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableElementAt<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15169d;

    /* renamed from: e  reason: collision with root package name */
    public final T f15170e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f15171f;

    public static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4066607327284737757L;

        /* renamed from: d  reason: collision with root package name */
        public final long f15172d;

        /* renamed from: e  reason: collision with root package name */
        public final T f15173e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f15174f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f15175g;

        /* renamed from: h  reason: collision with root package name */
        public long f15176h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f15177i;

        public ElementAtSubscriber(Subscriber<? super T> subscriber, long j11, T t11, boolean z11) {
            super(subscriber);
            this.f15172d = j11;
            this.f15173e = t11;
            this.f15174f = z11;
        }

        public void cancel() {
            super.cancel();
            this.f15175g.cancel();
        }

        public void onComplete() {
            if (!this.f15177i) {
                this.f15177i = true;
                T t11 = this.f15173e;
                if (t11 != null) {
                    complete(t11);
                } else if (this.f15174f) {
                    this.f18609b.onError(new NoSuchElementException());
                } else {
                    this.f18609b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f15177i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15177i = true;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15177i) {
                long j11 = this.f15176h;
                if (j11 == this.f15172d) {
                    this.f15177i = true;
                    this.f15175g.cancel();
                    complete(t11);
                    return;
                }
                this.f15176h = j11 + 1;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15175g, subscription)) {
                this.f15175g = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableElementAt(Flowable<T> flowable, long j11, T t11, boolean z11) {
        super(flowable);
        this.f15169d = j11;
        this.f15170e = t11;
        this.f15171f = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new ElementAtSubscriber(subscriber, this.f15169d, this.f15170e, this.f15171f));
    }
}
