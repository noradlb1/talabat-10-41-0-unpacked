package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class ForEachWhileSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;

    /* renamed from: b  reason: collision with root package name */
    public final Predicate<? super T> f23131b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f23132c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f23133d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23134e;

    public ForEachWhileSubscriber(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.f23131b = predicate;
        this.f23132c = consumer;
        this.f23133d = action;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        if (!this.f23134e) {
            this.f23134e = true;
            try {
                this.f23133d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.f23134e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23134e = true;
        try {
            this.f23132c.accept(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t11) {
        if (!this.f23134e) {
            try {
                if (!this.f23131b.test(t11)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                dispose();
                onError(th2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
