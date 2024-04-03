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

public final class BoundedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f18561b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f18562c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f18563d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Subscription> f18564e;

    /* renamed from: f  reason: collision with root package name */
    public final int f18565f;

    /* renamed from: g  reason: collision with root package name */
    public int f18566g;

    /* renamed from: h  reason: collision with root package name */
    public final int f18567h;

    public BoundedSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3, int i11) {
        this.f18561b = consumer;
        this.f18562c = consumer2;
        this.f18563d = action;
        this.f18564e = consumer3;
        this.f18565f = i11;
        this.f18567h = i11 - (i11 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.f18562c != Functions.ON_ERROR_MISSING;
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
                this.f18563d.run();
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
                this.f18562c.accept(th2);
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
                this.f18561b.accept(t11);
                int i11 = this.f18566g + 1;
                if (i11 == this.f18567h) {
                    this.f18566g = 0;
                    ((Subscription) get()).request((long) this.f18567h);
                    return;
                }
                this.f18566g = i11;
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
                this.f18564e.accept(this);
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
