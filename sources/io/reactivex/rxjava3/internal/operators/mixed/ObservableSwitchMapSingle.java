package io.reactivex.rxjava3.internal.operators.mixed;

import i.b;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f21286b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f21287c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21288d;

    public static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        public static final SwitchMapSingleObserver<Object> f21289j = new SwitchMapSingleObserver<>((SwitchMapSingleMainObserver) null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21290b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f21291c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21292d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21293e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SwitchMapSingleObserver<R>> f21294f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21295g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f21296h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21297i;

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapSingleMainObserver<?, R> f21298b;

            /* renamed from: c  reason: collision with root package name */
            public volatile R f21299c;

            public SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.f21298b = switchMapSingleMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onError(Throwable th2) {
                this.f21298b.c(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f21299c = r11;
                this.f21298b.b();
            }
        }

        public SwitchMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
            this.f21290b = observer;
            this.f21291c = function;
            this.f21292d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f21294f;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f21289j;
            SwitchMapSingleObserver<Object> andSet = atomicReference.getAndSet(switchMapSingleObserver);
            if (andSet != null && andSet != switchMapSingleObserver) {
                andSet.a();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f21290b;
                AtomicThrowable atomicThrowable = this.f21293e;
                AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f21294f;
                int i11 = 1;
                while (!this.f21297i) {
                    if (atomicThrowable.get() == null || this.f21292d) {
                        boolean z12 = this.f21296h;
                        SwitchMapSingleObserver switchMapSingleObserver = atomicReference.get();
                        if (switchMapSingleObserver == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                            return;
                        } else if (z11 || switchMapSingleObserver.f21299c == null) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            b.a(atomicReference, switchMapSingleObserver, (Object) null);
                            observer.onNext(switchMapSingleObserver.f21299c);
                        }
                    } else {
                        atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                        return;
                    }
                }
            }
        }

        public void c(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th2) {
            if (!b.a(this.f21294f, switchMapSingleObserver, (Object) null)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f21293e.tryAddThrowableOrReport(th2)) {
                if (!this.f21292d) {
                    this.f21295g.dispose();
                    a();
                }
                b();
            }
        }

        public void dispose() {
            this.f21297i = true;
            this.f21295g.dispose();
            a();
            this.f21293e.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f21297i;
        }

        public void onComplete() {
            this.f21296h = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f21293e.tryAddThrowableOrReport(th2)) {
                if (!this.f21292d) {
                    a();
                }
                this.f21296h = true;
                b();
            }
        }

        public void onNext(T t11) {
            SwitchMapSingleObserver<Object> switchMapSingleObserver;
            SwitchMapSingleObserver switchMapSingleObserver2 = this.f21294f.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                Object apply = this.f21291c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.f21294f.get();
                    if (switchMapSingleObserver == f21289j) {
                        return;
                    }
                } while (!b.a(this.f21294f, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.subscribe(switchMapSingleObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21295g.dispose();
                this.f21294f.getAndSet(f21289j);
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21295g, disposable)) {
                this.f21295g = disposable;
                this.f21290b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        this.f21286b = observable;
        this.f21287c = function;
        this.f21288d = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.f21286b, this.f21287c, observer)) {
            this.f21286b.subscribe(new SwitchMapSingleMainObserver(observer, this.f21287c, this.f21288d));
        }
    }
}
