package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSource<T> f17213b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f17214c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17215d;

    public static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f17216b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f17217c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f17218d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f17219e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f17220f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f17221g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17222h;

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
            this.f17216b = completableObserver;
            this.f17218d = function;
            this.f17219e = z11;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.f17220f.delete(innerObserver);
            onComplete();
        }

        public void b(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
            this.f17220f.delete(innerObserver);
            onError(th2);
        }

        public void dispose() {
            this.f17222h = true;
            this.f17221g.dispose();
            this.f17220f.dispose();
        }

        public boolean isDisposed() {
            return this.f17221g.isDisposed();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.f17217c.terminate();
                if (terminate != null) {
                    this.f17216b.onError(terminate);
                } else {
                    this.f17216b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.f17217c.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f17219e) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f17216b.onError(this.f17217c.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.f17216b.onError(this.f17217c.terminate());
            }
        }

        public void onNext(T t11) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f17218d.apply(t11), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f17222h && this.f17220f.add(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17221g.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17221g, disposable)) {
                this.f17221g = disposable;
                this.f17216b.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z11) {
        this.f17213b = observableSource;
        this.f17214c = function;
        this.f17215d = z11;
    }

    public Observable<T> fuseToObservable() {
        return RxJavaPlugins.onAssembly(new ObservableFlatMapCompletable(this.f17213b, this.f17214c, this.f17215d));
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        this.f17213b.subscribe(new FlatMapCompletableMainObserver(completableObserver, this.f17214c, this.f17215d));
    }
}
