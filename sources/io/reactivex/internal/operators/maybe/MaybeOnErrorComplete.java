package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeOnErrorComplete<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super Throwable> f16483c;

    public static final class OnErrorCompleteMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16484b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super Throwable> f16485c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16486d;

        public OnErrorCompleteMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super Throwable> predicate) {
            this.f16484b = maybeObserver;
            this.f16485c = predicate;
        }

        public void dispose() {
            this.f16486d.dispose();
        }

        public boolean isDisposed() {
            return this.f16486d.isDisposed();
        }

        public void onComplete() {
            this.f16484b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                if (this.f16485c.test(th2)) {
                    this.f16484b.onComplete();
                } else {
                    this.f16484b.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f16484b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16486d, disposable)) {
                this.f16486d = disposable;
                this.f16484b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f16484b.onSuccess(t11);
        }
    }

    public MaybeOnErrorComplete(MaybeSource<T> maybeSource, Predicate<? super Throwable> predicate) {
        super(maybeSource);
        this.f16483c = predicate;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new OnErrorCompleteMaybeObserver(maybeObserver, this.f16483c));
    }
}
