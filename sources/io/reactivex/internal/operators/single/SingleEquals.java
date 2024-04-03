package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleEquals<T> extends Single<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18312b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f18313c;

    public static class InnerObserver<T> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final int f18314b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f18315c;

        /* renamed from: d  reason: collision with root package name */
        public final Object[] f18316d;

        /* renamed from: e  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f18317e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f18318f;

        public InnerObserver(int i11, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.f18314b = i11;
            this.f18315c = compositeDisposable;
            this.f18316d = objArr;
            this.f18317e = singleObserver;
            this.f18318f = atomicInteger;
        }

        public void onError(Throwable th2) {
            int i11;
            do {
                i11 = this.f18318f.get();
                if (i11 >= 2) {
                    RxJavaPlugins.onError(th2);
                    return;
                }
            } while (!this.f18318f.compareAndSet(i11, 2));
            this.f18315c.dispose();
            this.f18317e.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f18315c.add(disposable);
        }

        public void onSuccess(T t11) {
            this.f18316d[this.f18314b] = t11;
            if (this.f18318f.incrementAndGet() == 2) {
                SingleObserver<? super Boolean> singleObserver = this.f18317e;
                Object[] objArr = this.f18316d;
                singleObserver.onSuccess(Boolean.valueOf(ObjectHelper.equals(objArr[0], objArr[1])));
            }
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.f18312b = singleSource;
        this.f18313c = singleSource2;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        CompositeDisposable compositeDisposable2 = compositeDisposable;
        Object[] objArr = {null, null};
        SingleObserver<? super Boolean> singleObserver2 = singleObserver;
        AtomicInteger atomicInteger2 = atomicInteger;
        this.f18312b.subscribe(new InnerObserver(0, compositeDisposable2, objArr, singleObserver2, atomicInteger2));
        this.f18313c.subscribe(new InnerObserver(1, compositeDisposable2, objArr, singleObserver2, atomicInteger2));
    }
}
