package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableAmb<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T>[] f16828b;

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<? extends T>> f16829c;

    public static final class AmbCoordinator<T> implements Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f16830b;

        /* renamed from: c  reason: collision with root package name */
        public final AmbInnerObserver<T>[] f16831c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f16832d = new AtomicInteger();

        public AmbCoordinator(Observer<? super T> observer, int i11) {
            this.f16830b = observer;
            this.f16831c = new AmbInnerObserver[i11];
        }

        public void dispose() {
            if (this.f16832d.get() != -1) {
                this.f16832d.lazySet(-1);
                for (AmbInnerObserver<T> dispose : this.f16831c) {
                    dispose.dispose();
                }
            }
        }

        public boolean isDisposed() {
            return this.f16832d.get() == -1;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f16831c;
            int length = ambInnerObserverArr.length;
            int i11 = 0;
            while (i11 < length) {
                int i12 = i11 + 1;
                ambInnerObserverArr[i11] = new AmbInnerObserver<>(this, i12, this.f16830b);
                i11 = i12;
            }
            this.f16832d.lazySet(0);
            this.f16830b.onSubscribe(this);
            for (int i13 = 0; i13 < length && this.f16832d.get() == 0; i13++) {
                observableSourceArr[i13].subscribe(ambInnerObserverArr[i13]);
            }
        }

        public boolean win(int i11) {
            int i12 = this.f16832d.get();
            int i13 = 0;
            if (i12 == 0) {
                if (!this.f16832d.compareAndSet(0, i11)) {
                    return false;
                }
                AmbInnerObserver<T>[] ambInnerObserverArr = this.f16831c;
                int length = ambInnerObserverArr.length;
                while (i13 < length) {
                    int i14 = i13 + 1;
                    if (i14 != i11) {
                        ambInnerObserverArr[i13].dispose();
                    }
                    i13 = i14;
                }
                return true;
            } else if (i12 == i11) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;

        /* renamed from: b  reason: collision with root package name */
        public final AmbCoordinator<T> f16833b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16834c;

        /* renamed from: d  reason: collision with root package name */
        public final Observer<? super T> f16835d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16836e;

        public AmbInnerObserver(AmbCoordinator<T> ambCoordinator, int i11, Observer<? super T> observer) {
            this.f16833b = ambCoordinator;
            this.f16834c = i11;
            this.f16835d = observer;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            if (this.f16836e) {
                this.f16835d.onComplete();
            } else if (this.f16833b.win(this.f16834c)) {
                this.f16836e = true;
                this.f16835d.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f16836e) {
                this.f16835d.onError(th2);
            } else if (this.f16833b.win(this.f16834c)) {
                this.f16836e = true;
                this.f16835d.onError(th2);
            } else {
                RxJavaPlugins.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (this.f16836e) {
                this.f16835d.onNext(t11);
            } else if (this.f16833b.win(this.f16834c)) {
                this.f16836e = true;
                this.f16835d.onNext(t11);
            } else {
                ((Disposable) get()).dispose();
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public ObservableAmb(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable) {
        this.f16828b = observableSourceArr;
        this.f16829c = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        int i11;
        ObservableSource<? extends T>[] observableSourceArr = this.f16828b;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                i11 = 0;
                for (ObservableSource<? extends T> observableSource : this.f16829c) {
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
