package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleTakeUntil<T, U> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f18397b;

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f18398c;

    public static final class TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -622603812305745221L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18399b;

        /* renamed from: c  reason: collision with root package name */
        public final TakeUntilOtherSubscriber f18400c = new TakeUntilOtherSubscriber(this);

        public TakeUntilMainObserver(SingleObserver<? super T> singleObserver) {
            this.f18399b = singleObserver;
        }

        public void a(Throwable th2) {
            Disposable disposable;
            Disposable disposable2 = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable2 == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (disposable != null) {
                disposable.dispose();
            }
            this.f18399b.onError(th2);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f18400c.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            this.f18400c.dispose();
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || ((Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f18399b.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f18400c.dispose();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (((Disposable) getAndSet(disposableHelper)) != disposableHelper) {
                this.f18399b.onSuccess(t11);
            }
        }
    }

    public static final class TakeUntilOtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 5170026210238877381L;

        /* renamed from: b  reason: collision with root package name */
        public final TakeUntilMainObserver<?> f18401b;

        public TakeUntilOtherSubscriber(TakeUntilMainObserver<?> takeUntilMainObserver) {
            this.f18401b = takeUntilMainObserver;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f18401b.a(new CancellationException());
            }
        }

        public void onError(Throwable th2) {
            this.f18401b.a(th2);
        }

        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.f18401b.a(new CancellationException());
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public SingleTakeUntil(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f18397b = singleSource;
        this.f18398c = publisher;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(singleObserver);
        singleObserver.onSubscribe(takeUntilMainObserver);
        this.f18398c.subscribe(takeUntilMainObserver.f18400c);
        this.f18397b.subscribe(takeUntilMainObserver);
    }
}
