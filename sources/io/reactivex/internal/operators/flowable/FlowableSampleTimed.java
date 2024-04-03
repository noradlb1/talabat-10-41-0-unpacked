package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f15774d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f15775e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f15776f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f15777g;

    public static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicInteger f15778i = new AtomicInteger(1);

        public SampleTimedEmitLast(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j11, timeUnit, scheduler);
        }

        public void b() {
            c();
            if (this.f15778i.decrementAndGet() == 0) {
                this.f15779b.onComplete();
            }
        }

        public void run() {
            if (this.f15778i.incrementAndGet() == 2) {
                c();
                if (this.f15778i.decrementAndGet() == 0) {
                    this.f15779b.onComplete();
                }
            }
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j11, timeUnit, scheduler);
        }

        public void b() {
            this.f15779b.onComplete();
        }

        public void run() {
            c();
        }
    }

    public static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f15779b;

        /* renamed from: c  reason: collision with root package name */
        public final long f15780c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f15781d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f15782e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f15783f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final SequentialDisposable f15784g = new SequentialDisposable();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f15785h;

        public SampleTimedSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f15779b = subscriber;
            this.f15780c = j11;
            this.f15781d = timeUnit;
            this.f15782e = scheduler;
        }

        public void a() {
            DisposableHelper.dispose(this.f15784g);
        }

        public abstract void b();

        public void c() {
            Object andSet = getAndSet((Object) null);
            if (andSet == null) {
                return;
            }
            if (this.f15783f.get() != 0) {
                this.f15779b.onNext(andSet);
                BackpressureHelper.produced(this.f15783f, 1);
                return;
            }
            cancel();
            this.f15779b.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }

        public void cancel() {
            a();
            this.f15785h.cancel();
        }

        public void onComplete() {
            a();
            b();
        }

        public void onError(Throwable th2) {
            a();
            this.f15779b.onError(th2);
        }

        public void onNext(T t11) {
            lazySet(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f15785h, subscription)) {
                this.f15785h = subscription;
                this.f15779b.onSubscribe(this);
                SequentialDisposable sequentialDisposable = this.f15784g;
                Scheduler scheduler = this.f15782e;
                long j11 = this.f15780c;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f15781d));
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f15783f, j11);
            }
        }
    }

    public FlowableSampleTimed(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(flowable);
        this.f15774d = j11;
        this.f15775e = timeUnit;
        this.f15776f = scheduler;
        this.f15777g = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f15777g) {
            this.f14763c.subscribe(new SampleTimedEmitLast(serializedSubscriber, this.f15774d, this.f15775e, this.f15776f));
        } else {
            this.f14763c.subscribe(new SampleTimedNoLast(serializedSubscriber, this.f15774d, this.f15775e, this.f15776f));
        }
    }
}
