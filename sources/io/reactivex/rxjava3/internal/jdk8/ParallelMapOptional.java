package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.Optional;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapOptional<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f18967a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, Optional<? extends R>> f18968b;

    public static final class ParallelMapConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super R> f18969b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, Optional<? extends R>> f18970c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f18971d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18972e;

        public ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, Optional<? extends R>> function) {
            this.f18969b = conditionalSubscriber;
            this.f18970c = function;
        }

        public void cancel() {
            this.f18971d.cancel();
        }

        public void onComplete() {
            if (!this.f18972e) {
                this.f18972e = true;
                this.f18969b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18972e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18972e = true;
            this.f18969b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f18971d.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18971d, subscription)) {
                this.f18971d = subscription;
                this.f18969b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18971d.request(j11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f18972e) {
                return false;
            }
            try {
                Optional<? extends R> apply = this.f18970c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null value");
                Optional optional = apply;
                if (!optional.isPresent() || !this.f18969b.tryOnNext(optional.get())) {
                    return false;
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                onError(th2);
                return false;
            }
        }
    }

    public static final class ParallelMapSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super R> f18973b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, Optional<? extends R>> f18974c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f18975d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f18976e;

        public ParallelMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, Optional<? extends R>> function) {
            this.f18973b = subscriber;
            this.f18974c = function;
        }

        public void cancel() {
            this.f18975d.cancel();
        }

        public void onComplete() {
            if (!this.f18976e) {
                this.f18976e = true;
                this.f18973b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18976e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18976e = true;
            this.f18973b.onError(th2);
        }

        public void onNext(T t11) {
            if (!tryOnNext(t11)) {
                this.f18975d.request(1);
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f18975d, subscription)) {
                this.f18975d = subscription;
                this.f18973b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f18975d.request(j11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f18976e) {
                return true;
            }
            try {
                Optional<? extends R> apply = this.f18974c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional optional = apply;
                if (!optional.isPresent()) {
                    return false;
                }
                this.f18973b.onNext(optional.get());
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                onError(th2);
                return true;
            }
        }
    }

    public ParallelMapOptional(ParallelFlowable<T> parallelFlowable, Function<? super T, Optional<? extends R>> function) {
        this.f18967a = parallelFlowable;
        this.f18968b = function;
    }

    public int parallelism() {
        return this.f18967a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (a(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i11];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelMapConditionalSubscriber(conditionalSubscriber, this.f18968b);
                } else {
                    subscriberArr2[i11] = new ParallelMapSubscriber(conditionalSubscriber, this.f18968b);
                }
            }
            this.f18967a.subscribe(subscriberArr2);
        }
    }
}
