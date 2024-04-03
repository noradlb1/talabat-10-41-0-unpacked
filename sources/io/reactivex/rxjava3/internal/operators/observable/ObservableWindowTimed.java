package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final long f22490c;

    /* renamed from: d  reason: collision with root package name */
    public final long f22491d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f22492e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f22493f;

    /* renamed from: g  reason: collision with root package name */
    public final long f22494g;

    /* renamed from: h  reason: collision with root package name */
    public final int f22495h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f22496i;

    public static abstract class AbstractWindowObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5724293814035355511L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super Observable<T>> f22497b;

        /* renamed from: c  reason: collision with root package name */
        public final SimplePlainQueue<Object> f22498c = new MpscLinkedQueue();

        /* renamed from: d  reason: collision with root package name */
        public final long f22499d;

        /* renamed from: e  reason: collision with root package name */
        public final TimeUnit f22500e;

        /* renamed from: f  reason: collision with root package name */
        public final int f22501f;

        /* renamed from: g  reason: collision with root package name */
        public long f22502g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f22503h;

        /* renamed from: i  reason: collision with root package name */
        public Throwable f22504i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f22505j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicBoolean f22506k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f22507l;

        /* renamed from: m  reason: collision with root package name */
        public final AtomicInteger f22508m;

        public AbstractWindowObserver(Observer<? super Observable<T>> observer, long j11, TimeUnit timeUnit, int i11) {
            this.f22497b = observer;
            this.f22499d = j11;
            this.f22500e = timeUnit;
            this.f22501f = i11;
            this.f22506k = new AtomicBoolean();
            this.f22508m = new AtomicInteger(1);
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public abstract void c();

        /* access modifiers changed from: package-private */
        public final void d() {
            if (this.f22508m.decrementAndGet() == 0) {
                a();
                this.f22505j.dispose();
                this.f22507l = true;
                c();
            }
        }

        public final void dispose() {
            if (this.f22506k.compareAndSet(false, true)) {
                d();
            }
        }

        public final boolean isDisposed() {
            return this.f22506k.get();
        }

        public final void onComplete() {
            this.f22503h = true;
            c();
        }

        public final void onError(Throwable th2) {
            this.f22504i = th2;
            this.f22503h = true;
            c();
        }

        public final void onNext(T t11) {
            this.f22498c.offer(t11);
            c();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22505j, disposable)) {
                this.f22505j = disposable;
                this.f22497b.onSubscribe(this);
                b();
            }
        }
    }

    public static final class WindowExactBoundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {
        private static final long serialVersionUID = -6130475889925953722L;

        /* renamed from: n  reason: collision with root package name */
        public final Scheduler f22509n;

        /* renamed from: o  reason: collision with root package name */
        public final boolean f22510o;

        /* renamed from: p  reason: collision with root package name */
        public final long f22511p;

        /* renamed from: q  reason: collision with root package name */
        public final Scheduler.Worker f22512q;

        /* renamed from: r  reason: collision with root package name */
        public long f22513r;

        /* renamed from: s  reason: collision with root package name */
        public UnicastSubject<T> f22514s;

        /* renamed from: t  reason: collision with root package name */
        public final SequentialDisposable f22515t;

        public static final class WindowBoundaryRunnable implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final WindowExactBoundedObserver<?> f22516b;

            /* renamed from: c  reason: collision with root package name */
            public final long f22517c;

            public WindowBoundaryRunnable(WindowExactBoundedObserver<?> windowExactBoundedObserver, long j11) {
                this.f22516b = windowExactBoundedObserver;
                this.f22517c = j11;
            }

            public void run() {
                this.f22516b.e(this);
            }
        }

        public WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, long j12, boolean z11) {
            super(observer, j11, timeUnit, i11);
            this.f22509n = scheduler;
            this.f22511p = j12;
            this.f22510o = z11;
            if (z11) {
                this.f22512q = scheduler.createWorker();
            } else {
                this.f22512q = null;
            }
            this.f22515t = new SequentialDisposable();
        }

        public void a() {
            this.f22515t.dispose();
            Scheduler.Worker worker = this.f22512q;
            if (worker != null) {
                worker.dispose();
            }
        }

        public void b() {
            if (!this.f22506k.get()) {
                this.f22502g = 1;
                this.f22508m.getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.f22501f, this);
                this.f22514s = create;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                this.f22497b.onNext(observableWindowSubscribeIntercept);
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, 1);
                if (this.f22510o) {
                    SequentialDisposable sequentialDisposable = this.f22515t;
                    Scheduler.Worker worker = this.f22512q;
                    long j11 = this.f22499d;
                    sequentialDisposable.replace(worker.schedulePeriodically(windowBoundaryRunnable, j11, j11, this.f22500e));
                } else {
                    SequentialDisposable sequentialDisposable2 = this.f22515t;
                    Scheduler scheduler = this.f22509n;
                    long j12 = this.f22499d;
                    sequentialDisposable2.replace(scheduler.schedulePeriodicallyDirect(windowBoundaryRunnable, j12, j12, this.f22500e));
                }
                if (observableWindowSubscribeIntercept.a()) {
                    this.f22514s.onComplete();
                }
            }
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.f22498c;
                Observer<? super Observable<T>> observer = this.f22497b;
                UnicastSubject<T> unicastSubject = this.f22514s;
                int i11 = 1;
                while (true) {
                    if (this.f22507l) {
                        simplePlainQueue.clear();
                        unicastSubject = null;
                        this.f22514s = null;
                    } else {
                        boolean z12 = this.f22503h;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable th2 = this.f22504i;
                            if (th2 != null) {
                                if (unicastSubject != null) {
                                    unicastSubject.onError(th2);
                                }
                                observer.onError(th2);
                            } else {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                            }
                            a();
                            this.f22507l = true;
                        } else if (!z11) {
                            if (poll instanceof WindowBoundaryRunnable) {
                                if (((WindowBoundaryRunnable) poll).f22517c == this.f22502g || !this.f22510o) {
                                    this.f22513r = 0;
                                    unicastSubject = f(unicastSubject);
                                }
                            } else if (unicastSubject != null) {
                                unicastSubject.onNext(poll);
                                long j11 = this.f22513r + 1;
                                if (j11 == this.f22511p) {
                                    this.f22513r = 0;
                                    unicastSubject = f(unicastSubject);
                                } else {
                                    this.f22513r = j11;
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
            this.f22498c.offer(windowBoundaryRunnable);
            c();
        }

        public UnicastSubject<T> f(UnicastSubject<T> unicastSubject) {
            if (unicastSubject != null) {
                unicastSubject.onComplete();
                unicastSubject = null;
            }
            if (this.f22506k.get()) {
                a();
            } else {
                long j11 = this.f22502g + 1;
                this.f22502g = j11;
                this.f22508m.getAndIncrement();
                unicastSubject = UnicastSubject.create(this.f22501f, this);
                this.f22514s = unicastSubject;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(unicastSubject);
                this.f22497b.onNext(observableWindowSubscribeIntercept);
                if (this.f22510o) {
                    SequentialDisposable sequentialDisposable = this.f22515t;
                    Scheduler.Worker worker = this.f22512q;
                    WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, j11);
                    long j12 = this.f22499d;
                    sequentialDisposable.update(worker.schedulePeriodically(windowBoundaryRunnable, j12, j12, this.f22500e));
                }
                if (observableWindowSubscribeIntercept.a()) {
                    unicastSubject.onComplete();
                }
            }
            return unicastSubject;
        }

        public void run() {
            d();
        }
    }

    public static final class WindowExactUnboundedObserver<T> extends AbstractWindowObserver<T> implements Runnable {

        /* renamed from: r  reason: collision with root package name */
        public static final Object f22518r = new Object();
        private static final long serialVersionUID = 1155822639622580836L;

        /* renamed from: n  reason: collision with root package name */
        public final Scheduler f22519n;

        /* renamed from: o  reason: collision with root package name */
        public UnicastSubject<T> f22520o;

        /* renamed from: p  reason: collision with root package name */
        public final SequentialDisposable f22521p = new SequentialDisposable();

        /* renamed from: q  reason: collision with root package name */
        public final Runnable f22522q = new WindowRunnable();

        public final class WindowRunnable implements Runnable {
            public WindowRunnable() {
            }

            public void run() {
                WindowExactUnboundedObserver.this.d();
            }
        }

        public WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
            super(observer, j11, timeUnit, i11);
            this.f22519n = scheduler;
        }

        public void a() {
            this.f22521p.dispose();
        }

        public void b() {
            if (!this.f22506k.get()) {
                this.f22508m.getAndIncrement();
                UnicastSubject<T> create = UnicastSubject.create(this.f22501f, this.f22522q);
                this.f22520o = create;
                this.f22502g = 1;
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                this.f22497b.onNext(observableWindowSubscribeIntercept);
                SequentialDisposable sequentialDisposable = this.f22521p;
                Scheduler scheduler = this.f22519n;
                long j11 = this.f22499d;
                sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f22500e));
                if (observableWindowSubscribeIntercept.a()) {
                    this.f22520o.onComplete();
                }
            }
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.f22498c;
                Observer<? super Observable<T>> observer = this.f22497b;
                UnicastSubject<T> unicastSubject = this.f22520o;
                int i11 = 1;
                while (true) {
                    if (this.f22507l) {
                        simplePlainQueue.clear();
                        this.f22520o = null;
                        unicastSubject = null;
                    } else {
                        boolean z12 = this.f22503h;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable th2 = this.f22504i;
                            if (th2 != null) {
                                if (unicastSubject != null) {
                                    unicastSubject.onError(th2);
                                }
                                observer.onError(th2);
                            } else {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                }
                                observer.onComplete();
                            }
                            a();
                            this.f22507l = true;
                        } else if (!z11) {
                            if (poll == f22518r) {
                                if (unicastSubject != null) {
                                    unicastSubject.onComplete();
                                    this.f22520o = null;
                                    unicastSubject = null;
                                }
                                if (this.f22506k.get()) {
                                    this.f22521p.dispose();
                                } else {
                                    this.f22502g++;
                                    this.f22508m.getAndIncrement();
                                    unicastSubject = UnicastSubject.create(this.f22501f, this.f22522q);
                                    this.f22520o = unicastSubject;
                                    ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(unicastSubject);
                                    observer.onNext(observableWindowSubscribeIntercept);
                                    if (observableWindowSubscribeIntercept.a()) {
                                        unicastSubject.onComplete();
                                    }
                                }
                            } else if (unicastSubject != null) {
                                unicastSubject.onNext(poll);
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
            this.f22498c.offer(f22518r);
            c();
        }
    }

    public static final class WindowSkipObserver<T> extends AbstractWindowObserver<T> implements Runnable {

        /* renamed from: q  reason: collision with root package name */
        public static final Object f22524q = new Object();

        /* renamed from: r  reason: collision with root package name */
        public static final Object f22525r = new Object();
        private static final long serialVersionUID = -7852870764194095894L;

        /* renamed from: n  reason: collision with root package name */
        public final long f22526n;

        /* renamed from: o  reason: collision with root package name */
        public final Scheduler.Worker f22527o;

        /* renamed from: p  reason: collision with root package name */
        public final List<UnicastSubject<T>> f22528p = new LinkedList();

        public static final class WindowBoundaryRunnable implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final WindowSkipObserver<?> f22529b;

            /* renamed from: c  reason: collision with root package name */
            public final boolean f22530c;

            public WindowBoundaryRunnable(WindowSkipObserver<?> windowSkipObserver, boolean z11) {
                this.f22529b = windowSkipObserver;
                this.f22530c = z11;
            }

            public void run() {
                this.f22529b.e(this.f22530c);
            }
        }

        public WindowSkipObserver(Observer<? super Observable<T>> observer, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker, int i11) {
            super(observer, j11, timeUnit, i11);
            this.f22526n = j12;
            this.f22527o = worker;
        }

        public void a() {
            this.f22527o.dispose();
        }

        public void b() {
            if (!this.f22506k.get()) {
                this.f22502g = 1;
                this.f22508m.getAndIncrement();
                UnicastSubject create = UnicastSubject.create(this.f22501f, this);
                this.f22528p.add(create);
                ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                this.f22497b.onNext(observableWindowSubscribeIntercept);
                this.f22527o.schedule(new WindowBoundaryRunnable(this, false), this.f22499d, this.f22500e);
                Scheduler.Worker worker = this.f22527o;
                WindowBoundaryRunnable windowBoundaryRunnable = new WindowBoundaryRunnable(this, true);
                long j11 = this.f22526n;
                worker.schedulePeriodically(windowBoundaryRunnable, j11, j11, this.f22500e);
                if (observableWindowSubscribeIntercept.a()) {
                    create.onComplete();
                    this.f22528p.remove(create);
                }
            }
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                SimplePlainQueue<Object> simplePlainQueue = this.f22498c;
                Observer<? super Observable<T>> observer = this.f22497b;
                List<UnicastSubject<T>> list = this.f22528p;
                int i11 = 1;
                while (true) {
                    if (this.f22507l) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z12 = this.f22503h;
                        Object poll = simplePlainQueue.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable th2 = this.f22504i;
                            if (th2 != null) {
                                for (UnicastSubject<T> onError : list) {
                                    onError.onError(th2);
                                }
                                observer.onError(th2);
                            } else {
                                for (UnicastSubject<T> onComplete : list) {
                                    onComplete.onComplete();
                                }
                                observer.onComplete();
                            }
                            a();
                            this.f22507l = true;
                        } else if (!z11) {
                            if (poll == f22524q) {
                                if (!this.f22506k.get()) {
                                    this.f22502g++;
                                    this.f22508m.getAndIncrement();
                                    UnicastSubject create = UnicastSubject.create(this.f22501f, this);
                                    list.add(create);
                                    ObservableWindowSubscribeIntercept observableWindowSubscribeIntercept = new ObservableWindowSubscribeIntercept(create);
                                    observer.onNext(observableWindowSubscribeIntercept);
                                    this.f22527o.schedule(new WindowBoundaryRunnable(this, false), this.f22499d, this.f22500e);
                                    if (observableWindowSubscribeIntercept.a()) {
                                        create.onComplete();
                                    }
                                }
                            } else if (poll != f22525r) {
                                for (UnicastSubject<T> onNext : list) {
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
            SimplePlainQueue<Object> simplePlainQueue = this.f22498c;
            if (z11) {
                obj = f22524q;
            } else {
                obj = f22525r;
            }
            simplePlainQueue.offer(obj);
            c();
        }

        public void run() {
            d();
        }
    }

    public ObservableWindowTimed(Observable<T> observable, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, long j13, int i11, boolean z11) {
        super(observable);
        this.f22490c = j11;
        this.f22491d = j12;
        this.f22492e = timeUnit;
        this.f22493f = scheduler;
        this.f22494g = j13;
        this.f22495h = i11;
        this.f22496i = z11;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.f22490c != this.f22491d) {
            this.f21304b.subscribe(new WindowSkipObserver(observer, this.f22490c, this.f22491d, this.f22492e, this.f22493f.createWorker(), this.f22495h));
        } else if (this.f22494g == Long.MAX_VALUE) {
            this.f21304b.subscribe(new WindowExactUnboundedObserver(observer, this.f22490c, this.f22492e, this.f22493f, this.f22495h));
        } else {
            this.f21304b.subscribe(new WindowExactBoundedObserver(observer, this.f22490c, this.f22492e, this.f22493f, this.f22495h, this.f22494g, this.f22496i));
        }
    }
}
