package io.reactivex.rxjava3.internal.operators.mixed;

import i.b;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f21260b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f21261c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21262d;

    public static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public static final SwitchMapInnerObserver f21263i = new SwitchMapInnerObserver((SwitchMapCompletableObserver<?>) null);

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f21264b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f21265c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f21266d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f21267e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver> f21268f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f21269g;

        /* renamed from: h  reason: collision with root package name */
        public Disposable f21270h;

        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapCompletableObserver<?> f21271b;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.f21271b = switchMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f21271b.b(this);
            }

            public void onError(Throwable th2) {
                this.f21271b.c(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z11) {
            this.f21264b = completableObserver;
            this.f21265c = function;
            this.f21266d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f21268f;
            SwitchMapInnerObserver switchMapInnerObserver = f21263i;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet != null && andSet != switchMapInnerObserver) {
                andSet.a();
            }
        }

        public void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (b.a(this.f21268f, switchMapInnerObserver, (Object) null) && this.f21269g) {
                this.f21267e.tryTerminateConsumer(this.f21264b);
            }
        }

        public void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th2) {
            if (!b.a(this.f21268f, switchMapInnerObserver, (Object) null)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f21267e.tryAddThrowableOrReport(th2)) {
            } else {
                if (!this.f21266d) {
                    this.f21270h.dispose();
                    a();
                    this.f21267e.tryTerminateConsumer(this.f21264b);
                } else if (this.f21269g) {
                    this.f21267e.tryTerminateConsumer(this.f21264b);
                }
            }
        }

        public void dispose() {
            this.f21270h.dispose();
            a();
            this.f21267e.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f21268f.get() == f21263i;
        }

        public void onComplete() {
            this.f21269g = true;
            if (this.f21268f.get() == null) {
                this.f21267e.tryTerminateConsumer(this.f21264b);
            }
        }

        public void onError(Throwable th2) {
            if (!this.f21267e.tryAddThrowableOrReport(th2)) {
                return;
            }
            if (this.f21266d) {
                onComplete();
                return;
            }
            a();
            this.f21267e.tryTerminateConsumer(this.f21264b);
        }

        public void onNext(T t11) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                Object apply = this.f21265c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f21268f.get();
                    if (switchMapInnerObserver == f21263i) {
                        return;
                    }
                } while (!b.a(this.f21268f, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                completableSource.subscribe(switchMapInnerObserver2);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21270h.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21270h, disposable)) {
                this.f21270h = disposable;
                this.f21264b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, boolean z11) {
        this.f21260b = observable;
        this.f21261c = function;
        this.f21262d = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        if (!ScalarXMapZHelper.a(this.f21260b, this.f21261c, completableObserver)) {
            this.f21260b.subscribe(new SwitchMapCompletableObserver(completableObserver, this.f21261c, this.f21262d));
        }
    }
}
