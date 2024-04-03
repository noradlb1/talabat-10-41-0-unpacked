package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f17203c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17204d;

    public static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17205b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f17206c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f17207d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f17208e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f17209f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f17210g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f17211h;

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

        public FlatMapCompletableMainObserver(Observer<? super T> observer, Function<? super T, ? extends CompletableSource> function, boolean z11) {
            this.f17205b = observer;
            this.f17207d = function;
            this.f17208e = z11;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.f17209f.delete(innerObserver);
            onComplete();
        }

        public void b(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
            this.f17209f.delete(innerObserver);
            onError(th2);
        }

        public void clear() {
        }

        public void dispose() {
            this.f17211h = true;
            this.f17210g.dispose();
            this.f17209f.dispose();
        }

        public boolean isDisposed() {
            return this.f17210g.isDisposed();
        }

        public boolean isEmpty() {
            return true;
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.f17206c.terminate();
                if (terminate != null) {
                    this.f17205b.onError(terminate);
                } else {
                    this.f17205b.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.f17206c.addThrowable(th2)) {
                RxJavaPlugins.onError(th2);
            } else if (!this.f17208e) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f17205b.onError(this.f17206c.terminate());
                }
            } else if (decrementAndGet() == 0) {
                this.f17205b.onError(this.f17206c.terminate());
            }
        }

        public void onNext(T t11) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.f17207d.apply(t11), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f17211h && this.f17209f.add(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f17210g.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17210g, disposable)) {
                this.f17210g = disposable;
                this.f17205b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() throws Exception {
            return null;
        }

        public int requestFusion(int i11) {
            return i11 & 2;
        }
    }

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z11) {
        super(observableSource);
        this.f17203c = function;
        this.f17204d = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new FlatMapCompletableMainObserver(observer, this.f17203c, this.f17204d));
    }
}
