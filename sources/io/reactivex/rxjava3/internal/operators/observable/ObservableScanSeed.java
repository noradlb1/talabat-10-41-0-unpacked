package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f22166c;

    /* renamed from: d  reason: collision with root package name */
    public final Supplier<R> f22167d;

    public static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f22168b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f22169c;

        /* renamed from: d  reason: collision with root package name */
        public R f22170d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22171e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22172f;

        public ScanSeedObserver(Observer<? super R> observer, BiFunction<R, ? super T, R> biFunction, R r11) {
            this.f22168b = observer;
            this.f22169c = biFunction;
            this.f22170d = r11;
        }

        public void dispose() {
            this.f22171e.dispose();
        }

        public boolean isDisposed() {
            return this.f22171e.isDisposed();
        }

        public void onComplete() {
            if (!this.f22172f) {
                this.f22172f = true;
                this.f22168b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22172f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22172f = true;
            this.f22168b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22172f) {
                try {
                    R apply = this.f22169c.apply(this.f22170d, t11);
                    Objects.requireNonNull(apply, "The accumulator returned a null value");
                    this.f22170d = apply;
                    this.f22168b.onNext(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f22171e.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22171e, disposable)) {
                this.f22171e = disposable;
                this.f22168b.onSubscribe(this);
                this.f22168b.onNext(this.f22170d);
            }
        }
    }

    public ObservableScanSeed(ObservableSource<T> observableSource, Supplier<R> supplier, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.f22166c = biFunction;
        this.f22167d = supplier;
    }

    public void subscribeActual(Observer<? super R> observer) {
        try {
            R r11 = this.f22167d.get();
            Objects.requireNonNull(r11, "The seed supplied is null");
            this.f21304b.subscribe(new ScanSeedObserver(observer, this.f22166c, r11));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
