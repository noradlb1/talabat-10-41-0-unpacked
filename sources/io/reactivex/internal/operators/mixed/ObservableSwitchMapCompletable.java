package io.reactivex.internal.operators.mixed;

import i.b;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final Observable<T> f16755b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f16756c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f16757d;

    public static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {

        /* renamed from: i  reason: collision with root package name */
        public static final SwitchMapInnerObserver f16758i = new SwitchMapInnerObserver((SwitchMapCompletableObserver<?>) null);

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f16759b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f16760c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f16761d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicThrowable f16762e = new AtomicThrowable();

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver> f16763f = new AtomicReference<>();

        /* renamed from: g  reason: collision with root package name */
        public volatile boolean f16764g;

        /* renamed from: h  reason: collision with root package name */
        public Disposable f16765h;

        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;

            /* renamed from: b  reason: collision with root package name */
            public final SwitchMapCompletableObserver<?> f16766b;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.f16766b = switchMapCompletableObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.f16766b.b(this);
            }

            public void onError(Throwable th2) {
                this.f16766b.c(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z11) {
            this.f16759b = completableObserver;
            this.f16760c = function;
            this.f16761d = z11;
        }

        public void a() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.f16763f;
            SwitchMapInnerObserver switchMapInnerObserver = f16758i;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet != null && andSet != switchMapInnerObserver) {
                andSet.a();
            }
        }

        public void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (b.a(this.f16763f, switchMapInnerObserver, (Object) null) && this.f16764g) {
                Throwable terminate = this.f16762e.terminate();
                if (terminate == null) {
                    this.f16759b.onComplete();
                } else {
                    this.f16759b.onError(terminate);
                }
            }
        }

        public void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th2) {
            if (!b.a(this.f16763f, switchMapInnerObserver, (Object) null) || !this.f16762e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f16761d) {
                dispose();
                Throwable terminate = this.f16762e.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.f16759b.onError(terminate);
                }
            } else if (this.f16764g) {
                this.f16759b.onError(this.f16762e.terminate());
            }
        }

        public void dispose() {
            this.f16765h.dispose();
            a();
        }

        public boolean isDisposed() {
            return this.f16763f.get() == f16758i;
        }

        public void onComplete() {
            this.f16764g = true;
            if (this.f16763f.get() == null) {
                Throwable terminate = this.f16762e.terminate();
                if (terminate == null) {
                    this.f16759b.onComplete();
                } else {
                    this.f16759b.onError(terminate);
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.f16762e.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (this.f16761d) {
                onComplete();
            } else {
                a();
                Throwable terminate = this.f16762e.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.f16759b.onError(terminate);
                }
            }
        }

        public void onNext(T t11) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f16760c.apply(t11), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f16763f.get();
                    if (switchMapInnerObserver == f16758i) {
                        return;
                    }
                } while (!b.a(this.f16763f, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                completableSource.subscribe(switchMapInnerObserver2);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16765h.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16765h, disposable)) {
                this.f16765h = disposable;
                this.f16759b.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, boolean z11) {
        this.f16755b = observable;
        this.f16756c = function;
        this.f16757d = z11;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        if (!ScalarXMapZHelper.a(this.f16755b, this.f16756c, completableObserver)) {
            this.f16755b.subscribe(new SwitchMapCompletableObserver(completableObserver, this.f16756c, this.f16757d));
        }
    }
}
