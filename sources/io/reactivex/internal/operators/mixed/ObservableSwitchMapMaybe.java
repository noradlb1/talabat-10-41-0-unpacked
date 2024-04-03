package io.reactivex.internal.operators.mixed;

import i.b;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f16767b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f16768c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f16769d;

    public static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* renamed from: j  reason: collision with root package name */
        public static final SwitchMapMaybeObserver<Object> f16770j = new SwitchMapMaybeObserver<>((SwitchMapMaybeMainObserver) null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super R> f16771b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends R>> f16772c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16773d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f16774e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SwitchMapMaybeObserver<R>> f16775f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f16776g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f16777h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f16778i;

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapMaybeMainObserver<?, R> f16779b;

            /* renamed from: c  reason: collision with root package name */
            public volatile R f16780c;

            public SwitchMapMaybeObserver(SwitchMapMaybeMainObserver<?, R> switchMapMaybeMainObserver) {
                this.f16779b = switchMapMaybeMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f16779b.c(this);
            }

            public void onError(Throwable th2) {
                this.f16779b.d(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }

            public void onSuccess(R r11) {
                this.f16780c = r11;
                this.f16779b.b();
            }
        }

        public SwitchMapMaybeMainObserver(Observer<? super R> observer, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
            this.f16771b = observer;
            this.f16772c = function;
            this.f16773d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f16775f;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f16770j;
            SwitchMapMaybeObserver<Object> andSet = atomicReference.getAndSet(switchMapMaybeObserver);
            if (andSet != null && andSet != switchMapMaybeObserver) {
                andSet.a();
            }
        }

        public void b() {
            boolean z11;
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.f16771b;
                AtomicThrowable atomicThrowable = this.f16774e;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.f16775f;
                int i11 = 1;
                while (!this.f16778i) {
                    if (atomicThrowable.get() == null || this.f16773d) {
                        boolean z12 = this.f16777h;
                        SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                        if (switchMapMaybeObserver == null) {
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
                        } else if (z11 || switchMapMaybeObserver.f16780c == null) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            b.a(atomicReference, switchMapMaybeObserver, (Object) null);
                            observer.onNext(switchMapMaybeObserver.f16780c);
                        }
                    } else {
                        observer.onError(atomicThrowable.terminate());
                        return;
                    }
                }
            }
        }

        public void c(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (b.a(this.f16775f, switchMapMaybeObserver, (Object) null)) {
                b();
            }
        }

        public void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th2) {
            if (!b.a(this.f16775f, switchMapMaybeObserver, (Object) null) || !this.f16774e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (!this.f16773d) {
                this.f16776g.dispose();
                a();
            }
            b();
        }

        public void dispose() {
            this.f16778i = true;
            this.f16776g.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f16778i;
        }

        public void onComplete() {
            this.f16777h = true;
            b();
        }

        public void onError(Throwable th2) {
            if (this.f16774e.addThrowable(th2)) {
                if (!this.f16773d) {
                    a();
                }
                this.f16777h = true;
                b();
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onNext(T t11) {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = this.f16775f.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.f16772c.apply(t11), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.f16775f.get();
                    if (switchMapMaybeObserver == f16770j) {
                        return;
                    }
                } while (!b.a(this.f16775f, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.subscribe(switchMapMaybeObserver3);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16776g.dispose();
                this.f16775f.getAndSet(f16770j);
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16776g, disposable)) {
                this.f16776g = disposable;
                this.f16771b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapMaybe(Observable<T> observable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z11) {
        this.f16767b = observable;
        this.f16768c = function;
        this.f16769d = z11;
    }

    public void subscribeActual(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.b(this.f16767b, this.f16768c, observer)) {
            this.f16767b.subscribe(new SwitchMapMaybeMainObserver(observer, this.f16768c, this.f16769d));
        }
    }
}
