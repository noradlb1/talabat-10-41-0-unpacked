package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f17176c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17177d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17178e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17179f;

    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;

        /* renamed from: b  reason: collision with root package name */
        public final long f17180b;

        /* renamed from: c  reason: collision with root package name */
        public final MergeObserver<T, U> f17181c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f17182d;

        /* renamed from: e  reason: collision with root package name */
        public volatile SimpleQueue<U> f17183e;

        /* renamed from: f  reason: collision with root package name */
        public int f17184f;

        public InnerObserver(MergeObserver<T, U> mergeObserver, long j11) {
            this.f17180b = j11;
            this.f17181c = mergeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f17182d = true;
            this.f17181c.d();
        }

        public void onError(Throwable th2) {
            if (this.f17181c.f17194i.addThrowable(th2)) {
                MergeObserver<T, U> mergeObserver = this.f17181c;
                if (!mergeObserver.f17189d) {
                    mergeObserver.c();
                }
                this.f17182d = true;
                this.f17181c.d();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(U u11) {
            if (this.f17184f == 0) {
                this.f17181c.i(u11, this);
            } else {
                this.f17181c.d();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.f17184f = requestFusion;
                    this.f17183e = queueDisposable;
                    this.f17182d = true;
                    this.f17181c.d();
                } else if (requestFusion == 2) {
                    this.f17184f = requestFusion;
                    this.f17183e = queueDisposable;
                }
            }
        }
    }

    public static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {

        /* renamed from: r  reason: collision with root package name */
        public static final InnerObserver<?, ?>[] f17185r = new InnerObserver[0];

        /* renamed from: s  reason: collision with root package name */
        public static final InnerObserver<?, ?>[] f17186s = new InnerObserver[0];
        private static final long serialVersionUID = -2117620485640801370L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f17187b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends U>> f17188c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f17189d;

        /* renamed from: e  reason: collision with root package name */
        public final int f17190e;

        /* renamed from: f  reason: collision with root package name */
        public final int f17191f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SimplePlainQueue<U> f17192g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17193h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicThrowable f17194i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f17195j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicReference<InnerObserver<?, ?>[]> f17196k;

        /* renamed from: l  reason: collision with root package name */
        public Disposable f17197l;

        /* renamed from: m  reason: collision with root package name */
        public long f17198m;

        /* renamed from: n  reason: collision with root package name */
        public long f17199n;

        /* renamed from: o  reason: collision with root package name */
        public int f17200o;

        /* renamed from: p  reason: collision with root package name */
        public Queue<ObservableSource<? extends U>> f17201p;

        /* renamed from: q  reason: collision with root package name */
        public int f17202q;

        public MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z11, int i11, int i12) {
            this.f17187b = observer;
            this.f17188c = function;
            this.f17189d = z11;
            this.f17190e = i11;
            this.f17191f = i12;
            if (i11 != Integer.MAX_VALUE) {
                this.f17201p = new ArrayDeque(i11);
            }
            this.f17196k = new AtomicReference<>(f17185r);
        }

        public boolean a(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.f17196k.get();
                if (innerObserverArr == f17186s) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[(length + 1)];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!b.a(this.f17196k, innerObserverArr, innerObserverArr2));
            return true;
        }

        public boolean b() {
            if (this.f17195j) {
                return true;
            }
            Throwable th2 = (Throwable) this.f17194i.get();
            if (this.f17189d || th2 == null) {
                return false;
            }
            c();
            Throwable terminate = this.f17194i.terminate();
            if (terminate != ExceptionHelper.TERMINATED) {
                this.f17187b.onError(terminate);
            }
            return true;
        }

        public boolean c() {
            InnerObserver<?, ?>[] innerObserverArr;
            this.f17197l.dispose();
            InnerObserver<?, ?>[] innerObserverArr2 = (InnerObserver[]) this.f17196k.get();
            InnerObserver<?, ?>[] innerObserverArr3 = f17186s;
            if (innerObserverArr2 == innerObserverArr3 || (innerObserverArr = (InnerObserver[]) this.f17196k.getAndSet(innerObserverArr3)) == innerObserverArr3) {
                return false;
            }
            for (InnerObserver<?, ?> dispose : innerObserverArr) {
                dispose.dispose();
            }
            return true;
        }

        public void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        public void dispose() {
            Throwable terminate;
            if (!this.f17195j) {
                this.f17195j = true;
                if (c() && (terminate = this.f17194i.terminate()) != null && terminate != ExceptionHelper.TERMINATED) {
                    RxJavaPlugins.onError(terminate);
                }
            }
        }

        public void e() {
            int i11;
            int i12;
            Observer<? super U> observer = this.f17187b;
            int i13 = 1;
            while (!b()) {
                SimplePlainQueue<U> simplePlainQueue = this.f17192g;
                int i14 = 0;
                if (simplePlainQueue != null) {
                    while (!b()) {
                        U poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                            i14++;
                        }
                    }
                    return;
                }
                if (i14 == 0) {
                    boolean z11 = this.f17193h;
                    SimplePlainQueue<U> simplePlainQueue2 = this.f17192g;
                    InnerObserver[] innerObserverArr = (InnerObserver[]) this.f17196k.get();
                    int length = innerObserverArr.length;
                    if (this.f17190e != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i11 = this.f17201p.size();
                        }
                    } else {
                        i11 = 0;
                    }
                    if (!z11 || !((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i11 == 0)) {
                        if (length != 0) {
                            long j11 = this.f17199n;
                            int i15 = this.f17200o;
                            if (length <= i15 || innerObserverArr[i15].f17180b != j11) {
                                if (length <= i15) {
                                    i15 = 0;
                                }
                                for (int i16 = 0; i16 < length && innerObserverArr[i15].f17180b != j11; i16++) {
                                    i15++;
                                    if (i15 == length) {
                                        i15 = 0;
                                    }
                                }
                                this.f17200o = i15;
                                this.f17199n = innerObserverArr[i15].f17180b;
                            }
                            int i17 = 0;
                            while (i17 < length) {
                                if (!b()) {
                                    InnerObserver innerObserver = innerObserverArr[i15];
                                    SimpleQueue<U> simpleQueue = innerObserver.f17183e;
                                    if (simpleQueue != null) {
                                        while (true) {
                                            try {
                                                U poll2 = simpleQueue.poll();
                                                if (poll2 == null) {
                                                    break;
                                                }
                                                observer.onNext(poll2);
                                                if (b()) {
                                                    return;
                                                }
                                            } catch (Throwable th2) {
                                                Exceptions.throwIfFatal(th2);
                                                innerObserver.dispose();
                                                this.f17194i.addThrowable(th2);
                                                if (!b()) {
                                                    f(innerObserver);
                                                    i14++;
                                                    i12 = i15 + 1;
                                                    if (i12 != length) {
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                    boolean z12 = innerObserver.f17182d;
                                    SimpleQueue<U> simpleQueue2 = innerObserver.f17183e;
                                    if (z12 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                        f(innerObserver);
                                        if (!b()) {
                                            i14++;
                                        } else {
                                            return;
                                        }
                                    }
                                    i12 = i15 + 1;
                                    if (i12 != length) {
                                        i17++;
                                    }
                                    i12 = 0;
                                    i17++;
                                } else {
                                    return;
                                }
                            }
                            this.f17200o = i15;
                            this.f17199n = innerObserverArr[i15].f17180b;
                        }
                        if (i14 == 0) {
                            i13 = addAndGet(-i13);
                            if (i13 == 0) {
                                return;
                            }
                        } else if (this.f17190e != Integer.MAX_VALUE) {
                            h(i14);
                        }
                    } else {
                        Throwable terminate = this.f17194i.terminate();
                        if (terminate == ExceptionHelper.TERMINATED) {
                            return;
                        }
                        if (terminate == null) {
                            observer.onComplete();
                            return;
                        } else {
                            observer.onError(terminate);
                            return;
                        }
                    }
                } else if (this.f17190e != Integer.MAX_VALUE) {
                    h(i14);
                }
            }
        }

        public void f(InnerObserver<T, U> innerObserver) {
            InnerObserver<T, U>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.f17196k.get();
                int length = innerObserverArr.length;
                if (length != 0) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            i11 = -1;
                            break;
                        } else if (innerObserverArr[i11] == innerObserver) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i11 >= 0) {
                        if (length == 1) {
                            innerObserverArr2 = f17185r;
                        } else {
                            InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[(length - 1)];
                            System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i11);
                            System.arraycopy(innerObserverArr, i11 + 1, innerObserverArr3, i11, (length - i11) - 1);
                            innerObserverArr2 = innerObserverArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!b.a(this.f17196k, innerObserverArr, innerObserverArr2));
        }

        public void g(ObservableSource<? extends U> observableSource) {
            boolean z11;
            while (observableSource instanceof Callable) {
                if (j((Callable) observableSource) && this.f17190e != Integer.MAX_VALUE) {
                    synchronized (this) {
                        observableSource = this.f17201p.poll();
                        if (observableSource == null) {
                            z11 = true;
                            this.f17202q--;
                        } else {
                            z11 = false;
                        }
                    }
                    if (z11) {
                        d();
                        return;
                    }
                } else {
                    return;
                }
            }
            long j11 = this.f17198m;
            this.f17198m = 1 + j11;
            InnerObserver innerObserver = new InnerObserver(this, j11);
            if (a(innerObserver)) {
                observableSource.subscribe(innerObserver);
            }
        }

        public void h(int i11) {
            while (true) {
                int i12 = i11 - 1;
                if (i11 != 0) {
                    synchronized (this) {
                        ObservableSource poll = this.f17201p.poll();
                        if (poll == null) {
                            this.f17202q--;
                        } else {
                            g(poll);
                        }
                    }
                    i11 = i12;
                } else {
                    return;
                }
            }
            while (true) {
            }
        }

        public void i(U u11, InnerObserver<T, U> innerObserver) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                SimpleQueue simpleQueue = innerObserver.f17183e;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.f17191f);
                    innerObserver.f17183e = simpleQueue;
                }
                simpleQueue.offer(u11);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.f17187b.onNext(u11);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            e();
        }

        public boolean isDisposed() {
            return this.f17195j;
        }

        public boolean j(Callable<? extends U> callable) {
            try {
                Object call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SimplePlainQueue<U> simplePlainQueue = this.f17192g;
                    if (simplePlainQueue == null) {
                        if (this.f17190e == Integer.MAX_VALUE) {
                            simplePlainQueue = new SpscLinkedArrayQueue<>(this.f17191f);
                        } else {
                            simplePlainQueue = new SpscArrayQueue<>(this.f17190e);
                        }
                        this.f17192g = simplePlainQueue;
                    }
                    if (!simplePlainQueue.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.f17187b.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                e();
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17194i.addThrowable(th2);
                d();
                return true;
            }
        }

        public void onComplete() {
            if (!this.f17193h) {
                this.f17193h = true;
                d();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17193h) {
                RxJavaPlugins.onError(th2);
            } else if (this.f17194i.addThrowable(th2)) {
                this.f17193h = true;
                d();
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f17193h) {
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17188c.apply(t11), "The mapper returned a null ObservableSource");
                    if (this.f17190e != Integer.MAX_VALUE) {
                        synchronized (this) {
                            int i11 = this.f17202q;
                            if (i11 == this.f17190e) {
                                this.f17201p.offer(observableSource);
                                return;
                            }
                            this.f17202q = i11 + 1;
                        }
                    }
                    g(observableSource);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17197l.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17197l, disposable)) {
                this.f17197l = disposable;
                this.f17187b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z11, int i11, int i12) {
        super(observableSource);
        this.f17176c = function;
        this.f17177d = z11;
        this.f17178e = i11;
        this.f17179f = i12;
    }

    public void subscribeActual(Observer<? super U> observer) {
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.f16799b, observer, this.f17176c)) {
            this.f16799b.subscribe(new MergeObserver(observer, this.f17176c, this.f17177d, this.f17178e, this.f17179f));
        }
    }
}
