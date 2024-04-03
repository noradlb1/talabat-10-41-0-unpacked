package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final BooleanSupplier f22069c;

    public static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22070b;

        /* renamed from: c  reason: collision with root package name */
        public final SequentialDisposable f22071c;

        /* renamed from: d  reason: collision with root package name */
        public final ObservableSource<? extends T> f22072d;

        /* renamed from: e  reason: collision with root package name */
        public final BooleanSupplier f22073e;

        public RepeatUntilObserver(Observer<? super T> observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.f22070b = observer;
            this.f22071c = sequentialDisposable;
            this.f22072d = observableSource;
            this.f22073e = booleanSupplier;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int i11 = 1;
                do {
                    this.f22072d.subscribe(this);
                    i11 = addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        public void onComplete() {
            try {
                if (this.f22073e.getAsBoolean()) {
                    this.f22070b.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22070b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            this.f22070b.onError(th2);
        }

        public void onNext(T t11) {
            this.f22070b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            this.f22071c.replace(disposable);
        }
    }

    public ObservableRepeatUntil(Observable<T> observable, BooleanSupplier booleanSupplier) {
        super(observable);
        this.f22069c = booleanSupplier;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatUntilObserver(observer, this.f22069c, sequentialDisposable, this.f21304b).a();
    }
}
