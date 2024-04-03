package io.reactivex.rxjava3.internal.operators.observable;

import i.b;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {

    /* renamed from: l  reason: collision with root package name */
    public static final CacheDisposable[] f21434l = new CacheDisposable[0];

    /* renamed from: m  reason: collision with root package name */
    public static final CacheDisposable[] f21435m = new CacheDisposable[0];

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f21436c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public final int f21437d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f21438e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f21439f;

    /* renamed from: g  reason: collision with root package name */
    public final Node<T> f21440g;

    /* renamed from: h  reason: collision with root package name */
    public Node<T> f21441h;

    /* renamed from: i  reason: collision with root package name */
    public int f21442i;

    /* renamed from: j  reason: collision with root package name */
    public Throwable f21443j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f21444k;

    public static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21445b;

        /* renamed from: c  reason: collision with root package name */
        public final ObservableCache<T> f21446c;

        /* renamed from: d  reason: collision with root package name */
        public Node<T> f21447d;

        /* renamed from: e  reason: collision with root package name */
        public int f21448e;

        /* renamed from: f  reason: collision with root package name */
        public long f21449f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f21450g;

        public CacheDisposable(Observer<? super T> observer, ObservableCache<T> observableCache) {
            this.f21445b = observer;
            this.f21446c = observableCache;
            this.f21447d = observableCache.f21440g;
        }

        public void dispose() {
            if (!this.f21450g) {
                this.f21450g = true;
                this.f21446c.b(this);
            }
        }

        public boolean isDisposed() {
            return this.f21450g;
        }
    }

    public static final class Node<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T[] f21451a;

        /* renamed from: b  reason: collision with root package name */
        public volatile Node<T> f21452b;

        public Node(int i11) {
            this.f21451a = new Object[i11];
        }
    }

    public ObservableCache(Observable<T> observable, int i11) {
        super(observable);
        this.f21437d = i11;
        Node<T> node = new Node<>(i11);
        this.f21440g = node;
        this.f21441h = node;
        this.f21438e = new AtomicReference<>(f21434l);
    }

    public void a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f21438e.get();
            if (cacheDisposableArr != f21435m) {
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[(length + 1)];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } else {
                return;
            }
        } while (!b.a(this.f21438e, cacheDisposableArr, cacheDisposableArr2));
    }

    public void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f21438e.get();
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
                        cacheDisposableArr2 = f21434l;
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
        } while (!b.a(this.f21438e, cacheDisposableArr, cacheDisposableArr2));
    }

    public void c(CacheDisposable<T> cacheDisposable) {
        boolean z11;
        if (cacheDisposable.getAndIncrement() == 0) {
            long j11 = cacheDisposable.f21449f;
            int i11 = cacheDisposable.f21448e;
            Node<T> node = cacheDisposable.f21447d;
            Observer<? super T> observer = cacheDisposable.f21445b;
            int i12 = this.f21437d;
            int i13 = 1;
            while (!cacheDisposable.f21450g) {
                boolean z12 = this.f21444k;
                if (this.f21439f == j11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z12 && z11) {
                    cacheDisposable.f21447d = null;
                    Throwable th2 = this.f21443j;
                    if (th2 != null) {
                        observer.onError(th2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                } else if (!z11) {
                    if (i11 == i12) {
                        node = node.f21452b;
                        i11 = 0;
                    }
                    observer.onNext(node.f21451a[i11]);
                    i11++;
                    j11++;
                } else {
                    cacheDisposable.f21449f = j11;
                    cacheDisposable.f21448e = i11;
                    cacheDisposable.f21447d = node;
                    i13 = cacheDisposable.addAndGet(-i13);
                    if (i13 == 0) {
                        return;
                    }
                }
            }
            cacheDisposable.f21447d = null;
        }
    }

    public void onComplete() {
        this.f21444k = true;
        for (CacheDisposable c11 : (CacheDisposable[]) this.f21438e.getAndSet(f21435m)) {
            c(c11);
        }
    }

    public void onError(Throwable th2) {
        this.f21443j = th2;
        this.f21444k = true;
        for (CacheDisposable c11 : (CacheDisposable[]) this.f21438e.getAndSet(f21435m)) {
            c(c11);
        }
    }

    public void onNext(T t11) {
        int i11 = this.f21442i;
        if (i11 == this.f21437d) {
            Node<T> node = new Node<>(i11);
            node.f21451a[0] = t11;
            this.f21442i = 1;
            this.f21441h.f21452b = node;
            this.f21441h = node;
        } else {
            this.f21441h.f21451a[i11] = t11;
            this.f21442i = i11 + 1;
        }
        this.f21439f++;
        for (CacheDisposable c11 : (CacheDisposable[]) this.f21438e.get()) {
            c(c11);
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void subscribeActual(Observer<? super T> observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.onSubscribe(cacheDisposable);
        a(cacheDisposable);
        if (this.f21436c.get() || !this.f21436c.compareAndSet(false, true)) {
            c(cacheDisposable);
        } else {
            this.f21304b.subscribe(this);
        }
    }
}
