package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class ObservableFromPublisher<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<? extends T> f21800b;

    public static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21801b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f21802c;

        public PublisherSubscriber(Observer<? super T> observer) {
            this.f21801b = observer;
        }

        public void dispose() {
            this.f21802c.cancel();
            this.f21802c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f21802c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f21801b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21801b.onError(th2);
        }

        public void onNext(T t11) {
            this.f21801b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f21802c, subscription)) {
                this.f21802c = subscription;
                this.f21801b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.f21800b = publisher;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21800b.subscribe(new PublisherSubscriber(observer));
    }
}
