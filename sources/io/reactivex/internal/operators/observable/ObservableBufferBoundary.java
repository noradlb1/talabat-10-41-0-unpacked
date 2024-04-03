package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<U> f16868c;

    /* renamed from: d  reason: collision with root package name */
    public final ObservableSource<? extends Open> f16869d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<? super Open, ? extends ObservableSource<? extends Close>> f16870e;

    public static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8466418554264089604L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super C> f16871b;

        /* renamed from: c  reason: collision with root package name */
        public final Callable<C> f16872c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends Open> f16873d;

        /* renamed from: e  reason: collision with root package name */
        public final Function<? super Open, ? extends ObservableSource<? extends Close>> f16874e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f16875f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public final AtomicReference<Disposable> f16876g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        public final AtomicThrowable f16877h = new AtomicThrowable();

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f16878i;

        /* renamed from: j  reason: collision with root package name */
        public final SpscLinkedArrayQueue<C> f16879j = new SpscLinkedArrayQueue<>(Observable.bufferSize());

        /* renamed from: k  reason: collision with root package name */
        public volatile boolean f16880k;

        /* renamed from: l  reason: collision with root package name */
        public long f16881l;

        /* renamed from: m  reason: collision with root package name */
        public Map<Long, C> f16882m = new LinkedHashMap();

        public static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;

            /* renamed from: b  reason: collision with root package name */
            public final BufferBoundaryObserver<?, ?, Open, ?> f16883b;

            public BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.f16883b = bufferBoundaryObserver;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.f16883b.e(this);
            }

            public void onError(Throwable th2) {
                lazySet(DisposableHelper.DISPOSED);
                this.f16883b.a(this, th2);
            }

            public void onNext(Open open) {
                this.f16883b.d(open);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public BufferBoundaryObserver(Observer<? super C> observer, ObservableSource<? extends Open> observableSource, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<C> callable) {
            this.f16871b = observer;
            this.f16872c = callable;
            this.f16873d = observableSource;
            this.f16874e = function;
        }

        public void a(Disposable disposable, Throwable th2) {
            DisposableHelper.dispose(this.f16876g);
            this.f16875f.delete(disposable);
            onError(th2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
            if (r4 == false) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
            r3.f16878i = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
            c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver<T, C> r4, long r5) {
            /*
                r3 = this;
                io.reactivex.disposables.CompositeDisposable r0 = r3.f16875f
                r0.delete(r4)
                io.reactivex.disposables.CompositeDisposable r4 = r3.f16875f
                int r4 = r4.size()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> r4 = r3.f16876g
                io.reactivex.internal.disposables.DisposableHelper.dispose(r4)
                r4 = r0
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.Map<java.lang.Long, C> r1 = r3.f16882m     // Catch:{ all -> 0x0033 }
                if (r1 != 0) goto L_0x001d
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                return
            L_0x001d:
                io.reactivex.internal.queue.SpscLinkedArrayQueue<C> r2 = r3.f16879j     // Catch:{ all -> 0x0033 }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0033 }
                java.lang.Object r5 = r1.remove(r5)     // Catch:{ all -> 0x0033 }
                r2.offer(r5)     // Catch:{ all -> 0x0033 }
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x002f
                r3.f16878i = r0
            L_0x002f:
                r3.c()
                return
            L_0x0033:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0033 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.b(io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferCloseObserver, long):void");
        }

        public void c() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super C> observer = this.f16871b;
                SpscLinkedArrayQueue<C> spscLinkedArrayQueue = this.f16879j;
                int i11 = 1;
                while (!this.f16880k) {
                    boolean z12 = this.f16878i;
                    if (!z12 || this.f16877h.get() == null) {
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
                        observer.onError(this.f16877h.terminate());
                        return;
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        public void d(Open open) {
            try {
                Collection collection = (Collection) ObjectHelper.requireNonNull(this.f16872c.call(), "The bufferSupplier returned a null Collection");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f16874e.apply(open), "The bufferClose returned a null ObservableSource");
                long j11 = this.f16881l;
                this.f16881l = 1 + j11;
                synchronized (this) {
                    Map<Long, C> map = this.f16882m;
                    if (map != null) {
                        map.put(Long.valueOf(j11), collection);
                        BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j11);
                        this.f16875f.add(bufferCloseObserver);
                        observableSource.subscribe(bufferCloseObserver);
                    }
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                DisposableHelper.dispose(this.f16876g);
                onError(th2);
            }
        }

        public void dispose() {
            if (DisposableHelper.dispose(this.f16876g)) {
                this.f16880k = true;
                this.f16875f.dispose();
                synchronized (this) {
                    this.f16882m = null;
                }
                if (getAndIncrement() != 0) {
                    this.f16879j.clear();
                }
            }
        }

        public void e(BufferOpenObserver<Open> bufferOpenObserver) {
            this.f16875f.delete(bufferOpenObserver);
            if (this.f16875f.size() == 0) {
                DisposableHelper.dispose(this.f16876g);
                this.f16878i = true;
                c();
            }
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f16876g.get());
        }

        public void onComplete() {
            this.f16875f.dispose();
            synchronized (this) {
                Map<Long, C> map = this.f16882m;
                if (map != null) {
                    for (C offer : map.values()) {
                        this.f16879j.offer(offer);
                    }
                    this.f16882m = null;
                    this.f16878i = true;
                    c();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f16877h.addThrowable(th2)) {
                this.f16875f.dispose();
                synchronized (this) {
                    this.f16882m = null;
                }
                this.f16878i = true;
                c();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            synchronized (this) {
                Map<Long, C> map = this.f16882m;
                if (map != null) {
                    for (C add : map.values()) {
                        add.add(t11);
                    }
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.f16876g, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.f16875f.add(bufferOpenObserver);
                this.f16873d.subscribe(bufferOpenObserver);
            }
        }
    }

    public static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;

        /* renamed from: b  reason: collision with root package name */
        public final BufferBoundaryObserver<T, C, ?, ?> f16884b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16885c;

        public BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j11) {
            this.f16884b = bufferBoundaryObserver;
            this.f16885c = j11;
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
                this.f16884b.b(this, this.f16885c);
            }
        }

        public void onError(Throwable th2) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f16884b.a(this, th2);
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
                this.f16884b.b(this, this.f16885c);
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableBufferBoundary(ObservableSource<T> observableSource, ObservableSource<? extends Open> observableSource2, Function<? super Open, ? extends ObservableSource<? extends Close>> function, Callable<U> callable) {
        super(observableSource);
        this.f16869d = observableSource2;
        this.f16870e = function;
        this.f16868c = callable;
    }

    public void subscribeActual(Observer<? super U> observer) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.f16869d, this.f16870e, this.f16868c);
        observer.onSubscribe(bufferBoundaryObserver);
        this.f16799b.subscribe(bufferBoundaryObserver);
    }
}
