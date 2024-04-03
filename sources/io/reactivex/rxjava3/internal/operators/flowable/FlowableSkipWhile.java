package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f20397d;

    public static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20398b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f20399c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20400d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20401e;

        public SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.f20398b = subscriber;
            this.f20399c = predicate;
        }

        public void cancel() {
            this.f20400d.cancel();
        }

        public void onComplete() {
            this.f20398b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20398b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f20401e) {
                this.f20398b.onNext(t11);
                return;
            }
            try {
                if (this.f20399c.test(t11)) {
                    this.f20400d.request(1);
                    return;
                }
                this.f20401e = true;
                this.f20398b.onNext(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20400d.cancel();
                this.f20398b.onError(th2);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20400d, subscription)) {
                this.f20400d = subscription;
                this.f20398b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20400d.request(j11);
        }
    }

    public FlowableSkipWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f20397d = predicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new SkipWhileSubscriber(subscriber, this.f20397d));
    }
}
