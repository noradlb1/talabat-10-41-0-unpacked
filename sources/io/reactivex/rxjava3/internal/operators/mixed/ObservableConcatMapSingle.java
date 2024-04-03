package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapSingle<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21250b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f21251c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f21252d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21253e;

    public static final class ConcatMapSingleMainObserver<T, R> extends ConcatMapXMainObserver<T> {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: i  reason: collision with root package name */
        public final Observer<? super R> f21254i;

        /* renamed from: j  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f21255j;

        /* renamed from: k  reason: collision with root package name */
        public final ConcatMapSingleObserver<R> f21256k = new ConcatMapSingleObserver<>(this);

        /* renamed from: l  reason: collision with root package name */
        public R f21257l;

        /* renamed from: m  reason: collision with root package name */
        public volatile int f21258m;

        public static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapSingleMainObserver<?, R> f21259b;

            public ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.f21259b = concatMapSingleMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onError(Throwable th2) {
                this.f21259b.e(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f21259b.f(r11);
            }
        }

        public ConcatMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, int i11, ErrorMode errorMode) {
            super(i11, errorMode);
            this.f21254i = observer;
            this.f21255j = function;
        }

        public void a() {
            this.f21257l = null;
        }

        public void b() {
            this.f21256k.a();
        }

        public void c() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f21254i;
                ErrorMode errorMode = this.f21109d;
                SimpleQueue<T> simpleQueue = this.f21110e;
                AtomicThrowable atomicThrowable = this.f21107b;
                int i11 = 1;
                while (true) {
                    if (this.f21113h) {
                        simpleQueue.clear();
                        this.f21257l = null;
                    } else {
                        int i12 = this.f21258m;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i12 == 0))) {
                            boolean z11 = false;
                            if (i12 == 0) {
                                boolean z12 = this.f21112g;
                                try {
                                    T poll = simpleQueue.poll();
                                    if (poll == null) {
                                        z11 = true;
                                    }
                                    if (z12 && z11) {
                                        atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                                        return;
                                    } else if (!z11) {
                                        try {
                                            Object apply = this.f21255j.apply(poll);
                                            Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                                            SingleSource singleSource = (SingleSource) apply;
                                            this.f21258m = 1;
                                            singleSource.subscribe(this.f21256k);
                                        } catch (Throwable th2) {
                                            Exceptions.throwIfFatal(th2);
                                            this.f21111f.dispose();
                                            simpleQueue.clear();
                                            atomicThrowable.tryAddThrowableOrReport(th2);
                                            atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                                            return;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    Exceptions.throwIfFatal(th3);
                                    this.f21113h = true;
                                    this.f21111f.dispose();
                                    atomicThrowable.tryAddThrowableOrReport(th3);
                                    atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                                    return;
                                }
                            } else if (i12 == 2) {
                                R r11 = this.f21257l;
                                this.f21257l = null;
                                observer.onNext(r11);
                                this.f21258m = 0;
                            }
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
                simpleQueue.clear();
                this.f21257l = null;
                atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
            }
        }

        public void d() {
            this.f21254i.onSubscribe(this);
        }

        public void e(Throwable th2) {
            if (this.f21107b.tryAddThrowableOrReport(th2)) {
                if (this.f21109d != ErrorMode.END) {
                    this.f21111f.dispose();
                }
                this.f21258m = 0;
                c();
            }
        }

        public void f(R r11) {
            this.f21257l = r11;
            this.f21258m = 2;
            c();
        }
    }

    public ObservableConcatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f21250b = observableSource;
        this.f21251c = function;
        this.f21252d = errorMode;
        this.f21253e = i11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.f21250b, this.f21251c, observer)) {
            this.f21250b.subscribe(new ConcatMapSingleMainObserver(observer, this.f21251c, this.f21253e, this.f21252d));
        }
    }
}
