package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f16964b;

    /* renamed from: c  reason: collision with root package name */
    public final Callable<? extends U> f16965c;

    /* renamed from: d  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f16966d;

    public static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super U> f16967b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f16968c;

        /* renamed from: d  reason: collision with root package name */
        public final U f16969d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f16970e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f16971f;

        public CollectObserver(SingleObserver<? super U> singleObserver, U u11, BiConsumer<? super U, ? super T> biConsumer) {
            this.f16967b = singleObserver;
            this.f16968c = biConsumer;
            this.f16969d = u11;
        }

        public void dispose() {
            this.f16970e.dispose();
        }

        public boolean isDisposed() {
            return this.f16970e.isDisposed();
        }

        public void onComplete() {
            if (!this.f16971f) {
                this.f16971f = true;
                this.f16967b.onSuccess(this.f16969d);
            }
        }

        public void onError(Throwable th2) {
            if (this.f16971f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16971f = true;
            this.f16967b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16971f) {
                try {
                    this.f16968c.accept(this.f16969d, t11);
                } catch (Throwable th2) {
                    this.f16970e.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16970e, disposable)) {
                this.f16970e = disposable;
                this.f16967b.onSubscribe(this);
            }
        }
    }

    public ObservableCollectSingle(ObservableSource<T> observableSource, Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        this.f16964b = observableSource;
        this.f16965c = callable;
        this.f16966d = biConsumer;
    }

    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableCollect(this.f16964b, this.f16965c, this.f16966d));
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f16964b.subscribe(new CollectObserver(singleObserver, ObjectHelper.requireNonNull(this.f16965c.call(), "The initialSupplier returned a null value"), this.f16966d));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
