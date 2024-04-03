package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.operators.ConditionalSubscriber;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    public final ParallelFlowable<T> f22662a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<? super T, ? extends R> f22663b;

    public static final class ParallelMapConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* renamed from: b  reason: collision with root package name */
        public final ConditionalSubscriber<? super R> f22664b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f22665c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f22666d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22667e;

        public ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function) {
            this.f22664b = conditionalSubscriber;
            this.f22665c = function;
        }

        public void cancel() {
            this.f22666d.cancel();
        }

        public void onComplete() {
            if (!this.f22667e) {
                this.f22667e = true;
                this.f22664b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22667e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22667e = true;
            this.f22664b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22667e) {
                try {
                    Object apply = this.f22665c.apply(t11);
                    Objects.requireNonNull(apply, "The mapper returned a null value");
                    this.f22664b.onNext(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22666d, subscription)) {
                this.f22666d = subscription;
                this.f22664b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f22666d.request(j11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f22667e) {
                return false;
            }
            try {
                Object apply = this.f22665c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null value");
                return this.f22664b.tryOnNext(apply);
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
        public final Subscriber<? super R> f22668b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends R> f22669c;

        /* renamed from: d  reason: collision with root package name */
        public Subscription f22670d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22671e;

        public ParallelMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function) {
            this.f22668b = subscriber;
            this.f22669c = function;
        }

        public void cancel() {
            this.f22670d.cancel();
        }

        public void onComplete() {
            if (!this.f22671e) {
                this.f22671e = true;
                this.f22668b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22671e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22671e = true;
            this.f22668b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22671e) {
                try {
                    Object apply = this.f22669c.apply(t11);
                    Objects.requireNonNull(apply, "The mapper returned a null value");
                    this.f22668b.onNext(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f22670d, subscription)) {
                this.f22670d = subscription;
                this.f22668b.onSubscribe(this);
            }
        }

        public void request(long j11) {
            this.f22670d.request(j11);
        }
    }

    public ParallelMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function) {
        this.f22662a = parallelFlowable;
        this.f22663b = function;
    }

    public int parallelism() {
        return this.f22662a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        Subscriber[] onSubscribe = RxJavaPlugins.onSubscribe(this, (Subscriber<? super T>[]) subscriberArr);
        if (a(onSubscribe)) {
            int length = onSubscribe.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i11 = 0; i11 < length; i11++) {
                Subscriber subscriber = onSubscribe[i11];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i11] = new ParallelMapConditionalSubscriber((ConditionalSubscriber) subscriber, this.f22663b);
                } else {
                    subscriberArr2[i11] = new ParallelMapSubscriber(subscriber, this.f22663b);
                }
            }
            this.f22662a.subscribe(subscriberArr2);
        }
    }
}
