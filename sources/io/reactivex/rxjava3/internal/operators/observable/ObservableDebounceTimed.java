package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f21602c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f21603d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f21604e;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;

        /* renamed from: b  reason: collision with root package name */
        public final T f21605b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21606c;

        /* renamed from: d  reason: collision with root package name */
        public final DebounceTimedObserver<T> f21607d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f21608e = new AtomicBoolean();

        public DebounceEmitter(T t11, long j11, DebounceTimedObserver<T> debounceTimedObserver) {
            this.f21605b = t11;
            this.f21606c = j11;
            this.f21607d = debounceTimedObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (this.f21608e.compareAndSet(false, true)) {
                this.f21607d.a(this.f21606c, this.f21605b, this);
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21609b;

        /* renamed from: c  reason: collision with root package name */
        public final long f21610c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f21611d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f21612e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f21613f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21614g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f21615h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f21616i;

        public DebounceTimedObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f21609b = observer;
            this.f21610c = j11;
            this.f21611d = timeUnit;
            this.f21612e = worker;
        }

        public void a(long j11, T t11, DebounceEmitter<T> debounceEmitter) {
            if (j11 == this.f21615h) {
                this.f21609b.onNext(t11);
                debounceEmitter.dispose();
            }
        }

        public void dispose() {
            this.f21613f.dispose();
            this.f21612e.dispose();
        }

        public boolean isDisposed() {
            return this.f21612e.isDisposed();
        }

        public void onComplete() {
            if (!this.f21616i) {
                this.f21616i = true;
                Disposable disposable = this.f21614g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.run();
                }
                this.f21609b.onComplete();
                this.f21612e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21616i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            Disposable disposable = this.f21614g;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f21616i = true;
            this.f21609b.onError(th2);
            this.f21612e.dispose();
        }

        public void onNext(T t11) {
            if (!this.f21616i) {
                long j11 = this.f21615h + 1;
                this.f21615h = j11;
                Disposable disposable = this.f21614g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t11, j11, this);
                this.f21614g = debounceEmitter;
                debounceEmitter.setResource(this.f21612e.schedule(debounceEmitter, this.f21610c, this.f21611d));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21613f, disposable)) {
                this.f21613f = disposable;
                this.f21609b.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f21602c = j11;
        this.f21603d = timeUnit;
        this.f21604e = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f21602c, this.f21603d, this.f21604e.createWorker()));
    }
}
