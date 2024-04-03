package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeFilterSingle<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f16374b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f16375c;

    public static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f16376b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f16377c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f16378d;

        public FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.f16376b = maybeObserver;
            this.f16377c = predicate;
        }

        public void dispose() {
            Disposable disposable = this.f16378d;
            this.f16378d = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f16378d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f16376b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f16378d, disposable)) {
                this.f16378d = disposable;
                this.f16376b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                if (this.f16377c.test(t11)) {
                    this.f16376b.onSuccess(t11);
                } else {
                    this.f16376b.onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f16376b.onError(th2);
            }
        }
    }

    public MaybeFilterSingle(SingleSource<T> singleSource, Predicate<? super T> predicate) {
        this.f16374b = singleSource;
        this.f16375c = predicate;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f16374b.subscribe(new FilterMaybeObserver(maybeObserver, this.f16375c));
    }
}
