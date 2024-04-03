package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapScheduler<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f21533c;

    /* renamed from: d  reason: collision with root package name */
    public final int f21534d;

    /* renamed from: e  reason: collision with root package name */
    public final ErrorMode f21535e;

    /* renamed from: f  reason: collision with root package name */
    public final Scheduler f21536f;

    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -6951100001833242599L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21537b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f21538c;

        /* renamed from: d  reason: collision with root package name */
        public final int f21539d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21540e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final DelayErrorInnerObserver<R> f21541f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f21542g;

        /* renamed from: h  reason: collision with root package name */
        public final Scheduler.Worker f21543h;

        /* renamed from: i  reason: collision with root package name */
        public SimpleQueue<T> f21544i;

        /* renamed from: j  reason: collision with root package name */
        public Disposable f21545j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f21546k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f21547l;

        /* renamed from: m  reason: collision with root package name */
        public volatile boolean f21548m;

        /* renamed from: n  reason: collision with root package name */
        public int f21549n;

        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;

            /* renamed from: b  reason: collision with root package name */
            public final Observer<? super R> f21550b;

            /* renamed from: c  reason: collision with root package name */
            public final ConcatMapDelayErrorObserver<?, R> f21551c;

            public DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.f21550b = observer;
                this.f21551c = concatMapDelayErrorObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f21551c;
                concatMapDelayErrorObserver.f21546k = false;
                concatMapDelayErrorObserver.a();
            }

            public void onError(Throwable th2) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f21551c;
                if (concatMapDelayErrorObserver.f21540e.tryAddThrowableOrReport(th2)) {
                    if (!concatMapDelayErrorObserver.f21542g) {
                        concatMapDelayErrorObserver.f21545j.dispose();
                    }
                    concatMapDelayErrorObserver.f21546k = false;
                    concatMapDelayErrorObserver.a();
                }
            }

            public void onNext(R r11) {
                this.f21550b.onNext(r11);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, boolean z11, Scheduler.Worker worker) {
            this.f21537b = observer;
            this.f21538c = function;
            this.f21539d = i11;
            this.f21542g = z11;
            this.f21541f = new DelayErrorInnerObserver<>(observer, this);
            this.f21543h = worker;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                this.f21543h.schedule(this);
            }
        }

        public void dispose() {
            this.f21548m = true;
            this.f21545j.dispose();
            this.f21541f.a();
            this.f21543h.dispose();
            this.f21540e.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f21548m;
        }

        public void onComplete() {
            this.f21547l = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f21540e.tryAddThrowableOrReport(th2)) {
                this.f21547l = true;
                a();
            }
        }

        public void onNext(T t11) {
            if (this.f21549n == 0) {
                this.f21544i.offer(t11);
            }
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21545j, disposable)) {
                this.f21545j = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f21549n = requestFusion;
                        this.f21544i = queueDisposable;
                        this.f21547l = true;
                        this.f21537b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f21549n = requestFusion;
                        this.f21544i = queueDisposable;
                        this.f21537b.onSubscribe(this);
                        return;
                    }
                }
                this.f21544i = new SpscLinkedArrayQueue(this.f21539d);
                this.f21537b.onSubscribe(this);
            }
        }

        public void run() {
            boolean z11;
            Observer<? super R> observer = this.f21537b;
            SimpleQueue<T> simpleQueue = this.f21544i;
            AtomicThrowable atomicThrowable = this.f21540e;
            while (true) {
                if (!this.f21546k) {
                    if (this.f21548m) {
                        simpleQueue.clear();
                        return;
                    } else if (this.f21542g || ((Throwable) atomicThrowable.get()) == null) {
                        boolean z12 = this.f21547l;
                        try {
                            T poll = simpleQueue.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                this.f21548m = true;
                                atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                                this.f21543h.dispose();
                                return;
                            } else if (!z11) {
                                try {
                                    Object apply = this.f21538c.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                    ObservableSource observableSource = (ObservableSource) apply;
                                    if (observableSource instanceof Supplier) {
                                        try {
                                            Object obj = ((Supplier) observableSource).get();
                                            if (obj != null && !this.f21548m) {
                                                observer.onNext(obj);
                                            }
                                        } catch (Throwable th2) {
                                            Exceptions.throwIfFatal(th2);
                                            atomicThrowable.tryAddThrowableOrReport(th2);
                                        }
                                    } else {
                                        this.f21546k = true;
                                        observableSource.subscribe(this.f21541f);
                                    }
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    this.f21548m = true;
                                    this.f21545j.dispose();
                                    simpleQueue.clear();
                                    atomicThrowable.tryAddThrowableOrReport(th3);
                                    atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                                    this.f21543h.dispose();
                                    return;
                                }
                            }
                        } catch (Throwable th4) {
                            Exceptions.throwIfFatal(th4);
                            this.f21548m = true;
                            this.f21545j.dispose();
                            atomicThrowable.tryAddThrowableOrReport(th4);
                            atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                            this.f21543h.dispose();
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        this.f21548m = true;
                        atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                        this.f21543h.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public static final class ConcatMapObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8828587559905699186L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f21552b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends U>> f21553c;

        /* renamed from: d  reason: collision with root package name */
        public final InnerObserver<U> f21554d;

        /* renamed from: e  reason: collision with root package name */
        public final int f21555e;

        /* renamed from: f  reason: collision with root package name */
        public final Scheduler.Worker f21556f;

        /* renamed from: g  reason: collision with root package name */
        public SimpleQueue<T> f21557g;

        /* renamed from: h  reason: collision with root package name */
        public Disposable f21558h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21559i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f21560j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f21561k;

        /* renamed from: l  reason: collision with root package name */
        public int f21562l;

        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -7449079488798789337L;

            /* renamed from: b  reason: collision with root package name */
            public final Observer<? super U> f21563b;

            /* renamed from: c  reason: collision with root package name */
            public final ConcatMapObserver<?, ?> f21564c;

            public InnerObserver(Observer<? super U> observer, ConcatMapObserver<?, ?> concatMapObserver) {
                this.f21563b = observer;
                this.f21564c = concatMapObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21564c.b();
            }

            public void onError(Throwable th2) {
                this.f21564c.dispose();
                this.f21563b.onError(th2);
            }

            public void onNext(U u11) {
                this.f21563b.onNext(u11);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i11, Scheduler.Worker worker) {
            this.f21552b = observer;
            this.f21553c = function;
            this.f21555e = i11;
            this.f21554d = new InnerObserver<>(observer, this);
            this.f21556f = worker;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                this.f21556f.schedule(this);
            }
        }

        public void b() {
            this.f21559i = false;
            a();
        }

        public void dispose() {
            this.f21560j = true;
            this.f21554d.a();
            this.f21558h.dispose();
            this.f21556f.dispose();
            if (getAndIncrement() == 0) {
                this.f21557g.clear();
            }
        }

        public boolean isDisposed() {
            return this.f21560j;
        }

        public void onComplete() {
            if (!this.f21561k) {
                this.f21561k = true;
                a();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21561k) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21561k = true;
            dispose();
            this.f21552b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21561k) {
                if (this.f21562l == 0) {
                    this.f21557g.offer(t11);
                }
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21558h, disposable)) {
                this.f21558h = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f21562l = requestFusion;
                        this.f21557g = queueDisposable;
                        this.f21561k = true;
                        this.f21552b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f21562l = requestFusion;
                        this.f21557g = queueDisposable;
                        this.f21552b.onSubscribe(this);
                        return;
                    }
                }
                this.f21557g = new SpscLinkedArrayQueue(this.f21555e);
                this.f21552b.onSubscribe(this);
            }
        }

        public void run() {
            boolean z11;
            while (!this.f21560j) {
                if (!this.f21559i) {
                    boolean z12 = this.f21561k;
                    try {
                        T poll = this.f21557g.poll();
                        if (poll == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            this.f21560j = true;
                            this.f21552b.onComplete();
                            this.f21556f.dispose();
                            return;
                        } else if (!z11) {
                            try {
                                Object apply = this.f21553c.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                this.f21559i = true;
                                observableSource.subscribe(this.f21554d);
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                dispose();
                                this.f21557g.clear();
                                this.f21552b.onError(th2);
                                this.f21556f.dispose();
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        dispose();
                        this.f21557g.clear();
                        this.f21552b.onError(th3);
                        this.f21556f.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f21557g.clear();
        }
    }

    public ObservableConcatMapScheduler(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i11, ErrorMode errorMode, Scheduler scheduler) {
        super(observableSource);
        this.f21533c = function;
        this.f21535e = errorMode;
        this.f21534d = Math.max(8, i11);
        this.f21536f = scheduler;
    }

    public void subscribeActual(Observer<? super U> observer) {
        boolean z11;
        if (this.f21535e == ErrorMode.IMMEDIATE) {
            this.f21304b.subscribe(new ConcatMapObserver(new SerializedObserver(observer), this.f21533c, this.f21534d, this.f21536f.createWorker()));
            return;
        }
        ObservableSource<T> observableSource = this.f21304b;
        Function<? super T, ? extends ObservableSource<? extends U>> function = this.f21533c;
        int i11 = this.f21534d;
        if (this.f21535e == ErrorMode.END) {
            z11 = true;
        } else {
            z11 = false;
        }
        observableSource.subscribe(new ConcatMapDelayErrorObserver(observer, function, i11, z11, this.f21536f.createWorker()));
    }
}
