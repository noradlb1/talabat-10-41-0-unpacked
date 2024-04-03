package io.reactivex.internal.operators.maybe;

import i.b;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final CacheDisposable[] f16269f = new CacheDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public static final CacheDisposable[] f16270g = new CacheDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<MaybeSource<T>> f16271b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f16272c = new AtomicReference<>(f16269f);

    /* renamed from: d  reason: collision with root package name */
    public T f16273d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f16274e;

    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16275b;

        public CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.f16275b = maybeObserver;
        }

        public void dispose() {
            MaybeCache maybeCache = (MaybeCache) getAndSet((Object) null);
            if (maybeCache != null) {
                maybeCache.b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public MaybeCache(MaybeSource<T> maybeSource) {
        this.f16271b = new AtomicReference<>(maybeSource);
    }

    public boolean a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f16272c.get();
            if (cacheDisposableArr == f16270g) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!b.a(this.f16272c, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f16272c.get();
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
                        cacheDisposableArr2 = f16269f;
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
        } while (!b.a(this.f16272c, cacheDisposableArr, cacheDisposableArr2));
    }

    public void onComplete() {
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f16272c.getAndSet(f16270g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f16275b.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        this.f16274e = th2;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f16272c.getAndSet(f16270g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f16275b.onError(th2);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void onSuccess(T t11) {
        this.f16273d = t11;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f16272c.getAndSet(f16270g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f16275b.onSuccess(t11);
            }
        }
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(maybeObserver, this);
        maybeObserver.onSubscribe(cacheDisposable);
        if (a(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                b(cacheDisposable);
                return;
            }
            MaybeSource andSet = this.f16271b.getAndSet((Object) null);
            if (andSet != null) {
                andSet.subscribe(this);
            }
        } else if (!cacheDisposable.isDisposed()) {
            Throwable th2 = this.f16274e;
            if (th2 != null) {
                maybeObserver.onError(th2);
                return;
            }
            T t11 = this.f16273d;
            if (t11 != null) {
                maybeObserver.onSuccess(t11);
            } else {
                maybeObserver.onComplete();
            }
        }
    }
}
