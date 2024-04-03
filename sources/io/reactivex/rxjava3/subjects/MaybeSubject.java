package io.reactivex.rxjava3.subjects;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final MaybeDisposable[] f23411f = new MaybeDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public static final MaybeDisposable[] f23412g = new MaybeDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<MaybeDisposable<T>[]> f23413b = new AtomicReference<>(f23411f);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f23414c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public T f23415d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f23416e;

    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f23417b;

        public MaybeDisposable(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
            this.f23417b = maybeObserver;
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

    @NonNull
    @CheckReturnValue
    public static <T> MaybeSubject<T> create() {
        return new MaybeSubject<>();
    }

    public boolean a(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f23413b.get();
            if (maybeDisposableArr == f23412g) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[(length + 1)];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!b.a(this.f23413b, maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    public void b(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f23413b.get();
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
                        maybeDisposableArr2 = f23411f;
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
        } while (!b.a(this.f23413b, maybeDisposableArr, maybeDisposableArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f23413b.get() == f23412g) {
            return this.f23416e;
        }
        return null;
    }

    @Nullable
    public T getValue() {
        if (this.f23413b.get() == f23412g) {
            return this.f23415d;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f23413b.get() == f23412g && this.f23415d == null && this.f23416e == null;
    }

    public boolean hasObservers() {
        return ((MaybeDisposable[]) this.f23413b.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f23413b.get() == f23412g && this.f23416e != null;
    }

    public boolean hasValue() {
        return this.f23413b.get() == f23412g && this.f23415d != null;
    }

    public void onComplete() {
        if (this.f23414c.compareAndSet(false, true)) {
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f23413b.getAndSet(f23412g)) {
                maybeDisposable.f23417b.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        if (this.f23414c.compareAndSet(false, true)) {
            this.f23416e = th2;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f23413b.getAndSet(f23412g)) {
                maybeDisposable.f23417b.onError(th2);
            }
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23413b.get() == f23412g) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t11) {
        ExceptionHelper.nullCheck(t11, "onSuccess called with a null value.");
        if (this.f23414c.compareAndSet(false, true)) {
            this.f23415d = t11;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f23413b.getAndSet(f23412g)) {
                maybeDisposable.f23417b.onSuccess(t11);
            }
        }
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeDisposable maybeDisposable = new MaybeDisposable(maybeObserver, this);
        maybeObserver.onSubscribe(maybeDisposable);
        if (!a(maybeDisposable)) {
            Throwable th2 = this.f23416e;
            if (th2 != null) {
                maybeObserver.onError(th2);
                return;
            }
            T t11 = this.f23415d;
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
