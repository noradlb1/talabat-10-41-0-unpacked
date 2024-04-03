package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final BooleanSupplier f17530c;

    public static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17531b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f17532c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends T> f17533d;

        /* renamed from: e  reason: collision with root package name */
        public final BooleanSupplier f17534e;

        public RepeatUntilObserver(Observer<? super T> observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f17531b = observer;
            this.f17532c = sequentialDisposable;
            this.f17533d = observableSource;
            this.f17534e = booleanSupplier;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                do {
                    this.f17533d.subscribe(this);
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void onComplete() {
            try {
                if (this.f17534e.getAsBoolean()) {
                    this.f17531b.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17531b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            this.f17531b.onError(th2);
        }

        public void onNext(T t11) {
            this.f17531b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f17532c.replace(disposable);
        }
    }

    public ObservableRepeatUntil(Observable<T> observable, BooleanSupplier booleanSupplier) {
        super(observable);
        this.f17530c = booleanSupplier;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(observer, this.f17530c, sequentialDisposable, this.f16799b).a();
    }
}
