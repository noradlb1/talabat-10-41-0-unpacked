package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.operators.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableZip<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T>[] f22552b;

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<? extends T>> f22553c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f22554d;

    /* renamed from: e  reason: collision with root package name */
    public final int f22555e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f22556f;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2983708048395377667L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f22557b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f22558c;

        /* renamed from: d  reason: collision with root package name */
        public final ZipObserver<T, R>[] f22559d;

        /* renamed from: e  reason: collision with root package name */
        public final T[] f22560e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f22561f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f22562g;

        public ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i11, boolean z11) {
            this.f22557b = observer;
            this.f22558c = function;
            this.f22559d = new ZipObserver[i11];
            this.f22560e = new Object[i11];
            this.f22561f = z11;
        }

        public void a() {
            d();
            b();
        }

        public void b() {
            for (ZipObserver<T, R> dispose : this.f22559d) {
                dispose.dispose();
            }
        }

        public boolean c(boolean z11, boolean z12, Observer<? super R> observer, boolean z13, ZipObserver<?, ?> zipObserver) {
            if (this.f22562g) {
                a();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = zipObserver.f22566e;
                    if (th2 != null) {
                        this.f22562g = true;
                        a();
                        observer.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        this.f22562g = true;
                        a();
                        observer.onComplete();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = zipObserver.f22566e;
                    this.f22562g = true;
                    a();
                    if (th3 != null) {
                        observer.onError(th3);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }

        public void d() {
            for (ZipObserver<T, R> zipObserver : this.f22559d) {
                zipObserver.f22564c.clear();
            }
        }

        public void dispose() {
            if (!this.f22562g) {
                this.f22562g = true;
                b();
                if (getAndIncrement() == 0) {
                    d();
                }
            }
        }

        public void drain() {
            Throwable th2;
            boolean z11;
            if (getAndIncrement() == 0) {
                ZipObserver<T, R>[] zipObserverArr = this.f22559d;
                Observer<? super R> observer = this.f22557b;
                T[] tArr = this.f22560e;
                boolean z12 = this.f22561f;
                int i11 = 1;
                while (true) {
                    int i12 = 0;
                    int i13 = 0;
                    for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                        if (tArr[i13] == null) {
                            boolean z13 = zipObserver.f22565d;
                            T poll = zipObserver.f22564c.poll();
                            if (poll == null) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            if (!c(z13, z11, observer, z12, zipObserver)) {
                                if (!z11) {
                                    tArr[i13] = poll;
                                } else {
                                    i12++;
                                }
                            } else {
                                return;
                            }
                        } else if (zipObserver.f22565d && !z12 && (th2 = zipObserver.f22566e) != null) {
                            this.f22562g = true;
                            a();
                            observer.onError(th2);
                            return;
                        }
                        i13++;
                    }
                    if (i12 != 0) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        try {
                            Object apply = this.f22558c.apply(tArr.clone());
                            Objects.requireNonNull(apply, "The zipper returned a null value");
                            observer.onNext(apply);
                            Arrays.fill(tArr, (Object) null);
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            a();
                            observer.onError(th3);
                            return;
                        }
                    }
                }
            }
        }

        public boolean isDisposed() {
            return this.f22562g;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr, int i11) {
            ZipObserver<T, R>[] zipObserverArr = this.f22559d;
            int length = zipObserverArr.length;
            for (int i12 = 0; i12 < length; i12++) {
                zipObserverArr[i12] = new ZipObserver<>(this, i11);
            }
            lazySet(0);
            this.f22557b.onSubscribe(this);
            for (int i13 = 0; i13 < length && !this.f22562g; i13++) {
                observableSourceArr[i13].subscribe(zipObserverArr[i13]);
            }
        }
    }

    public static final class ZipObserver<T, R> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final ZipCoordinator<T, R> f22563b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f22564c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f22565d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f22566e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f22567f = new AtomicReference<>();

        public ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i11) {
            this.f22563b = zipCoordinator;
            this.f22564c = new SpscLinkedArrayQueue<>(i11);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f22567f);
        }

        public void onComplete() {
            this.f22565d = true;
            this.f22563b.drain();
        }

        public void onError(Throwable th2) {
            this.f22566e = th2;
            this.f22565d = true;
            this.f22563b.drain();
        }

        public void onNext(T t11) {
            this.f22564c.offer(t11);
            this.f22563b.drain();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f22567f, disposable);
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f22552b = observableSourceArr;
        this.f22553c = iterable;
        this.f22554d = function;
        this.f22555e = i11;
        this.f22556f = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i11;
        ObservableSource<? extends T>[] observableSourceArr = this.f22552b;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            i11 = 0;
            for (ObservableSource<? extends T> observableSource : this.f22553c) {
                if (i11 == observableSourceArr.length) {
                    ObservableSource<? extends T>[] observableSourceArr2 = new ObservableSource[((i11 >> 2) + i11)];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, i11);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[i11] = observableSource;
                i11++;
            }
        } else {
            i11 = observableSourceArr.length;
        }
        if (i11 == 0) {
            EmptyDisposable.complete((Observer<?>) observer);
        } else {
            new ZipCoordinator(observer, this.f22554d, i11, this.f22556f).subscribe(observableSourceArr, this.f22555e);
        }
    }
}
