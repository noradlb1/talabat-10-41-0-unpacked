package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21327b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f21328c;

    public static final class AllObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f21329b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f21330c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21331d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21332e;

        public AllObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f21329b = singleObserver;
            this.f21330c = predicate;
        }

        public void dispose() {
            this.f21331d.dispose();
        }

        public boolean isDisposed() {
            return this.f21331d.isDisposed();
        }

        public void onComplete() {
            if (!this.f21332e) {
                this.f21332e = true;
                this.f21329b.onSuccess(Boolean.TRUE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f21332e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21332e = true;
            this.f21329b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21332e) {
                try {
                    if (!this.f21330c.test(t11)) {
                        this.f21332e = true;
                        this.f21331d.dispose();
                        this.f21329b.onSuccess(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21331d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21331d, disposable)) {
                this.f21331d = disposable;
                this.f21329b.onSubscribe(this);
            }
        }
    }

    public ObservableAllSingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f21327b = observableSource;
        this.f21328c = predicate;
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableAll(this.f21327b, this.f21328c));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f21327b.subscribe(new AllObserver(singleObserver, this.f21328c));
    }
}
