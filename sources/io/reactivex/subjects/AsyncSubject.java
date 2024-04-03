package io.reactivex.subjects;

import i.b;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncSubject<T> extends Subject<T> {

    /* renamed from: e  reason: collision with root package name */
    public static final AsyncDisposable[] f23577e = new AsyncDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    public static final AsyncDisposable[] f23578f = new AsyncDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<AsyncDisposable<T>[]> f23579b = new AtomicReference<>(f23577e);

    /* renamed from: c  reason: collision with root package name */
    public Throwable f23580c;

    /* renamed from: d  reason: collision with root package name */
    public T f23581d;

    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;

        /* renamed from: d  reason: collision with root package name */
        public final AsyncSubject<T> f23582d;

        public AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.f23582d = asyncSubject;
        }

        public void dispose() {
            if (super.tryDispose()) {
                this.f23582d.b(this);
            }
        }

        public void onComplete() {
            if (!isDisposed()) {
                this.f14549b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (isDisposed()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f14549b.onError(th2);
            }
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject<>();
    }

    public boolean a(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.f23579b.get();
            if (asyncDisposableArr == f23578f) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[(length + 1)];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!b.a(this.f23579b, asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    public void b(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.f23579b.get();
            int length = asyncDisposableArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (asyncDisposableArr[i11] == asyncDisposable) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        asyncDisposableArr2 = f23577e;
                    } else {
                        AsyncDisposable[] asyncDisposableArr3 = new AsyncDisposable[(length - 1)];
                        System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i11);
                        System.arraycopy(asyncDisposableArr, i11 + 1, asyncDisposableArr3, i11, (length - i11) - 1);
                        asyncDisposableArr2 = asyncDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23579b, asyncDisposableArr, asyncDisposableArr2));
    }

    public Throwable getThrowable() {
        if (this.f23579b.get() == f23578f) {
            return this.f23580c;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.f23579b.get() == f23578f) {
            return this.f23581d;
        }
        return null;
    }

    @Deprecated
    public Object[] getValues() {
        Object value = getValue();
        if (value == null) {
            return new Object[0];
        }
        return new Object[]{value};
    }

    public boolean hasComplete() {
        return this.f23579b.get() == f23578f && this.f23580c == null;
    }

    public boolean hasObservers() {
        return ((AsyncDisposable[]) this.f23579b.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f23579b.get() == f23578f && this.f23580c != null;
    }

    public boolean hasValue() {
        return this.f23579b.get() == f23578f && this.f23581d != null;
    }

    public void onComplete() {
        AsyncDisposable<T>[] asyncDisposableArr = this.f23579b.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = f23578f;
        if (asyncDisposableArr != asyncDisposableArr2) {
            T t11 = this.f23581d;
            AsyncDisposable[] asyncDisposableArr3 = (AsyncDisposable[]) this.f23579b.getAndSet(asyncDisposableArr2);
            int i11 = 0;
            if (t11 == null) {
                int length = asyncDisposableArr3.length;
                while (i11 < length) {
                    asyncDisposableArr3[i11].onComplete();
                    i11++;
                }
                return;
            }
            int length2 = asyncDisposableArr3.length;
            while (i11 < length2) {
                asyncDisposableArr3[i11].complete(t11);
                i11++;
            }
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] asyncDisposableArr = this.f23579b.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = f23578f;
        if (asyncDisposableArr == asyncDisposableArr2) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23581d = null;
        this.f23580c = th2;
        for (AsyncDisposable onError : (AsyncDisposable[]) this.f23579b.getAndSet(asyncDisposableArr2)) {
            onError.onError(th2);
        }
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f23579b.get() != f23578f) {
            this.f23581d = t11;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23579b.get() == f23578f) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        AsyncDisposable asyncDisposable = new AsyncDisposable(observer, this);
        observer.onSubscribe(asyncDisposable);
        if (!a(asyncDisposable)) {
            Throwable th2 = this.f23580c;
            if (th2 != null) {
                observer.onError(th2);
                return;
            }
            T t11 = this.f23581d;
            if (t11 != null) {
                asyncDisposable.complete(t11);
            } else {
                asyncDisposable.onComplete();
            }
        } else if (asyncDisposable.isDisposed()) {
            b(asyncDisposable);
        }
    }

    @Deprecated
    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }
}
