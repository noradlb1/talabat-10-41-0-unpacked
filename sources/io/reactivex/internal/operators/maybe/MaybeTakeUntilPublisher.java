package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeTakeUntilPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f16527c;

    public static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16528b;

        /* renamed from: c  reason: collision with root package name */
        public final TakeUntilOtherMaybeObserver<U> f16529c = new TakeUntilOtherMaybeObserver<>(this);

        public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Subscription> implements FlowableSubscriber<U> {
            private static final long serialVersionUID = -1266041316834525931L;

            /* renamed from: b  reason: collision with root package name */
            public final TakeUntilMainMaybeObserver<?, U> f16530b;

            public TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.f16530b = takeUntilMainMaybeObserver;
            }

            public void onComplete() {
                this.f16530b.a();
            }

            public void onError(Throwable th2) {
                this.f16530b.b(th2);
            }

            public void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                this.f16530b.a();
            }

            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public TakeUntilMainMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16528b = maybeObserver;
        }

        public void a() {
            if (DisposableHelper.dispose(this)) {
                this.f16528b.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (DisposableHelper.dispose(this)) {
                this.f16528b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.f16529c);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f16529c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16528b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f16529c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16528b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            SubscriptionHelper.cancel(this.f16529c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16528b.onSuccess(t11);
            }
        }
    }

    public MaybeTakeUntilPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f16527c = publisher;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(takeUntilMainMaybeObserver);
        this.f16527c.subscribe(takeUntilMainMaybeObserver.f16529c);
        this.f16264b.subscribe(takeUntilMainMaybeObserver);
    }
}
