package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableLastSingle<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f19980b;

    /* renamed from: c  reason: collision with root package name */
    public final T f19981c;

    public static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f19982b;

        /* renamed from: c  reason: collision with root package name */
        public final T f19983c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f19984d;

        /* renamed from: e  reason: collision with root package name */
        public T f19985e;

        public LastSubscriber(SingleObserver<? super T> singleObserver, T t11) {
            this.f19982b = singleObserver;
            this.f19983c = t11;
        }

        public void dispose() {
            this.f19984d.cancel();
            this.f19984d = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19984d == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19984d = SubscriptionHelper.CANCELLED;
            T t11 = this.f19985e;
            if (t11 != null) {
                this.f19985e = null;
                this.f19982b.onSuccess(t11);
                return;
            }
            T t12 = this.f19983c;
            if (t12 != null) {
                this.f19982b.onSuccess(t12);
            } else {
                this.f19982b.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            this.f19984d = SubscriptionHelper.CANCELLED;
            this.f19985e = null;
            this.f19982b.onError(th2);
        }

        public void onNext(T t11) {
            this.f19985e = t11;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19984d, subscription)) {
                this.f19984d = subscription;
                this.f19982b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableLastSingle(Publisher<T> publisher, T t11) {
        this.f19980b = publisher;
        this.f19981c = t11;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f19980b.subscribe(new LastSubscriber(singleObserver, this.f19981c));
    }
}
