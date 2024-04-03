package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f21775c;

    public static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21776b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f21777c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21778d;

        public FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.f21776b = observer;
            this.f21777c = function;
        }

        public void dispose() {
            this.f21778d.dispose();
            this.f21778d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f21778d.isDisposed();
        }

        public void onComplete() {
            Disposable disposable = this.f21778d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f21778d = disposableHelper;
                this.f21776b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            Disposable disposable = this.f21778d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21778d = disposableHelper;
            this.f21776b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f21778d != DisposableHelper.DISPOSED) {
                try {
                    Observer<? super R> observer = this.f21776b;
                    for (Object next : (Iterable) this.f21777c.apply(t11)) {
                        try {
                            try {
                                Objects.requireNonNull(next, "The iterator returned a null value");
                                observer.onNext(next);
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.f21778d.dispose();
                                onError(th2);
                                return;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            this.f21778d.dispose();
                            onError(th3);
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    this.f21778d.dispose();
                    onError(th4);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21778d, disposable)) {
                this.f21778d = disposable;
                this.f21776b.onSubscribe(this);
            }
        }
    }

    public ObservableFlattenIterable(ObservableSource<T> observableSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        super(observableSource);
        this.f21775c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        this.f21304b.subscribe(new FlattenIterableObserver(observer, this.f21775c));
    }
}
