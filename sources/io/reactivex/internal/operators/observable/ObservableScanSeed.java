package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<R, ? super T, R> f17623c;

    /* renamed from: d  reason: collision with root package name */
    public final Callable<R> f17624d;

    public static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17625b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<R, ? super T, R> f17626c;

        /* renamed from: d  reason: collision with root package name */
        public R f17627d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f17628e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17629f;

        public ScanSeedObserver(Observer<? super R> observer, BiFunction<R, ? super T, R> biFunction, R r11) {
            this.f17625b = observer;
            this.f17626c = biFunction;
            this.f17627d = r11;
        }

        public void dispose() {
            this.f17628e.dispose();
        }

        public boolean isDisposed() {
            return this.f17628e.isDisposed();
        }

        public void onComplete() {
            if (!this.f17629f) {
                this.f17629f = true;
                this.f17625b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17629f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17629f = true;
            this.f17625b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17629f) {
                try {
                    R requireNonNull = ObjectHelper.requireNonNull(this.f17626c.apply(this.f17627d, t11), "The accumulator returned a null value");
                    this.f17627d = requireNonNull;
                    this.f17625b.onNext(requireNonNull);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17628e.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17628e, disposable)) {
                this.f17628e = disposable;
                this.f17625b.onSubscribe(this);
                this.f17625b.onNext(this.f17627d);
            }
        }
    }

    public ObservableScanSeed(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        super(observableSource);
        this.f17623c = biFunction;
        this.f17624d = callable;
    }

    public void subscribeActual(Observer<? super R> observer) {
        try {
            this.f16799b.subscribe(new ScanSeedObserver(observer, this.f17623c, ObjectHelper.requireNonNull(this.f17624d.call(), "The seed supplied is null")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
