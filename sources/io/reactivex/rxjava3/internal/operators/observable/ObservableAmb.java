package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableAmb<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T>[] f21333b;

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<? extends T>> f21334c;

    public static final class AmbCoordinator<T> implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21335b;

        /* renamed from: c  reason: collision with root package name */
        public final AmbInnerObserver<T>[] f21336c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f21337d = new AtomicInteger();

        public AmbCoordinator(Observer<? super T> observer, int i11) {
            this.f21335b = observer;
            this.f21336c = new AmbInnerObserver[i11];
        }

        public void dispose() {
            if (this.f21337d.get() != -1) {
                this.f21337d.lazySet(-1);
                for (AmbInnerObserver<T> dispose : this.f21336c) {
                    dispose.dispose();
                }
            }
        }

        public boolean isDisposed() {
            return this.f21337d.get() == -1;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f21336c;
            int length = ambInnerObserverArr.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                ambInnerObserverArr[i11] = new AmbInnerObserver<>(this, i12, this.f21335b);
                i11 = i12;
            }
            this.f21337d.lazySet(0);
            this.f21335b.onSubscribe(this);
            for (int i13 = 0; i13 < length && this.f21337d.get() == 0; i13++) {
                observableSourceArr[i13].subscribe(ambInnerObserverArr[i13]);
            }
        }

        public boolean win(int i11) {
            int i12 = 0;
            if (this.f21337d.get() != 0 || !this.f21337d.compareAndSet(0, i11)) {
                return false;
            }
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f21336c;
            int length = ambInnerObserverArr.length;
            while (i12 < length) {
                int i13 = i12 + 1;
                if (i13 != i11) {
                    ambInnerObserverArr[i12].dispose();
                }
                i12 = i13;
            }
            return true;
        }
    }

    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;

        /* renamed from: b  reason: collision with root package name */
        public final AmbCoordinator<T> f21338b;

        /* renamed from: c  reason: collision with root package name */
        public final int f21339c;

        /* renamed from: d  reason: collision with root package name */
        public final Observer<? super T> f21340d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21341e;

        public AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i11, Observer<? super T> observer) {
            this.f21338b = ambCoordinator;
            this.f21339c = i11;
            this.f21340d = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            if (this.f21341e) {
                this.f21340d.onComplete();
            } else if (this.f21338b.win(this.f21339c)) {
                this.f21341e = true;
                this.f21340d.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21341e) {
                this.f21340d.onError(th2);
            } else if (this.f21338b.win(this.f21339c)) {
                this.f21341e = true;
                this.f21340d.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (this.f21341e) {
                this.f21340d.onNext(t11);
            } else if (this.f21338b.win(this.f21339c)) {
                this.f21341e = true;
                this.f21340d.onNext(t11);
            } else {
                ((Disposable) get()).dispose();
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.f21333b = observableSourceArr;
        this.f21334c = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        int i11;
        ObservableSource<? extends T>[] observableSourceArr = this.f21333b;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i11 = 0;
                for (ObservableSource<? extends T> observableSource : this.f21334c) {
                    if (observableSource == null) {
                        EmptyDisposable.error((Throwable) new NullPointerException("One of the sources is null"), (Observer<?>) observer);
                        return;
                    }
                    if (i11 == observableSourceArr.length) {
                        ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i11 >> 2) + i11)];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i11);
                        observableSourceArr = observableSourceArr2;
                    }
                    int i12 = i11 + 1;
                    observableSourceArr[i11] = observableSource;
                    i11 = i12;
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, (Observer<?>) observer);
                return;
            }
        } else {
            i11 = observableSourceArr.length;
        }
        if (i11 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
        } else if (i11 == 1) {
            observableSourceArr[0].subscribe(observer);
        } else {
            new AmbCoordinator(observer, i11).subscribe(observableSourceArr);
        }
    }
}
