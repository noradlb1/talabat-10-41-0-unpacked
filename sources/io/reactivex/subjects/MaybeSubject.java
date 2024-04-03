package io.reactivex.subjects;

import i.b;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final MaybeDisposable[] f23606f = new MaybeDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public static final MaybeDisposable[] f23607g = new MaybeDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<MaybeDisposable<T>[]> f23608b = new AtomicReference<>(f23606f);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f23609c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public T f23610d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f23611e;

    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f23612b;

        public MaybeDisposable(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
            this.f23612b = maybeObserver;
            lazySet(maybeSubject);
        }

        public void dispose() {
            MaybeSubject maybeSubject = (MaybeSubject) getAndSet((Object) null);
            if (maybeSubject != null) {
                maybeSubject.b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> MaybeSubject<T> create() {
        return new MaybeSubject<>();
    }

    public boolean a(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f23608b.get();
            if (maybeDisposableArr == f23607g) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[(length + 1)];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!b.a(this.f23608b, maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    public void b(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f23608b.get();
            int length = maybeDisposableArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (maybeDisposableArr[i11] == maybeDisposable) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        maybeDisposableArr2 = f23606f;
                    } else {
                        MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[(length - 1)];
                        System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i11);
                        System.arraycopy(maybeDisposableArr, i11 + 1, maybeDisposableArr3, i11, (length - i11) - 1);
                        maybeDisposableArr2 = maybeDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23608b, maybeDisposableArr, maybeDisposableArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f23608b.get() == f23607g) {
            return this.f23611e;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.f23608b.get() == f23607g) {
            return this.f23610d;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f23608b.get() == f23607g && this.f23610d == null && this.f23611e == null;
    }

    public boolean hasObservers() {
        return ((MaybeDisposable[]) this.f23608b.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f23608b.get() == f23607g && this.f23611e != null;
    }

    public boolean hasValue() {
        return this.f23608b.get() == f23607g && this.f23610d != null;
    }

    public void onComplete() {
        if (this.f23609c.compareAndSet(false, true)) {
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f23608b.getAndSet(f23607g)) {
                maybeDisposable.f23612b.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f23609c.compareAndSet(false, true)) {
            this.f23611e = th2;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f23608b.getAndSet(f23607g)) {
                maybeDisposable.f23612b.onError(th2);
            }
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23608b.get() == f23607g) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t11) {
        ObjectHelper.requireNonNull(t11, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f23609c.compareAndSet(false, true)) {
            this.f23610d = t11;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f23608b.getAndSet(f23607g)) {
                maybeDisposable.f23612b.onSuccess(t11);
            }
        }
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeDisposable maybeDisposable = new MaybeDisposable(maybeObserver, this);
        maybeObserver.onSubscribe(maybeDisposable);
        if (!a(maybeDisposable)) {
            Throwable th2 = this.f23611e;
            if (th2 != null) {
                maybeObserver.onError(th2);
                return;
            }
            T t11 = this.f23610d;
            if (t11 == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(t11);
            }
        } else if (maybeDisposable.isDisposed()) {
            b(maybeDisposable);
        }
    }
}
