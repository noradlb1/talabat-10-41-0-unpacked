package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeDoOnLifecycle<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super Disposable> f20860c;

    /* renamed from: d  reason: collision with root package name */
    public final Action f20861d;

    public static final class MaybeLifecycleObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20862b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super Disposable> f20863c;

        /* renamed from: d  reason: collision with root package name */
        public final Action f20864d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f20865e;

        public MaybeLifecycleObserver(MaybeObserver<? super T> maybeObserver, Consumer<? super Disposable> consumer, Action action) {
            this.f20862b = maybeObserver;
            this.f20863c = consumer;
            this.f20864d = action;
        }

        public void dispose() {
            try {
                this.f20864d.run();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
            this.f20865e.dispose();
            this.f20865e = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20865e.isDisposed();
        }

        public void onComplete() {
            Disposable disposable = this.f20865e;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f20865e = disposableHelper;
                this.f20862b.onComplete();
            }
        }

        public void onError(@NonNull Throwable th2) {
            Disposable disposable = this.f20865e;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f20865e = disposableHelper;
                this.f20862b.onError(th2);
                return;
            }
            RxJavaPlugins.onError(th2);
        }

        public void onSubscribe(@NonNull Disposable disposable) {
            try {
                this.f20863c.accept(disposable);
                if (DisposableHelper.validate(this.f20865e, disposable)) {
                    this.f20865e = disposable;
                    this.f20862b.onSubscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                disposable.dispose();
                this.f20865e = DisposableHelper.DISPOSED;
                EmptyDisposable.error(th2, (MaybeObserver<?>) this.f20862b);
            }
        }

        public void onSuccess(@NonNull T t11) {
            Disposable disposable = this.f20865e;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.f20865e = disposableHelper;
                this.f20862b.onSuccess(t11);
            }
        }
    }

    public MaybeDoOnLifecycle(Maybe<T> maybe, Consumer<? super Disposable> consumer, Action action) {
        super(maybe);
        this.f20860c = consumer;
        this.f20861d = action;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new MaybeLifecycleObserver(maybeObserver, this.f20860c, this.f20861d));
    }
}
