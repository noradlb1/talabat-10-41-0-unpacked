package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Collection;

public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Supplier<U> f22406c;

    public static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f22407b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f22408c;

        /* renamed from: d  reason: collision with root package name */
        public U f22409d;

        public ToListObserver(Observer<? super U> observer, U u11) {
            this.f22407b = observer;
            this.f22409d = u11;
        }

        public void dispose() {
            this.f22408c.dispose();
        }

        public boolean isDisposed() {
            return this.f22408c.isDisposed();
        }

        public void onComplete() {
            U u11 = this.f22409d;
            this.f22409d = null;
            this.f22407b.onNext(u11);
            this.f22407b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f22409d = null;
            this.f22407b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22409d.add(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22408c, disposable)) {
                this.f22408c = disposable;
                this.f22407b.onSubscribe(this);
            }
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, Supplier<U> supplier) {
        super(observableSource);
        this.f22406c = supplier;
    }

    public void subscribeActual(Observer<? super U> observer) {
        try {
            this.f21304b.subscribe(new ToListObserver(observer, (Collection) ExceptionHelper.nullCheck(this.f22406c.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
