package io.reactivex.internal.operators.flowable;

import i.b;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final long f14884d;

    /* renamed from: e  reason: collision with root package name */
    public final long f14885e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f14886f;

    /* renamed from: g  reason: collision with root package name */
    public final Scheduler f14887g;

    /* renamed from: h  reason: collision with root package name */
    public final Callable<U> f14888h;

    /* renamed from: i  reason: collision with root package name */
    public final int f14889i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f14890j;

    public static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public final Callable<U> f14891i;

        /* renamed from: j  reason: collision with root package name */
        public final long f14892j;

        /* renamed from: k  reason: collision with root package name */
        public final TimeUnit f14893k;

        /* renamed from: l  reason: collision with root package name */
        public final int f14894l;

        /* renamed from: m  reason: collision with root package name */
        public final boolean f14895m;

        /* renamed from: n  reason: collision with root package name */
        public final Scheduler.Worker f14896n;

        /* renamed from: o  reason: collision with root package name */
        public U f14897o;

        /* renamed from: p  reason: collision with root package name */
        public Disposable f14898p;

        /* renamed from: q  reason: collision with root package name */
        public Subscription f14899q;

        /* renamed from: r  reason: collision with root package name */
        public long f14900r;

        /* renamed from: s  reason: collision with root package name */
        public long f14901s;

        public BufferExactBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j11, TimeUnit timeUnit, int i11, boolean z11, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.f14891i = callable;
            this.f14892j = j11;
            this.f14893k = timeUnit;
            this.f14894l = i11;
            this.f14895m = z11;
            this.f14896n = worker;
        }

        public void cancel() {
            if (!this.f18590f) {
                this.f18590f = true;
                dispose();
            }
        }

        public void dispose() {
            synchronized (this) {
                this.f14897o = null;
            }
            this.f14899q.cancel();
            this.f14896n.dispose();
        }

        public boolean isDisposed() {
            return this.f14896n.isDisposed();
        }

        public void onComplete() {
            U u11;
            synchronized (this) {
                u11 = this.f14897o;
                this.f14897o = null;
            }
            if (u11 != null) {
                this.f18589e.offer(u11);
                this.f18591g = true;
                if (enter()) {
                    QueueDrainHelper.drainMaxLoop(this.f18589e, this.f18588d, false, this, this);
                }
                this.f14896n.dispose();
            }
        }

        public void onError(Throwable th2) {
            synchronized (this) {
                this.f14897o = null;
            }
            this.f18588d.onError(th2);
            this.f14896n.dispose();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r7.f14895m == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r7.f14898p.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            b(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8 = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(r7.f14891i.call(), "The supplied buffer is null");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r7.f14897o = r8;
            r7.f14901s++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
            if (r7.f14895m == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
            r0 = r7.f14896n;
            r4 = r7.f14892j;
            r7.f14898p = r0.schedulePeriodically(r7, r4, r4, r7.f14893k);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r8);
            cancel();
            r7.f18588d.onError(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0065, code lost:
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
                U r0 = r7.f14897o     // Catch:{ all -> 0x0066 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                return
            L_0x0007:
                r0.add(r8)     // Catch:{ all -> 0x0066 }
                int r8 = r0.size()     // Catch:{ all -> 0x0066 }
                int r1 = r7.f14894l     // Catch:{ all -> 0x0066 }
                if (r8 >= r1) goto L_0x0014
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                return
            L_0x0014:
                r8 = 0
                r7.f14897o = r8     // Catch:{ all -> 0x0066 }
                long r1 = r7.f14900r     // Catch:{ all -> 0x0066 }
                r3 = 1
                long r1 = r1 + r3
                r7.f14900r = r1     // Catch:{ all -> 0x0066 }
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                boolean r8 = r7.f14895m
                if (r8 == 0) goto L_0x0028
                io.reactivex.disposables.Disposable r8 = r7.f14898p
                r8.dispose()
            L_0x0028:
                r8 = 0
                r7.b(r0, r8, r7)
                java.util.concurrent.Callable<U> r8 = r7.f14891i     // Catch:{ all -> 0x0059 }
                java.lang.Object r8 = r8.call()     // Catch:{ all -> 0x0059 }
                java.lang.String r0 = "The supplied buffer is null"
                java.lang.Object r8 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r8, (java.lang.String) r0)     // Catch:{ all -> 0x0059 }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x0059 }
                monitor-enter(r7)
                r7.f14897o = r8     // Catch:{ all -> 0x0056 }
                long r0 = r7.f14901s     // Catch:{ all -> 0x0056 }
                long r0 = r0 + r3
                r7.f14901s = r0     // Catch:{ all -> 0x0056 }
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                boolean r8 = r7.f14895m
                if (r8 == 0) goto L_0x0055
                io.reactivex.Scheduler$Worker r0 = r7.f14896n
                long r4 = r7.f14892j
                java.util.concurrent.TimeUnit r6 = r7.f14893k
                r1 = r7
                r2 = r4
                io.reactivex.disposables.Disposable r8 = r0.schedulePeriodically(r1, r2, r4, r6)
                r7.f14898p = r8
            L_0x0055:
                return
            L_0x0056:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                throw r8
            L_0x0059:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r8)
                r7.cancel()
                org.reactivestreams.Subscriber<? super V> r0 = r7.f18588d
                r0.onError(r8)
                return
            L_0x0066:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.onNext(java.lang.Object):void");
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14899q, subscription)) {
                this.f14899q = subscription;
                try {
                    this.f14897o = (Collection) ObjectHelper.requireNonNull(this.f14891i.call(), "The supplied buffer is null");
                    this.f18588d.onSubscribe(this);
                    Scheduler.Worker worker = this.f14896n;
                    long j11 = this.f14892j;
                    this.f14898p = worker.schedulePeriodically(this, j11, j11, this.f14893k);
                    subscription.request(Long.MAX_VALUE);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14896n.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th2, this.f18588d);
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public void run() {
            try {
                U u11 = (Collection) ObjectHelper.requireNonNull(this.f14891i.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u12 = this.f14897o;
                    if (u12 != null) {
                        if (this.f14900r == this.f14901s) {
                            this.f14897o = u11;
                            b(u12, false, this);
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.f18588d.onError(th2);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u11) {
            subscriber.onNext(u11);
            return true;
        }
    }

    public static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public final Callable<U> f14902i;

        /* renamed from: j  reason: collision with root package name */
        public final long f14903j;

        /* renamed from: k  reason: collision with root package name */
        public final TimeUnit f14904k;

        /* renamed from: l  reason: collision with root package name */
        public final Scheduler f14905l;

        /* renamed from: m  reason: collision with root package name */
        public Subscription f14906m;

        /* renamed from: n  reason: collision with root package name */
        public U f14907n;

        /* renamed from: o  reason: collision with root package name */
        public final AtomicReference<Disposable> f14908o = new AtomicReference<>();

        public BufferExactUnboundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.f14902i = callable;
            this.f14903j = j11;
            this.f14904k = timeUnit;
            this.f14905l = scheduler;
        }

        public void cancel() {
            this.f18590f = true;
            this.f14906m.cancel();
            DisposableHelper.dispose(this.f14908o);
        }

        public void dispose() {
            cancel();
        }

        public boolean isDisposed() {
            return this.f14908o.get() == DisposableHelper.DISPOSED;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            if (enter() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
            io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r4.f18589e, r4.f18588d, false, (io.reactivex.disposables.Disposable) null, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
            r4.f18589e.offer(r0);
            r4.f18591g = true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r4 = this;
                java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> r0 = r4.f14908o
                io.reactivex.internal.disposables.DisposableHelper.dispose(r0)
                monitor-enter(r4)
                U r0 = r4.f14907n     // Catch:{ all -> 0x0027 }
                if (r0 != 0) goto L_0x000c
                monitor-exit(r4)     // Catch:{ all -> 0x0027 }
                return
            L_0x000c:
                r1 = 0
                r4.f14907n = r1     // Catch:{ all -> 0x0027 }
                monitor-exit(r4)     // Catch:{ all -> 0x0027 }
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r2 = r4.f18589e
                r2.offer(r0)
                r0 = 1
                r4.f18591g = r0
                boolean r0 = r4.enter()
                if (r0 == 0) goto L_0x0026
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r4.f18589e
                org.reactivestreams.Subscriber<? super V> r2 = r4.f18588d
                r3 = 0
                io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r0, r2, r3, r1, r4)
            L_0x0026:
                return
            L_0x0027:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0027 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactUnboundedSubscriber.onComplete():void");
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f14908o);
            synchronized (this) {
                this.f14907n = null;
            }
            this.f18588d.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f14907n;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14906m, subscription)) {
                this.f14906m = subscription;
                try {
                    this.f14907n = (Collection) ObjectHelper.requireNonNull(this.f14902i.call(), "The supplied buffer is null");
                    this.f18588d.onSubscribe(this);
                    if (!this.f18590f) {
                        subscription.request(Long.MAX_VALUE);
                        Scheduler scheduler = this.f14905l;
                        long j11 = this.f14903j;
                        Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f14904k);
                        if (!b.a(this.f14908o, (Object) null, schedulePeriodicallyDirect)) {
                            schedulePeriodicallyDirect.dispose();
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    EmptySubscription.error(th2, this.f18588d);
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public void run() {
            try {
                U u11 = (Collection) ObjectHelper.requireNonNull(this.f14902i.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u12 = this.f14907n;
                    if (u12 != null) {
                        this.f14907n = u11;
                        a(u12, false, this);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                cancel();
                this.f18588d.onError(th2);
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u11) {
            this.f18588d.onNext(u11);
            return true;
        }
    }

    public static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {

        /* renamed from: i  reason: collision with root package name */
        public final Callable<U> f14909i;

        /* renamed from: j  reason: collision with root package name */
        public final long f14910j;

        /* renamed from: k  reason: collision with root package name */
        public final long f14911k;

        /* renamed from: l  reason: collision with root package name */
        public final TimeUnit f14912l;

        /* renamed from: m  reason: collision with root package name */
        public final Scheduler.Worker f14913m;

        /* renamed from: n  reason: collision with root package name */
        public final List<U> f14914n = new LinkedList();

        /* renamed from: o  reason: collision with root package name */
        public Subscription f14915o;

        public final class RemoveFromBuffer implements Runnable {
            private final U buffer;

            public RemoveFromBuffer(U u11) {
                this.buffer = u11;
            }

            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.f14914n.remove(this.buffer);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.b(this.buffer, false, bufferSkipBoundedSubscriber.f14913m);
            }
        }

        public BufferSkipBoundedSubscriber(Subscriber<? super U> subscriber, Callable<U> callable, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.f14909i = callable;
            this.f14910j = j11;
            this.f14911k = j12;
            this.f14912l = timeUnit;
            this.f14913m = worker;
        }

        public void cancel() {
            this.f18590f = true;
            this.f14915o.cancel();
            this.f14913m.dispose();
            d();
        }

        public void d() {
            synchronized (this) {
                this.f14914n.clear();
            }
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.f14914n);
                this.f14914n.clear();
            }
            for (Collection offer : arrayList) {
                this.f18589e.offer(offer);
            }
            this.f18591g = true;
            if (enter()) {
                QueueDrainHelper.drainMaxLoop(this.f18589e, this.f18588d, false, this.f14913m, this);
            }
        }

        public void onError(Throwable th2) {
            this.f18591g = true;
            this.f14913m.dispose();
            d();
            this.f18588d.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                for (U add : this.f14914n) {
                    add.add(t11);
                }
            }
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f14915o, subscription)) {
                this.f14915o = subscription;
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.f14909i.call(), "The supplied buffer is null");
                    this.f14914n.add(collection);
                    this.f18588d.onSubscribe(this);
                    subscription.request(Long.MAX_VALUE);
                    Scheduler.Worker worker = this.f14913m;
                    long j11 = this.f14911k;
                    worker.schedulePeriodically(this, j11, j11, this.f14912l);
                    this.f14913m.schedule(new RemoveFromBuffer(collection), this.f14910j, this.f14912l);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14913m.dispose();
                    subscription.cancel();
                    EmptySubscription.error(th2, this.f18588d);
                }
            }
        }

        public void request(long j11) {
            requested(j11);
        }

        public void run() {
            if (!this.f18590f) {
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.f14909i.call(), "The supplied buffer is null");
                    synchronized (this) {
                        if (!this.f18590f) {
                            this.f14914n.add(collection);
                            this.f14913m.schedule(new RemoveFromBuffer(collection), this.f14910j, this.f14912l);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    cancel();
                    this.f18588d.onError(th2);
                }
            }
        }

        public boolean accept(Subscriber<? super U> subscriber, U u11) {
            subscriber.onNext(u11);
            return true;
        }
    }

    public FlowableBufferTimed(Flowable<T> flowable, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i11, boolean z11) {
        super(flowable);
        this.f14884d = j11;
        this.f14885e = j12;
        this.f14886f = timeUnit;
        this.f14887g = scheduler;
        this.f14888h = callable;
        this.f14889i = i11;
        this.f14890j = z11;
    }

    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.f14884d == this.f14885e && this.f14889i == Integer.MAX_VALUE) {
            this.f14763c.subscribe(new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.f14888h, this.f14884d, this.f14886f, this.f14887g));
            return;
        }
        Scheduler.Worker createWorker = this.f14887g.createWorker();
        if (this.f14884d == this.f14885e) {
            this.f14763c.subscribe(new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.f14888h, this.f14884d, this.f14886f, this.f14889i, this.f14890j, createWorker));
        } else {
            this.f14763c.subscribe(new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.f14888h, this.f14884d, this.f14885e, this.f14886f, createWorker));
        }
    }
}
