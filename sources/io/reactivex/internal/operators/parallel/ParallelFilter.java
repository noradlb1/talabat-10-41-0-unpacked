package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFilter<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18071a;

    /* renamed from: b  reason: collision with root package name */
    public final Predicate<? super T> f18072b;

    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Predicate<? super T> f18073b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f18074c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f18075d;

        public BaseFilterSubscriber(Predicate<? super T> predicate) {
            this.f18073b = predicate;
        }

        public final void cancel() {
            this.f18074c.cancel();
        }

        public final void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f18075d) {
                this.f18074c.request(1);
            }
        }

        public final void request(long j11) {
            this.f18074c.request(j11);
        }
    }

    public static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {

        /* renamed from: e  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f18076e;

        public ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.f18076e = conditionalSubscriber;
        }

        public void onComplete() {
            if (!this.f18075d) {
                this.f18075d = true;
                this.f18076e.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18075d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18075d = true;
            this.f18076e.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18074c, subscription)) {
                this.f18074c = subscription;
                this.f18076e.onSubscribe(this);
            }
        }

        public boolean tryOnNext(T t11) {
            if (!this.f18075d) {
                try {
                    if (this.f18073b.test(t11)) {
                        return this.f18076e.tryOnNext(t11);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
            return false;
        }
    }

    public static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {

        /* renamed from: e  reason: collision with root package name */
        public final Subscriber<? super T> f18077e;

        public ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.f18077e = subscriber;
        }

        public void onComplete() {
            if (!this.f18075d) {
                this.f18075d = true;
                this.f18077e.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18075d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18075d = true;
            this.f18077e.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18074c, subscription)) {
                this.f18074c = subscription;
                this.f18077e.onSubscribe(this);
            }
        }

        public boolean tryOnNext(T t11) {
            if (!this.f18075d) {
                try {
                    if (this.f18073b.test(t11)) {
                        this.f18077e.onNext(t11);
                        return true;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
            return false;
        }
    }

    public ParallelFilter(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate) {
        this.f18071a = parallelFlowable;
        this.f18072b = predicate;
    }

    public int parallelism() {
        return this.f18071a.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i11];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelFilterConditionalSubscriber(conditionalSubscriber, this.f18072b);
                } else {
                    subscriberArr2[i11] = new ParallelFilterSubscriber(conditionalSubscriber, this.f18072b);
                }
            }
            this.f18071a.subscribe(subscriberArr2);
        }
    }
}
