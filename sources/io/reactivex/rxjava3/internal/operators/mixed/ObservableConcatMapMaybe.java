package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.operators.SimpleQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapMaybe<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f21240b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f21241c;

    /* renamed from: d  reason: collision with root package name */
    public final ErrorMode f21242d;

    /* renamed from: e  reason: collision with root package name */
    public final int f21243e;

    public static final class ConcatMapMaybeMainObserver<T, R> extends ConcatMapXMainObserver<T> {
        private static final long serialVersionUID = -9140123220065488293L;

        /* renamed from: i  reason: collision with root package name */
        public final Observer<? super R> f21244i;

        /* renamed from: j  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f21245j;

        /* renamed from: k  reason: collision with root package name */
        public final ConcatMapMaybeObserver<R> f21246k = new ConcatMapMaybeObserver<>(this);

        /* renamed from: l  reason: collision with root package name */
        public R f21247l;

        /* renamed from: m  reason: collision with root package name */
        public volatile int f21248m;

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* renamed from: b  reason: collision with root package name */
            public final ConcatMapMaybeMainObserver<?, R> f21249b;

            public ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
                this.f21249b = concatMapMaybeMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21249b.e();
            }

            public void onError(Throwable th2) {
                this.f21249b.f(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f21249b.g(r11);
            }
        }

        public ConcatMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, int i11, ErrorMode errorMode) {
            super(i11, errorMode);
            this.f21244i = observer;
            this.f21245j = function;
        }

        public void a() {
            this.f21247l = null;
        }

        public void b() {
            this.f21246k.a();
        }

        public void c() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f21244i;
                ErrorMode errorMode = this.f21109d;
                SimpleQueue<T> simpleQueue = this.f21110e;
                AtomicThrowable atomicThrowable = this.f21107b;
                int i11 = 1;
                while (true) {
                    if (this.f21113h) {
                        simpleQueue.clear();
                        this.f21247l = null;
                    } else {
                        int i12 = this.f21248m;
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
                                            Object apply = this.f21245j.apply(poll);
                                            Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                                            MaybeSource maybeSource = (MaybeSource) apply;
                                            this.f21248m = 1;
                                            maybeSource.subscribe(this.f21246k);
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
                                R r11 = this.f21247l;
                                this.f21247l = null;
                                observer.onNext(r11);
                                this.f21248m = 0;
                            }
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 == 0) {
                        return;
                    }
                }
                simpleQueue.clear();
                this.f21247l = null;
                atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
            }
        }

        public void d() {
            this.f21244i.onSubscribe(this);
        }

        public void e() {
            this.f21248m = 0;
            c();
        }

        public void f(Throwable th2) {
            if (this.f21107b.tryAddThrowableOrReport(th2)) {
                if (this.f21109d != ErrorMode.END) {
                    this.f21111f.dispose();
                }
                this.f21248m = 0;
                c();
            }
        }

        public void g(R r11) {
            this.f21247l = r11;
            this.f21248m = 2;
            c();
        }
    }

    public ObservableConcatMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i11) {
        this.f21240b = observable;
        this.f21241c = function;
        this.f21242d = errorMode;
        this.f21243e = i11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.b(this.f21240b, this.f21241c, observer)) {
            this.f21240b.subscribe(new ConcatMapMaybeMainObserver(observer, this.f21241c, this.f21243e, this.f21242d));
        }
    }
}
