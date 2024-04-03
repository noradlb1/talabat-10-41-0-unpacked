package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFilter<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f22602a;

    /* renamed from: b  reason: collision with root package name */
    public final Predicate<? super T> f22603b;

    public static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Predicate<? super T> f22604b;

        /* renamed from: c  reason: collision with root package name */
        public Subscription f22605c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22606d;

        public BaseFilterSubscriber(Predicate<? super T> predicate) {
            this.f22604b = predicate;
        }

        public final void cancel() {
            this.f22605c.cancel();
        }

        public final void onNext(T t11) {
            if (!tryOnNext(t11) && !this.f22606d) {
                this.f22605c.request(1);
            }
        }

        public final void request(long j11) {
            this.f22605c.request(j11);
        }
    }

    public static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {

        /* renamed from: e  reason: collision with root package name */
        public final ConditionalSubscriber<? super T> f22607e;

        public ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.f22607e = conditionalSubscriber;
        }

        public void onComplete() {
            if (!this.f22606d) {
                this.f22606d = true;
                this.f22607e.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22606d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22606d = true;
            this.f22607e.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22605c, subscription)) {
                this.f22605c = subscription;
                this.f22607e.onSubscribe(this);
            }
        }

        public boolean tryOnNext(T t11) {
            if (!this.f22606d) {
                try {
                    if (this.f22604b.test(t11)) {
                        return this.f22607e.tryOnNext(t11);
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
        public final Subscriber<? super T> f22608e;

        public ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
            super(predicate);
            this.f22608e = subscriber;
        }

        public void onComplete() {
            if (!this.f22606d) {
                this.f22606d = true;
                this.f22608e.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22606d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22606d = true;
            this.f22608e.onError(th2);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22605c, subscription)) {
                this.f22605c = subscription;
                this.f22608e.onSubscribe(this);
            }
        }

        public boolean tryOnNext(T t11) {
            if (!this.f22606d) {
                try {
                    if (this.f22604b.test(t11)) {
                        this.f22608e.onNext(t11);
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
        this.f22602a = parallelFlowable;
        this.f22603b = predicate;
    }

    public int parallelism() {
        return this.f22602a.parallelism();
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                Subscriber subscriber = onSubscribe[i11];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelFilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f22603b);
                } else {
                    subscriberArr2[i11] = new ParallelFilterSubscriber(subscriber, this.f22603b);
                }
            }
            this.f22602a.subscribe(subscriberArr2);
        }
    }
}
