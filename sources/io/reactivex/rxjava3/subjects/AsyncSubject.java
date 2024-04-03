package io.reactivex.rxjava3.subjects;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncSubject<T> extends Subject<T> {

    /* renamed from: e  reason: collision with root package name */
    public static final AsyncDisposable[] f23382e = new AsyncDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    public static final AsyncDisposable[] f23383f = new AsyncDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<AsyncDisposable<T>[]> f23384b = new AtomicReference<>(f23382e);

    /* renamed from: c  reason: collision with root package name */
    public Throwable f23385c;

    /* renamed from: d  reason: collision with root package name */
    public T f23386d;

    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;

        /* renamed from: d  reason: collision with root package name */
        public final AsyncSubject<T> f23387d;

        public AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.f23387d = asyncSubject;
        }

        public void dispose() {
            if (super.tryDispose()) {
                this.f23387d.b(this);
            }
        }

        public void onComplete() {
            if (!isDisposed()) {
                this.f19028b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (isDisposed()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f19028b.onError(th2);
            }
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject<>();
    }

    public boolean a(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.f23384b.get();
            if (asyncDisposableArr == f23383f) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[(length + 1)];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!b.a(this.f23384b, asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    public void b(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.f23384b.get();
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
                        asyncDisposableArr2 = f23382e;
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
        } while (!b.a(this.f23384b, asyncDisposableArr, asyncDisposableArr2));
    }

    @CheckReturnValue
    public Throwable getThrowable() {
        if (this.f23384b.get() == f23383f) {
            return this.f23385c;
        }
        return null;
    }

    @CheckReturnValue
    @Nullable
    public T getValue() {
        if (this.f23384b.get() == f23383f) {
            return this.f23386d;
        }
        return null;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return this.f23384b.get() == f23383f && this.f23385c == null;
    }

    @CheckReturnValue
    public boolean hasObservers() {
        return ((AsyncDisposable[]) this.f23384b.get()).length != 0;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return this.f23384b.get() == f23383f && this.f23385c != null;
    }

    @CheckReturnValue
    public boolean hasValue() {
        return this.f23384b.get() == f23383f && this.f23386d != null;
    }

    public void onComplete() {
        AsyncDisposable<T>[] asyncDisposableArr = this.f23384b.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = f23383f;
        if (asyncDisposableArr != asyncDisposableArr2) {
            T t11 = this.f23386d;
            AsyncDisposable[] asyncDisposableArr3 = (AsyncDisposable[]) this.f23384b.getAndSet(asyncDisposableArr2);
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
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        AsyncDisposable<T>[] asyncDisposableArr = this.f23384b.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = f23383f;
        if (asyncDisposableArr == asyncDisposableArr2) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23386d = null;
        this.f23385c = th2;
        for (AsyncDisposable onError : (AsyncDisposable[]) this.f23384b.getAndSet(asyncDisposableArr2)) {
            onError.onError(th2);
        }
    }

    public void onNext(T t11) {
        ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
        if (this.f23384b.get() != f23383f) {
            this.f23386d = t11;
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23384b.get() == f23383f) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        AsyncDisposable asyncDisposable = new AsyncDisposable(observer, this);
        observer.onSubscribe(asyncDisposable);
        if (!a(asyncDisposable)) {
            Throwable th2 = this.f23385c;
            if (th2 != null) {
                observer.onError(th2);
                return;
            }
            T t11 = this.f23386d;
            if (t11 != null) {
                asyncDisposable.complete(t11);
            } else {
                asyncDisposable.onComplete();
            }
        } else if (asyncDisposable.isDisposed()) {
            b(asyncDisposable);
        }
    }
}
