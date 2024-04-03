package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T>[] f18435b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f18436c;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Exception {
            return ObjectHelper.requireNonNull(SingleZipArray.this.f18436c.apply(new Object[]{t11}), "The zipper returned a null value");
        }
    }

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f18438b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f18439c;

        /* renamed from: d  reason: collision with root package name */
        public final ZipSingleObserver<T>[] f18440d;

        /* renamed from: e  reason: collision with root package name */
        public final Object[] f18441e;

        public ZipCoordinator(SingleObserver<? super R> singleObserver, int i11, Function<? super Object[], ? extends R> function) {
            super(i11);
            this.f18438b = singleObserver;
            this.f18439c = function;
            ZipSingleObserver<T>[] zipSingleObserverArr = new ZipSingleObserver[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                zipSingleObserverArr[i12] = new ZipSingleObserver<>(this, i12);
            }
            this.f18440d = zipSingleObserverArr;
            this.f18441e = new Object[i11];
        }

        public void a(int i11) {
            ZipSingleObserver<T>[] zipSingleObserverArr = this.f18440d;
            int length = zipSingleObserverArr.length;
            for (int i12 = 0; i12 < i11; i12++) {
                zipSingleObserverArr[i12].dispose();
            }
            while (true) {
                i11++;
                if (i11 < length) {
                    zipSingleObserverArr[i11].dispose();
                } else {
                    return;
                }
            }
        }

        public void b(Throwable th2, int i11) {
            if (getAndSet(0) > 0) {
                a(i11);
                this.f18438b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void c(T t11, int i11) {
            this.f18441e[i11] = t11;
            if (decrementAndGet() == 0) {
                try {
                    this.f18438b.onSuccess(ObjectHelper.requireNonNull(this.f18439c.apply(this.f18441e), "The zipper returned a null value"));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f18438b.onError(th2);
                }
            }
        }

        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> dispose : this.f18440d) {
                    dispose.dispose();
                }
            }
        }

        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    public static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;

        /* renamed from: b  reason: collision with root package name */
        public final ZipCoordinator<T, ?> f18442b;

        /* renamed from: c  reason: collision with root package name */
        public final int f18443c;

        public ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i11) {
            this.f18442b = zipCoordinator;
            this.f18443c = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onError(Throwable th2) {
            this.f18442b.b(th2, this.f18443c);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f18442b.c(t11, this.f18443c);
        }
    }

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArr, Function<? super Object[], ? extends R> function) {
        this.f18435b = singleSourceArr;
        this.f18436c = function;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource<? extends T>[] singleSourceArr = this.f18435b;
        int length = singleSourceArr.length;
        int i11 = 0;
        if (length == 1) {
            singleSourceArr[0].subscribe(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, length, this.f18436c);
        singleObserver.onSubscribe(zipCoordinator);
        while (i11 < length && !zipCoordinator.isDisposed()) {
            SingleSource<? extends T> singleSource = singleSourceArr[i11];
            if (singleSource == null) {
                zipCoordinator.b(new NullPointerException("One of the sources is null"), i11);
                return;
            } else {
                singleSource.subscribe(zipCoordinator.f18440d[i11]);
                i11++;
            }
        }
    }
}
