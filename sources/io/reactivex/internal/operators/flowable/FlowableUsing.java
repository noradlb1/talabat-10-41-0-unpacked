package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUsing<T, D> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends D> f16074c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super D, ? extends Publisher<? extends T>> f16075d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super D> f16076e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f16077f;

    public static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5904473792286235046L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f16078b;

        /* renamed from: c  reason: collision with root package name */
        public final D f16079c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super D> f16080d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f16081e;

        /* renamed from: f  reason: collision with root package name */
        public Subscription f16082f;

        public UsingSubscriber(Subscriber<? super T> subscriber, D d11, Consumer<? super D> consumer, boolean z11) {
            this.f16078b = subscriber;
            this.f16079c = d11;
            this.f16080d = consumer;
            this.f16081e = z11;
        }

        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f16080d.accept(this.f16079c);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void cancel() {
            a();
            this.f16082f.cancel();
        }

        public void onComplete() {
            if (this.f16081e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f16080d.accept(this.f16079c);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f16078b.onError(th2);
                        return;
                    }
                }
                this.f16082f.cancel();
                this.f16078b.onComplete();
                return;
            }
            this.f16078b.onComplete();
            this.f16082f.cancel();
            a();
        }

        public void onError(Throwable th2) {
            Throwable th3;
            if (this.f16081e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f16080d.accept(this.f16079c);
                    } catch (Throwable th4) {
                        th3 = th4;
                        Exceptions.throwIfFatal(th3);
                    }
                }
                th3 = null;
                this.f16082f.cancel();
                if (th3 != null) {
                    this.f16078b.onError(new CompositeException(th2, th3));
                    return;
                }
                this.f16078b.onError(th2);
                return;
            }
            this.f16078b.onError(th2);
            this.f16082f.cancel();
            a();
        }

        public void onNext(T t11) {
            this.f16078b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f16082f, subscription)) {
                this.f16082f = subscription;
                this.f16078b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f16082f.request(j11);
        }
    }

    public FlowableUsing(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z11) {
        this.f16074c = callable;
        this.f16075d = function;
        this.f16076e = consumer;
        this.f16077f = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            Object call = this.f16074c.call();
            try {
                ((Publisher) ObjectHelper.requireNonNull(this.f16075d.apply(call), "The sourceSupplier returned a null Publisher")).subscribe(new UsingSubscriber(subscriber, call, this.f16076e, this.f16077f));
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
