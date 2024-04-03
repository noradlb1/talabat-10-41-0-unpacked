package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends ObservableSource<? extends T>> f22000c;

    public static final class OnErrorNextObserver<T> implements Observer<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f22001b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends ObservableSource<? extends T>> f22002c;

        /* renamed from: d  reason: collision with root package name */
        public final SequentialDisposable f22003d = new SequentialDisposable();

        /* renamed from: e  reason: collision with root package name */
        public boolean f22004e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22005f;

        public OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
            this.f22001b = observer;
            this.f22002c = function;
        }

        public void onComplete() {
            if (!this.f22005f) {
                this.f22005f = true;
                this.f22004e = true;
                this.f22001b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.f22004e) {
                this.f22004e = true;
                try {
                    ObservableSource observableSource = (ObservableSource) this.f22002c.apply(th2);
                    if (observableSource == null) {
                        NullPointerException nullPointerException = new NullPointerException("Observable is null");
                        nullPointerException.initCause(th2);
                        this.f22001b.onError(nullPointerException);
                        return;
                    }
                    observableSource.subscribe(this);
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    this.f22001b.onError(new CompositeException(th2, th3));
                }
            } else if (this.f22005f) {
                RxJavaPlugins.onError(th2);
            } else {
                this.f22001b.onError(th2);
            }
        }

        public void onNext(T t11) {
            if (!this.f22005f) {
                this.f22001b.onNext(t11);
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.f22003d.replace(disposable);
        }
    }

    public ObservableOnErrorNext(ObservableSource<T> observableSource, Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        super(observableSource);
        this.f22000c = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.f22000c);
        observer.onSubscribe(onErrorNextObserver.f22003d);
        this.f21304b.subscribe(onErrorNextObserver);
    }
}
