package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f23476b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f23477c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23478d;

    public SafeSubscriber(@NonNull Subscriber<? super T> subscriber) {
        this.f23476b = subscriber;
    }

    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f23476b.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f23476b.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th3));
        }
    }

    public void b() {
        this.f23478d = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f23476b.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f23476b.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th3));
        }
    }

    public void cancel() {
        try {
            this.f23477c.cancel();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }

    public void onComplete() {
        if (!this.f23478d) {
            this.f23478d = true;
            if (this.f23477c == null) {
                a();
                return;
            }
            try {
                this.f23476b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(@NonNull Throwable th2) {
        if (this.f23478d) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23478d = true;
        if (this.f23477c == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f23476b.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    this.f23476b.onError(new CompositeException(th2, nullPointerException));
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    RxJavaPlugins.onError(new CompositeException(th2, nullPointerException, th3));
                }
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(new CompositeException(th2, nullPointerException, th4));
            }
        } else {
            if (th2 == null) {
                th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            try {
                this.f23476b.onError(th2);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                RxJavaPlugins.onError(new CompositeException(th2, th5));
            }
        }
    }

    public void onNext(@NonNull T t11) {
        if (!this.f23478d) {
            if (this.f23477c == null) {
                b();
            } else if (t11 == null) {
                NullPointerException createNullPointerException = ExceptionHelper.createNullPointerException("onNext called with a null Throwable.");
                try {
                    this.f23477c.cancel();
                    onError(createNullPointerException);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(new CompositeException(createNullPointerException, th2));
                }
            } else {
                try {
                    this.f23476b.onNext(t11);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    onError(new CompositeException(th, th3));
                }
            }
        }
    }

    public void onSubscribe(@NonNull Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23477c, subscription)) {
            this.f23477c = subscription;
            try {
                this.f23476b.onSubscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        }
    }

    public void request(long j11) {
        try {
            this.f23477c.request(j11);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }
}
