package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.DisposableContainer;
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

public final class DisposableAutoReleaseSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = 8924480688481408726L;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<DisposableContainer> f23127b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f23128c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super Throwable> f23129d;

    /* renamed from: e  reason: collision with root package name */
    public final Action f23130e;

    public DisposableAutoReleaseSubscriber(DisposableContainer disposableContainer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        this.f23128c = consumer;
        this.f23129d = consumer2;
        this.f23130e = action;
        this.f23127b = new AtomicReference<>(disposableContainer);
    }

    public void a() {
        DisposableContainer andSet = this.f23127b.getAndSet((Object) null);
        if (andSet != null) {
            andSet.delete(this);
        }
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
        a();
    }

    public boolean hasCustomOnError() {
        return this.f23129d != Functions.ON_ERROR_MISSING;
    }

    public boolean isDisposed() {
        return SubscriptionHelper.CANCELLED == get();
    }

    public void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f23130e.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
        a();
    }

    public void onError(Throwable th2) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f23129d.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th2, th3));
            }
        } else {
            RxJavaPlugins.onError(th2);
        }
        a();
    }

    public void onNext(T t11) {
        if (get() != SubscriptionHelper.CANCELLED) {
            try {
                this.f23128c.accept(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                ((Subscription) get()).cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            subscription.request(Long.MAX_VALUE);
        }
    }
}
