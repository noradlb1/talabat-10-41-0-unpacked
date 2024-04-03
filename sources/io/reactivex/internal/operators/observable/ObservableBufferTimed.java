package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final long f16903c;

    /* renamed from: d  reason: collision with root package name */
    public final long f16904d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f16905e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f16906f;

    /* renamed from: g  reason: collision with root package name */
    public final Callable<U> f16907g;

    /* renamed from: h  reason: collision with root package name */
    public final int f16908h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f16909i;

    public static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final Callable<U> f16910h;

        /* renamed from: i  reason: collision with root package name */
        public final long f16911i;

        /* renamed from: j  reason: collision with root package name */
        public final TimeUnit f16912j;

        /* renamed from: k  reason: collision with root package name */
        public final int f16913k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f16914l;

        /* renamed from: m  reason: collision with root package name */
        public final Scheduler.Worker f16915m;

        /* renamed from: n  reason: collision with root package name */
        public U f16916n;

        /* renamed from: o  reason: collision with root package name */
        public Disposable f16917o;

        /* renamed from: p  reason: collision with root package name */
        public Disposable f16918p;

        /* renamed from: q  reason: collision with root package name */
        public long f16919q;

        /* renamed from: r  reason: collision with root package name */
        public long f16920r;

        public BufferExactBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j11, TimeUnit timeUnit, int i11, boolean z11, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f16910h = callable;
            this.f16911i = j11;
            this.f16912j = timeUnit;
            this.f16913k = i11;
            this.f16914l = z11;
            this.f16915m = worker;
        }

        public void dispose() {
            if (!this.f14577e) {
                this.f14577e = true;
                this.f16918p.dispose();
                this.f16915m.dispose();
                synchronized (this) {
                    this.f16916n = null;
                }
            }
        }

        public boolean isDisposed() {
            return this.f14577e;
        }

        public void onComplete() {
            U u11;
            this.f16915m.dispose();
            synchronized (this) {
                u11 = this.f16916n;
                this.f16916n = null;
            }
            if (u11 != null) {
                this.f14576d.offer(u11);
                this.f14578f = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.f14576d, this.f14575c, false, this, this);
                }
            }
        }

        public void onError(Throwable th2) {
            synchronized (this) {
                this.f16916n = null;
            }
            this.f14575c.onError(th2);
            this.f16915m.dispose();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r7.f16914l == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r7.f16917o.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            b(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8 = (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(r7.f16910h.call(), "The buffer supplied is null");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r7.f16916n = r8;
            r7.f16920r++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
            if (r7.f16914l == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
            r0 = r7.f16915m;
            r4 = r7.f16911i;
            r7.f16917o = r0.schedulePeriodically(r7, r4, r4, r7.f16912j);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005a, code lost:
            io.reactivex.exceptions.Exceptions.throwIfFatal(r8);
            r7.f14575c.onError(r8);
            dispose();
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
                U r0 = r7.f16916n     // Catch:{ all -> 0x0066 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                return
            L_0x0007:
                r0.add(r8)     // Catch:{ all -> 0x0066 }
                int r8 = r0.size()     // Catch:{ all -> 0x0066 }
                int r1 = r7.f16913k     // Catch:{ all -> 0x0066 }
                if (r8 >= r1) goto L_0x0014
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                return
            L_0x0014:
                r8 = 0
                r7.f16916n = r8     // Catch:{ all -> 0x0066 }
                long r1 = r7.f16919q     // Catch:{ all -> 0x0066 }
                r3 = 1
                long r1 = r1 + r3
                r7.f16919q = r1     // Catch:{ all -> 0x0066 }
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                boolean r8 = r7.f16914l
                if (r8 == 0) goto L_0x0028
                io.reactivex.disposables.Disposable r8 = r7.f16917o
                r8.dispose()
            L_0x0028:
                r8 = 0
                r7.b(r0, r8, r7)
                java.util.concurrent.Callable<U> r8 = r7.f16910h     // Catch:{ all -> 0x0059 }
                java.lang.Object r8 = r8.call()     // Catch:{ all -> 0x0059 }
                java.lang.String r0 = "The buffer supplied is null"
                java.lang.Object r8 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r8, (java.lang.String) r0)     // Catch:{ all -> 0x0059 }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x0059 }
                monitor-enter(r7)
                r7.f16916n = r8     // Catch:{ all -> 0x0056 }
                long r0 = r7.f16920r     // Catch:{ all -> 0x0056 }
                long r0 = r0 + r3
                r7.f16920r = r0     // Catch:{ all -> 0x0056 }
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                boolean r8 = r7.f16914l
                if (r8 == 0) goto L_0x0055
                io.reactivex.Scheduler$Worker r0 = r7.f16915m
                long r4 = r7.f16911i
                java.util.concurrent.TimeUnit r6 = r7.f16912j
                r1 = r7
                r2 = r4
                io.reactivex.disposables.Disposable r8 = r0.schedulePeriodically(r1, r2, r4, r6)
                r7.f16917o = r8
            L_0x0055:
                return
            L_0x0056:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0056 }
                throw r8
            L_0x0059:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r8)
                io.reactivex.Observer<? super V> r0 = r7.f14575c
                r0.onError(r8)
                r7.dispose()
                return
            L_0x0066:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0066 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver.onNext(java.lang.Object):void");
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16918p, disposable)) {
                this.f16918p = disposable;
                try {
                    this.f16916n = (Collection) ObjectHelper.requireNonNull(this.f16910h.call(), "The buffer supplied is null");
                    this.f14575c.onSubscribe(this);
                    Scheduler.Worker worker = this.f16915m;
                    long j11 = this.f16911i;
                    this.f16917o = worker.schedulePeriodically(this, j11, j11, this.f16912j);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f14575c);
                    this.f16915m.dispose();
                }
            }
        }

        public void run() {
            try {
                U u11 = (Collection) ObjectHelper.requireNonNull(this.f16910h.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u12 = this.f16916n;
                    if (u12 != null) {
                        if (this.f16919q == this.f16920r) {
                            this.f16916n = u11;
                            b(u12, false, this);
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                dispose();
                this.f14575c.onError(th2);
            }
        }

        public void accept(Observer<? super U> observer, U u11) {
            observer.onNext(u11);
        }
    }

    public static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final Callable<U> f16921h;

        /* renamed from: i  reason: collision with root package name */
        public final long f16922i;

        /* renamed from: j  reason: collision with root package name */
        public final TimeUnit f16923j;

        /* renamed from: k  reason: collision with root package name */
        public final Scheduler f16924k;

        /* renamed from: l  reason: collision with root package name */
        public Disposable f16925l;

        /* renamed from: m  reason: collision with root package name */
        public U f16926m;

        /* renamed from: n  reason: collision with root package name */
        public final AtomicReference<Disposable> f16927n = new AtomicReference<>();

        public BufferExactUnboundedObserver(Observer<? super U> observer, Callable<U> callable, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.f16921h = callable;
            this.f16922i = j11;
            this.f16923j = timeUnit;
            this.f16924k = scheduler;
        }

        public void dispose() {
            DisposableHelper.dispose(this.f16927n);
            this.f16925l.dispose();
        }

        public boolean isDisposed() {
            return this.f16927n.get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            U u11;
            synchronized (this) {
                u11 = this.f16926m;
                this.f16926m = null;
            }
            if (u11 != null) {
                this.f14576d.offer(u11);
                this.f14578f = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.f14576d, this.f14575c, false, (Disposable) null, this);
                }
            }
            DisposableHelper.dispose(this.f16927n);
        }

        public void onError(Throwable th2) {
            synchronized (this) {
                this.f16926m = null;
            }
            this.f14575c.onError(th2);
            DisposableHelper.dispose(this.f16927n);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f16926m;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16925l, disposable)) {
                this.f16925l = disposable;
                try {
                    this.f16926m = (Collection) ObjectHelper.requireNonNull(this.f16921h.call(), "The buffer supplied is null");
                    this.f14575c.onSubscribe(this);
                    if (!this.f14577e) {
                        Scheduler scheduler = this.f16924k;
                        long j11 = this.f16922i;
                        Disposable schedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f16923j);
                        if (!b.a(this.f16927n, (Object) null, schedulePeriodicallyDirect)) {
                            schedulePeriodicallyDirect.dispose();
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f14575c);
                }
            }
        }

        public void run() {
            U u11;
            try {
                U u12 = (Collection) ObjectHelper.requireNonNull(this.f16921h.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u11 = this.f16926m;
                    if (u11 != null) {
                        this.f16926m = u12;
                    }
                }
                if (u11 == null) {
                    DisposableHelper.dispose(this.f16927n);
                } else {
                    a(u11, false, this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f14575c.onError(th2);
                dispose();
            }
        }

        public void accept(Observer<? super U> observer, U u11) {
            this.f14575c.onNext(u11);
        }
    }

    public static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final Callable<U> f16928h;

        /* renamed from: i  reason: collision with root package name */
        public final long f16929i;

        /* renamed from: j  reason: collision with root package name */
        public final long f16930j;

        /* renamed from: k  reason: collision with root package name */
        public final TimeUnit f16931k;

        /* renamed from: l  reason: collision with root package name */
        public final Scheduler.Worker f16932l;

        /* renamed from: m  reason: collision with root package name */
        public final List<U> f16933m = new LinkedList();

        /* renamed from: n  reason: collision with root package name */
        public Disposable f16934n;

        public final class RemoveFromBuffer implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final U f16935b;

            public RemoveFromBuffer(U u11) {
                this.f16935b = u11;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f16933m.remove(this.f16935b);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.b(this.f16935b, false, bufferSkipBoundedObserver.f16932l);
            }
        }

        public final class RemoveFromBufferEmit implements Runnable {
            private final U buffer;

            public RemoveFromBufferEmit(U u11) {
                this.buffer = u11;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f16933m.remove(this.buffer);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.b(this.buffer, false, bufferSkipBoundedObserver.f16932l);
            }
        }

        public BufferSkipBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f16928h = callable;
            this.f16929i = j11;
            this.f16930j = j12;
            this.f16931k = timeUnit;
            this.f16932l = worker;
        }

        public void dispose() {
            if (!this.f14577e) {
                this.f14577e = true;
                e();
                this.f16934n.dispose();
                this.f16932l.dispose();
            }
        }

        public void e() {
            synchronized (this) {
                this.f16933m.clear();
            }
        }

        public boolean isDisposed() {
            return this.f14577e;
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.f16933m);
                this.f16933m.clear();
            }
            for (Collection offer : arrayList) {
                this.f14576d.offer(offer);
            }
            this.f14578f = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.f14576d, this.f14575c, false, this.f16932l, this);
            }
        }

        public void onError(Throwable th2) {
            this.f14578f = true;
            e();
            this.f14575c.onError(th2);
            this.f16932l.dispose();
        }

        public void onNext(T t11) {
            synchronized (this) {
                for (U add : this.f16933m) {
                    add.add(t11);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16934n, disposable)) {
                this.f16934n = disposable;
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.f16928h.call(), "The buffer supplied is null");
                    this.f16933m.add(collection);
                    this.f14575c.onSubscribe(this);
                    Scheduler.Worker worker = this.f16932l;
                    long j11 = this.f16930j;
                    worker.schedulePeriodically(this, j11, j11, this.f16931k);
                    this.f16932l.schedule(new RemoveFromBufferEmit(collection), this.f16929i, this.f16931k);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f14575c);
                    this.f16932l.dispose();
                }
            }
        }

        public void run() {
            if (!this.f14577e) {
                try {
                    Collection collection = (Collection) ObjectHelper.requireNonNull(this.f16928h.call(), "The bufferSupplier returned a null buffer");
                    synchronized (this) {
                        if (!this.f14577e) {
                            this.f16933m.add(collection);
                            this.f16932l.schedule(new RemoveFromBuffer(collection), this.f16929i, this.f16931k);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f14575c.onError(th2);
                    dispose();
                }
            }
        }

        public void accept(Observer<? super U> observer, U u11) {
            observer.onNext(u11);
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i11, boolean z11) {
        super(observableSource);
        this.f16903c = j11;
        this.f16904d = j12;
        this.f16905e = timeUnit;
        this.f16906f = scheduler;
        this.f16907g = callable;
        this.f16908h = i11;
        this.f16909i = z11;
    }

    public void subscribeActual(Observer<? super U> observer) {
        if (this.f16903c == this.f16904d && this.f16908h == Integer.MAX_VALUE) {
            this.f16799b.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.f16907g, this.f16903c, this.f16905e, this.f16906f));
            return;
        }
        Scheduler.Worker createWorker = this.f16906f.createWorker();
        if (this.f16903c == this.f16904d) {
            this.f16799b.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.f16907g, this.f16903c, this.f16905e, this.f16908h, this.f16909i, createWorker));
        } else {
            this.f16799b.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.f16907g, this.f16903c, this.f16904d, this.f16905e, createWorker));
        }
    }
}
