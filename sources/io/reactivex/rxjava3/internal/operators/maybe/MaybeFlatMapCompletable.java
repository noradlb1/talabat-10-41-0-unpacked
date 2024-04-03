package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapCompletable<T> extends Completable {

    /* renamed from: b  reason: collision with root package name */
    public final MaybeSource<T> f20897b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f20898c;

    public static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;

        /* renamed from: b  reason: collision with root package name */
        public final CompletableObserver f20899b;

        /* renamed from: c  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f20900c;

        public FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
            this.f20899b = completableObserver;
            this.f20900c = function;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            this.f20899b.onComplete();
        }

        public void onError(Throwable th2) {
            this.f20899b.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }

        public void onSuccess(T t11) {
            try {
                Object apply = this.f20900c.apply(t11);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                if (!isDisposed()) {
                    completableSource.subscribe(this);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }
    }

    public MaybeFlatMapCompletable(MaybeSource<T> maybeSource, Function<? super T, ? extends CompletableSource> function) {
        this.f20897b = maybeSource;
        this.f20898c = function;
    }

    public void subscribeActual(CompletableObserver completableObserver) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.f20898c);
        completableObserver.onSubscribe(flatMapCompletableObserver);
        this.f20897b.subscribe(flatMapCompletableObserver);
    }
}
