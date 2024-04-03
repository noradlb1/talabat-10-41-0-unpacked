package io.reactivex.internal.operators.observable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class ObservableFromPublisher<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends T> f17269b;

    public static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17270b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f17271c;

        public PublisherSubscriber(Observer<? super T> observer) {
            this.f17270b = observer;
        }

        public void dispose() {
            this.f17271c.cancel();
            this.f17271c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f17271c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f17270b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17270b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17270b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f17271c, subscription)) {
                this.f17271c = subscription;
                this.f17270b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.f17269b = publisher;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f17269b.subscribe(new PublisherSubscriber(observer));
    }
}
