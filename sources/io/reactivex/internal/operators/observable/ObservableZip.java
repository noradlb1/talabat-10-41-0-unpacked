package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableZip<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<? extends T>[] f18021b;

    /* renamed from: c  reason: collision with root package name */
    public final Iterable<? extends ObservableSource<? extends T>> f18022c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Object[], ? extends R> f18023d;

    /* renamed from: e  reason: collision with root package name */
    public final int f18024e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f18025f;

    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2983708048395377667L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f18026b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Object[], ? extends R> f18027c;

        /* renamed from: d  reason: collision with root package name */
        public final ZipObserver<T, R>[] f18028d;

        /* renamed from: e  reason: collision with root package name */
        public final T[] f18029e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f18030f;

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f18031g;

        public ZipCoordinator(Observer<? super R> observer, Function<? super Object[], ? extends R> function, int i11, boolean z11) {
            this.f18026b = observer;
            this.f18027c = function;
            this.f18028d = new ZipObserver[i11];
            this.f18029e = new Object[i11];
            this.f18030f = z11;
        }

        public void a() {
            d();
            b();
        }

        public void b() {
            for (ZipObserver<T, R> dispose : this.f18028d) {
                dispose.dispose();
            }
        }

        public boolean c(boolean z11, boolean z12, Observer<? super R> observer, boolean z13, ZipObserver<?, ?> zipObserver) {
            if (this.f18031g) {
                a();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = zipObserver.f18035e;
                    if (th2 != null) {
                        this.f18031g = true;
                        a();
                        observer.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        this.f18031g = true;
                        a();
                        observer.onComplete();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = zipObserver.f18035e;
                    this.f18031g = true;
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
            for (ZipObserver<T, R> zipObserver : this.f18028d) {
                zipObserver.f18033c.clear();
            }
        }

        public void dispose() {
            if (!this.f18031g) {
                this.f18031g = true;
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
                ZipObserver<T, R>[] zipObserverArr = this.f18028d;
                Observer<? super R> observer = this.f18026b;
                T[] tArr = this.f18029e;
                boolean z12 = this.f18030f;
                int i11 = 1;
                while (true) {
                    int i12 = 0;
                    int i13 = 0;
                    for (ZipObserver<T, R> zipObserver : zipObserverArr) {
                        if (tArr[i13] == null) {
                            boolean z13 = zipObserver.f18034d;
                            T poll = zipObserver.f18033c.poll();
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
                        } else if (zipObserver.f18034d && !z12 && (th2 = zipObserver.f18035e) != null) {
                            this.f18031g = true;
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
                            observer.onNext(ObjectHelper.requireNonNull(this.f18027c.apply(tArr.clone()), "The zipper returned a null value"));
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
            return this.f18031g;
        }

        public void subscribe(ObservableSource<? extends T>[] observableSourceArr, int i11) {
            ZipObserver<T, R>[] zipObserverArr = this.f18028d;
            int length = zipObserverArr.length;
            for (int i12 = 0; i12 < length; i12++) {
                zipObserverArr[i12] = new ZipObserver<>(this, i11);
            }
            lazySet(0);
            this.f18026b.onSubscribe(this);
            for (int i13 = 0; i13 < length && !this.f18031g; i13++) {
                observableSourceArr[i13].subscribe(zipObserverArr[i13]);
            }
        }
    }

    public static final class ZipObserver<T, R> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final ZipCoordinator<T, R> f18032b;

        /* renamed from: c  reason: collision with root package name */
        public final SpscLinkedArrayQueue<T> f18033c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f18034d;

        /* renamed from: e  reason: collision with root package name */
        public Throwable f18035e;

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Disposable> f18036f = new AtomicReference<>();

        public ZipObserver(ZipCoordinator<T, R> zipCoordinator, int i11) {
            this.f18032b = zipCoordinator;
            this.f18033c = new SpscLinkedArrayQueue<>(i11);
        }

        public void dispose() {
            DisposableHelper.dispose(this.f18036f);
        }

        public void onComplete() {
            this.f18034d = true;
            this.f18032b.drain();
        }

        public void onError(Throwable th2) {
            this.f18035e = th2;
            this.f18034d = true;
            this.f18032b.drain();
        }

        public void onNext(T t11) {
            this.f18033c.offer(t11);
            this.f18032b.drain();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f18036f, disposable);
        }
    }

    public ObservableZip(ObservableSource<? extends T>[] observableSourceArr, Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i11, boolean z11) {
        this.f18021b = observableSourceArr;
        this.f18022c = iterable;
        this.f18023d = function;
        this.f18024e = i11;
        this.f18025f = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        int i11;
        ObservableSource<? extends T>[] observableSourceArr = this.f18021b;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            i11 = 0;
            for (ObservableSource<? extends T> observableSource : this.f18022c) {
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
            new ZipCoordinator(observer, this.f18023d, i11, this.f18025f).subscribe(observableSourceArr, this.f18024e);
        }
    }
}
