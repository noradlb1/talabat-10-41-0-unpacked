package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20541d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f20542e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f20543f;

    /* renamed from: g  reason: collision with root package name */
    public final Publisher<? extends T> f20544g;

    public static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20545b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f20546c;

        public FallbackSubscriber(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.f20545b = subscriber;
            this.f20546c = subscriptionArbiter;
        }

        public void onComplete() {
            this.f20545b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20545b.onError(th2);
        }

        public void onNext(T t11) {
            this.f20545b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f20546c.setSubscription(subscription);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f20547j;

        /* renamed from: k  reason: collision with root package name */
        public final long f20548k;

        /* renamed from: l  reason: collision with root package name */
        public final TimeUnit f20549l;

        /* renamed from: m  reason: collision with root package name */
        public final Scheduler.Worker f20550m;

        /* renamed from: n  reason: collision with root package name */
        public final SequentialDisposable f20551n = new SequentialDisposable();

        /* renamed from: o  reason: collision with root package name */
        public final AtomicReference<Subscription> f20552o = new AtomicReference<>();

        /* renamed from: p  reason: collision with root package name */
        public final AtomicLong f20553p = new AtomicLong();

        /* renamed from: q  reason: collision with root package name */
        public long f20554q;

        /* renamed from: r  reason: collision with root package name */
        public Publisher<? extends T> f20555r;

        public TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker, Publisher<? extends T> publisher) {
            super(true);
            this.f20547j = subscriber;
            this.f20548k = j11;
            this.f20549l = timeUnit;
            this.f20550m = worker;
            this.f20555r = publisher;
        }

        public void c(long j11) {
            this.f20551n.replace(this.f20550m.schedule(new TimeoutTask(j11, this), this.f20548k, this.f20549l));
        }

        public void cancel() {
            super.cancel();
            this.f20550m.dispose();
        }

        public void onComplete() {
            if (this.f20553p.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f20551n.dispose();
                this.f20547j.onComplete();
                this.f20550m.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f20553p.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f20551n.dispose();
                this.f20547j.onError(th2);
                this.f20550m.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f20553p.get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = j11 + 1;
                if (this.f20553p.compareAndSet(j11, j12)) {
                    ((Disposable) this.f20551n.get()).dispose();
                    this.f20554q++;
                    this.f20547j.onNext(t11);
                    c(j12);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f20552o, subscription)) {
                setSubscription(subscription);
            }
        }

        public void onTimeout(long j11) {
            if (this.f20553p.compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f20552o);
                long j12 = this.f20554q;
                if (j12 != 0) {
                    produced(j12);
                }
                Publisher<? extends T> publisher = this.f20555r;
                this.f20555r = null;
                publisher.subscribe(new FallbackSubscriber(this.f20547j, this));
                this.f20550m.dispose();
            }
        }
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20556b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20557c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f20558d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f20559e;

        /* renamed from: f  reason: collision with root package name */
        public final SequentialDisposable f20560f = new SequentialDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Subscription> f20561g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicLong f20562h = new AtomicLong();

        public TimeoutSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f20556b = subscriber;
            this.f20557c = j11;
            this.f20558d = timeUnit;
            this.f20559e = worker;
        }

        public void a(long j11) {
            this.f20560f.replace(this.f20559e.schedule(new TimeoutTask(j11, this), this.f20557c, this.f20558d));
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f20561g);
            this.f20559e.dispose();
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f20560f.dispose();
                this.f20556b.onComplete();
                this.f20559e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f20560f.dispose();
                this.f20556b.onError(th2);
                this.f20559e.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (compareAndSet(j11, j12)) {
                    ((Disposable) this.f20560f.get()).dispose();
                    this.f20556b.onNext(t11);
                    a(j12);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f20561g, this.f20562h, subscription);
        }

        public void onTimeout(long j11) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f20561g);
                this.f20556b.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f20557c, this.f20558d)));
                this.f20559e.dispose();
            }
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f20561g, this.f20562h, j11);
        }
    }

    public interface TimeoutSupport {
        void onTimeout(long j11);
    }

    public static final class TimeoutTask implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutSupport f20563b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20564c;

        public TimeoutTask(long j11, TimeoutSupport timeoutSupport) {
            this.f20564c = j11;
            this.f20563b = timeoutSupport;
        }

        public void run() {
            this.f20563b.onTimeout(this.f20564c);
        }
    }

    public FlowableTimeoutTimed(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.f20541d = j11;
        this.f20542e = timeUnit;
        this.f20543f = scheduler;
        this.f20544g = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f20544g == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f20541d, this.f20542e, this.f20543f.createWorker());
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.a(0);
            this.f19260c.subscribe(timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f20541d, this.f20542e, this.f20543f.createWorker(), this.f20544g);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.c(0);
        this.f19260c.subscribe(timeoutFallbackSubscriber);
    }
}
