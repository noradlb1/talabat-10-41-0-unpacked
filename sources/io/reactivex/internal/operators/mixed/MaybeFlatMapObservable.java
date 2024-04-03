package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f16697b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f16698c;

    public static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16699b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f16700c;

        public FlatMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f16699b = observer;
            this.f16700c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f16699b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16699b.onError(th2);
        }

        public void onNext(R r11) {
            this.f16699b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onSuccess(T t11) {
            try {
                ((ObservableSource) ObjectHelper.requireNonNull(this.f16700c.apply(t11), "The mapper returned a null Publisher")).subscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16699b.onError(th2);
            }
        }
    }

    public MaybeFlatMapObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.f16697b = maybeSource;
        this.f16698c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.f16698c);
        observer.onSubscribe(flatMapObserver);
        this.f16697b.subscribe(flatMapObserver);
    }
}
