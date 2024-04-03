package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapNotification<T, R> extends Single<R> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<T> f22902b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends SingleSource<? extends R>> f22903c;

    /* renamed from: d  reason: collision with root package name */
    public final Function<? super Throwable, ? extends SingleSource<? extends R>> f22904d;

    public static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super R> f22905b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends SingleSource<? extends R>> f22906c;

        /* renamed from: d  reason: collision with root package name */
        public final Function<? super Throwable, ? extends SingleSource<? extends R>> f22907d;

        /* renamed from: e  reason: collision with root package name */
        public Disposable f22908e;

        public final class InnerObserver implements SingleObserver<R> {
            public InnerObserver() {
            }

            public void onError(Throwable th2) {
                FlatMapSingleObserver.this.f22905b.onError(th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(FlatMapSingleObserver.this, disposable);
            }

            public void onSuccess(R r11) {
                FlatMapSingleObserver.this.f22905b.onSuccess(r11);
            }
        }

        public FlatMapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
            this.f22905b = singleObserver;
            this.f22906c = function;
            this.f22907d = function2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
            this.f22908e.dispose();
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f22907d.apply(th2);
                Objects.requireNonNull(apply, "The onErrorMapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                if (!isDisposed()) {
                    singleSource.subscribe(new InnerObserver());
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f22905b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f22908e, disposable)) {
                this.f22908e = disposable;
                this.f22905b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f22906c.apply(t11);
                Objects.requireNonNull(apply, "The onSuccessMapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                if (!isDisposed()) {
                    singleSource.subscribe(new InnerObserver());
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.f22905b.onError(th2);
            }
        }
    }

    public SingleFlatMapNotification(SingleSource<T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
        this.f22902b = singleSource;
        this.f22903c = function;
        this.f22904d = function2;
    }

    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f22902b.subscribe(new FlatMapSingleObserver(singleObserver, this.f22903c, this.f22904d));
    }
}
