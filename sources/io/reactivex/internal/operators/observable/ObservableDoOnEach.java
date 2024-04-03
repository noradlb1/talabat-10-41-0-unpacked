package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f17136c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super Throwable> f17137d;

    /* renamed from: e  reason: collision with root package name */
    public final Action f17138e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f17139f;

    public static final class DoOnEachObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17140b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f17141c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super Throwable> f17142d;

        /* renamed from: e  reason: collision with root package name */
        public final Action f17143e;

        /* renamed from: f  reason: collision with root package name */
        public final Action f17144f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f17145g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f17146h;

        public DoOnEachObserver(Observer<? super T> observer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            this.f17140b = observer;
            this.f17141c = consumer;
            this.f17142d = consumer2;
            this.f17143e = action;
            this.f17144f = action2;
        }

        public void dispose() {
            this.f17145g.dispose();
        }

        public boolean isDisposed() {
            return this.f17145g.isDisposed();
        }

        public void onComplete() {
            if (!this.f17146h) {
                try {
                    this.f17143e.run();
                    this.f17146h = true;
                    this.f17140b.onComplete();
                    try {
                        this.f17144f.run();
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        RxJavaPlugins.onError(th2);
                    }
                } catch (Throwable th3) {
                    Exceptions.throwIfFatal(th3);
                    onError(th3);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f17146h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f17146h = true;
            try {
                this.f17142d.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f17140b.onError(th2);
            try {
                this.f17144f.run();
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(th4);
            }
        }

        public void onNext(T t11) {
            if (!this.f17146h) {
                try {
                    this.f17141c.accept(t11);
                    this.f17140b.onNext(t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17145g.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f17145g, disposable)) {
                this.f17145g = disposable;
                this.f17140b.onSubscribe(this);
            }
        }
    }

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.f17136c = consumer;
        this.f17137d = consumer2;
        this.f17138e = action;
        this.f17139f = action2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f16799b.subscribe(new DoOnEachObserver(observer, this.f17136c, this.f17137d, this.f17138e, this.f17139f));
    }
}
