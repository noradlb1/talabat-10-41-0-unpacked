package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;

public final class ObservableZipIterable<T, U, V> extends Observable<V> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<? extends T> f22568b;

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<U> f22569c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends V> f22570d;

    public static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super V> f22571b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<U> f22572c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends V> f22573d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22574e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22575f;

        public ZipIterableObserver(Observer<? super V> observer, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.f22571b = observer;
            this.f22572c = it;
            this.f22573d = biFunction;
        }

        public void a(Throwable th2) {
            this.f22575f = true;
            this.f22574e.dispose();
            this.f22571b.onError(th2);
        }

        public void dispose() {
            this.f22574e.dispose();
        }

        public boolean isDisposed() {
            return this.f22574e.isDisposed();
        }

        public void onComplete() {
            if (!this.f22575f) {
                this.f22575f = true;
                this.f22571b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f22575f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f22575f = true;
            this.f22571b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f22575f) {
                try {
                    U next = this.f22572c.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    try {
                        Object apply = this.f22573d.apply(t11, next);
                        Objects.requireNonNull(apply, "The zipper function returned a null value");
                        this.f22571b.onNext(apply);
                        try {
                            if (!this.f22572c.hasNext()) {
                                this.f22575f = true;
                                this.f22574e.dispose();
                                this.f22571b.onComplete();
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            a(th2);
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        a(th3);
                    }
                } catch (Throwable th4) {
                    Exceptions.throwIfFatal(th4);
                    a(th4);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22574e, disposable)) {
                this.f22574e = disposable;
                this.f22571b.onSubscribe(this);
            }
        }
    }

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.f22568b = observable;
        this.f22569c = iterable;
        this.f22570d = biFunction;
    }

    public void subscribeActual(Observer<? super V> observer) {
        try {
            Iterator<U> it = this.f22569c.iterator();
            Objects.requireNonNull(it, "The iterator returned by other is null");
            Iterator it2 = it;
            try {
                if (!it2.hasNext()) {
                    EmptyDisposable.complete((Observer<?>) observer);
                } else {
                    this.f22568b.subscribe(new ZipIterableObserver(observer, it2, this.f22570d));
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error(th2, (Observer<?>) observer);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, (Observer<?>) observer);
        }
    }
}
