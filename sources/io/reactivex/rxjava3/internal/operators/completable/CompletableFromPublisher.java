package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableFromPublisher<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Publisher<T> f19148b;

    public static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19149b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f19150c;

        public FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.f19149b = completableObserver;
        }

        public void dispose() {
            this.f19150c.cancel();
            this.f19150c = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f19150c == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f19149b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f19149b.onError(th2);
        }

        public void onNext(T t11) {
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19150c, subscription)) {
                this.f19150c = subscription;
                this.f19149b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.f19148b = publisher;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f19148b.subscribe(new FromPublisherSubscriber(completableObserver));
    }
}
