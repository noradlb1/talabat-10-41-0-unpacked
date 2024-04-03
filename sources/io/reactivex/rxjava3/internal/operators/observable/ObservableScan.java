package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<T, T, T> f22160c;

    public static final class ScanObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22161b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f22162c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22163d;

        /* renamed from: e  reason: collision with root package name */
        public T f22164e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22165f;

        public ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.f22161b = observer;
            this.f22162c = biFunction;
        }

        public void dispose() {
            this.f22163d.dispose();
        }

        public boolean isDisposed() {
            return this.f22163d.isDisposed();
        }

        public void onComplete() {
            if (!this.f22165f) {
                this.f22165f = true;
                this.f22161b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22165f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22165f = true;
            this.f22161b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22165f) {
                Observer<? super T> observer = this.f22161b;
                T t12 = this.f22164e;
                if (t12 == null) {
                    this.f22164e = t11;
                    observer.onNext(t11);
                    return;
                }
                try {
                    T apply = this.f22162c.apply(t12, t11);
                    Objects.requireNonNull(apply, "The value returned by the accumulator is null");
                    this.f22164e = apply;
                    observer.onNext(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f22163d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22163d, disposable)) {
                this.f22163d = disposable;
                this.f22161b.onSubscribe(this);
            }
        }
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.f22160c = biFunction;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new ScanObserver(observer, this.f22160c));
    }
}
