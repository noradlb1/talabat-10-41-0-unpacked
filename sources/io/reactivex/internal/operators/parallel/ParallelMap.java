package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18128a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends R> f18129b;

    public static final class ParallelMapConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super R> f18130b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f18131c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f18132d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18133e;

        public ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function) {
            this.f18130b = conditionalSubscriber;
            this.f18131c = function;
        }

        public void cancel() {
            this.f18132d.cancel();
        }

        public void onComplete() {
            if (!this.f18133e) {
                this.f18133e = true;
                this.f18130b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18133e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18133e = true;
            this.f18130b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18133e) {
                try {
                    this.f18130b.onNext(ObjectHelper.requireNonNull(this.f18131c.apply(t11), "The mapper returned a null value"));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18132d, subscription)) {
                this.f18132d = subscription;
                this.f18130b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18132d.request(j11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f18133e) {
                return false;
            }
            try {
                return this.f18130b.tryOnNext(ObjectHelper.requireNonNull(this.f18131c.apply(t11), "The mapper returned a null value"));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                onError(th2);
                return false;
            }
        }
    }

    public static final class ParallelMapSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f18134b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f18135c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f18136d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18137e;

        public ParallelMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function) {
            this.f18134b = subscriber;
            this.f18135c = function;
        }

        public void cancel() {
            this.f18136d.cancel();
        }

        public void onComplete() {
            if (!this.f18137e) {
                this.f18137e = true;
                this.f18134b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18137e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18137e = true;
            this.f18134b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18137e) {
                try {
                    this.f18134b.onNext(ObjectHelper.requireNonNull(this.f18135c.apply(t11), "The mapper returned a null value"));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18136d, subscription)) {
                this.f18136d = subscription;
                this.f18134b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18136d.request(j11);
        }
    }

    public ParallelMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function) {
        this.f18128a = parallelFlowable;
        this.f18129b = function;
    }

    public int parallelism() {
        return this.f18128a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i11];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelMapConditionalSubscriber(conditionalSubscriber, this.f18129b);
                } else {
                    subscriberArr2[i11] = new ParallelMapSubscriber(conditionalSubscriber, this.f18129b);
                }
            }
            this.f18128a.subscribe(subscriberArr2);
        }
    }
}
