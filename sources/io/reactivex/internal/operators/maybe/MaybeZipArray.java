package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeZipArray<T, R> extends Maybe<R> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<? extends T>[] f16572b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f16573c;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Exception {
            return ObjectHelper.requireNonNull(MaybeZipArray.this.f16573c.apply(new Object[]{t11}), "The zipper returned a null value");
        }
    }

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super R> f16575b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f16576c;

        /* renamed from: d  reason: collision with root package name */
        public final ZipMaybeObserver<T>[] f16577d;

        /* renamed from: e  reason: collision with root package name */
        public final Object[] f16578e;

        public ZipCoordinator(MaybeObserver<? super R> maybeObserver, int i11, Function<? super Object[], ? extends R> function) {
            super(i11);
            this.f16575b = maybeObserver;
            this.f16576c = function;
            ZipMaybeObserver<T>[] zipMaybeObserverArr = new ZipMaybeObserver[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                zipMaybeObserverArr[i12] = new ZipMaybeObserver<>(this, i12);
            }
            this.f16577d = zipMaybeObserverArr;
            this.f16578e = new Object[i11];
        }

        public void a(int i11) {
            ZipMaybeObserver<T>[] zipMaybeObserverArr = this.f16577d;
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
                this.f16575b.onComplete();
            }
        }

        public void c(Throwable th2, int i11) {
            if (getAndSet(0) > 0) {
                a(i11);
                this.f16575b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void d(T t11, int i11) {
            this.f16578e[i11] = t11;
            if (decrementAndGet() == 0) {
                try {
                    this.f16575b.onSuccess(ObjectHelper.requireNonNull(this.f16576c.apply(this.f16578e), "The zipper returned a null value"));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f16575b.onError(th2);
                }
            }
        }

        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipMaybeObserver<T> dispose : this.f16577d) {
                    dispose.dispose();
                }
            }
        }

        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    public static final class ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;

        /* renamed from: b  reason: collision with root package name */
        public final ZipCoordinator<T, ?> f16579b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16580c;

        public ZipMaybeObserver(ZipCoordinator<T, ?> zipCoordinator, int i11) {
            this.f16579b = zipCoordinator;
            this.f16580c = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.f16579b.b(this.f16580c);
        }

        public void onError(Throwable th2) {
            this.f16579b.c(th2, this.f16580c);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f16579b.d(t11, this.f16580c);
        }
    }

    public MaybeZipArray(MaybeSource<? extends T>[] maybeSourceArr, Function<? super Object[], ? extends R> function) {
        this.f16572b = maybeSourceArr;
        this.f16573c = function;
    }

    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource<? extends T>[] maybeSourceArr = this.f16572b;
        int length = maybeSourceArr.length;
        int i11 = 0;
        if (length == 1) {
            maybeSourceArr[0].subscribe(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, length, this.f16573c);
        maybeObserver.onSubscribe(zipCoordinator);
        while (i11 < length && !zipCoordinator.isDisposed()) {
            MaybeSource<? extends T> maybeSource = maybeSourceArr[i11];
            if (maybeSource == null) {
                zipCoordinator.c(new NullPointerException("One of the sources is null"), i11);
                return;
            } else {
                maybeSource.subscribe(zipCoordinator.f16577d[i11]);
                i11++;
            }
        }
    }
}
