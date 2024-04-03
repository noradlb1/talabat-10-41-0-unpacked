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

public final class LambdaSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f23145b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f23146c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f23147d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Subscription> f23148e;

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        this.f23145b = consumer;
        this.f23146c = consumer2;
        this.f23147d = action;
        this.f23148e = consumer3;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.f23146c != Functions.ON_ERROR_MISSING;
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
                this.f23147d.run();
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
                this.f23146c.accept(th2);
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
                this.f23145b.accept(t11);
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
                this.f23148e.accept(this);
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
