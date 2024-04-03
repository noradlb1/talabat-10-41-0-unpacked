package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleEquals<T> extends Single<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22853b;

    /* renamed from: c  reason: collision with root package name */
    public final SingleSource<? extends T> f22854c;

    public static class InnerObserver<T> implements SingleObserver<T> {

        /* renamed from: b  reason: collision with root package name */
        public final int f22855b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeDisposable f22856c;

        /* renamed from: d  reason: collision with root package name */
        public final Object[] f22857d;

        /* renamed from: e  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f22858e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicInteger f22859f;

        public InnerObserver(int i11, CompositeDisposable compositeDisposable, Object[] objArr, SingleObserver<? super Boolean> singleObserver, AtomicInteger atomicInteger) {
            this.f22855b = i11;
            this.f22856c = compositeDisposable;
            this.f22857d = objArr;
            this.f22858e = singleObserver;
            this.f22859f = atomicInteger;
        }

        public void onError(Throwable th2) {
            int andSet = this.f22859f.getAndSet(-1);
            if (andSet == 0 || andSet == 1) {
                this.f22856c.dispose();
                this.f22858e.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22856c.add(disposable);
        }

        public void onSuccess(T t11) {
            this.f22857d[this.f22855b] = t11;
            if (this.f22859f.incrementAndGet() == 2) {
                SingleObserver<? super Boolean> singleObserver = this.f22858e;
                Object[] objArr = this.f22857d;
                singleObserver.onSuccess(Boolean.valueOf(Objects.equals(objArr[0], objArr[1])));
            }
        }
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.f22853b = singleSource;
        this.f22854c = singleSource2;
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        CompositeDisposable compositeDisposable2 = compositeDisposable;
        Object[] objArr = {null, null};
        SingleObserver<? super Boolean> singleObserver2 = singleObserver;
        AtomicInteger atomicInteger2 = atomicInteger;
        this.f22853b.subscribe(new InnerObserver(0, compositeDisposable2, objArr, singleObserver2, atomicInteger2));
        this.f22854c.subscribe(new InnerObserver(1, compositeDisposable2, objArr, singleObserver2, atomicInteger2));
    }
}
