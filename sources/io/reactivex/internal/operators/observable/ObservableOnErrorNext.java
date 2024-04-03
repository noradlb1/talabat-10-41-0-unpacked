package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends ObservableSource<? extends T>> f17449c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f17450d;

    public static final class OnErrorNextObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17451b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends ObservableSource<? extends T>> f17452c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f17453d;

        /* renamed from: e  reason: collision with root package name */
        public final SequentialDisposable f17454e = new SequentialDisposable();

        /* renamed from: f  reason: collision with root package name */
        public boolean f17455f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17456g;

        public OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z11) {
            this.f17451b = observer;
            this.f17452c = function;
            this.f17453d = z11;
        }

        public void onComplete() {
            if (!this.f17456g) {
                this.f17456g = true;
                this.f17455f = true;
                this.f17451b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f17455f) {
                this.f17455f = true;
                if (!this.f17453d || (th2 instanceof Exception)) {
                    try {
                        ObservableSource observableSource = (ObservableSource) this.f17452c.apply(th2);
                        if (observableSource == null) {
                            NullPointerException nullPointerException = new NullPointerException("Observable is null");
                            nullPointerException.initCause(th2);
                            this.f17451b.onError(nullPointerException);
                            return;
                        }
                        observableSource.subscribe(this);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.f17451b.onError(new CompositeException(th2, th3));
                    }
                } else {
                    this.f17451b.onError(th2);
                }
            } else if (this.f17456g) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f17451b.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f17456g) {
                this.f17451b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f17454e.replace(disposable);
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean z11) {
        super(observableSource);
        this.f17449c = function;
        this.f17450d = z11;
    }

    public void subscribeActual(Observer<? super T> observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.f17449c, this.f17450d);
        observer.onSubscribe(onErrorNextObserver.f17454e);
        this.f16799b.subscribe(onErrorNextObserver);
    }
}
