package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f21300b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f21301c;

    public static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21302b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f21303c;

        public FlatMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f21302b = observer;
            this.f21303c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f21302b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21302b.onError(th2);
        }

        public void onNext(R r11) {
            this.f21302b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f21303c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                ObservableSource observableSource = (ObservableSource) apply;
                if (!isDisposed()) {
                    observableSource.subscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21302b.onError(th2);
            }
        }
    }

    public SingleFlatMapObservable(SingleSource<T> singleSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.f21300b = singleSource;
        this.f21301c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.f21301c);
        observer.onSubscribe(flatMapObserver);
        this.f21300b.subscribe(flatMapObserver);
    }
}
