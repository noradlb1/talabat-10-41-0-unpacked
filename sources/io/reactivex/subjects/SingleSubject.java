package io.reactivex.subjects;

import i.b;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final SingleDisposable[] f23651f = new SingleDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public static final SingleDisposable[] f23652g = new SingleDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<SingleDisposable<T>[]> f23653b = new AtomicReference<>(f23651f);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f23654c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public T f23655d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f23656e;

    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f23657b;

        public SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.f23657b = singleObserver;
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

    @CheckReturnValue
    @NonNull
    public static <T> SingleSubject<T> create() {
        return new SingleSubject<>();
    }

    public boolean a(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f23653b.get();
            if (singleDisposableArr == f23652g) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!b.a(this.f23653b, singleDisposableArr, singleDisposableArr2));
        return true;
    }

    public void b(@NonNull SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f23653b.get();
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
                        singleDisposableArr2 = f23651f;
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
        } while (!b.a(this.f23653b, singleDisposableArr, singleDisposableArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f23653b.get() == f23652g) {
            return this.f23656e;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.f23653b.get() == f23652g) {
            return this.f23655d;
        }
        return null;
    }

    public boolean hasObservers() {
        return ((SingleDisposable[]) this.f23653b.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f23653b.get() == f23652g && this.f23656e != null;
    }

    public boolean hasValue() {
        return this.f23653b.get() == f23652g && this.f23655d != null;
    }

    public void onError(@NonNull Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f23654c.compareAndSet(false, true)) {
            this.f23656e = th2;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f23653b.getAndSet(f23652g)) {
                singleDisposable.f23657b.onError(th2);
            }
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onSubscribe(@NonNull Disposable disposable) {
        if (this.f23653b.get() == f23652g) {
            disposable.dispose();
        }
    }

    public void onSuccess(@NonNull T t11) {
        ObjectHelper.requireNonNull(t11, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f23654c.compareAndSet(false, true)) {
            this.f23655d = t11;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f23653b.getAndSet(f23652g)) {
                singleDisposable.f23657b.onSuccess(t11);
            }
        }
    }

    public void subscribeActual(@NonNull SingleObserver<? super T> singleObserver) {
        SingleDisposable singleDisposable = new SingleDisposable(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (!a(singleDisposable)) {
            Throwable th2 = this.f23656e;
            if (th2 != null) {
                singleObserver.onError(th2);
            } else {
                singleObserver.onSuccess(this.f23655d);
            }
        } else if (singleDisposable.isDisposed()) {
            b(singleDisposable);
        }
    }
}
