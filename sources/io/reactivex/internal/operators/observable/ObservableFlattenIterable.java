package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f17248c;

    public static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f17249b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f17250c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17251d;

        public FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f17249b = observer;
            this.f17250c = function;
        }

        public void dispose() {
            this.f17251d.dispose();
            this.f17251d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f17251d.isDisposed();
        }

        public void onComplete() {
            Disposable disposable = this.f17251d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f17251d = disposableHelper;
                this.f17249b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            Disposable disposable = this.f17251d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17251d = disposableHelper;
            this.f17249b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f17251d != DisposableHelper.DISPOSED) {
                try {
                    Observer<? super R> observer = this.f17249b;
                    for (Object requireNonNull : (Iterable) this.f17250c.apply(t11)) {
                        try {
                            try {
                                observer.onNext(ObjectHelper.requireNonNull(requireNonNull, "The iterator returned a null value"));
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f17251d.dispose();
                                onError(th2);
                                return;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f17251d.dispose();
                            onError(th3);
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    this.f17251d.dispose();
                    onError(th4);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17251d, disposable)) {
                this.f17251d = disposable;
                this.f17249b.onSubscribe(this);
            }
        }
    }

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.f17248c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f16799b.subscribe(new FlattenIterableObserver(observer, this.f17248c));
    }
}
