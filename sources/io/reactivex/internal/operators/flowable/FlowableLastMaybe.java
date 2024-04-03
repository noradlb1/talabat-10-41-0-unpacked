package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f15449b;

    public static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f15450b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f15451c;

        /* renamed from: d  reason: collision with root package name */
        public T f15452d;

        public LastSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.f15450b = maybeObserver;
        }

        public void dispose() {
            this.f15451c.cancel();
            this.f15451c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f15451c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f15451c = SubscriptionHelper.CANCELLED;
            T t11 = this.f15452d;
            if (t11 != null) {
                this.f15452d = null;
                this.f15450b.onSuccess(t11);
                return;
            }
            this.f15450b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f15451c = SubscriptionHelper.CANCELLED;
            this.f15452d = null;
            this.f15450b.onError(th2);
        }

        public void onNext(T t11) {
            this.f15452d = t11;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15451c, subscription)) {
                this.f15451c = subscription;
                this.f15450b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableLastMaybe(Publisher<T> publisher) {
        this.f15449b = publisher;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f15449b.subscribe(new LastSubscriber(maybeObserver));
    }
}
