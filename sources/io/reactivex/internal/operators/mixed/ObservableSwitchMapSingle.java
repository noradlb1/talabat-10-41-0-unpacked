package io.reactivex.internal.operators.mixed;

import i.b;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f16781b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f16782c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f16783d;

    public static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        public static final SwitchMapSingleObserver<Object> f16784j = new SwitchMapSingleObserver<>((SwitchMapSingleMainObserver) null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16785b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f16786c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16787d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f16788e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SwitchMapSingleObserver<R>> f16789f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f16790g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f16791h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f16792i;

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapSingleMainObserver<?, R> f16793b;

            /* renamed from: c  reason: collision with root package name */
            public volatile R f16794c;

            public SwitchMapSingleObserver(SwitchMapSingleMainObserver<?, R> switchMapSingleMainObserver) {
                this.f16793b = switchMapSingleMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onError(Throwable th2) {
                this.f16793b.c(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f16794c = r11;
                this.f16793b.b();
            }
        }

        public SwitchMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
            this.f16785b = observer;
            this.f16786c = function;
            this.f16787d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f16789f;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f16784j;
            SwitchMapSingleObserver<Object> andSet = atomicReference.getAndSet(switchMapSingleObserver);
            if (andSet != null && andSet != switchMapSingleObserver) {
                andSet.a();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f16785b;
                AtomicThrowable atomicThrowable = this.f16788e;
                AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.f16789f;
                int i11 = 1;
                while (!this.f16792i) {
                    if (atomicThrowable.get() == null || this.f16787d) {
                        boolean z12 = this.f16791h;
                        SwitchMapSingleObserver switchMapSingleObserver = atomicReference.get();
                        if (switchMapSingleObserver == null) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z12 && z11) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                observer.onError(terminate);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        } else if (z11 || switchMapSingleObserver.f16794c == null) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            b.a(atomicReference, switchMapSingleObserver, (Object) null);
                            observer.onNext(switchMapSingleObserver.f16794c);
                        }
                    } else {
                        observer.onError(atomicThrowable.terminate());
                        return;
                    }
                }
            }
        }

        public void c(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th2) {
            if (!b.a(this.f16789f, switchMapSingleObserver, (Object) null) || !this.f16788e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f16787d) {
                this.f16790g.dispose();
                a();
            }
            b();
        }

        public void dispose() {
            this.f16792i = true;
            this.f16790g.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f16792i;
        }

        public void onComplete() {
            this.f16791h = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f16788e.addThrowable(th2)) {
                if (!this.f16787d) {
                    a();
                }
                this.f16791h = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            SwitchMapSingleObserver<Object> switchMapSingleObserver;
            SwitchMapSingleObserver switchMapSingleObserver2 = this.f16789f.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.f16786c.apply(t11), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = this.f16789f.get();
                    if (switchMapSingleObserver == f16784j) {
                        return;
                    }
                } while (!b.a(this.f16789f, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.subscribe(switchMapSingleObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16790g.dispose();
                this.f16789f.getAndSet(f16784j);
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16790g, disposable)) {
                this.f16790g = disposable;
                this.f16785b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapSingle(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z11) {
        this.f16781b = observable;
        this.f16782c = function;
        this.f16783d = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.f16781b, this.f16782c, observer)) {
            this.f16781b.subscribe(new SwitchMapSingleMainObserver(observer, this.f16782c, this.f16783d));
        }
    }
}
