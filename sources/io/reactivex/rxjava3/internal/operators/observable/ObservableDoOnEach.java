package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f21664c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super Throwable> f21665d;

    /* renamed from: e  reason: collision with root package name */
    public final Action f21666e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f21667f;

    public static final class DoOnEachObserver<T> implements Observer<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21668b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f21669c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super Throwable> f21670d;

        /* renamed from: e  reason: collision with root package name */
        public final Action f21671e;

        /* renamed from: f  reason: collision with root package name */
        public final Action f21672f;

        /* renamed from: g  reason: collision with root package name */
        public Disposable f21673g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f21674h;

        public DoOnEachObserver(Observer<? super T> observer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            this.f21668b = observer;
            this.f21669c = consumer;
            this.f21670d = consumer2;
            this.f21671e = action;
            this.f21672f = action2;
        }

        public void dispose() {
            this.f21673g.dispose();
        }

        public boolean isDisposed() {
            return this.f21673g.isDisposed();
        }

        public void onComplete() {
            if (!this.f21674h) {
                try {
                    this.f21671e.run();
                    this.f21674h = true;
                    this.f21668b.onComplete();
                    try {
                        this.f21672f.run();
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
            if (this.f21674h) {
                RxJavaPlugins.onError(th2);
                return;
            }
            this.f21674h = true;
            try {
                this.f21670d.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f21668b.onError(th2);
            try {
                this.f21672f.run();
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(th4);
            }
        }

        public void onNext(T t11) {
            if (!this.f21674h) {
                try {
                    this.f21669c.accept(t11);
                    this.f21668b.onNext(t11);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21673g.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21673g, disposable)) {
                this.f21673g = disposable;
                this.f21668b.onSubscribe(this);
            }
        }
    }

    public ObservableDoOnEach(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.f21664c = consumer;
        this.f21665d = consumer2;
        this.f21666e = action;
        this.f21667f = action2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f21304b.subscribe(new DoOnEachObserver(observer, this.f21664c, this.f21665d, this.f21666e, this.f21667f));
    }
}
