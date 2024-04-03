package io.reactivex.rxjava3.subjects;

import i.b;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishSubject<T> extends Subject<T> {

    /* renamed from: d  reason: collision with root package name */
    public static final PublishDisposable[] f23418d = new PublishDisposable[0];

    /* renamed from: e  reason: collision with root package name */
    public static final PublishDisposable[] f23419e = new PublishDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<PublishDisposable<T>[]> f23420b = new AtomicReference<>(f23419e);

    /* renamed from: c  reason: collision with root package name */
    public Throwable f23421c;

    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 3562861878281475070L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f23422b;

        /* renamed from: c  reason: collision with root package name */
        public final PublishSubject<T> f23423c;

        public PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.f23422b = observer;
            this.f23423c = publishSubject;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f23423c.b(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.f23422b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f23422b.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!get()) {
                this.f23422b.onNext(t11);
            }
        }
    }

    @NonNull
    @CheckReturnValue
    public static <T> PublishSubject<T> create() {
        return new PublishSubject<>();
    }

    public boolean a(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f23420b.get();
            if (publishDisposableArr == f23418d) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!b.a(this.f23420b, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    public void b(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f23420b.get();
            if (publishDisposableArr != f23418d && publishDisposableArr != f23419e) {
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
                        publishDisposableArr2 = f23419e;
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
        } while (!b.a(this.f23420b, publishDisposableArr, publishDisposableArr2));
    }

    @CheckReturnValue
    @Nullable
    public Throwable getThrowable() {
        if (this.f23420b.get() == f23418d) {
            return this.f23421c;
        }
        return null;
    }

    @CheckReturnValue
    public boolean hasComplete() {
        return this.f23420b.get() == f23418d && this.f23421c == null;
    }

    @CheckReturnValue
    public boolean hasObservers() {
        return ((PublishDisposable[]) this.f23420b.get()).length != 0;
    }

    @CheckReturnValue
    public boolean hasThrowable() {
        return this.f23420b.get() == f23418d && this.f23421c != null;
    }

    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f23420b.get();
        PublishDisposable<T>[] publishDisposableArr2 = f23418d;
        if (publishDisposableArr != publishDisposableArr2) {
            for (PublishDisposable onComplete : (PublishDisposable[]) this.f23420b.getAndSet(publishDisposableArr2)) {
                onComplete.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.nullCheck(th2, "onError called with a null Throwable.");
        PublishDisposable<T>[] publishDisposableArr = this.f23420b.get();
        PublishDisposable<T>[] publishDisposableArr2 = f23418d;
        if (publishDisposableArr == publishDisposableArr2) {
            RxJavaPlugins.onError(th2);
            return;
        }
        this.f23421c = th2;
        for (PublishDisposable onError : (PublishDisposable[]) this.f23420b.getAndSet(publishDisposableArr2)) {
            onError.onError(th2);
        }
    }

    public void onNext(T t11) {
        ExceptionHelper.nullCheck(t11, "onNext called with a null value.");
        for (PublishDisposable onNext : (PublishDisposable[]) this.f23420b.get()) {
            onNext.onNext(t11);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f23420b.get() == f23418d) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.onSubscribe(publishDisposable);
        if (!a(publishDisposable)) {
            Throwable th2 = this.f23421c;
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
