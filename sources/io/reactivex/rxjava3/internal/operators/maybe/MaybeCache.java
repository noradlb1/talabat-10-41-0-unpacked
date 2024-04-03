package io.reactivex.rxjava3.internal.operators.maybe;

import i.b;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final CacheDisposable[] f20768f = new CacheDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public static final CacheDisposable[] f20769g = new CacheDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<MaybeSource<T>> f20770b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f20771c = new AtomicReference<>(f20768f);

    /* renamed from: d  reason: collision with root package name */
    public T f20772d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f20773e;

    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20774b;

        public CacheDisposable(MaybeObserver<? super T> maybeObserver, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.f20774b = maybeObserver;
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
        this.f20770b = new AtomicReference<>(maybeSource);
    }

    public boolean a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f20771c.get();
            if (cacheDisposableArr == f20769g) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!b.a(this.f20771c, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f20771c.get();
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
                        cacheDisposableArr2 = f20768f;
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
        } while (!b.a(this.f20771c, cacheDisposableArr, cacheDisposableArr2));
    }

    public void onComplete() {
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f20771c.getAndSet(f20769g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f20774b.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        this.f20773e = th2;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f20771c.getAndSet(f20769g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f20774b.onError(th2);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void onSuccess(T t11) {
        this.f20772d = t11;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f20771c.getAndSet(f20769g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f20774b.onSuccess(t11);
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
            MaybeSource andSet = this.f20770b.getAndSet((Object) null);
            if (andSet != null) {
                andSet.subscribe(this);
            }
        } else if (!cacheDisposable.isDisposed()) {
            Throwable th2 = this.f20773e;
            if (th2 != null) {
                maybeObserver.onError(th2);
                return;
            }
            T t11 = this.f20772d;
            if (t11 != null) {
                maybeObserver.onSuccess(t11);
            } else {
                maybeObserver.onComplete();
            }
        }
    }
}
