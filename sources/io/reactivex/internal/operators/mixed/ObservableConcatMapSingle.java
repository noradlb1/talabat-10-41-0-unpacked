package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapSingle<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f16739b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f16740c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f16741d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16742e;

    public static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16743b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f16744c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicThrowable f16745d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        public final ConcatMapSingleObserver<R> f16746e = new ConcatMapSingleObserver<>(this);

        /* renamed from: f  reason: collision with root package name */
        public final SimplePlainQueue<T> f16747f;

        /* renamed from: g  reason: collision with root package name */
        public final ErrorMode f16748g;

        /* renamed from: h  reason: collision with root package name */
        public Disposable f16749h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f16750i;

        /* renamed from: j  reason: collision with root package name */
        public volatile boolean f16751j;

        /* renamed from: k  reason: collision with root package name */
        public R f16752k;

        /* renamed from: l  reason: collision with root package name */
        public volatile int f16753l;

        public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapSingleMainObserver<?, R> f16754b;

            public ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.f16754b = concatMapSingleMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onError(Throwable th2) {
                this.f16754b.b(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f16754b.c(r11);
            }
        }

        public ConcatMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, int i11, ErrorMode errorMode) {
            this.f16743b = observer;
            this.f16744c = function;
            this.f16748g = errorMode;
            this.f16747f = new SpscLinkedArrayQueue(i11);
        }

        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f16743b;
                ErrorMode errorMode = this.f16748g;
                SimplePlainQueue<T> simplePlainQueue = this.f16747f;
                AtomicThrowable atomicThrowable = this.f16745d;
                int i11 = 1;
                while (true) {
                    if (this.f16751j) {
                        simplePlainQueue.clear();
                        this.f16752k = null;
                    } else {
                        int i12 = this.f16753l;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i12 == 0))) {
                            boolean z11 = false;
                            if (i12 == 0) {
                                boolean z12 = this.f16750i;
                                T poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z11 = true;
                                }
                                if (z12 && z11) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        observer.onComplete();
                                        return;
                                    } else {
                                        observer.onError(terminate);
                                        return;
                                    }
                                } else if (!z11) {
                                    try {
                                        SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.f16744c.apply(poll), "The mapper returned a null SingleSource");
                                        this.f16753l = 1;
                                        singleSource.subscribe(this.f16746e);
                                    } catch (Throwable th2) {
                                        Exceptions.throwIfFatal(th2);
                                        this.f16749h.dispose();
                                        simplePlainQueue.clear();
                                        atomicThrowable.addThrowable(th2);
                                        observer.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i12 == 2) {
                                R r11 = this.f16752k;
                                this.f16752k = null;
                                observer.onNext(r11);
                                this.f16753l = 0;
                            }
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.f16752k = null;
                observer.onError(atomicThrowable.terminate());
            }
        }

        public void b(Throwable th2) {
            if (this.f16745d.addThrowable(th2)) {
                if (this.f16748g != ErrorMode.END) {
                    this.f16749h.dispose();
                }
                this.f16753l = 0;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void c(R r11) {
            this.f16752k = r11;
            this.f16753l = 2;
            a();
        }

        public void dispose() {
            this.f16751j = true;
            this.f16749h.dispose();
            this.f16746e.a();
            if (getAndIncrement() == 0) {
                this.f16747f.clear();
                this.f16752k = null;
            }
        }

        public boolean isDisposed() {
            return this.f16751j;
        }

        public void onComplete() {
            this.f16750i = true;
            a();
        }

        public void onError(Throwable th2) {
            if (this.f16745d.addThrowable(th2)) {
                if (this.f16748g == ErrorMode.IMMEDIATE) {
                    this.f16746e.a();
                }
                this.f16750i = true;
                a();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            this.f16747f.offer(t11);
            a();
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16749h, disposable)) {
                this.f16749h = disposable;
                this.f16743b.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f16739b = observable;
        this.f16740c = function;
        this.f16741d = errorMode;
        this.f16742e = i11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.f16739b, this.f16740c, observer)) {
            this.f16739b.subscribe(new ConcatMapSingleMainObserver(observer, this.f16740c, this.f16742e, this.f16741d));
        }
    }
}
