package io.reactivex.rxjava3.internal.operators.flowable;

import i.b;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final long f19372d;

    /* renamed from: e  reason: collision with root package name */
    public final long f19373e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f19374f;

    /* renamed from: g  reason: collision with root package name */
    public final Scheduler f19375g;

    /* renamed from: h  reason: collision with root package name */
    public final Supplier<U> f19376h;

    /* renamed from: i  reason: collision with root package name */
    public final int f19377i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f19378j;

    public static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public final Supplier<U> f19379i;

        /* renamed from: j  reason: collision with root package name */
        public final long f19380j;

        /* renamed from: k  reason: collision with root package name */
        public final TimeUnit f19381k;

        /* renamed from: l  reason: collision with root package name */
        public final int f19382l;

        /* renamed from: m  reason: collision with root package name */
        public final boolean f19383m;

        /* renamed from: n  reason: collision with root package name */
        public final Scheduler.Worker f19384n;

        /* renamed from: o  reason: collision with root package name */
        public U f19385o;

        /* renamed from: p  reason: collision with root package name */
        public Disposable f19386p;

        /* renamed from: q  reason: collision with root package name */
        public Subscription f19387q;

        /* renamed from: r  reason: collision with root package name */
        public long f19388r;

        /* renamed from: s  reason: collision with root package name */
        public long f19389s;

        public BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, long j11, TimeUnit timeUnit, int i11, boolean z11, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.f19379i = supplier;
            this.f19380j = j11;
            this.f19381k = timeUnit;
            this.f19382l = i11;
            this.f19383m = z11;
            this.f19384n = worker;
        }

        public void cancel() {
            if (!this.f23151f) {
                this.f23151f = true;
                dispose();
            }
        }

        public void dispose() {
            synchronized (this) {
                this.f19385o = null;
            }
            this.f19387q.cancel();
            this.f19384n.dispose();
        }

        public boolean isDisposed() {
            return this.f19384n.isDisposed();
        }

        public void onComplete() {
            U u11;
            synchronized (this) {
                u11 = this.f19385o;
                this.f19385o = null;
            }
            if (u11 != null) {
                this.f23150e.offer(u11);
                this.f23152g = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.f23150e, this.f23149d, false, this, this);
                }
                this.f19384n.dispose();
            }
        }

        public void onError(Throwable th2) {
            synchronized (this) {
                this.f19385o = null;
            }
            this.f23149d.onError(th2);
            this.f19384n.dispose();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r7.f19383m == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r7.f19386p.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            b(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8 = r7.f19379i.get();
            java.util.Objects.requireNonNull(r8, "The supplied buffer is null");
            r8 = (java.util.Collection) r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r7.f19385o = r8;
            r7.f19389s++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
            if (r7.f19383m == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            r0 = r7.f19384n;
            r4 = r7.f19380j;
            r7.f19386p = r0.schedulePeriodically(r7, r4, r4, r7.f19381k);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8);
            cancel();
            r7.f23149d.onError(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0064, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                U r0 = r7.f19385o     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                return
            L_0x0007:
                r0.add(r8)     // Catch:{ all -> 0x0065 }
                int r8 = r0.size()     // Catch:{ all -> 0x0065 }
                int r1 = r7.f19382l     // Catch:{ all -> 0x0065 }
                if (r8 >= r1) goto L_0x0014
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                return
            L_0x0014:
                r8 = 0
                r7.f19385o = r8     // Catch:{ all -> 0x0065 }
                long r1 = r7.f19388r     // Catch:{ all -> 0x0065 }
                r3 = 1
                long r1 = r1 + r3
                r7.f19388r = r1     // Catch:{ all -> 0x0065 }
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                boolean r8 = r7.f19383m
                if (r8 == 0) goto L_0x0028
                io.reactivex.rxjava3.disposables.Disposable r8 = r7.f19386p
                r8.dispose()
            L_0x0028:
                r8 = 0
                r7.b(r0, r8, r7)
                io.reactivex.rxjava3.functions.Supplier<U> r8 = r7.f19379i     // Catch:{ all -> 0x0058 }
                java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x0058 }
                java.lang.String r0 = "The supplied buffer is null"
                java.util.Objects.requireNonNull(r8, r0)     // Catch:{ all -> 0x0058 }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x0058 }
                monitor-enter(r7)
                r7.f19385o = r8     // Catch:{ all -> 0x0055 }
                long r0 = r7.f19389s     // Catch:{ all -> 0x0055 }
                long r0 = r0 + r3
                r7.f19389s = r0     // Catch:{ all -> 0x0055 }
                monitor-exit(r7)     // Catch:{ all -> 0x0055 }
                boolean r8 = r7.f19383m
                if (r8 == 0) goto L_0x0054
                io.reactivex.rxjava3.core.Scheduler$Worker r0 = r7.f19384n
                long r4 = r7.f19380j
                java.util.concurrent.TimeUnit r6 = r7.f19381k
                r1 = r7
                r2 = r4
                io.reactivex.rxjava3.disposables.Disposable r8 = r0.schedulePeriodically(r1, r2, r4, r6)
                r7.f19386p = r8
            L_0x0054:
                return
            L_0x0055:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0055 }
                throw r8
            L_0x0058:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8)
                r7.cancel()
                org.reactivestreams.Subscriber<? super V> r0 = r7.f23149d
                r0.onError(r8)
                return
            L_0x0065:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.onNext(java.lang.Object):void");
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19387q, subscription)) {
                this.f19387q = subscription;
                try {
                    U u11 = this.f19379i.get();
                    Objects.requireNonNull(u11, "The supplied buffer is null");
                    this.f19385o = (Collection) u11;
                    this.f23149d.onSubscribe(this);
                    Scheduler.Worker worker = this.f19384n;
                    long j11 = this.f19380j;
                    this.f19386p = worker.schedulePeriodically(this, j11, j11, this.f19381k);
                    subscription.request(Long.MAX_VALUE);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19384n.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th2, this.f23149d);
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public void run() {
            try {
                U u11 = this.f19379i.get();
                Objects.requireNonNull(u11, "The supplied buffer is null");
                U u12 = (Collection) u11;
                synchronized (this) {
                    U u13 = this.f19385o;
                    if (u13 != null) {
                        if (this.f19388r == this.f19389s) {
                            this.f19385o = u12;
                            b(u13, false, this);
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.f23149d.onError(th2);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u11) {
            subscriber.onNext(u11);
            return true;
        }
    }

    public static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public final Supplier<U> f19390i;

        /* renamed from: j  reason: collision with root package name */
        public final long f19391j;

        /* renamed from: k  reason: collision with root package name */
        public final TimeUnit f19392k;

        /* renamed from: l  reason: collision with root package name */
        public final Scheduler f19393l;

        /* renamed from: m  reason: collision with root package name */
        public Subscription f19394m;

        /* renamed from: n  reason: collision with root package name */
        public U f19395n;

        /* renamed from: o  reason: collision with root package name */
        public final AtomicReference<Disposable> f19396o = new AtomicReference<>();

        public BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.f19390i = supplier;
            this.f19391j = j11;
            this.f19392k = timeUnit;
            this.f19393l = scheduler;
        }

        public void cancel() {
            this.f23151f = true;
            this.f19394m.cancel();
            DisposableHelper.dispose(this.f19396o);
        }

        public void dispose() {
            cancel();
        }

        public boolean isDisposed() {
            return this.f19396o.get() == DisposableHelper.DISPOSED;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            if (enter() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            io.reactivex.rxjava3.internal.util.QueueDrainHelper.drainMaxLoop(r4.f23150e, r4.f23149d, false, (io.reactivex.rxjava3.disposables.Disposable) null, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
            r4.f23150e.offer(r0);
            r4.f23152g = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r4 = this;
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.disposables.Disposable> r0 = r4.f19396o
                io.reactivex.rxjava3.internal.disposables.DisposableHelper.dispose(r0)
                monitor-enter(r4)
                U r0 = r4.f19395n     // Catch:{ all -> 0x0027 }
                if (r0 != 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x0027 }
                return
            L_0x000c:
                r1 = 0
                r4.f19395n = r1     // Catch:{ all -> 0x0027 }
                monitor-exit(r4)     // Catch:{ all -> 0x0027 }
                io.reactivex.rxjava3.operators.SimplePlainQueue<U> r2 = r4.f23150e
                r2.offer(r0)
                r0 = 1
                r4.f23152g = r0
                boolean r0 = r4.enter()
                if (r0 == 0) goto L_0x0026
                io.reactivex.rxjava3.operators.SimplePlainQueue<U> r0 = r4.f23150e
                org.reactivestreams.Subscriber<? super V> r2 = r4.f23149d
                r3 = 0
                io.reactivex.rxjava3.internal.util.QueueDrainHelper.drainMaxLoop(r0, r2, r3, r1, r4)
            L_0x0026:
                return
            L_0x0027:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0027 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferTimed.BufferExactUnboundedSubscriber.onComplete():void");
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f19396o);
            synchronized (this) {
                this.f19395n = null;
            }
            this.f23149d.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f19395n;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19394m, subscription)) {
                this.f19394m = subscription;
                try {
                    U u11 = this.f19390i.get();
                    Objects.requireNonNull(u11, "The supplied buffer is null");
                    this.f19395n = (Collection) u11;
                    this.f23149d.onSubscribe(this);
                    if (!this.f23151f) {
                        subscription.request(Long.MAX_VALUE);
                        Scheduler scheduler = this.f19393l;
                        long j11 = this.f19391j;
                        Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f19392k);
                        if (!b.a(this.f19396o, (Object) null, schedulePeriodicallyDirect)) {
                            schedulePeriodicallyDirect.dispose();
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    EmptySubscription.error(th2, this.f23149d);
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public void run() {
            try {
                U u11 = this.f19390i.get();
                Objects.requireNonNull(u11, "The supplied buffer is null");
                U u12 = (Collection) u11;
                synchronized (this) {
                    U u13 = this.f19395n;
                    if (u13 != null) {
                        this.f19395n = u12;
                        a(u13, false, this);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.f23149d.onError(th2);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u11) {
            this.f23149d.onNext(u11);
            return true;
        }
    }

    public static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {

        /* renamed from: i  reason: collision with root package name */
        public final Supplier<U> f19397i;

        /* renamed from: j  reason: collision with root package name */
        public final long f19398j;

        /* renamed from: k  reason: collision with root package name */
        public final long f19399k;

        /* renamed from: l  reason: collision with root package name */
        public final TimeUnit f19400l;

        /* renamed from: m  reason: collision with root package name */
        public final Scheduler.Worker f19401m;

        /* renamed from: n  reason: collision with root package name */
        public final List<U> f19402n = new LinkedList();

        /* renamed from: o  reason: collision with root package name */
        public Subscription f19403o;

        public final class RemoveFromBuffer implements Runnable {
            private final U buffer;

            public RemoveFromBuffer(U u11) {
                this.buffer = u11;
            }

            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.f19402n.remove(this.buffer);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.b(this.buffer, false, bufferSkipBoundedSubscriber.f19401m);
            }
        }

        public BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Supplier<U> supplier, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.f19397i = supplier;
            this.f19398j = j11;
            this.f19399k = j12;
            this.f19400l = timeUnit;
            this.f19401m = worker;
        }

        public void cancel() {
            this.f23151f = true;
            this.f19403o.cancel();
            this.f19401m.dispose();
            d();
        }

        public void d() {
            synchronized (this) {
                this.f19402n.clear();
            }
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.f19402n);
                this.f19402n.clear();
            }
            for (Collection offer : arrayList) {
                this.f23150e.offer(offer);
            }
            this.f23152g = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.f23150e, this.f23149d, false, this.f19401m, this);
            }
        }

        public void onError(Throwable th2) {
            this.f23152g = true;
            this.f19401m.dispose();
            d();
            this.f23149d.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                for (U add : this.f19402n) {
                    add.add(t11);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f19403o, subscription)) {
                this.f19403o = subscription;
                try {
                    U u11 = this.f19397i.get();
                    Objects.requireNonNull(u11, "The supplied buffer is null");
                    Collection collection = (Collection) u11;
                    this.f19402n.add(collection);
                    this.f23149d.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    Scheduler.Worker worker = this.f19401m;
                    long j11 = this.f19399k;
                    worker.schedulePeriodically(this, j11, j11, this.f19400l);
                    this.f19401m.schedule(new RemoveFromBuffer(collection), this.f19398j, this.f19400l);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19401m.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th2, this.f23149d);
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public void run() {
            if (!this.f23151f) {
                try {
                    U u11 = this.f19397i.get();
                    Objects.requireNonNull(u11, "The supplied buffer is null");
                    Collection collection = (Collection) u11;
                    synchronized (this) {
                        if (!this.f23151f) {
                            this.f19402n.add(collection);
                            this.f19401m.schedule(new RemoveFromBuffer(collection), this.f19398j, this.f19400l);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    this.f23149d.onError(th2);
                }
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u11) {
            subscriber.onNext(u11);
            return true;
        }
    }

    public FlowableBufferTimed(Flowable<T> flowable, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, Supplier<U> supplier, int i11, boolean z11) {
        super(flowable);
        this.f19372d = j11;
        this.f19373e = j12;
        this.f19374f = timeUnit;
        this.f19375g = scheduler;
        this.f19376h = supplier;
        this.f19377i = i11;
        this.f19378j = z11;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.f19372d == this.f19373e && this.f19377i == Integer.MAX_VALUE) {
            this.f19260c.subscribe(new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.f19376h, this.f19372d, this.f19374f, this.f19375g));
            return;
        }
        Scheduler.Worker createWorker = this.f19375g.createWorker();
        if (this.f19372d == this.f19373e) {
            this.f19260c.subscribe(new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.f19376h, this.f19372d, this.f19374f, this.f19377i, this.f19378j, createWorker));
        } else {
            this.f19260c.subscribe(new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.f19376h, this.f19372d, this.f19373e, this.f19374f, createWorker));
        }
    }
}
