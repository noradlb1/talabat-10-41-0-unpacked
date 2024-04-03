package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeTakeUntilPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f21031c;

    public static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21032b;

        /* renamed from: c  reason: collision with root package name */
        public final TakeUntilOtherMaybeObserver<U> f21033c = new TakeUntilOtherMaybeObserver<>(this);

        public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Subscription> implements FlowableSubscriber<U> {
            private static final long serialVersionUID = -1266041316834525931L;

            /* renamed from: b  reason: collision with root package name */
            public final TakeUntilMainMaybeObserver<?, U> f21034b;

            public TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> takeUntilMainMaybeObserver) {
                this.f21034b = takeUntilMainMaybeObserver;
            }

            public void onComplete() {
                this.f21034b.a();
            }

            public void onError(Throwable th2) {
                this.f21034b.b(th2);
            }

            public void onNext(Object obj) {
                SubscriptionHelper.cancel(this);
                this.f21034b.a();
            }

            public void onSubscribe(Subscription subscription) {
                SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
            }
        }

        public TakeUntilMainMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f21032b = maybeObserver;
        }

        public void a() {
            if (DisposableHelper.dispose(this)) {
                this.f21032b.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (DisposableHelper.dispose(this)) {
                this.f21032b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.f21033c);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f21033c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f21032b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f21033c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f21032b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            SubscriptionHelper.cancel(this.f21033c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f21032b.onSuccess(t11);
            }
        }
    }

    public MaybeTakeUntilPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher) {
        super(maybeSource);
        this.f21031c = publisher;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(takeUntilMainMaybeObserver);
        this.f21031c.subscribe(takeUntilMainMaybeObserver.f21033c);
        this.f20763b.subscribe(takeUntilMainMaybeObserver);
    }
}
