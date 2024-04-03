package io.reactivex.internal.operators.single;

import i.b;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: g  reason: collision with root package name */
    public static final CacheDisposable[] f18220g = new CacheDisposable[0];

    /* renamed from: h  reason: collision with root package name */
    public static final CacheDisposable[] f18221h = new CacheDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18222b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f18223c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f18224d = new AtomicReference<>(f18220g);

    /* renamed from: e  reason: collision with root package name */
    public T f18225e;

    /* renamed from: f  reason: collision with root package name */
    public Throwable f18226f;

    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18227b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleCache<T> f18228c;

        public CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.f18227b = singleObserver;
            this.f18228c = singleCache;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f18228c.b(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        this.f18222b = singleSource;
    }

    public boolean a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f18224d.get();
            if (cacheDisposableArr == f18221h) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!b.a(this.f18224d, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f18224d.get();
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
                        cacheDisposableArr2 = f18220g;
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
        } while (!b.a(this.f18224d, cacheDisposableArr, cacheDisposableArr2));
    }

    public void onError(Throwable th2) {
        this.f18226f = th2;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f18224d.getAndSet(f18221h)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f18227b.onError(th2);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void onSuccess(T t11) {
        this.f18225e = t11;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f18224d.getAndSet(f18221h)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f18227b.onSuccess(t11);
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
            if (this.f18223c.getAndIncrement() == 0) {
                this.f18222b.subscribe(this);
                return;
            }
            return;
        }
        Throwable th2 = this.f18226f;
        if (th2 != null) {
            singleObserver.onError(th2);
        } else {
            singleObserver.onSuccess(this.f18225e);
        }
    }
}
