package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17868b;

    /* renamed from: c  reason: collision with root package name */
    public final Callable<U> f17869c;

    public static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super U> f17870b;

        /* renamed from: c  reason: collision with root package name */
        public U f17871c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f17872d;

        public ToListObserver(SingleObserver<? super U> singleObserver, U u11) {
            this.f17870b = singleObserver;
            this.f17871c = u11;
        }

        public void dispose() {
            this.f17872d.dispose();
        }

        public boolean isDisposed() {
            return this.f17872d.isDisposed();
        }

        public void onComplete() {
            U u11 = this.f17871c;
            this.f17871c = null;
            this.f17870b.onSuccess(u11);
        }

        public void onError(Throwable th2) {
            this.f17871c = null;
            this.f17870b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17871c.add(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17872d, disposable)) {
                this.f17872d = disposable;
                this.f17870b.onSubscribe(this);
            }
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, int i11) {
        this.f17868b = observableSource;
        this.f17869c = Functions.createArrayList(i11);
    }

    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableToList(this.f17868b, this.f17869c));
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f17868b.subscribe(new ToListObserver(singleObserver, (Collection) ObjectHelper.requireNonNull(this.f17869c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Callable<U> callable) {
        this.f17868b = observableSource;
        this.f17869c = callable;
    }
}
