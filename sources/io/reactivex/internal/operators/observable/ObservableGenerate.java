package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class ObservableGenerate<T, S> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Callable<S> f17273b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<S, Emitter<T>, S> f17274c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super S> f17275d;

    public ObservableGenerate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f17273b = callable;
        this.f17274c = biFunction;
        this.f17275d = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.f17274c, this.f17275d, this.f17273b.call());
            observer.onSubscribe(generatorDisposable);
            generatorDisposable.run();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }

    public static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f17276b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<S, ? super Emitter<T>, S> f17277c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super S> f17278d;

        /* renamed from: e  reason: collision with root package name */
        public S f17279e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f17280f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f17281g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f17282h;

        public GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s11) {
            this.f17276b = observer;
            this.f17277c = biFunction;
            this.f17278d = consumer;
            this.f17279e = s11;
        }

        private void dispose(S s11) {
            try {
                this.f17278d.accept(s11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public boolean isDisposed() {
            return this.f17280f;
        }

        public void onComplete() {
            if (!this.f17281g) {
                this.f17281g = true;
                this.f17276b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f17281g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f17281g = true;
            this.f17276b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f17281g) {
                return;
            }
            if (this.f17282h) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t11 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f17282h = true;
                this.f17276b.onNext(t11);
            }
        }

        public void run() {
            S s11 = this.f17279e;
            if (this.f17280f) {
                this.f17279e = null;
                dispose(s11);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> biFunction = this.f17277c;
            while (!this.f17280f) {
                this.f17282h = false;
                try {
                    s11 = biFunction.apply(s11, this);
                    if (this.f17281g) {
                        this.f17280f = true;
                        this.f17279e = null;
                        dispose(s11);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f17279e = null;
                    this.f17280f = true;
                    onError(th2);
                    dispose(s11);
                    return;
                }
            }
            this.f17279e = null;
            dispose(s11);
        }

        public void dispose() {
            this.f17280f = true;
        }
    }
}
