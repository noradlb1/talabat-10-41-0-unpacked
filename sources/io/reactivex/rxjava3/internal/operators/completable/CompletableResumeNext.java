package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableResumeNext extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final CompletableSource f19210b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super Throwable, ? extends CompletableSource> f19211c;

    public static final class ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 5018523762564524046L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f19212b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super Throwable, ? extends CompletableSource> f19213c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f19214d;

        public ResumeNextObserver(CompletableObserver completableObserver, Function<? super Throwable, ? extends CompletableSource> function) {
            this.f19212b = completableObserver;
            this.f19213c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f19212b.onComplete();
        }

        public void onError(Throwable th2) {
            if (this.f19214d) {
                this.f19212b.onError(th2);
                return;
            }
            this.f19214d = true;
            try {
                Object apply = this.f19213c.apply(th2);
                Objects.requireNonNull(apply, "The errorMapper returned a null CompletableSource");
                ((CompletableSource) apply).subscribe(this);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                this.f19212b.onError(new CompositeException(th2, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public CompletableResumeNext(CompletableSource completableSource, Function<? super Throwable, ? extends CompletableSource> function) {
        this.f19210b = completableSource;
        this.f19211c = function;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(completableObserver, this.f19211c);
        completableObserver.onSubscribe(resumeNextObserver);
        this.f19210b.subscribe(resumeNextObserver);
    }
}
