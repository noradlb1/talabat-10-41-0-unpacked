package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableResumeNext extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f14718b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends CompletableSource> f14719c;

    public static final class ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 5018523762564524046L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f14720b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends CompletableSource> f14721c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f14722d;

        public ResumeNextObserver(CompletableObserver completableObserver, Function<? super Throwable, ? extends CompletableSource> function) {
            this.f14720b = completableObserver;
            this.f14721c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f14720b.onComplete();
        }

        public void onError(Throwable th2) {
            if (this.f14722d) {
                this.f14720b.onError(th2);
                return;
            }
            this.f14722d = true;
            try {
                ((CompletableSource) ObjectHelper.requireNonNull(this.f14721c.apply(th2), "The errorMapper returned a null CompletableSource")).subscribe(this);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f14720b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.f14718b = completableSource;
        this.f14719c = function;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(completableObserver, this.f14719c);
        completableObserver.onSubscribe(resumeNextObserver);
        this.f14718b.subscribe(resumeNextObserver);
    }
}
