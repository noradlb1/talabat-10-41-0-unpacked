package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<U> f21373c;

    /* renamed from: d  reason: collision with root package name */
    public final ObservableSource<? extends Open> f21374d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Open, ? extends ObservableSource<? extends Close>> f21375e;

    public static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8466418554264089604L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super C> f21376b;

        /* renamed from: c  reason: collision with root package name */
        public final Supplier<C> f21377c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends Open> f21378d;

        /* renamed from: e  reason: collision with root package name */
        public final Function<? super Open, ? extends ObservableSource<? extends Close>> f21379e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f21380f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Disposable> f21381g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f21382h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21383i;

        /* renamed from: j  reason: collision with root package name */
        public final SpscLinkedArrayQueue<C> f21384j = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f21385k;

        /* renamed from: l  reason: collision with root package name */
        public long f21386l;

        /* renamed from: m  reason: collision with root package name */
        public Map<Long, C> f21387m = new LinkedHashMap();

        public static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;

            /* renamed from: b  reason: collision with root package name */
            public final BufferBoundaryObserver<?, ?, Open, ?> f21388b;

            public BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.f21388b = bufferBoundaryObserver;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.f21388b.e(this);
            }

            public void onError(Throwable th2) {
                lazySet(DisposableHelper.DISPOSED);
                this.f21388b.a(this, th2);
            }

            public void onNext(Open open) {
                this.f21388b.d(open);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Supplier<C> supplier) {
            this.f21376b = observer;
            this.f21377c = supplier;
            this.f21378d = observableSource;
            this.f21379e = function;
        }

        public void a(Disposable disposable, Throwable th2) {
            DisposableHelper.dispose(this.f21381g);
            this.f21380f.delete(disposable);
            onError(th2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (r4 == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
            r3.f21383i = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver<T, C> r4, long r5) {
            /*
                r3 = this;
                io.reactivex.rxjava3.disposables.CompositeDisposable r0 = r3.f21380f
                r0.delete(r4)
                io.reactivex.rxjava3.disposables.CompositeDisposable r4 = r3.f21380f
                int r4 = r4.size()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.disposables.Disposable> r4 = r3.f21381g
                io.reactivex.rxjava3.internal.disposables.DisposableHelper.dispose(r4)
                r4 = r0
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.Map<java.lang.Long, C> r1 = r3.f21387m     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x001d
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x001d:
                io.reactivex.rxjava3.operators.SpscLinkedArrayQueue<C> r2 = r3.f21384j     // Catch:{ all -> 0x0033 }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0033 }
                java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x0033 }
                r2.offer(r5)     // Catch:{ all -> 0x0033 }
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x002f
                r3.f21383i = r0
            L_0x002f:
                r3.c()
                return
            L_0x0033:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.b(io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver, long):void");
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super C> observer = this.f21376b;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.f21384j;
                int i11 = 1;
                while (!this.f21385k) {
                    boolean z12 = this.f21383i;
                    if (!z12 || this.f21382h.get() == null) {
                        Collection collection = (Collection) spscLinkedArrayQueue.poll();
                        if (collection == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            observer.onComplete();
                            return;
                        } else if (z11) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            observer.onNext(collection);
                        }
                    } else {
                        spscLinkedArrayQueue.clear();
                        this.f21382h.tryTerminateConsumer((Observer<?>) observer);
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void d(Open open) {
            try {
                C c11 = this.f21377c.get();
                Objects.requireNonNull(c11, "The bufferSupplier returned a null Collection");
                Collection collection = (Collection) c11;
                Object apply = this.f21379e.apply(open);
                Objects.requireNonNull(apply, "The bufferClose returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
                long j11 = this.f21386l;
                this.f21386l = 1 + j11;
                synchronized (this) {
                    Map<Long, C> map = this.f21387m;
                    if (map != null) {
                        map.put(Long.valueOf(j11), collection);
                        BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j11);
                        this.f21380f.add(bufferCloseObserver);
                        observableSource.subscribe(bufferCloseObserver);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                DisposableHelper.dispose(this.f21381g);
                onError(th2);
            }
        }

        public void dispose() {
            if (DisposableHelper.dispose(this.f21381g)) {
                this.f21385k = true;
                this.f21380f.dispose();
                synchronized (this) {
                    this.f21387m = null;
                }
                if (getAndIncrement() != 0) {
                    this.f21384j.clear();
                }
            }
        }

        public void e(BufferOpenObserver<Open> bufferOpenObserver) {
            this.f21380f.delete(bufferOpenObserver);
            if (this.f21380f.size() == 0) {
                DisposableHelper.dispose(this.f21381g);
                this.f21383i = true;
                c();
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f21381g.get());
        }

        public void onComplete() {
            this.f21380f.dispose();
            synchronized (this) {
                Map<Long, C> map = this.f21387m;
                if (map != null) {
                    for (C offer : map.values()) {
                        this.f21384j.offer(offer);
                    }
                    this.f21387m = null;
                    this.f21383i = true;
                    c();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f21382h.tryAddThrowableOrReport(th2)) {
                this.f21380f.dispose();
                synchronized (this) {
                    this.f21387m = null;
                }
                this.f21383i = true;
                c();
            }
        }

        public void onNext(T t11) {
            synchronized (this) {
                Map<Long, C> map = this.f21387m;
                if (map != null) {
                    for (C add : map.values()) {
                        add.add(t11);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f21381g, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.f21380f.add(bufferOpenObserver);
                this.f21378d.subscribe(bufferOpenObserver);
            }
        }
    }

    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;

        /* renamed from: b  reason: collision with root package name */
        public final BufferBoundaryObserver<T, C, ?, ?> f21389b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21390c;

        public BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j11) {
            this.f21389b = bufferBoundaryObserver;
            this.f21390c = j11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f21389b.b(this, this.f21390c);
            }
        }

        public void onError(Throwable th2) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f21389b.a(this, th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.f21389b.b(this, this.f21390c);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Supplier<U> supplier) {
        super(observableSource);
        this.f21374d = observableSource2;
        this.f21375e = function;
        this.f21373c = supplier;
    }

    public void subscribeActual(Observer<? super U> observer) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.f21374d, this.f21375e, this.f21373c);
        observer.onSubscribe(bufferBoundaryObserver);
        this.f21304b.subscribe(bufferBoundaryObserver);
    }
}
