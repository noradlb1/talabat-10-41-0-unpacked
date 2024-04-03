package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeUntilPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f20478d;

    public static final class InnerSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20479b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f20480c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20481d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20482e;

        public InnerSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.f20479b = subscriber;
            this.f20480c = predicate;
        }

        public void cancel() {
            this.f20481d.cancel();
        }

        public void onComplete() {
            if (!this.f20482e) {
                this.f20482e = true;
                this.f20479b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f20482e) {
                this.f20482e = true;
                this.f20479b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20482e) {
                this.f20479b.onNext(t11);
                try {
                    if (this.f20480c.test(t11)) {
                        this.f20482e = true;
                        this.f20481d.cancel();
                        this.f20479b.onComplete();
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20481d.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20481d, subscription)) {
                this.f20481d = subscription;
                this.f20479b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20481d.request(j11);
        }
    }

    public FlowableTakeUntilPredicate(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f20478d = predicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new InnerSubscriber(subscriber, this.f20478d));
    }
}
