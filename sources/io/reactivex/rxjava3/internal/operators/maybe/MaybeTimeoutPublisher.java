package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class MaybeTimeoutPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Publisher<U> f21052c;

    /* renamed from: d  reason: collision with root package name */
    public final MaybeSource<? extends T> f21053d;

    public static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21054b;

        public TimeoutFallbackMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.f21054b = maybeObserver;
        }

        public void onComplete() {
            this.f21054b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21054b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f21054b.onSuccess(t11);
        }
    }

    public static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -5955289211445418871L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21055b;

        /* renamed from: c  reason: collision with root package name */
        public final TimeoutOtherMaybeObserver<T, U> f21056c = new TimeoutOtherMaybeObserver<>(this);

        /* renamed from: d  reason: collision with root package name */
        public final MaybeSource<? extends T> f21057d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeoutFallbackMaybeObserver<T> f21058e;

        public TimeoutMainMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver;
            this.f21055b = maybeObserver;
            this.f21057d = maybeSource;
            if (maybeSource != null) {
                timeoutFallbackMaybeObserver = new TimeoutFallbackMaybeObserver<>(maybeObserver);
            } else {
                timeoutFallbackMaybeObserver = null;
            }
            this.f21058e = timeoutFallbackMaybeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.f21056c);
            TimeoutFallbackMaybeObserver<T> timeoutFallbackMaybeObserver = this.f21058e;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.dispose(timeoutFallbackMaybeObserver);
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            SubscriptionHelper.cancel(this.f21056c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f21055b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            SubscriptionHelper.cancel(this.f21056c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f21055b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            SubscriptionHelper.cancel(this.f21056c);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f21055b.onSuccess(t11);
            }
        }

        public void otherComplete() {
            if (DisposableHelper.dispose(this)) {
                MaybeSource<? extends T> maybeSource = this.f21057d;
                if (maybeSource == null) {
                    this.f21055b.onError(new TimeoutException());
                } else {
                    maybeSource.subscribe(this.f21058e);
                }
            }
        }

        public void otherError(Throwable th2) {
            if (DisposableHelper.dispose(this)) {
                this.f21055b.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutMainMaybeObserver<T, U> f21059b;

        public TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver<T, U> timeoutMainMaybeObserver) {
            this.f21059b = timeoutMainMaybeObserver;
        }

        public void onComplete() {
            this.f21059b.otherComplete();
        }

        public void onError(Throwable th2) {
            this.f21059b.otherError(th2);
        }

        public void onNext(Object obj) {
            ((Subscription) get()).cancel();
            this.f21059b.otherComplete();
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public MaybeTimeoutPublisher(MaybeSource<T> maybeSource, Publisher<U> publisher, MaybeSource<? extends T> maybeSource2) {
        super(maybeSource);
        this.f21052c = publisher;
        this.f21053d = maybeSource2;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.f21053d);
        maybeObserver.onSubscribe(timeoutMainMaybeObserver);
        this.f21052c.subscribe(timeoutMainMaybeObserver.f21056c);
        this.f20763b.subscribe(timeoutMainMaybeObserver);
    }
}
