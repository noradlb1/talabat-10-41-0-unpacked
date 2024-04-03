package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableReduceMaybe<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f22032b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<T, T, T> f22033c;

    public static final class ReduceObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f22034b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<T, T, T> f22035c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22036d;

        /* renamed from: e  reason: collision with root package name */
        public T f22037e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f22038f;

        public ReduceObserver(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
            this.f22034b = maybeObserver;
            this.f22035c = biFunction;
        }

        public void dispose() {
            this.f22038f.dispose();
        }

        public boolean isDisposed() {
            return this.f22038f.isDisposed();
        }

        public void onComplete() {
            if (!this.f22036d) {
                this.f22036d = true;
                T t11 = this.f22037e;
                this.f22037e = null;
                if (t11 != null) {
                    this.f22034b.onSuccess(t11);
                } else {
                    this.f22034b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f22036d) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22036d = true;
            this.f22037e = null;
            this.f22034b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22036d) {
                T t12 = this.f22037e;
                if (t12 == null) {
                    this.f22037e = t11;
                    return;
                }
                try {
                    T apply = this.f22035c.apply(t12, t11);
                    Objects.requireNonNull(apply, "The reducer returned a null value");
                    this.f22037e = apply;
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f22038f.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22038f, disposable)) {
                this.f22038f = disposable;
                this.f22034b.onSubscribe(this);
            }
        }
    }

    public ObservableReduceMaybe(ObservableSource<T> observableSource, BiFunction<T, T, T> biFunction) {
        this.f22032b = observableSource;
        this.f22033c = biFunction;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f22032b.subscribe(new ReduceObserver(maybeObserver, this.f22033c));
    }
}
