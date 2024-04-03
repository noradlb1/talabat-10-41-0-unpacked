package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGenerate<T, S> extends Flowable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<S> f19840c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<S, Emitter<T>, S> f19841d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super S> f19842e;

    public static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long serialVersionUID = 7565982551505011832L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f19843b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<S, ? super Emitter<T>, S> f19844c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super S> f19845d;

        /* renamed from: e  reason: collision with root package name */
        public S f19846e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f19847f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f19848g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f19849h;

        public GeneratorSubscription(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s11) {
            this.f19843b = subscriber;
            this.f19844c = biFunction;
            this.f19845d = consumer;
            this.f19846e = s11;
        }

        private void dispose(S s11) {
            try {
                this.f19845d.accept(s11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public void cancel() {
            if (!this.f19847f) {
                this.f19847f = true;
                if (BackpressureHelper.add(this, 1) == 0) {
                    S s11 = this.f19846e;
                    this.f19846e = null;
                    dispose(s11);
                }
            }
        }

        public void onComplete() {
            if (!this.f19848g) {
                this.f19848g = true;
                this.f19843b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f19848g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (th2 == null) {
                th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            this.f19848g = true;
            this.f19843b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f19848g) {
                return;
            }
            if (this.f19849h) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t11 == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else {
                this.f19849h = true;
                this.f19843b.onNext(t11);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11) && BackpressureHelper.add(this, j11) == 0) {
                S s11 = this.f19846e;
                BiFunction<S, ? super Emitter<T>, S> biFunction = this.f19844c;
                do {
                    long j12 = 0;
                    while (true) {
                        if (j12 == j11) {
                            j11 = get();
                            if (j12 == j11) {
                                this.f19846e = s11;
                                j11 = addAndGet(-j12);
                            }
                        } else if (this.f19847f) {
                            this.f19846e = null;
                            dispose(s11);
                            return;
                        } else {
                            this.f19849h = false;
                            try {
                                s11 = biFunction.apply(s11, this);
                                if (this.f19848g) {
                                    this.f19847f = true;
                                    this.f19846e = null;
                                    dispose(s11);
                                    return;
                                }
                                j12++;
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f19847f = true;
                                this.f19846e = null;
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

    public FlowableGenerate(Supplier<S> supplier, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f19840c = supplier;
        this.f19841d = biFunction;
        this.f19842e = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        try {
            subscriber.onSubscribe(new GeneratorSubscription(subscriber, this.f19841d, this.f19842e, this.f19840c.get()));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptySubscription.error(th2, subscriber);
        }
    }
}
