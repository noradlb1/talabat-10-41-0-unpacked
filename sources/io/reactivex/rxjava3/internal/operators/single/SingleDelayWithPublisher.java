package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleDelayWithPublisher<T, U> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22790b;

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f22791c;

    public static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22792b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleSource<T> f22793c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22794d;

        /* renamed from: e  reason: collision with root package name */
        public Subscription f22795e;

        public OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f22792b = singleObserver;
            this.f22793c = singleSource;
        }

        public void dispose() {
            this.f22795e.cancel();
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            if (!this.f22794d) {
                this.f22794d = true;
                this.f22793c.subscribe(new ResumeSingleObserver(this, this.f22792b));
            }
        }

        public void onError(Throwable th2) {
            if (this.f22794d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22794d = true;
            this.f22792b.onError(th2);
        }

        public void onNext(U u11) {
            this.f22795e.cancel();
            onComplete();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22795e, subscription)) {
                this.f22795e = subscription;
                this.f22792b.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public SingleDelayWithPublisher(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f22790b = singleSource;
        this.f22791c = publisher;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22791c.subscribe(new OtherSubscriber(singleObserver, this.f22790b));
    }
}
