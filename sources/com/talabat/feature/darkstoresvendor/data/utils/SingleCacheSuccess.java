package com.talabat.feature.darkstoresvendor.data.utils;

import i.b;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCacheSuccess<T> extends Single<T> implements SingleObserver<T> {
    private static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    private static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    private final AtomicReference<CacheDisposable<T>[]> observers;
    private final Single<T> source;
    private T value;
    private final AtomicBoolean wip = new AtomicBoolean();

    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 4746876330948546833L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f58510b;
        private final SingleCacheSuccess<T> parent;

        public CacheDisposable(SingleObserver<? super T> singleObserver, SingleCacheSuccess<T> singleCacheSuccess) {
            this.f58510b = singleObserver;
            this.parent = singleCacheSuccess;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }
    }

    private SingleCacheSuccess(Single<T> single) {
        this.source = single;
        this.observers = new AtomicReference<>(EMPTY);
    }

    private boolean add(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.observers.get();
            if (cacheDisposableArr == TERMINATED) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!b.a(this.observers, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public static <T> Single<T> create(Single<T> single) {
        return RxJavaPlugins.onAssembly(new SingleCacheSuccess(single));
    }

    /* access modifiers changed from: private */
    public void remove(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.observers.get();
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
                        cacheDisposableArr2 = EMPTY;
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
        } while (!b.a(this.observers, cacheDisposableArr, cacheDisposableArr2));
    }

    public void onError(Throwable th2) {
        this.wip.set(false);
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(EMPTY)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f58510b.onError(th2);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void onSuccess(T t11) {
        this.value = t11;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.f58510b.onSuccess(t11);
            }
        }
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        if (add(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                remove(cacheDisposable);
            }
            if (!this.wip.getAndSet(true)) {
                this.source.subscribe(this);
                return;
            }
            return;
        }
        singleObserver.onSuccess(this.value);
    }
}
