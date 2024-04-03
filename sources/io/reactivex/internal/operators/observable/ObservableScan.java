package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<T, T, T> f17617c;

    public static final class ScanObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17618b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f17619c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17620d;

        /* renamed from: e  reason: collision with root package name */
        public T f17621e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17622f;

        public ScanObserver(Observer<? super T> observer, BiFunction<T, T, T> biFunction) {
            this.f17618b = observer;
            this.f17619c = biFunction;
        }

        public void dispose() {
            this.f17620d.dispose();
        }

        public boolean isDisposed() {
            return this.f17620d.isDisposed();
        }

        public void onComplete() {
            if (!this.f17622f) {
                this.f17622f = true;
                this.f17618b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17622f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17622f = true;
            this.f17618b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17622f) {
                Observer<? super T> observer = this.f17618b;
                T t12 = this.f17621e;
                if (t12 == null) {
                    this.f17621e = t11;
                    observer.onNext(t11);
                    return;
                }
                try {
                    T requireNonNull = ObjectHelper.requireNonNull(this.f17619c.apply(t12, t11), "The value returned by the accumulator is null");
                    this.f17621e = requireNonNull;
                    observer.onNext(requireNonNull);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17620d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17620d, disposable)) {
                this.f17620d = disposable;
                this.f17618b.onSubscribe(this);
            }
        }
    }

    public ObservableScan(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        super(observableSource);
        this.f17617c = biFunction;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new ScanObserver(observer, this.f17617c));
    }
}
