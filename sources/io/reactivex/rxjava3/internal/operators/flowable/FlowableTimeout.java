package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final Publisher<U> f20524d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super T, ? extends Publisher<V>> f20525e;

    /* renamed from: f  reason: collision with root package name */
    public final Publisher<? extends T> f20526f;

    public static final class TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutSelectorSupport f20527b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20528c;

        public TimeoutConsumer(long j11, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.f20528c = j11;
            this.f20527b = timeoutSelectorSupport;
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
                this.f20527b.onTimeout(this.f20528c);
            }
        }

        public void onError(Throwable th2) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f20527b.onTimeoutError(this.f20528c, th2);
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
                this.f20527b.onTimeout(this.f20528c);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f20529j;

        /* renamed from: k  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<?>> f20530k;

        /* renamed from: l  reason: collision with root package name */
        public final SequentialDisposable f20531l = new SequentialDisposable();

        /* renamed from: m  reason: collision with root package name */
        public final AtomicReference<Subscription> f20532m = new AtomicReference<>();

        /* renamed from: n  reason: collision with root package name */
        public final AtomicLong f20533n;

        /* renamed from: o  reason: collision with root package name */
        public Publisher<? extends T> f20534o;

        /* renamed from: p  reason: collision with root package name */
        public long f20535p;

        public TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function, Publisher<? extends T> publisher) {
            super(true);
            this.f20529j = subscriber;
            this.f20530k = function;
            this.f20534o = publisher;
            this.f20533n = new AtomicLong();
        }

        public void c(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f20531l.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }

        public void cancel() {
            super.cancel();
            this.f20531l.dispose();
        }

        public void onComplete() {
            if (this.f20533n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f20531l.dispose();
                this.f20529j.onComplete();
                this.f20531l.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20533n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f20531l.dispose();
                this.f20529j.onError(th2);
                this.f20531l.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f20533n.get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = j11 + 1;
                if (this.f20533n.compareAndSet(j11, j12)) {
                    Disposable disposable = (Disposable) this.f20531l.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f20535p++;
                    this.f20529j.onNext(t11);
                    try {
                        Object apply = this.f20530k.apply(t11);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null Publisher.");
                        Publisher publisher = (Publisher) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j12, this);
                        if (this.f20531l.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f20532m.get().cancel();
                        this.f20533n.getAndSet(Long.MAX_VALUE);
                        this.f20529j.onError(th2);
                    }
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f20532m, subscription)) {
                setSubscription(subscription);
            }
        }

        public void onTimeout(long j11) {
            if (this.f20533n.compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f20532m);
                Publisher<? extends T> publisher = this.f20534o;
                this.f20534o = null;
                long j12 = this.f20535p;
                if (j12 != 0) {
                    produced(j12);
                }
                publisher.subscribe(new FlowableTimeoutTimed.FallbackSubscriber(this.f20529j, this));
            }
        }

        public void onTimeoutError(long j11, Throwable th2) {
            if (this.f20533n.compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f20532m);
                this.f20529j.onError(th2);
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
        public final Subscriber<? super T> f20536b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Publisher<?>> f20537c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f20538d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Subscription> f20539e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f20540f = new AtomicLong();

        public TimeoutSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function) {
            this.f20536b = subscriber;
            this.f20537c = function;
        }

        public void a(Publisher<?> publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0, this);
                if (this.f20538d.replace(timeoutConsumer)) {
                    publisher.subscribe(timeoutConsumer);
                }
            }
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f20539e);
            this.f20538d.dispose();
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f20538d.dispose();
                this.f20536b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f20538d.dispose();
                this.f20536b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (compareAndSet(j11, j12)) {
                    Disposable disposable = (Disposable) this.f20538d.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f20536b.onNext(t11);
                    try {
                        Object apply = this.f20537c.apply(t11);
                        Objects.requireNonNull(apply, "The itemTimeoutIndicator returned a null Publisher.");
                        Publisher publisher = (Publisher) apply;
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j12, this);
                        if (this.f20538d.replace(timeoutConsumer)) {
                            publisher.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f20539e.get().cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.f20536b.onError(th2);
                    }
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f20539e, this.f20540f, subscription);
        }

        public void onTimeout(long j11) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f20539e);
                this.f20536b.onError(new TimeoutException());
            }
        }

        public void onTimeoutError(long j11, Throwable th2) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f20539e);
                this.f20536b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f20539e, this.f20540f, j11);
        }
    }

    public FlowableTimeout(Flowable<T> flowable, Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        super(flowable);
        this.f20524d = publisher;
        this.f20525e = function;
        this.f20526f = publisher2;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f20526f == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f20525e);
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.a(this.f20524d);
            this.f19260c.subscribe(timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f20525e, this.f20526f);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.c(this.f20524d);
        this.f19260c.subscribe(timeoutFallbackSubscriber);
    }
}
