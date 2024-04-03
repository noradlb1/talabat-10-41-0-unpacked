package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f16033d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f16034e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f16035f;

    /* renamed from: g  reason: collision with root package name */
    public final Publisher<? extends T> f16036g;

    public static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f16037b;

        /* renamed from: c  reason: collision with root package name */
        public final SubscriptionArbiter f16038c;

        public FallbackSubscriber(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.f16037b = subscriber;
            this.f16038c = subscriptionArbiter;
        }

        public void onComplete() {
            this.f16037b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16037b.onError(th2);
        }

        public void onNext(T t11) {
            this.f16037b.onNext(t11);
        }

        public void onSubscribe(Subscription subscription) {
            this.f16038c.setSubscription(subscription);
        }
    }

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: j  reason: collision with root package name */
        public final Subscriber<? super T> f16039j;

        /* renamed from: k  reason: collision with root package name */
        public final long f16040k;

        /* renamed from: l  reason: collision with root package name */
        public final TimeUnit f16041l;

        /* renamed from: m  reason: collision with root package name */
        public final Scheduler.Worker f16042m;

        /* renamed from: n  reason: collision with root package name */
        public final SequentialDisposable f16043n = new SequentialDisposable();

        /* renamed from: o  reason: collision with root package name */
        public final AtomicReference<Subscription> f16044o = new AtomicReference<>();

        /* renamed from: p  reason: collision with root package name */
        public final AtomicLong f16045p = new AtomicLong();

        /* renamed from: q  reason: collision with root package name */
        public long f16046q;

        /* renamed from: r  reason: collision with root package name */
        public Publisher<? extends T> f16047r;

        public TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker, Publisher<? extends T> publisher) {
            super(true);
            this.f16039j = subscriber;
            this.f16040k = j11;
            this.f16041l = timeUnit;
            this.f16042m = worker;
            this.f16047r = publisher;
        }

        public void c(long j11) {
            this.f16043n.replace(this.f16042m.schedule(new TimeoutTask(j11, this), this.f16040k, this.f16041l));
        }

        public void cancel() {
            super.cancel();
            this.f16042m.dispose();
        }

        public void onComplete() {
            if (this.f16045p.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16043n.dispose();
                this.f16039j.onComplete();
                this.f16042m.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16045p.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16043n.dispose();
                this.f16039j.onError(th2);
                this.f16042m.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.f16045p.get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = j11 + 1;
                if (this.f16045p.compareAndSet(j11, j12)) {
                    ((Disposable) this.f16043n.get()).dispose();
                    this.f16046q++;
                    this.f16039j.onNext(t11);
                    c(j12);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.setOnce(this.f16044o, subscription)) {
                setSubscription(subscription);
            }
        }

        public void onTimeout(long j11) {
            if (this.f16045p.compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f16044o);
                long j12 = this.f16046q;
                if (j12 != 0) {
                    produced(j12);
                }
                Publisher<? extends T> publisher = this.f16047r;
                this.f16047r = null;
                publisher.subscribe(new FallbackSubscriber(this.f16039j, this));
                this.f16042m.dispose();
            }
        }
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f16048b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16049c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f16050d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f16051e;

        /* renamed from: f  reason: collision with root package name */
        public final SequentialDisposable f16052f = new SequentialDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Subscription> f16053g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicLong f16054h = new AtomicLong();

        public TimeoutSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f16048b = subscriber;
            this.f16049c = j11;
            this.f16050d = timeUnit;
            this.f16051e = worker;
        }

        public void a(long j11) {
            this.f16052f.replace(this.f16051e.schedule(new TimeoutTask(j11, this), this.f16049c, this.f16050d));
        }

        public void cancel() {
            SubscriptionHelper.cancel(this.f16053g);
            this.f16051e.dispose();
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16052f.dispose();
                this.f16048b.onComplete();
                this.f16051e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f16052f.dispose();
                this.f16048b.onError(th2);
                this.f16051e.dispose();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MAX_VALUE) {
                long j12 = 1 + j11;
                if (compareAndSet(j11, j12)) {
                    ((Disposable) this.f16052f.get()).dispose();
                    this.f16048b.onNext(t11);
                    a(j12);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this.f16053g, this.f16054h, subscription);
        }

        public void onTimeout(long j11) {
            if (compareAndSet(j11, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.f16053g);
                this.f16048b.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f16049c, this.f16050d)));
                this.f16051e.dispose();
            }
        }

        public void request(long j11) {
            SubscriptionHelper.deferredRequest(this.f16053g, this.f16054h, j11);
        }
    }

    public interface TimeoutSupport {
        void onTimeout(long j11);
    }

    public static final class TimeoutTask implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final TimeoutSupport f16055b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16056c;

        public TimeoutTask(long j11, TimeoutSupport timeoutSupport) {
            this.f16056c = j11;
            this.f16055b = timeoutSupport;
        }

        public void run() {
            this.f16055b.onTimeout(this.f16056c);
        }
    }

    public FlowableTimeoutTimed(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.f16033d = j11;
        this.f16034e = timeUnit;
        this.f16035f = scheduler;
        this.f16036g = publisher;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f16036g == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f16033d, this.f16034e, this.f16035f.createWorker());
            subscriber.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.a(0);
            this.f14763c.subscribe(timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f16033d, this.f16034e, this.f16035f.createWorker(), this.f16036g);
        subscriber.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.c(0);
        this.f14763c.subscribe(timeoutFallbackSubscriber);
    }
}
