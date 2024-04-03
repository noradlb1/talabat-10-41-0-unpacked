package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class CompletableAndThenPublisher<R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f21101c;

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends R> f21102d;

    public CompletableAndThenPublisher(CompletableSource completableSource, Publisher<? extends R> publisher) {
        this.f21101c = completableSource;
        this.f21102d = publisher;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f21101c.subscribe(new AndThenPublisherSubscriber(subscriber, this.f21102d));
    }

    public static final class AndThenPublisherSubscriber<R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, CompletableObserver, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f21103b;

        /* renamed from: c  reason: collision with root package name */
        public Publisher<? extends R> f21104c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21105d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f21106e = new AtomicLong();

        public AndThenPublisherSubscriber(Subscriber<? super R> subscriber, Publisher<? extends R> publisher) {
            this.f21103b = subscriber;
            this.f21104c = publisher;
        }

        public void cancel() {
            this.f21105d.dispose();
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            Publisher<? extends R> publisher = this.f21104c;
            if (publisher == null) {
                this.f21103b.onComplete();
                return;
            }
            this.f21104c = null;
            publisher.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f21103b.onError(th2);
        }

        public void onNext(R r11) {
            this.f21103b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21105d, disposable)) {
                this.f21105d = disposable;
                this.f21103b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this, this.f21106e, j11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.f21106e, subscription);
        }
    }
}
