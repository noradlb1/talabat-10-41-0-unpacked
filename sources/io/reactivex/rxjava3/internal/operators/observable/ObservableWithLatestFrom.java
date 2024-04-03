package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f22531c;

    /* renamed from: d  reason: collision with root package name */
    public final ObservableSource<? extends U> f22532d;

    public static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f22533b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends R> f22534c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f22535d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f22536e = new AtomicReference<>();

        public WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f22533b = observer;
            this.f22534c = biFunction;
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22535d);
            DisposableHelper.dispose(this.f22536e);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f22535d.get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f22536e);
            this.f22533b.onComplete();
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f22536e);
            this.f22533b.onError(th2);
        }

        public void onNext(T t11) {
            Object obj = get();
            if (obj != null) {
                try {
                    Object apply = this.f22534c.apply(t11, obj);
                    Objects.requireNonNull(apply, "The combiner returned a null value");
                    this.f22533b.onNext(apply);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    this.f22533b.onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22535d, disposable);
        }

        public void otherError(Throwable th2) {
            DisposableHelper.dispose(this.f22535d);
            this.f22533b.onError(th2);
        }

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.f22536e, disposable);
        }
    }

    public final class WithLatestFromOtherObserver implements Observer<U> {
        private final WithLatestFromObserver<T, U, R> parent;

        public WithLatestFromOtherObserver(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.parent = withLatestFromObserver;
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            this.parent.otherError(th2);
        }

        public void onNext(U u11) {
            this.parent.lazySet(u11);
        }

        public void onSubscribe(Disposable disposable) {
            this.parent.setOther(disposable);
        }
    }

    public ObservableWithLatestFrom(ObservableSource<T> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.f22531c = biFunction;
        this.f22532d = observableSource2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.f22531c);
        serializedObserver.onSubscribe(withLatestFromObserver);
        this.f22532d.subscribe(new WithLatestFromOtherObserver(withLatestFromObserver));
        this.f21304b.subscribe(withLatestFromObserver);
    }
}
