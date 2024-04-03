package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class ForEachWhileSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;

    /* renamed from: b  reason: collision with root package name */
    public final Predicate<? super T> f18570b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Throwable> f18571c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f18572d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18573e;

    public ForEachWhileSubscriber(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        this.f18570b = predicate;
        this.f18571c = consumer;
        this.f18572d = action;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        if (!this.f18573e) {
            this.f18573e = true;
            try {
                this.f18572d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.f18573e) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f18573e = true;
        try {
            this.f18571c.accept(th2);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            RxJavaPlugins.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t11) {
        if (!this.f18573e) {
            try {
                if (!this.f18570b.test(t11)) {
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
