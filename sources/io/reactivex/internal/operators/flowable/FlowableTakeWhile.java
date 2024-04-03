package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeWhile<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f15975d;

    public static final class TakeWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15976b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f15977c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15978d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15979e;

        public TakeWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.f15976b = subscriber;
            this.f15977c = predicate;
        }

        public void cancel() {
            this.f15978d.cancel();
        }

        public void onComplete() {
            if (!this.f15979e) {
                this.f15979e = true;
                this.f15976b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15979e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f15979e = true;
            this.f15976b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f15979e) {
                try {
                    if (!this.f15977c.test(t11)) {
                        this.f15979e = true;
                        this.f15978d.cancel();
                        this.f15976b.onComplete();
                        return;
                    }
                    this.f15976b.onNext(t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f15978d.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15978d, subscription)) {
                this.f15978d = subscription;
                this.f15976b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15978d.request(j11);
        }
    }

    public FlowableTakeWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f15975d = predicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new TakeWhileSubscriber(subscriber, this.f15975d));
    }
}
