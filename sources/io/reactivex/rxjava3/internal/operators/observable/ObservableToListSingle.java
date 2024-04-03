package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Collection;

public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f22410b;

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<U> f22411c;

    public static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super U> f22412b;

        /* renamed from: c  reason: collision with root package name */
        public U f22413c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22414d;

        public ToListObserver(SingleObserver<? super U> singleObserver, U u11) {
            this.f22412b = singleObserver;
            this.f22413c = u11;
        }

        public void dispose() {
            this.f22414d.dispose();
        }

        public boolean isDisposed() {
            return this.f22414d.isDisposed();
        }

        public void onComplete() {
            U u11 = this.f22413c;
            this.f22413c = null;
            this.f22412b.onSuccess(u11);
        }

        public void onError(Throwable th2) {
            this.f22413c = null;
            this.f22412b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22413c.add(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22414d, disposable)) {
                this.f22414d = disposable;
                this.f22412b.onSubscribe(this);
            }
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, int i11) {
        this.f22410b = observableSource;
        this.f22411c = Functions.createArrayList(i11);
    }

    public Observable<U> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableToList(this.f22410b, this.f22411c));
    }

    public void subscribeActual(SingleObserver<? super U> singleObserver) {
        try {
            this.f22410b.subscribe(new ToListObserver(singleObserver, (Collection) ExceptionHelper.nullCheck(this.f22411c.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (SingleObserver<?>) singleObserver);
        }
    }

    public ObservableToListSingle(ObservableSource<T> observableSource, Supplier<U> supplier) {
        this.f22410b = observableSource;
        this.f22411c = supplier;
    }
}
