package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class BoundedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f23118b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f23119c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f23120d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Subscription> f23121e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23122f;

    /* renamed from: g  reason: collision with root package name */
    public int f23123g;

    /* renamed from: h  reason: collision with root package name */
    public final int f23124h;

    public BoundedSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3, int i11) {
        this.f23118b = consumer;
        this.f23119c = consumer2;
        this.f23120d = action;
        this.f23121e = consumer3;
        this.f23122f = i11;
        this.f23124h = i11 - (i11 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.f23119c != Functions.ON_ERROR_MISSING;
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f23120d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f23119c.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th2, th3));
            }
        } else {
            RxJavaPlugins.onError(th2);
        }
    }

    public void onNext(T t11) {
        if (!isDisposed()) {
            try {
                this.f23118b.accept(t11);
                int i11 = this.f23123g + 1;
                if (i11 == this.f23124h) {
                    this.f23123g = 0;
                    ((Subscription) get()).request((long) this.f23124h);
                    return;
                }
                this.f23123g = i11;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                ((Subscription) get()).cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            try {
                this.f23121e.accept(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                subscription.cancel();
                onError(th2);
            }
        }
    }

    public void request(long j11) {
        ((Subscription) get()).request(j11);
    }
}
