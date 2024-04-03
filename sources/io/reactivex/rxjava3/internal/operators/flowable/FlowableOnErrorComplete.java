package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnErrorComplete<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super Throwable> f20100d;

    public static final class OnErrorCompleteSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20101b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super Throwable> f20102c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20103d;

        public OnErrorCompleteSubscriber(Subscriber<? super T> subscriber, Predicate<? super Throwable> predicate) {
            this.f20101b = subscriber;
            this.f20102c = predicate;
        }

        public void cancel() {
            this.f20103d.cancel();
        }

        public void onComplete() {
            this.f20101b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                if (this.f20102c.test(th2)) {
                    this.f20101b.onComplete();
                } else {
                    this.f20101b.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f20101b.onError(new CompositeException(th2, th3));
            }
        }

        public void onNext(T t11) {
            this.f20101b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20103d, subscription)) {
                this.f20103d = subscription;
                this.f20101b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20103d.request(j11);
        }
    }

    public FlowableOnErrorComplete(Flowable<T> flowable, Predicate<? super Throwable> predicate) {
        super(flowable);
        this.f20100d = predicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new OnErrorCompleteSubscriber(subscriber, this.f20100d));
    }
}
