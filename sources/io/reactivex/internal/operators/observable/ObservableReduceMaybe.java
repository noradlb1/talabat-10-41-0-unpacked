package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableReduceMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17493b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<T, T, T> f17494c;

    public static final class ReduceObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f17495b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f17496c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f17497d;

        /* renamed from: e  reason: collision with root package name */
        public T f17498e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f17499f;

        public ReduceObserver(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.f17495b = maybeObserver;
            this.f17496c = biFunction;
        }

        public void dispose() {
            this.f17499f.dispose();
        }

        public boolean isDisposed() {
            return this.f17499f.isDisposed();
        }

        public void onComplete() {
            if (!this.f17497d) {
                this.f17497d = true;
                T t11 = this.f17498e;
                this.f17498e = null;
                if (t11 != null) {
                    this.f17495b.onSuccess(t11);
                } else {
                    this.f17495b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f17497d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17497d = true;
            this.f17498e = null;
            this.f17495b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f17497d) {
                T t12 = this.f17498e;
                if (t12 == null) {
                    this.f17498e = t11;
                    return;
                }
                try {
                    this.f17498e = ObjectHelper.requireNonNull(this.f17496c.apply(t12, t11), "The reducer returned a null value");
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17499f.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17499f, disposable)) {
                this.f17499f = disposable;
                this.f17495b.onSubscribe(this);
            }
        }
    }

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.f17493b = observableSource;
        this.f17494c = biFunction;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f17493b.subscribe(new ReduceObserver(maybeObserver, this.f17494c));
    }
}
