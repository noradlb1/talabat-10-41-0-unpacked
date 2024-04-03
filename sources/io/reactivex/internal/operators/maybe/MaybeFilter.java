package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeFilter<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f16370c;

    public static final class FilterMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16371b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f16372c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16373d;

        public FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.f16371b = maybeObserver;
            this.f16372c = predicate;
        }

        public void dispose() {
            Disposable disposable = this.f16373d;
            this.f16373d = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f16373d.isDisposed();
        }

        public void onComplete() {
            this.f16371b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f16371b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16373d, disposable)) {
                this.f16373d = disposable;
                this.f16371b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                if (this.f16372c.test(t11)) {
                    this.f16371b.onSuccess(t11);
                } else {
                    this.f16371b.onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16371b.onError(th2);
            }
        }
    }

    public MaybeFilter(MaybeSource<T> maybeSource, Predicate<? super T> predicate) {
        super(maybeSource);
        this.f16370c = predicate;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16264b.subscribe(new FilterMaybeObserver(maybeObserver, this.f16370c));
    }
}
