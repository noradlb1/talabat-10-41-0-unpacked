package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMap;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeZipArray<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<? extends T>[] f21085b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f21086c;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Throwable {
            R apply = MaybeZipArray.this.f21086c.apply(new Object[]{t11});
            Objects.requireNonNull(apply, "The zipper returned a null value");
            return apply;
        }
    }

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f21088b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f21089c;

        /* renamed from: d  reason: collision with root package name */
        public final ZipMaybeObserver<T>[] f21090d;

        /* renamed from: e  reason: collision with root package name */
        public Object[] f21091e;

        public ZipCoordinator(MaybeObserver<? super R> maybeObserver, int i11, Function<? super Object[], ? extends R> function) {
            super(i11);
            this.f21088b = maybeObserver;
            this.f21089c = function;
            ZipMaybeObserver<T>[] zipMaybeObserverArr = new ZipMaybeObserver[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                zipMaybeObserverArr[i12] = new ZipMaybeObserver<>(this, i12);
            }
            this.f21090d = zipMaybeObserverArr;
            this.f21091e = new Object[i11];
        }

        public void a(int i11) {
            ZipMaybeObserver<T>[] zipMaybeObserverArr = this.f21090d;
            int length = zipMaybeObserverArr.length;
            for (int i12 = 0; i12 < i11; i12++) {
                zipMaybeObserverArr[i12].dispose();
            }
            while (true) {
                i11++;
                if (i11 < length) {
                    zipMaybeObserverArr[i11].dispose();
                } else {
                    return;
                }
            }
        }

        public void b(int i11) {
            if (getAndSet(0) > 0) {
                a(i11);
                this.f21091e = null;
                this.f21088b.onComplete();
            }
        }

        public void c(Throwable th2, int i11) {
            if (getAndSet(0) > 0) {
                a(i11);
                this.f21091e = null;
                this.f21088b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void d(T t11, int i11) {
            Object[] objArr = this.f21091e;
            if (objArr != null) {
                objArr[i11] = t11;
            }
            if (decrementAndGet() == 0) {
                try {
                    Object apply = this.f21089c.apply(objArr);
                    Objects.requireNonNull(apply, "The zipper returned a null value");
                    this.f21091e = null;
                    this.f21088b.onSuccess(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21091e = null;
                    this.f21088b.onError(th2);
                }
            }
        }

        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipMaybeObserver<T> dispose : this.f21090d) {
                    dispose.dispose();
                }
                this.f21091e = null;
            }
        }

        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    public static final class ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;

        /* renamed from: b  reason: collision with root package name */
        public final ZipCoordinator<T, ?> f21092b;

        /* renamed from: c  reason: collision with root package name */
        public final int f21093c;

        public ZipMaybeObserver(ZipCoordinator<T, ?> zipCoordinator, int i11) {
            this.f21092b = zipCoordinator;
            this.f21093c = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f21092b.b(this.f21093c);
        }

        public void onError(Throwable th2) {
            this.f21092b.c(th2, this.f21093c);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f21092b.d(t11, this.f21093c);
        }
    }

    public MaybeZipArray(MaybeSource<? extends T>[] maybeSourceArr, Function<? super Object[], ? extends R> function) {
        this.f21085b = maybeSourceArr;
        this.f21086c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource<? extends T>[] maybeSourceArr = this.f21085b;
        int length = maybeSourceArr.length;
        int i11 = 0;
        if (length == 1) {
            maybeSourceArr[0].subscribe(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, length, this.f21086c);
        maybeObserver.onSubscribe(zipCoordinator);
        while (i11 < length && !zipCoordinator.isDisposed()) {
            MaybeSource<? extends T> maybeSource = maybeSourceArr[i11];
            if (maybeSource == null) {
                zipCoordinator.c(new NullPointerException("One of the sources is null"), i11);
                return;
            } else {
                maybeSource.subscribe(zipCoordinator.f21090d[i11]);
                i11++;
            }
        }
    }
}
