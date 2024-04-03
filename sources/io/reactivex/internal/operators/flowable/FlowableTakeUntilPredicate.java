package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntilPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f15970d;

    public static final class InnerSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15971b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f15972c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15973d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15974e;

        public InnerSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.f15971b = subscriber;
            this.f15972c = predicate;
        }

        public void cancel() {
            this.f15973d.cancel();
        }

        public void onComplete() {
            if (!this.f15974e) {
                this.f15974e = true;
                this.f15971b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f15974e) {
                this.f15974e = true;
                this.f15971b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15974e) {
                this.f15971b.onNext(t11);
                try {
                    if (this.f15972c.test(t11)) {
                        this.f15974e = true;
                        this.f15973d.cancel();
                        this.f15971b.onComplete();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f15973d.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15973d, subscription)) {
                this.f15973d = subscription;
                this.f15971b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15973d.request(j11);
        }
    }

    public FlowableTakeUntilPredicate(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f15970d = predicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new InnerSubscriber(subscriber, this.f15970d));
    }
}
