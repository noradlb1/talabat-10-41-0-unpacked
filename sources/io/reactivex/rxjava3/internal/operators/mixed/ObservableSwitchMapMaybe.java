package io.reactivex.rxjava3.internal.operators.mixed;

import i.b;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f21272b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f21273c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21274d;

    public static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        public static final SwitchMapMaybeObserver<Object> f21275j = new SwitchMapMaybeObserver<>((SwitchMapMaybeMainObserver) null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f21276b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f21277c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21278d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21279e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SwitchMapMaybeObserver<R>> f21280f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21281g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f21282h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f21283i;

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapMaybeMainObserver<?, R> f21284b;

            /* renamed from: c  reason: collision with root package name */
            public volatile R f21285c;

            public SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.f21284b = switchMapMaybeMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21284b.c(this);
            }

            public void onError(Throwable th2) {
                this.f21284b.d(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f21285c = r11;
                this.f21284b.b();
            }
        }

        public SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
            this.f21276b = observer;
            this.f21277c = function;
            this.f21278d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f21280f;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f21275j;
            SwitchMapMaybeObserver<Object> andSet = atomicReference.getAndSet(switchMapMaybeObserver);
            if (andSet != null && andSet != switchMapMaybeObserver) {
                andSet.a();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f21276b;
                AtomicThrowable atomicThrowable = this.f21279e;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f21280f;
                int i11 = 1;
                while (!this.f21283i) {
                    if (atomicThrowable.get() == null || this.f21278d) {
                        boolean z12 = this.f21282h;
                        SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                        if (switchMapMaybeObserver == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                            return;
                        } else if (z11 || switchMapMaybeObserver.f21285c == null) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            b.a(atomicReference, switchMapMaybeObserver, (Object) null);
                            observer.onNext(switchMapMaybeObserver.f21285c);
                        }
                    } else {
                        atomicThrowable.tryTerminateConsumer((Observer<?>) observer);
                        return;
                    }
                }
            }
        }

        public void c(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (b.a(this.f21280f, switchMapMaybeObserver, (Object) null)) {
                b();
            }
        }

        public void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th2) {
            if (!b.a(this.f21280f, switchMapMaybeObserver, (Object) null)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f21279e.tryAddThrowableOrReport(th2)) {
                if (!this.f21278d) {
                    this.f21281g.dispose();
                    a();
                }
                b();
            }
        }

        public void dispose() {
            this.f21283i = true;
            this.f21281g.dispose();
            a();
            this.f21279e.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f21283i;
        }

        public void onComplete() {
            this.f21282h = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f21279e.tryAddThrowableOrReport(th2)) {
                if (!this.f21278d) {
                    a();
                }
                this.f21282h = true;
                b();
            }
        }

        public void onNext(T t11) {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = this.f21280f.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                Object apply = this.f21277c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.f21280f.get();
                    if (switchMapMaybeObserver == f21275j) {
                        return;
                    }
                } while (!b.a(this.f21280f, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.subscribe(switchMapMaybeObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21281g.dispose();
                this.f21280f.getAndSet(f21275j);
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21281g, disposable)) {
                this.f21281g = disposable;
                this.f21276b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        this.f21272b = observable;
        this.f21273c = function;
        this.f21274d = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.b(this.f21272b, this.f21273c, observer)) {
            this.f21272b.subscribe(new SwitchMapMaybeMainObserver(observer, this.f21273c, this.f21274d));
        }
    }
}
