package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableAll<T> extends AbstractFlowableWithUpstream<T, Boolean> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f14784d;

    public static final class AllSubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3521127104134758517L;

        /* renamed from: d  reason: collision with root package name */
        public final Predicate<? super T> f14785d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f14786e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f14787f;

        public AllSubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f14785d = predicate;
        }

        public void cancel() {
            super.cancel();
            this.f14786e.cancel();
        }

        public void onComplete() {
            if (!this.f14787f) {
                this.f14787f = true;
                complete(Boolean.TRUE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f14787f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14787f = true;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14787f) {
                try {
                    if (!this.f14785d.test(t11)) {
                        this.f14787f = true;
                        this.f14786e.cancel();
                        complete(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14786e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14786e, subscription)) {
                this.f14786e = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableAll(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f14784d = predicate;
    }

    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.f14763c.subscribe(new AllSubscriber(subscriber, this.f14784d));
    }
}
