package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17500b;

    /* renamed from: c  reason: collision with root package name */
    public final R f17501c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f17502d;

    public static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f17503b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f17504c;

        /* renamed from: d  reason: collision with root package name */
        public R f17505d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f17506e;

        public ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r11) {
            this.f17503b = singleObserver;
            this.f17505d = r11;
            this.f17504c = biFunction;
        }

        public void dispose() {
            this.f17506e.dispose();
        }

        public boolean isDisposed() {
            return this.f17506e.isDisposed();
        }

        public void onComplete() {
            R r11 = this.f17505d;
            if (r11 != null) {
                this.f17505d = null;
                this.f17503b.onSuccess(r11);
            }
        }

        public void onError(Throwable th2) {
            if (this.f17505d != null) {
                this.f17505d = null;
                this.f17503b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            R r11 = this.f17505d;
            if (r11 != null) {
                try {
                    this.f17505d = ObjectHelper.requireNonNull(this.f17504c.apply(r11, t11), "The reducer returned a null value");
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17506e.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17506e, disposable)) {
                this.f17506e = disposable;
                this.f17503b.onSubscribe(this);
            }
        }
    }

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r11, BiFunction<R, ? super T, R> biFunction) {
        this.f17500b = observableSource;
        this.f17501c = r11;
        this.f17502d = biFunction;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f17500b.subscribe(new ReduceSeedObserver(singleObserver, this.f17502d, this.f17501c));
    }
}
