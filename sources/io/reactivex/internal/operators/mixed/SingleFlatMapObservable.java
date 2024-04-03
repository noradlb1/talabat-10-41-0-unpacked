package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f16795b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f16796c;

    public static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16797b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f16798c;

        public FlatMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f16797b = observer;
            this.f16798c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16797b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16797b.onError(th2);
        }

        public void onNext(R r11) {
            this.f16797b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onSuccess(T t11) {
            try {
                ((ObservableSource) ObjectHelper.requireNonNull(this.f16798c.apply(t11), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16797b.onError(th2);
            }
        }
    }

    public SingleFlatMapObservable(SingleSource<T> singleSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.f16795b = singleSource;
        this.f16796c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.f16796c);
        observer.onSubscribe(flatMapObserver);
        this.f16795b.subscribe(flatMapObserver);
    }
}
