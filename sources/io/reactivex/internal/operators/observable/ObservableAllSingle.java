package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f16822b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f16823c;

    public static final class AllObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f16824b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f16825c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16826d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16827e;

        public AllObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f16824b = singleObserver;
            this.f16825c = predicate;
        }

        public void dispose() {
            this.f16826d.dispose();
        }

        public boolean isDisposed() {
            return this.f16826d.isDisposed();
        }

        public void onComplete() {
            if (!this.f16827e) {
                this.f16827e = true;
                this.f16824b.onSuccess(Boolean.TRUE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f16827e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16827e = true;
            this.f16824b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16827e) {
                try {
                    if (!this.f16825c.test(t11)) {
                        this.f16827e = true;
                        this.f16826d.dispose();
                        this.f16824b.onSuccess(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f16826d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16826d, disposable)) {
                this.f16826d = disposable;
                this.f16824b.onSubscribe(this);
            }
        }
    }

    public ObservableAllSingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f16822b = observableSource;
        this.f16823c = predicate;
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableAll(this.f16822b, this.f16823c));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f16822b.subscribe(new AllObserver(singleObserver, this.f16823c));
    }
}
