package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f21002c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super T> f21003d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Throwable> f21004e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f21005f;

    /* renamed from: g  reason: collision with root package name */
    public final Action f21006g;

    /* renamed from: h  reason: collision with root package name */
    public final Action f21007h;

    public static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f21008b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybePeek<T> f21009c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f21010d;

        public MaybePeekObserver(MaybeObserver<? super T> maybeObserver, MaybePeek<T> maybePeek) {
            this.f21008b = maybeObserver;
            this.f21009c = maybePeek;
        }

        public void a() {
            try {
                this.f21009c.f21006g.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public void b(Throwable th2) {
            try {
                this.f21009c.f21004e.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f21010d = DisposableHelper.DISPOSED;
            this.f21008b.onError(th2);
            a();
        }

        public void dispose() {
            try {
                this.f21009c.f21007h.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f21010d.dispose();
            this.f21010d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f21010d.isDisposed();
        }

        public void onComplete() {
            Disposable disposable = this.f21010d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                try {
                    this.f21009c.f21005f.run();
                    this.f21010d = disposableHelper;
                    this.f21008b.onComplete();
                    a();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    b(th2);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f21010d == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th2);
            } else {
                b(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f21010d, disposable)) {
                try {
                    this.f21009c.f21002c.accept(disposable);
                    this.f21010d = disposable;
                    this.f21008b.onSubscribe(this);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    disposable.dispose();
                    this.f21010d = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th2, (MaybeObserver<?>) this.f21008b);
                }
            }
        }

        public void onSuccess(T t11) {
            Disposable disposable = this.f21010d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                try {
                    this.f21009c.f21003d.accept(t11);
                    this.f21010d = disposableHelper;
                    this.f21008b.onSuccess(t11);
                    a();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    b(th2);
                }
            }
        }
    }

    public MaybePeek(MaybeSource<T> maybeSource, Consumer<? super Disposable> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Action action3) {
        super(maybeSource);
        this.f21002c = consumer;
        this.f21003d = consumer2;
        this.f21004e = consumer3;
        this.f21005f = action;
        this.f21006g = action2;
        this.f21007h = action3;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new MaybePeekObserver(maybeObserver, this));
    }
}
