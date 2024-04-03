package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class CompletableAndThenPublisher<R> extends Flowable<R> {

    /* renamed from: c  reason: collision with root package name */
    public final CompletableSource f16588c;

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<? extends R> f16589d;

    public CompletableAndThenPublisher(CompletableSource completableSource, Publisher<? extends R> publisher) {
        this.f16588c = completableSource;
        this.f16589d = publisher;
    }

    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f16588c.subscribe(new AndThenPublisherSubscriber(subscriber, this.f16589d));
    }

    public static final class AndThenPublisherSubscriber<R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, CompletableObserver, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f16590b;

        /* renamed from: c  reason: collision with root package name */
        public Publisher<? extends R> f16591c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16592d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicLong f16593e = new AtomicLong();

        public AndThenPublisherSubscriber(Subscriber<? super R> subscriber, Publisher<? extends R> publisher) {
            this.f16590b = subscriber;
            this.f16591c = publisher;
        }

        public void cancel() {
            this.f16592d.dispose();
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            Publisher<? extends R> publisher = this.f16591c;
            if (publisher == null) {
                this.f16590b.onComplete();
                return;
            }
            this.f16591c = null;
            publisher.subscribe(this);
        }

        public void onError(Throwable th2) {
            this.f16590b.onError(th2);
        }

        public void onNext(R r11) {
            this.f16590b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16592d, disposable)) {
                this.f16592d = disposable;
                this.f16590b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this, this.f16593e, j11);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.f16593e, subscription);
        }
    }
}
