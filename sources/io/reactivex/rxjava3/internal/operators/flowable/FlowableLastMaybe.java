package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f19976b;

    public static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f19977b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f19978c;

        /* renamed from: d  reason: collision with root package name */
        public T f19979d;

        public LastSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.f19977b = maybeObserver;
        }

        public void dispose() {
            this.f19978c.cancel();
            this.f19978c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19978c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19978c = SubscriptionHelper.CANCELLED;
            T t11 = this.f19979d;
            if (t11 != null) {
                this.f19979d = null;
                this.f19977b.onSuccess(t11);
                return;
            }
            this.f19977b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19978c = SubscriptionHelper.CANCELLED;
            this.f19979d = null;
            this.f19977b.onError(th2);
        }

        public void onNext(T t11) {
            this.f19979d = t11;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19978c, subscription)) {
                this.f19978c = subscription;
                this.f19977b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableLastMaybe(Publisher<T> publisher) {
        this.f19976b = publisher;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f19976b.subscribe(new LastSubscriber(maybeObserver));
    }
}
