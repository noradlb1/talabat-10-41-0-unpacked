package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleResumeNext<T> extends Single<T> {

    /* renamed from: b  reason: collision with root package name */
    public final SingleSource<? extends T> f18388b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends SingleSource<? extends T>> f18389c;

    public static final class ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5314538511045349925L;

        /* renamed from: b  reason: collision with root package name */
        public final SingleObserver<? super T> f18390b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends SingleSource<? extends T>> f18391c;

        public ResumeMainSingleObserver(SingleObserver<? super T> singleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
            this.f18390b = singleObserver;
            this.f18391c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onError(Throwable th2) {
            try {
                ((SingleSource) ObjectHelper.requireNonNull(this.f18391c.apply(th2), "The nextFunction returned a null SingleSource.")).subscribe(new ResumeSingleObserver(this, this.f18390b));
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f18390b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.f18390b.onSubscribe(this);
            }
        }

        public void onSuccess(T t11) {
            this.f18390b.onSuccess(t11);
        }
    }

    public SingleResumeNext(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.f18388b = singleSource;
        this.f18389c = function;
    }

    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f18388b.subscribe(new ResumeMainSingleObserver(singleObserver, this.f18389c));
    }
}
