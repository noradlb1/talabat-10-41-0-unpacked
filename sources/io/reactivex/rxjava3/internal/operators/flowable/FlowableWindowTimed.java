package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* renamed from: d  reason: collision with root package name */
    public final long f20671d;

    /* renamed from: e  reason: collision with root package name */
    public final long f20672e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f20673f;

    /* renamed from: g  reason: collision with root package name */
    public final Scheduler f20674g;

    /* renamed from: h  reason: collision with root package name */
    public final long f20675h;

    /* renamed from: i  reason: collision with root package name */
    public final int f20676i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f20677j;

    public static abstract class AbstractWindowSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5724293814035355511L;

        /* renamed from: b  reason: collision with root package name */
        public final Subscriber<? super Flowable<T>> f20678b;

        /* renamed from: c  reason: collision with root package name */
        public final SimplePlainQueue<Object> f20679c = new MpscLinkedQueue();

        /* renamed from: d  reason: collision with root package name */
        public final long f20680d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f20681e;

        /* renamed from: f  reason: collision with root package name */
        public final int f20682f;

        /* renamed from: g  reason: collision with root package name */
        public final AtomicLong f20683g;

        /* renamed from: h  reason: collision with root package name */
        public long f20684h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f20685i;

        /* renamed from: j  reason: collision with root package name */
        public Throwable f20686j;

        /* renamed from: k  reason: collision with root package name */
        public Subscription f20687k;

        /* renamed from: l  reason: collision with root package name */
        public final AtomicBoolean f20688l;

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f20689m;

        /* renamed from: n  reason: collision with root package name */
        public final AtomicInteger f20690n;

        public AbstractWindowSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, TimeUnit timeUnit, int i11) {
            this.f20678b = subscriber;
            this.f20680d = j11;
            this.f20681e = timeUnit;
            this.f20682f = i11;
            this.f20683g = new AtomicLong();
            this.f20688l = new AtomicBoolean();
            this.f20690n = new AtomicInteger(1);
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public abstract void c();

        public final void cancel() {
            if (this.f20688l.compareAndSet(false, true)) {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            if (this.f20690n.decrementAndGet() == 0) {
                a();
                this.f20687k.cancel();
                this.f20689m = true;
                c();
            }
        }

        public final void onComplete() {
            this.f20685i = true;
            c();
        }

        public final void onError(Throwable th2) {
            this.f20686j = th2;
            this.f20685i = true;
            c();
        }

        public final void onNext(T t11) {
            this.f20679c.offer(t11);
            c();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f20687k, subscription)) {
                this.f20687k = subscription;
                this.f20678b.onSubscribe(this);
                b();
            }
        }

        public final void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                BackpressureHelper.add(this.f20683g, j11);
            }
        }
    }

    public static final class WindowExactBoundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;

        /* renamed from: o  reason: collision with root package name */
        public final Scheduler f20691o;

        /* renamed from: p  reason: collision with root package name */
        public final boolean f20692p;

        /* renamed from: q  reason: collision with root package name */
        public final long f20693q;

        /* renamed from: r  reason: collision with root package name */
        public final Scheduler.Worker f20694r;

        /* renamed from: s  reason: collision with root package name */
        public long f20695s;

        /* renamed from: t  reason: collision with root package name */
        public UnicastProcessor<T> f20696t;

        /* renamed from: u  reason: collision with root package name */
        public final SequentialDisposable f20697u;

        public static final class WindowBoundaryRunnable implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final WindowExactBoundedSubscriber<?> f20698b;

            /* renamed from: c  reason: collision with root package name */
            public final long f20699c;

            public WindowBoundaryRunnable(WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber, long j11) {
                this.f20698b = windowExactBoundedSubscriber;
                this.f20699c = j11;
            }

            public void run() {
                this.f20698b.e(this);
            }
        }

        public WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, long j12, boolean z11) {
            super(subscriber, j11, timeUnit, i11);
            this.f20691o = scheduler;
            this.f20693q = j12;
            this.f20692p = z11;
            if (z11) {
                this.f20694r = scheduler.createWorker();
            } else {
                this.f20694r = null;
            }
            this.f20697u = new SequentialDisposable();
        }

        public void a() {
            this.f20697u.dispose();
            Scheduler.Worker worker = this.f20694r;
            if (worker != null) {
                worker.dispose();
            }
        }

        public void b() {
            if (this.f20688l.get()) {
                return;
            }
            if (this.f20683g.get() != 0) {
                this.f20684h = 1;
                this.f20690n.getAndIncrement();
                this.f20696t = UnicastProcessor.create(this.f20682f, this);
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(this.f20696t);
                this.f20678b.onNext(flowableWindowSubscribeIntercept);
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1);
                if (this.f20692p) {
                    SequentialDisposable sequentialDisposable = this.f20697u;
                    Scheduler.Worker worker = this.f20694r;
                    long j11 = this.f20680d;
                    sequentialDisposable.replace(worker.schedulePeriodically(windowBoundaryRunnable, j11, j11, this.f20681e));
                } else {
                    SequentialDisposable sequentialDisposable2 = this.f20697u;
                    Scheduler scheduler = this.f20691o;
                    long j12 = this.f20680d;
                    sequentialDisposable2.replace(scheduler.schedulePeriodicallyDirect(windowBoundaryRunnable, j12, j12, this.f20681e));
                }
                if (flowableWindowSubscribeIntercept.b()) {
                    this.f20696t.onComplete();
                }
                this.f20687k.request(Long.MAX_VALUE);
                return;
            }
            this.f20687k.cancel();
            this.f20678b.onError(new MissingBackpressureException(FlowableWindowTimed.b(this.f20684h)));
            a();
            this.f20689m = true;
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.f20679c;
                Subscriber<? super Flowable<T>> subscriber = this.f20678b;
                UnicastProcessor<T> unicastProcessor = this.f20696t;
                int i11 = 1;
                while (true) {
                    if (this.f20689m) {
                        simplePlainQueue.clear();
                        unicastProcessor = null;
                        this.f20696t = null;
                    } else {
                        boolean z12 = this.f20685i;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable th2 = this.f20686j;
                            if (th2 != null) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onError(th2);
                                }
                                subscriber.onError(th2);
                            } else {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            a();
                            this.f20689m = true;
                        } else if (!z11) {
                            if (poll instanceof WindowBoundaryRunnable) {
                                if (((WindowBoundaryRunnable) poll).f20699c == this.f20684h || !this.f20692p) {
                                    this.f20695s = 0;
                                    unicastProcessor = f(unicastProcessor);
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
                                long j11 = this.f20695s + 1;
                                if (j11 == this.f20693q) {
                                    this.f20695s = 0;
                                    unicastProcessor = f(unicastProcessor);
                                } else {
                                    this.f20695s = j11;
                                }
                            }
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void e(WindowBoundaryRunnable windowBoundaryRunnable) {
            this.f20679c.offer(windowBoundaryRunnable);
            c();
        }

        public UnicastProcessor<T> f(UnicastProcessor<T> unicastProcessor) {
            if (unicastProcessor != null) {
                unicastProcessor.onComplete();
                unicastProcessor = null;
            }
            if (this.f20688l.get()) {
                a();
            } else {
                long j11 = this.f20684h;
                if (this.f20683g.get() == j11) {
                    this.f20687k.cancel();
                    a();
                    this.f20689m = true;
                    this.f20678b.onError(new MissingBackpressureException(FlowableWindowTimed.b(j11)));
                } else {
                    long j12 = j11 + 1;
                    this.f20684h = j12;
                    this.f20690n.getAndIncrement();
                    unicastProcessor = UnicastProcessor.create(this.f20682f, this);
                    this.f20696t = unicastProcessor;
                    FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                    this.f20678b.onNext(flowableWindowSubscribeIntercept);
                    if (this.f20692p) {
                        SequentialDisposable sequentialDisposable = this.f20697u;
                        Scheduler.Worker worker = this.f20694r;
                        WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, j12);
                        long j13 = this.f20680d;
                        sequentialDisposable.update(worker.schedulePeriodically(windowBoundaryRunnable, j13, j13, this.f20681e));
                    }
                    if (flowableWindowSubscribeIntercept.b()) {
                        unicastProcessor.onComplete();
                    }
                }
            }
            return unicastProcessor;
        }

        public void run() {
            d();
        }
    }

    public static final class WindowExactUnboundedSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {

        /* renamed from: s  reason: collision with root package name */
        public static final Object f20700s = new Object();
        private static final long serialVersionUID = 1155822639622580836L;

        /* renamed from: o  reason: collision with root package name */
        public final Scheduler f20701o;

        /* renamed from: p  reason: collision with root package name */
        public UnicastProcessor<T> f20702p;

        /* renamed from: q  reason: collision with root package name */
        public final SequentialDisposable f20703q = new SequentialDisposable();

        /* renamed from: r  reason: collision with root package name */
        public final Runnable f20704r = new WindowRunnable();

        public final class WindowRunnable implements Runnable {
            public WindowRunnable() {
            }

            public void run() {
                WindowExactUnboundedSubscriber.this.d();
            }
        }

        public WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
            super(subscriber, j11, timeUnit, i11);
            this.f20701o = scheduler;
        }

        public void a() {
            this.f20703q.dispose();
        }

        public void b() {
            if (this.f20688l.get()) {
                return;
            }
            if (this.f20683g.get() != 0) {
                this.f20690n.getAndIncrement();
                this.f20702p = UnicastProcessor.create(this.f20682f, this.f20704r);
                this.f20684h = 1;
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(this.f20702p);
                this.f20678b.onNext(flowableWindowSubscribeIntercept);
                SequentialDisposable sequentialDisposable = this.f20703q;
                Scheduler scheduler = this.f20701o;
                long j11 = this.f20680d;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f20681e));
                if (flowableWindowSubscribeIntercept.b()) {
                    this.f20702p.onComplete();
                }
                this.f20687k.request(Long.MAX_VALUE);
                return;
            }
            this.f20687k.cancel();
            this.f20678b.onError(new MissingBackpressureException(FlowableWindowTimed.b(this.f20684h)));
            a();
            this.f20689m = true;
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.f20679c;
                Subscriber<? super Flowable<T>> subscriber = this.f20678b;
                UnicastProcessor<T> unicastProcessor = this.f20702p;
                int i11 = 1;
                while (true) {
                    if (this.f20689m) {
                        simplePlainQueue.clear();
                        this.f20702p = null;
                        unicastProcessor = null;
                    } else {
                        boolean z12 = this.f20685i;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable th2 = this.f20686j;
                            if (th2 != null) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onError(th2);
                                }
                                subscriber.onError(th2);
                            } else {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            a();
                            this.f20689m = true;
                        } else if (!z11) {
                            if (poll == f20700s) {
                                if (unicastProcessor != null) {
                                    unicastProcessor.onComplete();
                                    this.f20702p = null;
                                    unicastProcessor = null;
                                }
                                if (this.f20688l.get()) {
                                    this.f20703q.dispose();
                                } else {
                                    long j11 = this.f20683g.get();
                                    long j12 = this.f20684h;
                                    if (j11 == j12) {
                                        this.f20687k.cancel();
                                        a();
                                        this.f20689m = true;
                                        subscriber.onError(new MissingBackpressureException(FlowableWindowTimed.b(this.f20684h)));
                                    } else {
                                        this.f20684h = j12 + 1;
                                        this.f20690n.getAndIncrement();
                                        unicastProcessor = UnicastProcessor.create(this.f20682f, this.f20704r);
                                        this.f20702p = unicastProcessor;
                                        FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(unicastProcessor);
                                        subscriber.onNext(flowableWindowSubscribeIntercept);
                                        if (flowableWindowSubscribeIntercept.b()) {
                                            unicastProcessor.onComplete();
                                        }
                                    }
                                }
                            } else if (unicastProcessor != null) {
                                unicastProcessor.onNext(poll);
                            }
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void run() {
            this.f20679c.offer(f20700s);
            c();
        }
    }

    public static final class WindowSkipSubscriber<T> extends AbstractWindowSubscriber<T> implements Runnable {

        /* renamed from: r  reason: collision with root package name */
        public static final Object f20706r = new Object();

        /* renamed from: s  reason: collision with root package name */
        public static final Object f20707s = new Object();
        private static final long serialVersionUID = -7852870764194095894L;

        /* renamed from: o  reason: collision with root package name */
        public final long f20708o;

        /* renamed from: p  reason: collision with root package name */
        public final Scheduler.Worker f20709p;

        /* renamed from: q  reason: collision with root package name */
        public final List<UnicastProcessor<T>> f20710q = new LinkedList();

        public static final class WindowBoundaryRunnable implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final WindowSkipSubscriber<?> f20711b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f20712c;

            public WindowBoundaryRunnable(WindowSkipSubscriber<?> windowSkipSubscriber, boolean z11) {
                this.f20711b = windowSkipSubscriber;
                this.f20712c = z11;
            }

            public void run() {
                this.f20711b.e(this.f20712c);
            }
        }

        public WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker, int i11) {
            super(subscriber, j11, timeUnit, i11);
            this.f20708o = j12;
            this.f20709p = worker;
        }

        public void a() {
            this.f20709p.dispose();
        }

        public void b() {
            if (this.f20688l.get()) {
                return;
            }
            if (this.f20683g.get() != 0) {
                this.f20684h = 1;
                this.f20690n.getAndIncrement();
                UnicastProcessor create = UnicastProcessor.create(this.f20682f, this);
                this.f20710q.add(create);
                FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(create);
                this.f20678b.onNext(flowableWindowSubscribeIntercept);
                this.f20709p.schedule(new WindowBoundaryRunnable(this, false), this.f20680d, this.f20681e);
                Scheduler.Worker worker = this.f20709p;
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
                long j11 = this.f20708o;
                worker.schedulePeriodically(windowBoundaryRunnable, j11, j11, this.f20681e);
                if (flowableWindowSubscribeIntercept.b()) {
                    create.onComplete();
                    this.f20710q.remove(create);
                }
                this.f20687k.request(Long.MAX_VALUE);
                return;
            }
            this.f20687k.cancel();
            this.f20678b.onError(new MissingBackpressureException(FlowableWindowTimed.b(this.f20684h)));
            a();
            this.f20689m = true;
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.f20679c;
                Subscriber<? super Flowable<T>> subscriber = this.f20678b;
                List<UnicastProcessor<T>> list = this.f20710q;
                int i11 = 1;
                while (true) {
                    if (this.f20689m) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z12 = this.f20685i;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable th2 = this.f20686j;
                            if (th2 != null) {
                                for (UnicastProcessor<T> onError : list) {
                                    onError.onError(th2);
                                }
                                subscriber.onError(th2);
                            } else {
                                for (UnicastProcessor<T> onComplete : list) {
                                    onComplete.onComplete();
                                }
                                subscriber.onComplete();
                            }
                            a();
                            this.f20689m = true;
                        } else if (!z11) {
                            if (poll == f20706r) {
                                if (!this.f20688l.get()) {
                                    long j11 = this.f20684h;
                                    if (this.f20683g.get() != j11) {
                                        this.f20684h = j11 + 1;
                                        this.f20690n.getAndIncrement();
                                        UnicastProcessor create = UnicastProcessor.create(this.f20682f, this);
                                        list.add(create);
                                        FlowableWindowSubscribeIntercept flowableWindowSubscribeIntercept = new FlowableWindowSubscribeIntercept(create);
                                        subscriber.onNext(flowableWindowSubscribeIntercept);
                                        this.f20709p.schedule(new WindowBoundaryRunnable(this, false), this.f20680d, this.f20681e);
                                        if (flowableWindowSubscribeIntercept.b()) {
                                            create.onComplete();
                                        }
                                    } else {
                                        this.f20687k.cancel();
                                        MissingBackpressureException missingBackpressureException = new MissingBackpressureException(FlowableWindowTimed.b(j11));
                                        for (UnicastProcessor<T> onError2 : list) {
                                            onError2.onError(missingBackpressureException);
                                        }
                                        subscriber.onError(missingBackpressureException);
                                        a();
                                        this.f20689m = true;
                                    }
                                }
                            } else if (poll != f20707s) {
                                for (UnicastProcessor<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            } else if (!list.isEmpty()) {
                                list.remove(0).onComplete();
                            }
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
            }
        }

        public void e(boolean z11) {
            Object obj;
            SimplePlainQueue<Object> simplePlainQueue = this.f20679c;
            if (z11) {
                obj = f20706r;
            } else {
                obj = f20707s;
            }
            simplePlainQueue.offer(obj);
            c();
        }

        public void run() {
            d();
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, long j13, int i11, boolean z11) {
        super(flowable);
        this.f20671d = j11;
        this.f20672e = j12;
        this.f20673f = timeUnit;
        this.f20674g = scheduler;
        this.f20675h = j13;
        this.f20676i = i11;
        this.f20677j = z11;
    }

    public static String b(long j11) {
        return "Unable to emit the next window (#" + j11 + ") due to lack of requests. Please make sure the downstream is ready to consume windows.";
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        if (this.f20671d != this.f20672e) {
            this.f19260c.subscribe(new WindowSkipSubscriber(subscriber, this.f20671d, this.f20672e, this.f20673f, this.f20674g.createWorker(), this.f20676i));
        } else if (this.f20675h == Long.MAX_VALUE) {
            this.f19260c.subscribe(new WindowExactUnboundedSubscriber(subscriber, this.f20671d, this.f20673f, this.f20674g, this.f20676i));
        } else {
            this.f19260c.subscribe(new WindowExactBoundedSubscriber(subscriber, this.f20671d, this.f20673f, this.f20674g, this.f20676i, this.f20675h, this.f20677j));
        }
    }
}
