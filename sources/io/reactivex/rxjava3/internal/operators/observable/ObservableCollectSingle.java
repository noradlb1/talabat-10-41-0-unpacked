package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21460b;

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<? extends U> f21461c;

    /* renamed from: d  reason: collision with root package name */
    public final BiConsumer<? super U, ? super T> f21462d;

    public static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super U> f21463b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<? super U, ? super T> f21464c;

        /* renamed from: d  reason: collision with root package name */
        public final U f21465d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f21466e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f21467f;

        public CollectObserver(SingleObserver<? super U> singleObserver, U u11, BiConsumer<? super U, ? super T> biConsumer) {
            this.f21463b = singleObserver;
            this.f21464c = biConsumer;
            this.f21465d = u11;
        }

        public void dispose() {
            this.f21466e.dispose();
        }

        public boolean isDisposed() {
            return this.f21466e.isDisposed();
        }

        public void onComplete() {
            if (!this.f21467f) {
                this.f21467f = true;
                this.f21463b.onSuccess(this.f21465d);
            }
        }

        public void onError(Throwable th2) {
            if (this.f21467f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21467f = true;
            this.f21463b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21467f) {
                try {
                    this.f21464c.accept(this.f21465d, t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21466e.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21466e, disposable)) {
                this.f21466e = disposable;
                this.f21463b.onSubscribe(this);
            }
        }
    }

    public ObservableCollectSingle(ObservableSource<T> observableSource, Supplier<? extends U> supplier, BiConsumer<? super U, ? super T> biConsumer) {
        this.f21460b = observableSource;
        this.f21461c = supplier;
        this.f21462d = biConsumer;
    }

    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableCollect(this.f21460b, this.f21461c, this.f21462d));
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            Object obj = this.f21461c.get();
            Objects.requireNonNull(obj, "The initialSupplier returned a null value");
            this.f21460b.subscribe(new CollectObserver(singleObserver, obj, this.f21462d));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }
}
