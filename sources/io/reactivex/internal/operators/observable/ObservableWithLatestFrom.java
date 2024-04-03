package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f18000c;

    /* renamed from: d  reason: collision with root package name */
    public final ObservableSource<? extends U> f18001d;

    public static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f18002b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends R> f18003c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<Disposable> f18004d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<Disposable> f18005e = new AtomicReference<>();

        public WithLatestFromObserver(Observer<? super R> observer, BiFunction<? super T, ? super U, ? extends R> biFunction) {
            this.f18002b = observer;
            this.f18003c = biFunction;
        }

        public void dispose() {
            DisposableHelper.dispose(this.f18004d);
            DisposableHelper.dispose(this.f18005e);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f18004d.get());
        }

        public void onComplete() {
            DisposableHelper.dispose(this.f18005e);
            this.f18002b.onComplete();
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f18005e);
            this.f18002b.onError(th2);
        }

        public void onNext(T t11) {
            Object obj = get();
            if (obj != null) {
                try {
                    this.f18002b.onNext(ObjectHelper.requireNonNull(this.f18003c.apply(t11, obj), "The combiner returned a null value"));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    dispose();
                    this.f18002b.onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f18004d, disposable);
        }

        public void otherError(Throwable th2) {
            DisposableHelper.dispose(this.f18004d);
            this.f18002b.onError(th2);
        }

        public boolean setOther(Disposable disposable) {
            return DisposableHelper.setOnce(this.f18005e, disposable);
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
        this.f18000c = biFunction;
        this.f18001d = observableSource2;
    }

    public void subscribeActual(Observer<? super R> observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.f18000c);
        serializedObserver.onSubscribe(withLatestFromObserver);
        this.f18001d.subscribe(new WithLatestFromOtherObserver(withLatestFromObserver));
        this.f16799b.subscribe(withLatestFromObserver);
    }
}
