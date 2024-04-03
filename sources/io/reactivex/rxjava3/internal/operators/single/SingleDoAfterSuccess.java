package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class SingleDoAfterSuccess<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22808b;

    /* renamed from: c  reason: collision with root package name */
    public final Consumer<? super T> f22809c;

    public static final class DoAfterObserver<T> implements SingleObserver<T>, Disposable {

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22810b;

        /* renamed from: c  reason: collision with root package name */
        public final Consumer<? super T> f22811c;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f22812d;

        public DoAfterObserver(SingleObserver<? super T> singleObserver, Consumer<? super T> consumer) {
            this.f22810b = singleObserver;
            this.f22811c = consumer;
        }

        public void dispose() {
            this.f22812d.dispose();
        }

        public boolean isDisposed() {
            return this.f22812d.isDisposed();
        }

        public void onError(Throwable th2) {
            this.f22810b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22812d, disposable)) {
                this.f22812d = disposable;
                this.f22810b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f22810b.onSuccess(t11);
            try {
                this.f22811c.accept(t11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.onError(th2);
            }
        }
    }

    public SingleDoAfterSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f22808b = singleSource;
        this.f22809c = consumer;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22808b.subscribe(new DoAfterObserver(singleObserver, this.f22809c));
    }
}
