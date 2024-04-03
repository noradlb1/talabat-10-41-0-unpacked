package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<U> f16016d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<V>> f16017e;

    /* renamed from: f  reason: collision with root package name */
    public final Publisher<? extends T> f16018f;

    public static final class TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutSelectorSupport f16019b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16020c;

        public TimeoutConsumer(long j11, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.f16020c = j11;
            this.f16019b = timeoutSelectorSupport;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f16019b.onTimeout(this.f16020c);
            }
        }

        public void onError(Throwable th2) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f16019b.onTimeoutError(this.f16020c, th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                lazySet(subscriptionHelper);
                this.f16019b.onTimeout(this.f16020c);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f16021j;

        /* renamed from: k  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<?>> f16022k;

        /* renamed from: l  reason: collision with root package name */
        public final SequentialDisposable f16023l = new SequentialDisposable();

        /* renamed from: m  reason: collision with root package name */
        public final AtomicReference<Subscription> f16024m = new AtomicReference<>();

        /* renamed from: n  reason: collision with root package name */
        public final AtomicLong f16025n;

        /* renamed from: o  reason: collision with root package name */
        public Publisher<? extends T> f16026o;

        /* renamed from: p  reason: collision with root package name */
        public long f16027p;

        public TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function, Publisher<? extends T> publisher) {
            super(true);
            this.f16021j = subscriber;
            this.f16022k = function;
            this.f16026o = publisher;
            this.f16025n = new AtomicLong();
        }

        public void c(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f16023l.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }

        public void cancel() {
            super.cancel();
            this.f16023l.dispose();
        }

        public void onComplete() {
            if (this.f16025n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16023l.dispose();
                this.f16021j.onComplete();
                this.f16023l.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16025n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16023l.dispose();
                this.f16021j.onError(th2);
                this.f16023l.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f16025n.get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = j11 + 1;
                if (this.f16025n.compareAndSet(j11, j12)) {
                    Disposable disposable = (Disposable) this.f16023l.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f16027p++;
                    this.f16021j.onNext(t11);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f16022k.apply(t11), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j12, this);
                        if (this.f16023l.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f16024m.get().cancel();
                        this.f16025n.getAndSet(Long.MAX_VALUE);
                        this.f16021j.onError(th2);
                    }
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f16024m, subscription)) {
                setSubscription(subscription);
            }
        }

        public void onTimeout(long j11) {
            if (this.f16025n.compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f16024m);
                Publisher<? extends T> publisher = this.f16026o;
                this.f16026o = null;
                long j12 = this.f16027p;
                if (j12 != 0) {
                    produced(j12);
                }
                publisher.subscribe(new FlowableTimeoutTimed.FallbackSubscriber(this.f16021j, this));
            }
        }

        public void onTimeoutError(long j11, Throwable th2) {
            if (this.f16025n.compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f16024m);
                this.f16021j.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }
    }

    public interface TimeoutSelectorSupport extends FlowableTimeoutTimed.TimeoutSupport {
        void onTimeoutError(long j11, Throwable th2);
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f16028b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<?>> f16029c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f16030d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Subscription> f16031e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f16032f = new AtomicLong();

        public TimeoutSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function) {
            this.f16028b = subscriber;
            this.f16029c = function;
        }

        public void a(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f16030d.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f16031e);
            this.f16030d.dispose();
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16030d.dispose();
                this.f16028b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16030d.dispose();
                this.f16028b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (compareAndSet(j11, j12)) {
                    Disposable disposable = (Disposable) this.f16030d.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f16028b.onNext(t11);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.f16029c.apply(t11), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j12, this);
                        if (this.f16030d.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f16031e.get().cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.f16028b.onError(th2);
                    }
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f16031e, this.f16032f, subscription);
        }

        public void onTimeout(long j11) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f16031e);
                this.f16028b.onError(new TimeoutException());
            }
        }

        public void onTimeoutError(long j11, Throwable th2) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f16031e);
                this.f16028b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f16031e, this.f16032f, j11);
        }
    }

    public FlowableTimeout(Flowable<T> flowable, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        super(flowable);
        this.f16016d = publisher;
        this.f16017e = function;
        this.f16018f = publisher2;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f16018f == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f16017e);
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.a(this.f16016d);
            this.f14763c.subscribe(timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f16017e, this.f16018f);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.c(this.f16016d);
        this.f14763c.subscribe(timeoutFallbackSubscriber);
    }
}
