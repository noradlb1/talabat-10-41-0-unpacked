package io.reactivex.subjects;

import i.b;
import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T> extends Subject<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final PublishDisposable[] f23613d = new PublishDisposable[0];

    /* renamed from: e  reason: collision with root package name */
    public static final PublishDisposable[] f23614e = new PublishDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<PublishDisposable<T>[]> f23615b = new AtomicReference<>(f23614e);

    /* renamed from: c  reason: collision with root package name */
    public Throwable f23616c;

    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f23617b;

        /* renamed from: c  reason: collision with root package name */
        public final PublishSubject<T> f23618c;

        public PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.f23617b = observer;
            this.f23618c = publishSubject;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f23618c.b(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.f23617b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f23617b.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!get()) {
                this.f23617b.onNext(t11);
            }
        }
    }

    @CheckReturnValue
    @NonNull
    public static <T> PublishSubject<T> create() {
        return new PublishSubject<>();
    }

    public boolean a(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f23615b.get();
            if (publishDisposableArr == f23613d) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!b.a(this.f23615b, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    public void b(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f23615b.get();
            if (publishDisposableArr != f23613d && publishDisposableArr != f23614e) {
                int length = publishDisposableArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        i11 = -1;
                        break;
                    } else if (publishDisposableArr[i11] == publishDisposable) {
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = f23614e;
                    } else {
                        PublishDisposable[] publishDisposableArr3 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i11);
                        System.arraycopy(publishDisposableArr, i11 + 1, publishDisposableArr3, i11, (length - i11) - 1);
                        publishDisposableArr2 = publishDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!b.a(this.f23615b, publishDisposableArr, publishDisposableArr2));
    }

    @Nullable
    public Throwable getThrowable() {
        if (this.f23615b.get() == f23613d) {
            return this.f23616c;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.f23615b.get() == f23613d && this.f23616c == null;
    }

    public boolean hasObservers() {
        return ((PublishDisposable[]) this.f23615b.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.f23615b.get() == f23613d && this.f23616c != null;
    }

    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f23615b.get();
        PublishDisposable<T>[] publishDisposableArr2 = f23613d;
        if (publishDisposableArr != publishDisposableArr2) {
            for (PublishDisposable onComplete : (PublishDisposable[]) this.f23615b.getAndSet(publishDisposableArr2)) {
                onComplete.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        ObjectHelper.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f23615b.get();
        PublishDisposable<T>[] publishDisposableArr2 = f23613d;
        if (publishDisposableArr == publishDisposableArr2) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23616c = th2;
        for (PublishDisposable onError : (PublishDisposable[]) this.f23615b.getAndSet(publishDisposableArr2)) {
            onError.onError(th2);
        }
    }

    public void onNext(T t11) {
        ObjectHelper.requireNonNull(t11, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable onNext : (PublishDisposable[]) this.f23615b.get()) {
            onNext.onNext(t11);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23615b.get() == f23613d) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.onSubscribe(publishDisposable);
        if (!a(publishDisposable)) {
            Throwable th2 = this.f23616c;
            if (th2 != null) {
                observer.onError(th2);
            } else {
                observer.onComplete();
            }
        } else if (publishDisposable.isDisposed()) {
            b(publishDisposable);
        }
    }
}
