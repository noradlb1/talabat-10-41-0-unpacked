package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
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

public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f21486c;

    /* renamed from: d  reason: collision with root package name */
    public final int f21487d;

    /* renamed from: e  reason: collision with root package name */
    public final ErrorMode f21488e;

    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -6951100001833242599L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21489b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f21490c;

        /* renamed from: d  reason: collision with root package name */
        public final int f21491d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21492e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final DelayErrorInnerObserver<R> f21493f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f21494g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f21495h;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f21496i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f21497j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f21498k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f21499l;

        /* renamed from: m  reason: collision with root package name */
        public int f21500m;

        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;

            /* renamed from: b  reason: collision with root package name */
            public final Observer<? super R> f21501b;

            /* renamed from: c  reason: collision with root package name */
            public final ConcatMapDelayErrorObserver<?, R> f21502c;

            public DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.f21501b = observer;
                this.f21502c = concatMapDelayErrorObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f21502c;
                concatMapDelayErrorObserver.f21497j = false;
                concatMapDelayErrorObserver.a();
            }

            public void onError(Throwable th2) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f21502c;
                if (concatMapDelayErrorObserver.f21492e.tryAddThrowableOrReport(th2)) {
                    if (!concatMapDelayErrorObserver.f21494g) {
                        concatMapDelayErrorObserver.f21496i.dispose();
                    }
                    concatMapDelayErrorObserver.f21497j = false;
                    concatMapDelayErrorObserver.a();
                }
            }

            public void onNext(R r11) {
                this.f21501b.onNext(r11);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, boolean z11) {
            this.f21489b = observer;
            this.f21490c = function;
            this.f21491d = i11;
            this.f21494g = z11;
            this.f21493f = new DelayErrorInnerObserver<>(observer, this);
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f21489b;
                SimpleQueue<T> simpleQueue = this.f21495h;
                AtomicThrowable atomicThrowable = this.f21492e;
                while (true) {
                    if (!this.f21497j) {
                        if (this.f21499l) {
                            simpleQueue.clear();
                            return;
                        } else if (this.f21494g || ((Throwable) atomicThrowable.get()) == null) {
                            boolean z12 = this.f21498k;
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z12 && z11) {
                                    this.f21499l = true;
                                    atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                                    return;
                                } else if (!z11) {
                                    try {
                                        Object apply = this.f21490c.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                        ObservableSource observableSource = (ObservableSource) apply;
                                        if (observableSource instanceof Supplier) {
                                            try {
                                                Object obj = ((Supplier) observableSource).get();
                                                if (obj != null && !this.f21499l) {
                                                    observer.onNext(obj);
                                                }
                                            } catch (Throwable th2) {
                                                Exceptions.throwIfFatal(th2);
                                                atomicThrowable.tryAddThrowableOrReport(th2);
                                            }
                                        } else {
                                            this.f21497j = true;
                                            observableSource.subscribe(this.f21493f);
                                        }
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        this.f21499l = true;
                                        this.f21496i.dispose();
                                        simpleQueue.clear();
                                        atomicThrowable.tryAddThrowableOrReport(th3);
                                        atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                Exceptions.throwIfFatal(th4);
                                this.f21499l = true;
                                this.f21496i.dispose();
                                atomicThrowable.tryAddThrowableOrReport(th4);
                                atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            this.f21499l = true;
                            atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void dispose() {
            this.f21499l = true;
            this.f21496i.dispose();
            this.f21493f.a();
            this.f21492e.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f21499l;
        }

        public void onComplete() {
            this.f21498k = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f21492e.tryAddThrowableOrReport(th2)) {
                this.f21498k = true;
                a();
            }
        }

        public void onNext(T t11) {
            if (this.f21500m == 0) {
                this.f21495h.offer(t11);
            }
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21496i, disposable)) {
                this.f21496i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f21500m = requestFusion;
                        this.f21495h = queueDisposable;
                        this.f21498k = true;
                        this.f21489b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f21500m = requestFusion;
                        this.f21495h = queueDisposable;
                        this.f21489b.onSubscribe(this);
                        return;
                    }
                }
                this.f21495h = new SpscLinkedArrayQueue(this.f21491d);
                this.f21489b.onSubscribe(this);
            }
        }
    }

    public static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8828587559905699186L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f21503b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends U>> f21504c;

        /* renamed from: d  reason: collision with root package name */
        public final InnerObserver<U> f21505d;

        /* renamed from: e  reason: collision with root package name */
        public final int f21506e;

        /* renamed from: f  reason: collision with root package name */
        public SimpleQueue<T> f21507f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21508g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f21509h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21510i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f21511j;

        /* renamed from: k  reason: collision with root package name */
        public int f21512k;

        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -7449079488798789337L;

            /* renamed from: b  reason: collision with root package name */
            public final Observer<? super U> f21513b;

            /* renamed from: c  reason: collision with root package name */
            public final SourceObserver<?, ?> f21514c;

            public InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                this.f21513b = observer;
                this.f21514c = sourceObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21514c.b();
            }

            public void onError(Throwable th2) {
                this.f21514c.dispose();
                this.f21513b.onError(th2);
            }

            public void onNext(U u11) {
                this.f21513b.onNext(u11);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i11) {
            this.f21503b = observer;
            this.f21504c = function;
            this.f21506e = i11;
            this.f21505d = new InnerObserver<>(observer, this);
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                while (!this.f21510i) {
                    if (!this.f21509h) {
                        boolean z12 = this.f21511j;
                        try {
                            T poll = this.f21507f.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                this.f21510i = true;
                                this.f21503b.onComplete();
                                return;
                            } else if (!z11) {
                                try {
                                    Object apply = this.f21504c.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                    ObservableSource observableSource = (ObservableSource) apply;
                                    this.f21509h = true;
                                    observableSource.subscribe(this.f21505d);
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    dispose();
                                    this.f21507f.clear();
                                    this.f21503b.onError(th2);
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            dispose();
                            this.f21507f.clear();
                            this.f21503b.onError(th3);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f21507f.clear();
            }
        }

        public void b() {
            this.f21509h = false;
            a();
        }

        public void dispose() {
            this.f21510i = true;
            this.f21505d.a();
            this.f21508g.dispose();
            if (getAndIncrement() == 0) {
                this.f21507f.clear();
            }
        }

        public boolean isDisposed() {
            return this.f21510i;
        }

        public void onComplete() {
            if (!this.f21511j) {
                this.f21511j = true;
                a();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21511j) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21511j = true;
            dispose();
            this.f21503b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21511j) {
                if (this.f21512k == 0) {
                    this.f21507f.offer(t11);
                }
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21508g, disposable)) {
                this.f21508g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f21512k = requestFusion;
                        this.f21507f = queueDisposable;
                        this.f21511j = true;
                        this.f21503b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f21512k = requestFusion;
                        this.f21507f = queueDisposable;
                        this.f21503b.onSubscribe(this);
                        return;
                    }
                }
                this.f21507f = new SpscLinkedArrayQueue(this.f21506e);
                this.f21503b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i11, ErrorMode errorMode) {
        super(observableSource);
        this.f21486c = function;
        this.f21488e = errorMode;
        this.f21487d = Math.max(8, i11);
    }

    public void subscribeActual(Observer<? super U> observer) {
        boolean z11;
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.f21304b, observer, this.f21486c)) {
            if (this.f21488e == ErrorMode.IMMEDIATE) {
                this.f21304b.subscribe(new SourceObserver(new SerializedObserver(observer), this.f21486c, this.f21487d));
                return;
            }
            ObservableSource<T> observableSource = this.f21304b;
            Function<? super T, ? extends ObservableSource<? extends U>> function = this.f21486c;
            int i11 = this.f21487d;
            if (this.f21488e == ErrorMode.END) {
                z11 = true;
            } else {
                z11 = false;
            }
            observableSource.subscribe(new ConcatMapDelayErrorObserver(observer, function, i11, z11));
        }
    }
}
