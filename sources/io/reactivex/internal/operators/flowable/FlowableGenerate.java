package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGenerate<T, S> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<S> f15323c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<S, Emitter<T>, S> f15324d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super S> f15325e;

    public static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15326b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<S, ? super Emitter<T>, S> f15327c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super S> f15328d;

        /* renamed from: e  reason: collision with root package name */
        public S f15329e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f15330f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f15331g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f15332h;

        public GeneratorSubscription(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s11) {
            this.f15326b = subscriber;
            this.f15327c = biFunction;
            this.f15328d = consumer;
            this.f15329e = s11;
        }

        private void dispose(S s11) {
            try {
                this.f15328d.accept(s11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public void cancel() {
            if (!this.f15330f) {
                this.f15330f = true;
                if (BackpressureHelper.add(this, 1) == 0) {
                    S s11 = this.f15329e;
                    this.f15329e = null;
                    dispose(s11);
                }
            }
        }

        public void onComplete() {
            if (!this.f15331g) {
                this.f15331g = true;
                this.f15326b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f15331g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f15331g = true;
            this.f15326b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f15331g) {
                return;
            }
            if (this.f15332h) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t11 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f15332h = true;
                this.f15326b.onNext(t11);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11) && BackpressureHelper.add(this, j11) == 0) {
                S s11 = this.f15329e;
                BiFunction<S, ? super Emitter<T>, S> biFunction = this.f15327c;
                do {
                    long j12 = 0;
                    while (true) {
                        if (j12 == j11) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f15329e = s11;
                                j11 = addAndGet(-j12);
                            }
                        } else if (this.f15330f) {
                            this.f15329e = null;
                            dispose(s11);
                            return;
                        } else {
                            this.f15332h = false;
                            try {
                                s11 = biFunction.apply(s11, this);
                                if (this.f15331g) {
                                    this.f15330f = true;
                                    this.f15329e = null;
                                    dispose(s11);
                                    return;
                                }
                                j12++;
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f15330f = true;
                                this.f15329e = null;
                                onError(th2);
                                dispose(s11);
                                return;
                            }
                        }
                    }
                } while (j11 != 0);
            }
        }
    }

    public FlowableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f15323c = callable;
        this.f15324d = biFunction;
        this.f15325e = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new GeneratorSubscription(subscriber, this.f15324d, this.f15325e, this.f15323c.call()));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
