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

public final class FlowableAny<T> extends AbstractFlowableWithUpstream<T, Boolean> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f14804d;

    public static final class AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2311252482644620661L;

        /* renamed from: d  reason: collision with root package name */
        public final Predicate<? super T> f14805d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f14806e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f14807f;

        public AnySubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f14805d = predicate;
        }

        public void cancel() {
            super.cancel();
            this.f14806e.cancel();
        }

        public void onComplete() {
            if (!this.f14807f) {
                this.f14807f = true;
                complete(Boolean.FALSE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f14807f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f14807f = true;
            this.f18609b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f14807f) {
                try {
                    if (this.f14805d.test(t11)) {
                        this.f14807f = true;
                        this.f14806e.cancel();
                        complete(Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14806e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14806e, subscription)) {
                this.f14806e = subscription;
                this.f18609b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableAny(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f14804d = predicate;
    }

    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.f14763c.subscribe(new AnySubscriber(subscriber, this.f14804d));
    }
}
