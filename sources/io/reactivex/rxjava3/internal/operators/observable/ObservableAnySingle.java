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

public final class ObservableAnySingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21347b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f21348c;

    public static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f21349b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f21350c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21351d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21352e;

        public AnyObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f21349b = singleObserver;
            this.f21350c = predicate;
        }

        public void dispose() {
            this.f21351d.dispose();
        }

        public boolean isDisposed() {
            return this.f21351d.isDisposed();
        }

        public void onComplete() {
            if (!this.f21352e) {
                this.f21352e = true;
                this.f21349b.onSuccess(Boolean.FALSE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f21352e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21352e = true;
            this.f21349b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f21352e) {
                try {
                    if (this.f21350c.test(t11)) {
                        this.f21352e = true;
                        this.f21351d.dispose();
                        this.f21349b.onSuccess(Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21351d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21351d, disposable)) {
                this.f21351d = disposable;
                this.f21349b.onSubscribe(this);
            }
        }
    }

    public ObservableAnySingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f21347b = observableSource;
        this.f21348c = predicate;
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableAny(this.f21347b, this.f21348c));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f21347b.subscribe(new AnyObserver(singleObserver, this.f21348c));
    }
}
