package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17613b;

        /* renamed from: c  reason: collision with root package name */
        public final T f17614c;

        public ScalarDisposable(Observer<? super T> observer, T t11) {
            this.f17613b = observer;
            this.f17614c = t11;
        }

        public void clear() {
            lazySet(3);
        }

        public void dispose() {
            set(3);
        }

        public boolean isDisposed() {
            return get() == 3;
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public boolean offer(T t11) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Nullable
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.f17614c;
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f17613b.onNext(this.f17614c);
                if (get() == 2) {
                    lazySet(3);
                    this.f17613b.onComplete();
                }
            }
        }

        public boolean offer(T t11, T t12) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public static final class ScalarXMapObservable<T, R> extends Observable<R> {

        /* renamed from: b  reason: collision with root package name */
        public final T f17615b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f17616c;

        public ScalarXMapObservable(T t11, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f17615b = t11;
            this.f17616c = function;
        }

        public void subscribeActual(Observer<? super R> observer) {
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.requireNonNull(this.f17616c.apply(this.f17615b), "The mapper returned a null ObservableSource");
                if (observableSource instanceof Callable) {
                    try {
                        Object call = ((Callable) observableSource).call();
                        if (call == null) {
                            EmptyDisposable.complete((Observer<?>) observer);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptyDisposable.error(th2, (Observer<?>) observer);
                    }
                } else {
                    observableSource.subscribe(observer);
                }
            } catch (Throwable th3) {
                EmptyDisposable.error(th3, (Observer<?>) observer);
            }
        }
    }

    private ObservableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Observable<U> scalarXMap(T t11, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        return RxJavaPlugins.onAssembly(new ScalarXMapObservable(t11, function));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(ObservableSource<T> observableSource, Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function) {
        if (!(observableSource instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) observableSource).call();
            if (call == null) {
                EmptyDisposable.complete((Observer<?>) observer);
                return true;
            }
            try {
                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.requireNonNull(function.apply(call), "The mapper returned a null ObservableSource");
                if (observableSource2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) observableSource2).call();
                        if (call2 == null) {
                            EmptyDisposable.complete((Observer<?>) observer);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, call2);
                        observer.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptyDisposable.error(th2, (Observer<?>) observer);
                        return true;
                    }
                } else {
                    observableSource2.subscribe(observer);
                }
                return true;
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptyDisposable.error(th3, (Observer<?>) observer);
                return true;
            }
        } catch (Throwable th4) {
            Exceptions.throwIfFatal(th4);
            EmptyDisposable.error(th4, (Observer<?>) observer);
            return true;
        }
    }
}
