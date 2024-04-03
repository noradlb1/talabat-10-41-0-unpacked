package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeTimeoutPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f16539c;

    /* renamed from: d  reason: collision with root package name */
    public final MaybeSource<? extends T> f16540d;

    public static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16541b;

        public TimeoutFallbackMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f16541b = maybeObserver;
        }

        public void onComplete() {
            this.f16541b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16541b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f16541b.onSuccess(t11);
        }
    }

    public static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -5955289211445418871L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16542b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeoutOtherMaybeObserver<T, U> f16543c = new TimeoutOtherMaybeObserver<>(this);

        /* renamed from: d  reason: collision with root package name */
        public final MaybeSource<? extends T> f16544d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeoutFallbackMaybeObserver<T> f16545e;

        public TimeoutMainMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver;
            this.f16542b = maybeObserver;
            this.f16544d = maybeSource;
            if (maybeSource != null) {
                timeoutFallbackMaybeObserver = new TimeoutFallbackMaybeObserver<>(maybeObserver);
            } else {
                timeoutFallbackMaybeObserver = null;
            }
            this.f16545e = timeoutFallbackMaybeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.f16543c);
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver = this.f16545e;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.dispose(timeoutFallbackMaybeObserver);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f16543c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16542b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f16543c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16542b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            SubscriptionHelper.cancel(this.f16543c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f16542b.onSuccess(t11);
            }
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this)) {
                MaybeSource<? extends T> maybeSource = this.f16544d;
                if (maybeSource == null) {
                    this.f16542b.onError(new TimeoutException());
                } else {
                    maybeSource.subscribe(this.f16545e);
                }
            }
        }

        public void otherError(Throwable th2) {
            if (DisposableHelper.dispose(this)) {
                this.f16542b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutMainMaybeObserver<T, U> f16546b;

        public TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.f16546b = timeoutMainMaybeObserver;
        }

        public void onComplete() {
            this.f16546b.otherComplete();
        }

        public void onError(Throwable th2) {
            this.f16546b.otherError(th2);
        }

        public void onNext(Object obj) {
            ((Subscription) get()).cancel();
            this.f16546b.otherComplete();
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public MaybeTimeoutPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.f16539c = publisher;
        this.f16540d = maybeSource2;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.f16540d);
        maybeObserver.onSubscribe(timeoutMainMaybeObserver);
        this.f16539c.subscribe(timeoutMainMaybeObserver.f16543c);
        this.f16264b.subscribe(timeoutMainMaybeObserver);
    }
}
