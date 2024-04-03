package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMapCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f21730c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21731d;

    public static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21732b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicThrowable f21733c = new AtomicThrowable();

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f21734d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f21735e;

        /* renamed from: f  reason: collision with root package name */
        public final CompositeDisposable f21736f = new CompositeDisposable();

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21737g;

        /* renamed from: h  reason: collision with root package name */
        public volatile boolean f21738h;

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
            this.f21732b = observer;
            this.f21734d = function;
            this.f21735e = z11;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.f21736f.delete(innerObserver);
            onComplete();
        }

        public void b(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
            this.f21736f.delete(innerObserver);
            onError(th2);
        }

        public void clear() {
        }

        public void dispose() {
            this.f21738h = true;
            this.f21737g.dispose();
            this.f21736f.dispose();
            this.f21733c.tryTerminateAndReport();
        }

        public boolean isDisposed() {
            return this.f21737g.isDisposed();
        }

        public boolean isEmpty() {
            return true;
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.f21733c.tryTerminateConsumer((Observer<?>) this.f21732b);
            }
        }

        public void onError(Throwable th2) {
            if (!this.f21733c.tryAddThrowableOrReport(th2)) {
                return;
            }
            if (!this.f21735e) {
                this.f21738h = true;
                this.f21737g.dispose();
                this.f21736f.dispose();
                this.f21733c.tryTerminateConsumer((Observer<?>) this.f21732b);
            } else if (decrementAndGet() == 0) {
                this.f21733c.tryTerminateConsumer((Observer<?>) this.f21732b);
            }
        }

        public void onNext(T t11) {
            try {
                Object apply = this.f21734d.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.f21738h && this.f21736f.add(innerObserver)) {
                    completableSource.subscribe(innerObserver);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f21737g.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21737g, disposable)) {
                this.f21737g = disposable;
                this.f21732b.onSubscribe(this);
            }
        }

        @Nullable
        public T poll() {
            return null;
        }

        public int requestFusion(int i11) {
            return i11 & 2;
        }
    }

    public ObservableFlatMapCompletable(ObservableSource<T> observableSource, Function<? super T, ? extends CompletableSource> function, boolean z11) {
        super(observableSource);
        this.f21730c = function;
        this.f21731d = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new FlatMapCompletableMainObserver(observer, this.f21730c, this.f21731d));
    }
}
