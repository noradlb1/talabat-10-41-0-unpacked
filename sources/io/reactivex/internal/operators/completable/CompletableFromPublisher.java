package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableFromPublisher<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f14663b;

    public static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14664b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f14665c;

        public FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.f14664b = completableObserver;
        }

        public void dispose() {
            this.f14665c.cancel();
            this.f14665c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f14665c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f14664b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14664b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14665c, subscription)) {
                this.f14665c = subscription;
                this.f14664b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.f14663b = publisher;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f14663b.subscribe(new FromPublisherSubscriber(completableObserver));
    }
}
