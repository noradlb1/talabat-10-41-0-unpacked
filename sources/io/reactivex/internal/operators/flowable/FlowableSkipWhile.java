package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f15887d;

    public static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15888b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f15889c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15890d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15891e;

        public SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.f15888b = subscriber;
            this.f15889c = predicate;
        }

        public void cancel() {
            this.f15890d.cancel();
        }

        public void onComplete() {
            this.f15888b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15888b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f15891e) {
                this.f15888b.onNext(t11);
                return;
            }
            try {
                if (this.f15889c.test(t11)) {
                    this.f15890d.request(1);
                    return;
                }
                this.f15891e = true;
                this.f15888b.onNext(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f15890d.cancel();
                this.f15888b.onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15890d, subscription)) {
                this.f15890d = subscription;
                this.f15888b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f15890d.request(j11);
        }
    }

    public FlowableSkipWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f15887d = predicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f14763c.subscribe(new SkipWhileSubscriber(subscriber, this.f15887d));
    }
}
