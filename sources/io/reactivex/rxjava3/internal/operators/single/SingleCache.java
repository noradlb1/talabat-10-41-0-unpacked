package io.reactivex.rxjava3.internal.operators.single;

import i.b;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: g  reason: collision with root package name */
    public static final CacheDisposable[] f22754g = new CacheDisposable[0];

    /* renamed from: h  reason: collision with root package name */
    public static final CacheDisposable[] f22755h = new CacheDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22756b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f22757c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f22758d = new AtomicReference<>(f22754g);

    /* renamed from: e  reason: collision with root package name */
    public T f22759e;

    /* renamed from: f  reason: collision with root package name */
    public Throwable f22760f;

    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22761b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleCache<T> f22762c;

        public CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.f22761b = singleObserver;
            this.f22762c = singleCache;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f22762c.b(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.f22756b = singleSource;
    }

    public boolean a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f22758d.get();
            if (cacheDisposableArr == f22755h) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!b.a(this.f22758d, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f22758d.get();
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
                        cacheDisposableArr2 = f22754g;
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
        } while (!b.a(this.f22758d, cacheDisposableArr, cacheDisposableArr2));
    }

    public void onError(Throwable th2) {
        this.f22760f = th2;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f22758d.getAndSet(f22755h)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f22761b.onError(th2);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void onSuccess(T t11) {
        this.f22759e = t11;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f22758d.getAndSet(f22755h)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f22761b.onSuccess(t11);
            }
        }
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        if (a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                b(cacheDisposable);
            }
            if (this.f22757c.getAndIncrement() == 0) {
                this.f22756b.subscribe(this);
                return;
            }
            return;
        }
        Throwable th2 = this.f22760f;
        if (th2 != null) {
            singleObserver.onError(th2);
        } else {
            singleObserver.onSuccess(this.f22759e);
        }
    }
}
