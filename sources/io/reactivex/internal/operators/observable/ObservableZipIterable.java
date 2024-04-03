package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

public final class ObservableZipIterable<T, U, V> extends Observable<V> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<? extends T> f18037b;

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<U> f18038c;

    /* renamed from: d  reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends V> f18039d;

    public static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super V> f18040b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<U> f18041c;

        /* renamed from: d  reason: collision with root package name */
        public final BiFunction<? super T, ? super U, ? extends V> f18042d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f18043e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18044f;

        public ZipIterableObserver(Observer<? super V> observer, Iterator<U> it, BiFunction<? super T, ? super U, ? extends V> biFunction) {
            this.f18040b = observer;
            this.f18041c = it;
            this.f18042d = biFunction;
        }

        public void a(Throwable th2) {
            this.f18044f = true;
            this.f18043e.dispose();
            this.f18040b.onError(th2);
        }

        public void dispose() {
            this.f18043e.dispose();
        }

        public boolean isDisposed() {
            return this.f18043e.isDisposed();
        }

        public void onComplete() {
            if (!this.f18044f) {
                this.f18044f = true;
                this.f18040b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f18044f) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f18044f = true;
            this.f18040b.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.f18044f) {
                try {
                    try {
                        this.f18040b.onNext(ObjectHelper.requireNonNull(this.f18042d.apply(t11, ObjectHelper.requireNonNull(this.f18041c.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                        try {
                            if (!this.f18041c.hasNext()) {
                                this.f18044f = true;
                                this.f18043e.dispose();
                                this.f18040b.onComplete();
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
            if (DisposableHelper.validate(this.f18043e, disposable)) {
                this.f18043e = disposable;
                this.f18040b.onSubscribe(this);
            }
        }
    }

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.f18037b = observable;
        this.f18038c = iterable;
        this.f18039d = biFunction;
    }

    public void subscribeActual(Observer<? super V> observer) {
        try {
            Iterator it = (Iterator) ObjectHelper.requireNonNull(this.f18038c.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete((Observer<?>) observer);
                } else {
                    this.f18037b.subscribe(new ZipIterableObserver(observer, it, this.f18039d));
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
