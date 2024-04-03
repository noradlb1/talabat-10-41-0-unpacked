package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelPeek<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f22686a;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f22687b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f22688c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super Throwable> f22689d;

    /* renamed from: e  reason: collision with root package name */
    public final Action f22690e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f22691f;

    /* renamed from: g  reason: collision with root package name */
    public final Consumer<? super Subscription> f22692g;

    /* renamed from: h  reason: collision with root package name */
    public final LongConsumer f22693h;

    /* renamed from: i  reason: collision with root package name */
    public final Action f22694i;

    public static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f22695b;

        /* renamed from: c  reason: collision with root package name */
        public final ParallelPeek<T> f22696c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f22697d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22698e;

        public ParallelPeekSubscriber(Subscriber<? super T> subscriber, ParallelPeek<T> parallelPeek) {
            this.f22695b = subscriber;
            this.f22696c = parallelPeek;
        }

        public void cancel() {
            try {
                this.f22696c.f22694i.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f22697d.cancel();
        }

        public void onComplete() {
            if (!this.f22698e) {
                this.f22698e = true;
                try {
                    this.f22696c.f22690e.run();
                    this.f22695b.onComplete();
                    try {
                        this.f22696c.f22691f.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        RxJavaPlugins.onError(th2);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f22695b.onError(th3);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f22698e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22698e = true;
            try {
                this.f22696c.f22689d.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f22695b.onError(th2);
            try {
                this.f22696c.f22691f.run();
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(th4);
            }
        }

        public void onNext(T t11) {
            if (!this.f22698e) {
                try {
                    this.f22696c.f22687b.accept(t11);
                    this.f22695b.onNext(t11);
                    try {
                        this.f22696c.f22688c.accept(t11);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        onError(th2);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    onError(th3);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22697d, subscription)) {
                this.f22697d = subscription;
                try {
                    this.f22696c.f22692g.accept(subscription);
                    this.f22695b.onSubscribe(this);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    subscription.cancel();
                    this.f22695b.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th2);
                }
            }
        }

        public void request(long j11) {
            try {
                this.f22696c.f22693h.accept(j11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f22697d.request(j11);
        }
    }

    public ParallelPeek(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super Subscription> consumer4, LongConsumer longConsumer, Action action3) {
        this.f22686a = parallelFlowable;
        Objects.requireNonNull(consumer, "onNext is null");
        this.f22687b = consumer;
        Objects.requireNonNull(consumer2, "onAfterNext is null");
        this.f22688c = consumer2;
        Objects.requireNonNull(consumer3, "onError is null");
        this.f22689d = consumer3;
        Objects.requireNonNull(action, "onComplete is null");
        this.f22690e = action;
        Objects.requireNonNull(action2, "onAfterTerminated is null");
        this.f22691f = action2;
        Objects.requireNonNull(consumer4, "onSubscribe is null");
        this.f22692g = consumer4;
        Objects.requireNonNull(longConsumer, "onRequest is null");
        this.f22693h = longConsumer;
        Objects.requireNonNull(action3, "onCancel is null");
        this.f22694i = action3;
    }

    public int parallelism() {
        return this.f22686a.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                subscriberArr2[i11] = new ParallelPeekSubscriber(onSubscribe[i11], this);
            }
            this.f22686a.subscribe(subscriberArr2);
        }
    }
}
