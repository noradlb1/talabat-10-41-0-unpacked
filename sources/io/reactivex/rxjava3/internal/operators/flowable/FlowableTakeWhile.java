package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTakeWhile<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Predicate<? super T> f20483d;

    public static final class TakeWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20484b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f20485c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f20486d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20487e;

        public TakeWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            this.f20484b = subscriber;
            this.f20485c = predicate;
        }

        public void cancel() {
            this.f20486d.cancel();
        }

        public void onComplete() {
            if (!this.f20487e) {
                this.f20487e = true;
                this.f20484b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20487e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f20487e = true;
            this.f20484b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f20487e) {
                try {
                    if (!this.f20485c.test(t11)) {
                        this.f20487e = true;
                        this.f20486d.cancel();
                        this.f20484b.onComplete();
                        return;
                    }
                    this.f20484b.onNext(t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f20486d.cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20486d, subscription)) {
                this.f20486d = subscription;
                this.f20484b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20486d.request(j11);
        }
    }

    public FlowableTakeWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f20483d = predicate;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f19260c.subscribe(new TakeWhileSubscriber(subscriber, this.f20483d));
    }
}
