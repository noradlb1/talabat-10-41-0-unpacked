package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeFilterSingle<T> extends Maybe<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f20885b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f20886c;

    public static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20887b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f20888c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20889d;

        public FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.f20887b = maybeObserver;
            this.f20888c = predicate;
        }

        public void dispose() {
            Disposable disposable = this.f20889d;
            this.f20889d = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f20889d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f20887b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20889d, disposable)) {
                this.f20889d = disposable;
                this.f20887b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                if (this.f20888c.test(t11)) {
                    this.f20887b.onSuccess(t11);
                } else {
                    this.f20887b.onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20887b.onError(th2);
            }
        }
    }

    public MaybeFilterSingle(SingleSource<T> singleSource, Predicate<? super T> predicate) {
        this.f20885b = singleSource;
        this.f20886c = predicate;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20885b.subscribe(new FilterMaybeObserver(maybeObserver, this.f20886c));
    }
}
