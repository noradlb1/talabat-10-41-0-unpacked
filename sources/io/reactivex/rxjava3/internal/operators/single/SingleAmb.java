package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SingleAmb<T> extends Single<T> {
    private final SingleSource<? extends T>[] sources;
    private final Iterable<? extends SingleSource<? extends T>> sourcesIterable;

    public static final class AmbSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final CompositeDisposable f22750b;

        /* renamed from: c  reason: collision with root package name */
        public final SingleObserver<? super T> f22751c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicBoolean f22752d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22753e;

        public AmbSingleObserver(SingleObserver<? super T> singleObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.f22751c = singleObserver;
            this.f22750b = compositeDisposable;
            this.f22752d = atomicBoolean;
        }

        public void onError(Throwable th2) {
            if (this.f22752d.compareAndSet(false, true)) {
                this.f22750b.delete(this.f22753e);
                this.f22750b.dispose();
                this.f22751c.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22753e = disposable;
            this.f22750b.add(disposable);
        }

        public void onSuccess(T t11) {
            if (this.f22752d.compareAndSet(false, true)) {
                this.f22750b.delete(this.f22753e);
                this.f22750b.dispose();
                this.f22751c.onSuccess(t11);
            }
        }
    }

    public SingleAmb(SingleSource<? extends T>[] singleSourceArr, Iterable<? extends SingleSource<? extends T>> iterable) {
        this.sources = singleSourceArr;
        this.sourcesIterable = iterable;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        int i11;
        SingleSource<? extends T>[] singleSourceArr = this.sources;
        if (singleSourceArr == null) {
            singleSourceArr = new SingleSource[8];
            try {
                i11 = 0;
                for (SingleSource<? extends T> singleSource : this.sourcesIterable) {
                    if (singleSource == null) {
                        EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), (SingleObserver<?>) singleObserver);
                        return;
                    }
                    if (i11 == singleSourceArr.length) {
                        SingleSource<? extends T>[] singleSourceArr2 = new SingleSource[((i11 >> 2) + i11)];
                        System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, i11);
                        singleSourceArr = singleSourceArr2;
                    }
                    int i12 = i11 + 1;
                    singleSourceArr[i11] = singleSource;
                    i11 = i12;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
                return;
            }
        } else {
            i11 = singleSourceArr.length;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        int i13 = 0;
        while (i13 < i11) {
            SingleSource<? extends T> singleSource2 = singleSourceArr[i13];
            if (!compositeDisposable.isDisposed()) {
                if (singleSource2 == null) {
                    compositeDisposable.dispose();
                    NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        singleObserver.onError(nullPointerException);
                        return;
                    } else {
                        RxJavaPlugins.onError(nullPointerException);
                        return;
                    }
                } else {
                    singleSource2.subscribe(new AmbSingleObserver(singleObserver, compositeDisposable, atomicBoolean));
                    i13++;
                }
            } else {
                return;
            }
        }
    }
}
