package io.reactivex.internal.operators.observable;

import i.b;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {

    /* renamed from: l  reason: collision with root package name */
    public static final CacheDisposable[] f16938l = new CacheDisposable[0];

    /* renamed from: m  reason: collision with root package name */
    public static final CacheDisposable[] f16939m = new CacheDisposable[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f16940c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public final int f16941d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f16942e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f16943f;

    /* renamed from: g  reason: collision with root package name */
    public final Node<T> f16944g;

    /* renamed from: h  reason: collision with root package name */
    public Node<T> f16945h;

    /* renamed from: i  reason: collision with root package name */
    public int f16946i;

    /* renamed from: j  reason: collision with root package name */
    public Throwable f16947j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f16948k;

    public static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f16949b;

        /* renamed from: c  reason: collision with root package name */
        public final ObservableCache<T> f16950c;

        /* renamed from: d  reason: collision with root package name */
        public Node<T> f16951d;

        /* renamed from: e  reason: collision with root package name */
        public int f16952e;

        /* renamed from: f  reason: collision with root package name */
        public long f16953f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f16954g;

        public CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.f16949b = observer;
            this.f16950c = observableCache;
            this.f16951d = observableCache.f16944g;
        }

        public void dispose() {
            if (!this.f16954g) {
                this.f16954g = true;
                this.f16950c.b(this);
            }
        }

        public boolean isDisposed() {
            return this.f16954g;
        }
    }

    public static final class Node<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T[] f16955a;

        /* renamed from: b  reason: collision with root package name */
        public volatile Node<T> f16956b;

        public Node(int i11) {
            this.f16955a = new Object[i11];
        }
    }

    public ObservableCache(Observable<T> observable, int i11) {
        super(observable);
        this.f16941d = i11;
        Node<T> node = new Node<>(i11);
        this.f16944g = node;
        this.f16945h = node;
        this.f16942e = new AtomicReference<>(f16938l);
    }

    public void a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f16942e.get();
            if (cacheDisposableArr != f16939m) {
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[(length + 1)];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } else {
                return;
            }
        } while (!b.a(this.f16942e, cacheDisposableArr, cacheDisposableArr2));
    }

    public void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f16942e.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (cacheDisposableArr[i11] == cacheDisposable) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = f16938l;
                    } else {
                        CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i11);
                        System.arraycopy(cacheDisposableArr, i11 + 1, cacheDisposableArr3, i11, (length - i11) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f16942e, cacheDisposableArr, cacheDisposableArr2));
    }

    public void c(CacheDisposable<T> cacheDisposable) {
        boolean z11;
        if (cacheDisposable.getAndIncrement() == 0) {
            long j11 = cacheDisposable.f16953f;
            int i11 = cacheDisposable.f16952e;
            Node<T> node = cacheDisposable.f16951d;
            Observer<? super T> observer = cacheDisposable.f16949b;
            int i12 = this.f16941d;
            int i13 = 1;
            while (!cacheDisposable.f16954g) {
                boolean z12 = this.f16948k;
                if (this.f16943f == j11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z12 && z11) {
                    cacheDisposable.f16951d = null;
                    Throwable th2 = this.f16947j;
                    if (th2 != null) {
                        observer.onError(th2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z11) {
                    if (i11 == i12) {
                        node = node.f16956b;
                        i11 = 0;
                    }
                    observer.onNext(node.f16955a[i11]);
                    i11++;
                    j11++;
                } else {
                    cacheDisposable.f16953f = j11;
                    cacheDisposable.f16952e = i11;
                    cacheDisposable.f16951d = node;
                    i13 = cacheDisposable.addAndGet(-i13);
                    if (i13 == 0) {
                        return;
                    }
                }
            }
            cacheDisposable.f16951d = null;
        }
    }

    public void onComplete() {
        this.f16948k = true;
        for (CacheDisposable c11 : (CacheDisposable[]) this.f16942e.getAndSet(f16939m)) {
            c(c11);
        }
    }

    public void onError(Throwable th2) {
        this.f16947j = th2;
        this.f16948k = true;
        for (CacheDisposable c11 : (CacheDisposable[]) this.f16942e.getAndSet(f16939m)) {
            c(c11);
        }
    }

    public void onNext(T t11) {
        int i11 = this.f16946i;
        if (i11 == this.f16941d) {
            Node<T> node = new Node<>(i11);
            node.f16955a[0] = t11;
            this.f16946i = 1;
            this.f16945h.f16956b = node;
            this.f16945h = node;
        } else {
            this.f16945h.f16955a[i11] = t11;
            this.f16946i = i11 + 1;
        }
        this.f16943f++;
        for (CacheDisposable c11 : (CacheDisposable[]) this.f16942e.get()) {
            c(c11);
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void subscribeActual(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.onSubscribe(cacheDisposable);
        a(cacheDisposable);
        if (this.f16940c.get() || !this.f16940c.compareAndSet(false, true)) {
            c(cacheDisposable);
        } else {
            this.f16799b.subscribe(this);
        }
    }
}
