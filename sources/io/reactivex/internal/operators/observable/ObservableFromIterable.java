package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class ObservableFromIterable<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends T> f17262b;

    public static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17263b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<? extends T> f17264c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f17265d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f17266e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f17267f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17268g;

        public FromIterableDisposable(Observer<? super T> observer, Iterator<? extends T> it) {
            this.f17263b = observer;
            this.f17264c = it;
        }

        public void a() {
            while (!isDisposed()) {
                try {
                    this.f17263b.onNext(ObjectHelper.requireNonNull(this.f17264c.next(), "The iterator returned a null value"));
                    if (!isDisposed()) {
                        try {
                            if (!this.f17264c.hasNext()) {
                                if (!isDisposed()) {
                                    this.f17263b.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f17263b.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f17263b.onError(th3);
                    return;
                }
            }
        }

        public void clear() {
            this.f17267f = true;
        }

        public void dispose() {
            this.f17265d = true;
        }

        public boolean isDisposed() {
            return this.f17265d;
        }

        public boolean isEmpty() {
            return this.f17267f;
        }

        @Nullable
        public T poll() {
            if (this.f17267f) {
                return null;
            }
            if (!this.f17268g) {
                this.f17268g = true;
            } else if (!this.f17264c.hasNext()) {
                this.f17267f = true;
                return null;
            }
            return ObjectHelper.requireNonNull(this.f17264c.next(), "The iterator returned a null value");
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            this.f17266e = true;
            return 1;
        }
    }

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.f17262b = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator<? extends T> it = this.f17262b.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete((Observer<?>) observer);
                    return;
                }
                FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it);
                observer.onSubscribe(fromIterableDisposable);
                if (!fromIterableDisposable.f17266e) {
                    fromIterableDisposable.a();
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
