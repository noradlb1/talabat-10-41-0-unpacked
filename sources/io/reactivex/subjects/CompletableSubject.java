package io.reactivex.subjects;

import i.b;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject extends Completable implements CompletableObserver {

    /* renamed from: e  reason: collision with root package name */
    public static final CompletableDisposable[] f23600e = new CompletableDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    public static final CompletableDisposable[] f23601f = new CompletableDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<CompletableDisposable[]> f23602b = new AtomicReference<>(f23600e);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f23603c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public Throwable f23604d;

    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f23605b;

        public CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.f23605b = completableObserver;
            lazySet(completableSubject);
        }

        public void dispose() {
            CompletableSubject completableSubject = (CompletableSubject) getAndSet((Object) null);
            if (completableSubject != null) {
                completableSubject.b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    @CheckReturnValue
    @NonNull
    public static CompletableSubject create() {
        return new CompletableSubject();
    }

    public boolean a(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f23602b.get();
            if (completableDisposableArr == f23601f) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!b.a(this.f23602b, completableDisposableArr, completableDisposableArr2));
        return true;
    }

    public void b(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f23602b.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (completableDisposableArr[i11] == completableDisposable) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        completableDisposableArr2 = f23600e;
                    } else {
                        CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[(length - 1)];
                        System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i11);
                        System.arraycopy(completableDisposableArr, i11 + 1, completableDisposableArr3, i11, (length - i11) - 1);
                        completableDisposableArr2 = completableDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23602b, completableDisposableArr, completableDisposableArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f23602b.get() == f23601f) {
            return this.f23604d;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f23602b.get() == f23601f && this.f23604d == null;
    }

    public boolean hasObservers() {
        return this.f23602b.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.f23602b.get() == f23601f && this.f23604d != null;
    }

    public void onComplete() {
        if (this.f23603c.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f23602b.getAndSet(f23601f)) {
                completableDisposable.f23605b.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f23603c.compareAndSet(false, true)) {
            this.f23604d = th2;
            for (CompletableDisposable completableDisposable : this.f23602b.getAndSet(f23601f)) {
                completableDisposable.f23605b.onError(th2);
            }
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23602b.get() == f23601f) {
            disposable.dispose();
        }
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (!a(completableDisposable)) {
            Throwable th2 = this.f23604d;
            if (th2 != null) {
                completableObserver.onError(th2);
            } else {
                completableObserver.onComplete();
            }
        } else if (completableDisposable.isDisposed()) {
            b(completableDisposable);
        }
    }
}
