package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22156b;

        /* renamed from: c  reason: collision with root package name */
        public final T f22157c;

        public ScalarDisposable(Observer<? super T> observer, T t11) {
            this.f22156b = observer;
            this.f22157c = t11;
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
        public T poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.f22157c;
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
                this.f22156b.onNext(this.f22157c);
                if (get() == 2) {
                    lazySet(3);
                    this.f22156b.onComplete();
                }
            }
        }

        public boolean offer(T t11, T t12) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    public static final class ScalarXMapObservable<T, R> extends Observable<R> {

        /* renamed from: b  reason: collision with root package name */
        public final T f22158b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f22159c;

        public ScalarXMapObservable(T t11, Function<? super T, ? extends ObservableSource<? extends R>> function) {
            this.f22158b = t11;
            this.f22159c = function;
        }

        public void subscribeActual(Observer<? super R> observer) {
            try {
                Object apply = this.f22159c.apply(this.f22158b);
                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
                if (observableSource instanceof Supplier) {
                    try {
                        Object obj = ((Supplier) observableSource).get();
                        if (obj == null) {
                            EmptyDisposable.complete((Observer<?>) observer);
                            return;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, obj);
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
                Exceptions.throwIfFatal(th3);
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
        if (!(observableSource instanceof Supplier)) {
            return false;
        }
        try {
            Object obj = ((Supplier) observableSource).get();
            if (obj == null) {
                EmptyDisposable.complete((Observer<?>) observer);
                return true;
            }
            try {
                Object apply = function.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                ObservableSource observableSource2 = (ObservableSource) apply;
                if (observableSource2 instanceof Supplier) {
                    try {
                        Object obj2 = ((Supplier) observableSource2).get();
                        if (obj2 == null) {
                            EmptyDisposable.complete((Observer<?>) observer);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, obj2);
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
