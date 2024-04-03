package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaybeOnErrorComplete<T> extends AbstractMaybeWithUpstream<T, T> {

    /* renamed from: c  reason: collision with root package name */
    public final Predicate<? super Throwable> f20989c;

    public static final class OnErrorCompleteMultiObserver<T> implements MaybeObserver<T>, SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final MaybeObserver<? super T> f20990b;

        /* renamed from: c  reason: collision with root package name */
        public final Predicate<? super Throwable> f20991c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f20992d;

        public OnErrorCompleteMultiObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super Throwable> predicate) {
            this.f20990b = maybeObserver;
            this.f20991c = predicate;
        }

        public void dispose() {
            this.f20992d.dispose();
        }

        public boolean isDisposed() {
            return this.f20992d.isDisposed();
        }

        public void onComplete() {
            this.f20990b.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                if (this.f20991c.test(th2)) {
                    this.f20990b.onComplete();
                } else {
                    this.f20990b.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f20990b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f20992d, disposable)) {
                this.f20992d = disposable;
                this.f20990b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f20990b.onSuccess(t11);
        }
    }

    public MaybeOnErrorComplete(MaybeSource<T> maybeSource, Predicate<? super Throwable> predicate) {
        super(maybeSource);
        this.f20989c = predicate;
    }

    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f20763b.subscribe(new OnErrorCompleteMultiObserver(maybeObserver, this.f20989c));
    }
}
