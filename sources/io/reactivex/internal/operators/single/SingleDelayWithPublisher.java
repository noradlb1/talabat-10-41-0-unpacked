package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleDelayWithPublisher<T, U> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18256b;

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f18257c;

    public static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18258b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<T> f18259c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f18260d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f18261e;

        public OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f18258b = singleObserver;
            this.f18259c = singleSource;
        }

        public void dispose() {
            this.f18261e.cancel();
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (!this.f18260d) {
                this.f18260d = true;
                this.f18259c.subscribe(new ResumeSingleObserver(this, this.f18258b));
            }
        }

        public void onError(Throwable th2) {
            if (this.f18260d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18260d = true;
            this.f18258b.onError(th2);
        }

        public void onNext(U u11) {
            this.f18261e.cancel();
            onComplete();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18261e, subscription)) {
                this.f18261e = subscription;
                this.f18258b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public SingleDelayWithPublisher(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f18256b = singleSource;
        this.f18257c = publisher;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18257c.subscribe(new OtherSubscriber(singleObserver, this.f18256b));
    }
}
