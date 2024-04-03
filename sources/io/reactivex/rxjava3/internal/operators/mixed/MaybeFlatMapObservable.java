package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapObservable<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f21221b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f21222c;

    public static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21223b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f21224c;

        public FlatMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f21223b = observer;
            this.f21224c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f21223b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f21223b.onError(th2);
        }

        public void onNext(R r11) {
            this.f21223b.onNext(r11);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f21224c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                ObservableSource observableSource = (ObservableSource) apply;
                if (!isDisposed()) {
                    observableSource.subscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21223b.onError(th2);
            }
        }
    }

    public MaybeFlatMapObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        this.f21221b = maybeSource;
        this.f21222c = function;
    }

    public void subscribeActual(Observer<? super R> observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.f21222c);
        observer.onSubscribe(flatMapObserver);
        this.f21221b.subscribe(flatMapObserver);
    }
}
