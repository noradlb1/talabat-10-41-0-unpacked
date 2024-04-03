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

public final class ObservableAnySingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f16842b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f16843c;

    public static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super Boolean> f16844b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f16845c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16846d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16847e;

        public AnyObserver(SingleObserver<? super Boolean> singleObserver, Predicate<? super T> predicate) {
            this.f16844b = singleObserver;
            this.f16845c = predicate;
        }

        public void dispose() {
            this.f16846d.dispose();
        }

        public boolean isDisposed() {
            return this.f16846d.isDisposed();
        }

        public void onComplete() {
            if (!this.f16847e) {
                this.f16847e = true;
                this.f16844b.onSuccess(Boolean.FALSE);
            }
        }

        public void onError(Throwable th2) {
            if (this.f16847e) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f16847e = true;
            this.f16844b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f16847e) {
                try {
                    if (this.f16845c.test(t11)) {
                        this.f16847e = true;
                        this.f16846d.dispose();
                        this.f16844b.onSuccess(Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f16846d.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16846d, disposable)) {
                this.f16846d = disposable;
                this.f16844b.onSubscribe(this);
            }
        }
    }

    public ObservableAnySingle(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        this.f16842b = observableSource;
        this.f16843c = predicate;
    }

    public Observable<Boolean> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableAny(this.f16842b, this.f16843c));
    }

    public void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f16842b.subscribe(new AnyObserver(singleObserver, this.f16843c));
    }
}
