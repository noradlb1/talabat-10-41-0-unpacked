package io.reactivex.rxjava3.subjects;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject extends Completable implements CompletableObserver {

    /* renamed from: e  reason: collision with root package name */
    public static final CompletableDisposable[] f23405e = new CompletableDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    public static final CompletableDisposable[] f23406f = new CompletableDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<CompletableDisposable[]> f23407b = new AtomicReference<>(f23405e);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f23408c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public Throwable f23409d;

    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f23410b;

        public CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.f23410b = completableObserver;
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

    @NonNull
    @CheckReturnValue
    public static CompletableSubject create() {
        return new CompletableSubject();
    }

    public boolean a(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f23407b.get();
            if (completableDisposableArr == f23406f) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!b.a(this.f23407b, completableDisposableArr, completableDisposableArr2));
        return true;
    }

    public void b(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f23407b.get();
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
                        completableDisposableArr2 = f23405e;
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
        } while (!b.a(this.f23407b, completableDisposableArr, completableDisposableArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f23407b.get() == f23406f) {
            return this.f23409d;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f23407b.get() == f23406f && this.f23409d == null;
    }

    public boolean hasObservers() {
        return this.f23407b.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.f23407b.get() == f23406f && this.f23409d != null;
    }

    public void onComplete() {
        if (this.f23408c.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f23407b.getAndSet(f23406f)) {
                completableDisposable.f23410b.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        if (this.f23408c.compareAndSet(false, true)) {
            this.f23409d = th2;
            for (CompletableDisposable completableDisposable : this.f23407b.getAndSet(f23406f)) {
                completableDisposable.f23410b.onError(th2);
            }
            return;
        }
        RxJavaPlugins.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23407b.get() == f23406f) {
            disposable.dispose();
        }
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (!a(completableDisposable)) {
            Throwable th2 = this.f23409d;
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
