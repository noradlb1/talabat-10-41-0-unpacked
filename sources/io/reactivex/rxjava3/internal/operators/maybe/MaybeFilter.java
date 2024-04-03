package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeFilter<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super T> f20881c;

    public static final class FilterMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20882b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super T> f20883c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20884d;

        public FilterMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super T> predicate) {
            this.f20882b = maybeObserver;
            this.f20883c = predicate;
        }

        public void dispose() {
            Disposable disposable = this.f20884d;
            this.f20884d = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        public boolean isDisposed() {
            return this.f20884d.isDisposed();
        }

        public void onComplete() {
            this.f20882b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20882b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20884d, disposable)) {
                this.f20884d = disposable;
                this.f20882b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                if (this.f20883c.test(t11)) {
                    this.f20882b.onSuccess(t11);
                } else {
                    this.f20882b.onComplete();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f20882b.onError(th2);
            }
        }
    }

    public MaybeFilter(MaybeSource<T> maybeSource, Predicate<? super T> predicate) {
        super(maybeSource);
        this.f20881c = predicate;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new FilterMaybeObserver(maybeObserver, this.f20881c));
    }
}
