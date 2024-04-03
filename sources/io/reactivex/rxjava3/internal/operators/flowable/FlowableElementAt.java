package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableElementAt<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f19675d;

    /* renamed from: e  reason: collision with root package name */
    public final T f19676e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f19677f;

    public static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4066607327284737757L;

        /* renamed from: d  reason: collision with root package name */
        public final long f19678d;

        /* renamed from: e  reason: collision with root package name */
        public final T f19679e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f19680f;

        /* renamed from: g  reason: collision with root package name */
        public Subscription f19681g;

        /* renamed from: h  reason: collision with root package name */
        public long f19682h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f19683i;

        public ElementAtSubscriber(Subscriber<? super T> subscriber, long j11, T t11, boolean z11) {
            super(subscriber);
            this.f19678d = j11;
            this.f19679e = t11;
            this.f19680f = z11;
        }

        public void cancel() {
            super.cancel();
            this.f19681g.cancel();
        }

        public void onComplete() {
            if (!this.f19683i) {
                this.f19683i = true;
                T t11 = this.f19679e;
                if (t11 != null) {
                    complete(t11);
                } else if (this.f19680f) {
                    this.f23170b.onError(new NoSuchElementException());
                } else {
                    this.f23170b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f19683i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19683i = true;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19683i) {
                long j11 = this.f19682h;
                if (j11 == this.f19678d) {
                    this.f19683i = true;
                    this.f19681g.cancel();
                    complete(t11);
                    return;
                }
                this.f19682h = j11 + 1;
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19681g, subscription)) {
                this.f19681g = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableElementAt(Flowable<T> flowable, long j11, T t11, boolean z11) {
        super(flowable);
        this.f19675d = j11;
        this.f19676e = t11;
        this.f19677f = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new ElementAtSubscriber(subscriber, this.f19675d, this.f19676e, this.f19677f));
    }
}
