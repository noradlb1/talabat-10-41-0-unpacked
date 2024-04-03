package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAll<T> extends AbstractFlowableWithUpstream<T, Boolean> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f19281d;

    public static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3521127104134758517L;

        /* renamed from: d  reason: collision with root package name */
        public final Predicate<? super T> f19282d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f19283e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f19284f;

        public AllSubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f19282d = predicate;
        }

        public void cancel() {
            super.cancel();
            this.f19283e.cancel();
        }

        public void onComplete() {
            if (!this.f19284f) {
                this.f19284f = true;
                complete(Boolean.TRUE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f19284f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19284f = true;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19284f) {
                try {
                    if (!this.f19282d.test(t11)) {
                        this.f19284f = true;
                        this.f19283e.cancel();
                        complete(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19283e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19283e, subscription)) {
                this.f19283e = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableAll(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f19281d = predicate;
    }

    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.f19260c.subscribe(new AllSubscriber(subscriber, this.f19281d));
    }
}
