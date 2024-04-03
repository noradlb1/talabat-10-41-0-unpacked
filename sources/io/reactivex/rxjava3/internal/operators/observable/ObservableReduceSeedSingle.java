package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableReduceSeedSingle<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f22039b;

    /* renamed from: c  reason: collision with root package name */
    public final R f22040c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f22041d;

    public static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f22042b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f22043c;

        /* renamed from: d  reason: collision with root package name */
        public R f22044d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22045e;

        public ReduceSeedObserver(SingleObserver<? super R> singleObserver, BiFunction<R, ? super T, R> biFunction, R r11) {
            this.f22042b = singleObserver;
            this.f22044d = r11;
            this.f22043c = biFunction;
        }

        public void dispose() {
            this.f22045e.dispose();
        }

        public boolean isDisposed() {
            return this.f22045e.isDisposed();
        }

        public void onComplete() {
            R r11 = this.f22044d;
            if (r11 != null) {
                this.f22044d = null;
                this.f22042b.onSuccess(r11);
            }
        }

        public void onError(Throwable th2) {
            if (this.f22044d != null) {
                this.f22044d = null;
                this.f22042b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            R r11 = this.f22044d;
            if (r11 != null) {
                try {
                    R apply = this.f22043c.apply(r11, t11);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.f22044d = apply;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f22045e.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22045e, disposable)) {
                this.f22045e = disposable;
                this.f22042b.onSubscribe(this);
            }
        }
    }

    public ObservableReduceSeedSingle(ObservableSource<T> observableSource, R r11, BiFunction<R, ? super T, R> biFunction) {
        this.f22039b = observableSource;
        this.f22040c = r11;
        this.f22041d = biFunction;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f22039b.subscribe(new ReduceSeedObserver(singleObserver, this.f22041d, this.f22040c));
    }
}
