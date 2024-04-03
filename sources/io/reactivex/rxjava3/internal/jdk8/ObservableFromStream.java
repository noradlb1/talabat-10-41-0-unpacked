package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.operators.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.Objects;

public final class ObservableFromStream<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Stream<T> f18933b;

    public static final class StreamDisposable<T> implements QueueDisposable<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f18934b;

        /* renamed from: c  reason: collision with root package name */
        public Iterator<T> f18935c;

        /* renamed from: d  reason: collision with root package name */
        public AutoCloseable f18936d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f18937e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f18938f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f18939g;

        public StreamDisposable(Observer<? super T> observer, Iterator<T> it, AutoCloseable autoCloseable) {
            this.f18934b = observer;
            this.f18935c = it;
            this.f18936d = autoCloseable;
        }

        public void clear() {
            this.f18935c = null;
            AutoCloseable autoCloseable = this.f18936d;
            this.f18936d = null;
            if (autoCloseable != null) {
                ObservableFromStream.a(autoCloseable);
            }
        }

        public void dispose() {
            this.f18937e = true;
            run();
        }

        public boolean isDisposed() {
            return this.f18937e;
        }

        public boolean isEmpty() {
            Iterator<T> it = this.f18935c;
            if (it == null) {
                return true;
            }
            if (!this.f18938f || it.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public boolean offer(@NonNull T t11) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public T poll() {
            Iterator<T> it = this.f18935c;
            if (it == null) {
                return null;
            }
            if (!this.f18938f) {
                this.f18938f = true;
            } else if (!it.hasNext()) {
                clear();
                return null;
            }
            T next = this.f18935c.next();
            Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
            return next;
        }

        public int requestFusion(int i11) {
            if ((i11 & 1) == 0) {
                return 0;
            }
            this.f18939g = true;
            return 1;
        }

        public void run() {
            if (!this.f18939g) {
                Iterator<T> it = this.f18935c;
                Observer<? super T> observer = this.f18934b;
                while (!this.f18937e) {
                    try {
                        T next = it.next();
                        Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                        if (!this.f18937e) {
                            observer.onNext(next);
                            if (!this.f18937e) {
                                try {
                                    if (!it.hasNext()) {
                                        observer.onComplete();
                                        this.f18937e = true;
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    observer.onError(th2);
                                    this.f18937e = true;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        observer.onError(th3);
                        this.f18937e = true;
                    }
                }
                clear();
            }
        }

        public boolean offer(@NonNull T t11, @NonNull T t12) {
            throw new UnsupportedOperationException();
        }
    }

    public ObservableFromStream(Stream<T> stream) {
        this.f18933b = stream;
    }

    public static void a(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(th2);
        }
    }

    public static <T> void subscribeStream(Observer<? super T> observer, Stream<T> stream) {
        try {
            Iterator<T> it = stream.iterator();
            if (!it.hasNext()) {
                EmptyDisposable.complete((Observer<?>) observer);
                a(stream);
                return;
            }
            StreamDisposable streamDisposable = new StreamDisposable(observer, it, stream);
            observer.onSubscribe(streamDisposable);
            streamDisposable.run();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
            a(stream);
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        subscribeStream(observer, this.f18933b);
    }
}
