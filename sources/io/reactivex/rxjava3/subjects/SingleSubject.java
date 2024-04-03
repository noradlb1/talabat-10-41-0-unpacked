package io.reactivex.rxjava3.subjects;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final SingleDisposable[] f23456f = new SingleDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public static final SingleDisposable[] f23457g = new SingleDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<SingleDisposable<T>[]> f23458b = new AtomicReference<>(f23456f);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f23459c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public T f23460d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f23461e;

    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f23462b;

        public SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.f23462b = singleObserver;
            lazySet(singleSubject);
        }

        public void dispose() {
            SingleSubject singleSubject = (SingleSubject) getAndSet((Object) null);
            if (singleSubject != null) {
                singleSubject.b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> SingleSubject<T> create() {
        return new SingleSubject<>();
    }

    public boolean a(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f23458b.get();
            if (singleDisposableArr == f23457g) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!b.a(this.f23458b, singleDisposableArr, singleDisposableArr2));
        return true;
    }

    public void b(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f23458b.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (singleDisposableArr[i11] == singleDisposable) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        singleDisposableArr2 = f23456f;
                    } else {
                        SingleDisposable[] singleDisposableArr3 = new SingleDisposable[(length - 1)];
                        System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i11);
                        System.arraycopy(singleDisposableArr, i11 + 1, singleDisposableArr3, i11, (length - i11) - 1);
                        singleDisposableArr2 = singleDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23458b, singleDisposableArr, singleDisposableArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f23458b.get() == f23457g) {
            return this.f23461e;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.f23458b.get() == f23457g) {
            return this.f23460d;
        }
        return null;
    }

    public boolean hasObservers() {
        return ((SingleDisposable[]) this.f23458b.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f23458b.get() == f23457g && this.f23461e != null;
    }

    public boolean hasValue() {
        return this.f23458b.get() == f23457g && this.f23460d != null;
    }

    public void onError(@NonNull Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        if (this.f23459c.compareAndSet(false, true)) {
            this.f23461e = th2;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f23458b.getAndSet(f23457g)) {
                singleDisposable.f23462b.onError(th2);
            }
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        if (this.f23458b.get() == f23457g) {
            disposable.dispose();
        }
    }

    public void onSuccess(@NonNull T t11) {
        ExceptionHelper.nullCheck(t11, "onSuccess called with a null value.");
        if (this.f23459c.compareAndSet(false, true)) {
            this.f23460d = t11;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f23458b.getAndSet(f23457g)) {
                singleDisposable.f23462b.onSuccess(t11);
            }
        }
    }

    public void subscribeActual(@NonNull SingleObserver<? super T> singleObserver) {
        SingleDisposable singleDisposable = new SingleDisposable(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (!a(singleDisposable)) {
            Throwable th2 = this.f23461e;
            if (th2 != null) {
                singleObserver.onError(th2);
            } else {
                singleObserver.onSuccess(this.f23460d);
            }
        } else if (singleDisposable.isDisposed()) {
            b(singleDisposable);
        }
    }
}
