package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

public final class ObservableFromIterable<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Iterable<? extends T> f21793b;

    public static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21794b;

        /* renamed from: c  reason: collision with root package name */
        public final Iterator<? extends T> f21795c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f21796d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f21797e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f21798f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f21799g;

        public FromIterableDisposable(Observer<? super T> observer, Iterator<? extends T> it) {
            this.f21794b = observer;
            this.f21795c = it;
        }

        public void a() {
            while (!isDisposed()) {
                try {
                    Object next = this.f21795c.next();
                    Objects.requireNonNull(next, "The iterator returned a null value");
                    this.f21794b.onNext(next);
                    if (!isDisposed()) {
                        try {
                            if (!this.f21795c.hasNext()) {
                                if (!isDisposed()) {
                                    this.f21794b.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            this.f21794b.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f21794b.onError(th3);
                    return;
                }
            }
        }

        public void clear() {
            this.f21798f = true;
        }

        public void dispose() {
            this.f21796d = true;
        }

        public boolean isDisposed() {
            return this.f21796d;
        }

        public boolean isEmpty() {
            return this.f21798f;
        }

        @Nullable
        public T poll() {
            if (this.f21798f) {
                return null;
            }
            if (!this.f21799g) {
                this.f21799g = true;
            } else if (!this.f21795c.hasNext()) {
                this.f21798f = true;
                return null;
            }
            T next = this.f21795c.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            return next;
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            this.f21797e = true;
            return 1;
        }
    }

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.f21793b = iterable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator<? extends T> it = this.f21793b.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete((Observer<?>) observer);
                    return;
                }
                FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it);
                observer.onSubscribe(fromIterableDisposable);
                if (!fromIterableDisposable.f21797e) {
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
