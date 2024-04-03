package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f16990c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16991d;

    /* renamed from: e  reason: collision with root package name */
    public final ErrorMode f16992e;

    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -6951100001833242599L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16993b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f16994c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16995d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f16996e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final DelayErrorInnerObserver<R> f16997f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f16998g;

        /* renamed from: h  reason: collision with root package name */
        public SimpleQueue<T> f16999h;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f17000i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f17001j;

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f17002k;

        /* renamed from: l  reason: collision with root package name */
        public volatile boolean f17003l;

        /* renamed from: m  reason: collision with root package name */
        public int f17004m;

        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;

            /* renamed from: b  reason: collision with root package name */
            public final Observer<? super R> f17005b;

            /* renamed from: c  reason: collision with root package name */
            public final ConcatMapDelayErrorObserver<?, R> f17006c;

            public DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.f17005b = observer;
                this.f17006c = concatMapDelayErrorObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f17006c;
                concatMapDelayErrorObserver.f17001j = false;
                concatMapDelayErrorObserver.a();
            }

            public void onError(Throwable th2) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.f17006c;
                if (concatMapDelayErrorObserver.f16996e.addThrowable(th2)) {
                    if (!concatMapDelayErrorObserver.f16998g) {
                        concatMapDelayErrorObserver.f17000i.dispose();
                    }
                    concatMapDelayErrorObserver.f17001j = false;
                    concatMapDelayErrorObserver.a();
                    return;
                }
                RxJavaPlugins.onError(th2);
            }

            public void onNext(R r11) {
                this.f17005b.onNext(r11);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i11, boolean z11) {
            this.f16993b = observer;
            this.f16994c = function;
            this.f16995d = i11;
            this.f16998g = z11;
            this.f16997f = new DelayErrorInnerObserver<>(observer, this);
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f16993b;
                SimpleQueue<T> simpleQueue = this.f16999h;
                AtomicThrowable atomicThrowable = this.f16996e;
                while (true) {
                    if (!this.f17001j) {
                        if (this.f17003l) {
                            simpleQueue.clear();
                            return;
                        } else if (this.f16998g || ((Throwable) atomicThrowable.get()) == null) {
                            boolean z12 = this.f17002k;
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                if (z12 && z11) {
                                    this.f17003l = true;
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate != null) {
                                        observer.onError(terminate);
                                        return;
                                    } else {
                                        observer.onComplete();
                                        return;
                                    }
                                } else if (!z11) {
                                    try {
                                        ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f16994c.apply(poll), "The mapper returned a null ObservableSource");
                                        if (observableSource instanceof Callable) {
                                            try {
                                                Object call = ((Callable) observableSource).call();
                                                if (call != null && !this.f17003l) {
                                                    observer.onNext(call);
                                                }
                                            } catch (Throwable th2) {
                                                Exceptions.throwIfFatal(th2);
                                                atomicThrowable.addThrowable(th2);
                                            }
                                        } else {
                                            this.f17001j = true;
                                            observableSource.subscribe(this.f16997f);
                                        }
                                    } catch (Throwable th3) {
                                        Exceptions.throwIfFatal(th3);
                                        this.f17003l = true;
                                        this.f17000i.dispose();
                                        simpleQueue.clear();
                                        atomicThrowable.addThrowable(th3);
                                        observer.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                Exceptions.throwIfFatal(th4);
                                this.f17003l = true;
                                this.f17000i.dispose();
                                atomicThrowable.addThrowable(th4);
                                observer.onError(atomicThrowable.terminate());
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            this.f17003l = true;
                            observer.onError(atomicThrowable.terminate());
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
            this.f17003l = true;
            this.f17000i.dispose();
            this.f16997f.a();
        }

        public boolean isDisposed() {
            return this.f17003l;
        }

        public void onComplete() {
            this.f17002k = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f16996e.addThrowable(th2)) {
                this.f17002k = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f17004m == 0) {
                this.f16999h.offer(t11);
            }
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17000i, disposable)) {
                this.f17000i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f17004m = requestFusion;
                        this.f16999h = queueDisposable;
                        this.f17002k = true;
                        this.f16993b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f17004m = requestFusion;
                        this.f16999h = queueDisposable;
                        this.f16993b.onSubscribe(this);
                        return;
                    }
                }
                this.f16999h = new SpscLinkedArrayQueue(this.f16995d);
                this.f16993b.onSubscribe(this);
            }
        }
    }

    public static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8828587559905699186L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f17007b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends U>> f17008c;

        /* renamed from: d  reason: collision with root package name */
        public final InnerObserver<U> f17009d;

        /* renamed from: e  reason: collision with root package name */
        public final int f17010e;

        /* renamed from: f  reason: collision with root package name */
        public SimpleQueue<T> f17011f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f17012g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17013h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f17014i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f17015j;

        /* renamed from: k  reason: collision with root package name */
        public int f17016k;

        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -7449079488798789337L;

            /* renamed from: b  reason: collision with root package name */
            public final Observer<? super U> f17017b;

            /* renamed from: c  reason: collision with root package name */
            public final SourceObserver<?, ?> f17018c;

            public InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                this.f17017b = observer;
                this.f17018c = sourceObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f17018c.b();
            }

            public void onError(Throwable th2) {
                this.f17018c.dispose();
                this.f17017b.onError(th2);
            }

            public void onNext(U u11) {
                this.f17017b.onNext(u11);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i11) {
            this.f17007b = observer;
            this.f17008c = function;
            this.f17010e = i11;
            this.f17009d = new InnerObserver<>(observer, this);
        }

        public void a() {
            boolean z11;
            if (getAndIncrement() == 0) {
                while (!this.f17014i) {
                    if (!this.f17013h) {
                        boolean z12 = this.f17015j;
                        try {
                            T poll = this.f17011f.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (z12 && z11) {
                                this.f17014i = true;
                                this.f17007b.onComplete();
                                return;
                            } else if (!z11) {
                                try {
                                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17008c.apply(poll), "The mapper returned a null ObservableSource");
                                    this.f17013h = true;
                                    observableSource.subscribe(this.f17009d);
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    dispose();
                                    this.f17011f.clear();
                                    this.f17007b.onError(th2);
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            dispose();
                            this.f17011f.clear();
                            this.f17007b.onError(th3);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f17011f.clear();
            }
        }

        public void b() {
            this.f17013h = false;
            a();
        }

        public void dispose() {
            this.f17014i = true;
            this.f17009d.a();
            this.f17012g.dispose();
            if (getAndIncrement() == 0) {
                this.f17011f.clear();
            }
        }

        public boolean isDisposed() {
            return this.f17014i;
        }

        public void onComplete() {
            if (!this.f17015j) {
                this.f17015j = true;
                a();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17015j) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17015j = true;
            dispose();
            this.f17007b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17015j) {
                if (this.f17016k == 0) {
                    this.f17011f.offer(t11);
                }
                a();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17012g, disposable)) {
                this.f17012g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.f17016k = requestFusion;
                        this.f17011f = queueDisposable;
                        this.f17015j = true;
                        this.f17007b.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.f17016k = requestFusion;
                        this.f17011f = queueDisposable;
                        this.f17007b.onSubscribe(this);
                        return;
                    }
                }
                this.f17011f = new SpscLinkedArrayQueue(this.f17010e);
                this.f17007b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i11, ErrorMode errorMode) {
        super(observableSource);
        this.f16990c = function;
        this.f16992e = errorMode;
        this.f16991d = Math.max(8, i11);
    }

    public void subscribeActual(Observer<? super U> observer) {
        boolean z11;
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.f16799b, observer, this.f16990c)) {
            if (this.f16992e == ErrorMode.IMMEDIATE) {
                this.f16799b.subscribe(new SourceObserver(new SerializedObserver(observer), this.f16990c, this.f16991d));
                return;
            }
            ObservableSource<T> observableSource = this.f16799b;
            Function<? super T, ? extends ObservableSource<? extends U>> function = this.f16990c;
            int i11 = this.f16991d;
            if (this.f16992e == ErrorMode.END) {
                z11 = true;
            } else {
                z11 = false;
            }
            observableSource.subscribe(new ConcatMapDelayErrorObserver(observer, function, i11, z11));
        }
    }
}
