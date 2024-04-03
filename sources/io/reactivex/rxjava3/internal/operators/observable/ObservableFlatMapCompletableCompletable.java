package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f21740b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f21741c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21742d;

    public static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f21743b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f21744c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f21745d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f21746e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f21747f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21748g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f21749h;

        public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            public InnerObserver() {
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public boolean isDisposed() {
                return DisposableHelper.isDisposed((Disposable) get());
            }

            public void onComplete() {
                FlatMapCompletableMainObserver.this.a(this);
            }

            public void onError(Throwable th2) {
                FlatMapCompletableMainObserver.this.b(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public FlatMapCompletableMainObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z11) {
            this.f21743b = completableObserver;
            this.f21745d = function;
            this.f21746e = z11;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.f21747f.delete(innerObserver);
            onComplete();
        }

        public void b(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
            this.f21747f.delete(innerObserver);
            onError(th2);
        }

        public void dispose() {
            this.f21749h = true;
            this.f21748g.dispose();
            this.f21747f.dispose();
            this.f21744c.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f21748g.isDisposed();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.f21744c.tryTerminateConsumer(this.f21743b);
            }
        }

        public void onError(Throwable th2) {
            if (!this.f21744c.tryAddThrowableOrReport(th2)) {
                return;
            }
            if (!this.f21746e) {
                this.f21749h = true;
                this.f21748g.dispose();
                this.f21747f.dispose();
                this.f21744c.tryTerminateConsumer(this.f21743b);
            } else if (decrementAndGet() == 0) {
                this.f21744c.tryTerminateConsumer(this.f21743b);
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f21745d.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f21749h && this.f21747f.add(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21748g.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21748g, disposable)) {
                this.f21748g = disposable;
                this.f21743b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z11) {
        this.f21740b = observableSource;
        this.f21741c = function;
        this.f21742d = z11;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableFlatMapCompletable(this.f21740b, this.f21741c, this.f21742d));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f21740b.subscribe(new FlatMapCompletableMainObserver(completableObserver, this.f21741c, this.f21742d));
    }
}
