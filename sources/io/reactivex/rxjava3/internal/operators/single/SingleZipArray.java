package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.operators.single.SingleMap;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T>[] f23004b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f23005c;

    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        public R apply(T t11) throws Throwable {
            R apply = SingleZipArray.this.f23005c.apply(new Object[]{t11});
            Objects.requireNonNull(apply, "The zipper returned a null value");
            return apply;
        }
    }

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -5556924161382950569L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f23007b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f23008c;

        /* renamed from: d  reason: collision with root package name */
        public final ZipSingleObserver<T>[] f23009d;

        /* renamed from: e  reason: collision with root package name */
        public Object[] f23010e;

        public ZipCoordinator(SingleObserver<? super R> singleObserver, int i11, Function<? super Object[], ? extends R> function) {
            super(i11);
            this.f23007b = singleObserver;
            this.f23008c = function;
            ZipSingleObserver<T>[] zipSingleObserverArr = new ZipSingleObserver[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                zipSingleObserverArr[i12] = new ZipSingleObserver<>(this, i12);
            }
            this.f23009d = zipSingleObserverArr;
            this.f23010e = new Object[i11];
        }

        public void a(int i11) {
            ZipSingleObserver<T>[] zipSingleObserverArr = this.f23009d;
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
                this.f23010e = null;
                this.f23007b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void c(T t11, int i11) {
            Object[] objArr = this.f23010e;
            if (objArr != null) {
                objArr[i11] = t11;
            }
            if (decrementAndGet() == 0) {
                try {
                    Object apply = this.f23008c.apply(objArr);
                    Objects.requireNonNull(apply, "The zipper returned a null value");
                    this.f23010e = null;
                    this.f23007b.onSuccess(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f23010e = null;
                    this.f23007b.onError(th2);
                }
            }
        }

        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> dispose : this.f23009d) {
                    dispose.dispose();
                }
                this.f23010e = null;
            }
        }

        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    public static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        private static final long serialVersionUID = 3323743579927613702L;

        /* renamed from: b  reason: collision with root package name */
        public final ZipCoordinator<T, ?> f23011b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23012c;

        public ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i11) {
            this.f23011b = zipCoordinator;
            this.f23012c = i11;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onError(Throwable th2) {
            this.f23011b.b(th2, this.f23012c);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(T t11) {
            this.f23011b.c(t11, this.f23012c);
        }
    }

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArr, Function<? super Object[], ? extends R> function) {
        this.f23004b = singleSourceArr;
        this.f23005c = function;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource<? extends T>[] singleSourceArr = this.f23004b;
        int length = singleSourceArr.length;
        int i11 = 0;
        if (length == 1) {
            singleSourceArr[0].subscribe(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, length, this.f23005c);
        singleObserver.onSubscribe(zipCoordinator);
        while (i11 < length && !zipCoordinator.isDisposed()) {
            SingleSource<? extends T> singleSource = singleSourceArr[i11];
            if (singleSource == null) {
                zipCoordinator.b(new NullPointerException("One of the sources is null"), i11);
                return;
            } else {
                singleSource.subscribe(zipCoordinator.f23009d[i11]);
                i11++;
            }
        }
    }
}
