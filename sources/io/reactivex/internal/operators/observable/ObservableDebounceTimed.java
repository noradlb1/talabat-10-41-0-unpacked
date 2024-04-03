package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final long f17074c;

    /* renamed from: d  reason: collision with root package name */
    public final TimeUnit f17075d;

    /* renamed from: e  reason: collision with root package name */
    public final Scheduler f17076e;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;

        /* renamed from: b  reason: collision with root package name */
        public final T f17077b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17078c;

        /* renamed from: d  reason: collision with root package name */
        public final DebounceTimedObserver<T> f17079d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicBoolean f17080e = new AtomicBoolean();

        public DebounceEmitter(T t11, long j11, DebounceTimedObserver<T> debounceTimedObserver) {
            this.f17077b = t11;
            this.f17078c = j11;
            this.f17079d = debounceTimedObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (this.f17080e.compareAndSet(false, true)) {
                this.f17079d.a(this.f17078c, this.f17077b, this);
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17081b;

        /* renamed from: c  reason: collision with root package name */
        public final long f17082c;

        /* renamed from: d  reason: collision with root package name */
        public final TimeUnit f17083d;

        /* renamed from: e  reason: collision with root package name */
        public final Scheduler.Worker f17084e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f17085f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f17086g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f17087h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f17088i;

        public DebounceTimedObserver(Observer<? super T> observer, long j11, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f17081b = observer;
            this.f17082c = j11;
            this.f17083d = timeUnit;
            this.f17084e = worker;
        }

        public void a(long j11, T t11, DebounceEmitter<T> debounceEmitter) {
            if (j11 == this.f17087h) {
                this.f17081b.onNext(t11);
                debounceEmitter.dispose();
            }
        }

        public void dispose() {
            this.f17085f.dispose();
            this.f17084e.dispose();
        }

        public boolean isDisposed() {
            return this.f17084e.isDisposed();
        }

        public void onComplete() {
            if (!this.f17088i) {
                this.f17088i = true;
                Disposable disposable = this.f17086g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.run();
                }
                this.f17081b.onComplete();
                this.f17084e.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17088i) {
                RxJavaPlugins.onError(th2);
                return;
            }
            Disposable disposable = this.f17086g;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f17088i = true;
            this.f17081b.onError(th2);
            this.f17084e.dispose();
        }

        public void onNext(T t11) {
            if (!this.f17088i) {
                long j11 = this.f17087h + 1;
                this.f17087h = j11;
                Disposable disposable = this.f17086g;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t11, j11, this);
                this.f17086g = debounceEmitter;
                debounceEmitter.setResource(this.f17084e.schedule(debounceEmitter, this.f17082c, this.f17083d));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17085f, disposable)) {
                this.f17085f = disposable;
                this.f17081b.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f17074c = j11;
        this.f17075d = timeUnit;
        this.f17076e = scheduler;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f17074c, this.f17075d, this.f17076e.createWorker()));
    }
}
