package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.QueueDrainObserver;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final long f21399c;

    /* renamed from: d  reason: collision with root package name */
    public final long f21400d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f21401e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f21402f;

    /* renamed from: g  reason: collision with root package name */
    public final Supplier<U> f21403g;

    /* renamed from: h  reason: collision with root package name */
    public final int f21404h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f21405i;

    public static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final Supplier<U> f21406h;

        /* renamed from: i  reason: collision with root package name */
        public final long f21407i;

        /* renamed from: j  reason: collision with root package name */
        public final TimeUnit f21408j;

        /* renamed from: k  reason: collision with root package name */
        public final int f21409k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f21410l;

        /* renamed from: m  reason: collision with root package name */
        public final Scheduler.Worker f21411m;

        /* renamed from: n  reason: collision with root package name */
        public U f21412n;

        /* renamed from: o  reason: collision with root package name */
        public Disposable f21413o;

        /* renamed from: p  reason: collision with root package name */
        public Disposable f21414p;

        /* renamed from: q  reason: collision with root package name */
        public long f21415q;

        /* renamed from: r  reason: collision with root package name */
        public long f21416r;

        public BufferExactBoundedObserver(Observer<? super U> observer, Supplier<U> supplier, long j11, TimeUnit timeUnit, int i11, boolean z11, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f21406h = supplier;
            this.f21407i = j11;
            this.f21408j = timeUnit;
            this.f21409k = i11;
            this.f21410l = z11;
            this.f21411m = worker;
        }

        public void dispose() {
            if (!this.f19058e) {
                this.f19058e = true;
                this.f21414p.dispose();
                this.f21411m.dispose();
                synchronized (this) {
                    this.f21412n = null;
                }
            }
        }

        public boolean isDisposed() {
            return this.f19058e;
        }

        public void onComplete() {
            U u11;
            this.f21411m.dispose();
            synchronized (this) {
                u11 = this.f21412n;
                this.f21412n = null;
            }
            if (u11 != null) {
                this.f19057d.offer(u11);
                this.f19059f = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.f19057d, this.f19056c, false, this, this);
                }
            }
        }

        public void onError(Throwable th2) {
            synchronized (this) {
                this.f21412n = null;
            }
            this.f19056c.onError(th2);
            this.f21411m.dispose();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r7.f21410l == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r7.f21413o.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            b(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r8 = r7.f21406h.get();
            java.util.Objects.requireNonNull(r8, "The buffer supplied is null");
            r8 = (java.util.Collection) r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r7.f21412n = r8;
            r7.f21416r++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
            if (r7.f21410l == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            r0 = r7.f21411m;
            r4 = r7.f21407i;
            r7.f21413o = r0.schedulePeriodically(r7, r4, r4, r7.f21408j);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8);
            r7.f19056c.onError(r8);
            dispose();
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
                U r0 = r7.f21412n     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                return
            L_0x0007:
                r0.add(r8)     // Catch:{ all -> 0x0065 }
                int r8 = r0.size()     // Catch:{ all -> 0x0065 }
                int r1 = r7.f21409k     // Catch:{ all -> 0x0065 }
                if (r8 >= r1) goto L_0x0014
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                return
            L_0x0014:
                r8 = 0
                r7.f21412n = r8     // Catch:{ all -> 0x0065 }
                long r1 = r7.f21415q     // Catch:{ all -> 0x0065 }
                r3 = 1
                long r1 = r1 + r3
                r7.f21415q = r1     // Catch:{ all -> 0x0065 }
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                boolean r8 = r7.f21410l
                if (r8 == 0) goto L_0x0028
                io.reactivex.rxjava3.disposables.Disposable r8 = r7.f21413o
                r8.dispose()
            L_0x0028:
                r8 = 0
                r7.b(r0, r8, r7)
                io.reactivex.rxjava3.functions.Supplier<U> r8 = r7.f21406h     // Catch:{ all -> 0x0058 }
                java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x0058 }
                java.lang.String r0 = "The buffer supplied is null"
                java.util.Objects.requireNonNull(r8, r0)     // Catch:{ all -> 0x0058 }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x0058 }
                monitor-enter(r7)
                r7.f21412n = r8     // Catch:{ all -> 0x0055 }
                long r0 = r7.f21416r     // Catch:{ all -> 0x0055 }
                long r0 = r0 + r3
                r7.f21416r = r0     // Catch:{ all -> 0x0055 }
                monitor-exit(r7)     // Catch:{ all -> 0x0055 }
                boolean r8 = r7.f21410l
                if (r8 == 0) goto L_0x0054
                io.reactivex.rxjava3.core.Scheduler$Worker r0 = r7.f21411m
                long r4 = r7.f21407i
                java.util.concurrent.TimeUnit r6 = r7.f21408j
                r1 = r7
                r2 = r4
                io.reactivex.rxjava3.disposables.Disposable r8 = r0.schedulePeriodically(r1, r2, r4, r6)
                r7.f21413o = r8
            L_0x0054:
                return
            L_0x0055:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0055 }
                throw r8
            L_0x0058:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.throwIfFatal(r8)
                io.reactivex.rxjava3.core.Observer<? super V> r0 = r7.f19056c
                r0.onError(r8)
                r7.dispose()
                return
            L_0x0065:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0065 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver.onNext(java.lang.Object):void");
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21414p, disposable)) {
                this.f21414p = disposable;
                try {
                    U u11 = this.f21406h.get();
                    Objects.requireNonNull(u11, "The buffer supplied is null");
                    this.f21412n = (Collection) u11;
                    this.f19056c.onSubscribe(this);
                    Scheduler.Worker worker = this.f21411m;
                    long j11 = this.f21407i;
                    this.f21413o = worker.schedulePeriodically(this, j11, j11, this.f21408j);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f19056c);
                    this.f21411m.dispose();
                }
            }
        }

        public void run() {
            try {
                U u11 = this.f21406h.get();
                Objects.requireNonNull(u11, "The bufferSupplier returned a null buffer");
                U u12 = (Collection) u11;
                synchronized (this) {
                    U u13 = this.f21412n;
                    if (u13 != null) {
                        if (this.f21415q == this.f21416r) {
                            this.f21412n = u12;
                            b(u13, false, this);
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                dispose();
                this.f19056c.onError(th2);
            }
        }

        public void accept(Observer<? super U> observer, U u11) {
            observer.onNext(u11);
        }
    }

    public static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final Supplier<U> f21417h;

        /* renamed from: i  reason: collision with root package name */
        public final long f21418i;

        /* renamed from: j  reason: collision with root package name */
        public final TimeUnit f21419j;

        /* renamed from: k  reason: collision with root package name */
        public final Scheduler f21420k;

        /* renamed from: l  reason: collision with root package name */
        public Disposable f21421l;

        /* renamed from: m  reason: collision with root package name */
        public U f21422m;

        /* renamed from: n  reason: collision with root package name */
        public final AtomicReference<Disposable> f21423n = new AtomicReference<>();

        public BufferExactUnboundedObserver(Observer<? super U> observer, Supplier<U> supplier, long j11, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.f21417h = supplier;
            this.f21418i = j11;
            this.f21419j = timeUnit;
            this.f21420k = scheduler;
        }

        public void dispose() {
            DisposableHelper.dispose(this.f21423n);
            this.f21421l.dispose();
        }

        public boolean isDisposed() {
            return this.f21423n.get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            U u11;
            synchronized (this) {
                u11 = this.f21422m;
                this.f21422m = null;
            }
            if (u11 != null) {
                this.f19057d.offer(u11);
                this.f19059f = true;
                if (enter()) {
                    QueueDrainHelper.drainLoop(this.f19057d, this.f19056c, false, (Disposable) null, this);
                }
            }
            DisposableHelper.dispose(this.f21423n);
        }

        public void onError(Throwable th2) {
            synchronized (this) {
                this.f21422m = null;
            }
            this.f19056c.onError(th2);
            DisposableHelper.dispose(this.f21423n);
        }

        public void onNext(T t11) {
            synchronized (this) {
                U u11 = this.f21422m;
                if (u11 != null) {
                    u11.add(t11);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21421l, disposable)) {
                this.f21421l = disposable;
                try {
                    U u11 = this.f21417h.get();
                    Objects.requireNonNull(u11, "The buffer supplied is null");
                    this.f21422m = (Collection) u11;
                    this.f19056c.onSubscribe(this);
                    if (!DisposableHelper.isDisposed(this.f21423n.get())) {
                        Scheduler scheduler = this.f21420k;
                        long j11 = this.f21418i;
                        DisposableHelper.set(this.f21423n, scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f21419j));
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f19056c);
                }
            }
        }

        public void run() {
            U u11;
            try {
                U u12 = this.f21417h.get();
                Objects.requireNonNull(u12, "The bufferSupplier returned a null buffer");
                U u13 = (Collection) u12;
                synchronized (this) {
                    u11 = this.f21422m;
                    if (u11 != null) {
                        this.f21422m = u13;
                    }
                }
                if (u11 == null) {
                    DisposableHelper.dispose(this.f21423n);
                } else {
                    a(u11, false, this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f19056c.onError(th2);
                dispose();
            }
        }

        public void accept(Observer<? super U> observer, U u11) {
            this.f19056c.onNext(u11);
        }
    }

    public static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final Supplier<U> f21424h;

        /* renamed from: i  reason: collision with root package name */
        public final long f21425i;

        /* renamed from: j  reason: collision with root package name */
        public final long f21426j;

        /* renamed from: k  reason: collision with root package name */
        public final TimeUnit f21427k;

        /* renamed from: l  reason: collision with root package name */
        public final Scheduler.Worker f21428l;

        /* renamed from: m  reason: collision with root package name */
        public final List<U> f21429m = new LinkedList();

        /* renamed from: n  reason: collision with root package name */
        public Disposable f21430n;

        public final class RemoveFromBuffer implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final U f21431b;

            public RemoveFromBuffer(U u11) {
                this.f21431b = u11;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f21429m.remove(this.f21431b);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.b(this.f21431b, false, bufferSkipBoundedObserver.f21428l);
            }
        }

        public final class RemoveFromBufferEmit implements Runnable {
            private final U buffer;

            public RemoveFromBufferEmit(U u11) {
                this.buffer = u11;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f21429m.remove(this.buffer);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.b(this.buffer, false, bufferSkipBoundedObserver.f21428l);
            }
        }

        public BufferSkipBoundedObserver(Observer<? super U> observer, Supplier<U> supplier, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f21424h = supplier;
            this.f21425i = j11;
            this.f21426j = j12;
            this.f21427k = timeUnit;
            this.f21428l = worker;
        }

        public void dispose() {
            if (!this.f19058e) {
                this.f19058e = true;
                e();
                this.f21430n.dispose();
                this.f21428l.dispose();
            }
        }

        public void e() {
            synchronized (this) {
                this.f21429m.clear();
            }
        }

        public boolean isDisposed() {
            return this.f19058e;
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.f21429m);
                this.f21429m.clear();
            }
            for (Collection offer : arrayList) {
                this.f19057d.offer(offer);
            }
            this.f19059f = true;
            if (enter()) {
                QueueDrainHelper.drainLoop(this.f19057d, this.f19056c, false, this.f21428l, this);
            }
        }

        public void onError(Throwable th2) {
            this.f19059f = true;
            e();
            this.f19056c.onError(th2);
            this.f21428l.dispose();
        }

        public void onNext(T t11) {
            synchronized (this) {
                for (U add : this.f21429m) {
                    add.add(t11);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21430n, disposable)) {
                this.f21430n = disposable;
                try {
                    U u11 = this.f21424h.get();
                    Objects.requireNonNull(u11, "The buffer supplied is null");
                    Collection collection = (Collection) u11;
                    this.f21429m.add(collection);
                    this.f19056c.onSubscribe(this);
                    Scheduler.Worker worker = this.f21428l;
                    long j11 = this.f21426j;
                    worker.schedulePeriodically(this, j11, j11, this.f21427k);
                    this.f21428l.schedule(new RemoveFromBufferEmit(collection), this.f21425i, this.f21427k);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    disposable.dispose();
                    EmptyDisposable.error(th2, (Observer<?>) this.f19056c);
                    this.f21428l.dispose();
                }
            }
        }

        public void run() {
            if (!this.f19058e) {
                try {
                    U u11 = this.f21424h.get();
                    Objects.requireNonNull(u11, "The bufferSupplier returned a null buffer");
                    Collection collection = (Collection) u11;
                    synchronized (this) {
                        if (!this.f19058e) {
                            this.f21429m.add(collection);
                            this.f21428l.schedule(new RemoveFromBuffer(collection), this.f21425i, this.f21427k);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f19056c.onError(th2);
                    dispose();
                }
            }
        }

        public void accept(Observer<? super U> observer, U u11) {
            observer.onNext(u11);
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, Supplier<U> supplier, int i11, boolean z11) {
        super(observableSource);
        this.f21399c = j11;
        this.f21400d = j12;
        this.f21401e = timeUnit;
        this.f21402f = scheduler;
        this.f21403g = supplier;
        this.f21404h = i11;
        this.f21405i = z11;
    }

    public void subscribeActual(Observer<? super U> observer) {
        if (this.f21399c == this.f21400d && this.f21404h == Integer.MAX_VALUE) {
            this.f21304b.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.f21403g, this.f21399c, this.f21401e, this.f21402f));
            return;
        }
        Scheduler.Worker createWorker = this.f21402f.createWorker();
        if (this.f21399c == this.f21400d) {
            this.f21304b.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.f21403g, this.f21399c, this.f21401e, this.f21404h, this.f21405i, createWorker));
        } else {
            this.f21304b.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.f21403g, this.f21399c, this.f21400d, this.f21401e, createWorker));
        }
    }
}
