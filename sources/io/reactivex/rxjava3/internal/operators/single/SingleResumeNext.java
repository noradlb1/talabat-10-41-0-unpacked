package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleResumeNext<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f22948b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends SingleSource<? extends T>> f22949c;

    public static final class ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5314538511045349925L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f22950b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends SingleSource<? extends T>> f22951c;

        public ResumeMainSingleObserver(SingleObserver<? super T> singleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
            this.f22950b = singleObserver;
            this.f22951c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            try {
                Object apply = this.f22951c.apply(th2);
                Objects.requireNonNull(apply, "The nextFunction returned a null SingleSource.");
                ((SingleSource) apply).subscribe(new ResumeSingleObserver(this, this.f22950b));
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f22950b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f22950b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f22950b.onSuccess(t11);
        }
    }

    public SingleResumeNext(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.f22948b = singleSource;
        this.f22949c = function;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f22948b.subscribe(new ResumeMainSingleObserver(singleObserver, this.f22949c));
    }
}
