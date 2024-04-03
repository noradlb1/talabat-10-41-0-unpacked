package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f15453b;

    /* renamed from: c  reason: collision with root package name */
    public final T f15454c;

    public static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f15455b;

        /* renamed from: c  reason: collision with root package name */
        public final T f15456c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f15457d;

        /* renamed from: e  reason: collision with root package name */
        public T f15458e;

        public LastSubscriber(SingleObserver<? super T> singleObserver, T t11) {
            this.f15455b = singleObserver;
            this.f15456c = t11;
        }

        public void dispose() {
            this.f15457d.cancel();
            this.f15457d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f15457d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f15457d = SubscriptionHelper.CANCELLED;
            T t11 = this.f15458e;
            if (t11 != null) {
                this.f15458e = null;
                this.f15455b.onSuccess(t11);
                return;
            }
            T t12 = this.f15456c;
            if (t12 != null) {
                this.f15455b.onSuccess(t12);
            } else {
                this.f15455b.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            this.f15457d = SubscriptionHelper.CANCELLED;
            this.f15458e = null;
            this.f15455b.onError(th2);
        }

        public void onNext(T t11) {
            this.f15458e = t11;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15457d, subscription)) {
                this.f15457d = subscription;
                this.f15455b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableLastSingle(Publisher<T> publisher, T t11) {
        this.f15453b = publisher;
        this.f15454c = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f15453b.subscribe(new LastSubscriber(singleObserver, this.f15454c));
    }
}
