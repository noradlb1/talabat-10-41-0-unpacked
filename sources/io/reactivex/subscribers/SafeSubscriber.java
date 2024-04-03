package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: b  reason: collision with root package name */
    public final Subscriber<? super T> f23671b;

    /* renamed from: c  reason: collision with root package name */
    public Subscription f23672c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23673d;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        this.f23671b = subscriber;
    }

    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f23671b.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f23671b.onError(nullPointerException);
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
        this.f23673d = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f23671b.onSubscribe(EmptySubscription.INSTANCE);
            try {
                this.f23671b.onError(nullPointerException);
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
            this.f23672c.cancel();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }

    public void onComplete() {
        if (!this.f23673d) {
            this.f23673d = true;
            if (this.f23672c == null) {
                a();
                return;
            }
            try {
                this.f23671b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.f23673d) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23673d = true;
        if (this.f23672c == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f23671b.onSubscribe(EmptySubscription.INSTANCE);
                try {
                    this.f23671b.onError(new CompositeException(th2, nullPointerException));
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
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f23671b.onError(th2);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                RxJavaPlugins.onError(new CompositeException(th2, th5));
            }
        }
    }

    public void onNext(T t11) {
        if (!this.f23673d) {
            if (this.f23672c == null) {
                b();
            } else if (t11 == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f23672c.cancel();
                    onError(nullPointerException);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(new CompositeException(nullPointerException, th2));
                }
            } else {
                try {
                    this.f23671b.onNext(t11);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    onError(new CompositeException(th, th3));
                }
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f23672c, subscription)) {
            this.f23672c = subscription;
            try {
                this.f23671b.onSubscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(new CompositeException(th, th2));
            }
        }
    }

    public void request(long j11) {
        try {
            this.f23672c.request(j11);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(th, th2));
        }
    }
}
