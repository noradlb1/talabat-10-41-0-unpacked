package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeDoOnEvent<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final BiConsumer<? super T, ? super Throwable> f20856c;

    public static final class DoOnEventMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20857b;

        /* renamed from: c  reason: collision with root package name */
        public final BiConsumer<? super T, ? super Throwable> f20858c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20859d;

        public DoOnEventMaybeObserver(MaybeObserver<? super T> maybeObserver, BiConsumer<? super T, ? super Throwable> biConsumer) {
            this.f20857b = maybeObserver;
            this.f20858c = biConsumer;
        }

        public void dispose() {
            this.f20859d.dispose();
            this.f20859d = DisposableHelper.DISPOSED;
        }

        public boolean isDisposed() {
            return this.f20859d.isDisposed();
        }

        public void onComplete() {
            this.f20859d = DisposableHelper.DISPOSED;
            try {
                this.f20858c.accept(null, null);
                this.f20857b.onComplete();
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20857b.onError(th2);
            }
        }

        public void onError(Throwable th2) {
            this.f20859d = DisposableHelper.DISPOSED;
            try {
                this.f20858c.accept(null, th2);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f20857b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20859d, disposable)) {
                this.f20859d = disposable;
                this.f20857b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20859d = DisposableHelper.DISPOSED;
            try {
                this.f20858c.accept(t11, null);
                this.f20857b.onSuccess(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20857b.onError(th2);
            }
        }
    }

    public MaybeDoOnEvent(MaybeSource<T> maybeSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        super(maybeSource);
        this.f20856c = biConsumer;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new DoOnEventMaybeObserver(maybeObserver, this.f20856c));
    }
}
