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

public final class FlowableAny<T> extends AbstractFlowableWithUpstream<T, Boolean> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f19301d;

    public static final class AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2311252482644620661L;

        /* renamed from: d  reason: collision with root package name */
        public final Predicate<? super T> f19302d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f19303e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f19304f;

        public AnySubscriber(Subscriber<? super Boolean> subscriber, Predicate<? super T> predicate) {
            super(subscriber);
            this.f19302d = predicate;
        }

        public void cancel() {
            super.cancel();
            this.f19303e.cancel();
        }

        public void onComplete() {
            if (!this.f19304f) {
                this.f19304f = true;
                complete(Boolean.FALSE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f19304f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f19304f = true;
            this.f23170b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f19304f) {
                try {
                    if (this.f19302d.test(t11)) {
                        this.f19304f = true;
                        this.f19303e.cancel();
                        complete(Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19303e.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19303e, subscription)) {
                this.f19303e = subscription;
                this.f23170b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableAny(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f19301d = predicate;
    }

    public void subscribeActual(Subscriber<? super Boolean> subscriber) {
        this.f19260c.subscribe(new AnySubscriber(subscriber, this.f19301d));
    }
}
