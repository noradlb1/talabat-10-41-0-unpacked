package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeDoOnEvent<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final BiConsumer<? super T, ? super Throwable> f16351c;

    public static final class DoOnEventMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16352b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<? super T, ? super Throwable> f16353c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16354d;

        public DoOnEventMaybeObserver(MaybeObserver<? super T> maybeObserver, BiConsumer<? super T, ? super Throwable> biConsumer) {
            this.f16352b = maybeObserver;
            this.f16353c = biConsumer;
        }

        public void dispose() {
            this.f16354d.dispose();
            this.f16354d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f16354d.isDisposed();
        }

        public void onComplete() {
            this.f16354d = DisposableHelper.DISPOSED;
            try {
                this.f16353c.accept(null, null);
                this.f16352b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16352b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            this.f16354d = DisposableHelper.DISPOSED;
            try {
                this.f16353c.accept(null, th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f16352b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16354d, disposable)) {
                this.f16354d = disposable;
                this.f16352b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16354d = DisposableHelper.DISPOSED;
            try {
                this.f16353c.accept(t11, null);
                this.f16352b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16352b.onError(th2);
            }
        }
    }

    public MaybeDoOnEvent(MaybeSource<T> maybeSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        super(maybeSource);
        this.f16351c = biConsumer;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new DoOnEventMaybeObserver(maybeObserver, this.f16351c));
    }
}
