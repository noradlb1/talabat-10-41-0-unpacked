package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17957c;

    /* renamed from: d  reason: collision with root package name */
    public final long f17958d;

    /* renamed from: e  reason: collision with root package name */
    public final TimeUnit f17959e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f17960f;

    /* renamed from: g  reason: collision with root package name */
    public final long f17961g;

    /* renamed from: h  reason: collision with root package name */
    public final int f17962h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f17963i;

    public static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {

        /* renamed from: h  reason: collision with root package name */
        public final long f17964h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f17965i;

        /* renamed from: j  reason: collision with root package name */
        public final Scheduler f17966j;

        /* renamed from: k  reason: collision with root package name */
        public final int f17967k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f17968l;

        /* renamed from: m  reason: collision with root package name */
        public final long f17969m;

        /* renamed from: n  reason: collision with root package name */
        public final Scheduler.Worker f17970n;

        /* renamed from: o  reason: collision with root package name */
        public long f17971o;

        /* renamed from: p  reason: collision with root package name */
        public long f17972p;

        /* renamed from: q  reason: collision with root package name */
        public Disposable f17973q;

        /* renamed from: r  reason: collision with root package name */
        public UnicastSubject<T> f17974r;

        /* renamed from: s  reason: collision with root package name */
        public volatile boolean f17975s;

        /* renamed from: t  reason: collision with root package name */
        public final SequentialDisposable f17976t = new SequentialDisposable();

        public static final class ConsumerIndexHolder implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final long f17977b;

            /* renamed from: c  reason: collision with root package name */
            public final WindowExactBoundedObserver<?> f17978c;

            public ConsumerIndexHolder(long j11, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.f17977b = j11;
                this.f17978c = windowExactBoundedObserver;
            }

            public void run() {
                WindowExactBoundedObserver<?> windowExactBoundedObserver = this.f17978c;
                if (!windowExactBoundedObserver.f14577e) {
                    windowExactBoundedObserver.f14576d.offer(this);
                } else {
                    windowExactBoundedObserver.f17975s = true;
                }
                if (windowExactBoundedObserver.enter()) {
                    windowExactBoundedObserver.f();
                }
            }
        }

        public WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11, long j12, boolean z11) {
            super(observer, new MpscLinkedQueue());
            this.f17964h = j11;
            this.f17965i = timeUnit;
            this.f17966j = scheduler;
            this.f17967k = i11;
            this.f17969m = j12;
            this.f17968l = z11;
            if (z11) {
                this.f17970n = scheduler.createWorker();
            } else {
                this.f17970n = null;
            }
        }

        public void dispose() {
            this.f14577e = true;
        }

        public void e() {
            DisposableHelper.dispose(this.f17976t);
            Scheduler.Worker worker = this.f17970n;
            if (worker != null) {
                worker.dispose();
            }
        }

        public void f() {
            boolean z11;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f14576d;
            Observer<? super V> observer = this.f14575c;
            UnicastSubject<T> unicastSubject = this.f17974r;
            int i11 = 1;
            while (!this.f17975s) {
                boolean z12 = this.f14578f;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z13 = poll instanceof ConsumerIndexHolder;
                if (z12 && (z11 || z13)) {
                    this.f17974r = null;
                    mpscLinkedQueue.clear();
                    Throwable th2 = this.f14579g;
                    if (th2 != null) {
                        unicastSubject.onError(th2);
                    } else {
                        unicastSubject.onComplete();
                    }
                    e();
                    return;
                } else if (z11) {
                    i11 = leave(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else if (z13) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                    if (!this.f17968l || this.f17972p == consumerIndexHolder.f17977b) {
                        unicastSubject.onComplete();
                        this.f17971o = 0;
                        unicastSubject = UnicastSubject.create(this.f17967k);
                        this.f17974r = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(poll));
                    long j11 = this.f17971o + 1;
                    if (j11 >= this.f17969m) {
                        this.f17972p++;
                        this.f17971o = 0;
                        unicastSubject.onComplete();
                        unicastSubject = UnicastSubject.create(this.f17967k);
                        this.f17974r = unicastSubject;
                        this.f14575c.onNext(unicastSubject);
                        if (this.f17968l) {
                            Disposable disposable = (Disposable) this.f17976t.get();
                            disposable.dispose();
                            Scheduler.Worker worker = this.f17970n;
                            ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.f17972p, this);
                            long j12 = this.f17964h;
                            Disposable schedulePeriodically = worker.schedulePeriodically(consumerIndexHolder2, j12, j12, this.f17965i);
                            if (!this.f17976t.compareAndSet(disposable, schedulePeriodically)) {
                                schedulePeriodically.dispose();
                            }
                        }
                    } else {
                        this.f17971o = j11;
                    }
                }
            }
            this.f17973q.dispose();
            mpscLinkedQueue.clear();
            e();
        }

        public boolean isDisposed() {
            return this.f14577e;
        }

        public void onComplete() {
            this.f14578f = true;
            if (enter()) {
                f();
            }
            this.f14575c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14579g = th2;
            this.f14578f = true;
            if (enter()) {
                f();
            }
            this.f14575c.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17975s) {
                if (fastEnter()) {
                    UnicastSubject<T> unicastSubject = this.f17974r;
                    unicastSubject.onNext(t11);
                    long j11 = this.f17971o + 1;
                    if (j11 >= this.f17969m) {
                        this.f17972p++;
                        this.f17971o = 0;
                        unicastSubject.onComplete();
                        UnicastSubject<T> create = UnicastSubject.create(this.f17967k);
                        this.f17974r = create;
                        this.f14575c.onNext(create);
                        if (this.f17968l) {
                            ((Disposable) this.f17976t.get()).dispose();
                            Scheduler.Worker worker = this.f17970n;
                            ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f17972p, this);
                            long j12 = this.f17964h;
                            DisposableHelper.replace(this.f17976t, worker.schedulePeriodically(consumerIndexHolder, j12, j12, this.f17965i));
                        }
                    } else {
                        this.f17971o = j11;
                    }
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.f14576d.offer(NotificationLite.next(t11));
                    if (!enter()) {
                        return;
                    }
                }
                f();
            }
        }

        public void onSubscribe(Disposable disposable) {
            Disposable disposable2;
            if (DisposableHelper.validate(this.f17973q, disposable)) {
                this.f17973q = disposable;
                Observer<? super V> observer = this.f14575c;
                observer.onSubscribe(this);
                if (!this.f14577e) {
                    UnicastSubject<T> create = UnicastSubject.create(this.f17967k);
                    this.f17974r = create;
                    observer.onNext(create);
                    ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f17972p, this);
                    if (this.f17968l) {
                        Scheduler.Worker worker = this.f17970n;
                        long j11 = this.f17964h;
                        disposable2 = worker.schedulePeriodically(consumerIndexHolder, j11, j11, this.f17965i);
                    } else {
                        Scheduler scheduler = this.f17966j;
                        long j12 = this.f17964h;
                        disposable2 = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j12, j12, this.f17965i);
                    }
                    this.f17976t.replace(disposable2);
                }
            }
        }
    }

    public static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {

        /* renamed from: p  reason: collision with root package name */
        public static final Object f17979p = new Object();

        /* renamed from: h  reason: collision with root package name */
        public final long f17980h;

        /* renamed from: i  reason: collision with root package name */
        public final TimeUnit f17981i;

        /* renamed from: j  reason: collision with root package name */
        public final Scheduler f17982j;

        /* renamed from: k  reason: collision with root package name */
        public final int f17983k;

        /* renamed from: l  reason: collision with root package name */
        public Disposable f17984l;

        /* renamed from: m  reason: collision with root package name */
        public UnicastSubject<T> f17985m;

        /* renamed from: n  reason: collision with root package name */
        public final SequentialDisposable f17986n = new SequentialDisposable();

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f17987o;

        public WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j11, TimeUnit timeUnit, Scheduler scheduler, int i11) {
            super(observer, new MpscLinkedQueue());
            this.f17980h = j11;
            this.f17981i = timeUnit;
            this.f17982j = scheduler;
            this.f17983k = i11;
        }

        public void c() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f14576d;
            Observer<? super V> observer = this.f14575c;
            UnicastSubject<T> unicastSubject = this.f17985m;
            int i11 = 1;
            while (true) {
                boolean z11 = this.f17987o;
                boolean z12 = this.f14578f;
                Object poll = mpscLinkedQueue.poll();
                if (!z12 || !(poll == null || poll == f17979p)) {
                    if (poll == null) {
                        i11 = leave(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else if (poll == f17979p) {
                        unicastSubject.onComplete();
                        if (!z11) {
                            unicastSubject = UnicastSubject.create(this.f17983k);
                            this.f17985m = unicastSubject;
                            observer.onNext(unicastSubject);
                        } else {
                            this.f17984l.dispose();
                        }
                    } else {
                        unicastSubject.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
            this.f17985m = null;
            mpscLinkedQueue.clear();
            Throwable th2 = this.f14579g;
            if (th2 != null) {
                unicastSubject.onError(th2);
            } else {
                unicastSubject.onComplete();
            }
            this.f17986n.dispose();
        }

        public void dispose() {
            this.f14577e = true;
        }

        public boolean isDisposed() {
            return this.f14577e;
        }

        public void onComplete() {
            this.f14578f = true;
            if (enter()) {
                c();
            }
            this.f14575c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14579g = th2;
            this.f14578f = true;
            if (enter()) {
                c();
            }
            this.f14575c.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17987o) {
                if (fastEnter()) {
                    this.f17985m.onNext(t11);
                    if (leave(-1) == 0) {
                        return;
                    }
                } else {
                    this.f14576d.offer(NotificationLite.next(t11));
                    if (!enter()) {
                        return;
                    }
                }
                c();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17984l, disposable)) {
                this.f17984l = disposable;
                this.f17985m = UnicastSubject.create(this.f17983k);
                Observer<? super V> observer = this.f14575c;
                observer.onSubscribe(this);
                observer.onNext(this.f17985m);
                if (!this.f14577e) {
                    Scheduler scheduler = this.f17982j;
                    long j11 = this.f17980h;
                    this.f17986n.replace(scheduler.schedulePeriodicallyDirect(this, j11, j11, this.f17981i));
                }
            }
        }

        public void run() {
            if (this.f14577e) {
                this.f17987o = true;
            }
            this.f14576d.offer(f17979p);
            if (enter()) {
                c();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {

        /* renamed from: h  reason: collision with root package name */
        public final long f17988h;

        /* renamed from: i  reason: collision with root package name */
        public final long f17989i;

        /* renamed from: j  reason: collision with root package name */
        public final TimeUnit f17990j;

        /* renamed from: k  reason: collision with root package name */
        public final Scheduler.Worker f17991k;

        /* renamed from: l  reason: collision with root package name */
        public final int f17992l;

        /* renamed from: m  reason: collision with root package name */
        public final List<UnicastSubject<T>> f17993m = new LinkedList();

        /* renamed from: n  reason: collision with root package name */
        public Disposable f17994n;

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f17995o;

        public final class CompletionTask implements Runnable {

            /* renamed from: w  reason: collision with root package name */
            private final UnicastSubject<T> f17997w;

            public CompletionTask(UnicastSubject<T> unicastSubject) {
                this.f17997w = unicastSubject;
            }

            public void run() {
                WindowSkipObserver.this.c(this.f17997w);
            }
        }

        public static final class SubjectWork<T> {

            /* renamed from: a  reason: collision with root package name */
            public final UnicastSubject<T> f17998a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f17999b;

            public SubjectWork(UnicastSubject<T> unicastSubject, boolean z11) {
                this.f17998a = unicastSubject;
                this.f17999b = z11;
            }
        }

        public WindowSkipObserver(Observer<? super Observable<T>> observer, long j11, long j12, TimeUnit timeUnit, Scheduler.Worker worker, int i11) {
            super(observer, new MpscLinkedQueue());
            this.f17988h = j11;
            this.f17989i = j12;
            this.f17990j = timeUnit;
            this.f17991k = worker;
            this.f17992l = i11;
        }

        public void c(UnicastSubject<T> unicastSubject) {
            this.f14576d.offer(new SubjectWork(unicastSubject, false));
            if (enter()) {
                d();
            }
        }

        public void d() {
            boolean z11;
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f14576d;
            Observer<? super V> observer = this.f14575c;
            List<UnicastSubject<T>> list = this.f17993m;
            int i11 = 1;
            while (!this.f17995o) {
                boolean z12 = this.f14578f;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z13 = poll instanceof SubjectWork;
                if (z12 && (z11 || z13)) {
                    mpscLinkedQueue.clear();
                    Throwable th2 = this.f14579g;
                    if (th2 != null) {
                        for (UnicastSubject<T> onError : list) {
                            onError.onError(th2);
                        }
                    } else {
                        for (UnicastSubject<T> onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    list.clear();
                    this.f17991k.dispose();
                    return;
                } else if (z11) {
                    i11 = leave(-i11);
                    if (i11 == 0) {
                        return;
                    }
                } else if (z13) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.f17999b) {
                        list.remove(subjectWork.f17998a);
                        subjectWork.f17998a.onComplete();
                        if (list.isEmpty() && this.f14577e) {
                            this.f17995o = true;
                        }
                    } else if (!this.f14577e) {
                        UnicastSubject create = UnicastSubject.create(this.f17992l);
                        list.add(create);
                        observer.onNext(create);
                        this.f17991k.schedule(new CompletionTask(create), this.f17988h, this.f17990j);
                    }
                } else {
                    for (UnicastSubject<T> onNext : list) {
                        onNext.onNext(poll);
                    }
                }
            }
            this.f17994n.dispose();
            mpscLinkedQueue.clear();
            list.clear();
            this.f17991k.dispose();
        }

        public void dispose() {
            this.f14577e = true;
        }

        public boolean isDisposed() {
            return this.f14577e;
        }

        public void onComplete() {
            this.f14578f = true;
            if (enter()) {
                d();
            }
            this.f14575c.onComplete();
        }

        public void onError(Throwable th2) {
            this.f14579g = th2;
            this.f14578f = true;
            if (enter()) {
                d();
            }
            this.f14575c.onError(th2);
        }

        public void onNext(T t11) {
            if (fastEnter()) {
                for (UnicastSubject<T> onNext : this.f17993m) {
                    onNext.onNext(t11);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.f14576d.offer(t11);
                if (!enter()) {
                    return;
                }
            }
            d();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17994n, disposable)) {
                this.f17994n = disposable;
                this.f14575c.onSubscribe(this);
                if (!this.f14577e) {
                    UnicastSubject create = UnicastSubject.create(this.f17992l);
                    this.f17993m.add(create);
                    this.f14575c.onNext(create);
                    this.f17991k.schedule(new CompletionTask(create), this.f17988h, this.f17990j);
                    Scheduler.Worker worker = this.f17991k;
                    long j11 = this.f17989i;
                    worker.schedulePeriodically(this, j11, j11, this.f17990j);
                }
            }
        }

        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.create(this.f17992l), true);
            if (!this.f14577e) {
                this.f14576d.offer(subjectWork);
            }
            if (enter()) {
                d();
            }
        }
    }

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j11, long j12, TimeUnit timeUnit, Scheduler scheduler, long j13, int i11, boolean z11) {
        super(observableSource);
        this.f17957c = j11;
        this.f17958d = j12;
        this.f17959e = timeUnit;
        this.f17960f = scheduler;
        this.f17961g = j13;
        this.f17962h = i11;
        this.f17963i = z11;
    }

    public void subscribeActual(Observer<? super Observable<T>> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        long j11 = this.f17957c;
        long j12 = this.f17958d;
        if (j11 == j12) {
            long j13 = this.f17961g;
            if (j13 == Long.MAX_VALUE) {
                this.f16799b.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.f17957c, this.f17959e, this.f17960f, this.f17962h));
            } else {
                this.f16799b.subscribe(new WindowExactBoundedObserver(serializedObserver, j11, this.f17959e, this.f17960f, this.f17962h, j13, this.f17963i));
            }
        } else {
            this.f16799b.subscribe(new WindowSkipObserver(serializedObserver, j11, j12, this.f17959e, this.f17960f.createWorker(), this.f17962h));
        }
    }
}
