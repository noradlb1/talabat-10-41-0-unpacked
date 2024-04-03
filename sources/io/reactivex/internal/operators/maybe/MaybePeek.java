package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f16498c;

    /* renamed from: d  reason: collision with root package name */
    public final Consumer<? super T> f16499d;

    /* renamed from: e  reason: collision with root package name */
    public final Consumer<? super Throwable> f16500e;

    /* renamed from: f  reason: collision with root package name */
    public final Action f16501f;

    /* renamed from: g  reason: collision with root package name */
    public final Action f16502g;

    /* renamed from: h  reason: collision with root package name */
    public final Action f16503h;

    public static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16504b;

        /* renamed from: c  reason: collision with root package name */
        public final MaybePeek<T> f16505c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16506d;

        public MaybePeekObserver(MaybeObserver<? super T> maybeObserver, MaybePeek<T> maybePeek) {
            this.f16504b = maybeObserver;
            this.f16505c = maybePeek;
        }

        public void a() {
            try {
                this.f16505c.f16502g.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }

        public void b(Throwable th2) {
            try {
                this.f16505c.f16500e.accept(th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f16506d = DisposableHelper.DISPOSED;
            this.f16504b.onError(th2);
            a();
        }

        public void dispose() {
            try {
                this.f16505c.f16503h.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f16506d.dispose();
            this.f16506d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16506d.isDisposed();
        }

        public void onComplete() {
            Disposable disposable = this.f16506d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                try {
                    this.f16505c.f16501f.run();
                    this.f16506d = disposableHelper;
                    this.f16504b.onComplete();
                    a();
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    b(th2);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f16506d == DisposableHelper.DISPOSED) {
                RxJavaPlugins.onError(th2);
            } else {
                b(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16506d, disposable)) {
                try {
                    this.f16505c.f16498c.accept(disposable);
                    this.f16506d = disposable;
                    this.f16504b.onSubscribe(this);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    disposable.dispose();
                    this.f16506d = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th2, (MaybeObserver<?>) this.f16504b);
                }
            }
        }

        public void onSuccess(T t11) {
            Disposable disposable = this.f16506d;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                try {
                    this.f16505c.f16499d.accept(t11);
                    this.f16506d = disposableHelper;
                    this.f16504b.onSuccess(t11);
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
        this.f16498c = consumer;
        this.f16499d = consumer2;
        this.f16500e = consumer3;
        this.f16501f = action;
        this.f16502g = action2;
        this.f16503h = action3;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new MaybePeekObserver(maybeObserver, this));
    }
}
