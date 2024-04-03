package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.plugins.RxJavaPlugins;

public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    private static final long serialVersionUID = -5502432239815349361L;

    /* renamed from: b  reason: collision with root package name */
    public final Observer<? super T> f14549b;

    /* renamed from: c  reason: collision with root package name */
    public T f14550c;

    public DeferredScalarDisposable(Observer<? super T> observer) {
        this.f14549b = observer;
    }

    public final void clear() {
        lazySet(32);
        this.f14550c = null;
    }

    public final void complete(T t11) {
        int i11 = get();
        if ((i11 & 54) == 0) {
            Observer<? super T> observer = this.f14549b;
            if (i11 == 8) {
                this.f14550c = t11;
                lazySet(16);
                observer.onNext(null);
            } else {
                lazySet(2);
                observer.onNext(t11);
            }
            if (get() != 4) {
                observer.onComplete();
            }
        }
    }

    public void dispose() {
        set(4);
        this.f14550c = null;
    }

    public final void error(Throwable th2) {
        if ((get() & 54) != 0) {
            RxJavaPlugins.onError(th2);
            return;
        }
        lazySet(2);
        this.f14549b.onError(th2);
    }

    public final boolean isDisposed() {
        return get() == 4;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    @Nullable
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t11 = this.f14550c;
        this.f14550c = null;
        lazySet(32);
        return t11;
    }

    public final int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    public final void complete() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.f14549b.onComplete();
        }
    }
}
