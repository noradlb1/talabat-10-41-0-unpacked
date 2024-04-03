package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20284d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f20285e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f20286f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f20287g;

    public static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicInteger f20288i = new AtomicInteger(1);

        public SampleTimedEmitLast(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j11, timeUnit, scheduler);
        }

        public void b() {
            c();
            if (this.f20288i.decrementAndGet() == 0) {
                this.f20289b.onComplete();
            }
        }

        public void run() {
            if (this.f20288i.incrementAndGet() == 2) {
                c();
                if (this.f20288i.decrementAndGet() == 0) {
                    this.f20289b.onComplete();
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
            this.f20289b.onComplete();
        }

        public void run() {
            c();
        }
    }

    public static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super T> f20289b;

        /* renamed from: c  reason: collision with root package name */
        public final long f20290c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f20291d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler f20292e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicLong f20293f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        public final SequentialDisposable f20294g = new SequentialDisposable();

        /* renamed from: h  reason: collision with root package name */
        public Subscription f20295h;

        public SampleTimedSubscriber(Subscriber<? super T> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            this.f20289b = subscriber;
            this.f20290c = j11;
            this.f20291d = timeUnit;
            this.f20292e = scheduler;
        }

        public void a() {
            DisposableHelper.dispose(this.f20294g);
        }

        public abstract void b();

        public void c() {
            Object andSet = getAndSet((Object) null);
            if (andSet == null) {
                return;
            }
            if (this.f20293f.get() != 0) {
                this.f20289b.onNext(andSet);
                BackpressureHelper.produced(this.f20293f, 1);
                return;
            }
            cancel();
            this.f20289b.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }

        public void cancel() {
            a();
            this.f20295h.cancel();
        }

        public void onComplete() {
            a();
            b();
        }

        public void onError(Throwable th2) {
            a();
            this.f20289b.onError(th2);
        }

        public void onNext(T t11) {
            lazySet(t11);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20295h, subscription)) {
                this.f20295h = subscription;
                this.f20289b.onSubscribe(this);
                SequentialDisposable sequentialDisposable = this.f20294g;
                Scheduler scheduler = this.f20292e;
                long j11 = this.f20290c;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f20291d));
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20293f, j11);
            }
        }
    }

    public FlowableSampleTimed(Flowable<T> flowable, long j11, TimeUnit timeUnit, Scheduler scheduler, boolean z11) {
        super(flowable);
        this.f20284d = j11;
        this.f20285e = timeUnit;
        this.f20286f = scheduler;
        this.f20287g = z11;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f20287g) {
            this.f19260c.subscribe(new SampleTimedEmitLast(serializedSubscriber, this.f20284d, this.f20285e, this.f20286f));
        } else {
            this.f19260c.subscribe(new SampleTimedNoLast(serializedSubscriber, this.f20284d, this.f20285e, this.f20286f));
        }
    }
}
