package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeDoAfterSuccess<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f16343c;

    public static final class DoAfterObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16344b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f16345c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16346d;

        public DoAfterObserver(MaybeObserver<? super T> maybeObserver, Consumer<? super T> consumer) {
            this.f16344b = maybeObserver;
            this.f16345c = consumer;
        }

        public void dispose() {
            this.f16346d.dispose();
        }

        public boolean isDisposed() {
            return this.f16346d.isDisposed();
        }

        public void onComplete() {
            this.f16344b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16344b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16346d, disposable)) {
                this.f16346d = disposable;
                this.f16344b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16344b.onSuccess(t11);
            try {
                this.f16345c.accept(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public MaybeDoAfterSuccess(MaybeSource<T> maybeSource, Consumer<? super T> consumer) {
        super(maybeSource);
        this.f16343c = consumer;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new DoAfterObserver(maybeObserver, this.f16343c));
    }
}
