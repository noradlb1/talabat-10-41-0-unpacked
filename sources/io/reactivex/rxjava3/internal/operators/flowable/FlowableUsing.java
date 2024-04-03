package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUsing<T, D> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<? extends D> f20582c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super D, ? extends Publisher<? extends T>> f20583d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super D> f20584e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f20585f;

    public static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5904473792286235046L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20586b;

        /* renamed from: c  reason: collision with root package name */
        public final D f20587c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super D> f20588d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f20589e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f20590f;

        public UsingSubscriber(Subscriber<? super T> subscriber, D d11, Consumer<? super D> consumer, boolean z11) {
            this.f20586b = subscriber;
            this.f20587c = d11;
            this.f20588d = consumer;
            this.f20589e = z11;
        }

        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f20588d.accept(this.f20587c);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void cancel() {
            if (this.f20589e) {
                a();
                this.f20590f.cancel();
                this.f20590f = SubscriptionHelper.CANCELLED;
                return;
            }
            this.f20590f.cancel();
            this.f20590f = SubscriptionHelper.CANCELLED;
            a();
        }

        public void onComplete() {
            if (this.f20589e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f20588d.accept(this.f20587c);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f20586b.onError(th2);
                        return;
                    }
                }
                this.f20586b.onComplete();
                return;
            }
            this.f20586b.onComplete();
            a();
        }

        public void onError(Throwable th2) {
            Throwable th3;
            if (this.f20589e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f20588d.accept(this.f20587c);
                    } catch (Throwable th4) {
                        th3 = th4;
                        Exceptions.throwIfFatal(th3);
                    }
                }
                th3 = null;
                if (th3 != null) {
                    this.f20586b.onError(new CompositeException(th2, th3));
                    return;
                }
                this.f20586b.onError(th2);
                return;
            }
            this.f20586b.onError(th2);
            a();
        }

        public void onNext(T t11) {
            this.f20586b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20590f, subscription)) {
                this.f20590f = subscription;
                this.f20586b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f20590f.request(j11);
        }
    }

    public FlowableUsing(Supplier<? extends D> supplier, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z11) {
        this.f20582c = supplier;
        this.f20583d = function;
        this.f20584e = consumer;
        this.f20585f = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Object obj = this.f20582c.get();
            try {
                Object apply = this.f20583d.apply(obj);
                Objects.requireNonNull(apply, "The sourceSupplier returned a null Publisher");
                ((Publisher) apply).subscribe(new UsingSubscriber(subscriber, obj, this.f20584e, this.f20585f));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(new CompositeException(th, th2), subscriber);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptySubscription.error(th3, subscriber);
        }
    }
}
