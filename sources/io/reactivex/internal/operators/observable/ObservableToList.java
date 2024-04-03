package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* renamed from: c  reason: collision with root package name */
    public final Callable<U> f17864c;

    public static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super U> f17865b;

        /* renamed from: c  reason: collision with root package name */
        public Disposable f17866c;

        /* renamed from: d  reason: collision with root package name */
        public U f17867d;

        public ToListObserver(Observer<? super U> observer, U u11) {
            this.f17865b = observer;
            this.f17867d = u11;
        }

        public void dispose() {
            this.f17866c.dispose();
        }

        public boolean isDisposed() {
            return this.f17866c.isDisposed();
        }

        public void onComplete() {
            U u11 = this.f17867d;
            this.f17867d = null;
            this.f17865b.onNext(u11);
            this.f17865b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f17867d = null;
            this.f17865b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17867d.add(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17866c, disposable)) {
                this.f17866c = disposable;
                this.f17865b.onSubscribe(this);
            }
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, int i11) {
        super(observableSource);
        this.f17864c = Functions.createArrayList(i11);
    }

    public void subscribeActual(Observer<? super U> observer) {
        try {
            this.f16799b.subscribe(new ToListObserver(observer, (Collection) ObjectHelper.requireNonNull(this.f17864c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }

    public ObservableToList(ObservableSource<T> observableSource, Callable<U> callable) {
        super(observableSource);
        this.f17864c = callable;
    }
}
