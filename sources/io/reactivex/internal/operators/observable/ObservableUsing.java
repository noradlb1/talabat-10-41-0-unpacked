package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUsing<T, D> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<? extends D> f17878b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super D, ? extends ObservableSource<? extends T>> f17879c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super D> f17880d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f17881e;

    public static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5904473792286235046L;

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17882b;

        /* renamed from: c  reason: collision with root package name */
        public final D f17883c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super D> f17884d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f17885e;

        /* renamed from: f  reason: collision with root package name */
        public Disposable f17886f;

        public UsingObserver(Observer<? super T> observer, D d11, Consumer<? super D> consumer, boolean z11) {
            this.f17882b = observer;
            this.f17883c = d11;
            this.f17884d = consumer;
            this.f17885e = z11;
        }

        public void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f17884d.accept(this.f17883c);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(th2);
                }
            }
        }

        public void dispose() {
            a();
            this.f17886f.dispose();
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (this.f17885e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f17884d.accept(this.f17883c);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.f17882b.onError(th2);
                        return;
                    }
                }
                this.f17886f.dispose();
                this.f17882b.onComplete();
                return;
            }
            this.f17882b.onComplete();
            this.f17886f.dispose();
            a();
        }

        public void onError(Throwable th2) {
            if (this.f17885e) {
                if (compareAndSet(false, true)) {
                    try {
                        this.f17884d.accept(this.f17883c);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        th2 = new CompositeException(th2, th3);
                    }
                }
                this.f17886f.dispose();
                this.f17882b.onError(th2);
                return;
            }
            this.f17882b.onError(th2);
            this.f17886f.dispose();
            a();
        }

        public void onNext(T t11) {
            this.f17882b.onNext(t11);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17886f, disposable)) {
                this.f17886f = disposable;
                this.f17882b.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z11) {
        this.f17878b = callable;
        this.f17879c = function;
        this.f17880d = consumer;
        this.f17881e = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.f17878b.call();
            try {
                ((ObservableSource) ObjectHelper.requireNonNull(this.f17879c.apply(call), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(observer, call, this.f17880d, this.f17881e));
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptyDisposable.error((Throwable) new CompositeException(th, th2), (Observer<?>) observer);
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptyDisposable.error(th3, (Observer<?>) observer);
        }
    }
}
