package io.reactivex.rxjava3.internal.operators.observable;

import i.b;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.operators.SimplePlainQueue;
import io.reactivex.rxjava3.operators.SimpleQueue;
import io.reactivex.rxjava3.operators.SpscArrayQueue;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends U>> f21704c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21705d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21706e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21707f;

    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;

        /* renamed from: b  reason: collision with root package name */
        public final long f21708b;

        /* renamed from: c  reason: collision with root package name */
        public final MergeObserver<T, U> f21709c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f21710d;

        /* renamed from: e  reason: collision with root package name */
        public volatile SimpleQueue<U> f21711e;

        /* renamed from: f  reason: collision with root package name */
        public int f21712f;

        public InnerObserver(MergeObserver<T, U> mergeObserver, long j11) {
            this.f21708b = j11;
            this.f21709c = mergeObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f21710d = true;
            this.f21709c.d();
        }

        public void onError(Throwable th2) {
            if (this.f21709c.f21722i.tryAddThrowableOrReport(th2)) {
                MergeObserver<T, U> mergeObserver = this.f21709c;
                if (!mergeObserver.f21717d) {
                    mergeObserver.c();
                }
                this.f21710d = true;
                this.f21709c.d();
            }
        }

        public void onNext(U u11) {
            if (this.f21712f == 0) {
                this.f21709c.i(u11, this);
            } else {
                this.f21709c.d();
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.f21712f = requestFusion;
                    this.f21711e = queueDisposable;
                    this.f21710d = true;
                    this.f21709c.d();
                } else if (requestFusion == 2) {
                    this.f21712f = requestFusion;
                    this.f21711e = queueDisposable;
                }
            }
        }
    }

    public static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {

        /* renamed from: q  reason: collision with root package name */
        public static final InnerObserver<?, ?>[] f21713q = new InnerObserver[0];

        /* renamed from: r  reason: collision with root package name */
        public static final InnerObserver<?, ?>[] f21714r = new InnerObserver[0];
        private static final long serialVersionUID = -2117620485640801370L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f21715b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends U>> f21716c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21717d;

        /* renamed from: e  reason: collision with root package name */
        public final int f21718e;

        /* renamed from: f  reason: collision with root package name */
        public final int f21719f;

        /* renamed from: g  reason: collision with root package name */
        public volatile SimplePlainQueue<U> f21720g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f21721h;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicThrowable f21722i = new AtomicThrowable();

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f21723j;

        /* renamed from: k  reason: collision with root package name */
        public final AtomicReference<InnerObserver<?, ?>[]> f21724k;

        /* renamed from: l  reason: collision with root package name */
        public Disposable f21725l;

        /* renamed from: m  reason: collision with root package name */
        public long f21726m;

        /* renamed from: n  reason: collision with root package name */
        public int f21727n;

        /* renamed from: o  reason: collision with root package name */
        public Queue<ObservableSource<? extends U>> f21728o;

        /* renamed from: p  reason: collision with root package name */
        public int f21729p;

        public MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z11, int i11, int i12) {
            this.f21715b = observer;
            this.f21716c = function;
            this.f21717d = z11;
            this.f21718e = i11;
            this.f21719f = i12;
            if (i11 != Integer.MAX_VALUE) {
                this.f21728o = new ArrayDeque(i11);
            }
            this.f21724k = new AtomicReference<>(f21713q);
        }

        public boolean a(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.f21724k.get();
                if (innerObserverArr == f21714r) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[(length + 1)];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!b.a(this.f21724k, innerObserverArr, innerObserverArr2));
            return true;
        }

        public boolean b() {
            if (this.f21723j) {
                return true;
            }
            Throwable th2 = (Throwable) this.f21722i.get();
            if (this.f21717d || th2 == null) {
                return false;
            }
            c();
            this.f21722i.tryTerminateConsumer((Observer<?>) this.f21715b);
            return true;
        }

        public boolean c() {
            this.f21725l.dispose();
            AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.f21724k;
            InnerObserver<?, ?>[] innerObserverArr = f21714r;
            InnerObserver<?, ?>[] innerObserverArr2 = (InnerObserver[]) atomicReference.getAndSet(innerObserverArr);
            if (innerObserverArr2 == innerObserverArr) {
                return false;
            }
            for (InnerObserver<?, ?> dispose : innerObserverArr2) {
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
            this.f21723j = true;
            if (c()) {
                this.f21722i.tryTerminateAndReport();
            }
        }

        public void e() {
            int i11;
            Observer<? super U> observer = this.f21715b;
            int i12 = 1;
            while (!b()) {
                SimplePlainQueue<U> simplePlainQueue = this.f21720g;
                int i13 = 0;
                if (simplePlainQueue != null) {
                    while (!b()) {
                        U poll = simplePlainQueue.poll();
                        if (poll != null) {
                            observer.onNext(poll);
                            i13++;
                        }
                    }
                    return;
                }
                if (i13 == 0) {
                    boolean z11 = this.f21721h;
                    SimplePlainQueue<U> simplePlainQueue2 = this.f21720g;
                    InnerObserver[] innerObserverArr = (InnerObserver[]) this.f21724k.get();
                    int length = innerObserverArr.length;
                    if (this.f21718e != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i11 = this.f21728o.size();
                        }
                    } else {
                        i11 = 0;
                    }
                    if (!z11 || !((simplePlainQueue2 == null || simplePlainQueue2.isEmpty()) && length == 0 && i11 == 0)) {
                        if (length != 0) {
                            int min = Math.min(length - 1, this.f21727n);
                            int i14 = 0;
                            while (i14 < length) {
                                if (!b()) {
                                    InnerObserver innerObserver = innerObserverArr[min];
                                    SimpleQueue<U> simpleQueue = innerObserver.f21711e;
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
                                                this.f21722i.tryAddThrowableOrReport(th2);
                                                if (!b()) {
                                                    f(innerObserver);
                                                    i13++;
                                                    min++;
                                                    if (min != length) {
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                    boolean z12 = innerObserver.f21710d;
                                    SimpleQueue<U> simpleQueue2 = innerObserver.f21711e;
                                    if (z12 && (simpleQueue2 == null || simpleQueue2.isEmpty())) {
                                        f(innerObserver);
                                        i13++;
                                    }
                                    min++;
                                    if (min != length) {
                                        i14++;
                                    }
                                    min = 0;
                                    i14++;
                                } else {
                                    return;
                                }
                            }
                            this.f21727n = min;
                        }
                        if (i13 == 0) {
                            i12 = addAndGet(-i12);
                            if (i12 == 0) {
                                return;
                            }
                        } else if (this.f21718e != Integer.MAX_VALUE) {
                            h(i13);
                        }
                    } else {
                        this.f21722i.tryTerminateConsumer((Observer<?>) this.f21715b);
                        return;
                    }
                } else if (this.f21718e != Integer.MAX_VALUE) {
                    h(i13);
                }
            }
        }

        public void f(InnerObserver<T, U> innerObserver) {
            InnerObserver<T, U>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.f21724k.get();
                int length = innerObserverArr.length;
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
                        innerObserverArr2 = f21713q;
                    } else {
                        InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[(length - 1)];
                        System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i11);
                        System.arraycopy(innerObserverArr, i11 + 1, innerObserverArr3, i11, (length - i11) - 1);
                        innerObserverArr2 = innerObserverArr3;
                    }
                } else {
                    return;
                }
            } while (!b.a(this.f21724k, innerObserverArr, innerObserverArr2));
        }

        public void g(ObservableSource<? extends U> observableSource) {
            boolean z11;
            while (observableSource instanceof Supplier) {
                if (j((Supplier) observableSource) && this.f21718e != Integer.MAX_VALUE) {
                    synchronized (this) {
                        observableSource = this.f21728o.poll();
                        if (observableSource == null) {
                            z11 = true;
                            this.f21729p--;
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
            long j11 = this.f21726m;
            this.f21726m = 1 + j11;
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
                        ObservableSource poll = this.f21728o.poll();
                        if (poll == null) {
                            this.f21729p--;
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
                SimpleQueue simpleQueue = innerObserver.f21711e;
                if (simpleQueue == null) {
                    simpleQueue = new SpscLinkedArrayQueue(this.f21719f);
                    innerObserver.f21711e = simpleQueue;
                }
                simpleQueue.offer(u11);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.f21715b.onNext(u11);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            e();
        }

        public boolean isDisposed() {
            return this.f21723j;
        }

        public boolean j(Supplier<? extends U> supplier) {
            try {
                Object obj = supplier.get();
                if (obj == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    SimplePlainQueue<U> simplePlainQueue = this.f21720g;
                    if (simplePlainQueue == null) {
                        if (this.f21718e == Integer.MAX_VALUE) {
                            simplePlainQueue = new SpscLinkedArrayQueue<>(this.f21719f);
                        } else {
                            simplePlainQueue = new SpscArrayQueue<>(this.f21718e);
                        }
                        this.f21720g = simplePlainQueue;
                    }
                    simplePlainQueue.offer(obj);
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.f21715b.onNext(obj);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                e();
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21722i.tryAddThrowableOrReport(th2);
                d();
                return true;
            }
        }

        public void onComplete() {
            if (!this.f21721h) {
                this.f21721h = true;
                d();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21721h) {
                RxJavaPlugins.onError(th2);
            } else if (this.f21722i.tryAddThrowableOrReport(th2)) {
                this.f21721h = true;
                d();
            }
        }

        public void onNext(T t11) {
            if (!this.f21721h) {
                try {
                    Object apply = this.f21716c.apply(t11);
                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                    ObservableSource observableSource = (ObservableSource) apply;
                    if (this.f21718e != Integer.MAX_VALUE) {
                        synchronized (this) {
                            int i11 = this.f21729p;
                            if (i11 == this.f21718e) {
                                this.f21728o.offer(observableSource);
                                return;
                            }
                            this.f21729p = i11 + 1;
                        }
                    }
                    g(observableSource);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21725l.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21725l, disposable)) {
                this.f21725l = disposable;
                this.f21715b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z11, int i11, int i12) {
        super(observableSource);
        this.f21704c = function;
        this.f21705d = z11;
        this.f21706e = i11;
        this.f21707f = i12;
    }

    public void subscribeActual(Observer<? super U> observer) {
        if (!ObservableScalarXMap.tryScalarXMapSubscribe(this.f21304b, observer, this.f21704c)) {
            this.f21304b.subscribe(new MergeObserver(observer, this.f21704c, this.f21705d, this.f21706e, this.f21707f));
        }
    }
}
