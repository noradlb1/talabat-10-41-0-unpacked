package io.reactivex.internal.operators.completable;

import i.b;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCache extends Completable implements CompletableObserver {

    /* renamed from: f  reason: collision with root package name */
    public static final InnerCompletableCache[] f14595f = new InnerCompletableCache[0];

    /* renamed from: g  reason: collision with root package name */
    public static final InnerCompletableCache[] f14596g = new InnerCompletableCache[0];

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14597b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<InnerCompletableCache[]> f14598c = new AtomicReference<>(f14595f);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f14599d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    public Throwable f14600e;

    public final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14601b;

        public InnerCompletableCache(CompletableObserver completableObserver) {
            this.f14601b = completableObserver;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.b(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }

    public CompletableCache(CompletableSource completableSource) {
        this.f14597b = completableSource;
    }

    public boolean a(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.f14598c.get();
            if (innerCompletableCacheArr == f14596g) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[(length + 1)];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!b.a(this.f14598c, innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    public void b(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.f14598c.get();
            int length = innerCompletableCacheArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (innerCompletableCacheArr[i11] == innerCompletableCache) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        innerCompletableCacheArr2 = f14595f;
                    } else {
                        InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[(length - 1)];
                        System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i11);
                        System.arraycopy(innerCompletableCacheArr, i11 + 1, innerCompletableCacheArr3, i11, (length - i11) - 1);
                        innerCompletableCacheArr2 = innerCompletableCacheArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f14598c, innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    public void onComplete() {
        for (InnerCompletableCache innerCompletableCache : this.f14598c.getAndSet(f14596g)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.f14601b.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        this.f14600e = th2;
        for (InnerCompletableCache innerCompletableCache : this.f14598c.getAndSet(f14596g)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.f14601b.onError(th2);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(completableObserver);
        completableObserver.onSubscribe(innerCompletableCache);
        if (a(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                b(innerCompletableCache);
            }
            if (this.f14599d.compareAndSet(false, true)) {
                this.f14597b.subscribe(this);
                return;
            }
            return;
        }
        Throwable th2 = this.f14600e;
        if (th2 != null) {
            completableObserver.onError(th2);
        } else {
            completableObserver.onComplete();
        }
    }
}
