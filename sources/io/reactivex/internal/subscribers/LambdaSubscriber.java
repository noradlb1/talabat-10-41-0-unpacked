package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class LambdaSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f18584b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f18585c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f18586d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Subscription> f18587e;

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        this.f18584b = consumer;
        this.f18585c = consumer2;
        this.f18586d = action;
        this.f18587e = consumer3;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.f18585c != Functions.ON_ERROR_MISSING;
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
                this.f18586d.run();
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
                this.f18585c.accept(th2);
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
                this.f18584b.accept(t11);
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
                this.f18587e.accept(this);
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
