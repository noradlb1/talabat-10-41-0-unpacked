package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class ObservableGenerate<T, S> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Supplier<S> f21806b;

    /* renamed from: c  reason: collision with root package name */
    public final BiFunction<S, Emitter<T>, S> f21807c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super S> f21808d;

    public ObservableGenerate(Supplier<S> supplier, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f21806b = supplier;
        this.f21807c = biFunction;
        this.f21808d = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.f21807c, this.f21808d, this.f21806b.get());
            observer.onSubscribe(generatorDisposable);
            generatorDisposable.run();
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }

    public static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final Observer<? super T> f21809b;

        /* renamed from: c  reason: collision with root package name */
        public final BiFunction<S, ? super Emitter<T>, S> f21810c;

        /* renamed from: d  reason: collision with root package name */
        public final Consumer<? super S> f21811d;

        /* renamed from: e  reason: collision with root package name */
        public S f21812e;

        /* renamed from: f  reason: collision with root package name */
        public volatile boolean f21813f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f21814g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f21815h;

        public GeneratorDisposable(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s11) {
            this.f21809b = observer;
            this.f21810c = biFunction;
            this.f21811d = consumer;
            this.f21812e = s11;
        }

        private void dispose(S s11) {
            try {
                this.f21811d.accept(s11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public boolean isDisposed() {
            return this.f21813f;
        }

        public void onComplete() {
            if (!this.f21814g) {
                this.f21814g = true;
                this.f21809b.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f21814g) {
                RxJavaPlugins.onError(th2);
                return;
            }
            if (th2 == null) {
                th2 = ExceptionHelper.createNullPointerException("onError called with a null Throwable.");
            }
            this.f21814g = true;
            this.f21809b.onError(th2);
        }

        public void onNext(T t11) {
            if (this.f21814g) {
                return;
            }
            if (this.f21815h) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t11 == null) {
                onError(ExceptionHelper.createNullPointerException("onNext called with a null value."));
            } else {
                this.f21815h = true;
                this.f21809b.onNext(t11);
            }
        }

        public void run() {
            S s11 = this.f21812e;
            if (this.f21813f) {
                this.f21812e = null;
                dispose(s11);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> biFunction = this.f21810c;
            while (!this.f21813f) {
                this.f21815h = false;
                try {
                    s11 = biFunction.apply(s11, this);
                    if (this.f21814g) {
                        this.f21813f = true;
                        this.f21812e = null;
                        dispose(s11);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.f21812e = null;
                    this.f21813f = true;
                    onError(th2);
                    dispose(s11);
                    return;
                }
            }
            this.f21812e = null;
            dispose(s11);
        }

        public void dispose() {
            this.f21813f = true;
        }
    }
}
