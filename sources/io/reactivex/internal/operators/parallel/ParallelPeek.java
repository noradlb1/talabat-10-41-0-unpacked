package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelPeek<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18152a;

    /* renamed from: b  reason: collision with root package name */
    public final Consumer<? super T> f18153b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f18154c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super Throwable> f18155d;

    /* renamed from: e  reason: collision with root package name */
    public final Action f18156e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f18157f;

    /* renamed from: g  reason: collision with root package name */
    public final Consumer<? super Subscription> f18158g;

    /* renamed from: h  reason: collision with root package name */
    public final LongConsumer f18159h;

    /* renamed from: i  reason: collision with root package name */
    public final Action f18160i;

    public static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f18161b;

        /* renamed from: c  reason: collision with root package name */
        public final ParallelPeek<T> f18162c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f18163d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18164e;

        public ParallelPeekSubscriber(Subscriber<? super T> subscriber, ParallelPeek<T> parallelPeek) {
            this.f18161b = subscriber;
            this.f18162c = parallelPeek;
        }

        public void cancel() {
            try {
                this.f18162c.f18160i.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f18163d.cancel();
        }

        public void onComplete() {
            if (!this.f18164e) {
                this.f18164e = true;
                try {
                    this.f18162c.f18156e.run();
                    this.f18161b.onComplete();
                    try {
                        this.f18162c.f18157f.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        RxJavaPlugins.onError(th2);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f18161b.onError(th3);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f18164e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18164e = true;
            try {
                this.f18162c.f18155d.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f18161b.onError(th2);
            try {
                this.f18162c.f18157f.run();
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(th4);
            }
        }

        public void onNext(T t11) {
            if (!this.f18164e) {
                try {
                    this.f18162c.f18153b.accept(t11);
                    this.f18161b.onNext(t11);
                    try {
                        this.f18162c.f18154c.accept(t11);
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
            if (SubscriptionHelper.validate(this.f18163d, subscription)) {
                this.f18163d = subscription;
                try {
                    this.f18162c.f18158g.accept(subscription);
                    this.f18161b.onSubscribe(this);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    subscription.cancel();
                    this.f18161b.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th2);
                }
            }
        }

        public void request(long j11) {
            try {
                this.f18162c.f18159h.accept(j11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f18163d.request(j11);
        }
    }

    public ParallelPeek(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super Subscription> consumer4, LongConsumer longConsumer, Action action3) {
        this.f18152a = parallelFlowable;
        this.f18153b = (Consumer) ObjectHelper.requireNonNull(consumer, "onNext is null");
        this.f18154c = (Consumer) ObjectHelper.requireNonNull(consumer2, "onAfterNext is null");
        this.f18155d = (Consumer) ObjectHelper.requireNonNull(consumer3, "onError is null");
        this.f18156e = (Action) ObjectHelper.requireNonNull(action, "onComplete is null");
        this.f18157f = (Action) ObjectHelper.requireNonNull(action2, "onAfterTerminated is null");
        this.f18158g = (Consumer) ObjectHelper.requireNonNull(consumer4, "onSubscribe is null");
        this.f18159h = (LongConsumer) ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        this.f18160i = (Action) ObjectHelper.requireNonNull(action3, "onCancel is null");
    }

    public int parallelism() {
        return this.f18152a.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                subscriberArr2[i11] = new ParallelPeekSubscriber(subscriberArr[i11], this);
            }
            this.f18152a.subscribe(subscriberArr2);
        }
    }
}
